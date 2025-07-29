package exemplo01.Models;


public class Categoria {
    private int id;
    private String nome;
    private static int contadorId;

    public Categoria(String nome) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

