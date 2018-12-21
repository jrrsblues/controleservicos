import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError  } from 'rxjs';
import { Tecnico } from '../modelo/tecnico.model';
import { catchError } from 'rxjs/operators';
import { FormGroup } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class ServicosService {

  private api = 'http://localhost:8080';

  private mensagem: string;

  constructor(private http: HttpClient) { }

  listar(): Observable<Tecnico[]>{
    return this.http.get<any>(`${this.api}/tecnico`).pipe(catchError(this.handleError));        
  }

  listarid(): Observable<any>{
    return this.http.get<any>(`${this.api}/retornar/1`);
  }

  cadastrar(tecnico: Tecnico): Observable<any>{
    return this.http.post<Tecnico>(`${this.api}/tecnico`,tecnico)
    .pipe(catchError(this.handleError));
  }

  alterar(tecnico: Tecnico): Observable<any>{
    return this.http.put<Tecnico>(`${this.api}/tecnico`,tecnico)
    .pipe(catchError(this.handleError));
  }

  handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
        this.mensagem = 'Problemas do lado cliente :' + errorResponse.message + ". Por gentileza, Contatar tecnico.";
    } else {
        this.mensagem = 'Problemas do lado servidor :' + errorResponse.message + ". Por gentileza, Contatar adm.";
    }
    // return an observable with a meaningful error message to the end user
    return throwError(this.mensagem);
  }

}
