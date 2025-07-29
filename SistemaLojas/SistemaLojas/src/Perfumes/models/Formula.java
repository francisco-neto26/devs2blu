package Perfumes.models;

import java.util.Map;

public class Formula {
    private int id;
    private String nomeFormula;
    private String composicaoQuimica;
    private Map<String, Double> componentes; // Componentes e suas porcentagens (ex: "álcool" -> 70.0)
    private String tipoEssencia;
    private static int contadorId;

    public Formula(String nomeFormula, String composicaoQuimica, Map<String, Double> componentes, String tipoEssencia) {
        contadorId++;
        this.id = contadorId;
        this.nomeFormula = nomeFormula;
        this.composicaoQuimica = composicaoQuimica;
        this.componentes = componentes;
        this.tipoEssencia = tipoEssencia;
    }

    public String getNomeFormula() {
        return nomeFormula;
    }

    public int getId() {
        return id;
    }

    public void setNomeFormula(String nomeFormula) {
        this.nomeFormula = nomeFormula;
    }

    public String getComposicaoQuimica() {
        return composicaoQuimica;
    }

    public void setComposicaoQuimica(String composicaoQuimica) {
        this.composicaoQuimica = composicaoQuimica;
    }

    public Map<String, Double> getComponentes() {
        return componentes;
    }

    public void setComponentes(Map<String, Double> componentes) {
        this.componentes = componentes;
    }

    public String getTipoEssencia() {
        return tipoEssencia;
    }

    public void setTipoEssencia(String tipoEssencia) {
        this.tipoEssencia = tipoEssencia;
    }
}
