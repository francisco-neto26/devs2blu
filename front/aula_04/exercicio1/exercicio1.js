function calcularMedia() {
  const n1 = parseFloat(document.getElementById('nota1').value);
  const n2 = parseFloat(document.getElementById('nota2').value);
  const n3 = parseFloat(document.getElementById('nota3').value);
  const resultadoDiv = document.getElementById('resultado');

  // Limpa classes anteriores
  resultadoDiv.className = "mensagem";

  // Verifica se todas são números válidos
  if (isNaN(n1) || isNaN(n2) || isNaN(n3)) {
    resultadoDiv.textContent = "Por favor, preencha todas as notas corretamente.";
    resultadoDiv.classList.add("erro");
    return;
  }

  // Verifica se estão dentro de 0 a 10
  if ([n1, n2, n3].some(nota => nota < 0 || nota > 10)) {
    resultadoDiv.textContent = "As notas devem estar entre 0 e 10.";
    resultadoDiv.classList.add("erro");
    return;
  }

  // Calcula média
  const media = (n1 + n2 + n3) / 3;
  let situacao = '';
  let classe = '';

  if (media >= 7) {
    situacao = 'Aprovado';
    classe = 'sucesso';
  } else if (media >= 5) {
    situacao = 'Recuperação';
    classe = 'atencao';
  } else {
    situacao = 'Reprovado';
    classe = 'erro';
  }

  resultadoDiv.textContent = `Média: ${media.toFixed(2)} - Situação: ${situacao}`;
  resultadoDiv.classList.add(classe);
}

document.addEventListener('DOMContentLoaded', function() {
    let botoes = document.querySelectorAll('.container button');
    
    botoes.forEach(function(botao) {
        botao.addEventListener('mouseenter', function() {
            this.style.transform = 'scale(1.05)';
        });
        
        botao.addEventListener('mouseleave', function() {
            this.style.transform = 'scale(1)';
        });
    });
});
