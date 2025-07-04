function verificarBissexto() {
  const ano = parseInt(document.getElementById('ano').value, 10);
  const resultadoDiv = document.getElementById('resultado');

  resultadoDiv.className = 'mensagem';

  if (isNaN(ano) || ano <= 0) {
    resultadoDiv.textContent = 'Por favor, informe um ano válido.';
    return;
  }

  const bissexto =
    (ano % 4 === 0 && ano % 100 !== 0) || (ano % 400 === 0);

  resultadoDiv.textContent = bissexto
    ? `O ano ${ano} é bissexto.`
    : `O ano ${ano} não é bissexto.`;
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