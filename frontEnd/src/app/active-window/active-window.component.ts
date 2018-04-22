import {Component, OnInit, ViewChild} from '@angular/core';
import {LoginFormComponent} from '../login-form/login-form.component';
import {RoomLobbyComponent} from '../room-lobby/room-lobby.component';
import {SelectRoomComponent} from '../select-room/select-room.component';
import {Room} from '../room';
import {GameSessionComponent} from '../game-session/game-session.component';

@Component({
  selector: 'app-active-window',
  templateUrl: './active-window.component.html',
  styleUrls: ['./active-window.component.css']
})
export class ActiveWindowComponent implements OnInit {

  @ViewChild(LoginFormComponent) login: LoginFormComponent;
  @ViewChild(SelectRoomComponent) selectRoom: SelectRoomComponent;
  @ViewChild(RoomLobbyComponent) lobby: RoomLobbyComponent;
  @ViewChild(GameSessionComponent) gameSession: GameSessionComponent;

  constructor() {
  }

  ngOnInit() {
  }

  onReceiveMessage(msg: string) {
    this.disableAll();
    switch (msg) {
      case 'login' :
        this.login.show = true;
        break;
      case 'selectRoom' :
        this.selectRoom.show = true;
        break;
      case 'lobby' :
        this.lobby.show = true;
        break;
      case 'gameSession':
        this.gameSession.show = true;
        break;
      case 'endGame':
        console.log('endGame');
        break;
      default:
        this.login.show = true;
        break;
    }
  }

  disableAll() {
    this.login.show = false;
    this.selectRoom.show = false;
    this.lobby.show = false;
    this.gameSession.show = false;
  }

}
