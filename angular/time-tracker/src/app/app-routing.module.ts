import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormComponent } from './form/form.component';
import { TimeTrackerComponent } from './time-tracker/time-tracker.component';
import { SearchComponent } from './search/search.component';


const routes: Routes = [
  { path: "", component: TimeTrackerComponent},
  { path: "form", component: FormComponent},
  { path: "search", component: SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
