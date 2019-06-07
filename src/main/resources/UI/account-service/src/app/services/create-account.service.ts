import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CreateAccountService {

  constructor(private http: HttpClient) { }

  CreateAccountService(customerId: string, initialCredit: number){
    var headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.http.post<any>('http://localhost:8080/AccountService/api/addCustomerAccount/'+customerId+'/'+initialCredit,{},{headers}).pipe(tap(data =>
           {
          console.log(data);
           return data;
         }));
  }
}
