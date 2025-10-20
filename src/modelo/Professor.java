package modelo;

import java.util.ArrayList;

public class Professor extends Usuario{
    String formacaoAcademica;
    ArrayList<Disciplina>disciplinasLeciona = new ArrayList<>();

    public Professor(String nome, String cpf, String rg, String matricula, String email, int diaNasc, int mesNasc, int anoNasc,String nomeRua, String nomeBairro, String nomeCidade, int numeroCasa, String complemento, int numeroTelefone, String formacaoAcademica, ArrayList<Disciplina>disciplinasLeciona){
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone);
        this.formacaoAcademica = formacaoAcademica;
        this.disciplinasLeciona = disciplinasLeciona;
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
    
}
