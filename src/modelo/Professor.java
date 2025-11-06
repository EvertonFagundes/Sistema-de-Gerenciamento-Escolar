package modelo;

import java.util.ArrayList;

public class Professor extends Usuario{
    private String formacaoAcademica;
    private ArrayList<Disciplina>disciplinasLeciona = new ArrayList<>();
    private ArrayList<Turma> turmasLeciona = new ArrayList<>();
    //construtor com o ArrayList de disciplinas e turmas
    public Professor(String nome, String cpf, String rg, String matricula, String email, int diaNasc, int mesNasc, int anoNasc,String nomeRua, String nomeBairro, String nomeCidade, int numeroCasa, String complemento, String numeroTelefone, String senha, String formacaoAcademica, ArrayList<Disciplina> disciplinasLeciona){
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
        setPerfil("PROFESSOR");
        this.formacaoAcademica = formacaoAcademica;
        this.disciplinasLeciona = disciplinasLeciona;
    }
    //construtor sem o ArrayList de disciplinas
    public Professor(String nome, String cpf, String rg, String matricula, String email, int diaNasc, int mesNasc, int anoNasc,String nomeRua, String nomeBairro, String nomeCidade, int numeroCasa, String complemento, String numeroTelefone, String senha, String formacaoAcademica){
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
        setPerfil("PROFESSOR");
        this.formacaoAcademica = formacaoAcademica;
    }
    //construtor com ArrayList de disciplinas e de turmas
    public Professor(String nome, String cpf, String rg, String matricula, String email, int diaNasc, int mesNasc, int anoNasc,String nomeRua, String nomeBairro, String nomeCidade, int numeroCasa, String complemento, String numeroTelefone, String senha, String formacaoAcademica, ArrayList<Disciplina> disciplinasLeciona, ArrayList<Turma> turmasLeciona){
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
        setPerfil("PROFESSOR");
        this.formacaoAcademica = formacaoAcademica;
        this.disciplinasLeciona = disciplinasLeciona;
        this.turmasLeciona = turmasLeciona;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public ArrayList<Disciplina> getDisciplinasLeciona() {
        return disciplinasLeciona;
    }

    public void setDisciplinasLeciona(ArrayList<Disciplina> disciplinasLeciona) {
        this.disciplinasLeciona = disciplinasLeciona;
    }

    public ArrayList<Turma> getTurmasLeciona() {
        return turmasLeciona;
    }

    public void setTurmasLeciona(ArrayList<Turma> turmasLeciona) {
        this.turmasLeciona = turmasLeciona;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
