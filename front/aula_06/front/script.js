const urlBack = 'http://localhost:3000/pessoas';
const urlViaCep = 'https://viacep.com.br/ws/recebe_cep/json';
let pessoas = [];
let buscarAltera = 1;
let ativaBtnAlterar = 0;
let obj_old = null;
const colunas = {};
const nomesColunas = [
    'colunaId',
    'colunaNome',
    'colunaCEP',
    'colunaEstado',
    'colunaCidade',
    'colunaBairro',
    'colunaLogradouro',
    'colunaSelecionar'
];

let verificaCampos = (buscar) => {
    //obtem os inputs
    let nome = document.getElementById('nome');
    let cep = document.getElementById('cep');
    let obj = {
        'nome': nome.value,
        'cep': cep.value,
    }
    ativarbtncadastrar(buscar)

    let btnBuscar = document.getElementById('btnBuscar');
    if (obj.nome === '' || obj.cep === '') {
        btnBuscar.style.display = 'none';
    } else if (obj.nome != '' || obj.cep != '') {
        btnBuscar.style.display = 'inline-block';
    }
    
}
//função para buscar dados do cep
const buscar = (obj_old) => {
    ativarBtnAlterar(ativaBtnAlterar);
    let cep = document.getElementById('cep').value;
    fetch(urlViaCep.replace('recebe_cep', cep))
        .then(retorno => retorno.json())
        .then(dadosRet => {
            document.getElementById('estado').value = (dadosRet.estado);
            document.getElementById('cidade').value = (dadosRet.localidade);
            document.getElementById('bairro').value = (dadosRet.bairro);
            document.getElementById('logradouro').value = (dadosRet.logradouro);
        });
    let obj = getDadosFormulario();

    let iguais = camparainpOldNew(obj_old, obj)

    if (iguais) {
        ativarBtnAlterar(0);
    } else {
        ativarBtnAlterar(1);
    }
    let btnBuscar = document.getElementById('btnBuscar');
    btnBuscar.style.display = 'none';
    ativarbtncadastrar(buscarAltera);
}

fetch(urlBack)
    .then(retorno => retorno.json())
    .then(p => {
        pessoas = p
        criarTabela()
    });
//função para criar tabela
let criarTabela = () => {
    let tabela = document.getElementById('tabela');

    tabela.innerHTML = '';

    for (let indice = 0; indice < pessoas.length; indice++) {

        let linha = tabela.insertRow(-1);

        for (let i = 0; i < nomesColunas.length; i++) {
            colunas[nomesColunas[i]] = linha.insertCell(i);
        }
        preencherLinhaTabela(colunas, pessoas[indice], indice);
    }
}

//função para cadastrar
const cadastrar = () => {
    let obj = getDadosFormulario();

    fetch(urlBack, {
        method: 'POST',
        body: JSON.stringify(obj),
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {

            pessoas.push(p);
            let indice = pessoas.length - 1;
            let linha = tabela.insertRow(-1);

            for (let i = 0; i < nomesColunas.length; i++) {
                colunas[nomesColunas[i]] = linha.insertCell(i);
            }
            preencherLinhaTabela(colunas, pessoas[indice], indice);
            limpaCampos();
            verificaCampos(0);
            nome.focus();
        });
}

// função para selecionar
const selecionar = (indice) => {

    let obj = pessoas[indice];
    document.getElementById('id').value = obj.id;
    document.getElementById('nome').value = obj.nome;
    document.getElementById('cep').value = obj.cep;
    document.getElementById('estado').value = obj.estado;
    document.getElementById('cidade').value = obj.cidade;
    document.getElementById('bairro').value = obj.bairro;
    document.getElementById('logradouro').value = obj.logradouro;
    buscarAltera = 0;
    ativaBtnAlterar = 1;
    verificaCampos(0);
    btnAjuste(1);
    obj_old = getDadosFormulario();
};

// função para cancelar
const cancelar = () => {

    limpaCampos();
    verificaCampos(0);
    btnAjuste(0);

}

//função para alterar
const alterar = () => {
    let obj = getDadosFormulario();

    fetch(`${urlBack}/${id.value}`, {
        method: 'PUT',
        body: JSON.stringify(obj),
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {
            let indice = pessoas.findIndex(pessoa => pessoa.id == p.id);
            pessoas[indice] = p;
            criarTabela();
            limpaCampos();
            buscarAltera = 1;
            verificaCampos(0);
            btnAjuste(0);
            nome.focus();
        });
    ativarBtnAlterar(0);
};

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
            verificaCampos(0);
            btnAjuste(0);
            nome.focus();
        });
};

const btnAjuste = (ativa) => {
    let btnRemover = document.getElementById('btnRemover');
    let btnCancelar = document.getElementById('btnCancelar');
    if (ativa === 1) {
        btnRemover.style.display = 'inline-block';
        btnCancelar.style.display = 'inline-block';
    } else {
        btnRemover.style.display = 'none';
        btnCancelar.style.display = 'none';
    }
}

const ativarbtncadastrar = (ativa) => {
    let btnCadastrar = document.getElementById('btnCadastrar');
    if (ativa === 1) {
        btnCadastrar.style.display = 'inline-block';
    } else {
        btnCadastrar.style.display = 'none';
    }
}
const ativarBtnAlterar = (ativa) => {
    let btnAlterar = document.getElementById('btnAlterar');
    if (ativa === 1) {
        btnAlterar.style.display = 'inline-block';
    } else {
        btnAlterar.style.display = 'none';
    }
}

const limpaCampos = () => {
    nome.value = '';
    cep.value = '';
    estado.value = '';
    cidade.value = '';
    bairro.value = '';
    logradouro.value = '';
}

function getDadosFormulario() {
    const campos = ['nome', 'cep', 'estado', 'cidade', 'bairro', 'logradouro'];
    const obj = {};

    campos.forEach(campo => {
        obj[campo] = document.getElementById(campo).value;
    });

    return obj;
}

function preencherLinhaTabela(colunas, pessoa, indice) {
    colunas.colunaId.innerText = pessoa.id;
    colunas.colunaNome.innerText = pessoa.nome;
    colunas.colunaCEP.innerText = pessoa.cep;
    colunas.colunaEstado.innerText = pessoa.estado;
    colunas.colunaCidade.innerText = pessoa.cidade;
    colunas.colunaBairro.innerText = pessoa.bairro;
    colunas.colunaLogradouro.innerText = pessoa.logradouro;
    colunas.colunaSelecionar.innerHTML = `<button value="Selecionar" onclick="selecionar(${indice})" class="btn btn-primary">Selecionar</button>`;
}

function camparainpOldNew(obj1, obj2) {
    if (obj1 === null){
        obj1 = getDadosFormulario();
    }
    for (let chave of Object.keys(obj1)) {
        if (obj1[chave] !== obj2[chave]) {
            return false;
        }
    }
    return true;
}

nome.addEventListener('input', verificaCampos);
cep.addEventListener('input', verificaCampos);

verificaCampos(0);