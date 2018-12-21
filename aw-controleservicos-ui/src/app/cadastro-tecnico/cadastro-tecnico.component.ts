import { Component, OnInit } from '@angular/core';
import { Tecnico } from '../modelo/tecnico.model';
import { ServicosService } from '../servicos/tecnicos.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cadastro-tecnico',
  templateUrl: './cadastro-tecnico.component.html',
  styleUrls: ['./cadastro-tecnico.component.css']
})
export class CadastroTecnicoComponent implements OnInit {

  tecnico: any;
  id: number;
  tecnicos: Array<Tecnico>;
  mensagem: string;
  erroMsg: string;
  getTecnicos: [];

  constructor(private servicosService: ServicosService, 
    private rota: ActivatedRoute, private _rota: Router) { }

  ngOnInit() {
    this.id = +this.rota.snapshot.paramMap.get('id');
    if(this.id===0){
        this.novoCadastro();
        this._rota.navigate(['/cadastrar', 0]);
       }else{
        this.listar();
    }
  }

  novoCadastro(){
    this.tecnico = {};
  }

  cadastrar(frm: FormGroup){
    this.servicosService.cadastrar(this.tecnico).subscribe(response =>{
       this.tecnico = response;
       frm.reset();
       this.novoCadastro();
       this.mensagem = "Dados cadastrados com sucesso!";
    },
    errorResponse => this.erroMsg = errorResponse);
  }

  alterar(frm: FormGroup){
    this.servicosService.alterar(this.tecnico).subscribe(response =>{
       this.tecnico = response;
       this.mensagem = "Dados alterados com sucesso!";
    },
    errorResponse => this.erroMsg = errorResponse);
  }

  listar(){
    this.servicosService.listar().subscribe(response =>{
       this.tecnicos = response;
       this.tecnico = this.tecnicos[this.id-1];
    },
    errorResponse => this.erroMsg = errorResponse);
  }
}
