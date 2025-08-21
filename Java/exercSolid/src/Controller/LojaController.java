package Controller;

import Interface.LojaView;
import Model.Cliente;
import Model.CompraModel;
import Model.Jogo;

public class LojaController {
    private LojaView view;
    private CompraModel compraModel;
    private Cliente cliente;
    private Jogo jogo1;
    private Jogo jogo2;

    public LojaController() {
        this.view = new LojaView();
        this.compraModel = new CompraModel();

        // Inicializa dados
        this.jogo1 = new Jogo("Super Mario", 150, 5);
        this.jogo2 = new Jogo("Zelda", 200, 3);
        this.cliente = new Cliente("Lucas", "lucas@email.com");
    }

    public void executar() {
        int opcao = 0;

        while (opcao != 3) {
            view.exibirMenu();
            opcao = view.obterOpcaoUsuario();

            processarOpcao(opcao);
        }

        view.exibirSaida();
        view.fechar();
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                processarCompra(jogo1);
                break;
            case 2:
                processarCompra(jogo2);
                break;
            case 3:
                // Sair - não faz nada
                break;
            default:
                view.exibirOpcaoInvalida();
                break;
        }
    }

    private void processarCompra(Jogo jogo) {
        // Verifica estoque antes de tentar comprar
        if (!compraModel.verificarEstoque(jogo)) {
            view.exibirJogoEsgotado(jogo.getNome());
            return;
        }

        // Tenta realizar a compra
        boolean sucesso = compraModel.realizarCompra(cliente, jogo);

        if (sucesso) {
            view.exibirSucesso(jogo.getNome(), cliente.getNome());
        } else {
            view.exibirErro("Falha no processamento da compra");
        }
    }
}

