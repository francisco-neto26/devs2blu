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
