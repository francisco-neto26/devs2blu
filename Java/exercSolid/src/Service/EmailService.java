package Service;

import Model.Cliente;
import Model.Jogo;

public class EmailService {

    public void enviarEmailConfirmacao(Cliente cliente, Jogo jogo) {
        System.out.println("Email de confirmação enviado para " + cliente.getNome() +
                " sobre a compra do jogo " + jogo.getNome());
    }
}