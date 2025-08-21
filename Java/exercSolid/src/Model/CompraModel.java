package Model;

import Service.EmailService;
import Service.EstoqueService;
import Service.PagamentoService;

public class CompraModel {
    private EstoqueService estoqueService;
    private PagamentoService pagamentoService;
    private EmailService emailService;

    public CompraModel() {
        this.estoqueService = new EstoqueService();
        this.pagamentoService = new PagamentoService();
        this.emailService = new EmailService();
    }

    public boolean realizarCompra(Cliente cliente, Jogo jogo) {
        if (!estoqueService.temEstoque(jogo)) {
            return false;
        }

        Compra compra = new Compra(cliente, jogo);

        boolean pagamentoOk = pagamentoService.processarCartao(cliente, jogo.getPreco());
        if (!pagamentoOk) {
            return false;
        }

        boolean estoqueOk = estoqueService.diminuirEstoque(jogo);
        if (!estoqueOk) {
            return false;
        }

        compra.marcarComoProcessada();
        emailService.enviarEmailConfirmacao(cliente, jogo);

        return true;
    }

    public boolean verificarEstoque(Jogo jogo) {
        return estoqueService.temEstoque(jogo);
    }
}