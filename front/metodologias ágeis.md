**Projeto ERP SuperMarket Pro - Metodologia Scrum**

**Descrição do Projeto**

**Resumo**

O SuperMarket Pro é um sistema ERP (Enterprise Resource Planning) completo desenvolvido especificamente para supermercados de pequeno, médio e grande porte. O sistema integra todas as operações essenciais do negócio, desde a gestão de estoque e vendas até controle financeiro e recursos humanos.

**Diferencial do Sistema**
O que torna o SuperMarket Pro único no mercado:

* **Interface Intuitiva:** Design moderno e responsivo que funciona perfeitamente em desktops, tablets e smartphones
* **Integração com PIX:** Sistema nativo de pagamentos PIX integrado ao Banco Central
* **IA para Previsão de Demanda:** Algoritmos de machine learning para prever necessidades de reposição de estoque
* **Gestão de Perecíveis Avançada:** Sistema especializado para controle de produtos com data de validade
* **Dashboard em Tempo Real:** Métricas e KPIs atualizados instantaneamente
* **Sistema de Fidelidade Gamificado:** Programa de pontos com elementos de gamificação
* **Sustentabilidade:** Módulo de gestão de desperdício e pegada de carbono

**Tecnologias Utilizadas**
* **Front-end:** Angular 17 com TypeScript, PrimeNG para componentes especializados
* **Back-end:** Java 17 (LTS), Spring Boot 3.2 como framework principal, Lombok para redução de boilerplate
* **Banco de Dados:** PostgreSQL 15
* **DevOps e Infraestrutura:** Docker para containerização, AWS ECS para orquestração, SonarQube para qualidade de código, JUnit 5 e Mockito para testes unitários, TestContainers para testes de integração

**Equipe de Desenvolvimento**
* **Ana Clara Silva:** Tech Lead & Full Stack Developer
* **Roberto Mendes:** Senior Back-end Developer
* **Camila Santos:** Senior Front-end Developer
* **Diego Ferreira:** DevOps & Database Specialist
* **Fernanda Costa:** QA Engineer & Scrum Master
Total de Sprints: 25

---

**Sprint 1: Definição de Arquitetura e Padrões de Código**
* **O que foi feito:** Definida a arquitetura completa do sistema (Clean Architecture e DDD) e estabelecidos os padrões de código para front-end e back-end, incluindo a configuração de ambientes de desenvolvimento.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Definiu a arquitetura do front-end Angular, padrões de componentes, estrutura de roteamento e serviços.
    * **Roberto:** Projetou a arquitetura hexagonal do back-end Spring Boot, definindo a estrutura de camadas e packages.
* Período de desenvolvimento: 5 dias.
* Período de testes: 1 dia.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 04/08/2025 - 14/08/2025.

**Sprint 2: Desenvolvimento da Autenticação de Usuários**
* **O que foi feito:** Implementado o sistema de login com formulário (e-mail e senha) e autenticação social (Google e Microsoft), com a criação dos métodos de autenticação no back-end.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu a interface de login responsiva com validação de formulários e integrou a autenticação social (OAuth2).
    * **Diego:** Criou os endpoints REST, implementou a autenticação JWT e configurou o OAuth2 Resource Server.
* Período de desenvolvimento: 6 dias.
* Período de testes: 1 dia.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 15/08/2025 - 25/08/2025.

**Sprint 3: Sistema de Gestão de Usuários e Perfis**
* **O que foi feito:** Desenvolvido um sistema de CRUD (Criar, Ler, Atualizar, Deletar) de usuários, com diferentes níveis de acesso e perfis personalizáveis.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Criou componentes Angular para gestão de usuários, formulários dinâmicos e sistema de upload de fotos.
    * **Roberto:** Modelou entidades JPA para usuários, roles e permissões, e implementou os repositórios com Spring Data JPA.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 26/08/2025 - 09/09/2025.

**Sprint 4: Cadastro e Gestão de Produtos**
* **O que foi feito:** Criado o sistema de cadastro de produtos com código de barras, categorias e integração com API externa para busca automática.
* **O que cada desenvolvedor fez:**
    * **Roberto:** Desenvolveu controladores REST para CRUD de produtos, integrou APIs externas e criou endpoints para upload de imagens.
    * **Fernanda:** Configurou testes unitários (JUnit 5, Mockito) e de integração (TestContainers) para as funcionalidades de produtos.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 04/09/2025 - 17/09/2025.

