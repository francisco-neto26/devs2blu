import { DecimalPipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Aluno {
  nome: string;
  nota1: number;
  nota2: number;
  nota3: number;
  media: number;
  situacao: string; // 'Aprovado' ou 'Reprovado'
}

@Component({
  selector: 'app-media-aluno',
  imports: [FormsModule, DecimalPipe],
  templateUrl: './media-aluno.html',
  styleUrl: './media-aluno.css'
})

export class MediaAluno {
  nomeAluno = '';
  alunos: Aluno[] = [];
  nota1: number | undefined = undefined
  nota2: number | undefined = undefined
  nota3: number | undefined = undefined
  media = 0;
  situacao = "";
  aprovados = 0;
  reprovados = 0;
  calculado = false;

  calcularMedia() {
    if (this.nota1 === undefined || this.nota2 === undefined || this.nota3 === undefined) {
      alert("Por favor, preencha todas as notas!")
      return
    }

    this.media = (this.nota1 + this.nota2 + this.nota3) / 3

    if (this.media >= 7) {
      this.situacao = "Aprovado"
      this.aprovados++
    } else {
      this.situacao = "Reprovado"
      this.reprovados++
    } 
    
    const novoAluno: Aluno = {
      nome: this.nomeAluno,
      nota1: this.nota1,
      nota2: this.nota2,
      nota3: this.nota3,
      media: this.media,
      situacao: this.situacao,
    }

    this.alunos.push(novoAluno)

    this.nomeAluno = ""
    this.nota1 = 0
    this.nota2 = 0
    this.nota3 = 0

    this.calculado = true
  } 

}
