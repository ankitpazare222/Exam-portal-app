import { Component, OnInit } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { CommonModule } from '@angular/common';
import { LoginuserService } from '../../../sevices/loginuser.service';
import { CategoryService } from '../../../sevices/category.service';
import { error } from 'console';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import jsPDF from 'jspdf';
import autoTable from 'jspdf-autotable';
import { MatExpansionModule } from '@angular/material/expansion';

// import { NgxUiLoaderModule } from 'ngx-ui-loader';

@Component({
  selector: 'app-userdasboard',
  standalone: true,
  imports: [MatListModule, MatCardModule, MatMenuModule, MatIconModule, CommonModule, FormsModule, MatInputModule, MatSlideToggleModule,
    MatSelectModule, MatButtonModule, MatExpansionModule],
  templateUrl: './userdasboard.component.html',
  styleUrl: './userdasboard.component.css'
})
export class UserdasboardComponent implements OnInit {
  getcategory: any;
  quizessss: any;
  quizesdata: any;
  instruction: boolean = false;
  ShowQuizes: boolean = false;
  questionsss: any;
  questionTitle: any;
  qID: any;
  mainAllDiv: boolean = true;
  startquizhear: boolean = false;
  questionss: any;
  Quizeresult: boolean = false;
  showResult: boolean = false;
  user: any;
  name: any;
  userID: any;
  personal: boolean = false;
  education: boolean = false;
  placement: boolean = false;
  file: Blob | undefined;
  filename: any;

  // userDetails: any;


  constructor(public category: CategoryService, private login: LoginuserService, public snak: MatSnackBar) {

  }
  ngOnInit(): void {
    this.getCategory();

    // this.getallQuizzes();

  }

