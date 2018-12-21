import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { AcionamentosService } from '../servicos/acionamentos.service';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-atualizar-manutencao',
  templateUrl: './atualizar-manutencao.component.html',
  styleUrls: ['./atualizar-manutencao.component.css']
})


export class AtualizarManutencaoComponent implements OnInit {

  manutencoes: Array<any>;
  tecnicos: Array<any>;
  tecnicosid: number;
  manutencao: any;
  bapesquisa: any;
  cntd: number;
  controle: boolean;
  ctrl2: boolean;
  ctrl3: boolean;
  bloqueio: boolean;

  datePickerConfig: Partial<BsDatepickerConfig>;

  constructor(private acionamentosService: AcionamentosService, private datePipe: DatePipe) {
    this.datePickerConfig = Object.assign({}, { containerClass: 'theme-dark-blue', 
     dateInputFormat: 'DD/MM/YYYY HH:mm:ss' });
  }

  ngOnInit() {
    this.novapesquisa();
  }

  novapesquisa(){
    this.manutencoes = [{}];
    this.manutencao = {};
    this.controle = false;
    this.ctrl2 = true;
    this.ctrl3 = false;
  }

  pesquisaridporufnomeusual(uf: string, tecnico: string){
    this.acionamentosService.pesquisaridporufnomeusual(uf + "-" + tecnico).subscribe(response=>{
     this.tecnicosid=response;
     this.manutencao.idtecnico = this.tecnicosid[0].id;
  });
 }

  pesquisarmanutencaoporba(){
    this.acionamentosService.pesquisarmanutencaoporba(this.bapesquisa).subscribe(response=>{
       this.manutencoes=response;
       this.controle = true;
       this.ctrl2 = true;
       this.bloqueio = false;
       this.ctrl3 = false;
       this.cntd = this.manutencoes.length;
       this.manutencao = this.manutencoes[0];
       if(this.manutencoes[0].datachegadanosite!=null){
          this.manutencao.datachegadanosite = this.datePipe.transform(this.manutencoes[0].datachegadanosite, 'dd/MM/yyyy HH:mm:ss'); 
       }
       if(this.manutencoes[0].datasaidadosite!=null){
          this.manutencao.datasaidadosite = this.datePipe.transform(this.manutencoes[0].datasaidadosite, 'dd/MM/yyyy HH:mm:ss');
       } 

       if(this.manutencao!=null){
        this.ctrl3 = true;
       }
       if(this.cntd === 0){
          this.novapesquisa();
          this.ctrl2 = false;
          this.bloqueio = false;
        }else{
         var i;
         for(i=0;i<this.cntd;i++){
            this.ctrl3 = true;
            if(i===0){
              this.manutencoes[0].datahorastatus = this.datePipe.transform(this.manutencoes[0].datahorastatus, 'dd/MM/yyyy HH:mm:ss'); 
            }
            if(i>0){
             if(this.manutencoes[i].datahorastatus!=null){
                this.manutencoes[i].datahorastatus = this.datePipe.transform(this.manutencoes[i].datahorastatus, 'dd/MM/yyyy HH:mm:ss'); 
             }
             if(this.manutencoes[i].datachegadanosite!=null){
               this.manutencoes[i].datachegadanosite = this.datePipe.transform(this.manutencoes[i].datachegadanosite, 'dd/MM/yyyy HH:mm:ss'); 
             }
             if(this.manutencoes[i].datasaidadosite!=null){
              this.manutencoes[i].datasaidadosite = this.datePipe.transform(this.manutencoes[i].datasaidadosite, 'dd/MM/yyyy HH:mm:ss'); 
             }
            }
         }
         if(this.manutencao.status==='Finalizada'){
          this.bloqueio = true;
         }
       }
    });
  }

  pesquisartecnico(uf: any){
    this.acionamentosService.pesquisartecnico(uf).subscribe(response=>this.tecnicos=response);
  }

  alterarmanutencao(frm){
    this.manutencao.datahorastatus=null;
    if(this.manutencao.datachegadanosite!=null){
      this.manutencao.datachegadanosite = this.datePipe.transform(this.manutencao.datachegadanosite, 'HH:mm:ss yyyy-MM-dd'); 
    }
    //if(this.manutencao.datasaidadosite!=null){
      //this.manutencao.datasaidadosite = this.datePipe.transform(this.manutencao.datasaidadosite, 'HH:mm:ss yyyy-MM-dd'); 
    //}
    this.acionamentosService.alterarmanutencao(this.manutencao).subscribe(response=>
      {
        this.manutencao = response;
        this.pesquisarmanutencaoporba();
      });
  }
}
