# Apresentação — FRANCISCO (Backend: Banco de Dados & Segurança)

## Slide 1 — Título
- FRANCISCO — Backend (Banco de Dados & Segurança)
- VendaTech
- Objetivo: Descrever responsabilidades, arquitetura e decisões técnicas do backend relacionadas a banco de dados e segurança.

---

## Slide 2 — Responsabilidades (resumo)
- Configuração e gerenciamento do cluster MongoDB Atlas
- Design e implementação dos Schemas (Mongoose): User, Product, Order
- Segurança: JWT para autenticação, bcryptjs para hash de senhas
- Middlewares de autorização: autenticação (`authenticate`) e permissão de admin (`requireAdmin`)
- Validações: `express-validator` nas rotas
- Variáveis de ambiente e ambiente de produção (`.env`, MONGODB_URI, JWT_SECRET)

---

## Slide 3 — Arquivos principais (lista rápida)
- `src/models/User.js` — Schema do Usuário, hashing de senha, método comparePassword
- `src/models/Product.js` — Schema do Produto
- `src/models/Order.js` — Schema do Pedido, índices para performance
- `src/middleware/auth.js` — Middleware `authenticate` (verifica JWT)
- `src/middleware/admin.js` — Middleware `requireAdmin` (verifica isAdmin)
- `src/config/database.js` — Conexão com MongoDB via `MONGODB_URI`
- `.env` / `.env.example` — Variáveis de ambiente essenciais

---

## Slide 4 — User Schema (detalhes)
- Campos principais: `name`, `email` (único), `password` (hashed), `isAdmin`
- Validações no schema: required, maxlength, padrão de email
- Pre-save hook para hash de senha usando `bcryptjs` (salt 10)
- Método `comparePassword` para validação durante login
- `toJSON` sobrescrito para remover `password` em respostas

Trecho-chave (resumo):
- `userSchema.pre('save', async function(next) { ... })` — garante que a senha seja sempre hasheada antes de persistir.

---

## Slide 5 — Product Schema (detalhes)
- Campos: `name`, `description`, `price`, `image`, `category`, `stock`, `isActive`
- Restrições: `price >= 0`, `stock >=0`, `category` enum
- Timestamp automático (`timestamps: true`)
- Placeholder de imagem padrão

---

## Slide 6 — Order Schema (detalhes)
- Relacionamento com `User` e `Product` via ObjectId
- Campos: `items` (lista), `totalAmount`, `status`, `paymentStatus`, `transactionId`, `shippingAddress`, `orderDate`
- Índices: `{ userId: 1 }`, `{ orderDate: -1 }`, `{ status: 1 }`, `{ transactionId: 1 }` — ajudam em consultas frequentes
- Lógica de decremento de estoque implementada no controller ao criar pedido

---

## Slide 7 — Autenticação & JWT
- Biblioteca: `jsonwebtoken` (JWT)
- Fluxo:
  1. Usuário efetua login (email + senha)
  2. `authController.login` valida credenciais usando `comparePassword`
  3. Gera token JWT com `jwt.sign({ id }, process.env.JWT_SECRET, { expiresIn })`
  4. Rotas privadas usam `authenticate` para decodificar token e carregar `req.user`
- Recomendações de segurança: usar `JWT_SECRET` forte e diferente para ambientes (dev/staging/prod), expiração curta para tokens de acesso e refresh tokens se necessário

---

## Slide 8 — Hash de Senha (bcryptjs)
- `bcryptjs` com salt rounds = 10
- Implementação segura no `pre('save')`
- Comparação com `bcrypt.compare` via `user.comparePassword`
- Comentário: `bcryptjs` é puro JS — para maior performance e segurança em ambientes de produção, considerar `bcrypt` (bindings nativos) ou `argon2` onde apropriado

---

