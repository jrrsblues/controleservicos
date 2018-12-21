import { Component, OnInit } from '@angular/core';
import { ServicosService } from '../servicos/tecnicos.service';
import { Tecnico } from '../modelo/tecnico.model';
import { Router, NavigationStart, NavigationEnd,
  NavigationCancel, NavigationError, Event} from '@angular/router';


@Component({
  selector: 'app-listar-tecnico',
  templateUrl: './listar-tecnico.component.html',
  styleUrls: ['./listar-tecnico.component.css']
})
export class ListarTecnicoComponent implements OnInit {

  tecnicos: Array<Tecnico>;
  tecnico: Tecnico;
  tecnicosFiltros: Tecnico[];
  erroMsg: string;
  showLoadingIndicator: boolean;

  private _pesquisar: string;
  get pesquisar(): string{
    return this._pesquisar;
  }
  set pesquisar(value: string){
    this._pesquisar = value;
    this.tecnicosFiltros = this.tecnicoFiltrado(value);
  }

  tecnicoFiltrado(pesquisaTecnico: string){
    return this.tecnicos.filter(tecnico =>
      tecnico.nomecompleto.toLowerCase().indexOf(pesquisaTecnico.toLowerCase()) !== -1);
  }
 
  qtd: number;

  constructor(private servicosService: ServicosService, private rota: Router) { 
    
    this.rota.events.subscribe((routerEvent: Event) => {

      if (routerEvent instanceof NavigationStart) {
        this.showLoadingIndicator = true;
      }

      if (routerEvent instanceof NavigationEnd ||
        routerEvent instanceof NavigationError ||
        routerEvent instanceof NavigationCancel) {
         this.showLoadingIndicator = false;
      }

    });
  }

  ngOnInit() {
    this.listarTodosTecnicos();
  }

  listarTodosTecnicos(){
      this.servicosService.listar().subscribe((response) =>{
      this.tecnicos = response;
      this.tecnicosFiltros = this.tecnicos;
      this.qtd = this.tecnicosFiltros.length;
    },
    errorResponse => this.erroMsg = errorResponse);
  }

  listarid(){
    this.servicosService.listarid().subscribe(response => this.tecnico = response,
      errorResponse => this.erroMsg = errorResponse);
  }

  verDetalhesTecnico(id: number){
    this.rota.navigate(['/detalhes',id]);
  }

  alterarDadosTecnicos(id: number){
    this.rota.navigate(['/cadastrar',id]);
  }

}
