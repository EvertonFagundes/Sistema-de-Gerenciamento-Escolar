package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Disciplina;
import modelo.Professor;
import modelo.Turma;

public class ProfessorDAO {

    private ArrayList<Professor> listaProfessores = new ArrayList<>();

    public ArrayList<Professor> getProfessores() {
    listaProfessores.clear();
    try (BufferedReader leitor = new BufferedReader(new FileReader("professores.txt"))) {
        String linha;
        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");
            // Converte a string do arquivo para lista de disciplinas
            String disciplinasTexto = dados[16].replace("[", "").replace("]", "").trim();
            String[] nomesDisciplinas = disciplinasTexto.split(",");

            ArrayList<Disciplina> disciplinas = new ArrayList<>();

            for (String nomeDisciplina : nomesDisciplinas) {
                nomeDisciplina = nomeDisciplina.trim();
                if (!nomeDisciplina.isEmpty()) {
                    disciplinas.add(new Disciplina(nomeDisciplina));
                }
            }
            String turmasTexto = dados[17].replace("[", "").replace("]", "").trim();
            String[] turmasLecionadas = turmasTexto.split(",");

            ArrayList<Turma> turmas = new ArrayList<>();

            for (String t : turmasLecionadas) {
                t = t.trim();
                if (!t.isEmpty()) {
                    String[] partes = t.split("\\|"); // separa ano do nome
                    if (partes.length == 2) {
                        int ano = Integer.parseInt(partes[0].trim());
                        String nome = partes[1].trim();
                        turmas.add(new Turma(ano, nome));
                    }
                }
            }


            Professor professor = new Professor(
                dados[0], // nome
                dados[1], // cpf
                dados[2], // rg
                dados[3], // matricula
                dados[4], // email
                Integer.parseInt(dados[5]), // dia nasc
                Integer.parseInt(dados[6]), // mes nasc
                Integer.parseInt(dados[7]), // ano nasc
                dados[8], // rua
                dados[9], // bairro
                dados[10], // cidade
                Integer.parseInt(dados[11]), // número casa
                dados[12], // complemento
                dados[13], // telefone
                dados[14], // senha
                dados[15], // formação
                disciplinas // disciplinas leciona
            );

            professor.setTurmasLeciona(turmas);
            listaProfessores.add(professor);
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler arquivo: " + e.getMessage());
    }

    return listaProfessores;
}

    public void cadastrarProfessor(Professor professor){
        if(verificarProfessor(professor.getMatricula()) == false){//verifica se o professor existe, caso não exista ele cadastra o professor
            try{
            FileWriter escritor = new FileWriter("professores.txt", true);
            escritor.write(professor.getNome() + ";" + professor.getCpf() + ";" + professor.getRg() + ";" + professor.getMatricula() + ";" + professor.getEmail() + ";" + professor.getDiaNasc() + ";" + professor.getMesNasc() + ";" + professor.getAnoNasc() + ";" + professor.getNomeRua() + ";" + professor.getNomeBairro() + ";" + professor.getNomeCidade() + ";" + professor.getNumeroCasa() + ";" + professor.getComplemento() + ";" + professor.getNumeroTelefone() + ";" + professor.getSenha() + ";" + professor.getFormacaoAcademica() + ";" + professor.getDisciplinasLeciona() + ";" + professor.getTurmasLeciona() + "\n");
            escritor.close();
            System.out.println("Professor adicionado com sucesso!");
            
            }catch(IOException e){
                System.err.println("Erro ao cadastrar Professor " + e.getMessage());
            }
        }else{
            System.out.println("Professor já cadastrado no sistema");
        }
        
    }

