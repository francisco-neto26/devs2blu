const express = require('express');
const cors = require('cors');
const fileupload = require('express-fileupload');
const path = require('path');
const app = express();
app.use(cors());
app.use(fileupload());

//criar rota para upload (form-data)
app.post('/', (req, res) => {
    //obter o arquivo
    const arquivo = req.files.arquivo;

    //definir caminho do upload e nome do arquivo
    const destino = path.join(__dirname, 'uploads', arquivo.name);

    // mover o arquivo
    arquivo.mv(destino);
    
    //retorno da api
    res.status(200).json({mensagem:'Upload realizado com sucesso'});
});

app.listen(8080);