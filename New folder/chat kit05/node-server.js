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