import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {DatePipe} from '@angular/common';

import { HttpClientModule } from '@angular/common/http';
import { ListarTecnicoComponent } from './listar-tecnico/listar-tecnico.component';
import { CadastroTecnicoComponent } from './cadastro-tecnico/cadastro-tecnico.component';
import { DetalhesTecnicoComponent } from './detalhes-tecnico/detalhes-tecnico.component';
import { TecnicoFilterPipe } from './servicos/tecnico-filter.pipe';
import { AbrirAcionamentoComponent } from './abrir-acionamento/abrir-acionamento.component';
import { CadastroManutencaoComponent } from './cadastro-manutencao/cadastro-manutencao.component';
import { SeguirManutencaoComponent } from './seguir-manutencao/seguir-manutencao.component';
import { AtualizarManutencaoComponent } from './atualizar-manutencao/atualizar-manutencao.component';

registerLocaleData(localePt);

const appRouters: Routes = [
  {
    path: 'listar', 
    component: ListarTecnicoComponent
  },
  {
    path: 'cadastrar/:id', 
    component: CadastroTecnicoComponent
  },
  {
    path: 'manutencao/:id', 
    component: CadastroManutencaoComponent
  },
  {
    path: 'detalhes/:id', 
    component: DetalhesTecnicoComponent
  },
  {
    path: 'abriracionamento', 
    component: AbrirAcionamentoComponent
  },
  {
    path: 'atualizarmanutencao/:id', 
    component: AtualizarManutencaoComponent
  },
  {
    path: 'seguirmanutencao', 
    component: SeguirManutencaoComponent
  },
  {
    path: '', 
    redirectTo: 'listar', 
    pathMatch: 'full'
  } 
  
]

@NgModule({
  declarations: [
    AppComponent,
    ListarTecnicoComponent,
    CadastroTecnicoComponent,
    DetalhesTecnicoComponent,
    TecnicoFilterPipe,
    AbrirAcionamentoComponent,
    CadastroManutencaoComponent,
    SeguirManutencaoComponent,
    AtualizarManutencaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRouters),
    BsDatepickerModule.forRoot(),
    FormsModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' }, DatePipe
  ],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
