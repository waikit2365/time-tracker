import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { TimeTrackerService } from '../time-tracker.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  scheduleForm = new FormGroup({
    category: new FormControl(),
    description: new FormControl(),
    startAt: new FormControl(),
    endAt: new FormControl(),
    planActual: new FormControl()
  })
  

  constructor(private timeTrackerService: TimeTrackerService) { }

  ngOnInit() {
  }

  onSubmit(){
    const formValues = this.scheduleForm.value
    // console.log(formValues)
    this.timeTrackerService.submit(
      formValues.category,
      formValues.description,
      formValues.startAt,
      formValues.endAt,
      formValues.planActual
    ).subscribe(response => {
      console.log(response)
    })
  }

}
