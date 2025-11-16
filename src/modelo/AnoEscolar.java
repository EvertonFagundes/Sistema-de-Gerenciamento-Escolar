package modelo;
import dao.Services;

public class AnoEscolar {
    private int ano; //2025, 2024, etc
    private String periodoLetivo; //bimestres,trimestres,semestres
    private String codigo;
    private boolean situacao;//ativo ou não ativo

    public AnoEscolar(){
    }
    
    public AnoEscolar(int ano, String periodoLetivo){
        this.ano = ano;
        this.periodoLetivo = periodoLetivo;
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

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
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

}
