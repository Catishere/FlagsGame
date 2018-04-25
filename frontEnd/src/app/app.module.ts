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
} from "angular5-social-login";
import { SignInComponent } from './signin/signin.component';

export function getAuthServiceConfigs() {
  let config = new AuthServiceConfig(
    [
      {
        id: FacebookLoginProvider.PROVIDER_ID,
        provider: new FacebookLoginProvider("599511380396307")
      },
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider("924387460332-mkdjvc9be9u0oa28dhb6oobvddd5t9i8.apps.googleusercontent.com")
      }
    ]
  );
  return config;
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
    FormsModule
  ],
  providers: [
    {
      provide: AuthServiceConfig,
      useFactory: getAuthServiceConfigs
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
