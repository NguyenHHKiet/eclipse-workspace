/*jshint esversion: 6 */

// // step 5. use URL parser
// const fs = require('fs');
// const urlm = require('url');
// const http = require('http');
// const server = http.createServer();
// const members = [];
// server.on('request', function(request, response){
//     // let url = request.url;
//     // let query = null;
//     // if(request.url.indexOf('?') > -1){
//     //     const a = request.url.split('?');
//     //     url = a[0];
//     //     query = a[1];
//     // }
//     const parsedUrl = urlm.parse(request.url, true);
//     let url = parsedUrl.pathname;
//     let query = parsedUrl.query;
//     console.log('path :', parsedUrl.path);// equals request.url
//     console.log('pathname :', parsedUrl.pathname);
//     console.log('query :', parsedUrl.query);

//     if(url == '/'){
//         const data = fs.readFileSync('./index.html','utf8');
//         response.writeHead(200, {'Content-Type': 'text/html'});
//         response.end(data);
//     }else if(url.endsWith('.html')){
//         const data = fs.readFileSync('.'+url,'utf8');
//         response.writeHead(200, {'Content-Type': 'text/html'});
//         response.end(data);
//     }else if(url == '/enter'){
//         // const a = query.split('&');
//         let param = {userid:query.nickname};
//         // a.forEach(function(arg){
//         //     const b = arg.split('=');
//         //     param[b[0]] = b[1];
//         // });
//         console.log('enter - ', param);
//         members.push(param);
//         console.log('members - ', members);

//         let cookies = [];
//         cookies.push(encodeURIComponent('userid') + '=' + encodeURIComponent(param.nickname));

//         const data = fs.readFileSync('./room.html','utf8');
//         response.writeHead(200, {'Content-Type': 'text/html','Set-Cookie': cookies});
//         response.end(data);
//         // response.writeHead(302, {'Location': '/flex-room.html','Set-Cookie': cookies});
//     }

// });
// server.on('close', function(request, response){});
// server.listen(3000);
// console.log('start node server at http://localhost:3000');

// // step 6. use AJAX - removed comments
// const fs = require('fs');
// const urlm = require('url');
// const http = require('http');
// const server = http.createServer();
// const members = [];
// server.on('request', function(request, response){
//     const parsedUrl = urlm.parse(request.url, true);
//     let url = parsedUrl.pathname;
//     let query = parsedUrl.query;
//     console.log('path :', parsedUrl.path);// equals request.url
//     console.log('pathname :', parsedUrl.pathname);
//     console.log('query :', parsedUrl.query);

//     if(url == '/'){
//         const data = fs.readFileSync('./index.html','utf8');
//         response.writeHead(200, {'Content-Type': 'text/html'});
//         response.end(data);
//     }else if(url.endsWith('.html')){
//         const data = fs.readFileSync('.'+url,'utf8');
//         response.writeHead(200, {'Content-Type': 'text/html'});
//         response.end(data);
//     }else if(url == '/enter'){
//         let param = { nickname : query.nickname};
//         console.log('enter - ', param);
//         members.push(param);
//         console.log('members - ', members);

//         let cookies = [];
//         cookies.push(encodeURIComponent('userid') + '=' + encodeURIComponent(param.nickname));

//         const data = fs.readFileSync('./room.html','utf8');
//         response.writeHead(200, {'Content-Type': 'text/html','Set-Cookie': cookies});
//         response.end(data);
//         // response.writeHead(302, {'Location': '/room.html','Set-Cookie': cookies});

//     }else if(url == '/api/nicklist'){
//         // 현재 접속자들의 대화명 목록을 응답
//         response.writeHead(200, {'Content-Type': 'application/json'});
//         let data = JSON.stringify(members);
//         console.log(data);
//         response.end(data);

//     }

// });// server.on
// server.on('close', function(request, response){});
// server.listen(3000);
// console.log('start node server at http://localhost:3000');

// step 7. use Map
const fs = require('fs');
const urlm = require('url');
const http = require('http');
const server = http.createServer();

const members = new Map();

