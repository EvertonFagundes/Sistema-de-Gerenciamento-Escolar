package dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Services {
    public static boolean verificarDado(String nomeArquivo, String dadoProcurado){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(";");
                for(String dado : dados){
                    if(dado.equals(dadoProcurado)){
                        leitor.close();
                        return true;
                    }
                }
            }
            leitor.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    return false;
}
    public static Map<String, String> lerDados(String caminhoArquivo) {
        Map<String, String> dados = new HashMap<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

            for (String linha : linhas) {
                if (linha.trim().isEmpty() || linha.trim().startsWith("#")) continue;

                String[] partes = linha.split(":", 2);
                if (partes.length == 2) {
                    dados.put(partes[0].trim(), partes[1].trim());
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return dados;
    }
    public static void modificarDado(String caminhoArquivo, String chave, String novoValor) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));
            boolean encontrado = false;

            for (int i = 0; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                if (linha.trim().startsWith(chave + ":")) {
                    linhas.set(i, chave + ": " + novoValor);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                
                linhas.add(chave + ": " + novoValor);
            }
            Files.write(Paths.get(caminhoArquivo), linhas);

        } catch (IOException e) {
            System.out.println("Erro ao modificar o arquivo: " + e.getMessage());
        }
    }
    public static String criarMatricula(int anoAtual){
        Map<String, String> dados = lerDados("src/dao/data/settings.txt");
        int contador = Integer.parseInt(dados.get("numeroMatricula"));
        contador += 1;
        String matricula = String.format("%d%04d", anoAtual, contador);
        modificarDado("src/dao/data/settings.txt", "numeroMatricula", Integer.toString(contador));
        return matricula;
    }
}