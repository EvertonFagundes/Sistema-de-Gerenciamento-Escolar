package modelo;

import java.util.ArrayList;

public class Boletim extends AnoEscolar{
    double frequenciaAluno;
    double mediaAluno;
    ArrayList<Double> notas = new ArrayList<>();

    public Boletim(int ano, String periodoLetivo, double frequenciaAluno, double mediaAluno, ArrayList<Double> notas){
        super(ano, periodoLetivo);
        this.frequenciaAluno = frequenciaAluno;
        this.mediaAluno = mediaAluno;
        this.notas = new ArrayList<>();
    }

    public double getFrequenciaAluno() {
        return frequenciaAluno;
    }

    public void setFrequenciaAluno(double frequenciaAluno) {
        this.frequenciaAluno = frequenciaAluno;
    }

    public double getMediaAluno() {
        return mediaAluno;
    }

    public void setMediaAluno(double mediaAluno) {
        this.mediaAluno = mediaAluno;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }   
}
