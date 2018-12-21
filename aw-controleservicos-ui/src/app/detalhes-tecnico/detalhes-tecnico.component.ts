import { Component, OnInit } from '@angular/core';
import { Tecnico } from '../modelo/tecnico.model';
import { ServicosService } from '../servicos/tecnicos.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalhes-tecnico',
  templateUrl: './detalhes-tecnico.component.html',
  styleUrls: ['./detalhes-tecnico.component.css']
})
export class DetalhesTecnicoComponent implements OnInit {

  tecnico: Tecnico;
  tecnicos: Array<Tecnico>;
  tecnicosFiltro: Tecnico[];
  id: number;
  qtd: number;
 
  constructor(
    private servicosService: ServicosService, 
    private rota: ActivatedRoute, 
    private _rota: Router
    ) { }

  ngOnInit() {
    this.id = +this.rota.snapshot.paramMap.get('id');
    this.pesquisarTecnicoPorId();
   }

   getTecnico(id: number){
     return this.tecnicosFiltro.find(e=> e.id === id);
   }

  pesquisarTecnicoPorId(){
      this.servicosService.listar().subscribe((response) =>{ 
      this.tecnicos = response;
      this.tecnicosFiltro = this.tecnicos;
      this.qtd = this.tecnicosFiltro.length;
      this.tecnico = this.getTecnico(this.id);
    });
  } 
  
  verDetalhesTecnicoAnterior(){
    this.qtd=this.tecnicos.length;
    this.id = this.id - 1;
    this._rota.navigate(['/detalhes', this.id]);    
  }

  verDetalhesTecnicoProximo(){
    this.qtd=this.tecnicos.length;
    this.id = this.id + 1;
    this._rota.navigate(['/detalhes', this.id]);
  }
 
}
