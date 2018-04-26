import { Component, OnInit } from '@angular/core';
import { USERS } from '../mock-users';

@Component({
  selector: 'app-end-game',
  templateUrl: './end-game.component.html',
  styleUrls: ['./end-game.component.css']
})
export class EndGameComponent implements OnInit {

  show = false;
  users = USERS;
  scores: number[] = [
    1,
    4
  ];


  constructor() { }

  ngOnInit() {
  }

}
