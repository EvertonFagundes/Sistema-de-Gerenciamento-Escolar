package modelo;

import java.util.ArrayList;

public class Aluno extends Usuario {
    private String situacao;
    private String nomeResponsavel;
    private int telefoneResponsavel;
    private String emailResponsavel;

    public Aluno(String nome, String cpf, String rg, String matricula, String email, int diaNasc, int mesNasc, int anoNasc,String nomeRua, String nomeBairro, String nomeCidade, int numeroCasa, String complemento, String numeroTelefone, String senha, String situacao, String nomeResponsavel, int telefoneResponsavel, String emailResponsavel){
        super(nomeResponsavel, cpf, rg, matricula, emailResponsavel, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
        setPerfil("ALUNO");
        this.situacao = situacao;
        this.nomeResponsavel = nomeResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
        this.emailResponsavel = emailResponsavel;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public int getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(int telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }
    
}
