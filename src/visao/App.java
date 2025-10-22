package visao;

import java.util.ArrayList;

import dao.ProfessorDAO;
import modelo.Disciplina;
import modelo.Professor;

public class App {
    public static void main(String[] args) {
        ProfessorDAO pDAO = new ProfessorDAO();

        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        Disciplina d1 = new Disciplina("Redes 1", "005", "Materia ensina topologias de rede, modelo osi, tcp-ip e muito mais.", 20);
        Disciplina d2 = new Disciplina("Matemática ", "003", "Materia que ensina funções do primeiro e segundo grau, análise combinatória e etc.", 75);
        disciplinas.add(d1);
        disciplinas.add(d2);
        
        /*Professor p1 = new Professor("Givanildo", "092.804.412-54", "069565415465656", "20115013", "2011@colegio.edu.br", 12, 5, 1980, "Rua XXX", "Jequiezinho", "Jequié", 55, "Casa com muro branco e portão cinza", "73988659423", "Givanildo123", "Docente", disciplinas);*/

        //pDAO.cadastrarProfessor(p1);

        


    }
}
