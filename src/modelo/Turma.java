package modelo;

import java.util.ArrayList;
import java.util.Map;

import dao.Services;

public class Turma extends AnoEscolar{
    private String identificador; //ex: A, C etc
    private String codigo;
    private ArrayList<String>alunosTurma = new ArrayList<>();
    private ArrayList<String>professoresLeciona = new ArrayList<>();

    public Turma(){
    }

    public Turma(int ano, String identificador){
        super(ano);
        this.identificador = identificador;
    }

    public Turma(int ano, ArrayList<String>alunosTurma, String identificador){
        super(ano);
        this.alunosTurma = alunosTurma; 
        this.identificador = identificador;
    }

    public ArrayList<String> getAlunosTurma() {
        return alunosTurma;
    }

    public void setAlunosTurma(ArrayList<String> alunosTurma) {
        this.alunosTurma = alunosTurma;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<String> getProfessoresLeciona() {
        return professoresLeciona;
    }

    public void setProfessoresLeciona(ArrayList<String> professoresLeciona) {
        this.professoresLeciona = professoresLeciona;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        Map<String, String> dados = Services.lerDados("src/dao/settings.txt");
        return dados.get("codigoTurma");
    }
}
