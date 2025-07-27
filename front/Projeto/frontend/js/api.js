// Configuração da API
const API_BASE_URL = "http://localhost:3000/api"

// Classe para gerenciar as chamadas da API
class API {
  static async get(endpoint) {
    try {
      const response = await fetch(`${API_BASE_URL}${endpoint}`)
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }
      return await response.json()
    } catch (error) {
      console.error("Erro na requisição GET:", error)
      throw error
    }
  }

  static async post(endpoint, data) {
    try {
      const response = await fetch(`${API_BASE_URL}${endpoint}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })

      if (!response.ok) {
        const errorData = await response.json()
        throw new Error(errorData.error || `HTTP error! status: ${response.status}`)
      }

      return await response.json()
    } catch (error) {
      console.error("Erro na requisição POST:", error)
      throw error
    }
  }

  static async put(endpoint, data) {
    try {
      const response = await fetch(`${API_BASE_URL}${endpoint}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })

      if (!response.ok) {
        const errorData = await response.json()
        throw new Error(errorData.error || `HTTP error! status: ${response.status}`)
      }

      return await response.json()
    } catch (error) {
      console.error("Erro na requisição PUT:", error)
      throw error
    }
  }

  static async delete(endpoint) {
    try {
      const response = await fetch(`${API_BASE_URL}${endpoint}`, {
        method: "DELETE",
      })

      if (!response.ok) {
        const errorData = await response.json()
        throw new Error(errorData.error || `HTTP error! status: ${response.status}`)
      }

      return await response.json()
    } catch (error) {
      console.error("Erro na requisição DELETE:", error)
      throw error
    }
  }

  // Métodos específicos para produtos
  static async getProdutos() {
    return this.get("/produtos")
  }

  static async getProduto(id) {
    return this.get(`/produtos/${id}`)
  }

  static async getProdutosPorCategoria(categoria) {
    return this.get(`/produtos/categoria/${categoria}`)
  }

  static async buscarProdutos(termo) {
    return this.get(`/produtos/buscar/${termo}`)
  }

  static async getCategorias() {
    return this.get("/categorias")
  }

  static async getCategoria(id) {
    return this.get(`/categorias/${id}`)
  }

  // Métodos específicos para carrinho
  static async getCarrinho() {
    return this.get("/carrinho")
  }

  static async adicionarAoCarrinho(produtoId, quantidade) {
    return this.post("/carrinho/adicionar", { produtoId, quantidade })
  }

  static async removerDoCarrinho(produtoId) {
    return this.delete(`/carrinho/remover/${produtoId}`)
  }

  static async atualizarCarrinho(produtoId, quantidade) {
    return this.put(`/carrinho/atualizar/${produtoId}`, { quantidade })
  }

  static async finalizarCompra() {
    return this.post("/carrinho/finalizar", {})
  }
}

window.API = API