server.on('request', function (request, response) {
    const parsedUrl = urlm.parse(request.url, true);
    console.log('-->', parsedUrl);
    let url = parsedUrl.pathname;
    let query = parsedUrl.query;

    if (url == '/') {
        const data = fs.readFileSync('./index.html', 'utf8');
        response.writeHead(200, {
            'Content-Type': 'text/html'
        });
        response.end(data);
    } else if (url.endsWith('.html')) {
        const data = fs.readFileSync('.' + url, 'utf8');
        response.writeHead(200, {
            'Content-Type': 'text/html'
        });
        response.end(data);
    } else if (url == '/enter') {
        // 접속자 정보 객체
        let param = {
            nickname: query.nickname
        };
        console.log('enter - ', param);
        // members.push(param); is Array
        members.set(query.nickname, param);
        // console.log('members - ', members);

        let cookies = [];
        cookies.push(encodeURIComponent('userid') + '=' + encodeURIComponent(param.nickname));

        const data = fs.readFileSync('./room.html', 'utf8');
        response.writeHead(200, {
            'Content-Type': 'text/html',
            'Set-Cookie': cookies
        });
        response.end(data);

    } else if (url == '/api/nicklist') {
        // 현재 접속자들의 대화명 목록을 응답 by Ajax
        response.writeHead(200, {
            'Content-Type': 'application/json'
        });
        // 접속자들의 nickname 만 필요하다면 map 의 key 만 배열로 복사
        // Array.from( members.keys() );
        // [ ...members.keys() ];   //전개연산 instead of forEach
        // [ ...members.enrties() ];
        const list = [...members.values()];
        let data = JSON.stringify(list);
        console.log(data);
        response.end(data);

    }

}); // server.on
server.on('close', function (request, response) {});
server.listen(3000);
console.log('start node server at http://localhost:3000');

// // step 8. Socket client
// const url = 'ws://demo.piesocket.com/';
// const params = 'v3/channel_1?api_key=oCdCMcMPQpbvNjUIzqtvF1d2X2okWpDQj4AwARJuAgtjhzKxVEjQU6IdCjwm&notify_self';

// const WebSocketClient = require('websocket').client;
// const client = new WebSocketClient();
// client.connect(url+params);
// console.log('connected nodsocket server at demo.piescoket.com (Thanks piesocket)');
// let connection;
// client.on('connectFailed', function(error) {
//     console.log('Connect Error: ' + error.toString());
// });

// client.on('connect', function(socket) {
//     console.log('WebSocket Client Connected');
//     connection = socket;
//     socket.on('error', function(error) {
//         console.log("Connection Error: " + error.toString());
//     });
//     socket.on('close', function() {
//         console.log('Connection Closed');
//     });
//     socket.on('message', function(message) {
//         if (message.type === 'utf8') {
//             console.log("Received: '" + message.utf8Data + "'");
//         }
//     });
// });

// step 9 : websocket server
// let connection;
// var WebSocketServer = require("websocket").server;
// var wss = new WebSocketServer({ 
//     httpServer: server,
//     autoAcceptConnections: true
// });
// console.log('start websocket server at ws://localhost:3000');
// // 연결이 수립되면 클라이언트에 메시지를 전송하고 클라이언트로부터의 메시지를 수신한다
// wss.on("connection", function(ws) {
//     connection = ws;
//     console.log("Connected:", connection);
//     ws.send("Hello! I am a server.");
//     ws.on("message", function(message) {
//         console.log("Received: %s", message);
//     });
// });
// wss.on("connectionFailed", function(error) {
//     console.log('Connect Error: ' + error.toString());
// });

// step 10 : websocket server
let connection = [];
const WebSocketServer = require("ws").Server;
const wss = new WebSocketServer({
    port: 3030
});
console.log('start websocket server at ws://localhost:3030');
// 연결이 수립되면 클라이언트에 메시지를 전송하고 클라이언트로부터의 메시지를 수신한다
wss.on("connection", function (ws) {
    console.log("Connected: ");
    connection.push(ws);
    // 지금 접속된 client 에게 보낸다
    ws.send('{"message" : "Hello! I am a server" }');
});
wss.on("connectionFailed", function (error) {
    console.log('Connect Error: ' + error.toString());
});
wss.on('message', function (data) {
    for (var client of connection) {
        client.send(data);
    }
});

////////////////////////////////////////////////////////////////////////
const { Server } = require("socket.io");
const io = new Server(server);

server.listen(3030, () => {
    console.log('Server listening *: 3030');
})
