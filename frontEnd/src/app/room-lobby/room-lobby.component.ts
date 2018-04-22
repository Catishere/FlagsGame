import { Component, OnInit } from '@angular/core';
import { USERS } from '../mock-users'

@Component({
  selector: 'app-room-lobby',
  templateUrl: './room-lobby.component.html',
  styleUrls: ['./room-lobby.component.css']
})
export class RoomLobbyComponent implements OnInit {

  show: boolean = false;
  id : number;
  name: string = "Gosho's room ";
  users = USERS;

  constructor() { }

  ngOnInit() {
  }

}
