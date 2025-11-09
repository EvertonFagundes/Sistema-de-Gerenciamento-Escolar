package modelo;

import java.util.ArrayList;

public class Turma extends AnoEscolar{
    private String identificador; //ex: A, C etc
    private ArrayList<Aluno>alunosTurma = new ArrayList<>();

    public Turma(int ano, String identificador){
        super(ano);
        this.identificador = identificador;
    }

    public Turma(int ano, ArrayList<Aluno>alunosTurma, String identificador){
        super(ano);
        this.alunosTurma = alunosTurma; 
        this.identificador = identificador;
    }

    public ArrayList<Aluno> getAlunosTurma() {
        return alunosTurma;
    }

    public void setAlunosTurma(ArrayList<Aluno> alunosTurma) {
        this.alunosTurma = alunosTurma;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return getAno() + " ano " + getIdentificador();
    }
}
