package visao;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// Erick
import java.util.ArrayList;
import java.util.Map;

import dao.AnoEscolarDAO;
import dao.DisciplinaDAO;
import dao.ProfessorDAO;
import dao.Services;
import dao.TurmaDAO;
import modelo.*;

public class App {
    public static void main(String[] args) {
        ProfessorDAO pDAO = new ProfessorDAO();

       // pDAO.cadastrarProfessor(p25);
        
        // pDAO.sobrescreverArquivo();
        // pDAO.listarProfessores();
        // pDAO.editarProfessor(p25, "HUM001");
        //pDAO.listarProfessores();
        // System.out.println(pDAO.buscarPorNome("Karina Lima"));
        // System.out.println(pDAO.buscarPorCpf("555.666.777-81"));
        //System.out.println(pDAO.buscarPorDisciplina("Química", "CIE006"));
        // pDAO.removerProfessor("MAT002");

        //Professor p26 = new Professor("Everton Souza Fagundes", "092.804.235-93", "BA5678901", "INFO06", "yuri@colegio.edu.br", 18, 2, 2007, "Rua Y", "Bairro Y", "Cidade Y", 501, "Casa Azul", "99995555", "Everton123", "Professor de Informática");

        //Administrador adm1 = new Administrador("Geovânio", null, null, null, null, 0, 0, 0, null, null, null, 0, null, null, null);

        //Disciplina RedesI = new Disciplina("RedesII", "R001", "Disciplina de Redes I", 75);
        // adm1.cadastrarProfessor(p26);
        //adm1.adicionarDisciplinaAoProfessor(RedesI, "INFO01");

        // adm1.adicionarDisciplinaAoProfessor(RedesI, "INFO01");

        //Turma t1 = new Turma(2, "A");
        //adm1.adicionarTurmasAoProfessor(t1, "INFO01");

        // adm1.editarProfessor(p26);

        //adm1.cadastrarProfessor(p26);

        //Map <String, String> dados = Services.lerDados("banco/professor" + p26.getMatricula() + ".txt");
        //System.out.println(dados.get("disciplinasLeciona"));
        //Turma t1 = new Turma(5, "C");

        //Professor p28 = new Professor("Mariana Duarte Silveira dos Santos", "318.642.910-57", "SP9034128", "MAT04", "mariana.silveira@colegio.edu.br", 12, 9, 1989, "Rua das Acácias", "Jardim Primavera", "São Paulo", 742, "Casa Verde", "11988776655", "MarianaD89", "Professora de Matemática");
        // if(adm1.buscarPorNome("Everton Souza Fagundes")){
        //     System.out.println("achou");
        // }

        //Path caminho = Paths.get("banco/turmas/");
        //System.out.println("Tentando ler de: " + caminho.toAbsolutePath());
        //System.out.println("Existe? " + Files.exists(caminho)); 

        //TurmaDAO.criarTurma(t);
        //pDAO.adicionarTurmasAoProfessor(t, "20250005");
        //TurmaDAO.adiconarProfessorLeciona(t, "20250005");
        //TurmaDAO.adiconarProfessorLeciona(t, "20250005");
        //TurmaDAO.removerProfessorLeciona(t, "20250004");
        //Map<String, String> dados = Services.lerDados("src/dao/settings.txt");
        //Disciplina d = new Disciplina("Inglês instrumental", Services.criarCodigoDisciplina() , "Portugues fundamental", 30);
        //d.getLecionadaPor().add(p28);
        //DisciplinaDAO.criarDisciplina(d);
        //Turma t = TurmaDAO.getTurma(1, "A");
        //Turma t = new Turma(1, "A");
        //t.setCodigo(Services.criarCodigoTurma());
        //TurmaDAO.sobrescreverArquivoTurma(t);
        //System.out.println(t.getCodigo());


    }

}