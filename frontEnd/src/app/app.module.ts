import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { SelectRoomComponent } from './select-room/select-room.component';
import { RoomLobbyComponent } from './room-lobby/room-lobby.component';
import { ActiveWindowComponent } from './active-window/active-window.component';
import { GameSessionComponent } from './game-session/game-session.component';
import { EndGameComponent } from './end-game/end-game.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    SelectRoomComponent,
    RoomLobbyComponent,
    ActiveWindowComponent,
    GameSessionComponent,
    EndGameComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
