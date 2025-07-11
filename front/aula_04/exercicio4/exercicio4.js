function gerarTabuada() {
  const numero = parseInt(document.getElementById('numero').value, 10);
  const resultadoDiv = document.getElementById('resultado');

  resultadoDiv.innerHTML = '';
  resultadoDiv.className = 'mensagem';

  if (isNaN(numero)) {
    resultadoDiv.textContent = 'Por favor, informe um número válido.';
    resultadoDiv.classList.add('erro');
    return;
  }

  const lista = document.createElement('ul');

  for (let i = 1; i <= 10; i++) {
    const item = document.createElement('li');
    item.textContent = `${numero} x ${i} = ${numero * i}`;
    lista.appendChild(item);
  }

  resultadoDiv.appendChild(lista);
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