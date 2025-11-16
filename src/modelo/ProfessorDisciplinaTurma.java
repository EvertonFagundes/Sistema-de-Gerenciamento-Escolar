package modelo;

public class ProfessorDisciplinaTurma {
    private int id;
    private Turma turma;
    private Disciplina disciplina;
    private Professor professor;

    public ProfessorDisciplinaTurma(Professor professor,  Disciplina disciplina, Turma turma){
        this.professor = professor;
        this.disciplina = disciplina;
        this.turma = turma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
