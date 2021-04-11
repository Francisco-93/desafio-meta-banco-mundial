import { Information } from './../model/information-model';
import { FormViewService } from './form-view.service';
import { COUNTRY_OPTIONS } from './../model/country-options';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSelectChange } from '@angular/material/select';
import { YEARS_OPTIONS } from '../model/yars-options';


@Component({
  selector: 'app-form-view',
  templateUrl: './form-view.component.html',
  styleUrls: ['./form-view.component.css']
})
export class FormViewComponent implements OnInit {

  public countryOptions = COUNTRY_OPTIONS;

  public yearsOptions = YEARS_OPTIONS;

  public selectedName: string = '';

  public selectedYear: string = '';

  private page: number;
  private id: string;

  public informations: Information[] = [];

  country: FormGroup;

  constructor(private fb: FormBuilder, private service: FormViewService) { }

  displayedColumns: string[] = ['countryName', 'date', 'poorPopulation'];

  ngOnInit(): void {
    
    this.country = this.fb.group({
      countryName: [null],
      date: [null],
      poorPopulation: [null]
    })
  }

  linkInputCountry(event: MatSelectChange): void{
    this.selectedName = event.value.value;
    console.log(this.selectedName);
    this.id = event.value.id;
  }

  linkInputYears(event: MatSelectChange): void{
    this.selectedYear = event.value;
    console.log(this.selectedYear);
    let intYear = parseInt(this.selectedYear);
    if(intYear > 1970){
      this.page = 1;
    }
    else{
      this.page = 2;
    }
  }

  getInformations(){
    this.informations = [];
    let aux = []
    this.service.findCountryById(this.id, this.page).subscribe(res => {
      this.informations =res;
      res.forEach(obj => {
        if(obj.date == this.selectedYear){
          aux.push(obj);
          if(obj.poorPopulation == null){
            aux[0].poorPopulation = "Não Informado";
          }
        }
      })
      this.informations = aux;
    })

    console.log(this.informations);
  }

}
