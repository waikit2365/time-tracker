import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { DateTimePickerModule } from '@syncfusion/ej2-angular-calendars';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimeTrackerComponent } from './time-tracker/time-tracker.component';
import { FormComponent } from './form/form.component';
import { SearchComponent } from './search/search.component';
import { SearchBodyComponent } from './search-body/search-body.component';

@NgModule({
  declarations: [
    AppComponent,
    TimeTrackerComponent,
    FormComponent,
    SearchComponent,
    SearchBodyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    DateTimePickerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
