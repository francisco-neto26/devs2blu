package exercicios.exer01;

public class Aviao extends Veiculo {
    private String comAeria;

    public Aviao(int ano, String marca, String comAeria) {
        super(ano, marca);
        this.comAeria = comAeria;
    }

    public String getComAeria() {
        return comAeria;
    }

    public void setComAeria(String comAeria) {
        this.comAeria = comAeria;
    }

    @Override
    public String toString() {
        String txt = super.toString();
        return txt + ", Companhia Aeria: " + this.comAeria;
    }
}
