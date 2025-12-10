package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Serie;
import modelo.Turma;

public class AlunoDAO {

    // ----------- GET ALUNO -----------
    public Aluno getAluno(String matricula) {

        Aluno aluno = new Aluno(
            null, null, null, null, null, 
            0,0,0, null,null,null,0,null,null,null,
            null, null, null, null
        );

        try {
            Map<String, String> dados = Services.lerDados("banco/alunos/ALUNO" + matricula + ".txt");

            aluno.setNome(dados.getOrDefault("nome", ""));
            aluno.setCpf(dados.getOrDefault("cpf", ""));
            aluno.setRg(dados.getOrDefault("rg", ""));
            aluno.setMatricula(dados.getOrDefault("matricula", ""));
            aluno.setEmail(dados.getOrDefault("email", ""));

            aluno.setDiaNasc(parseIntSeguro(dados.get("diaNasc")));
            aluno.setMesNasc(parseIntSeguro(dados.get("mesNasc")));
            aluno.setAnoNasc(parseIntSeguro(dados.get("anoNasc")));

            aluno.setNomeRua(dados.getOrDefault("nomeRua", ""));
            aluno.setNomeBairro(dados.getOrDefault("nomeBairro", ""));
            aluno.setNomeCidade(dados.getOrDefault("nomeCidade", ""));
            aluno.setNumeroCasa(parseIntSeguro(dados.get("numeroCasa")));

            aluno.setComplemento(dados.getOrDefault("complemento", ""));
            aluno.setNumeroTelefone(dados.getOrDefault("numeroTelefone", ""));
            aluno.setSenha(dados.getOrDefault("senha", ""));

            aluno.setSituacao(dados.getOrDefault("situacao", "ATIVO"));
            aluno.setNomeResponsavel(dados.getOrDefault("nomeResponsavel", ""));
            aluno.setTelefoneResponsavel(dados.get("telefoneResponsavel"));
            aluno.setEmailResponsavel(dados.getOrDefault("emailResponsavel", ""));

        } catch (Exception e) {
            System.err.println("Erro ao ler aluno " + matricula + ": " + e.getMessage());
        }

        return aluno;
    }

    // ----------- CADASTRAR ALUNO -----------
    public void cadastrarAluno(Aluno aluno) {
        File diretorio = new File("banco/alunos/");
        if(!diretorio.isDirectory()){
            diretorio.mkdirs();
        }
        LocalDate dataAtual = LocalDate.now();
        int ano = dataAtual.getYear();
        String matriculaGerada = Services.criarMatricula(ano, "ALUNO");
        File arquivo = new File("banco/disciplinas/DISCIPLINA" + matriculaGerada + ".txt");
        if(arquivo.isFile()){
            JOptionPane.showMessageDialog(null, "Aluno já existente!", "Erro ao criar aluno", JOptionPane.ERROR_MESSAGE);
        }else{
            if (!verificarAluno(aluno.getMatricula())) {
            try {

                FileWriter escritor = new FileWriter("banco/alunos/ALUNO" + matriculaGerada + ".txt", false);

                escritor.write("Aluno :{\n");
                escritor.write("    nome: " + aluno.getNome() + ",\n");
                escritor.write("    cpf: " + aluno.getCpf() + ",\n");
                escritor.write("    rg: " + aluno.getRg() + ",\n");
                escritor.write("    matricula: " + matriculaGerada + ",\n");
                escritor.write("    email: " + aluno.getEmail() + ",\n");

                escritor.write("    diaNasc: " + aluno.getDiaNasc() + ",\n");
                escritor.write("    mesNasc: " + aluno.getMesNasc() + ",\n");
                escritor.write("    anoNasc: " + aluno.getAnoNasc() + ",\n");

                escritor.write("    nomeRua: " + aluno.getNomeRua() + ",\n");
                escritor.write("    nomeBairro: " + aluno.getNomeBairro() + ",\n");
                escritor.write("    nomeCidade: " + aluno.getNomeCidade() + ",\n");
                escritor.write("    numeroCasa: " + aluno.getNumeroCasa() + ",\n");

                escritor.write("    complemento: " + aluno.getComplemento() + ",\n");
                escritor.write("    numeroTelefone: " + aluno.getNumeroTelefone() + ",\n");
                escritor.write("    senha: " + aluno.getSenha() + ",\n");

                escritor.write("    situacao: " + aluno.getSituacao() + ",\n");
                escritor.write("    nomeResponsavel: " + aluno.getNomeResponsavel() + ",\n");
                escritor.write("    telefoneResponsavel: " + aluno.getTelefoneResponsavel() + ",\n");
                escritor.write("    emailResponsavel: " + aluno.getEmailResponsavel() + "\n");

                escritor.write("}");

                escritor.close();
                System.out.println("Aluno cadastrado com sucesso!");

            } catch (IOException e) {
                System.err.println("Erro ao cadastrar aluno: " + e.getMessage());
            }

            } else {
                System.out.println("Aluno já cadastrado no sistema.");
            }
        }
    }

