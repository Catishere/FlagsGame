import {Component, forwardRef, Input, OnInit, ViewChild} from '@angular/core';
import {QUESTIONS} from '../mock-questions';
import {Question} from '../question';
import {ActiveWindowComponent} from '../active-window/active-window.component';
import {MatSnackBar} from '@angular/material';

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
  userAnswer: string;
  timer = 0;
  intervalId: number;
  points = 0;

  constructor(public snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.currentQuestion = this.questions[0];
    console.log(this.currentQuestion);
    this.start();
  }

  nextQuestion() {
    console.log(this.userAnswer);
    if (this.userAnswer === this.currentQuestion.answers[this.currentQuestion.correct]) {
      this.snackBar.open('You answered correctly.', 'Cool', {
        duration: 3500;
      });
      this.points += 20 - this.timer;
    } else {
      this.snackBar.open('You answered wrong.', 'Fak', {
        duration: 3500;
      });
    }
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
    if (!this.show) return;
    this.timer += 10;
    if (this.timer === 110) {
      this.nextQuestion();
    }
  }

}
