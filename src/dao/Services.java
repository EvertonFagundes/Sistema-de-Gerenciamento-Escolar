package dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
/*
   public static Map<String, String> lerDados(String caminhoArquivo) {
    Map<String, String> dados = new HashMap<>();

    try {
        List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));
        StringBuilder conteudo = new StringBuilder();

        boolean dentroDoBloco = false;

        // Junta apenas o conteúdo dentro das chaves { }
        for (String linha : linhas) {
            linha = linha.trim();
            if (linha.isEmpty() || linha.startsWith("#")) continue;

            if (linha.contains("{")) {
                dentroDoBloco = true;
                linha = linha.substring(linha.indexOf("{") + 1);
            }
            if (linha.contains("}")) {
                dentroDoBloco = false;
                linha = linha.substring(0, linha.indexOf("}"));
            }

            if (dentroDoBloco || linha.contains(":")) {
                conteudo.append(linha).append(" ");
            }
        }

        // Agora, percorre o texto e quebra corretamente nos pares chave:valor
        String texto = conteudo.toString();
        StringBuilder buffer = new StringBuilder();
        boolean dentroDeColchetes = false;

        for (char c : texto.toCharArray()) {
            if (c == '[') dentroDeColchetes = true;
            else if (c == ']') dentroDeColchetes = false;

            // vírgula fora de colchetes separa pares chave:valor
            if (c == ',' && !dentroDeColchetes) {
                buffer.append('\n'); // quebra linha
            } else {
                buffer.append(c);
            }
        }

        // Divide em pares e adiciona no mapa
        String[] partes = buffer.toString().split("\n");
        for (String parte : partes) {
            parte = parte.trim();
            if (parte.isEmpty()) continue;

            String[] kv = parte.split(":", 2);
            if (kv.length == 2) {
                String chave = kv[0].trim();
                String valor = kv[1].trim();

                // remove vírgula final se sobrar
                if (valor.endsWith(",")) valor = valor.substring(0, valor.length() - 1).trim();

                dados.put(chave, valor);
            }
        }

    } catch (Exception e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

    return dados;
}
*/

