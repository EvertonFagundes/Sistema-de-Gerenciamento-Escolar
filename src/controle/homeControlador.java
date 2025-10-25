package controle;
import static dao.Services.*;
import java.util.ArrayList;
import java.util.Map;
import modelo.Disciplina;
import modelo.Professor;

public class homeControlador {
    
    public void menu(){
        System.out.println("=== Sistema de Gerenciamento Escolar ===\n");
        System.out.println("1. Cadastrar Professor!");
        System.out.println("2. Listar Professores!");
        System.out.println("\n=============================================\n");

    }
    public static void main(String[] args) {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        Disciplina d1 = new Disciplina("Redes 1", "005", "Materia ensina topologias de rede, modelo osi, tcp-ip e muito mais.", 20);
        Disciplina d2 = new Disciplina("Matemática ", "003", "Materia que ensina funções do primeiro e segundo grau, análise combinatória e etc.", 75);
        disciplinas.add(d1);
        disciplinas.add(d2);
        ProfessorControlador pc = new ProfessorControlador();
        Professor professor = pc.criarProfessor("Givanildo", "092.804.412-54", "069565415465656", "20115013", "2011@colegio.edu.br", 12, 5, 1980, "Rua XXX", "Jequiezinho", "Jequié", 55, "Casa com muro branco e portão cinza", "73988659423", "Givanildo123","Docente", disciplinas);
        System.out.println(professor.getNome());
        System.out.println();
        
        System.out.println(verificarDado("professores.txt", "Givanilda"));
        Map<String, String> dados = lerDados("/home/erick/Documentos/Programação/sagres/Sistema-de-Gerenciamento-Escolar/src/dao/data/settings.txt");
        String matricula = criarMatricula(2024);
        System.out.println("Matrícula gerada: " + matricula);
    }
}