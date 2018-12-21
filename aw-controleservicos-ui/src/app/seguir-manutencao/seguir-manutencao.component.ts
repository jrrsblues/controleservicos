import { Component, OnInit } from '@angular/core';
import { AcionamentosService } from '../servicos/acionamentos.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-seguir-manutencao',
  templateUrl: './seguir-manutencao.component.html',
  styleUrls: ['./seguir-manutencao.component.css']
})
export class SeguirManutencaoComponent implements OnInit {

  pesquisaba: number;
  manutencoes: Array<any>;
  ctrltable: boolean;
  ctrlmessage: boolean;

  constructor(private acionamentosService: AcionamentosService ) { }

  ngOnInit() {
    this.pesquisaba = null;
    this.manutencoes = [{}];
    this.ctrltable = false;
    this.ctrlmessage = false;
  }

 listartarefaporba(frm: FormGroup){
    this.acionamentosService.pesquisarmanutencaoporba(this.pesquisaba).subscribe(response=>{
      this.manutencoes = response;
      frm.reset;
      if(this.manutencoes.length>0){
         this.ctrltable = true;
         this.ctrlmessage = false;
       }else{
        this.ctrltable = false;
        this.ctrlmessage = true;
      }
    });
  }

}
