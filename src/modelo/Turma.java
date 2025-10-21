package modelo;

import java.util.ArrayList;

public class Turma extends AnoEscolar{
    String nome; //ex: 1A, 3C etc
    ArrayList<Aluno>alunosTurma = new ArrayList<>();

    public Turma(int ano, String nome){
        super(ano);
        this.nome = nome;
    }

    public Turma(int ano, ArrayList<Aluno>alunosTurma, String nome){
        super(ano);
        this.alunosTurma = new ArrayList<>(); 
        this.nome = nome;
    }

    public ArrayList<Aluno> getAlunosTurma() {
        return alunosTurma;
    }

    public void setAlunosTurma(ArrayList<Aluno> alunosTurma) {
        this.alunosTurma = alunosTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
