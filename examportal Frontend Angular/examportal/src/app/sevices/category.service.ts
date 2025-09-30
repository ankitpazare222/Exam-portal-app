import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  // getcategoryURL='http://localhost:9003/category/'
  // postcategorySaveURL='http://localhost:9003/category/'
  // deleteCategoryURL='http://localhost:9003/category/'

  baseUrlforCategory='http://localhost:9003/category/'

  baseUrlForSquiz='http://localhost:9003/quiz/'

  getQuesBYiDURL='http://localhost:9003/question/quiz/all/'

  baseUrLforQuestion='http://localhost:9003/question/'

  getCategoryTitleByIDURL='http://localhost:9003/quiz/category/'

  getActiveQuizessURL='http://localhost:9003/quiz/active'

  getCategoryActiceTitleByIDURL='http://localhost:9003/quiz/category/active/'

  getQuesBYiDForTestURL='http://localhost:9003/question/quiz/'

  getAllstdListURL='http://localhost:9003/user/all'

  deleteStudentBYIDURL='http://localhost:9003/user/'

  baseUrl = 'http://localhost:9003/questions';

  userURl='http://localhost:9003/user/id/'

  updateUserById='http://localhost:9003/user/'

  updateUserInfo='http://localhost:9003/details/'

  uploadFileByID='http://localhost:9003/user/uploadResume/'
  // getAllquizessaURL='http://localhost:9003/quiz/'
  // postQuizesURL='http://localhost:9003/quiz/'
  // deleteQuizeURL='http://localhost:9003/quiz/'
  // getQuizesByIdddURL='http://localhost:9003/quiz/'


  constructor( private http:HttpClient) { }
  uploadBulkQuestions(file: File): Observable<any> {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post(`${this.baseUrl}/bulk-upload`, formData);
  }

  getAllstdList():Observable<any>{
    return this.http.get(`${this.getAllstdListURL}`);
  }

  deleteStudentBYID(id: any): Observable<any> {
    return this.http.delete(`${this.deleteStudentBYIDURL}${id}`);
  }

  getcategory():Observable<any>{
    return this.http.get(`${this.baseUrlforCategory}`);
  }

  postcategorySave(titlecategory:any):Observable<any>{
    return this.http.post(`${this.baseUrlforCategory}`,titlecategory);
  }
  // deleteCategory(cid:any):Observable<any>{
  //   return this.http.delete(`${this.deleteCategoryURL}${cid}`)
  // }

  deleteCategory(cid: any): Observable<any> {
    return this.http.delete(`${this.baseUrlforCategory}${cid}`);
  }



  getAllquizessa():Observable<any>{
    return this.http.get(`${this.baseUrlForSquiz}`);
  }

  getActiveQuizess():Observable<any>{
    return this.http.get(`${this.getActiveQuizessURL}`);
  }

  postQuizes(CategoryData:any):Observable<any>{
    return this.http.post(`${this.baseUrlForSquiz}`,CategoryData);
  }

  deleteQuize(qID: any): Observable<any> {
    return this.http.delete(`${this.baseUrlForSquiz}${qID}`);
  }

  getQuizesByIddd(qID:any): Observable<any> {
    return this.http.get(`${this.baseUrlForSquiz}${qID}`);
  }
  
  putUodateQuize(quizesdata:any):Observable<any>{
    return this.http.put(`${this.baseUrlForSquiz}`,quizesdata);
  }

  getQuesBYiD(qID:any):Observable<any>{
    return this.http.get(`${this.getQuesBYiDURL}${qID}`);
  }

  getQuesBYiDForTest(qID:any):Observable<any>{
    return this.http.get(`${this.getQuesBYiDForTestURL}${qID}`);
  }

  PostaddQuestion(AddQuestion:any):Observable<any>{
    return this.http.post(`${this.baseUrLforQuestion}`,AddQuestion);
  }

  deleteQuestionByid(quesId:any):Observable<any>{
    return this.http.delete(`${this.baseUrLforQuestion}${quesId}`);
  }

  getQuestionByID(quesId:any):Observable<any>{
    return this.http.get(`${this.baseUrLforQuestion}${quesId}`);
  }

  postUpdateQuestion(QueByID:any):Observable<any>{
    return this.http.put(`${this.baseUrLforQuestion}`,QueByID);
  }

  getCategoryActiceTitleByID(cid:any):Observable<any>{
    return this.http.get(`${this.getCategoryActiceTitleByIDURL}${cid}`);
  }


  getuserByID(userId:any):Observable<any>{
    return this.http.get(`${this.userURl}${userId}`);
  }

  UpdateUserDetails(userDetails:any):Observable<any>{
    return this.http.put(`${this.updateUserById}`,userDetails);
  }


  PostuserIfo(userDetailsAll:any):Observable<any>{
    return this.http.post(`${this.updateUserInfo}`,userDetailsAll);
  }

  

  uploadResumeByiD(resumeFile: File, userID: number): Observable<any> {
    const formData: FormData = new FormData();
    formData.append("file", resumeFile);  
  
    return this.http.put(`${this.uploadFileByID}${userID}`, formData);
  }

  private baseUrlfordwn = 'http://localhost:9003/user/downloadResume';
  private baseUrlforUp = 'http://localhost:9003/user/uploadResume';

  downloadResume(userID: number): Observable<Blob> {
    return this.http.get(`${this.baseUrlfordwn}/${userID}`, {
      responseType: 'blob'
    });
  }


  uploadResume(studentId: number, file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file);

    return this.http.put(`${this.baseUrlforUp}/${studentId}`, formData, {
      responseType: 'text'
    });
  }



  

}
