import { Component, signal } from '@angular/core';
import { PrimeiroComponente } from "./primeiro-componente/primeiro-componente";
import { DataBindings } from "./data-bindings/data-bindings";
import { ControleFluxo } from "./controle-fluxo/controle-fluxo";
import { Diretivas } from "./diretivas/diretivas";
import { MediaAluno } from "./media-aluno/media-aluno";
import { ConversorMoedas } from "./conversor-moedas/conversor-moedas";
import { ImplementarPipes } from "./implementar-pipes/implementar-pipes";
import { FormularioReativo } from "./formulario-reativo/formulario-reativo";
import { Roteamento } from "./roteamento/roteamento";

@Component({
  selector: 'app-root',
  imports: [ConversorMoedas, ImplementarPipes, FormularioReativo, Roteamento],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('conceitos');
}
