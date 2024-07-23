import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-select-company',
  templateUrl: './select-company.component.html',
  styleUrls: ['./select-company.component.css'],
})
export class SelectCompanyComponent {
  selectedCompany: string | null = null;
  companies = ['FedEx', 'Cook Systems', 'Google'];

  constructor(private router: Router) {}

  onSelectCompany(event: Event): void {
    const selectElement = event.target as HTMLSelectElement;
    this.selectedCompany = selectElement.value;
    if (this.selectedCompany) {
      localStorage.setItem('selectedCompany', this.selectedCompany); //save company in local storage & and goto home/announcemnets page -Devin
      this.router.navigate(['/home-announcements']); 
    }
  }
}