public static Map<String, String> lerDados(String caminhoArquivo) {
    Map<String, String> dados = new HashMap<>();

    try {
        List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));
        StringBuilder conteudo = new StringBuilder();

        boolean dentroDoBloco = false;

        // Junta apenas o conteúdo dentro das chaves { }
        for (String linha : linhas) {
            linha = linha.trim();
            if (linha.isEmpty() || linha.startsWith("#")) continue;

            if (linha.contains("{")) {
                dentroDoBloco = true;
                linha = linha.substring(linha.indexOf("{") + 1);
            }
            if (linha.contains("}")) {
                dentroDoBloco = false;
                linha = linha.substring(0, linha.indexOf("}"));
            }

            if (dentroDoBloco || linha.contains(":")) {
                conteudo.append(linha).append(" ");
            }
        }

        // Agora, percorre o texto e quebra corretamente nos pares chave:valor
        String texto = conteudo.toString();
        StringBuilder buffer = new StringBuilder();
        boolean dentroDeColchetes = false;

        for (char c : texto.toCharArray()) {
            if (c == '[') dentroDeColchetes = true;
            else if (c == ']') dentroDeColchetes = false;

            // vírgula fora de colchetes separa pares chave:valor
            if (c == ',' && !dentroDeColchetes) {
                buffer.append('\n'); // quebra linha
            } else {
                buffer.append(c);
            }
        }

        // Divide em pares e adiciona no mapa
        String[] partes = buffer.toString().split("\n");
        for (String parte : partes) {
            parte = parte.trim();
            if (parte.isEmpty()) continue;

            String[] kv = parte.split(":", 2);
            if (kv.length == 2) {
                String chave = kv[0].trim();
                String valor = kv[1].trim();

                // remove vírgula final se sobrar
                if (valor.endsWith(",")) valor = valor.substring(0, valor.length() - 1).trim();

                //nunca armazenar null
                if (valor == null) valor = "";

                dados.put(chave, valor);
            }
        }

    } catch (Exception e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

    //garantir que TODAS as chaves esperadas existam
    String[] chavesEsperadas = {
            "nome", "cpf", "rg", "matricula", "email",
            "diaNasc", "mesNasc", "anoNasc",
            "nomeRua", "nomeBairro", "nomeCidade",
            "numeroCasa", "complemento", "numeroTelefone",
            "senha", "formacaoAcademica",
            "disciplinasLeciona", "turmasLeciona",
    };

    for (String chave : chavesEsperadas) {
        dados.putIfAbsent(chave, "");
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
    /*String prefixo;
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
    }*/

    // Lê dados do arquivo
    Map<String, String> dados = lerDados("src/dao/settings.txt");

    // Cada tipo de usuário pode ter seu próprio contador!
    String chaveContador = "numeroMatricula";
    int contador = 1;

    if (dados.containsKey(chaveContador)) {
        contador = Integer.parseInt(dados.get(chaveContador));
        contador += 1;
    }

    // Monta a matrícula final
    String matricula = String.format("%d%04d", anoAtual, contador);

    // Atualiza o contador no arquivo
    modificarDado("src/dao/settings.txt","numeroMatricula", Integer.toString(contador));

    return matricula;
}

    /*public static String verificarTipo(String matricula){
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
    }*/

    public static String criarCodigoDisciplina(){
        Map<String, String> dados = lerDados("src/dao/settings.txt");
        String codigo = "";
        if(dados.get("codigoDisciplina") == null){
            try {
                FileWriter escritor = new FileWriter("src/dao/settings.txt");
                escritor.write("numeroMatricula: " + dados.get("numeroMatricula") + ",\n");
                escritor.write("codigoDisciplina: 0");
                escritor.close();
            } catch (Exception e) {
                System.out.println("Erro em criar campo codigoDisciplina on settings.txt" + e.getMessage());
            }
        }else{
            int ultimoCodigo = Integer.parseInt(dados.get("codigoDisciplina"));
            ultimoCodigo += 1;
             codigo = String.valueOf(ultimoCodigo);
            
            modificarDado("src/dao/settings.txt", "codigoDisciplina", codigo);
        }
        
        return codigo;
        
    }

    public static String criarCodigoTurma(){
        Map<String, String> dados = lerDados("src/dao/settings.txt");
        String codigo = "";
        if(dados.get("codigoTurma") == null){
            try {
                FileWriter escritor = new FileWriter("src/dao/settings.txt");
                escritor.write("numeroMatricula: " + dados.get("numeroMatricula") + ",\n");
                escritor.write("codigoDisciplina: " + dados.get("codigoDisciplina") + ",\n");
                escritor.write("codigoTurma: 0,\n");
                escritor.write("codigoAnoEscolar: 0");
                escritor.close();
            } catch (Exception e) {
                System.out.println("Erro em criar campo codigoDisciplina on settings.txt" + e.getMessage());
            }
        }else{
            int ultimoCodigo = Integer.parseInt(dados.get("codigoTurma"));
            ultimoCodigo += 1;
             codigo = String.valueOf(ultimoCodigo);
            
            modificarDado("src/dao/settings.txt", "codigoTurma", codigo);
        }
        
        return codigo;
    }

    public static String criarCodigoAnoEscolar(){
        Map<String, String> dados = lerDados("src/dao/settings.txt");
        String codigo = "";
        if(dados.get("codigoAnoEscolar") == null){
            try {
                FileWriter escritor = new FileWriter("src/dao/settings.txt");
                escritor.write("numeroMatricula: " + dados.get("numeroMatricula") + ",\n");
                escritor.write("codigoDisciplina: " + dados.get("codigoDisciplina") + ",\n");
                escritor.write("codigoTurma: " + dados.get("codigoTurma") + ",\n");
                escritor.write("codigoAnoEscolar: 0");
                escritor.close();
            } catch (Exception e) {
                System.out.println("Erro em criar campo codigoTurma on settings.txt" + e.getMessage());
            }
        }else{
            int ultimoCodigo = Integer.parseInt(dados.get("codigoAnoEscolar"));
            ultimoCodigo += 1;
            codigo = String.valueOf(ultimoCodigo);
            
            modificarDado("src/dao/settings.txt", "codigoAnoEscolar", codigo);
        }
        
        return codigo;
    }

}