package modelo;

import java.util.ArrayList;

public class Serie{
    private String nome;
    private ArrayList<Turma> turmas = new ArrayList<>();

    public Serie(){
    }

    public Serie(String nome, ArrayList<Turma> turmas){
        this.nome = nome;
        this.turmas = turmas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
