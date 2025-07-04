const taxas = {
  dolar: 5.20,
  euro: 5.60,
  libra: 6.50,
  bitcoin: 300000
};

window.addEventListener('DOMContentLoaded', () => {
  const select = document.getElementById('tipo');
  for (const option of select.options) {
    const key = option.value;
    if (taxas[key]) {
      option.textContent = `${option.textContent} (${taxas[key]})`;
    }
  }
});

function converter() {
  const valor = parseFloat(document.getElementById('valor').value);
  const tipo = document.getElementById('tipo').value;
  const resultadoDiv = document.getElementById('resultado');

  if (isNaN(valor) || valor < 0) {
    resultadoDiv.textContent = "Por favor, informe um valor válido.";
    return;
  }

  const taxa = taxas[tipo];
  if (!taxa) {
    resultadoDiv.textContent = "Tipo de conversão inválido.";
    return;
  }

  const simbolos = {
    dolar: 'US$',
    euro: '€',
    libra: '£',
    bitcoin: '₿'
  };

  const nomeMoeda = {
    dolar: 'Dólar',
    euro: 'Euro',
    libra: 'Libra',
    bitcoin: 'Bitcoin'
  };

  const convertido = valor / taxa;

  resultadoDiv.textContent = `R$ ${valor.toFixed(2)} equivalem a ${simbolos[tipo]} ${convertido.toFixed(4)} (${nomeMoeda[tipo]})`;
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
