import {Component, OnInit, ViewChild} from '@angular/core';
import {LoginFormComponent} from '../login-form/login-form.component';
import {SelectRoomComponent} from '../select-room/select-room.component';
import {GameSessionComponent} from '../game-session/game-session.component';
import {SocketService} from "../service/socket.service";
import {LeaderboardComponent} from '../leaderboard/leaderboard.component';

@Component({
  selector: 'app-active-window',
  templateUrl: './active-window.component.html',
  styleUrls: ['./active-window.component.css']
})
export class ActiveWindowComponent implements OnInit {

  @ViewChild(LoginFormComponent) login: LoginFormComponent;
  @ViewChild(SelectRoomComponent) selectRoom: SelectRoomComponent;
  @ViewChild(GameSessionComponent) gameSession: GameSessionComponent;
  @ViewChild(LeaderboardComponent) leaderboard: LeaderboardComponent;

  constructor(private socketService: SocketService) { }

  ngOnInit() {
    this.socketService.initSocket();
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
      case 'gameSession':
        this.gameSession.show = true;
        break;
      case 'endGame':
        console.log('endGame');
        break;
      case 'leaderboard':
        this.leaderboard.show = true;
        break;
      default:
        this.login.show = true;
        break;
    }
  }

  disableAll() {
    this.login.show = false;
    this.selectRoom.show = false;
    this.gameSession.show = false;
    this.leaderboard.show = false;
  }


}
