class Server {
    constructor(port, address) {
        this.port = port;
        this.address = address;
    }
    startServer() {
        console.log(`Starting server at ${this.address} on port ${this.port}`);
    }
}
const someServer = new Server(8080, "localhost3000");
someServer.startServer();
