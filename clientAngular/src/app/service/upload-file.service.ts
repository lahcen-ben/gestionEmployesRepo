import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employe} from '../model/Employe';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(private http: HttpClient) { }

  stockerFichier(file: File): Observable<HttpEvent<{}>> {

    const dataform: FormData = new FormData();

    dataform.append('file', file);

    const req = new HttpRequest('POST', '/charger', dataform, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }
}
