import { Component, OnInit } from '@angular/core';
import { TimeTrackerService } from '../time-tracker.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  categories: any[] = []
  
  constructor(private timeTrackerService: TimeTrackerService) { }

  ngOnInit() {
    this.timeTrackerService.getCatalog().subscribe((categories) => {
      this.categories = categories as any[]
    })
  }

}
