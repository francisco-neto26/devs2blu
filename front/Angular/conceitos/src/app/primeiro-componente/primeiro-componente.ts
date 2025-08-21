import { Component } from '@angular/core';

@Component({
  selector: 'app-primeiro-componente',
  imports: [],
  templateUrl: './primeiro-componente.html',
  styleUrl: './primeiro-componente.css'
})
export class PrimeiroComponente {
  //variavel
  texto: string = 'Aprendendo Angular';

  //Função para retornar um texto
  funcaoTexto(): string {
    return 'Exibindo um texto via função';
  }

}
