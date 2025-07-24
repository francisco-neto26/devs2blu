//importa pacote express
const express = require('express')
//criando objeto Router
const router = express.Router()

//vetor para armazenar dados pessoas
let vetor = [
    {
        id: 1,
        nome: 'Neto',
        idade: 26
    },
    {
        id: 2,
        nome: 'Neto',
        idade: 36
    }
];

// id da pessoa
let id = vetor.length + 1;
//let id = 3;

//Rota para efetuar uma requisição get
router.get('/', (req, res) => {
    res.status(200).json(vetor)
})

router.get('/:idPessoa', (req, res) => {
    const idPessoa = parseInt(req.params.idPessoa);

    const indiceVetor = vetor.findIndex(p => p.id === idPessoa);
    if (indiceVetor === -1) {
        res.status(404).json({ mensagem: 'Pessoa não encontrada' });
    }

    const obj = vetor[indiceVetor]

    res.status(200).json(obj);

})

//rota para efetuar uma requesição post
router.post('/', (req, res) => {
    // obtem nome e idade
    const { nome, idade } = req.body;
    //valida se estão preenchidos
    if (!nome || !idade) {
        res.status(400).json({ mensagem: 'O nome ou a idade não informado(s)' });
    }
    //cria objeto do tipo pessoa
    const obj = { id, nome, idade };
    //cadastrar no vetor
    vetor.push(obj);
    id++;
    //retorno
    res.status(201).json(obj);
});

//rota para alterar dados
router.put('/:idPessoa', (req, res) => {
    //extrair idPessoa
    const idPessoa = parseInt(req.params.idPessoa);

    const indiceVetor = vetor.findIndex(p => p.id === idPessoa);
    if (indiceVetor === -1) {
        res.status(404).json({ mensagem: 'Pessoa não encontrada' });
    }

    const { nome, idade } = req.body;
    //valida se estão preenchidos
    if (!nome || !idade) {
        res.status(400).json({ mensagem: 'O nome ou a idade não informado(s)' });
    }

    const obj = {
        'id': idPessoa,
        'nome': nome,
        'idade': idade
    }
    vetor[indiceVetor] = obj;

    res.status(200).json(obj);
});

//rota para deletar dados
router.delete('/:idPessoa', (req, res) => {
    //extrair idPessoa
    const idPessoa = parseInt(req.params.idPessoa);

    const indiceVetor = vetor.findIndex(p => p.id === idPessoa);
    if (indiceVetor === -1) {
        res.status(404).json({ mensagem: 'Pessoa não encontrada' });
    }
    //remover dados no vetor    
    vetor.splice[indiceVetor, 1];

    res.status(200).json({ mensagem: 'Pessoa removida com sucesso' });
});

module.exports = router
