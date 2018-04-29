import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  show = false;
  displayedColumns = ['rank', 'name', 'score'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit() {
  }

}

export interface Element {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA:Leaderboards[] = [
  {rank: 1, name: 'Hydrogen', score: 355},
  {rank: 2, name: 'Oxygen', score: 213},
  {rank: 3, name: 'Uran', score: 33}

];


export interface Leaderboards {
  rank: number;
  name: string;
  score: number;
}
