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
            //Disciplina d = new Disciplina("Inglês instrumental", Services.criarCodigoDisciplina() , "Portugues fundamental", 30);
            //d.getLecionadaPor().add(p28);
        //DisciplinaDAO.criarDisciplina(d);
        // Turma t = TurmaDAO.getTurma(1, "A");
        //System.out.println(t.getCodigo());
        
        //pDAO.cadastrarProfessor(p28);
        //Services.criarCodigoDisciplina();
        //String codigo = dados.get("codigoDisciplina");
        //RedesI.setCodigo(codigo);
        //DisciplinaDAO.criarDisciplina(RedesI);
        //  TurmaDAO.criarTurma(t);
        //TurmaDAO.sobrescreverArquivoTurma(t);
        ProfessorDAO pDAO = new ProfessorDAO();
        Map<String, String> dados = Services.lerDados("src/dao/settings.txt");
        AnoEscolar a1 = new AnoEscolar(2025, "semestre");
        Services.criarCodigoAnoEscolar();
        a1.setCodigo(dados.get("codigoAnoEscolar"));
        AnoEscolarDAO.criarAnoEscolar(a1);
        
        /*
        Professor p28 = new Professor("Mariana Duarte Silveira dos Santos", "318.642.910-57", "SP9034128", "MAT04", "mariana.silveira@colegio.edu.br", 12, 9, 1989, "Rua das Acácias", "Jardim Primavera", "São Paulo", 742, "Casa Verde", "11988776655", "MarianaD89", "Professora de Matemática");
        
        Disciplina RedesI = new Disciplina("RedesI", "", "Disciplina de Redes I", 75);
        
        Turma t = new Turma(1, "A");
        Services.criarCodigoTurma();
        t.setCodigo(dados.get("codigoTurma"));
        TurmaDAO.sobrescreverArquivoTurma(t);
        
        ProfessorDisciplinaTurma pdt1 = new ProfessorDisciplinaTurma(p28, RedesI, t);
        System.out.println(pdt1.getProfessor());
        System.out.println(pdt1.getDisciplina());
        System.out.println(pdt1.getTurma());
        */
    }

}