**Sprint 4: Sistema de Gestão de Fornecedores**
* **O que foi feito:** Desenvolvido o módulo de fornecedores, incluindo cadastro, histórico de compras, avaliação de desempenho e um sistema de comunicação integrado.
* **O que cada desenvolvedor fez:**
    * **Diego:** Implementou serviços Spring Boot para gestão de fornecedores, criou APIs REST para histórico de transações e notificações.
    * **Ana Clara:** Criou componentes Angular para cadastro de fornecedores, dashboards de performance e sistema de upload de documentos.
* Período de desenvolvimento: 6 dias.
* Período de testes: 1 dia.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 20/09/2025 - 01/10/2025.

**Sprint 5: Sistema de Controle de Estoque**
* **O que foi feito:** Implementado o sistema de controle de estoque com entrada e saída de produtos, rastreabilidade, alertas de estoque mínimo e integração com código de barras.
* **O que cada desenvolvedor fez:**
    * **Diego:** Modelou entidades JPA para controle de estoque, implementou triggers em PostgreSQL e criou views otimizadas.
    * **Roberto:** Desenvolveu controladores REST para movimentação de estoque, implementou alertas em tempo real via WebSocket e criou endpoints para relatórios.
* Período de desenvolvimento: 8 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 19/09/2025 - 02/10/2025.

**Sprint 6: Módulo de Compras e Pedidos**
* **O que foi feito:** Criado o sistema de gestão de compras com criação automática de pedidos, cotação com múltiplos fornecedores, aprovação por níveis hierárquicos e acompanhamento de entregas.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Implementou a lógica de negócio para pedidos automáticos, desenvolveu o sistema de cotações e o fluxo de aprovações.
    * **Fernanda:** Criou testes unitários e de integração para os fluxos de compras e desenvolveu testes de performance.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 03/10/2025 - 15/10/2025.

**Sprint 7: Sistema PDV (Ponto de Venda)**
* **O que foi feito:** Desenvolvido o sistema de PDV com interface otimizada para touch, leitura de código de barras, cálculo de impostos, impressão de cupom fiscal e integração com periféricos.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu a interface touch do PDV, componentes de seleção rápida de produtos e a tela de finalização de vendas.
    * **Diego:** Configurou a integração com impressoras fiscais, implementou os cálculos de impostos e criou entidades JPA para transações.
* Período de desenvolvimento: 8 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 16/10/2025 - 29/10/2025.

**Sprint 8: Processamento de Pagamentos**
* **O que foi feito:** Integradas múltiplas formas de pagamento (dinheiro, cartão, PIX), com sistema de troco automático e conciliação bancária.
* **O que cada desenvolvedor fez:**
    * **Roberto:** Integrou APIs de pagamento, implementou o processamento PIX e o sistema de conciliação bancária.
    * **Ana Clara:** Implementou a lógica de cálculo de troco, a interface para seleção de pagamentos e validações de segurança.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 30/10/2025 - 11/11/2025.

**Sprint 9: Gestão Financeira Básica**
* **O que foi feito:** Criado o sistema de contas a pagar/receber, fluxo de caixa, conciliação bancária, relatórios financeiros e controle de inadimplência.
* **O que cada desenvolvedor fez:**
    * **Diego:** Modelou a estrutura financeira no banco de dados e criou procedures para cálculos complexos.
    * **Fernanda:** Desenvolveu testes para os cálculos financeiros, criou testes de integridade para conciliação e cenários para inadimplência.
* Período de desenvolvimento: 6 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 12/11/2025 - 23/11/2025.

**Sprint 10: Dashboard Executivo e Relatórios**
* **O que foi feito:** Criação de um dashboard executivo com KPIs em tempo real, gráficos interativos e relatórios personalizáveis com exportação.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu dashboards interativos com Chart.js, componentes de filtros avançados e interfaces para relatórios customizados.
    * **Roberto:** Implementou APIs para coleta de métricas em tempo real, sistema de cache para dashboards e endpoints para exportação.
* Período de desenvolvimento: 8 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 24/11/2025 - 07/12/2025.

