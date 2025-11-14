package modelo;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String codigo;
    private String descricao;
    private int cargaHoraria;
    private ArrayList<Professor> lecionadaPor = new ArrayList<>();

    public Disciplina(){
    }

    public Disciplina(String nome, String codigo, String descricao, int cargaHoraria){
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Professor> getLecionadaPor() {
        return lecionadaPor;
    }

    public void setLecionadaPor(ArrayList<Professor> lecionadaPor) {
        this.lecionadaPor = lecionadaPor;
    }

    @Override
    public String toString() {
        return nome;
    }

}
