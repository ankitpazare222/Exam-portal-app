import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { CommonModule } from '@angular/common';
import { LoginuserService } from '../../../sevices/loginuser.service';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [  MatCardModule,MatMenuModule,MatIconModule,CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  constructor(private login:LoginuserService){}
  home: boolean = false;
  profile: boolean = false;
  user: any = null;
  getHome(){
    this.home=true;
    this.profile=false;

  }

  getProfile(){
    this.home=false;
    this.profile=true;
    this.getadminuser();

  }

  getadminuser(){
    this.user=this.login.getUser()
    // this.name=username;
  }
}
