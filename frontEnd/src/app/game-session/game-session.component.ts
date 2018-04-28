import {Component, forwardRef, Input, OnInit, ViewChild} from '@angular/core';
import {QUESTIONS} from '../mock-questions';
import {Question} from '../question';
import {ActiveWindowComponent} from '../active-window/active-window.component';

@Component({
  selector: 'app-game-session',
  templateUrl: './game-session.component.html',
  styleUrls: ['./game-session.component.css']
})
export class GameSessionComponent implements OnInit {

  show = false;
  questId = 0;
  questions = QUESTIONS;
  currentQuestion: Question = this.questions[0];

  constructor() {
  }

  ngOnInit() {
    this.currentQuestion = this.questions[0];
    console.log(this.currentQuestion);
  }

  nextQuestion() {
    if (this.questions.length - 1 > this.questId) {
      this.questId++;
    }
    this.currentQuestion = this.questions[this.questId];
    console.log(this.questId);
  }

  getPathOf(flag: string): string {
    return 'assets/flags/' + flag + '.png';
  }

}
