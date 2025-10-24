package modelo;

import java.util.ArrayList;

public class Professor extends Usuario{
    private String formacaoAcademica;
    private ArrayList<Disciplina>disciplinasLeciona = new ArrayList<>();

    public Professor(String nome, String cpf, String rg, String matricula, String email, int diaNasc, int mesNasc, int anoNasc,String nomeRua, String nomeBairro, String nomeCidade, int numeroCasa, String complemento, String numeroTelefone, String senha, String formacaoAcademica, ArrayList<Disciplina>disciplinasLeciona){
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
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

    @Override
    public String toString() {
        return getNome();
    }
    
}
