const perguntas = [
  {
    pergunta: "Qual é a capital do Brasil?",
    alternativas: ["São Paulo", "Brasília", "Rio de Janeiro", "Salvador"],
    correta: 1
  },
  {
    pergunta: "Qual é o maior planeta do sistema solar?",
    alternativas: ["Terra", "Saturno", "Júpiter", "Marte"],
    correta: 2
  },
  {
    pergunta: "Qual linguagem é usada para criar páginas web?",
    alternativas: ["HTML", "Python", "C++", "Java"],
    correta: 0
  },
  {
    pergunta: "Em que continente fica o Egito?",
    alternativas: ["Ásia", "Europa", "África", "América"],
    correta: 2
  },
  {
    pergunta: "Quem pintou a Mona Lisa?",
    alternativas: ["Van Gogh", "Leonardo da Vinci", "Michelangelo", "Picasso"],
    correta: 1
  },
  {
    pergunta: "Qual é o símbolo químico da água?",
    alternativas: ["O2", "H2O", "HO", "OH"],
    correta: 1
  },
  {
    pergunta: "Quantos segundos tem 1 hora?",
    alternativas: ["360", "3600", "600", "60"],
    correta: 1
  },
  {
    pergunta: "Qual é o menor número primo?",
    alternativas: ["0", "1", "2", "3"],
    correta: 2
  },
  {
    pergunta: "Qual animal é conhecido como o rei da selva?",
    alternativas: ["Tigre", "Elefante", "Leão", "Macaco"],
    correta: 2
  },
  {
    pergunta: "Quanto é 7 x 8?",
    alternativas: ["54", "56", "58", "60"],
    correta: 1
  }
];

let perguntasSelecionadas = [];
let indiceAtual = 0;
let acertos = 0;
let respostaSelecionada = null;
let respostasUsuario = [];

function embaralhar(array) {
  return array.sort(() => Math.random() - 0.5);
}

function iniciarQuiz() {
  perguntasSelecionadas = embaralhar(perguntas).slice(0, 5);
  respostasUsuario = [];
  indiceAtual = 0;
  acertos = 0;
  mostrarPergunta();
}

function mostrarPergunta() {
  const perguntaAtual = perguntasSelecionadas[indiceAtual];
  const perguntaDiv = document.getElementById("pergunta");
  const alternativasDiv = document.getElementById("alternativas");
  const resultadoDiv = document.getElementById("resultado");

  resultadoDiv.innerHTML = "";
  respostaSelecionada = null;

  perguntaDiv.textContent = `Pergunta ${indiceAtual + 1}: ${perguntaAtual.pergunta}`;
  alternativasDiv.innerHTML = "";

  perguntaAtual.alternativas.forEach((texto, i) => {
    const botao = document.createElement("button");
    botao.textContent = texto;
    botao.onclick = () => {
      document.querySelectorAll(".alternativas button").forEach(b => b.classList.remove("selecionada"));
      botao.classList.add("selecionada");
      respostaSelecionada = i;
      document.getElementById("proxima").disabled = false;
    };
    alternativasDiv.appendChild(botao);
  });

  document.getElementById("proxima").disabled = true;
}

function proximaPergunta() {
  const perguntaAtual = perguntasSelecionadas[indiceAtual];

  respostasUsuario.push({
    pergunta: perguntaAtual.pergunta,
    alternativas: perguntaAtual.alternativas,
    correta: perguntaAtual.correta,
    escolhida: respostaSelecionada
  });

  if (respostaSelecionada === perguntaAtual.correta) {
    acertos++;
  }

  indiceAtual++;

  if (indiceAtual < perguntasSelecionadas.length) {
    mostrarPergunta();
  } else {
    mostrarResultadoFinal();
  }
}

function mostrarResultadoFinal() {
  document.getElementById("quiz").style.display = "none";
  const resultadoDiv = document.getElementById("resultado");

  let resumo = `<p>Você acertou <strong>${acertos}</strong> de ${respostasUsuario.length} perguntas.</p><hr/>`;

  respostasUsuario.forEach((resposta, i) => {
    const correta = resposta.correta;
    const escolhida = resposta.escolhida;
    const status = correta === escolhida ? "✅ Acertou" : "❌ Errou";

    resumo += `
      <div style="margin-bottom: 15px;">
        <strong>P${i + 1}: ${resposta.pergunta}</strong><br/>
        ${status}<br/>
        Sua resposta: <em>${resposta.alternativas[escolhida] || "Não respondida"}</em><br/>
        Resposta correta: <strong>${resposta.alternativas[correta]}</strong>
      </div>
    `;
  });

  resultadoDiv.innerHTML = resumo;
  document.getElementById("reiniciar").style.display = "block";

}

function reiniciarQuiz() {
  document.getElementById("quiz").style.display = "block";
  document.getElementById("resultado").innerHTML = "";
  document.getElementById("reiniciar").style.display = "none";
  iniciarQuiz();
}

iniciarQuiz();