**Sprint 11: Sistema de Promoções e Descontos**
* **O que foi feito:** Desenvolvimento de um sistema de promoções (desconto progressivo, compre X leve Y) e cupons de desconto, com validação em tempo real no PDV.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Implementou a engine de regras de promoções, desenvolveu o sistema de cupons digitais e APIs para validação em tempo real.
    * **Diego:** Criou a estrutura de dados otimizada para promoções, implementou queries de alta performance e um sistema de auditoria.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 08/12/2025 - 20/12/2025.

**Sprint 12: Programa de Fidelidade**
* **O que foi feito:** Criado um sistema de fidelidade gamificado com acúmulo de pontos, níveis de cliente, recompensas, missões e rankings.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu a interface gamificada do programa, criou o sistema de badges e implementou rankings interativos.
    * **Fernanda:** Criou testes para todos os cenários de acúmulo de pontos, testes de integração com redes sociais e testes de performance para os rankings.
* Período de desenvolvimento: 6 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 21/12/2025 - 02/01/2026.

**Sprint 13: Gestão de Funcionários e RH**
* **O que foi feito:** Sistema de RH com cadastro de funcionários, controle de ponto, cálculo de folha de pagamento, gestão de férias e avaliações de desempenho.
* **O que cada desenvolvedor fez:**
    * **Roberto:** Implementou APIs para gestão de funcionários, desenvolveu o sistema de cálculos trabalhistas e integrou com eSocial.
    * **Ana Clara:** Desenvolveu a lógica de negócio para folha de pagamento, implementou o sistema de avaliações e o workflow para férias.
* Período de desenvolvimento: 8 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 03/01/2026 - 16/01/2026.

**Sprint 14: Controle de Perdas e Validade**
* **O que foi feito:** Sistema especializado para controle de produtos perecíveis, com alertas de vencimento, sugestões de promoções e relatórios de desperdício.
* **O que cada desenvolvedor fez:**
    * **Diego:** Criou a estrutura de dados para controle de lotes e validades, implementou triggers para alertas e queries para análise de perdas.
    * **Camila:** Desenvolveu as interfaces para o controle de validade, dashboards de perdas e alertas visuais para produtos vencendo.
* Período de desenvolvimento: 6 dias.
* Período de testes: 1 dia.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 17/01/2026 - 27/01/2026.

**Sprint 15: Integração com Sistemas Fiscais**
* **O que foi feito:** Integração completa com SPED Fiscal, emissão de NF-e, NFC-e, cálculos de impostos automatizados e sistema de contingência offline.
* **O que cada desenvolvedor fez:**
    * **Roberto:** Implementou a integração com a SEFAZ, o sistema de emissão de notas fiscais e os cálculos de impostos.
    * **Fernanda:** Criou testes para todos os cenários fiscais, testes de integração com a SEFAZ e cenários de teste para a contingência offline.
* Período de desenvolvimento: 9 dias.
* Período de testes: 3 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 28/01/2026 - 12/02/2026.

**Sprint 16: Sistema de Delivery e E-commerce**
* **O que foi feito:** Plataforma de e-commerce integrada com catálogo online, carrinho, sistema de delivery com rastreamento GPS e app mobile para clientes.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu o front-end do e-commerce responsivo, o aplicativo mobile e a interface de chat para suporte.
    * **Ana Clara:** Implementou o back-end para e-commerce, APIs de integração com plataformas de delivery e o cálculo de frete.
* Período de desenvolvimento: 10 dias.
* Período de testes: 3 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 13/02/2026 - 01/03/2026.

**Sprint 17: Business Intelligence e Analytics**
* **O que foi feito:** Implementado BI avançado com análise preditiva, forecasting de vendas, análise de comportamento do cliente e dashboards com machine learning.
* **O que cada desenvolvedor fez:**
    * **Diego:** Criou um data warehouse, implementou ETL para análise de dados e desenvolveu modelos de machine learning para previsão.
    * **Roberto:** Implementou APIs para coleta de dados analíticos, desenvolveu algoritmos de recomendação de produtos e APIs para dashboards de BI.
* Período de desenvolvimento: 9 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 02/03/2026 - 16/03/2026.

**Sprint 18: Sistema de Auditoria e Compliance**
* **O que foi feito:** Sistema completo de auditoria com logs detalhados, trilhas de auditoria, relatórios de compliance, backup e monitoramento de segurança em tempo real.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Implementou sistema de logs distribuído, desenvolveu trilhas de auditoria e criou um sistema de backup automático.
    * **Fernanda:** Desenvolveu testes de segurança, testes para verificação de compliance e cenários de teste para auditoria.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 17/03/2026 - 29/03/2026.