    public void editarProfessor(Professor novoProfessor, String matricula){
        if(verificarProfessor(matricula)){
            listaProfessores = getProfessores();
            boolean encontrado = false;

            for (Professor p : listaProfessores) {
                if (p.getMatricula().equals(matricula)) {
                    // Atualiza os dados
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
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                sobrescreverArquivo(); // sobrescreve o arquivo atualizado
                System.out.println("Professor atualizado com sucesso!");
            } else {
                System.out.println("Professor não encontrado.");
            }
        }
        
    }

    public void listarProfessores(){
        listaProfessores = getProfessores();
        for(Professor professor : listaProfessores){
            System.out.println(professor.getNome());
        }
    }

    public void sobrescreverArquivo(){
        try{
            FileWriter escritor = new FileWriter("professores.txt", false);
            for(Professor professor : listaProfessores){
                escritor.write(professor.getNome() + ";" + professor.getCpf() + ";" + professor.getRg() + ";" + professor.getMatricula() + ";" + professor.getEmail() + ";" + professor.getDiaNasc() + ";" + professor.getMesNasc() + ";" + professor.getAnoNasc() + ";" + professor.getNomeRua() + ";" + professor.getNomeBairro() + ";" + professor.getNomeCidade() + ";" + professor.getNumeroCasa() + ";" + professor.getComplemento() + ";" + professor.getNumeroTelefone() + ";" + professor.getSenha() + ";" + professor.getFormacaoAcademica() + ";" + professor.getDisciplinasLeciona() + ";" + professor.getTurmasLeciona() + "\n");
            }
            System.out.println("Arquivo sobrescrito!");
            escritor.close();
        }catch(IOException e){
            System.err.println("Erro ao sobrescrever arquivo" + e.getMessage());
        }
    }

    public boolean buscarPorNome(String nome){
        ArrayList<Professor> listaProfessores = getProfessores();
        boolean resp = false;

        for (Professor professor : listaProfessores) {
            String nomeUpper = professor.getNome().toUpperCase();
            if(nomeUpper.equals(nome.toUpperCase())){
                resp = true;
            }
        }
        return resp;
    }

    public boolean buscarPorCpf(String cpf){
        listaProfessores = getProfessores();
        boolean resp = false;

        for (Professor professor : listaProfessores) {
            if(professor.getCpf().equals(cpf)){
                resp = true;
            }
        }
        return resp;
    }

    public boolean buscarPorDisciplina(String nomeDisciplina, String matricula){
        listaProfessores = getProfessores();
        boolean resp = false;
        for(Professor professor : listaProfessores){
            if(professor.getMatricula().equals(matricula)){
                for(Disciplina disciplina : professor.getDisciplinasLeciona()){
                    if(disciplina.getNome().equals(nomeDisciplina)){
                        // System.out.println(disciplina.getNome());
                        resp = true;
                    }
                }
            }
        }
        return resp;
    }

    public void adicionarDisciplinaAoProfessor(Disciplina disciplina, String matriculaProfessor){
        if(verificarProfessor(matriculaProfessor)){
            listaProfessores = getProfessores();
            for(Professor professor : listaProfessores){
                if(professor.getMatricula().equals(matriculaProfessor)){
                    //Testa se existe disciplina com mesmo nome no ArrayList
                    for(int i=0; i<professor.getDisciplinasLeciona().size(); i++){
                        if(professor.getDisciplinasLeciona().get(i).getNome().toUpperCase().equals(disciplina.getNome().toUpperCase())){
                            System.out.println("Professor já tem essa disciplina cadastrada!");
                            return;
                        }
                    }
                    //só adiciona se não achar disciplina igual já no ArrayList
                    professor.getDisciplinasLeciona().add(disciplina);
                    System.out.println("Disciplina adicionada com sucesso!");
                    sobrescreverArquivo();
                    return;
                }
            }
        }else{
            System.out.println("Erro ao adicionar disciplina!");
        }
    }

    public void removerProfessor(String matricula){
        if(verificarProfessor(matricula)){
            boolean resp = false;
            listaProfessores = getProfessores();
            Professor professorRemover = null;
            for(Professor professor : listaProfessores){
                if(professor.getMatricula().equals(matricula)){
                    professorRemover = professor;
                    resp = true;
                    break;
                }
            }
            if(resp){
                listaProfessores.remove(professorRemover);
                sobrescreverArquivo();
            }
        }
        
    }

    public boolean verificarProfessor(String matricula){
        listaProfessores = getProfessores();
        boolean resp = false;
        for(Professor professor : listaProfessores){
            if(professor.getMatricula().equals(matricula)){
                resp = true;
            }
        }
        return resp;
    }
    //FALTA CONCERTAR ESSE MÉTODO DE adicionarTurmasAoProfessor!!! Ele muda a turma ao invés de adicionar no final do ArrayList
    public void adicionarTurmasAoProfessor(Turma turma, String matriculaProfessor){
        listaProfessores = getProfessores();
        if(verificarProfessor(matriculaProfessor)){
            for(Professor p : listaProfessores){
                if(p.getMatricula().equals(matriculaProfessor)){
                    if(p.getTurmasLeciona().contains(turma)){
                        System.out.println("Turma já vinculada ao professor");
                        return;
                    }else{
                        p.getTurmasLeciona().add(turma);
                        sobrescreverArquivo();
                        System.out.println("turma adicionada com sucesso");
                        return;
                    }
                }
            }
        }
    }
}
