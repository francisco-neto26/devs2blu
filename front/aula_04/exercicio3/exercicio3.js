// Número aleatório entre 1 e 100
const numeroSecreto = Math.floor(Math.random() * 100) + 1;

let tentativas = 0;

function verificarPalpite() {
  const palpiteInput = document.getElementById('palpite');
  const dicaDiv = document.getElementById('dica');
  const tentativasDiv = document.getElementById('tentativas');

  const palpite = parseInt(palpiteInput.value, 10);

  // Limpa mensagens anteriores
  dicaDiv.textContent = '';
  dicaDiv.className = 'mensagem';
  tentativasDiv.textContent = '';

  if (isNaN(palpite) || palpite < 1 || palpite > 100) {
    dicaDiv.textContent = 'Por favor, informe um número entre 1 e 100.';
    dicaDiv.classList.add('erro');
    return;
  }

  tentativas++;

  const diferenca = Math.abs(palpite - numeroSecreto);

  if (palpite === numeroSecreto) {
    dicaDiv.textContent = `Parabéns! Você acertou o número ${numeroSecreto} em ${tentativas} tentativas!`;
    dicaDiv.classList.add('sucesso');
    tentativasDiv.textContent = '';
  } else {
    if (diferenca <= 5) {
      dicaDiv.textContent = 'Quase!';
    } else if (diferenca <= 10) {
      dicaDiv.textContent = 'Perto!';
    } else if (diferenca <= 20) {
      dicaDiv.textContent = 'Longe!';
    } else {
      dicaDiv.textContent = 'Muito longe!';
    }
    dicaDiv.classList.add('dica');
    tentativasDiv.textContent = `Tentativas: ${tentativas}`;
  }

  palpiteInput.value = '';
  palpiteInput.focus();
}
