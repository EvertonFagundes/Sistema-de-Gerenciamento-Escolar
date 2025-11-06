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

   public static String criarMatricula(int anoAtual, String tipoUsuario) {
    // Define prefixo baseado no tipo
    String prefixo;
    switch (tipoUsuario.toUpperCase()) {
        case "ALUNO":
            prefixo = "AL";
            break;
        case "PROFESSOR":
            prefixo = "PR";
            break;
        case "ADMIN":
            prefixo = "AD";
            break;
        default:
            prefixo = "US"; // usuário genérico
            break;
    }

    // Lê dados do arquivo
    Map<String, String> dados = lerDados("settings.txt");

    // Cada tipo de usuário pode ter seu próprio contador!
    String chaveContador = tipoUsuario.toUpperCase(); // ex: numeroMatriculaAL
    int contador = 1;

    if (dados.containsKey(chaveContador)) {
        contador = Integer.parseInt(dados.get(chaveContador));
        contador += 1;
    }

    // Monta a matrícula final
    String matricula = String.format("%s%d%04d", prefixo, anoAtual, contador);

    // Atualiza o contador no arquivo
    modificarDado("settings.txt", chaveContador, Integer.toString(contador));

    return matricula;
}

    public static String verificarTipo(String matricula){
        String tipo = matricula.substring(0,1);
        String retorno;
        switch (tipo) {
        case "AL":
            retorno = "ALUNO";
            break;
        case "PR":
            retorno = "PROFESSOR";
            break;
        case "AD":
            retorno = "ADMIN";
            break;
        default:
            retorno = "US"; // usuário genérico
            break;
        }
        return retorno;
    }
}