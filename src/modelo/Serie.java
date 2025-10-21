package modelo;

import java.util.ArrayList;

public class Serie extends AnoEscolar{
    ArrayList<Turma>turmas1Ano = new ArrayList<>();
    ArrayList<Turma>turmas2Ano = new ArrayList<>();
    ArrayList<Turma>turmas3Ano = new ArrayList<>();

    public Serie(int ano, ArrayList<Turma>turmas1ano, ArrayList<Turma>turmas2Ano, ArrayList<Turma>turmas3Ano){
        super(ano);
        this.turmas1Ano = new ArrayList<>();
        this.turmas2Ano = new ArrayList<>();
        this.turmas3Ano = new ArrayList<>();
    }

    public ArrayList<Turma> getTurmas1Ano() {
        return turmas1Ano;
    }

    public void setTurmas1Ano(ArrayList<Turma> turmas1Ano) {
        this.turmas1Ano = turmas1Ano;
    }

    public ArrayList<Turma> getTurmas2Ano() {
        return turmas2Ano;
    }
    
    public void setTurmas2Ano(ArrayList<Turma> turmas2Ano) {
        this.turmas2Ano = turmas2Ano;
    }

    public ArrayList<Turma> getTurmas3Ano() {
        return turmas3Ano;
    }

    public void setTurmas3Ano(ArrayList<Turma> turmas3Ano) {
        this.turmas3Ano = turmas3Ano;
    }
}
