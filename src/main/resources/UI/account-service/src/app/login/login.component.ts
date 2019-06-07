import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormsModule,FormGroup,FormBuilder,Validators,ReactiveFormsModule }   from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  returnUrl: string;
  loginError: string;
  invalidLogin: boolean = false;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    
) { }

  ngOnInit() {
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
}

login() {
    console.log(this.model.username);
    console.log(this.model.password);
    this.loading = true;


     if(this.model.username == 'admin' && this.model.password == 'admin') {
     this.router.navigate(['/header']);
           }
           else {
   this.invalidLogin = true;
 }
    
}
}
