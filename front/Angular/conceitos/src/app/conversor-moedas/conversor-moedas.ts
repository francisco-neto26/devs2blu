import { CurrencyPipe, DecimalPipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Opcao {
  valor: string;
  texto: string;
  valorUnit: number;
}

@Component({
  selector: 'app-conversor-moedas',
  imports: [FormsModule],
  templateUrl: './conversor-moedas.html',
  styleUrl: './conversor-moedas.css'
})
export class ConversorMoedas {

  opcoes: Opcao[] = [
    { valor: 'BTC', texto: 'Bitcoin', valorUnit: 634450.20 },
    { valor: 'US$', texto: 'Dólar', valorUnit: 5.40 },
    { valor: 'EUR', texto: 'Euro', valorUnit: 6.62 },
    { valor: 'ETH', texto: 'Ethereum', valorUnit: 23986.72 },
    { valor: 'GBP', texto: 'Libra', valorUnit: 7.32 },
    { valor: 'JPY', texto: 'Iene', valorUnit: 0.037 }
  ];
  opcaoSelecionadaEntrada: string = '';
  opcaoSelecionadaSaida: string = '';
  valorEntrada: number | undefined = undefined
  valorSaida: number | undefined = undefined

  converter(): void {
    if (this.opcaoSelecionadaEntrada === '' || this.opcaoSelecionadaSaida === '' || this.valorEntrada === undefined) {
      alert("Por favor, preencha todos os campos!")
      return
    }
    for (let index = 0; index < this.opcoes.length; index++) {
      if (this.opcaoSelecionadaEntrada === this.opcoes[index].valor) {
        const opcaoCalculo = this.opcoes[index]
        if (this.valorEntrada != 1 && opcaoCalculo.valor === this.opcaoSelecionadaSaida) {
          this.valorSaida = opcaoCalculo.valorUnit * this.valorEntrada;
        } else {
          let opcaoCalculoSaida: number = 0;          
          for (let index = 0; index < this.opcoes.length; index++) {
            if (this.opcoes[index].valor === this.opcaoSelecionadaSaida) {
              opcaoCalculoSaida = this.opcoes[index].valorUnit;
            }
          }
          if (opcaoCalculo.valorUnit >= opcaoCalculoSaida) {
            this.valorSaida =  opcaoCalculoSaida / opcaoCalculo.valorUnit * this.valorEntrada;
          }else{
            this.valorSaida =  opcaoCalculo.valorUnit / opcaoCalculoSaida * this.valorEntrada;
          }
        }
      }
    }
  }
}
