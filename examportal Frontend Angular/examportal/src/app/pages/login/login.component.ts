import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../../sevices/user.service';
import { LoginuserService } from '../../sevices/loginuser.service';




@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MatInputModule, MatFormFieldModule, MatCardModule, FormsModule, MatSnackBarModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {

  }

  constructor(private http: HttpClient, private userservice: LoginuserService, private snack: MatSnackBar) { }
  public logindata = {
    "username": '',
    "password": ''
  }


  userloginData() {
    console.log(this.logindata);
    if (this.logindata.username == '' || this.logindata.username == null) {
      this.snack.open('username is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.logindata.password == '' || this.logindata.password == null) {
      this.snack.open('password is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }

    this.postlogin();


  }

  postlogin() {
    this.userservice.postlogindetails(this.logindata).subscribe({
      next: (data: any) => {
        console.log(data);
        this.userservice.loginuser(data.token);
  
        this.userservice.getCurrentuser().subscribe({
          next: (user: any) => {
            this.userservice.setUser(user);
            console.log('✅ User:', user);
  
            if (this.userservice.getUserRole() == "Ankit") {
              window.location.href = '/admin';
            }
            else if (this.userservice.getUserRole() !== "") {
              window.location.href = '/user';
            }
            else {
              this.userservice.logout();
            }
          },
          error: (err) => {
            console.error('❌ Error fetching current user:', err);
          }
        });
      },
  
      error: (err) => {
        // ✅ Agar login API (token generate) fail hoti hai
        this.snack.open('❌ Invalid Credentials! Please try again.', 'OK', {
          verticalPosition: "top",
          duration: 3000,
        });
        console.error('❌ Error during login:', err);
      }
    });
  }

  
  
  


}
