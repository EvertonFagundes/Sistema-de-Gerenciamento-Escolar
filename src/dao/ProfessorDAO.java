package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Turma;
import dao.Services;

public class ProfessorDAO {

    public Professor getProfessor(String matricula) {
        Professor professor = new Professor(null, null, null, null, null, 0, 0, 0, null, null, null, 0, null, null,
                null, null);
        try (BufferedReader leitor = new BufferedReader(new FileReader("banco/professor" + matricula + ".txt"))) {
            Map<String, String> dados = Services.lerDados("banco/professor" + matricula + ".txt");

            professor.setNome(dados.get("nome"));
            professor.setCpf(dados.get("cpf"));
            professor.setRg(dados.get("rg"));
            professor.setMatricula(dados.get("matricula"));
            professor.setEmail(dados.get("email"));
            professor.setDiaNasc(parseIntSeguro(dados.get("diaNasc")));
            professor.setMesNasc(parseIntSeguro(dados.get("mesNasc")));
            professor.setAnoNasc(parseIntSeguro(dados.get("anoNasc")));
            professor.setNomeRua(dados.get("nomeRua"));
            professor.setNomeBairro(dados.get("nomeBairro"));
            professor.setNomeCidade(dados.get("nomeCidade"));
            professor.setNumeroCasa(parseIntSeguro(dados.get("numeroCasa")));
            professor.setComplemento(dados.get("complemento"));
            professor.setNumeroTelefone(dados.get("numeroTelefone"));
            professor.setSenha(dados.get("senha"));
            professor.setFormacaoAcademica(dados.get("formacaoAcademica"));

            String disciplinasTexto = dados.get("disciplinasLeciona").replace("[", "").replace("]", "");
            String dadoDisciplina[] = disciplinasTexto.split(",");
            ArrayList<Disciplina> disciplinas = new ArrayList<>();

            for (String nomeDisciplina : dadoDisciplina) {
                Disciplina d = new Disciplina(nomeDisciplina);
                disciplinas.add(d);
            }
            professor.setDisciplinasLeciona(disciplinas);

            String turmasTexto = dados.get("turmasLeciona").replace("[", "").replace("]", "");

            if (turmasTexto.trim().isEmpty()) {
                professor.setTurmasLeciona(new ArrayList<>());
            } else {
                String[] turmas = turmasTexto.split(",");
                ArrayList<Turma> turmasArray = new ArrayList<>();

                for (String turma : turmas) {
                    turma = turma.trim();
                    if (turma.isEmpty()) continue; // ✅ IGNORA VAZIAS

                    String[] partes = turma.split("\\s+");

                    if (partes.length < 2) continue; // ✅ evita erro e barulho

                    Turma t = new Turma(Integer.parseInt(partes[0]), partes[1]);
                    turmasArray.add(t);
                }

                professor.setTurmasLeciona(turmasArray);
            }


        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return professor;
    }
    // alterado para cadastrar cada professor em um arquivo individual
    public void cadastrarProfessor(Professor professor) {
        if (verificarProfessor(professor.getMatricula()) == false) {// verifica se o professor existe, caso não exista
                                                                    // ele cadastra o professor
            try {
                FileWriter escritor = new FileWriter("banco/professor" + professor.getMatricula() + ".txt", true);
                escritor.write("Professor :{\n");
                escritor.write("    nome: " + professor.getNome() + ",\n" + "    cpf: " + professor.getCpf() + ",\n"
                        + "    rg: " + professor.getRg() + ",\n" + "    matricula: " + professor.getMatricula() + ",\n"
                        + "    email: " + professor.getEmail() + ",\n" + "    diaNasc: " + professor.getDiaNasc()
                        + ",\n" + "    mesNasc: " + professor.getMesNasc() + ",\n" + "    anoNasc: "
                        + professor.getAnoNasc() + ",\n" + "    nomeRua: " + professor.getNomeRua() + ",\n"
                        + "    nomeBairro: " + professor.getNomeBairro() + ",\n" + "    nomeCidade: "
                        + professor.getNomeCidade() + ",\n" + "    numeroCasa: " + professor.getNumeroCasa() + ",\n"
                        + "    complemento: " + professor.getComplemento() + ",\n" + "    numeroTelefone: "
                        + professor.getNumeroTelefone() + ",\n" + "    senha: " + professor.getSenha() + ",\n"
                        + "    formacaoAcademica: " + professor.getFormacaoAcademica() + ",\n"
                        + "    disciplinasLeciona: " + professor.getDisciplinasLeciona() + ",\n" + "    turmasLeciona: "
                        + professor.getTurmasLeciona() + "\n");
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
        }
    }
    //novo método criado
    public ArrayList<Professor> getProfessores() {
        ArrayList<Professor> lista = new ArrayList<>();

        File pasta = new File("banco/");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return lista;

        for (File f : arquivos) {
            if (f.getName().startsWith("professor") && f.getName().endsWith(".txt")) {
                // Extrai a matrícula do nome do arquivo
                String nomeArq = f.getName(); // ex.: professorABC123.txt
                String matricula = nomeArq.replace("professor", "").replace(".txt", "");

                Professor p = getProfessor(matricula);
                lista.add(p);
            }
        }

        return lista;
    }
    // alterado
    public void sobrescreverArquivo(Professor professor) {
        try {
            FileWriter escritor = new FileWriter("banco/professor" + professor.getMatricula() + ".txt", false);
            escritor.write("Professor :{\n");
            escritor.write("    nome: " + professor.getNome() + ",\n" + "    cpf: " + professor.getCpf() + ",\n"
                    + "    rg: " + professor.getRg() + ",\n" + "    matricula: " + professor.getMatricula() + ",\n"
                    + "    email: " + professor.getEmail() + ",\n" + "    diaNasc: " + professor.getDiaNasc() + ",\n"
                    + "    mesNasc: " + professor.getMesNasc() + ",\n" + "    anoNasc: " + professor.getAnoNasc()
                    + ",\n" + "    nomeRua: " + professor.getNomeRua() + ",\n" + "    nomeBairro: "
                    + professor.getNomeBairro() + ",\n" + "    nomeCidade: " + professor.getNomeCidade() + ",\n"
                    + "    numeroCasa: " + professor.getNumeroCasa() + ",\n" + "    complemento: "
                    + professor.getComplemento() + ",\n" + "    numeroTelefone: " + professor.getNumeroTelefone()
                    + ",\n" + "    senha: " + professor.getSenha() + ",\n" + "    formacaoAcademica: "
                    + professor.getFormacaoAcademica() + ",\n" + "    disciplinasLeciona: "
                    + professor.getDisciplinasLeciona() + ",\n" + "    turmasLeciona: " + professor.getTurmasLeciona()
                    + "\n");
            escritor.write("}");
            System.out.println("Arquivo sobrescrito!");
            escritor.close();
        } catch (IOException e) {
            System.err.println("Erro ao sobrescrever arquivo" + e.getMessage());
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
        // Verifica se o professor existe
        if (!verificarProfessor(matriculaProfessor)) {
            System.out.println("Erro: Professor não encontrado!");
            return;
        }
        // Carrega o professor diretamente do arquivo
        Professor professor = getProfessor(matriculaProfessor);
        // Verifica se já possui a disciplina
        for (Disciplina d : professor.getDisciplinasLeciona()) {
            if (d.getNome().trim().equalsIgnoreCase(disciplina.getNome().trim())) {
                System.out.println("Professor já tem essa disciplina cadastrada!");
                return;
            }
        }
        // Se não tem, adiciona
        professor.getDisciplinasLeciona().add(disciplina);
        // Sobrescreve o arquivo com os dados atualizados
        sobrescreverArquivo(professor);

        System.out.println("Disciplina adicionada com sucesso!");
    }
    //alterado
    public void removerProfessor(String matricula) {
        if (!verificarProfessor(matricula)) {
            System.out.println("Professor não encontrado.");
            return;
        }

        File arquivo = new File("banco/professor" + matricula + ".txt");

        if (arquivo.delete()) {
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Erro ao remover o professor.");
        }
    }
    //alterado
    public boolean verificarProfessor(String matricula) {
        File arquivo = new File("banco/professor" + matricula + ".txt");
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
    //Funções para previnir exceções
    private int parseIntSeguro(String s) {
        try {
            if (s == null || s.trim().isEmpty()) return 0;
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }

}
