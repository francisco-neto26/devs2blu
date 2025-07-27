class Carrinho {
  constructor() {
    this.items = []
    this.total = 0
    this.init()
  }

  init() {
    this.carregarCarrinho()
    this.setupEventListeners()
  }

  setupEventListeners() {
    document.getElementById("btn-finalizar-compra").addEventListener("click", () => {
      this.finalizarCompra()
    })
  }

  async carregarCarrinho() {
    try {
      const carrinho = await window.API.getCarrinho()
      this.items = carrinho
      this.atualizarInterface()
    } catch (error) {
      console.error("Erro ao carregar carrinho:", error)
      this.mostrarToast("Erro ao carregar carrinho", "error")
    }
  }

  async adicionarProduto(produtoId, quantidade = 1) {
    try {
      await window.API.adicionarAoCarrinho(produtoId, quantidade)
      await this.carregarCarrinho()
      this.mostrarToast("Produto adicionado ao carrinho!", "success")
    } catch (error) {
      console.error("Erro ao adicionar produto:", error)
      this.mostrarToast(error.message, "error")
    }
  }

  async removerProduto(produtoId) {
    try {
      await window.API.removerDoCarrinho(produtoId)
      await this.carregarCarrinho()
      this.mostrarToast("Produto removido do carrinho", "info")
    } catch (error) {
      console.error("Erro ao remover produto:", error)
      this.mostrarToast("Erro ao remover produto", "error")
    }
  }

  async atualizarQuantidade(produtoId, quantidade) {
    try {
      await window.API.atualizarCarrinho(produtoId, quantidade)
      await this.carregarCarrinho()
    } catch (error) {
      console.error("Erro ao atualizar quantidade:", error)
      this.mostrarToast(error.message, "error")
    }
  }

  async finalizarCompra() {
    if (this.items.length === 0) {
      this.mostrarToast("Carrinho vazio!", "warning")
      return
    }

    try {
      await window.API.finalizarCompra()
      await this.carregarCarrinho()

      const offcanvas = window.bootstrap.Offcanvas.getInstance(document.getElementById("offcanvasCarrinho"))
      if (offcanvas) {
        offcanvas.hide()
      }

      const modal = new window.bootstrap.Modal(document.getElementById("modalSucesso"))
      modal.show()

      if (window.loja) {
        window.loja.carregarProdutos()
      }
    } catch (error) {
      console.error("Erro ao finalizar compra:", error)
      this.mostrarToast("Erro ao finalizar compra", "error")
    }
  }

  atualizarInterface() {
    this.atualizarContador()
    this.renderizarItens()
    this.calcularTotal()
  }

  atualizarContador() {
    const contador = document.getElementById("carrinho-count")
    const totalItens = this.items.reduce((total, item) => total + item.quantidade, 0)
    contador.textContent = totalItens
    contador.style.display = totalItens > 0 ? "inline" : "none"
  }

  renderizarItens() {
    const container = document.getElementById("carrinho-items")
    const carrinhoVazio = document.getElementById("carrinho-vazio")
    const carrinhoFooter = document.getElementById("carrinho-footer")

    if (this.items.length === 0) {
      container.innerHTML = ""
      carrinhoVazio.classList.remove("d-none")
      carrinhoFooter.classList.add("d-none")
      return
    }

    carrinhoVazio.classList.add("d-none")
    carrinhoFooter.classList.remove("d-none")

    container.innerHTML = this.items
      .map(
        (item) => `
            <div class="border-bottom pb-3 mb-3">
                <div class="row align-items-center g-3">
                    <div class="col-3">
                        <img src="${item.produto.imagem}" alt="${item.produto.nome}" class="carrinho-item-image rounded">
                    </div>
                    <div class="col-9">
                        <h6 class="fw-bold mb-1 text-dark">${item.produto.nome}</h6>
                        <p class="text-muted mb-2 small">R$ ${item.produto.valor.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })} cada</p>
                        
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="d-flex align-items-center gap-2">
                                <button class="btn btn-outline-secondary btn-sm quantity-btn d-flex align-items-center justify-content-center" 
                                        onclick="carrinho.atualizarQuantidade(${item.produtoId}, ${item.quantidade - 1})" 
                                        ${item.quantidade <= 1 ? "disabled" : ""}>
                                    −
                                </button>
                                <span class="fw-semibold px-2">${item.quantidade}</span>
                                <button class="btn btn-outline-secondary btn-sm quantity-btn d-flex align-items-center justify-content-center" 
                                        onclick="carrinho.atualizarQuantidade(${item.produtoId}, ${item.quantidade + 1})" 
                                        ${item.quantidade >= item.produto.quantidade ? "disabled" : ""}>
                                    +
                                </button>
                            </div>
                            
                            <div class="d-flex align-items-center gap-2">
                                <span class="fw-bold text-success">R$ ${(item.produto.valor * item.quantidade).toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</span>
                                <button class="btn btn-outline-danger btn-sm" onclick="carrinho.removerProduto(${item.produtoId})" title="Remover item">
                                    🗑️
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `,
      )
      .join("")
  }

  calcularTotal() {
    this.total = this.items.reduce((total, item) => total + item.produto.valor * item.quantidade, 0)
    document.getElementById("carrinho-total").textContent = `R$ ${this.total.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`
  }

  mostrarToast(mensagem, tipo = "info") {
    let toastContainer = document.querySelector(".toast-container")
    if (!toastContainer) {
      toastContainer = document.createElement("div")
      toastContainer.className = "toast-container position-fixed top-0 end-0 p-3"
      toastContainer.style.zIndex = "1055"
      document.body.appendChild(toastContainer)
    }

    const toastId = "toast-" + Date.now()
    const bgClass =
      {
        success: "bg-success",
        error: "bg-danger",
        warning: "bg-warning",
        info: "bg-info",
      }[tipo] || "bg-info"

    const toastHTML = `
            <div id="${toastId}" class="toast border-0 shadow-lg" role="alert">
                <div class="toast-header ${bgClass} text-white border-0">
                    <strong class="me-auto fw-bold">🛍️ BuyOn</strong>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast"></button>
                </div>
                <div class="toast-body bg-white fw-semibold">
                    ${mensagem}
                </div>
            </div>
        `

    toastContainer.insertAdjacentHTML("beforeend", toastHTML)

    const toastElement = document.getElementById(toastId)
    const toast = new window.bootstrap.Toast(toastElement, { delay: 1000 })
    toast.show()

    toastElement.addEventListener("hidden.bs.toast", () => {
      toastElement.remove()
    })
  }
}

window.Carrinho = Carrinho
