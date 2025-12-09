package dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.Serie;
import modelo.Turma;

public class SerieDAO {

    private static String CAMINHO = "banco/series/";

    public static void salvarSerie(Serie serie) {
        try {
            File dir = new File(CAMINHO);
            if (!dir.exists()) dir.mkdirs();

            File arquivo = new File(CAMINHO + "SERIE" + serie.getNome() + ".txt");

            FileWriter escritor = new FileWriter(arquivo, false);

            escritor.write("Serie:{\n");
            escritor.write("    nome: " + serie.getNome() + ",\n");

            escritor.write("    turmas: [");
            for (int i = 0; i < serie.getTurmas().size(); i++) {
                Turma t = serie.getTurmas().get(i);
                String cod = t.getAno() + t.getIdentificador();

                if (i > 0) escritor.write(", ");
                escritor.write(cod);
            }
            escritor.write("]\n");

            escritor.write("}");

            escritor.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar série!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Serie getSerie(String nome) {

        Serie serie = new Serie();
        serie.setNome(nome);

        try {
            Map<String, String> dados = Services.lerDados(CAMINHO + "SERIE" + nome + ".txt");

            ArrayList<Turma> turmas = new ArrayList<>();
            String turmasTxt = dados.get("turmas").replace("[", "").replace("]", "");

            if (!turmasTxt.isEmpty()) {
                for (String parte : turmasTxt.split(",")) {
                    parte = parte.trim();
                    if (parte.isEmpty()) continue;

                    // Parte: "2025A"
                    int ano = Integer.parseInt(parte.replaceAll("\\D", ""));
                    String identificador = parte.replaceAll("\\d", "");

                    Turma turma = TurmaDAO.getTurma(ano, identificador);
                    turmas.add(turma);
                }
            }

            serie.setTurmas(turmas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler série!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return serie;
    }

    public static ArrayList<Serie> listarSeries() {

        ArrayList<Serie> lista = new ArrayList<>();

        File pasta = new File(CAMINHO);
        File[] arqs = pasta.listFiles();

        if (arqs == null) return lista;

        for (File f : arqs) {
            if (f.getName().startsWith("SERIE") && f.getName().endsWith(".txt")) {
                String nome = f.getName().replace("SERIE", "").replace(".txt", "");
                lista.add(getSerie(nome));
            }
        }

        return lista;
    }


}
