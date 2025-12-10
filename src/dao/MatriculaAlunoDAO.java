package dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;
import modelo.MatriculaAluno;

public class MatriculaAlunoDAO {

    private static final String CAMINHO = "banco/Matriculas/";

    public static void salvar(MatriculaAluno m) {
        try {
            File dir = new File(CAMINHO);
            if (!dir.exists()) dir.mkdirs();

            File arquivo = new File(CAMINHO + "MATRICULA" + m.getMatriculaAluno() + ".txt");

            FileWriter escritor = new FileWriter(arquivo, false);

            escritor.write("MatriculaAluno:{\n");
            escritor.write("    matriculaAluno: " + m.getMatriculaAluno() + ",\n");
            escritor.write("    serie: " + m.getSerie() + ",\n");
            escritor.write("    turma: " + m.getTurma() + ",\n");
            escritor.write("    anoEscolar: " + m.getAnoEscolar() + "\n");
            escritor.write("}");

            escritor.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar matrícula!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static MatriculaAluno getMatricula(String matriculaAluno) {
        MatriculaAluno m = new MatriculaAluno();

        try {
            Map<String, String> dados = Services.lerDados(CAMINHO + "MATRICULA" + matriculaAluno + ".txt");

            m.setMatriculaAluno(dados.get("matriculaAluno"));
            m.setSerie(dados.get("serie"));
            m.setTurma(dados.get("turma"));
            m.setAnoEscolar(dados.get("anoEscolar"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler matrícula!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return m;
    }

    public static boolean existe(String matriculaAluno) {
        File arquivo = new File(CAMINHO + "MATRICULA" + matriculaAluno + ".txt");
        return arquivo.isFile();
    }

    public static void atualizar(MatriculaAluno m) {
        try {
            File arquivo = new File(CAMINHO + "MATRICULA" + m.getMatriculaAluno() + ".txt");
            FileWriter escritor = new FileWriter(arquivo, false);

            escritor.write("MatriculaAluno:{\n");
            escritor.write("    matriculaAluno: " + m.getMatriculaAluno() + ",\n");
            escritor.write("    serie: " + m.getSerie() + ",\n");
            escritor.write("    turma: " + m.getTurma() + ",\n");
            escritor.write("    anoEscolar: " + m.getAnoEscolar() + "\n");
            escritor.write("}");

            escritor.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar matrícula!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean excluir(String matriculaAluno) {
        File arquivo = new File(CAMINHO + "MATRICULA" + matriculaAluno + ".txt");
        if (arquivo.exists()) {
            return arquivo.delete();
        }
        return false;
    }

    public static ArrayList<MatriculaAluno> listarTodos() {
        ArrayList<MatriculaAluno> lista = new ArrayList<>();

        File pasta = new File(CAMINHO);
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return lista;

        for (File f : arquivos) {
            if (f.getName().startsWith("MATRICULA") && f.getName().endsWith(".txt")) {
                String matricula = f.getName().replace("MATRICULA", "").replace(".txt", "");
                lista.add(getMatricula(matricula));
            }
        }

        return lista;
    }

    public static ArrayList<MatriculaAluno> listarPorTurma(String anoEscolar, String identificadorTurma) {

        ArrayList<MatriculaAluno> lista = new ArrayList<>();
        ArrayList<MatriculaAluno> todos = listarTodos();

        for (MatriculaAluno m : todos) {
            if (m.getAnoEscolar().equals(anoEscolar) && m.getTurma().equalsIgnoreCase(identificadorTurma)) {
                lista.add(m);
            }
        }

        return lista;
    }

}
