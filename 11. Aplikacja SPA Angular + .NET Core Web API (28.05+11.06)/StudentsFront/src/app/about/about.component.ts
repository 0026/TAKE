import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  text : any;

  constructor() { }

  ngOnInit(): void {
    this.text = new Date();
  }

}
