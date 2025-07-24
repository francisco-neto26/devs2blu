const urlBack = 'http://localhost:3000/pessoa';
let pessoas = [];
let buscar = 1;
let ativaBtnAlterar = 0;
let obj_old = null;
const colunas = [];
const nomesColunas = [
    'colunaId',
    'colunaNome',
    'colunaIdade',
    'colunaSelecionar'
];

const nomesInputs = [
    'id',
    'nome',
    'idade'
];

const nomesBotoes = [
    'btnCadastrar',//0
    'btnAlterar',//1
    'btnRemover',//2
    'btnCancelar'//3
];

fetch(urlBack)
    .then(retorno => retorno.json())
    .then(p => {
        pessoas = p
        criarTabela()
    });

let criarTabela = () => {
    let tabela = document.getElementById('tabela');

    tabela.innerHTML = '';

    for (let indice = 0; indice < pessoas.length; indice++) {
        let linha = tabela.insertRow(-1);
        preencherLinhaTabela(criarColunasTabela(linha, nomesColunas), pessoas[indice], indice);
    }
}

let verificaCampos = () => {
    let obj = getDadosInputs(nomesInputs);

    if (obj.nome === '' || obj.idade === '') {
        ativaDesativaBtn(nomesBotoes[0], 0)
    } else if (obj.nome != '' || obj.cep != '') {
        ativaDesativaBtn(nomesBotoes[0], 1)
    } 
    let iguais = camparainpOldNew(obj_old, obj) 
    if(!iguais) {
        ativaDesativaBtn(nomesBotoes[0], 0)
        ativaDesativaBtn(nomesBotoes[1], 1)
    }
}

const ativaDesativaBtn = (botao, ativaDesativa) => {
    let botaoAtivaDesativa = document.getElementById(botao);
    if (ativaDesativa === 1) {
        botaoAtivaDesativa.style.display = 'inline-block';
    } else {
        botaoAtivaDesativa.style.display = 'none';
    }
}

const limpaCampos = () => {
    nome.value = '';
    idade.value = '';
    id.value = '';
}

const cadastrar = () => {
    let dados = getDadosInputs(nomesInputs);

    fetch(urlBack, {
        method: 'POST',
        body: JSON.stringify(dados),
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {

            pessoas.push(p);
            let indice = pessoas.length - 1;

            let tabela = document.getElementById('tabela');
            let linha = tabela.insertRow(-1);

            preencherLinhaTabela(criarColunasTabela(linha, nomesColunas), pessoas[indice], indice);
            limpaCampos();
            verificaCampos();
            nome.focus();
        });
};

const alterar = () => {
    let dados = getDadosInputs(nomesInputs);
    
    fetch(`${urlBack}/${dados.id}`, {
        method: 'PUT',
        body: JSON.stringify(dados),
        headers: { 'Content-Type': 'application/json' }
    })
    .then(res => res.json())
    .then(p => {
        //console.log("Lista local de pessoas:", pessoas);
        let indice = pessoas.findIndex(pessoa => Number(pessoa.id) === Number(p.id));
        console.log(indice)
        pessoas[indice] = p;        
        criarTabela();        
        limpaCampos();        
        nome.focus();
    });
};

function preencherLinhaTabela(colunas, pessoa, indice) {
    colunas.colunaId.innerText = pessoa.id;
    colunas.colunaNome.innerText = pessoa.nome;
    colunas.colunaIdade.innerText = pessoa.idade;

    if (colunas.colunaSelecionar) {
        colunas.colunaSelecionar.innerHTML = `<button value="Selecionar" onclick="selecionar(${indice})" class="btn btn-primary">Selecionar</button>`;
    }
}

function criarColunasTabela(linha, nomesColunas) {
    const colunas = {};
    nomesColunas.forEach((nome, i) => {
        colunas[nome] = linha.insertCell(i);
    });
    return colunas;
}
/*
function getDadosInputs(campos) {
    const obj = {};
    campos.forEach(nome => {
        const input = document.getElementById(nome);
        obj[nome] = input ? input.value : '';
    });
    return obj;
}*/

function getDadosInputs(campos) {
    const obj = {};
    campos.forEach(nome => {
        const input = document.getElementById(nome);
        let valor = input ? input.value : '';
        if (nome === 'id' || nome === 'idade') {
            valor = Number(valor);
        }
        obj[nome] = valor;
    });
    return obj;
}

// função para selecionar
const selecionar = (indice) => {

    let objPessoas = pessoas[indice];
    nomesInputs.forEach(nome => {
        const input = document.getElementById(nome);
        if (input && objPessoas[nome] !== undefined) {
            input.value = objPessoas[nome];
        }
    });
    ativaDesativaBtn(nomesBotoes[2], 1);
    ativaDesativaBtn(nomesBotoes[3], 1);
    obj_old = getDadosInputs(nomesInputs);    
};

// função para cancelar
const cancelar = () => {

    limpaCampos();
    verificaCampos();
    btnAjuste(0);

}

//função para remover
const remover = () => {

    let id = document.getElementById('id');

    fetch(`${urlBack}/${id.value}`, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {
            let indice = pessoas.findIndex(pessoa => pessoa.id == p.id);
            pessoas.splice(indice, 1);
            criarTabela();
            limpaCampos();
            //verificaCampos(0);
            btnAjuste(0);
            nome.focus();
        });
};

function camparainpOldNew(obj1, obj2) {
    if (obj1 === null) {
        obj1 = getDadosInputs(nomesInputs);
    }
    for (let chave of Object.keys(obj1)) {
        if (obj1[chave] !== obj2[chave]) {
            return false;
        }
    }
    return true;
}

nome.addEventListener('input', verificaCampos);
idade.addEventListener('input', verificaCampos);

verificaCampos(buscar);

