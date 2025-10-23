package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import modelo.Professor;

public class ProfessorDAO {

    public void cadastrarProfessor(Professor professor){
        try{
            /*nome, cpf, rg, matricula, email, dia, mes, ano, rua, bairro, cidade, numeroCasa, complemento, nTelefone, senha, formacaoAcademica, ArrayList<Disciplina>disciplinasLeciona */

            FileWriter escritor = new FileWriter("professores.txt", true);
            escritor.write(professor.getNome() + ";" + professor.getCpf() + ";" + professor.getMatricula() + ";" + professor.getEmail() + ";" + professor.getDiaNasc() + ";" + professor.getMesNasc() + ";" + professor.getAnoNasc() + ";" + professor.getNomeRua() + ";" + professor.getNomeBairro() + ";" + professor.getNomeCidade() + ";" + professor.getNumeroCasa() + ";" + professor.getComplemento() + ";" + professor.getNumeroTelefone() + ";" + professor.getSenha() + ";" + professor.getFormacaoAcademica() + ";" + professor.getDisciplinasLeciona() + "\n");
            escritor.close();
            System.out.println("Professor adicionado com sucesso!");
            
            // System.out.println(professor.getDisciplinasLeciona());
        }catch(IOException e){
            e.getMessage();
            // System.out.println("Erro");
        }
    }

    public void editarProfessor(Professor professor){
        String linha;
        StringBuilder conteudo = new StringBuilder();
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("professores.txt"));
            while((linha = leitor.readLine()) != null){

            }
            leitor.close();
        }catch(IOException e){
            e.getMessage();
        }
    }

    public void listarProfessores(){
        // ArrayList<Professor> listaProfessores = new ArrayList<>();
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
            e.getMessage();
        }
    }

    public void sobrescreverArquivo(ArrayList<Professor> lista){

    }

    public void buscarPorNome(){

    }

}
