package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.Disciplina;
import modelo.Professor;
import modelo.Turma;
import dao.Services;
import java.time.LocalDate;

public class ProfessorDAO {

    public Professor getProfessor(String matricula) {

        Professor professor = new Professor(null, null, null, null, null,0, 0, 0,null, null, null,0, null, null,null, null);

        try {
            Map<String, String> dados = Services.lerDados("banco/PROFESSOR" + matricula + ".txt");            

            professor.setNome(dados.getOrDefault("nome", ""));
            professor.setCpf(dados.getOrDefault("cpf", "000.000.000-00"));
            professor.setRg(dados.getOrDefault("rg", "000.000.000-0"));
            professor.setMatricula(dados.getOrDefault("matricula", ""));
            professor.setEmail(dados.getOrDefault("email", ""));

            professor.setDiaNasc(parseIntSeguro(dados.get("diaNasc")));
            professor.setMesNasc(parseIntSeguro(dados.get("mesNasc")));
            professor.setAnoNasc(parseIntSeguro(dados.get("anoNasc")));

            professor.setNomeRua(dados.getOrDefault("nomeRua", "Sem rua"));
            professor.setNomeBairro(dados.getOrDefault("nomeBairro", "Sem bairro"));
            professor.setNomeCidade(dados.getOrDefault("nomeCidade", "Sem cidade"));
            professor.setNumeroCasa(parseIntSeguro(dados.get("numeroCasa")));

            professor.setComplemento(dados.getOrDefault("complemento", "Sem Complemento"));
            professor.setNumeroTelefone(dados.getOrDefault("numeroTelefone", "Sem número de telefone"));
            professor.setSenha(dados.getOrDefault("senha", ""));
            professor.setFormacaoAcademica(dados.getOrDefault("formacaoAcademica", ""));

            //DISCIPLINAS (nome|codigo|carga)
            String disciplinasTexto = dados.getOrDefault("disciplinasLeciona", "").replace("[", "").replace("]", "").trim();

            ArrayList<Disciplina> disciplinas = new ArrayList<>();

            if (!disciplinasTexto.isEmpty()) {

                String[] partes = disciplinasTexto.split(",");

                for (String parte : partes) {
                    parte = parte.trim();
                    if (parte.isEmpty()) continue;

                    // Formato esperado: nome|codigo|carga
                    String[] campos = parte.split("\\|");

                    String nome = campos[0].trim();
                    String codigo = campos.length > 1 ? campos[1].trim() : null;
                    int carga = campos.length > 2 ? parseIntSeguro(campos[2]) : 0;

                    Disciplina disc = new Disciplina(nome, codigo, null, carga);
                    disciplinas.add(disc);
                }
            }

            professor.setDisciplinasLeciona(disciplinas);


            //TURMAS
            String turmasTexto = dados.getOrDefault("turmasLeciona", "").replace("[", "").replace("]", "").trim();

            if (turmasTexto.isEmpty()) {
                professor.setTurmasLeciona(new ArrayList<>());
            } else {
                String[] partesTurmas = turmasTexto.split(",");
                ArrayList<Turma> turmas = new ArrayList<>();

                for (String parte : partesTurmas) {
                    parte = parte.trim();
                    if (parte.isEmpty()) continue;

                    // Exemplo esperado no arquivo: "2024 A"
                    String[] campos = parte.split("\\s+");
                    if (campos.length < 2) continue;

                    int ano = parseIntSeguro(campos[0]);
                    String nomeTurma = campos[1];

                    turmas.add(new Turma(ano, nomeTurma));
                }

                professor.setTurmasLeciona(turmas);
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler professor " + matricula + ": " + e.getMessage());
        }

    return professor;
    }
    // alterado para cadastrar cada professor em um arquivo individual
    public void cadastrarProfessor(Professor professor) {
        if (!verificarProfessor(professor.getMatricula())) {
            try {
                LocalDate dataAtual = LocalDate.now();
                int ano = dataAtual.getYear();
                String matricula = Services.criarMatricula(ano, "PROFESSOR");
                FileWriter escritor = new FileWriter("banco/PROFESSOR" + matricula + ".txt", false);

                escritor.write("Professor :{\n");
                escritor.write("    nome: " + professor.getNome() + ",\n");
                escritor.write("    cpf: " + professor.getCpf() + ",\n");
                escritor.write("    rg: " + professor.getRg() + ",\n");
                escritor.write("    matricula: " + matricula + ",\n");
                escritor.write("    email: " + professor.getEmail() + ",\n");
                escritor.write("    diaNasc: " + professor.getDiaNasc() + ",\n");
                escritor.write("    mesNasc: " + professor.getMesNasc() + ",\n");
                escritor.write("    anoNasc: " + professor.getAnoNasc() + ",\n");
                escritor.write("    nomeRua: " + professor.getNomeRua() + ",\n");
                escritor.write("    nomeBairro: " + professor.getNomeBairro() + ",\n");
                escritor.write("    nomeCidade: " + professor.getNomeCidade() + ",\n");
                escritor.write("    numeroCasa: " + professor.getNumeroCasa() + ",\n");
                escritor.write("    complemento: " + professor.getComplemento() + ",\n");
                escritor.write("    numeroTelefone: " + professor.getNumeroTelefone() + ",\n");
                escritor.write("    senha: " + professor.getSenha() + ",\n");
                escritor.write("    formacaoAcademica: " + professor.getFormacaoAcademica() + ",\n");

                //Lista de disciplinas no novo formato nome|codigo|carga
                escritor.write("    disciplinasLeciona: [");
                for (int i = 0; i < professor.getDisciplinasLeciona().size(); i++) {

                    Disciplina d = professor.getDisciplinasLeciona().get(i);

                    escritor.write(d.getNome() + "|" + d.getCodigo() + "|" + d.getCargaHoraria());

                    if (i < professor.getDisciplinasLeciona().size() - 1) {
                        escritor.write(", ");
                    }
                }
                escritor.write("],\n");

                escritor.write("    turmasLeciona: " + professor.getTurmasLeciona() + "\n");
                escritor.write("}");

                escritor.close();
                System.out.println("Professor adicionado com sucesso!");

            } catch (IOException e) {
                System.err.println("Erro ao cadastrar Professor " + e.getMessage());
            }

        } else {
            System.out.println("Professor já cadastrado no sistema");
        }
    }
    // alterado
    public void editarProfessor(Professor novoProfessor, String matricula) {
        if (verificarProfessor(matricula)) {
            // Atualiza os dados
            Professor p = getProfessor(matricula);
            p.setNome(novoProfessor.getNome());
            p.setCpf(novoProfessor.getCpf());
            p.setRg(novoProfessor.getRg());
            p.setEmail(novoProfessor.getEmail());
            p.setDiaNasc(novoProfessor.getDiaNasc());
            p.setMesNasc(novoProfessor.getMesNasc());
            p.setAnoNasc(novoProfessor.getAnoNasc());
            p.setNomeRua(novoProfessor.getNomeRua());
            p.setNomeBairro(novoProfessor.getNomeBairro());
            p.setNomeCidade(novoProfessor.getNomeCidade());
            p.setNumeroCasa(novoProfessor.getNumeroCasa());
            p.setComplemento(novoProfessor.getComplemento());
            p.setNumeroTelefone(novoProfessor.getNumeroTelefone());
            p.setSenha(novoProfessor.getSenha());
            p.setFormacaoAcademica(novoProfessor.getFormacaoAcademica());
            p.setDisciplinasLeciona(novoProfessor.getDisciplinasLeciona());
            p.setTurmasLeciona(novoProfessor.getTurmasLeciona());

            sobrescreverArquivo(novoProfessor);
        }
    }
    //novo método criado
    public ArrayList<Professor> getProfessores() {
        ArrayList<Professor> lista = new ArrayList<>();

        File pasta = new File("banco/");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return lista;

        for (File f : arquivos) {
            if (f.getName().startsWith("PROFESSOR") && f.getName().endsWith(".txt")) {
                // Extrai a matrícula do nome do arquivo
                String nomeArq = f.getName(); // ex.: PROFESSORABC123.txt
                String matricula = nomeArq.replace("PROFESSOR", "").replace(".txt", "");

                Professor p = getProfessor(matricula);
                lista.add(p);
            }
        }

        return lista;
    }
    // alterado
    public void sobrescreverArquivo(Professor professor) {
        try {
            FileWriter escritor = new FileWriter("banco/PROFESSOR" + professor.getMatricula() + ".txt", false);

            escritor.write("Professor :{\n");
            escritor.write("    nome: " + professor.getNome() + ",\n");
            escritor.write("    cpf: " + professor.getCpf() + ",\n");
            escritor.write("    rg: " + professor.getRg() + ",\n");
            escritor.write("    matricula: " + professor.getMatricula() + ",\n");
            escritor.write("    email: " + professor.getEmail() + ",\n");
            escritor.write("    diaNasc: " + professor.getDiaNasc() + ",\n");
            escritor.write("    mesNasc: " + professor.getMesNasc() + ",\n");
            escritor.write("    anoNasc: " + professor.getAnoNasc() + ",\n");
            escritor.write("    nomeRua: " + professor.getNomeRua() + ",\n");
            escritor.write("    nomeBairro: " + professor.getNomeBairro() + ",\n");
            escritor.write("    nomeCidade: " + professor.getNomeCidade() + ",\n");
            escritor.write("    numeroCasa: " + professor.getNumeroCasa() + ",\n");
            escritor.write("    complemento: " + professor.getComplemento() + ",\n");
            escritor.write("    numeroTelefone: " + professor.getNumeroTelefone() + ",\n");
            escritor.write("    senha: " + professor.getSenha() + ",\n");
            escritor.write("    formacaoAcademica: " + professor.getFormacaoAcademica() + ",\n");

            //Disciplinas no formato nome|codigo|carga
            escritor.write("    disciplinasLeciona: [");
            for (int i = 0; i < professor.getDisciplinasLeciona().size(); i++) {

                Disciplina d = professor.getDisciplinasLeciona().get(i);

                escritor.write(
                    d.getNome() + "|" +
                    d.getCodigo() + "|" +
                    d.getCargaHoraria()
                );

                if (i < professor.getDisciplinasLeciona().size() - 1) {
                    escritor.write(", ");
                }
            }
            escritor.write("],\n");

            //Mantém o formato das turmas
            escritor.write("    turmasLeciona: " + professor.getTurmasLeciona() + "\n");

            escritor.write("}");

            escritor.close();
            System.out.println("Arquivo sobrescrito!");

        } catch (IOException e) {
            System.err.println("Erro ao sobrescrever arquivo: " + e.getMessage());
        }
    }
    // alterado
    public boolean buscarPorNome(String nome) {
        ArrayList<Professor> professores = getProfessores();

        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome.trim())) {
                return true;
            }
        }

        return false;
    }
    // alterado
    public boolean buscarPorCpf(String cpf) {
        ArrayList<Professor> professores = getProfessores();
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf.trim())) {
                return true;
            }
        }

        return false;
    }
    // alterado
    public boolean buscarPorDisciplina(String nomeDisciplina, String matricula) {
        // Verifica se o professor existe
        if (!verificarProfessor(matricula)) {
            return false;
        }
        // Carrega o professor
        Professor professor = getProfessor(matricula);
        // Verifica se ele leciona a disciplina
        for (Disciplina d : professor.getDisciplinasLeciona()) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina.trim())) {
                return true;
            }
        }

        return false;
    }
    //alterado
    public void adicionarDisciplinaAoProfessor(Disciplina disciplina, String matriculaProfessor) {
        //Verifica se o professor existe
        if (!verificarProfessor(matriculaProfessor)) {
            System.out.println("Erro: Professor não encontrado!");
            return;
        }

        // Carrega o professor atualizado do arquivo
        Professor professor = getProfessor(matriculaProfessor);

        //Verifica duplicação (por nome OU por código)
        for (Disciplina d : professor.getDisciplinasLeciona()) {

            boolean nomeIgual = d.getNome() != null && disciplina.getNome() != null && d.getNome().trim().equalsIgnoreCase(disciplina.getNome().trim());

            boolean codigoIgual = d.getCodigo() != null && disciplina.getCodigo() != null && d.getCodigo().trim().equalsIgnoreCase(disciplina.getCodigo().trim());

            if (nomeIgual || codigoIgual) {
                System.out.println("Professor já tem essa disciplina cadastrada!");
                return;
            }
        }

        //Adiciona disciplina ao professor
        professor.getDisciplinasLeciona().add(disciplina);

        //Salva no arquivo (nome|codigo|carga)
        sobrescreverArquivo(professor);

        System.out.println("Disciplina adicionada com sucesso!");
    }
    //alterado
    public void removerProfessor(String matricula) {
        if (!verificarProfessor(matricula)) {
            System.out.println("Professor não encontrado.");
            return;
        }

        File arquivo = new File("banco/PROFESSOR" + matricula + ".txt");

        if (arquivo.delete()) {
            JOptionPane.showMessageDialog(null, "Professor removido com sucesso!", "Professor removido", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao remover o professor!", "Professor não removido", JOptionPane.ERROR_MESSAGE);
        }
    }
    //alterado
    public static boolean verificarProfessor(String matricula) {
        File arquivo = new File("banco/PROFESSOR" + matricula + ".txt");
        return arquivo.exists();
    }
    //alterado
    public void adicionarTurmasAoProfessor(Turma turma, String matriculaProfessor) {
        // Verifica se o professor existe
        if (!verificarProfessor(matriculaProfessor)) {
            System.out.println("Professor não encontrado!");
            return;
        }
        // Carrega o professor
        Professor professor = getProfessor(matriculaProfessor);
        // Verifica se a turma já está cadastrada
        boolean jaExiste = false;
        for (Turma t : professor.getTurmasLeciona()) {
            if (t.getAno() == turma.getAno() && t.getIdentificador().equals(turma.getIdentificador())) {
                jaExiste = true;
                break;
            }
        }
        if (jaExiste) {
            System.out.println("Turma já vinculada ao professor");
            return;
        }
        // Adiciona a nova turma
        professor.getTurmasLeciona().add(turma);
        // Salva no arquivo
        sobrescreverArquivo(professor);
        System.out.println("Turma adicionada com sucesso!");
    }
    //Novas funções
    public int calcularCargaHorariaPorDisciplinas(String matriculaProfessor) {
        Professor professor = getProfessor(matriculaProfessor);
        int total = 0;
        for (Disciplina d : professor.getDisciplinasLeciona()) {
            total += d.getCargaHoraria();
        }
        return total;
    }

    public int calcularCargaHorariaPorTurmas(String matriculaProfessor) {
        Professor professor = getProfessor(matriculaProfessor);
        int qtdTurmas = professor.getTurmasLeciona().size();
        int cargaDisciplinas = calcularCargaHorariaPorDisciplinas(matriculaProfessor);

        return cargaDisciplinas * qtdTurmas;
    }
    //Atribuição de Disciplinas e Turmas
    public void lancarNota(String matriculaAluno, String codigoDisciplina, double nota) {
        try {
            FileWriter fw = new FileWriter("banco/notas/" + matriculaAluno + "-" + codigoDisciplina + ".txt", true);
            fw.write(nota + "\n");
            fw.close();
            System.out.println("Nota lançada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao lançar nota: " + e.getMessage());
        }
    }

    public void lancarFrequencia(String matriculaAluno, String codigoDisciplina, boolean presente) {
        try {
            FileWriter fw = new FileWriter("banco/frequencia/" + matriculaAluno + "-" + codigoDisciplina + ".txt", true);
            fw.write((presente ? "Presente" : "Faltou") + "\n");
            fw.close();
            System.out.println("Frequência lançada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao lançar frequência: " + e.getMessage());
        }
    }

    public List<Double> visualizarNotas(String matriculaAluno, String codigoDisciplina) {
        List<Double> notas = new ArrayList<>();
        try {
            List<String> linhas = Files.readAllLines(
                Paths.get("banco/notas/" + matriculaAluno + "-" + codigoDisciplina + ".txt")
            );

            for (String linha : linhas) {
                notas.add(Double.parseDouble(linha));
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler notas: " + e.getMessage());
        }

        return notas;
    }

    public List<String> visualizarFrequencia(String matriculaAluno, String codigoDisciplina) {
        try {
            return Files.readAllLines(
                Paths.get("banco/frequencia/" + matriculaAluno + "-" + codigoDisciplina + ".txt")
            );
        } catch (Exception e) {
            System.out.println("Erro ao ler frequência: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Turma> visualizarTurmas(String matriculaProfessor) {
        Professor professor = getProfessor(matriculaProfessor);
        return professor.getTurmasLeciona();
    }
    
    //Funções para previnir exceções
    private int parseIntSeguro(String s) {
        try {
            if (s == null || s.trim().isEmpty()) return 0;
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }
    public void removerDisciplinaProfessor(String matriculaProfessor, String indentificador){
    if(!verificarProfessor(matriculaProfessor)){
        System.out.println("Professor não encontrado!");
        return;
    }
    Professor professor = getProfessor(matriculaProfessor);

    boolean removido = professor.getDisciplinasLeciona().removeIf(d ->
    (d.getNome() != null && d.getNome().equalsIgnoreCase(indentificador.trim())) ||
    (d.getCodigo() != null && d.getCodigo().equalsIgnoreCase(indentificador.trim())));

    if (removido) {
        sobrescreverArquivo(professor);
        System.out.println("Disciplina removida com sucesso!");
    } else {
        System.out.println("Disciplina não encontrada para este professor.");
    }
  }
    public void removerTurmaDoProfessor(String matriculaProfessor, int ano, String identificador){
        if(!verificarProfessor(matriculaProfessor)){
            System.out.println("Professor não encontrado!");
            return;
        }

        Professor professor = getProfessor(matriculaProfessor);

        boolean removido = professor.getTurmasLeciona().removeIf(t -> t.getAno() == ano
        && t.getIdentificador().equalsIgnoreCase(identificador.trim())
        );
        if (removido) {
        sobrescreverArquivo(professor);
        System.out.println("Turma removida com sucesso!");
    } else {
        System.out.println("Turma não encontrada para este professor.");
    }
    }

    public void lancarNotas(){
        
    }

    public void lancarFrequencias(){

    }
}

