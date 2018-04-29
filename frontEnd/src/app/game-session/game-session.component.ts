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
  userAnswer: number;
  timer = 0;
  intervalId: number;

  constructor() {
  }

  ngOnInit() {
    this.currentQuestion = this.questions[0];
    console.log(this.currentQuestion);
    this.start();
  }

  nextQuestion() {
    if (this.questions.length - 1 > this.questId) {
      this.questId++;
    }
    this.currentQuestion = this.questions[this.questId];
    this.timer = 0;
    console.log(this.questId);
  }

  start() {
    this.intervalId = setInterval(() => {
      this.timeIt();
    }, 1000);
  }

  stop() {
    clearInterval(this.intervalId);
    this.intervalId = -1;
  }

  startStop() {
    if (this.intervalId === -1) {
      this.start();
    } else {
      this.stop();
    }
  }

  timeIt() {
    this.timer += 10;
    if (this.timer === 110) {
      this.nextQuestion();
    }
  }

  }
