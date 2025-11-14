package dao;
import static dao.Services.lerDados;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import dao.Services;
import modelo.Disciplina;
import modelo.Professor;

public class DisciplinaDAO {
    public static void criarDisciplina(Disciplina disciplina){
        File diretorio = new File("banco/disciplinas/");
        if(!diretorio.isDirectory()){
            diretorio.mkdirs();
        }
        File arquivo = new File("banco/disciplinas/DISCIPLINA" + disciplina.getCodigo() + ".txt");
        if(arquivo.isFile()){
            JOptionPane.showMessageDialog(null, "Disciplina já existente!", "Erro ao criar disciplina", JOptionPane.ERROR_MESSAGE);
        }else{
            try(FileWriter escritor = new FileWriter("banco/disciplinas/DISCIPLINA" + disciplina.getCodigo() + ".txt", false)){
            escritor.write("Disciplina :{\n");
            escritor.write("    nome: " + disciplina.getNome() + ",\n");
            escritor.write("    codigo: " + disciplina.getCodigo() + ",\n");
            escritor.write("    descricao: " + disciplina.getDescricao() + ",\n");
            escritor.write("    cargaHoraria: " + disciplina.getCargaHoraria() + ",\n");
            escritor.write("    lecionadaPor: [");
            
            for(int i=0; i<disciplina.getLecionadaPor().size(); i++){
                if(i == (disciplina.getLecionadaPor().size())-1){
                    escritor.write(disciplina.getLecionadaPor().get(i).getMatricula());
                }else{
                    escritor.write(disciplina.getLecionadaPor().get(i).getMatricula() + ", ");
                }
            }
            escritor.write("]\n");
            escritor.write("}");
            escritor.close();
            }catch(Exception e){
                System.out.println("Erro ao criar disciplina " + e.getMessage());
            }
        }
    }

    public static Disciplina getDisciplina(String codigo){
        File arquivo = new File("banco/disciplinas/DISCIPLINA" + codigo + ".txt");
        Map<String, String> dados = lerDados("banco/disciplinas/DISCIPLINA" + codigo + ".txt");
        ProfessorDAO professorDAO = new ProfessorDAO();
        Disciplina disciplina = new Disciplina();
        if(arquivo.isFile()){
            String nome = dados.get("nome");
            String descricao = dados.get("descricao");
            int cargaHoraria = Integer.parseInt(dados.get("cargaHoraria"));
            String lecionadaPor = dados.get("lecionadaPor");
            String[] lecionadaPorTexto = lecionadaPor.split(",");
            ArrayList<Professor> professores = new ArrayList<>();
            for(String matricula : lecionadaPorTexto){
                matricula = matricula.replace("[", "").replace("]", "");
                professores.add(professorDAO.getProfessor(matricula));
            }
            disciplina = new Disciplina(nome, codigo, descricao, cargaHoraria);
            disciplina.setLecionadaPor(professores);
        }else{
            JOptionPane.showMessageDialog(null, "Disciplina não existente!", "Erro ao pegar disciplina", JOptionPane.ERROR_MESSAGE);
        }
        return disciplina;
    }

    public void editarDisciplina(Disciplina novaDisciplina, String codigo) {
        if (verificaDisciplina(codigo)) {
            // Atualiza os dados
            Disciplina d = getDisciplina(codigo);
            d.setNome(novaDisciplina.getNome());
            d.setDescricao(novaDisciplina.getDescricao());
            d.setCargaHoraria(novaDisciplina.getCargaHoraria());
            d.setLecionadaPor(novaDisciplina.getLecionadaPor());

            sobrescreverArquivo(novaDisciplina);
        }
    }

    public static boolean verificaDisciplina(String codigo){
        File arquivo = new File("banco/disciplinas/DISCIPLINA" + codigo + ".txt");
        if(arquivo.isFile()){
            return true;
        }else{
            return false;
        }
    }

    public static void sobrescreverArquivo(Disciplina disciplina){
        try(FileWriter escritor = new FileWriter("banco/disciplinas/DISCIPLINA" + disciplina.getCodigo() + ".txt", false)){
            escritor.write("Disciplina :{\n");
            escritor.write("    nome: " + disciplina.getNome() + ",\n");
            escritor.write("    codigo: " + disciplina.getCodigo() + ",\n");
            escritor.write("    descricao: " + disciplina.getDescricao() + ",\n");
            escritor.write("    cargaHoraria: " + disciplina.getCargaHoraria() + ",\n");
            escritor.write("    lecionadaPor: [");
            
            for(int i=0; i<disciplina.getLecionadaPor().size(); i++){
                if(i == (disciplina.getLecionadaPor().size())-1){
                    escritor.write(disciplina.getLecionadaPor().get(i).getMatricula());
                }else{
                    escritor.write(disciplina.getLecionadaPor().get(i).getMatricula() + ", ");
                }
            }
            escritor.write("]\n");
            escritor.write("}");
            escritor.close();
        }catch(Exception e){
            System.out.println("Erro ao sobrescrever Arquivo " + e.getMessage());
        }
    }


}
