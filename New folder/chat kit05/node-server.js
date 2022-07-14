/*jshint esversion: 6 */

// console.log('step 1. start node http server');
// const http = require('http');
// const server = http.createServer();
// server.on('request', function(request, response){
//     response.write('Hello Node');
//     response.end();
// });
// server.on('close', function(request, response){});
// server.listen(3000);
// console.log('start node server at http://localhost:3000');
    
// console.log('step 2. handle request URL');
// const http = require('http');
// const server = http.createServer();
// server.on('request', function(request, response){
//     let url = request.url;
//     let query = null;
//     if(request.url.indexOf('?') > -1){
//         const a = request.url.split('?');
//         url = a[0];
//         query = a[1];
//     }
//     response.writeHead(200, {'Content-Type': 'text/html'});
//     // response.setHeader('Content-Type', 'text/html');
//     response.write(request.method+'/ '+request.url+'<br/>');
//     response.write(url+'? '+query+'<br/>');
//     response.end();
// });
// server.on('close', function(request, response){});
// server.listen(3000);
// console.log('start node server at http://localhost:3000');


// console.log('step 3. handle file URL');
// const fs = require('fs');
// const http = require('http');
// const server = http.createServer();
// server.on('request', function(request, response){
//     let url = request.url;
//     let query = null;
//     if(request.url.indexOf('?') > -1){
//         const a = request.url.split('?');
//         url = a[0];
//         query = a[1];
//     }

//     if(url == '/'){
//         const data = fs.readFileSync('./index.html','utf8');
//         response.writeHead(200, {'Content-Type': 'text/html'});
//         response.end(data);
//     }else if(url.endsWith('.html')){
//         const data = fs.readFileSync('.'+url,'utf8');
//         response.writeHead(200, {'Content-Type': 'text/html'});
//         response.end(data);
//     }

// });
// server.on('close', function(request, response){});
// server.listen(3000);
// console.log('start node server at http://localhost:3000');

console.log('step 4. handle file URL');
const fs = require('fs');
const http = require('http');
const server = http.createServer();
const members = [];
server.on('request', function(request, response){
    let url = request.url;
    let query = null;
    if(request.url.indexOf('?') > -1){
        const a = request.url.split('?');
        url = a[0];
        query = a[1];
    }

    if(url == '/'){
        const data = fs.readFileSync('./index.html','utf8');
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.end(data);
    }else if(url.endsWith('.html')){
        const data = fs.readFileSync('.'+url,'utf8');
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.end(data);
    }else if(url == '/enter'){
        const a = query.split('&');
        let param = {};
        a.forEach(function(arg){
            const b = arg.split('=');
            param[b[0]] = b[1];
        });
        console.log('enter - ', param);
        members.push(param);
        console.log('members - ', members);

        let cookies = [];
        cookies.push(encodeURIComponent('userid') + '=' + encodeURIComponent(param.nickname));

        const data = fs.readFileSync('./room.html','utf8');
        response.writeHead(200, {'Content-Type': 'text/html','Set-Cookie': cookies});
        response.end(data);
        // response.writeHead(302, {'Location': '/room.html','Set-Cookie': cookies});
    }

});
server.on('close', function(request, response){});
server.listen(3000);
console.log('start node server at http://localhost:3000');