## Slide 9 — Middlewares de Autorização
- `authenticate` (`src/middleware/auth.js`):
  - Lê header `Authorization: Bearer <token>`
  - `jwt.verify(token, process.env.JWT_SECRET)`
  - Carrega `req.user` com o usuário (sem a senha)
  - Retorna 401/403 em token ausente ou inválido
- `requireAdmin` (`src/middleware/admin.js`):
  - Verifica `req.user` e `req.user.isAdmin`
  - Retorna 403 se não for admin

---

## Slide 10 — Validações de Entrada
- Biblioteca: `express-validator` (uso nas rotas `auth` e `products`)
- Padrão: definir arrays de validações por rota e usar `validationResult(req)` no controller
- Exemplo: registro de usuário valida `name`, `email`, `password`
- Benefício: evita persistir dados inválidos e melhora mensagens de erro para frontend

---

## Slide 11 — Tratamento de Erros
- Controllers usam try/catch e retornam `500` em erro inesperado
- Validações retornam `400` com `errors: errors.array()`
- Sugestão: adicionar um middleware global de erro (`errorHandler`) para centralizar logs e respostas padronizadas

---

## Slide 12 — Configuração do Banco (MongoDB Atlas)
- `src/config/database.js` conecta usando `process.env.MONGODB_URI`
- `.env` deve conter `MONGODB_URI`, `JWT_SECRET`, `JWT_EXPIRE`, `NODE_ENV`
- Docs e passos para criação do cluster e string de conexão estão disponíveis em `docs/MONGODB_ATLAS_SETUP.md`

---

## Slide 13 — Segurança e Boas Práticas
- Variáveis de ambiente nunca no código-fonte
- Usar roles (`isAdmin`) mínimo necessário
- Rate limiting + Helmet + CORS configurado no `app.js` (recomendado)
- Monitoramento e alertas no Atlas
- Backups e políticas de retenção

---

## Slide 14 — Demonstração ao Vivo (roteiro)
1. Mostrar `.env.example` e explicar variáveis (MONGODB_URI, JWT_SECRET)
2. Subir backend local (`npm install` + `npm run dev`) — mostrar logs de conexão com Atlas
3. Registrar um usuário via Postman / curl (POST /api/auth/register)
4. Logar e obter token (POST /api/auth/login)
5. Consumir rota protegida (GET /api/auth/profile) com header `Authorization`
6. Demonstrar rota admin protegida (POST /api/products` com token de admin) — usar `make-admin` se necessário
7. Criar um pedido e mostrar decremento de estoque

---

## Slide 15 — Riscos conhecidos & limitações
- Tokens long-lived sem refresh tokens (melhorar)
- `express` 5.x em dependências: verificar compatibilidade de middlewares
- `bcryptjs` vs `bcrypt`/`argon2` (opção de melhoria)
- Ausência de logging estruturado/centralizado (ex: Sentry)

---

## Slide 16 — Próximos passos sugeridos
- Implementar middleware global de erro e logs estruturados
- Adicionar refresh tokens e rotação de tokens
- Implementar rate limiting (express-rate-limit)
- Policies de senha (complexidade) e proteção contra brute force
- Testes end-to-end cobrindo autenticação e fluxo de pedidos

---

## Slide 17 — Finalização (frase para encerrar)
"O backend foi projetado com foco em segurança e escalabilidade: schemas bem definidos, autenticação segura via JWT, hashing de senhas e middlewares de autorização garantem que apenas usuários autenticados e administradores executem ações sensíveis. A próxima etapa é reforçar monitoramento, rotatividade de tokens e políticas de segurança para produção." 


---

## Anexos — Trechos de Código Úteis
- `src/models/User.js` (hash + compare)
- `src/middleware/auth.js` (verificação JWT)
- `src/config/database.js` (conexão com MONGODB_URI)


---

## Notas do Apresentador
- Tenha o `.env` pronto antes da demo
- Use um token admin para demonstrar rotas privadas
- Se algo falhar, explique rapidamente o fluxo (código) e prossiga
- Tempo estimado: 10-15 minutos + 5-10 minutos Q&A
