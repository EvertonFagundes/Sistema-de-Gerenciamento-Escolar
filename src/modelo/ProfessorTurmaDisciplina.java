package modelo;

public class ProfessorTurmaDisciplina {
    public int id;
    public Turma turma;
    public Disciplina disciplina;
    public Professor professor;

    public ProfessorTurmaDisciplina(Turma turma, Disciplina disciplina, Professor professor){
        this.turma = turma;
        this.professor = professor;
        this.disciplina = disciplina;
    }


    
}
