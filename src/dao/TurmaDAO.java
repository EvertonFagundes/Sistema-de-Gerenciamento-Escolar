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
import modelo.Serie;
import dao.AlunoDAO;

public class TurmaDAO {
    public static void criarTurma(Turma turma) {
        File diretorio = new File("banco/turmas/");
        File arquivo = new File("banco/turmas/TURMA" + turma.getAno() + turma.getIdentificador() + ".txt");
        if(!diretorio.exists()) {
            diretorio.mkdirs();
        }
        if(!arquivo.isFile()){
            try(FileWriter escritor = new FileWriter("banco/turmas/TURMA" + turma.getAno() + turma.getIdentificador() + ".txt", false)){
            String codigo = Services.criarCodigoTurma();
            turma.setCodigo(codigo);
            escritor.write("Turma :{\n");
            escritor.write("    ano: " + turma.getAno() + ",\n");
            escritor.write("    identificador: " + turma.getIdentificador() + ",\n");
            escritor.write("    codigo: " + turma.getCodigo() + ",\n");
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
            if (turma.getSerie() != null) {
                escritor.write("    serieNome: " + turma.getSerie().getNome() + ",\n");
            } else {
                escritor.write("    serieNome: ,\n");
            }
            escritor.write("}");
            escritor.close();
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "A turma já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public static Turma getTurma(int ano, String identificador) {
        String nomeArquivo = "banco/turmas/TURMA" + ano + identificador + ".txt";
        Turma turma = null;

        try {
            Map<String, String> dados = Services.lerDados(nomeArquivo);
            String letra = dados.getOrDefault("identificador", "");
            String serieNome = dados.getOrDefault("serieNome", "").trim();
            String codigo = dados.get("codigo");

            turma = new Turma(ano, letra);
            turma.setCodigo(codigo);

            // Setar série
            if (!serieNome.isEmpty()) {
                Serie serie = SerieDAO.getSerie(serieNome);
                turma.setSerie(serie);
            }

            // Setar alunos
            ArrayList<String> matriculasAlunosTurma = new ArrayList<>();
            String alunosTexto = dados.getOrDefault("alunosTurma", "[]").replace("[", "").replace("]", "").trim();
            if (!alunosTexto.isEmpty()) {
                String[] partes = alunosTexto.split(",");
                for (String parte : partes) {
                    matriculasAlunosTurma.add(parte.trim());
                }
            }
            turma.setAlunosTurma(matriculasAlunosTurma);

            // Setar professores
            ArrayList<String> matriculasProfessoresLeciona = new ArrayList<>();
            String professoresTexto = dados.getOrDefault("professoresLeciona", "[]").replace("[", "").replace("]", "").trim();
            if (!professoresTexto.isEmpty()) {
                String[] partes = professoresTexto.split(",");
                for (String parte : partes) {
                    matriculasProfessoresLeciona.add(parte.trim());
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
            escritor.write("    codigo: " + turma.getCodigo() + ",\n");
            escritor.write("    alunosTurma: [");
            ArrayList<String> matriculaAlunos = turma.getAlunosTurma();
            if (matriculaAlunos != null && !matriculaAlunos.isEmpty()) {
                for (int i = 0; i < matriculaAlunos.size(); i++) {
                    escritor.write(matriculaAlunos.get(i));
                    System.out.println(matriculaAlunos.get(i) + "\n");
                    if (i < matriculaAlunos.size() - 1) {
                        escritor.write(", ");
                    }
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
            if (turma.getSerie() != null) {
                escritor.write("    serieNome: " + turma.getSerie().getNome() + ",\n");
            } else {
                escritor.write("    serieNome: ,\n");
            }
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

    public static ArrayList<Turma> listarTodasTurmas() {
        ArrayList<Turma> lista = new ArrayList<>();

        File pasta = new File("banco/turmas/");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return lista;

        for (File f : arquivos) {
            if (f.getName().startsWith("TURMA") && f.getName().endsWith(".txt")) {

                // Extrair ano e identificador do arquivo
                String nome = f.getName(); // TURMA2025A.txt
                String parte = nome.replace("TURMA", "").replace(".txt", "");
                
                // Ano = tudo exceto a última letra
                int ano = Integer.parseInt(parte.substring(0, parte.length() - 1));

                // Identificador = última letra
                String identificador = parte.substring(parte.length() - 1);

                Turma t = getTurma(ano, identificador);
                if (t != null) {
                    lista.add(t);
                }
            }
        }

        return lista;
    }

    public static boolean excluirTurma(String numeroSerie, String identificador) {
        String codigo = numeroSerie + identificador; // ex: "1A"
        File arquivo = new File("banco/turmas/TURMA" + codigo + ".txt");

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "Arquivo da turma não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean excluiu = arquivo.delete();

        if (excluiu) {
            JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a turma.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return excluiu;
    }




    

}
