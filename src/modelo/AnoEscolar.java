package modelo;

public class AnoEscolar {
    int ano; //1,2 ou 3
    String periodoLetivo; //bimestres,trimestres,semestres
    
    public AnoEscolar(int ano, String periodoLetivo){
        this.ano = ano;
        this.periodoLetivo = periodoLetivo;
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

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

}
