import { Component, OnInit } from '@angular/core';
import { USERS } from '../mock-users'

@Component({
  selector: 'app-room-lobby',
  templateUrl: './room-lobby.component.html',
  styleUrls: ['./room-lobby.component.css']
})
export class RoomLobbyComponent implements OnInit {

  show: boolean = true;
  users = USERS;

  constructor() { }

  ngOnInit() {
  }

}
