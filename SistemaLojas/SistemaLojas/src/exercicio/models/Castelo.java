package exercicio.models;

public class Castelo {
    private int id;
    private String nome;
    private String localizacao;
    private int numeroTorres;
    private boolean temFosso;
    private int capacidadeSoldados;
    private static int contadorId;

    public Castelo(String nome, String localizacao, int numeroTorres, boolean temFosso, int capacidadeSoldados) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.localizacao = localizacao;
        this.numeroTorres = numeroTorres;
        this.temFosso = temFosso;
        this.capacidadeSoldados = capacidadeSoldados;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getNumeroTorres() {
        return numeroTorres;
    }

    public void setNumeroTorres(int numeroTorres) {
        this.numeroTorres = numeroTorres;
    }

    public boolean getTemFosso() {
        return temFosso;
    }

    public void setTemFosso(boolean temFosso) {
        this.temFosso = temFosso;
    }

    public int getCapacidadeSoldados() {
        return capacidadeSoldados;
    }

    public void setCapacidadeSoldados(int capacidadeSoldados) {
        this.capacidadeSoldados = capacidadeSoldados;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Castelo.contadorId = contadorId;
    }
}
