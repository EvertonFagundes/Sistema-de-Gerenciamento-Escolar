package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.Serie;
import modelo.Turma;

public class SerieDAO {

    private static String CAMINHO = "banco/series/";

    public static void salvarSerie(Serie serie) {
        try {
            // Cria a pasta caso não exista
            File diretorio = new File(CAMINHO);
            if (!diretorio.isDirectory()) {
                diretorio.mkdirs();
            }

            String NumeroSerie = serie.getNome().substring(0, 1);

            // Gera o código da série via Services e atualiza settings.txt
            String codigo = Services.criarCodigoSerie();
            serie.setCodigo(codigo);

            File arquivo = new File(CAMINHO + "SERIE" + NumeroSerie + ".txt");

            // Se o arquivo já existir, não sobrescreve
            if (arquivo.exists()) {
                JOptionPane.showMessageDialog(null, "Série já existente!", "Erro ao criar série", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Escrever dados no arquivo
            try (FileWriter escritor = new FileWriter(arquivo, false)) {
                escritor.write("Serie :{\n");
                escritor.write("    nome: " + serie.getNome() + ",\n");
                escritor.write("    codigo: " + serie.getCodigo() + "\n");
                escritor.write("}");
            }

            JOptionPane.showMessageDialog(null, "Série criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar série: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    public static Serie getSerie(String nome) {
        try {
            File diretorio = new File(CAMINHO);
            if (!diretorio.isDirectory()) {
                diretorio.mkdirs();
            }

            String numeroSerie = nome.substring(0, 1);
            File arquivo = new File(CAMINHO + "SERIE" + numeroSerie + ".txt");

            if (!arquivo.exists()) {
                return null; // ainda não existe
            }

            Map<String, String> dados = Services.lerDados(arquivo.getPath());
            String nomeArquivo = dados.get("nome");
            if (nomeArquivo != null) {
                Serie s = new Serie();
                s.setNome(nomeArquivo);
                s.setCodigo(dados.get("codigo"));
                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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

    public static void atualizarSerie(Serie serie) {
        try {
            // Garante que a pasta exista
            File diretorio = new File(CAMINHO);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            // Arquivo da série baseado no código
            File arquivo = new File(CAMINHO + "SERIE" + serie.getCodigo() + ".txt");

            if (!arquivo.exists()) {
                JOptionPane.showMessageDialog(null, "Arquivo da série não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Sobrescreve os dados
            try (FileWriter escritor = new FileWriter(arquivo, false)) {
                escritor.write("Serie :{\n");
                escritor.write("    nome: " + serie.getNome() + ",\n");
                escritor.write("    codigo: " + serie.getCodigo() + "\n");
                escritor.write("}");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar série: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static boolean excluirSerie(String codigo) {
        File arquivo = new File(CAMINHO + "SERIE" + codigo + ".txt");

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "Arquivo da série não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean excluiu = arquivo.delete();

        if (excluiu) {
            JOptionPane.showMessageDialog(null, "Série excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a série.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return excluiu;
    }


}
