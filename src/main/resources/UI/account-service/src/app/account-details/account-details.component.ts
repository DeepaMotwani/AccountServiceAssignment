import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {
  title = 'GetData';
  customerId  : string;
  constructor (private httpService: HttpClient) { }
  cutomerData: any;
  errorscreen:boolean;

  ngOnInit () {
    
  }

  getDetails(){
    this.httpService.get('http://localhost:8080/AccountService/api/getCustomerDetails/'+this.customerId).subscribe(
      data => {
         console.log(data);
         if(data!=null){
         this.cutomerData = data;
        }else{
          this.errorscreen = true;
        }
      },
      (err: HttpErrorResponse) => {
        console.log (err.message);
        this.errorscreen = true;
      }
    );
  }

  errorstatus()
{
  this.errorscreen = false;
}
}