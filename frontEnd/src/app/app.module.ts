import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { SelectRoomComponent } from './select-room/select-room.component';
import { RoomLobbyComponent } from './room-lobby/room-lobby.component';
import { ActiveWindowComponent } from './active-window/active-window.component';
import { GameSessionComponent } from './game-session/game-session.component';
import {
  SocialLoginModule,
  AuthServiceConfig,
  GoogleLoginProvider,
  FacebookLoginProvider,
} from 'angular5-social-login';
import { SignInComponent } from './signin/signin.component';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import { NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatChipsModule} from '@angular/material/chips';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatIconModule} from '@angular/material/icon';
import {SocketService} from "./service/socket.service";
import {MatRadioModule} from '@angular/material/radio';
import {MatProgressBarModule} from '@angular/material/progress-bar';


export function getAuthServiceConfigs() {
  return new AuthServiceConfig(
    [
      {
        id: FacebookLoginProvider.PROVIDER_ID,
        provider: new FacebookLoginProvider('599511380396307')
      },
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider('924387460332-mkdjvc9be9u0oa28dhb6oobvddd5t9i8.apps.googleusercontent.com')
      }
    ]
  );
}

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    SelectRoomComponent,
    RoomLobbyComponent,
    ActiveWindowComponent,
    GameSessionComponent,
    SignInComponent
  ],
  imports: [
    BrowserModule,
    SocialLoginModule,
    FormsModule, MatFormFieldModule, MatRadioModule, MatIconModule, MatProgressBarModule, MatButtonModule, MatCheckboxModule, NoopAnimationsModule, MatChipsModule, MatInputModule, MatListModule, MatExpansionModule
  ],
  providers: [
    {
      provide: AuthServiceConfig,
      useFactory: getAuthServiceConfigs
    },
    SocketService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
