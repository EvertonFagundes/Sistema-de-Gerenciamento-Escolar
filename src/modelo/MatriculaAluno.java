package modelo;

public class MatriculaAluno {

    private String matriculaAluno;
    private String serie;
    private String turma;
    private String anoEscolar;

    public MatriculaAluno() {
    }

    public MatriculaAluno(String matriculaAluno, String serie, String turma, String anoEscolar) {
        this.matriculaAluno = matriculaAluno;
        this.serie = serie;
        this.turma = turma;
        this.anoEscolar = anoEscolar;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

}
