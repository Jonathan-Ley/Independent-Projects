class Server {
  private port: number;
  private address: string;

  constructor(port: number, address: string) {
    this.port = port;
    this.address = address;
  }

  startServer() {
    console.log(`Starting server at ${this.address} on port ${this.port}`);
  }
}

const someServer = new Server(8080, "localhost3000");
someServer.startServer();
//can use any as a way to access private variables of a class
const port1 = (someServer as any).port;
console.log(port1);
//using interfaces promotes loose coupling & inheritance creates tight coupling
