/*const express = require('express');
const cors = require('cors');
const jwt = require('jsonwebtoken');
const app = express();
app.use(cors());

//aceita req contendo json body
app.use(express.json());

const segredo = "aula-de-jwt";

app.post('/', (req, res) =>{
    //obter nome
    const {nome} = req.body;
    //gera o token
    const token = jwt.sign({nome}, segredo, {expiresIn:'1h'});

    //retornar
    res.status(200).json(token);
})

app.get('/', (req, res) => {
    //extrair token do cabecalho
    const headers = req.headers.authorization;
    const token = headers.split(' ')[1];
    try {
        const validarToken = jwt.verify(token, segredo);
        res.status(200).json({mensagem: 'Autenticado ' + validarToken.nome})
    } catch (erro) {
        res.status(400).json({mensagem: 'falha ' + erro});
    }
})

app.listen(8080);*/

/*
    EXPRESS (npm i express);
    NODEMON (npm i nodemon);
    CORS (npm i cors);
    JSONWEBTOKEN (npm i jsonwebtoken).
*/

// Importar Express
const express = require('express');

// Importar CORS
const cors = require('cors');

// Importar JsonWebToken
const jwt = require('jsonwebtoken');

// Criar o objeto app
const app = express();

// Referenciar CORS
app.use(cors());

// Aceitar requisições contendo JSON (body)
app.use(express.json());

// Palavra / Frase secreta
const segredo = "Ready";

// Rota para criar o token
app.post('/', (req, res) => {
    // Obter o nome
    //const nome = req.body.nome;
    const {nome} = req.body;

    // Gerar token
    const token = jwt.sign({nome}, segredo, {expiresIn:'1h'});

    // Retornar
    res.status(200).json(token);
});

// Rota para validar o token
app.get('/', (req, res) => {
    // Extrair Bearer do cabeçalho
    const headers = req.headers.authorization;

    // Extrair o token
    const token = headers.split(' ')[1];

    // Try-Catch
    try{
        const validarToken = jwt.verify(token, segredo);

        res.status(200).json({mensagem:'Autenticado! O nome informado é ' + validarToken.nome});
    }catch(erro){
        res.status(400).json({mensagem:'Falha ' + erro});
    }
});

// Servidor
app.listen(8080);



