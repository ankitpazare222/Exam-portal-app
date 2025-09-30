import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent implements OnInit{
  users: any[] = [];


  ngOnInit(): void {
    this.users = [
      { name: 'Ankit', email: 'ankit@example.com' },
      { name: 'Priya', email: 'priya@example.com' },
      { name: 'Rahul', email: 'rahul@example.com' }
    ];
    
    
  }

 

}
