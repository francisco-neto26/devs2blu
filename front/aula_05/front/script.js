let produtos = [];

fetch('http://localhost:3000/produtos')
    .then(retorno => retorno.json())
    .then(p => {
        produtos = p
        renderizarTabela()
    });
//função para criar tabela
let renderizarTabela = () => {
    let tabela = document.getElementById('tabela');

    // limpar tabela
    tabela.innerHTML = '';

    for (let indice = 0; indice < produtos.length; indice++) {
        //cria linha na tabela
        let linha = tabela.insertRow(-1);
        //cria colunas da tabela
        let colunaId = linha.insertCell(0);
        let colunaNome = linha.insertCell(1);
        let colunaMarca = linha.insertCell(2);
        let colunaValor = linha.insertCell(3);
        let colunaSelecionar = linha.insertCell(4);
        //insere os valores nas colunas da tabela
        colunaId.innerText = produtos[indice].id;
        colunaNome.innerText = produtos[indice].nome;
        colunaMarca.innerText = produtos[indice].marca;
        colunaValor.innerText = produtos[indice].valor;
        colunaSelecionar.innerHTML = `<button value="Selecionar" onclick = 'selecionar(${indice})' class = 'btn btn-primary'>Selecionar</button>`;

    }
}

//função para cadastrar produtos
const cadastrar = () => {

    //obtem os inputs
    let nome = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');

    // gerar objeto produto

    let obj = {
        'nome': nome.value,
        'marca': marca.value,
        'valor': parseFloat(valor.value)
    }

    fetch('http://localhost:3000/produtos', {
        method: 'POST',
        body: JSON.stringify(obj),
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {
            // atualizar vetor
            produtos.push(p);

            //Gerar o indice do produto no vetor
            let indice = produtos.length - 1;

            let tabela = document.getElementById('tabela');
            //cria linha na tabela
            let linha = tabela.insertRow(-1);
            //cria colunas da tabela
            let colunaId = linha.insertCell(0);
            let colunaNome = linha.insertCell(1);
            let colunaMarca = linha.insertCell(2);
            let colunaValor = linha.insertCell(3);
            let colunaSelecionar = linha.insertCell(4);
            //insere os valores nas colunas da tabela
            colunaId.innerText = p.id;
            colunaNome.innerText = p.nome;
            colunaMarca.innerText = p.marca;
            colunaValor.innerText = p.valor;
            colunaSelecionar.innerHTML = `<button value="Selecionar" onclick = 'selecionar(${indice})' class = 'btn btn-primary'>Selecionar</button>`;

            //limpar inputs
            nome.value = '';
            marca.value = '';
            valor.value = '';

            //focus
            nome.focus();
        })
}

// função para selecionar um produto
const selecionar = (indice) => {
    // selecionar todos os elementos de formulario
    let id = document.getElementById('id');
    let nome = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');
    let btnCadastrar = document.getElementById('btnCadastrar');
    let btnAlterar = document.getElementById('btnAlterar');
    let btnRemover = document.getElementById('btnRemover');
    let btnCancelar = document.getElementById('btnCancelar');

    //obter objeto de produto
    let obj = produtos[indice]

    //preencher inputs
    id.value = obj.id;
    nome.value = obj.nome;
    marca.value = obj.marca;
    valor.value = obj.valor

    // visibilidade de botoes
    btnCadastrar.style.display = 'none';
    btnAlterar.style.display = 'inline-block';
    btnRemover.style.display = 'inline-block';
    btnCancelar.style.display = 'inline-block';

}
// função para cancelar
const cancelar = () => {
    // selecionar todos os elementos de formulario
    let id = document.getElementById('id');
    let nome = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');
    let btnCadastrar = document.getElementById('btnCadastrar');
    let btnAlterar = document.getElementById('btnAlterar');
    let btnRemover = document.getElementById('btnRemover');
    let btnCancelar = document.getElementById('btnCancelar');

    //preencher inputs
    id.value = '';
    nome.value = '';
    marca.value = '';
    valor.value = '';

    // visibilidade de botoes
    btnCadastrar.style.display = 'inline-block';
    btnAlterar.style.display = 'none';
    btnRemover.style.display = 'none';
    btnCancelar.style.display = 'none';

}

//função para alterar produtos
const alterar = () => {

    //obtem os inputs
    let nome = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');
    let id = document.getElementById('id');

    // gerar objeto produto

    let obj = {
        'nome': nome.value,
        'marca': marca.value,
        'valor': parseFloat(valor.value)
    }

    fetch(`http://localhost:3000/produtos/${id.value}`, {
        method: 'PUT',
        body: JSON.stringify(obj),
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {
            // localizar o produto no vetor
            let indice = produtos.findIndex(produto => produto.id == p.id);

            //alterar objeto no vetor
            produtos[indice] = p;

            renderizarTabela();

            //limpar inputs
            nome.value = '';
            marca.value = '';
            valor.value = '';
            id.value = '';

            //focus
            nome.focus();
        })
}

//função para remover produtos
const remover = () => {

    //obtem os inputs
    let id = document.getElementById('id');
    
    fetch(`http://localhost:3000/produtos/${id.value}`, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    }).then(res => res.json())
        .then(p => {
            // localizar o produto no vetor
            let indice = produtos.findIndex(produto => produto.id == p.id);

            //remover objeto no vetor
            produtos.splice(indice, 1);

            renderizarTabela();

            //limpar inputs
            nome.value = '';
            marca.value = '';
            valor.value = '';
            id.value = '';

            //focus
            nome.focus();
        })
}
