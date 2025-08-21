import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { EventoMouse } from '../minha-diretiva/evento-mouse';

@Component({
  selector: 'app-diretivas',
  imports: [CommonModule, EventoMouse],
  templateUrl: './diretivas.html',
  styleUrl: './diretivas.css'
})
export class Diretivas {

  alunos: string[] = ['aprovado', 'aprovado', 'reprovado', 'aprovado']

  corFonte: string = 'yellow';
  corFundo: String = 'green';

  estilo = {
    'color': this.corFonte,
    'background-color': this.corFundo
  };

  alterarEstilo(): void {
    this.corFonte = this.corFonte === 'yellow' ? 'blue' : 'yellow';
    this.corFundo = this.corFundo === 'green' ? 'red' : 'green';
    this.estilo = {
      'color': this.corFonte,
      'background-color': this.corFundo
    }
  }
}

  
  
