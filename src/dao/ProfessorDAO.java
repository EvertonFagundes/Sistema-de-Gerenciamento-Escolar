package dao;

import java.io.BufferedReader;
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

    private ArrayList<Professor> professores = new ArrayList<>();
    //FALTA CONCERTAR ESSA PARTE DE PEGAR O NOME E ANO DAS TURMAS
    public Professor getProfessor(String matricula) {
       Professor professor = new Professor(null, null, null, null, null, 0, 0, 0, null, null, null, 0, null, null, null, null);
        try (BufferedReader leitor = new BufferedReader(new FileReader("banco/professor" + matricula + ".txt"))) {
            Map <String, String> dados = Services.lerDados("banco/professor" + matricula + ".txt");
            
            professor.setNome(dados.get("nome"));
            professor.setCpf(dados.get("cpf"));
            professor.setRg(dados.get("rg"));
            professor.setMatricula(dados.get("matricula"));
            professor.setEmail(dados.get("email"));
            professor.setDiaNasc(Integer.parseInt(dados.get("diaNasc").trim()));
            professor.setMesNasc(Integer.parseInt(dados.get("mesNasc").trim()));
            professor.setAnoNasc(Integer.parseInt(dados.get("anoNasc").trim()));
            professor.setNomeRua(dados.get("nomeRua"));
            professor.setNomeBairro(dados.get("nomeBairro"));
            professor.setNomeCidade(dados.get("nomeCidade"));
            professor.setNumeroCasa(Integer.parseInt(dados.get("numeroCasa").trim()));
            professor.setComplemento(dados.get("complemento"));
            professor.setNumeroTelefone(dados.get("numeroTelefone"));
            professor.setSenha(dados.get("senha"));
            professor.setFormacaoAcademica(dados.get("formacaoAcademica"));

            String disciplinasTexto = dados.get("disciplinasLeciona").replace("[", "").replace("]", "");
            String dadoDisciplina[] = disciplinasTexto.split(",");
            ArrayList <Disciplina> disciplinas = new ArrayList<>();
            
            for(String nomeDisciplina : dadoDisciplina){
                Disciplina d = new Disciplina(nomeDisciplina);
                disciplinas.add(d);
            }
            professor.setDisciplinasLeciona(disciplinas);

            String turmasTexto = dados.get("turmasLeciona").replace("[", "").replace("]", "");
            String dadoTurmas[] = turmasTexto.split(",");
            ArrayList <Turma> turmas = new ArrayList<>();
            //FALTA CONCERTAR ESSA PARTE DE PEGAR O NOME E ANO DAS TURMAS
            for(String nomeTurma : dadoTurmas){
                Turma t = new Turma(0, nomeTurma);
                turmas.add(t);
            }
            professor.setTurmasLeciona(turmas);

    } catch (IOException e) {
        System.err.println("Erro ao ler arquivo: " + e.getMessage());
    }

    return professor;
}
    //alterado para cadastrar cada professor em um arquivo individual
    public void cadastrarProfessor(Professor professor){
        if(verificarProfessor(professor.getMatricula()) == false){//verifica se o professor existe, caso não exista ele cadastra o professor
            try{
            FileWriter escritor = new FileWriter("banco/professor" + professor.getMatricula() + ".txt", true);
            escritor.write("Professor :{\n");
            escritor.write("    nome: " + professor.getNome() + ",\n" + "    cpf: " +professor.getCpf() + ",\n" + "    rg: " + professor.getRg() + ",\n" + "    matricula: " + professor.getMatricula() + ",\n" + "    email: " + professor.getEmail() + ",\n" + "    diaNasc: " + professor.getDiaNasc() + ",\n" + "    mesNasc: " + professor.getMesNasc() + ",\n" + "    anoNasc: " + professor.getAnoNasc() + ",\n" + "    nomeRua: " + professor.getNomeRua() + ",\n" + "    nomeBairro: " + professor.getNomeBairro() + ",\n" + "    nomeCidade: " + professor.getNomeCidade() + ",\n" + "    numeroCasa: " + professor.getNumeroCasa() + ",\n" + "    complemento: " + professor.getComplemento() + ",\n" + "    numeroTelefone: " + professor.getNumeroTelefone() + ",\n" + "    senha: " + professor.getSenha() + ",\n" + "    formacaoAcademica: " + professor.getFormacaoAcademica() + ",\n" + "    disciplinasLeciona: " + professor.getDisciplinasLeciona() + ",\n" + "    turmasLeciona: " + professor.getTurmasLeciona() + "\n");
            escritor.write("}");
            escritor.close();
            System.out.println("Professor adicionado com sucesso!");
            
            }catch(IOException e){
                System.err.println("Erro ao cadastrar Professor " + e.getMessage());
            }
        }else{
            System.out.println("Professor já cadastrado no sistema");
        }
        
    }

    /*public void editarProfessor(Professor novoProfessor, String matricula){
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
        
    }*/

    public void editarProfessor(Professor novoProfessor, String matricula){
        try (BufferedReader leitor = new BufferedReader(new FileReader("banco/professor" + matricula + ".txt"))){
             
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void listarProfessores(){
        //professores = getProfessor();
        for(Professor professor : professores){
            System.out.println(professor.getNome());
        }
    }

    public void sobrescreverArquivo(){
        try{
            FileWriter escritor = new FileWriter("professores.txt", false);
            for(Professor professor : professores){
                escritor.write(professor.getNome() + ";" + professor.getCpf() + ";" + professor.getRg() + ";" + professor.getMatricula() + ";" + professor.getEmail() + ";" + professor.getDiaNasc() + ";" + professor.getMesNasc() + ";" + professor.getAnoNasc() + ";" + professor.getNomeRua() + ";" + professor.getNomeBairro() + ";" + professor.getNomeCidade() + ";" + professor.getNumeroCasa() + ";" + professor.getComplemento() + ";" + professor.getNumeroTelefone() + ";" + professor.getSenha() + ";" + professor.getFormacaoAcademica() + ";" + professor.getDisciplinasLeciona() + ";" + professor.getTurmasLeciona() + "\n");
            }
            System.out.println("Arquivo sobrescrito!");
            escritor.close();
        }catch(IOException e){
            System.err.println("Erro ao sobrescrever arquivo" + e.getMessage());
        }
    }

    public boolean buscarPorNome(String nome){
        //ArrayList<Professor> professores = getProfessor();
        boolean resp = false;

        for (Professor professor : professores) {
            String nomeUpper = professor.getNome().toUpperCase();
            if(nomeUpper.equals(nome.toUpperCase())){
                resp = true;
            }
        }
        return resp;
    }

    public boolean buscarPorCpf(String cpf){
        //professores = getProfessor();
        boolean resp = false;

        for (Professor professor : professores) {
            if(professor.getCpf().equals(cpf)){
                resp = true;
            }
        }
        return resp;
    }

    public boolean buscarPorDisciplina(String nomeDisciplina, String matricula){
        //professores = getProfessor();
        boolean resp = false;
        for(Professor professor : professores){
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
            //professores = getProfessor();
            for(Professor professor : professores){
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
            //professores = getProfessor();
            Professor professorRemover = null;
            for(Professor professor : professores){
                if(professor.getMatricula().equals(matricula)){
                    professorRemover = professor;
                    resp = true;
                    break;
                }
            }
            if(resp){
                professores.remove(professorRemover);
                sobrescreverArquivo();
            }
        }
        
    }

    public boolean verificarProfessor(String matricula){
        //professores = getProfessores();
        boolean resp = false;
        for(Professor professor : professores){
            if(professor.getMatricula().equals(matricula)){
                resp = true;
            }
        }
        return resp;
    }
    //FALTA CONCERTAR ESSE MÉTODO DE adicionarTurmasAoProfessor!!! Ele muda a turma ao invés de adicionar no final do ArrayList
    /*public void adicionarTurmasAoProfessor(Turma turma, String matriculaProfessor){
        professores = getProfessores();
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
    } */
}
