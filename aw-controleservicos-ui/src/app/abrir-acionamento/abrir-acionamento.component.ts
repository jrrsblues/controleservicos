import { Component, OnInit } from '@angular/core';
import { AcionamentosService } from '../servicos/acionamentos.service';
import { FormGroup } from '@angular/forms';
import { Acionamento } from '../modelo/acionamento.model';
import { Tecnico } from '../modelo/tecnico.model';
import { Site } from '../modelo/site.model';
import { Manutencao } from '../modelo/manutencao.model';
import { Router, NavigationStart, NavigationEnd,
  NavigationCancel, NavigationError, Event} from '@angular/router';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-abrir-acionamento',
  templateUrl: './abrir-acionamento.component.html',
  styleUrls: ['./abrir-acionamento.component.css']
})
export class AbrirAcionamentoComponent implements OnInit {

  id: number;
  acionamento: any;
  acionamentos: Array<Acionamento>;
  tecnicos: Array<Tecnico>;
  tecnicosid: Array<Tecnico>;
  manutencao: any;
  manutencoes: Array<Manutencao>;
  sites: Array<Site>;
  ctrltecnico: boolean;
  cadastroacionamento: boolean;
  pesquisarbaexistente: boolean;
  _idtecnico: number;

  datePickerConfig: Partial<BsDatepickerConfig>;

  constructor(private acionamentosService: AcionamentosService, private rota: Router) { 
    this.datePickerConfig = Object.assign({}, { containerClass: 'theme-dark-blue', 
     dateInputFormat: 'DD/MM/YYYY HH:mm:ss' });
  }

  ngOnInit() {
    this.novocadastro();
  }

  novocadastro(){
    this.acionamento = {};
    this.tecnicos = [];
    this.tecnicosid = [];
    this.acionamento.operador = "JRRS";
    this.ctrltecnico = false;
    this.cadastroacionamento = false;
  }
  
  pesquisarmanutencaoporba(ba: any){
    this.acionamentosService.pesquisarmanutencaoporba(ba).subscribe(response=>{
      this.acionamentos = response;
        if(this.acionamentos.length>0){
             this.pesquisarbaexistente = true;
             this.acionamento.ba = "";
           }else{
             this.pesquisarbaexistente = false;
        };
    });
  }

  abriracionamento(frm: FormGroup){
    this.acionamentosService.cadastraracionamento(this.acionamento).subscribe(response=>{
       this.acionamento = response;
       frm.reset();
       this.chamarManutencaoCadastro(this.acionamento.id);
    });
  }

  pesquisartecnico(uf: any){
    this.acionamentosService.pesquisartecnico(uf).subscribe(response=>this.tecnicos=response);
  }

  pesquisarsiteporuf(uf: any){
    this.acionamentosService.pesquisarsite(uf).subscribe(response=>{
      this.sites=response;
    });
  }

  listarmanutencao(ba: any){
    this.acionamentosService.listarmanutencao(ba).subscribe(response=>this.manutencoes=response);
  }

  pesquisaridporufnomeusual(uf: string, tecnico: string){
     this.acionamentosService.pesquisaridporufnomeusual(uf + "-" + tecnico).subscribe(response=>{
      this.tecnicosid=response;
      this.acionamento.idtecnico = this.tecnicosid[0].id;
      this.ctrltecnico = true;
     });
  }

  chamarManutencaoCadastro(id: number){
    this.novocadastro();
    this.rota.navigate(['/manutencao', id]);
  }

}
