package Model;

public class Compra {
    private Cliente cliente;
    private Jogo jogo;
    private boolean processada;

    public Compra(Cliente cliente, Jogo jogo) {
        this.cliente = cliente;
        this.jogo = jogo;
        this.processada = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public boolean isProcessada() {
        return processada;
    }

    public void marcarComoProcessada() {
        this.processada = true;
    }
}
