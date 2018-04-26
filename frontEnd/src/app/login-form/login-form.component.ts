import { Component, OnInit } from '@angular/core';
import { SocketService } from '../service/socket.service';

@Component({
  selector: 'app-login-form',
  providers: [SocketService],
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  show: boolean = true;
  username : string = '';
  password : string = '';

  constructor(private socketService: SocketService) { }

  ngOnInit() {
  }

  login():void {
    console.log("Send to socket: " + this.username + ' ' + this.password);
    this.socketService.send("samo cska");
    this.show = false;
  }

}
