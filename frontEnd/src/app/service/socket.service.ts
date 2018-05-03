import {Injectable} from '@angular/core';

@Injectable()
export class SocketService {
  private socket;

  public initSocket(): void {
    this.socket = new WebSocket('ws://localhost:8080');

    this.socket.onopen = function () {
      console.log("open"); // Send the message 'Ping' to the server
    };

    this.socket.onclose = function () {
      console.log("close");
    };

    this.socket.onmessage = function (message) {
      console.log(message.data);
      if (message.data.type == "end") {
        console.log("ez life");
      }
    };

    // Log errors
    this.socket.onerror = function (error) {
      console.log('WebSocket Error ' + error);
    };

  }

  public send(message): void {
    this.socket.send(JSON.stringify(message));
  }
}
