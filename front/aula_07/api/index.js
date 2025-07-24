// importar dependencias/pacote
const express = require('express')
//importa depedencia do cors
const cors = require('cors')

//objeto express (manipular rotas e o servidor)
const app = express()

//adicionar cors
app.use(cors())
// hab receber objeto json nas req
app.use(express.json());

//referenciar arquivo de rotas
const pessoa = require('./rotas/pessoa');

//add rotas na aplicação
app.use('/pessoa', pessoa)

//servidor
app.listen(3000)
