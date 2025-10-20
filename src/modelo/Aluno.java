package modelo;

public class Aluno {

    String nome;
    String cpf;
    String rg;
    String matricula;
    int diaNasc;
    int mesNasc;
    int anoNasc;
    String sitaucao;

    public Aluno(String nome, String cpf, String rg, String matricula, int diaNasc, int mesNasc, int anoNasc, String situacao){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.diaNasc = diaNasc;
        this.mesNasc = mesNasc;
        this.anoNasc = anoNasc;
        this.sitaucao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getDiaNasc() {
        return diaNasc;
    }

    public void setDiaNasc(int diaNasc) {
        this.diaNasc = diaNasc;
    }

    public int getMesNasc() {
        return mesNasc;
    }

    public void setMesNasc(int mesNasc) {
        this.mesNasc = mesNasc;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public String getSitaucao() {
        return sitaucao;
    }

    public void setSitaucao(String sitaucao) {
        this.sitaucao = sitaucao;
    }
    
}
