package dao;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import modelo.ProfessorDisciplinaTurma;

public class ProfessorDisciplinaTurmaDAO {
    public static void criarAtribuicaoProfessorDisciplinaTurma(ProfessorDisciplinaTurma professorDisciplinaTurma){
        File diretorio = new File("banco/ProfessorDisciplinaTurma/");
        if(!diretorio.isDirectory()){
            diretorio.mkdirs();
        }
        File arquivo = new File("banco/ProfessorDisciplinaTurma/PDT" + professorDisciplinaTurma.getId() + ".txt");
        if(arquivo.isFile()){
            System.out.println("Arquivo já existente!");
        }else{
            try(FileWriter escritor = new FileWriter("banco/ProfessorDisciplinaTurma/PDT" + professorDisciplinaTurma.getId() + ".txt", false)){
            escritor.write("PDT :{\n");
            escritor.write("    id: " + professorDisciplinaTurma.getId() + ",\n");
            escritor.write("    professor: " + professorDisciplinaTurma.getProfessor().getMatricula() + ",\n");
            escritor.write("    disciplina: " + professorDisciplinaTurma.getDisciplina().getCodigo() + ",\n");
            escritor.write("    turma: " + professorDisciplinaTurma.getTurma().getCodigo() + "\n");
            escritor.write("}");
            escritor.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Erro ao criar atribuição ProfessorDisciplinaTurma", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void editarAtribuicaoProfessorDisciplinaTurma(){

    }

    public static void removerAtribuicaoProfessorDisciplinaTurma(){

    }

    public static void getAtribuicaoProfessorDisciplinaTurma(){

    }

    public static void sobrescreverArquivo(){

    }
}