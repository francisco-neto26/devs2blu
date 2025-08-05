package exercicios.exer01;

public class Veiculo {
    private String marca;
    private int ano;

    public Veiculo(int ano, String marca) {
        this.ano = ano;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo da" +
                " marca = " + marca + '\'' +
                ", ano = " + ano;
    }
}
