let produtos = [];

fetch('http://localhost:3000/produtos')
    .then(retorno => retorno.json())
    .then(p => {
        produtos = p
        renderizarTabela()
    });

let renderizarTabela = () => {
    let tabela = document.getElementById('tabela');

    for( let indice = 0; indice < produtos.length; indice++ ){
        let linha = tabela.insertRow(-1);
        let colunaId = linha.insertCell(0);
        let colunaNome = linha.insertCell(1);
        let colunaMarca = linha.insertCell(2);
        let colunaValor = linha.insertCell(3);
        let colunaSelecionar = linha.insertCell(4);

        colunaId.innerText = produtos[indice].id;
        colunaNome.innerText = produtos[indice].nome;
        colunaMarca.innerText = produtos[indice].marca;
        colunaValor.innerText = produtos[indice].valor;
        colunaSelecionar.innerHTML = `<button class = 'btn btn-primary'>Selecionar</button>`;

    }
}