  //  get all category
  getCategory() {


    this.category.getcategory().subscribe((data: any) => {
      this.getcategory = data;
      console.log(this.category)

    },
      (error) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Something went wrong!",

        });
      })





  }

  // get all quizes

  getallQuizzes() {

    this.category.getActiveQuizess().subscribe((data: any) => {
      this.quizessss = data;
      this.ShowQuizes = true;
      this.personal = false;
      this.education = false;
      this.placement = false;
    },
      (error) => {
        console.log(error);
      })

  }


  viewQuiz(qid: any) {

  }

  startQuiz(qid: any) {
    this.category.getQuizesByIddd(qid).subscribe((data: any) => {

      this.quizesdata = data;
      this.qID = this.quizesdata.qID;
      this.instruction = true;
      this.ShowQuizes = false;



    })

  }

  // get Quize by title
  getQuizeById(cid: any) {
    this.category.getCategoryActiceTitleByID(cid).subscribe((data: any) => {
      this.quizessss = data;
      this.ShowQuizes = true;

      this.personal = false;
      this.education = false;
      this.placement = false;
    })

  }

  // start quize
  startQuizsFortest(qID: any) {
    this.category.getQuesBYiDForTest(qID).subscribe((data: any) => {
      this.questionss = data;
      this.questionss.forEach((q: any) => {
        q['givenanswer'] = '';
      })


      this.questionsss = this.questionss;
      console.log(this.questionsss)
      let title = this.questionsss[0].quiz.title;
      this.questionTitle = title
      this.mainAllDiv = false;
      this.startquizhear = true;
      // let Qidd = this.questionsss[0].quiz.qID;


      console.log(this.questionTitle);



    })

  }
  marksGot = 0;
  attemted = 0;
  correctAnswer = 0;

  submitQuize() {
    console.log(this.questionsss);
    this.questionsss.forEach((q: any) => {
      if (q.givenanswer == q.answer) {
        this.correctAnswer++;
        let marksSingle = this.questionsss[0].quiz.maxMarks / this.questionsss.length;
        this.marksGot += marksSingle;
      }

      if (q.givenanswer.trim() !== '') {
        this.attemted++;
      }
    });

    // SweetAlert
    Swal.fire({
      title: 'Quiz Submitted!',
      html: `
        <h3>🎯 Marks Got: <strong>${this.marksGot.toFixed(2)}</strong></h3>
        <h3>✅ Correct Answers: <strong>${this.correctAnswer}</strong></h3>
        <h3>📝 Questions Attempted: <strong>${this.attemted}</strong></h3>
      `,
      icon: 'success',
      confirmButtonText: 'OK',
      confirmButtonColor: '#1976d2',
      width: 500,
    });

    this.getadminuser();
    this.Quizeresult = true;
    this.startquizhear = false;



    console.log(this.correctAnswer);
    console.log(this.marksGot);

  }
  getadminuser() {
    this.user = this.login.getUser()
    this.name = this.user.firstName + this.user.lastName;
  }


  printPage() {
    window.print();
  }

  backtohome() {
    this.mainAllDiv = true;
    this.Quizeresult = false;
    this.getallQuizzes();
    this.instruction = false;
    this.showResult = false;


  }
  viewresult() {
    this.showResult = true;
  }

  exportQuizResultToPDF() {
    const doc = new jsPDF();

    doc.setFontSize(18);
    doc.text('Quiz Result Report', 65, 15);

    doc.setFontSize(12);
    doc.text(`User: ${this.name || 'Anonymous'}`, 14, 30);
    doc.text(`Total Score: ${this.marksGot} / ${this.questionsss[0].quiz.maxMarks}`, 14, 38);

    const tableData = this.questionsss.map((q: any, index: number) => [
      index + 1,
      q.content?.replace(/<[^>]+>/g, ''), // remove html tags if any
      q.answer,
      q.givenanswer || 'Not Attempted',
      q.answer === q.givenanswer ? '✔ Correct' : '✘ Wrong',
    ]);

    autoTable(doc, {
      startY: 45,
      head: [['#', 'Question', 'Correct Answer', 'Your Answer', 'Result']],
      body: tableData,
      styles: { fontSize: 9, cellPadding: 3 },
      headStyles: { fillColor: [63, 81, 181], textColor: 255 },
      alternateRowStyles: { fillColor: [240, 240, 240] },
    });

    doc.save(this.name + ' quiz-result.pdf');
  }

  showPersonalDetails() {
    var username = this.login.getUser().id

    this.userID = username

    this.category.getuserByID(this.userID).subscribe((data: any) => {
      this.userDetails = data;
      this.personal = true;
      this.education = false;
      this.placement = false
      this.ShowQuizes = false;


    })


  }
  showEducationDetails() {
    var username = this.login.getUser().id

    this.userID = username

    this.category.getuserByID(this.userID).subscribe((data: any) => {
      this.userDetails = data;
      this.personal = false;
      this.education = true;
      this.placement = false
      this.ShowQuizes = false;


    })

  }
  showPlacementDetails() {
    var username = this.login.getUser().id

    this.userID = username

    this.category.getuserByID(this.userID).subscribe((data: any) => {
      this.userDetails = data;
      this.personal = false;
      this.education = false;
      this.placement = true
      this.ShowQuizes = false;

    })

  }




  userDetails: any = {};

  updateEducationdetails() {
    this.category.UpdateUserDetails(this.userDetails).subscribe({
      next: (response: any) => {
        this.snak.open("✅ User details updated successfully!", "Close", {
          duration: 3000,
          panelClass: ['success-snackbar']
        });
      },
      error: (err: any) => {
        this.snak.open("❌ Failed to update user details!", "Close", {
          duration: 3000,
          panelClass: ['error-snackbar']
        });
      }
    });

  }
  resumeFile: File | null = null;




  downloadResume() {
    var username = this.login.getUser().id
    this.user = this.login.getUser()
    this.name = this.user.firstName +" " + this.user.lastName;

    this.userID = username

    this.category.downloadResume(this.userID).subscribe({
      next: (data) => {
        this.file=data;
        const blob = new Blob([data], { type: data.type });
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        this.filename="resume of "+this.name;
        a.download = this.filename; // server se naam laane ka option bhi hai
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
      },
      error: (err) => alert("Download failed: " + err.message)
    });
  }




  selectedFile!: File;
  onResumeSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }



  uploadResume() {
    var username = this.login.getUser().id

    this.userID = username

    if (this.selectedFile) {
      this.category.uploadResume(this.userID, this.selectedFile).subscribe({
        next: (res: any) => alert(res),
        error: (err: { message: string; }) => alert("Upload failed: " + err.message)
      });
    } else {
      alert("Please select a file first!");
    }
  }


}
