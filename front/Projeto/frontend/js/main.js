class LojaVirtual {
  constructor() {
    this.produtos = []
    this.categorias = []
    this.filtroAtual = null
    this.termoPesquisa = ""
    this.init()
  }

  async init() {
    try {
      await this.carregarCategorias()
      await this.carregarProdutos()
      this.setupEventListeners()
    } catch (error) {
      console.error("Erro ao inicializar loja:", error)
      this.mostrarErro("Erro ao carregar a loja. Verifique se o servidor está rodando.")
    }
  }

  setupEventListeners() {

    const formPesquisa = document.getElementById("form-pesquisa")
    const inputPesquisa = document.getElementById("input-pesquisa")

    formPesquisa.addEventListener("submit", (e) => {
      e.preventDefault()
      const termo = inputPesquisa.value.trim()
      if (termo) {
        this.pesquisarProdutos(termo)
      } else {
        this.carregarProdutos()
      }
    })


    inputPesquisa.addEventListener("input", (e) => {
      if (e.target.value.trim() === "") {
        this.carregarProdutos()
      }
    })
  }

  async carregarCategorias() {
    try {
      const API = window.API
      this.categorias = await API.getCategorias()
      this.renderizarMenuCategorias()
    } catch (error) {
      console.error("Erro ao carregar categorias:", error)
    }
  }

  renderizarMenuCategorias() {
    const menu = document.getElementById("categorias-menu")
    menu.innerHTML = this.categorias
      .map(
        (categoria) => `
            <li><a class="dropdown-item py-2 px-3 fw-semibold" href="#" onclick="loja.filtrarPorCategoria('${categoria.id}')">${categoria.nome}</a></li>
        `,
      )
      .join("")
  }

  async carregarProdutos() {
    this.mostrarLoading(true)
    try {
      const API = window.API
      this.produtos = await API.getProdutos()
      this.renderizarProdutos(this.produtos)
      this.atualizarBreadcrumb("Todos os Produtos")
      this.filtroAtual = null
      this.termoPesquisa = ""
    } catch (error) {
      console.error("Erro ao carregar produtos:", error)
      this.mostrarErro("Erro ao carregar produtos")
    } finally {
      this.mostrarLoading(false)
    }
  }

  async filtrarPorCategoria(categoria) {
    this.mostrarLoading(true)
    try {
      const API = window.API
      const catNome = await API.getCategoria(categoria)
      this.produtos = await API.getProdutosPorCategoria(categoria)
      this.renderizarProdutos(this.produtos)
      this.atualizarBreadcrumb(catNome.nome)
      this.filtroAtual = categoria
      this.termoPesquisa = ""

      // Limpar campo de pesquisa
      document.getElementById("input-pesquisa").value = ""
    } catch (error) {
      console.error("Erro ao filtrar por categoria:", error)
      this.mostrarErro("Erro ao filtrar produtos")
    } finally {
      this.mostrarLoading(false)
    }
  }

  async pesquisarProdutos(termo) {
    this.mostrarLoading(true)
    try {
      const API = window.API
      this.produtos = await API.buscarProdutos(termo)
      this.renderizarProdutos(this.produtos)
      this.atualizarBreadcrumb(`Pesquisa: "${termo}"`)
      this.filtroAtual = null
      this.termoPesquisa = termo
    } catch (error) {
      console.error("Erro ao pesquisar produtos:", error)
      this.mostrarErro("Erro ao pesquisar produtos")
    } finally {
      this.mostrarLoading(false)
    }
  }

  renderizarProdutos(produtos) {


    const container = document.getElementById("produtos-container")
    const noProducts = document.getElementById("no-products")

    if (produtos.length === 0) {
      container.innerHTML = ""
      noProducts.classList.remove("d-none")
      return
    }

    noProducts.classList.add("d-none")
    container.innerHTML = this.embaralharProdutos(produtos).map((produto) => this.criarCardProduto(produto)).join("")
  }

  embaralharProdutos(produtos) {
    return [...produtos].sort(() => Math.random() - 0.5);
  }

  criarCardProduto(produto) {
    const semEstoque = produto.quantidade === 0
    const estoqueBaixo = produto.quantidade > 0 && produto.quantidade <= 5

    let statusEstoque = ""
    let classEstoque = ""
    let badgeEstoque = ""

    if (semEstoque) {
      statusEstoque = "Sem estoque"
      classEstoque = "text-danger fw-bold"
      badgeEstoque = "bg-danger"
    } else if (estoqueBaixo) {
      statusEstoque = `Apenas ${produto.quantidade} em estoque`
      classEstoque = "text-warning fw-bold"
      badgeEstoque = "bg-warning"
    } else {
      statusEstoque = `${produto.quantidade} em estoque`
      classEstoque = "text-muted"
      badgeEstoque = "bg-success"
    }
    const categoria = this.categorias.find(cat => cat.id === produto.categoria)
    return `
            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
                <div class="card product-card h-100 shadow-sm border-0 fade-in">
                    <div class="product-image-container position-relative">
                        <img src="${produto.imagem}" alt="${produto.nome}" class="product-image">
                        <span class="badge ${badgeEstoque} position-absolute top-0 end-0 m-2 small">
                            ${produto.quantidade} Un
                        </span>
                    </div>
                    <div class="card-body d-flex flex-column p-3">
                        <div class="mb-2">
                            <span class="badge categoria text-white small fw-semibold px-2 py-1" style="--categoria-cor: ${categoria.cor};">
                              ${categoria.nome}
                            </span>
                        </div>
                        <h5 class="card-title fw-bold mb-2 text-dark">${produto.nome}</h5>
                        <p class="fs-4 fw-bold text-success mb-2">R$ ${produto.valor.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</p>
                        <p class="small ${classEstoque} mb-3">${statusEstoque}</p>
                        <div class="mt-auto">
                            <button 
                                class="btn ${semEstoque ? "btn-outline-secondary" : "btn-primary"} w-100 fw-semibold py-2 shadow-sm" 
                                onclick="window.carrinho.adicionarProduto(${produto.id})"
                                ${semEstoque ? "disabled" : ""}
                            >
                                <span class="me-2">🛒</span>
                                ${semEstoque ? "Sem Estoque" : "Adicionar ao Carrinho"}
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        `
  }

  atualizarBreadcrumb(texto) {
    const breadcrumb = document.getElementById("breadcrumb")
    breadcrumb.innerHTML = `<li class="breadcrumb-item active fw-semibold text-primary">${texto}</li>`
  }

  mostrarLoading(mostrar) {
    const loading = document.getElementById("loading")
    const container = document.getElementById("produtos-container")
    const noProducts = document.getElementById("no-products")

    if (mostrar) {
      loading.classList.remove("d-none")
      container.innerHTML = ""
      noProducts.classList.add("d-none")
    } else {
      loading.classList.add("d-none")
    }
  }

  mostrarErro(mensagem) {
    const container = document.getElementById("produtos-container")
    container.innerHTML = `
            <div class="col-12">
                <div class="alert alert-danger text-center border-0 shadow-sm py-4" role="alert">
                    <div class="text-danger mb-3" style="font-size: 3rem;">⚠️</div>
                    <h5 class="fw-bold mb-2">Ops! Algo deu errado</h5>
                    <p class="mb-3">${mensagem}</p>
                    <button class="btn btn-danger" onclick="loja.carregarProdutos()">
                        Tentar Novamente
                    </button>
                </div>
            </div>
        `
  }
}

document.addEventListener("DOMContentLoaded", () => {
  window.loja = new LojaVirtual()
  window.carrinho = new window.Carrinho()
})
