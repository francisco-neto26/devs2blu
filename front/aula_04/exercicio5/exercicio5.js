function calcularFatorial() {
  const input = document.getElementById('numero');
  const resultadoDiv = document.getElementById('resultado');
  const numero = parseInt(input.value, 10);

  resultadoDiv.className = 'mensagem'; // limpa classes anteriores

  if (isNaN(numero) || numero < 0) {
    resultadoDiv.textContent = 'Por favor, informe um número inteiro positivo ou zero.';
    return;
  }

  let fatorial = 1;

  for (let i = 2; i <= numero; i++) {
    fatorial *= i;
  }

  resultadoDiv.textContent = `O fatorial de ${numero} é ${fatorial}.`;
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