function calcularIMC() {
  const peso = parseFloat(document.getElementById('peso').value);
  const altura = parseFloat(document.getElementById('altura').value);
  const resultadoDiv = document.getElementById('resultado');

  resultadoDiv.className = 'mensagem';

  if (isNaN(peso) || isNaN(altura) || peso <= 0 || altura <= 0) {
    resultadoDiv.textContent = 'Por favor, informe peso e altura válidos.';
    return;
  }

  const imc = peso / (altura * altura);
  let classificacao = '';
  let estilo = {};

  if (imc < 18.5) {
    classificacao = 'Abaixo do peso';
    estilo = {
      backgroundColor: '#D6EAF8',
      color: '#154360',
      border: '2px solid #5DADE2'
    };
  } else if (imc < 25) {
    classificacao = 'Peso normal';
    estilo = {
      backgroundColor: '#D4EFDF',
      color: '#1E8449',
      border: '2px solid #27AE60'
    };
  } else if (imc < 30) {
    classificacao = 'Sobrepeso';
    estilo = {
      backgroundColor: '#FCF3CF',
      color: '#B7950B',
      border: '2px solid #F1C40F'
    };
  } else if (imc < 35) {
    classificacao = 'Obesidade grau 1';
    estilo = {
      backgroundColor: '#FDEBD0',
      color: '#BA4A00',
      border: '2px solid #E67E22'
    };
  } else if (imc < 40) {
    classificacao = 'Obesidade grau 2';
    estilo = {
      backgroundColor: '#FADBD8',
      color: '#922B21',
      border: '2px solid #E74C3C'
    };
  } else {
    classificacao = 'Obesidade grau 3';
    estilo = {
      backgroundColor: '#F5B7B1',
      color: '#641E16',
      border: '2px solid #922B21'
    };
  }

  resultadoDiv.textContent = `Seu IMC é ${imc.toFixed(2)} - ${classificacao}`;
  resultadoDiv.style.backgroundColor = estilo.backgroundColor;
  resultadoDiv.style.color = estilo.color;
  resultadoDiv.style.border = estilo.border;
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