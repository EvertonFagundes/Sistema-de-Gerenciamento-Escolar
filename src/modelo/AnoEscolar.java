package modelo;
import java.util.ArrayList;

import dao.Services;

public class AnoEscolar {
    private int ano; //2025, 2024, etc
    private ArrayList<PeriodoLetivo> periodos; //bimestres,trimestres,semestres
    private String codigo;
    private boolean situacao;//ativo ou não ativo
    private ArrayList<Serie> series = new ArrayList<>();

    public AnoEscolar(){
    }
    
    public AnoEscolar(int ano, ArrayList<PeriodoLetivo> periodoLetivo){
        this.ano = ano;
        this.periodos = periodos;
        this.situacao = true;
    }

    public AnoEscolar(int ano){
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ArrayList<PeriodoLetivo> getPeriodoLetivo() {
        return periodos;
    }

    public void setPeriodoLetivo(ArrayList<PeriodoLetivo> periodos) {
        this.periodos = periodos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean getSituacao(){
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public ArrayList<Serie> getSeries(){
        return series;
    }

    public void setSeries(ArrayList<Serie> series) {
        this.series = series;
    }
}
