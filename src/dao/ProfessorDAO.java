package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.List;
import java.util.ArrayList;

import modelo.Disciplina;
import modelo.Professor;

public class ProfessorDAO {

    ArrayList<Professor> listaProfessores = new ArrayList<>();

public ArrayList<Professor> lerArquivo() {

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

            listaProfessores.add(professor);
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler arquivo: " + e.getMessage());
    }

    return listaProfessores;
}

    public void cadastrarProfessor(Professor professor){
        try{
            /*nome, cpf, rg, matricula, email, dia, mes, ano, rua, bairro, cidade, numeroCasa, complemento, nTelefone, senha, formacaoAcademica, ArrayList<Disciplina>disciplinasLeciona */

            FileWriter escritor = new FileWriter("professores.txt", true);
            escritor.write(professor.getNome() + ";" + professor.getCpf() + ";" + professor.getRg() + ";" + professor.getMatricula() + ";" + professor.getEmail() + ";" + professor.getDiaNasc() + ";" + professor.getMesNasc() + ";" + professor.getAnoNasc() + ";" + professor.getNomeRua() + ";" + professor.getNomeBairro() + ";" + professor.getNomeCidade() + ";" + professor.getNumeroCasa() + ";" + professor.getComplemento() + ";" + professor.getNumeroTelefone() + ";" + professor.getSenha() + ";" + professor.getFormacaoAcademica() + ";" + professor.getDisciplinasLeciona() + "\n");
            escritor.close();
            System.out.println("Professor adicionado com sucesso!");
            
            // System.out.println(professor.getDisciplinasLeciona());
        }catch(IOException e){
            e.getMessage();
            // System.out.println("Erro");
        }
    }

    public void editarProfessor(Professor novoProfessor, String matricula){
        ArrayList<Professor> professores = lerArquivo();
        boolean encontrado = false;

        for (Professor p : professores) {
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
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            sobrescreverArquivo(professores); // sobrescreve o arquivo atualizado
            System.out.println("Professor atualizado com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public void listarProfessores(){
        String linha;
        StringBuilder conteudo = new StringBuilder(); 
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("professores.txt"));
            while((linha = leitor.readLine()) != null){
                conteudo.append(linha).append("\n");
                String[] professores = linha.split(";");
                System.out.println(professores[0]);                
                // System.out.println(conteudo);
            }
            leitor.close();
        }catch(IOException e){
            System.err.println("Erro ao imprimir os professores" + e.getMessage());
        }
    }

    public void sobrescreverArquivo(ArrayList<Professor> lista){

    }

    public boolean buscarPorNome(String nome){
        ArrayList<Professor> listaProfessores = lerArquivo();
        boolean resp = false;

        for (Professor professor : listaProfessores) {
            String nomeUpper = professor.getNome().toUpperCase();
            if(nomeUpper.equals(nome.toUpperCase())){
                resp = true;
            }
        }
        return resp;
    }

}
