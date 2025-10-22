package dao;

import java.io.FileWriter;
import java.util.List;

import modelo.Professor;

public class ProfessorDAO {

    public void cadastrarProfessor(Professor professor){
        try{
            /*nome, cpf, rg, matricula, email, dia, mes, ano, rua, bairro, cidade, numeroCasa, complemento, nTelefone, senha, formacaoAcademica, ArrayList<Disciplina>disciplinasLeciona */

            FileWriter escritor = new FileWriter("Professor.txt", true);
            escritor.write(professor.getNome() + ";" + professor.getCpf() + ";" + professor.getMatricula() + ";" + professor.getEmail() + ";" + professor.getDiaNasc() + ";" + professor.getMesNasc() + ";" + professor.getAnoNasc() + ";" + professor.getNomeRua() + ";" + professor.getNomeBairro() + ";" + professor.getNomeCidade() + ";" + professor.getNumeroCasa() + ";" + professor.getComplemento() + ";" + professor.getNumeroTelefone() + ";" + professor.getSenha() + ";" + professor.getFormacaoAcademica() + ";" + professor.getDisciplinasLeciona() + "\n");
            escritor.close();
            System.out.println("Professor adicionado com sucesso!");
            
            System.out.println(professor.getDisciplinasLeciona());
        }catch(Exception e){
            e.printStackTrace();
            // System.out.println("Erro");
        }
    }

    public void editarProfessor(Professor professor, String matricula){
        
    }

    public void listarProfessores(){

    }

    public void sobrescreverArquivo(List<Professor> lista){

    }

    public void buscarPorNome(){

    }

}