**Sprint 19: Otimização de Performance**
* **O que foi feito:** Otimização geral do sistema com implementação de cache distribuído, otimização de queries, compressão de dados, CDN para assets estáticos e micro-serviços para componentes críticos.
* **O que cada desenvolvedor fez:**
    * **Roberto:** Implementou cache distribuído com Redis, otimizou APIs críticas e desenvolveu um sistema de rate limiting.
    * **Diego:** Otimizou queries do banco de dados, implementou particionamento de tabelas e configurou replicação master-slave.
* Período de desenvolvimento: 8 dias.
* Período de testes: 3 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 30/03/2026 - 13/04/2026.

**Sprint 20: Sistema de Comunicação Integrado**
* **O que foi feito:** Plataforma de comunicação com chat interno, notificações push, integração com WhatsApp Business, email marketing e SMS marketing.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu interfaces de chat em tempo real, criou o sistema de notificações push personalizáveis e interfaces para email marketing.
    * **Ana Clara:** Implementou WebSockets para o chat, a integração com a API do WhatsApp Business e APIs para SMS marketing.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 14/04/2026 - 26/04/2026.

**Sprint 21: Gestão de Múltiplas Filiais**
* **O que foi feito:** Sistema multi-tenant para gestão de múltiplas filiais com sincronização de dados, relatórios consolidados, transferência de produtos e gestão centralizada.
* **O que cada desenvolvedor fez:**
    * **Diego:** Implementou a arquitetura multi-tenant no banco de dados, criou um sistema de sincronização e particionamento por tenant.
    * **Roberto:** Desenvolveu APIs para gestão multi-filial, implementou o sistema de transferência entre filiais e o sistema de permissões hierárquicas.
* Período de desenvolvimento: 9 dias.
* Período de testes: 3 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 27/04/2026 - 11/05/2026.

**Sprint 22: Sistema de Sustentabilidade**
* **O que foi feito:** Módulo de sustentabilidade com cálculo de pegada de carbono, gestão de resíduos, controle de consumo energético e relatórios ambientais.
* **O que cada desenvolvedor fez:**
    * **Fernanda:** Criou testes para cálculos de sustentabilidade, testes de integração com sensores IoT e testes para relatórios ambientais.
    * **Camila:** Desenvolveu dashboards de sustentabilidade, interfaces para gestão de resíduos e relatórios visuais de impacto ambiental.
* Período de desenvolvimento: 6 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 12/05/2026 - 23/05/2026.

**Sprint 23: Integração com IoT e Automação**
* **O que foi feito:** Integração com dispositivos IoT para monitoramento de temperatura, sensores de movimento, automação de iluminação e balanças inteligentes.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Desenvolveu APIs para coleta de dados IoT, criou um sistema de alertas e um dashboard para monitoramento em tempo real.
    * **Diego:** Configurou o banco de dados para dados de sensores, implementou um sistema de time-series para métricas IoT e análise preditiva.
* Período de desenvolvimento: 8 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 24/05/2026 - 06/06/2026.

**Sprint 24: Sistema de Treinamento e Onboarding**
* **O que foi feito:** Plataforma de e-learning integrada com cursos personalizados, certificações internas, gamificação do aprendizado e acompanhamento de progresso.
* **O que cada desenvolvedor fez:**
    * **Camila:** Desenvolveu a plataforma de e-learning responsiva, criou o sistema de progresso gamificado e a interface para criação de cursos.
    * **Roberto:** Implementou o back-end para gestão de cursos, desenvolveu o sistema de certificações e APIs para tracking de progresso.
* Período de desenvolvimento: 7 dias.
* Período de testes: 2 dias.
* Período de revisão: 2 dias.
* Período de deploy: 1 dia.
* Data inicial e final da Sprint: 07/06/2026 - 19/06/2026.

