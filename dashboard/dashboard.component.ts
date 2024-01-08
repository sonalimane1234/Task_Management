import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms'

import {Router} from '@angular/router'; 
// import { Task } from '../model/front_Asscss';
import { TaskManegService } from '../task-maneg.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  task: any;
  taskDetail!: FormGroup<any>;
  TaskManegService: any;
editTask(_t26: Task) {
throw new Error('Method not implemented.');
}
addtask() {
throw new Error('Method not implemented.');
}
      
 
updatetask() {
  throw new Error('Method not implemented.');
  }
  
    TaskDetail! : FormGroup ;
    TaskObj : Task = new Task(); //customerObj is the object of Customer Class
    TaskList : Task[] = [];
    TaskService: any;
  
    constructor(private formBuilder : FormBuilder, private router: Router) {}

    ngOnInit(): void {
      this.getAllCustomer();
  
      this.TaskDetail =new FormGroup({
        id: new FormControl('',[Validators.required]),
        Taskname: new FormControl('',[Validators.required,Validators.pattern('^[A-Za-z]*$')]),
        lastTask: new FormControl('',[Validators.required,Validators.pattern('^[A-Za-z]*$')]),
        // menu: new FormControl('',[Validators.required,Validators.pattern('^[A-Za-z]*$')]),
        Time: new FormControl('',[Validators.required]),
        });
  }
  clickLogout()
  {
    console.log("Successfully Logged out");  
    this.router.navigate (['/logout']);  
  }
  // validation .....................................................
  loginUser()
  {
    console.warn(this.TaskDetail.value)
  }
  get id()
  {
    return this.TaskDetail.get('id');
  }
  get taskname()
  {
    return this.TaskDetail.get('taskname');
  }
  get lasttask()
  {
    return this.TaskDetail.get('lasttask');
  }
  // get menu()
  // {
  //   return this.TaskDetail.get('menu');
  // }
  get time()
  {
    return this.TaskDetail.get('time');
  }
  // ........................................................
  
    // add customer
  
    addCustomer()  {
      console.log(this.TaskDetail);
      this.TaskObj.id = this.TaskDetail.value.id;
      this.TaskObj.firstname = this.TaskDetail.value.firstname;
      this.TaskObj.lastname = this.TaskDetail.value.lastname;
      this.TaskObj.menu = this.TaskDetail.value.menu;
      this.TaskObj.price = this.TaskDetail.value.price;
    
    //declaring the method and passing the customer object
    this.task-TaskManegService.addtask(this.TaskObj).subscribe((res: any)=>{
      console.log(res);
      this.getAllCustomer();
      },(err: any)=>{
      console.log(err);
      });
    }
    // get  all customer
  getAllCustomer() {
    this.TaskManegService.getAlltask().subscribe((res: Task[])=>{
       this.TaskList =res;
      },(err: any)=>{
      console.log("error while fetching data");
     })
    }
  
    // edit customer
  editCustomerr(custom : Task)
  {
     this.TaskDetail.controls['id'].setValue(custom.id);
     this.TaskDetail.controls['firstname'].setValue(custom.taskname);
     this.TaskDetail.controls['lastname'].setValue(custom.lasttask);
    //  this.TaskDetail.controls['menu'].setValue(custom.menu);
     this.TaskDetail.controls['price'].setValue(custom.Time);
  }
  
  // update customer
  UpdateCustomer(){
    this.TaskObj.id = this.TaskDetail.value.id;
    this.TaskObj.firstname = this.TaskDetail.value.firstname;
    this.TaskObj.lastname = this.TaskDetail.value.lastname;
    this.TaskObj.menu = this.TaskDetail.value.menu;
    this.TaskObj.price = this.TaskDetail.value.price;
  
    this.TaskManegService.updateCustomer(this.TaskObj).subscribe((res: any)=>{
      console.log(res);
      this.getAllCustomer();
    },(err: any)=>{
      console.log(err);
    })
  }
    
  deleteTask(custom : Task){
    this.task-TaskManegService.deleteTask(custom).subscribe((res: any)=>{
      console.log(res);
      alert("Task Profile Deleted Successfully");
      this.getAllCustomer();
    },(err: any)=>{
      console.log(err);
    });
  }
  }
  
  
  