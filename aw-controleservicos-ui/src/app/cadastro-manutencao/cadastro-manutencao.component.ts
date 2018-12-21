import { Component, OnInit } from '@angular/core';
import { AcionamentosService } from '../servicos/acionamentos.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cadastro-manutencao',
  templateUrl: './cadastro-manutencao.component.html',
  styleUrls: ['./cadastro-manutencao.component.css']
})
export class CadastroManutencaoComponent implements OnInit {

  manutencao: any;
  id: number;

  constructor(private acionamentosService: AcionamentosService, 
    private rota: ActivatedRoute, private _rota: Router) { }

  ngOnInit() {
    this.id = +this.rota.snapshot.paramMap.get('id');
    this.pesquisarmanutencao(this.id);
    this.manutencao = {};
  }

  pesquisarmanutencao(id: number){
    this.acionamentosService.pesquisarmanutencao(id)
       .subscribe(response=>this.manutencao = response);
  }

  fecharmanutencao(frm: FormGroup){
    this.acionamentosService.fecharmanutencao(this.manutencao).subscribe((response)=>{
      this.manutencao=response;
      this._rota.navigate(['/atualizarmanutencao', this.manutencao.id]);
    });
  }

}
