const express = require('express');
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

app.listen(8080);



