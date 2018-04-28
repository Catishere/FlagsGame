import { Component, OnInit } from '@angular/core';
import { SocketService } from '../service/socket.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  show = true;
  username = '';
  password = '';

  constructor(private socketService: SocketService) { }

  ngOnInit() {
  }

  login():void {
    console.log("Send to socket: " + this.username + ' ' + this.password);
    var msg = {
      type: "message",
      text: "samo cska"
    };
    this.socketService.send(msg);
    this.show = false;
  }

}
