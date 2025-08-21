import { Component } from '@angular/core';

@Component({
  selector: 'app-data-bindings',
  imports: [],
  templateUrl: './data-bindings.html',
  styleUrl: './data-bindings.css'
})
export class DataBindings {
  imagem:string = 'img1.jpg';

  funcao(): void {
    if(this.imagem === 'img1.jpg'){
      this.imagem = 'img2.jpg';
    }else{
      this.imagem = 'img1.jpg';
    }
  }
}
