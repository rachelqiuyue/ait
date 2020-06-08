const net = require('net');
const [HOST, PORT] = ['127.0.0.1', 8080];

class Request{
    
}

// // create a server
// // when a client connects call the callback function provided (the arrow 
// // function that takes a socket as an argument)
const server = net.createServer((sock) => {

    // do this stuff when a client connects:
    
    // show the connected client's ip address and port
    console.log(sock.remoteAddress, sock.remotePort);

    // when the connected client sends us data...
    sock.on('data', (binaryData) => {

        // convert buffer object to string, and use request object
        // to parse http request string into actual object
        // with the request object's path, find the right function to 
        // handle the path (or 404 if we don't handle that path)
        // if(routes.hasOwnProperty(req.path)) {
        //     const requestHandler = routes[req.path];
        //     requestHandler(sock);
        // } else {
        //     sock.write(createResponse(404, 'this is a 404!'));
        // }
        sock.write("HTTP/1.1 200 OK\r\nContent-type: text/html\r\n\r\n<em>Hello</em> <strong>World</strong>");

        // close the connection the client
        sock.end();
    });
});

