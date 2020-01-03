import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const BASE_URL = "serviceEndPoint"

@Injectable({
  providedIn: 'root'
})
export class TimeTrackerService {

  constructor(private http:HttpClient) { }

  submit(category, description, startAt, endAt, planActual){
    const params = {
      category: category,
      description: description,
      startAt: startAt,
      endAt: endAt,
      planActual: planActual,
    }

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    }
    return this.http.post(`${BASE_URL}/schedule/`, params, httpOptions)
  }
}
