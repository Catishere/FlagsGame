import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  show: boolean = true;
  username : string = '';
  password : string = '';

  constructor() { }

  ngOnInit() {
  }

  login():void {
    console.log("Send to socket: " + this.username + ' ' + this.password);
    this.show = false;
  }

}
