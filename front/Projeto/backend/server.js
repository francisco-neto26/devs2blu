const express = require('express');
const cors = require('cors');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());

// Carregar dados do arquivo JSON
const loadData = () => {
  const data = fs.readFileSync('db.json', 'utf8');
  return JSON.parse(data);
};

// Salvar dados no arquivo JSON
const saveData = (data) => {
  fs.writeFileSync('db.json', JSON.stringify(data, null, 2));
};

// Endpoints básicos
app.get('/api/produtos', (req, res) => {
  const data = loadData();
  res.json(data.produtos);
});

app.get('/api/produtos/:id', (req, res) => {
  const data = loadData();
  const produto = data.produtos.find(p => p.id === parseInt(req.params.id));
  if (produto) {
    res.json(produto);
  } else {
    res.status(404).json({ error: 'Produto não encontrado' });
  }
});

app.get('/api/categorias', (req, res) => {
  const data = loadData();
  res.json(data.categorias);
});

app.get('/api/carrinho', (req, res) => {
  const data = loadData();
  res.json(data.carrinho);
});

app.get('/api/pedidos', (req, res) => {
  const data = loadData();
  res.json(data.pedidos);
});

app.get('/api/produtos/categoria/:categoria', (req, res) => {
  const categoria = req.params.categoria.toLowerCase();
  const data = loadData();
  const produtos = data.produtos.filter(produto => 
    produto.categoria.toLowerCase() === categoria
  );
  res.json(produtos);
});

app.get('/api/produtos/buscar/:termo', (req, res) => {
  const termo = req.params.termo.toLowerCase();
  const data = loadData();
  const produtos = data.produtos.filter(produto => 
    produto.nome.toLowerCase().includes(termo) || 
    produto.categoria.toLowerCase().includes(termo)
  );
  res.json(produtos);
});

app.post('/api/carrinho/adicionar', (req, res) => {
  const { produtoId, quantidade } = req.body;
  const data = loadData();
  
  const produto = data.produtos.find(p => p.id === produtoId);
  
  if (!produto) {
    return res.status(404).json({ error: 'Produto não encontrado' });
  }
  
  if (produto.quantidade < quantidade) {
    return res.status(400).json({ error: 'Quantidade insuficiente em estoque' });
  }
  
  const itemCarrinho = data.carrinho.find(item => item.produtoId === produtoId);
  
  if (itemCarrinho) {
    const novaQuantidade = itemCarrinho.quantidade + quantidade;
    if (produto.quantidade < novaQuantidade) {
      return res.status(400).json({ error: 'Quantidade total excede o estoque' });
    }
    itemCarrinho.quantidade = novaQuantidade;
  } else {
    data.carrinho.push({
      id: Date.now(),
      produtoId,
      quantidade,
      produto: produto
    });
  }
  
  saveData(data);
  res.json({ success: true, message: 'Produto adicionado ao carrinho' });
});

app.delete('/api/carrinho/remover/:produtoId', (req, res) => {
  const produtoId = parseInt(req.params.produtoId);
  const data = loadData();
  
  data.carrinho = data.carrinho.filter(item => item.produtoId !== produtoId);
  saveData(data);
  res.json({ success: true, message: 'Produto removido do carrinho' });
});

app.post('/api/carrinho/finalizar', (req, res) => {
  const data = loadData();
  
  if (data.carrinho.length === 0) {
    return res.status(400).json({ error: 'Carrinho vazio' });
  }
  
  data.carrinho.forEach(item => {
    const produto = data.produtos.find(p => p.id === item.produtoId);
    produto.quantidade -= item.quantidade;
  });
  
  const pedido = {
    id: Date.now(),
    data: new Date().toISOString(),
    itens: [...data.carrinho],
    total: data.carrinho.reduce((total, item) => total + (item.produto.valor * item.quantidade), 0)
  };
  
  data.pedidos.push(pedido);
  data.carrinho = [];
  
  saveData(data);
  res.json({ success: true, message: 'Compra finalizada com sucesso', pedido });
});

app.put('/api/carrinho/atualizar/:produtoId', (req, res) => {
  const produtoId = parseInt(req.params.produtoId);
  const { quantidade } = req.body;
  const data = loadData();
  
  const produto = data.produtos.find(p => p.id === produtoId);
  
  if (!produto) {
    return res.status(404).json({ error: 'Produto não encontrado' });
  }
  
  if (produto.quantidade < quantidade) {
    return res.status(400).json({ error: 'Quantidade insuficiente em estoque' });
  }
  
  if (quantidade <= 0) {
    data.carrinho = data.carrinho.filter(item => item.produtoId !== produtoId);
  } else {
    const item = data.carrinho.find(item => item.produtoId === produtoId);
    if (item) {
      item.quantidade = quantidade;
    }
  }
  
  saveData(data);
  res.json({ success: true, message: 'Carrinho atualizado' });
});

app.listen(PORT, () => {
  console.log(`🚀 Servidor rodando na porta ${PORT}`);
  console.log(`📊 API disponível em: http://localhost:${PORT}/api`);
  console.log(`🛍️  Endpoints principais:`);
  console.log(`   - GET /api/produtos - Listar todos os produtos`);
  console.log(`   - GET /api/produtos/:id - Produto específico`);
  console.log(`   - GET /api/produtos/categoria/:categoria - Produtos por categoria`);
  console.log(`   - GET /api/produtos/buscar/:termo - Buscar produtos`);
  console.log(`   - GET /api/categorias - Listar categorias`);
  console.log(`   - GET /api/carrinho - Ver carrinho`);
  console.log(`   - POST /api/carrinho/adicionar - Adicionar ao carrinho`);
  console.log(`   - DELETE /api/carrinho/remover/:produtoId - Remover do carrinho`);
  console.log(`   - PUT /api/carrinho/atualizar/:produtoId - Atualizar quantidade`);
  console.log(`   - POST /api/carrinho/finalizar - Finalizar compra`);
});