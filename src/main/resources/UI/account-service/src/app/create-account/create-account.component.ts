import { Component, OnInit } from '@angular/core';
import {CreateAccountService } from '../services/create-account.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  customerId: string;
  initialCredit: number;
  confirm: boolean;
  loading: boolean;

  constructor(private createAccountService: CreateAccountService) { }

  ngOnInit() {
  }

  createAccount(){
    if(this.initialCredit==undefined)
    this.initialCredit =0;
    this.createAccountService.CreateAccountService(this.customerId,this.initialCredit).subscribe(
      data => {
        this.confirm = true;
        console.log(data);
      }
    )

  }

  confirmstatus(){
    this.confirm = false;
  }

}
