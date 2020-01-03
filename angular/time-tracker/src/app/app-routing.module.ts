import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormComponent } from './form/form.component';
import { TimeTrackerComponent } from './time-tracker/time-tracker.component';


const routes: Routes = [
  { path: "", component: TimeTrackerComponent},
  { path: "form", component: FormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
