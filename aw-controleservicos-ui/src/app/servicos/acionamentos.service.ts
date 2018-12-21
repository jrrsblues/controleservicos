import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Acionamento } from '../modelo/acionamento.model';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AcionamentosService {

  private api = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  abriracionamento(acionamento: Acionamento): Observable<any>{
    return this.http.post<any>(`${this.api}/acionamento`, acionamento);
  }

  listar():Observable<any>{
    return this.http.get<any>('${this.api}/tecnico');
  }

  pesquisarsite(uf: string): Observable<any>{
    return this.http.get<any>(`${this.api}/retornarsite/${uf}`);
  }

  pesquisaridporufnomeusual(uftecnico: string): Observable<any>{
    return this.http.get<any>(`${this.api}/retornaridporuftecnico/${uftecnico}`);
  }

  pesquisartecnico(uf: string): Observable<any>{
    return this.http.get<any>(`${this.api}/retornartecnico/${uf}`);
  }

  pesquisaracionamento(id: any): Observable<any>{
    return this.http.get<any>(`${this.api}/acionamento/${id}`);
  }

  cadastraracionamento(acionamento: any): Observable<any>{
    return this.http.post<any>(`${this.api}/acionamento`,acionamento);
  }

  listarmanutencao(ba: string):Observable<any>{
     return this.http.get<any>(`${this.api}/manutencao/${ba}`);
  }

  pesquisarmanutencao(id: any): Observable<any>{
    return this.http.get<any>(`${this.api}/manutencao/${id}`);
  }

  pesquisarmanutencaoporba(ba: any): Observable<any>{
    return this.http.get<any>(`${this.api}/manutencoes/${ba}`);
  }

  fecharmanutencao(manutencao: any): Observable<any>{
    return this.http.put<any>(`${this.api}/manutencao`,manutencao);
  }

  alterarmanutencao(manutencao:any): Observable<any>{
      var str = manutencao.datachegadanosite; 
      if(manutencao.datachegadanosite!=null){
       str = str.toString( );
       manutencao.datachegadanosite = new Date(str);
      }
      if(manutencao.datasaidadosite!=null){
       str = manutencao.datasaidadosite; 
       str = str.toString( );
      }
      return this.http.post<any>(`${this.api}/manutencoes`,manutencao);
  }
  
}
