import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Information } from '../model/information-model';

@Injectable({
  providedIn: 'root'
})
export class FormViewService {

  uri: string = 'http://localhost:8080/servicoA/resource/';

  constructor(private http: HttpClient) { }

  findCountryById(id:string, page:number):Observable<Information[]>{
      return this.http.get<Information[]>(`${this.uri}/${id}/${page}`);
  }

}