    // ----------- EDITAR ALUNO -----------
    public void editarAluno(Aluno novoAluno, String matricula) {

        if (verificarAluno(matricula)) {
            sobrescreverArquivo(novoAluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // ----------- LISTAR ALUNOS -----------
    public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> lista = new ArrayList<>();

        File pasta = new File("banco/alunos");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return lista;

        for (File f : arquivos) {
            if (f.getName().startsWith("ALUNO") && f.getName().endsWith(".txt")) {
                String matricula = f.getName().replace("ALUNO", "").replace(".txt", "");
                lista.add(getAluno(matricula));
            }
        }

        return lista;
    }

    // ----------- SOBRESCREVER ARQUIVO -----------
    public void sobrescreverArquivo(Aluno aluno) {

        try {
            FileWriter escritor = new FileWriter("banco/alunos/ALUNO" + aluno.getMatricula() + ".txt", false);

            escritor.write("Aluno :{\n");
            escritor.write("    nome: " + aluno.getNome() + ",\n");
            escritor.write("    cpf: " + aluno.getCpf() + ",\n");
            escritor.write("    rg: " + aluno.getRg() + ",\n");
            escritor.write("    matricula: " + aluno.getMatricula() + ",\n");
            escritor.write("    email: " + aluno.getEmail() + ",\n");

            escritor.write("    diaNasc: " + aluno.getDiaNasc() + ",\n");
            escritor.write("    mesNasc: " + aluno.getMesNasc() + ",\n");
            escritor.write("    anoNasc: " + aluno.getAnoNasc() + ",\n");

            escritor.write("    nomeRua: " + aluno.getNomeRua() + ",\n");
            escritor.write("    nomeBairro: " + aluno.getNomeBairro() + ",\n");
            escritor.write("    nomeCidade: " + aluno.getNomeCidade() + ",\n");
            escritor.write("    numeroCasa: " + aluno.getNumeroCasa() + ",\n");

            escritor.write("    complemento: " + aluno.getComplemento() + ",\n");
            escritor.write("    numeroTelefone: " + aluno.getNumeroTelefone() + ",\n");
            escritor.write("    senha: " + aluno.getSenha() + ",\n");

            escritor.write("    situacao: " + aluno.getSituacao() + ",\n");
            escritor.write("    nomeResponsavel: " + aluno.getNomeResponsavel() + ",\n");
            escritor.write("    telefoneResponsavel: " + aluno.getTelefoneResponsavel() + ",\n");
            escritor.write("    emailResponsavel: " + aluno.getEmailResponsavel() + "\n");

            escritor.write("}");

            escritor.close();
            System.out.println("Arquivo do aluno sobrescrito com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao sobrescrever arquivo do aluno: " + e.getMessage());
        }
    }

    public boolean verificaAlunoCpf(String cpf) {
    for (Aluno a : getAlunos()) {
        if (a.getCpf().equals(cpf.trim())) {
            return true;
        }
    }
    return false;
    }

    public boolean verificaAlunoNome(String nome) {
        for (Aluno a : getAlunos()) {
            if (a.getNome().equalsIgnoreCase(nome.trim())) {
                return true;
            }
        }
        return false;
    }

    public Aluno getAlunoCpf(String cpf) {
        for (Aluno a : getAlunos()) {
            if (a.getCpf().equals(cpf.trim())) {
                return a;
            }
        }
        return null;
    }

    public Aluno getAlunoNome(String nome) {
        for (Aluno a : getAlunos()) {
            if (a.getNome().equalsIgnoreCase(nome.trim())) {
                return a;
            }
        }
        return null;
    }

    public Aluno getAlunoMatricula(String matricula) {
        for (Aluno a : getAlunos()) {
            if (a.getMatricula().equals(matricula.trim())) {
                return a;
            }
        }
        return null;
    }


    public ArrayList<Aluno> getAlunosPorSerie(String serieNome) {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        ArrayList<Turma> todasTurmas = TurmaDAO.listarTodasTurmas();

        for (Turma t : todasTurmas) {
            Serie serie = t.getSerie();
            if (serie != null && serie.getNome().equalsIgnoreCase(serieNome)) {

                for (String matricula : t.getAlunosTurma()) {
                    Aluno aluno = getAlunoMatricula(matricula);
                    if (aluno != null) {
                        encontrados.add(aluno);
                    }
                }
            }
        }
        return encontrados;
    }

    public ArrayList<Aluno> getAlunosPorAnoEscolar(int ano) {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        ArrayList<Turma> todasTurmas = TurmaDAO.listarTodasTurmas();

        for (Turma t : todasTurmas) {
            if (t.getAno() == ano) {

                for (String matricula : t.getAlunosTurma()) {
                    Aluno aluno = getAlunoMatricula(matricula);
                    if (aluno != null) {
                        encontrados.add(aluno);
                    }
                }
            }
        }
        return encontrados;
    }


    // ----------- REMOVER ALUNO -----------
    public void removerAluno(String matricula) {

        if (!verificarAluno(matricula)) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        File arquivo = new File("banco/alunos/ALUNO" + matricula + ".txt");

        if (arquivo.delete()) {
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!", "Aluno removido", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao remover o aluno!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ----------- VERIFICAR EXISTÊNCIA -----------
    public static boolean verificarAluno(String matricula) {
        File arquivo = new File("banco/alunos/ALUNO" + matricula + ".txt");
        return arquivo.exists();
    }

    // ----------- SEGURANÇA INT -----------
    private int parseIntSeguro(String s) {
        try {
            if (s == null || s.trim().isEmpty()) return 0;
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
