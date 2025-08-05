package exercicios.exer01;

public class Carro extends Veiculo{
    private String modelo;

    public Carro(int ano, String marca, String modelo) {
        super(ano, marca);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Carro(int ano, String marca) {
        super(ano, marca);
    }

    @Override
    public String toString() {
        String txt = super.toString();
        return txt + ", Modelo: " + this.modelo;
    }
}
