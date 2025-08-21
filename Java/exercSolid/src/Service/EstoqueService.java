package Service;

import Model.Jogo;

public class EstoqueService {

    public boolean temEstoque(Jogo jogo) {
        return jogo.getEstoque() > 0;
    }

    public boolean diminuirEstoque(Jogo jogo) {
        if (jogo.getEstoque() > 0) {
            jogo.setEstoque(jogo.getEstoque() - 1);
            atualizarEstoqueBanco(jogo);
            return true;
        }
        return false;
    }

    private void atualizarEstoqueBanco(Jogo jogo) {
        System.out.println("Estoque do jogo " + jogo.getNome() + " atualizado no banco de dados");
    }
}
