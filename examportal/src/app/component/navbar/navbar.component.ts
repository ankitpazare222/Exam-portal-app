import { Component, OnInit } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { RouterLink, RouterOutlet } from '@angular/router';
import { LoginuserService } from '../../sevices/loginuser.service';
// import { UserService } from '../../sevices/user.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [MatToolbarModule,MatIconModule, RouterLink],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  username: string = '';
  name: string = '';
  // loginn: boolean = true;
  // regiator: boolean = true;


constructor(private login:LoginuserService){}
  ngOnInit(): void {
    // this.usernam();
  }
  
  logout(){

    this.login.logout();
    window.location.reload();
    window.location.href = '/login';

    
  }
  usernam(){
    const username=this.login.getUser().username
    // let mayname=this.username
    this.name=username;
    // if (this.name !=='') {
    //   this.loginn=false;
    //   this.regiator=false;
    // }
    // else{
    //   this.loginn=true;
    //   this.regiator=true;
    // }
  }
}
