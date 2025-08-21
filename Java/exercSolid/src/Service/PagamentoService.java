package Service;

import Model.Cliente;

public class PagamentoService {

    public boolean processarCartao(Cliente cliente, double valor) {
        System.out.println("Pagamento de R$" + valor + " processado para " + cliente.getNome());
        return true;
    }
}
