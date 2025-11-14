package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Turma;
import dao.Services;
import modelo.Aluno;
import modelo.Professor;
import dao.AlunoDAO;

public class TurmaDAO {
    public static void criarTurma(Turma turma) {
        File diretorio = new File("banco/turmas/");
        if(!diretorio.exists()) {
            diretorio.mkdirs();
        }
        try(FileWriter escritor = new FileWriter("banco/turmas/TURMA" + turma.getAno() + turma.getIdentificador() + ".txt", false)){
            escritor.write("Turma :{\n");
            escritor.write("    ano: " + turma.getAno() + ",\n");
            escritor.write("    identificador: " + turma.getIdentificador() + ",\n");
            escritor.write("    alunosTurma: [");
            ArrayList<String> matriculaAlunos = turma.getAlunosTurma();
            for (int i = 0; i < matriculaAlunos.size(); i++) {
                escritor.write(matriculaAlunos.get(i));
                if (i < matriculaAlunos.size() - 1) {
                    escritor.write(", ");
                }
            }
            escritor.write("]\n");
            escritor.write("    professoresLeciona: [");
            ArrayList<String> matriculaProfessoresLeciona = turma.getProfessoresLeciona();
            for(int i = 0; i < matriculaProfessoresLeciona.size(); i++){
                escritor.write(matriculaProfessoresLeciona.get(i));
                if(i < matriculaProfessoresLeciona.size() - 1){
                    escritor.write(", ");
                }
            }
            escritor.write("]\n");
            escritor.write("}");
            escritor.close();
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Turma getTurma(int ano, String identificador) {
        String nomeArquivo = "banco/turmas/TURMA" + ano + identificador + ".txt";
        Turma turma = null;

        try {
            Map<String, String> dados = Services.lerDados(nomeArquivo);
            String letra = dados.getOrDefault("identificador", "");
            turma = new Turma(ano, letra);

            ArrayList <String> matriculasAlunosTurma = new ArrayList<>();
            String alunosTexto = dados.getOrDefault("alunosTurma", "[]").replace("[", "").replace("]", "").trim();

            if(!alunosTexto.isEmpty()){
                String[] partes = alunosTexto.split(",");

                for(String parte : partes){
                    parte = parte.trim();
                    matriculasAlunosTurma.add(parte);
                }
            }

            turma.setAlunosTurma(matriculasAlunosTurma);

            ArrayList <String> matriculasProfessoresLeciona = new ArrayList<>();
            String professoresTexto = dados.getOrDefault("professoresLeciona", "[]").replace("[", "").replace("]", "").trim();

            if(!professoresTexto.isEmpty()){
                String[] partes = professoresTexto.split(",");

                for(String parte : partes){
                    parte = parte.trim();
                    matriculasProfessoresLeciona.add(parte);
                }
            }

            turma.setProfessoresLeciona(matriculasProfessoresLeciona);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return turma;
    }

    public static void sobrescreverArquivoTurma(Turma turma){
        try(FileWriter escritor = new FileWriter("banco/turmas/TURMA" + turma.getAno() + turma.getIdentificador() + ".txt", false)){

        escritor.write("Turma :{\n");
            escritor.write("    ano: " + turma.getAno() + ",\n");
            escritor.write("    identificador: " + turma.getIdentificador() + ",\n");
            escritor.write("    alunosTurma: [");
            ArrayList<String> matriculaAlunos = turma.getAlunosTurma();
            for (int i = 0; i < matriculaAlunos.size(); i++) {
                escritor.write(matriculaAlunos.get(i));
                if (i < matriculaAlunos.size() - 1) {
                    escritor.write(", ");
                }
            }
            escritor.write("],\n");
            escritor.write("    professoresLeciona: [");
            ArrayList<String> matriculaProfessoresLeciona = turma.getProfessoresLeciona();
            for(int i = 0; i < matriculaProfessoresLeciona.size(); i++){
                escritor.write(matriculaProfessoresLeciona.get(i));
                if(i < matriculaProfessoresLeciona.size() - 1){
                    escritor.write(", ");
                }
            }
            escritor.write("]\n");
            escritor.write("}");
            escritor.close();
            System.out.println("Arquivo sobrescrito com sucesso!!!");
        }catch(IOException e){
            System.err.println("Erro ao sobrescrever arquivo " + e.getMessage());
        }
    }

    public static void adiconarProfessorLeciona(Turma t, String matricula){
        Map<String,String> dados = Services.lerDados("banco/turmas/TURMA" + t.getAno()+t.getIdentificador()+".txt");
        String professores = dados.get("professoresLeciona").replace("[", "").replace("]", "").trim();
        if(ProfessorDAO.verificarProfessor(matricula)){
            String[] vetor_professores = professores.split(",");
            for(String matriculaProf : vetor_professores){
                if(matriculaProf.trim().equals(matricula)){
                    System.out.println("Professor já leciona está turma!");
                    return;
                }
            }
            if(professores.isEmpty()){
                t.getProfessoresLeciona().add(matricula);
            }
            else{
                t.getProfessoresLeciona().add(professores + " , " + matricula);
            }

            sobrescreverArquivoTurma(t);
        }else{
            System.out.println("Professor não existente");
        }
        
    }

    public static void removerProfessorLeciona(Turma t, String matricula){
        Map<String,String> dados = Services.lerDados("banco/turmas/TURMA" + t.getAno()+t.getIdentificador()+".txt");
        String professores = dados.get("professoresLeciona").replace("[", "").replace("]", "").trim();
        if(ProfessorDAO.verificarProfessor(matricula)){
            String[] vetor_professores = professores.split(",");
            for(String matriculaProf : vetor_professores){
                if(matriculaProf.trim().equals(matricula)){
                    professores = professores.replace(matricula+" , ","");
                    t.getProfessoresLeciona().add(professores);
                    sobrescreverArquivoTurma(t);
                }
            }
        }
        else{
                System.out.println("Matricula não encontrada!");
            }
    }
}