**Sprint 25: Testes Finais e Deploy de Produção**
* **O que foi feito:** Testes de integração, testes de carga, ajustes de performance, documentação final, treinamento da equipe de suporte e deploy definitivo em produção.
* **O que cada desenvolvedor fez:**
    * **Ana Clara:** Coordenou os testes finais de integração, realizou code review e documentou a arquitetura.
    * **Roberto:** Executou testes de carga e performance, otimizou queries críticas e configurou o monitoramento de produção.
    * **Camila:** Realizou testes de usabilidade, ajustou interfaces e criou a documentação do usuário.
    * **Diego:** Configurou o ambiente de produção, realizou a migração de dados e implementou o monitoramento de infraestrutura.
    * **Fernanda:** Executou testes automatizados, testes de segurança e criou o plano de testes de regressão.
* Período de desenvolvimento: 10 dias.
* Período de testes: 5 dias.
* Período de revisão: 3 dias.
* Período de deploy: 2 dias.
* Data inicial e final da Sprint: 20/06/2026 - 09/07/2026.

---

**Resumo da Equipe sobre Metodologia Ágil**
**Vantagens da Implementação Scrum**
* **Flexibilidade e Adaptação:** A metodologia Scrum permitiu que nossa equipe se adaptasse rapidamente às mudanças de requisitos e feedback dos stakeholders.
* **Entrega de Valor Contínuo:** Com sprints de 9-13 dias, entregamos funcionalidades utilizáveis ao final de cada ciclo, permitindo feedback valioso do cliente.
* **Comunicação e Transparência:** As daily standups e retrospectivas criaram um ambiente de comunicação aberta, onde problemas foram resolvidos rapidamente.
* **Qualidade do Código:** A revisão de código e os testes em cada sprint garantiram alta qualidade do produto final, com menos bugs em produção.
* **Motivação da Equipe:** Ver o progresso tangível a cada sprint manteve a equipe motivada e engajada.

**Dificuldades Encontradas**
* **Estimativas Iniciais Imprecisas:** A equipe subestimou a complexidade de algumas funcionalidades, como as integrações fiscais (Sprint 15) e o sistema de IoT (Sprint 23).
* **Dependências Externas:** Integrações com APIs de terceiros (sistemas bancários, SEFAZ, delivery platforms) causaram atrasos.
* **Mudanças de Escopo:** Algumas mudanças de escopo no meio do projeto impactaram sprints já planejadas.
* **Sobrecarga de Reuniões:** A quantidade de cerimônias Scrum foi percebida como excessiva em alguns momentos.

**Principais Dificuldades - "Calcanhar de Aquiles"**
* **Gerenciamento de Débito Técnico:** O maior desafio foi equilibrar a velocidade de entrega com a qualidade técnica.
* **Sincronização entre Front-end e Back-end:** Coordenar o desenvolvimento simultâneo de APIs e interfaces exigiu comunicação constante.
* **Testes de Integração Complexos:** À medida que o sistema cresceu, os testes de integração se tornaram mais complexos e demorados.
* **Gestão de Ambientes:** Manter ambientes de desenvolvimento, teste e staging sincronizados e funcionais foi um desafio constante.
* **Documentação Concorrente:** Manter a documentação atualizada durante o desenvolvimento ágil foi desafiador.

**Lições Aprendidas**
* **Investimento em Automação:** A automação de testes e deploy (CI/CD) foi fundamental para manter a qualidade e velocidade de entrega.
* **Definition of Done Clara:** Ter critérios bem definidos do que constitui uma funcionalidade "pronta" evitou retrabalho.
* **Priorização Rigorosa:** A participação ativa do Product Owner na priorização do backlog foi crucial.
* **Retrospectivas Efetivas:** As retrospectivas se mostraram fundamentais para a evolução contínua da equipe.

**Recomendações para Projetos Futuros**
* Investir mais tempo no Sprint 0 para definição de arquitetura e padrões de código.
* Criar um buffer de 15-20% no planejamento para lidar com imprevistos.
* Implementar pair programming mais sistematicamente, especialmente em funcionalidades críticas.
* Estabelecer contratos de API antes do desenvolvimento paralelo de front e back-end.
* Dedicar tempo específico para redução de débito técnico em cada sprint.

**Conclusão**

Apesar dos desafios, a metodologia Scrum se mostrou extremamente eficaz para o desenvolvimento do SuperMarket Pro. A capacidade de adaptar-se às mudanças, entregar valor continuamente e manter a qualidade técnica resultou em um produto robusto e alinhado às necessidades reais do mercado. A experiência fortaleceu nossa equipe e estabeleceu processos maduros que serão aplicados em projetos futuros.
