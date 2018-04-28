import { Component, OnInit } from '@angular/core';
import { ROOMS } from '../mock-rooms';

@Component({
  selector: 'app-select-room',
  templateUrl: './select-room.component.html',
  styleUrls: ['./select-room.component.css']
})
export class SelectRoomComponent implements OnInit {

  show : boolean = false;
  rooms = ROOMS;

  constructor() { }

  ngOnInit() {
  }

  joinRoom(id: number) {
    console.log('test ' + id);
    this.show = false;
  }

}
