import { Component, OnInit } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../../sevices/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2'
import { MatCardModule } from '@angular/material/card';

// import { BrowserModule } from '@angular/platform-browser';
@Component({
  selector: 'app-singnup',
  standalone: true,
  imports: [MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    MatCardModule,
    
    // BrowserModule
  ],
  templateUrl: './singnup.component.html',
  styleUrl: './singnup.component.css'
})
export class SingnupComponent implements OnInit {

  ngOnInit(): void {
   
  }

  constructor(private http:HttpClient,private userservice:UserService,private snack:MatSnackBar){}
  public user={
    username: '',
    password:'' ,
    firstName:'' ,
    lastName:'' ,
    email:'' ,
    phone:'' ,
  }


  formSubmit(){
    // alert('askdjhasui')

    console.log(this.user)
    if(this.user.username=='' || this.user.username==null){
      // alert('user is required')
      this.snack.open('user is required !!','ok',{
        verticalPosition:"top"
      })
      return
    }
    this.saveuserdata();

  }




  saveuserdata(){
    this.userservice.saveuserdata(this.user).subscribe((data:any)=> {
      console.log(data);

      Swal.fire('Sucess is done !!','user id:'+data.id+'  USer name:'+data.username,'success')
      
    })

  }
  // selectedFile: File | null = null;
  // onFileSelected(event: any) {
  //   this.selectedFile = event.target.files[0];
  // }

}
