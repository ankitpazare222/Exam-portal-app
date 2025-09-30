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
import * as XLSX from 'xlsx';
@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [MatListModule, MatCardModule, MatMenuModule, MatIconModule, CommonModule, FormsModule, MatInputModule, MatSlideToggleModule,
    MatSelectModule, MatButtonModule,
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  excelData: any[] = [];
  home: boolean = false;
  profile: boolean = false;
  // name: any=[];
  user: any = null;
  getcategory: any;
  showcategory: boolean = false;
  showaddcategory: boolean = false;
  quizessss: any;
  showAllquizes: boolean = false;
  quizData: any;
  ShowaddQuizes: boolean = false;
  qID: any;
  quizesdata: any;
  showUpdate: boolean = false;
  questionsss: any;
  questionTitle: any;
  questionID: any;
  showQuestionForm: boolean = false;
  GetQuestionByID: boolean = false;
  QueByID: any;
  showUpdateQuestionForm: boolean = false;
  Allstudentlist: any;
  ShowSTD: boolean = false;
  name: any;
  userID: any;
  // snack: any;
  constructor(private login: LoginuserService, public category: CategoryService, public snak: MatSnackBar) { }
  ngOnInit(): void {
    // this.getadminuser();
    // this.home=true;
    // this.getCategory();
    // this.getallQuizzes();
    // this.showQuestionForm=false;
    // this.GetQuestionByID=false;




  }
  public CategoryData = {

    "title": "",
    "description": "",
    "maxMarks": "",
    "active": "",
    "category": {

      "cid": ""

    },
    "numberofQue": "",
  }

  public titlecategory = {

    "title": '',
    "description": '',

  }

  public AddQuestion = {

    "content": "",
    "image": "",
    "option1": "",
    "option2": "",
    "option3": "",
    "option4": "",
    "answer": "",
    "quiz": {
      "qID": ""

    }
  }
  getHome() {
    this.showaddcategory = false;
    this.showcategory = false;
    this.home = true;
    this.profile = false;
    this.showAllquizes = false;
    this.ShowaddQuizes = false;
    this.showUpdate = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;

  }

  getProfile() {
    this.showaddcategory = false;
    this.showcategory = false;
    this.home = false;
    this.profile = true;
    this.getadminuser();
    this.showAllquizes = false;
    this.ShowaddQuizes = false;
    this.showUpdate = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;

  }

  getadminuser() {
    this.user = this.login.getUser()
    // this.name=username;
  }
  addnewcategory() {

    this.showaddcategory = true;
    this.showcategory = false;
    this.home = false;
    this.profile = false;
    this.showAllquizes = false;
    this.ShowaddQuizes = false;
    this.showUpdate = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;

  }


  getCategory() {
    this.showcategory = true;
    this.showaddcategory = false;
    // this.showcategory=false;
    this.home = false;
    this.profile = false;
    this.showAllquizes = false;
    this.ShowaddQuizes = false;
    this.showUpdate = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;

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

  postCategory() {
    this.category.postcategorySave(this.titlecategory).subscribe((data: any) => {
      this.titlecategory.title = '',
        this.titlecategory.description = ''
      Swal.fire({
        title: "Good job!",
        text: "Category added sucessfully",
        icon: "success"
      });

    },
      (error) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Something went wrong!",

        });

      }

    )


  }

  postQuizes() {
    this.category.postQuizes(this.CategoryData).subscribe((data: any) => {
      this.CategoryData.title = '',
        this.CategoryData.description = ''
      Swal.fire({
        title: "Good job!",
        text: "Quizes added sucessfully",
        icon: "success"
      });

    },
      (error) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Something went wrong!",

        });

      }

    )

  }


  saveCategory() {
    console.log(this.titlecategory);
    if (this.titlecategory.title == '' || this.titlecategory.title == null) {
      this.snak.open('title is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.titlecategory.description == '' || this.titlecategory.description == null) {
      this.snak.open('description is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }

    this.postCategory();


  }

  deleteCategory(cid: any) {


    Swal.fire({
      title: 'Are you sure?',
      text: 'This action cannot be undone!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {

      if (result.isConfirmed) {
        this.category.deleteCategory(cid).subscribe((data: any) => {
          Swal.fire('Deleted!', 'Category has been deleted.', 'success');
          this.getCategory() // refresh list

        },
          (error) => {
            console.log(error)
          })


      }
    });

  }

  getaddCategory() {
    this.showaddcategory = true;
    this.showcategory = false;
    this.home = false;
    this.profile = false;
    this.showAllquizes = false;
    this.ShowaddQuizes = false;
    this.showUpdate = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;


  }

  // show all quizes

  getallQuizzes() {
    this.showAllquizes = true;
    this.showUpdate = false;
    this.ShowaddQuizes = false;
    this.showaddcategory = false;
    this.showcategory = false;
    this.home = false;
    this.profile = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;
    this.category.getAllquizessa().subscribe((data: any) => {
      this.quizessss = data;
    },
      (error) => {
        console.log(error);
      })

  }

  // add quize

  AddQuizes() {
    console.log(this.CategoryData);
    if (this.CategoryData.title == '' || this.CategoryData.title == null) {
      this.snak.open('title is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.CategoryData.description == '' || this.CategoryData.description == null) {
      this.snak.open('description is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }
    if (this.CategoryData.maxMarks == '' || this.CategoryData.maxMarks == null) {
      this.snak.open('maxMarks is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.CategoryData.numberofQue == '' || this.CategoryData.numberofQue == null) {
      this.snak.open('Number of question is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }
    if (this.CategoryData.category.cid == '' || this.CategoryData.category.cid == null) {
      this.snak.open('category is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }

    this.postQuizes();

  }

  getaddAllQuizzes() {
    this.ShowaddQuizes = true;

    this.showAllquizes = false;

    this.showaddcategory = false;
    this.showcategory = false;
    this.home = false;
    this.profile = false;
    this.showUpdate = false;
    this.GetQuestionByID = false;
    this.showQuestionForm = false;
    this.showUpdateQuestionForm = false;
    this.ShowSTD = false;

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
  // delete Quizes

  deleteQuize(qID: any) {
    console.log(qID)

    Swal.fire({
      title: 'Are you sure?',
      text: 'This action cannot be undone!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {

      if (result.isConfirmed) {
        this.category.deleteQuize(qID).subscribe((data: any) => {
          Swal.fire('Deleted!', 'Quize has been deleted.', 'success');
          this.getallQuizzes() // refresh list

        },
          (error) => {
            console.log(error)
            Swal.fire({
              icon: "error",
              title: "Oops...",
              text: "Something went wrong!",

            });
          })


      }
    });




  }
  //  get quizes by ID
  getQuizesById(qID: number) {
    this.showUpdate = true;
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
    this.showAllquizes = false;

    this.category.getQuizesByIddd(qID).subscribe((data: any) => {

      this.quizesdata = data;
    })

  }



  UpdateQuizessss() {
    console.log(this.quizesdata);
    if (this.quizesdata.title == '' || this.quizesdata.title == null) {
      this.snak.open('title is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.quizesdata.description == '' || this.quizesdata.description == null) {
      this.snak.open('description is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }
    if (this.quizesdata.maxMarks == '' || this.quizesdata.maxMarks == null) {
      this.snak.open('maxMarks is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.quizesdata.numberofQue == '' || this.quizesdata.numberofQue == null) {
      this.snak.open('Number of question is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }
    if (this.quizesdata.category.cid == '' || this.quizesdata.category.cid == null) {
      this.snak.open('category is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }

    this.category.putUodateQuize(this.quizesdata).subscribe((data: any) => {

      Swal.fire({
        title: "Good job!",
        text: "Your data update sucessfully",
        icon: "success"
      });
      this.getallQuizzes();

    })
  }

  //  get question by ID
  QuestionByiD(qID: any) {
    this.questionID = qID

    this.GetQuestionByID = true;
    this.showAllquizes = false;
    this.showUpdateQuestionForm = false;
    this.category.getQuesBYiD(qID).subscribe((data: any) => {
      this.questionsss = data;
      let title = this.questionsss[0].quiz.title;
      this.questionTitle = title
      // let Qidd = this.questionsss[0].quiz.qID;

      console.log(this.questionTitle);



    })
  }


  // getQuesID
  queID(questionID: any) {


    this.showQuestionForm = true;
    this.GetQuestionByID = false;
    this.AddQuestion.quiz.qID = questionID;
    console.log(this.AddQuestion);


  }

  // add question

  addQuestions() {


    if (this.AddQuestion.content == '' || this.AddQuestion.content == null) {
      this.snak.open('content is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.AddQuestion.answer == '' || this.AddQuestion.answer == null) {
      this.snak.open('answer is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }
    if (this.AddQuestion.option1 == '' || this.AddQuestion.option1 == null) {
      this.snak.open('option1 is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return

    }
    if (this.AddQuestion.option2 == '' || this.AddQuestion.option2 == null) {
      this.snak.open('option2 of question is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }
    if (this.AddQuestion.option4 == '' || this.AddQuestion.option4 == null) {
      this.snak.open('option4 is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }

    if (this.AddQuestion.option3 == '' || this.AddQuestion.option3 == null) {
      this.snak.open('option3 is required !!', 'ok', {
        verticalPosition: "top",
        duration: 3000,
      })
      return
    }


    this.category.PostaddQuestion(this.AddQuestion).subscribe((data: any) => {

      Swal.fire({
        title: "Good job!",
        text: "Nice! Your question is now part of the quiz",
        icon: "success"
      });
      this.AddQuestion.answer = '',
        this.AddQuestion.content = '',
        this.AddQuestion.option1 = '',
        this.AddQuestion.option2 = '',
        this.AddQuestion.option4 = '',
        this.AddQuestion.option3 = ''


    },
      (error) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "🛑 Oops! Question could not be saved.",

        });
      })

    console.log(this.AddQuestion)
  }


  // update question
  updateQuestion(quesId: any, index: number) {
    this.showUpdateQuestionForm = true;
    this.GetQuestionByID = false;

    this.category.getQuestionByID(quesId).subscribe((data: any) => {
      this.QueByID = data;
    })




  }

  // delete question
  deleteQuestion(quesId: any, index: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: "This question will be permanently deleted!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.category.deleteQuestionByid(quesId).subscribe(
          (data: any) => {
            // ✅ Remove item from the array using index
            this.questionsss.splice(index, 1);

            Swal.fire('Deleted!', 'The question has been deleted.', 'success');
          },
          (error) => {
            console.error(error);
            Swal.fire('Error!', 'Could not delete the question.', 'error');
          }
        );
      }
    });
  }

  // update question
  updateeQuestions() {

    console.log(this.QueByID);
    this.qID = this.QueByID.quiz.qID;

    this.category.postUpdateQuestion(this.QueByID).subscribe(
      (data: any) => {
        // ✅ Show success alert
        Swal.fire({
          icon: 'success',
          title: 'Updated!',
          text: 'Question has been updated successfully.',
          timer: 2000,
          showConfirmButton: false
        });

        this.showUpdateQuestionForm = false;
        this.GetQuestionByID = true;
        this.QuestionByiD(this.qID);



      },
      (error) => {
        console.error(error);
        Swal.fire({
          icon: 'error',
          title: 'Failed!',
          text: 'Something went wrong while updating the question.',
        });
      }
    );
  }

  // get all student list 
  GEtallstudent() {
    this.ShowSTD = true;
    this.category.getAllstdList().subscribe((data: any) => {
      this.Allstudentlist = data;
      console.log(this.Allstudentlist);
    })

  }
  deleteStudent(id: any, i: any) {

    Swal.fire({
      title: 'Are you sure?',
      text: "This Candidate will be permanently deleted!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.category.deleteStudentBYID(id).subscribe(
          (data: any) => {
            // ✅ Remove item from the array using index
            this.Allstudentlist.splice(i, 1);

            Swal.fire('Deleted!', 'The Candidate has been deleted.', 'success');
          },
          (error) => {
            console.error(error);
            Swal.fire('Error!', 'Could not delete the Candidate.', 'error');
          }
        );
      }
    });


  }

  onFileChange(event: any) {
    const target: DataTransfer = <DataTransfer>(event.target);

    if (target.files.length !== 1) {
      alert('Only one file allowed.');
      return;
    }

    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {
      const bstr: string = e.target.result;
      const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary' });
      const wsname: string = wb.SheetNames[0];
      const ws: XLSX.WorkSheet = wb.Sheets[wsname];
      this.excelData = XLSX.utils.sheet_to_json(ws, { defval: '' }); // Parse to JSON
    };
    reader.readAsBinaryString(target.files[0]);
  }


  uploadQuestions() {
    console.log(this.excelData);
    this.category.PostaddQuestion(this.excelData).subscribe((data: any) => {

      Swal.fire({
        title: "Good job!",
        text: "Nice! Your question is now part of the quiz",
        icon: "success"
      });
      // this.AddQuestion.answer = '',
      //   this.AddQuestion.content = '',
      //   this.AddQuestion.option1 = '',
      //   this.AddQuestion.option2 = '',
      //   this.AddQuestion.option4 = '',
      //   this.AddQuestion.option3 = ''


    },
      (error) => {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "🛑 Oops! Question could not be saved.",

        });
      })
  }



  selectedFile: File | null = null;
  uploadMessage: string = '';


  


  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  uploadFile() {
    if (this.selectedFile) {
      this.category.uploadBulkQuestions(this.selectedFile)
        .subscribe(
          (res) => {
            this.uploadMessage = '✅ Questions uploaded successfully!';
            this.selectedFile = null;
          },
          (err) => {
            this.uploadMessage = '❌ Upload failed: ' + (err.error?.message || err.message);
          }
        );
    } else {
      this.uploadMessage = '⚠️ Please select a file first.';
    }
  }
  selectedStudent: any = null;
  viewStudent(student: any) {
    this.selectedStudent = student;
  }
  
  closeModal() {
    this.selectedStudent = null;
  }

  // downloadResume(selectedStudent:any){

  // }
  filename: any;
  file: Blob | undefined;
  downloadResume(selectedStudent:any) {
    var username = this.selectedStudent.id;
    // this.user = this.login.getUser()
    this.name = this.selectedStudent.firstName +" " + this.selectedStudent.lastName;

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
      error: (err) => alert("This student has not uploaded a resume yet." )
    });
  }



  

}
