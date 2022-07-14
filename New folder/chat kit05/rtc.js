/*jshint esversion: 6 */

let localVideo = document.getElementById("localVideo");
let remoteVideo = document.getElementById("remoteVideo");
let isInitiator = false;
let isChannelReady = false;
let isStarted = false;
let localStream;
let remoteStream;
let pc; // RTCPeerConnection 객체

// thanks google, STUN server
let pcConfig = {
    'iceServers': [{
        'urls': 'stun:stun.l.google.com:19302'
    }]
};

// .getUserMedia() : 사용자의 웹캠(video), 마이크(audio) 등의 미디어 접근
// .then gotStream 을 이어서 실행
// .catch 에러 나면 실행
navigator.mediaDevices
    .getUserMedia({
        video: true,
        audio: true,
    })
    .then(gotStream)
    .catch((error) => console.error(error));

function gotStream(stream) {
    console.log("Adding local stream");
    // 미디어 data 를 받는 stream
    localStream = stream;
    // 자신의 웹캠 영상 #localVideo 요소에 보여준다.
    localVideo.srcObject = stream;
    // socket 서버로 메세지 전송
    const message = "got user media";
    console.log('Client sending message: ', message);
    // socket 은 자신과 socket server 간 연결된 socket
    socket.emit('message', message);

    if (isInitiator) {
        maybeStart();
    }
}

//  maybeStart() 
//  자신의 RTCPeerConnection 을 초기화하고 상대방의 RTCPeerConnection 과 연결하는 함수이다.
//      주의할 것은 상대방이 여러 명이라는 것이다.
function maybeStart() {
    console.log(">>MaybeStart() : ", isStarted, localStream, isChannelReady);
    if (!isStarted && typeof localStream !== "undefined" && isChannelReady) {
        console.log(">>>>> creating peer connection");
        createPeerConnection();
        pc.addStream(localStream);
        isStarted = true;
        console.log("isInitiator : ", isInitiator);
        if (isInitiator) {
            doCall();
        }
    } else {
        console.error('maybeStart not Started!');
    }
}

//    createPeerConnection() 을 통해 RTCPeerConnection 에 대한 객체를 형성해주고 있다.
function createPeerConnection() {
    try {
        pc = new RTCPeerConnection(null);
        pc.onicecandidate = handleIceCandidate;
        pc.onaddstream = handleRemoteStreamAdded;
        console.log("Created RTCPeerConnection");
    } catch (e) {
        console.err("connot create RTCPeerConnection object", e);
        return;
    }
}

// iceCandidate 는 데이터 교환을 할 대상의 EndPoint 정보.
// 따라서 iceCandidate할 대상이 생긴다면 handleIceCandidate Method를 실행하게 된다.
// 이 부분은 signaling 서버로 넘겨줘 상대방 Peer가 내 Stream을 연결할 수 있도록 한다.
function handleIceCandidate(event) {
    console.log("iceCandidateEvent", event);
    if (event.candidate) {
        const message = {
            type: "candidate",
            label: event.candidate.sdpMLineIndex,
            id: event.candidate.sdpMid,
            candidate: event.candidate.candidate,
        };
        console.log('Client sending message: ', message);
        socket.emit('message', message);
    } else {
        console.log("end of candidates");
    }
}

function handleCreateOfferError(event) {
    console.log("createOffer() error: ", event);
}

//연결된 Peer는 handleRemoteStreamAdded Method를 통해서 remoteVideo 뷰에 띄우도록 한다.
function handleRemoteStreamAdded(event) {
    console.log("remote stream added");
    remoteStream = event.stream;
    remoteVideo.srcObject = remoteStream;
}

//  doCall과 doAnswer를 통해서 Description을 교환하고 
//  이 과정을 통해서 내 화상 정보가 상대방에게, 상대방의 화상정보가 내 뷰에 출력할 수 있게 되는 것이다.
function doCall() {
    console.log("Sending offer to peer");
    pc.createOffer(setLocalAndSendMessage, handleCreateOfferError);
}

function doAnswer() {
    console.log("Sending answer to peer");
    pc.createAnswer().then(
        setLocalAndSendMessage,
        onCreateSessionDescriptionError
    );
}

function setLocalAndSendMessage(sessionDescription) {
    pc.setLocalDescription(sessionDescription);
    const message = sessionDescription;
    console.log('Client sending message: ', message);
    socket.emit('message', message);
}

function onCreateSessionDescriptionError(error) {
    console.error("Falied to create session Description", error);
}