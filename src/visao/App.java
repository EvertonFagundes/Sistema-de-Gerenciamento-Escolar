package visao;
// Erick
import java.util.ArrayList;
import dao.ProfessorDAO;
import modelo.*;

public class App {
    public static void main(String[] args) {
        ProfessorDAO pDAO = new ProfessorDAO();

        // --------------------
        // DISCIPLINAS VARIADAS POR PROFESSOR
        // --------------------

        // Matemática
        /*ArrayList<Disciplina> disMat1 = new ArrayList<>();
        disMat1.add(new Disciplina("Matemática", "MAT01", "Funções, Geometria", 60));
        disMat1.add(new Disciplina("Álgebra", "MAT02", "Equações, Inequações", 40));

        ArrayList<Disciplina> disMat2 = new ArrayList<>();
        disMat2.add(new Disciplina("Matemática", "MAT01", "Funções, Geometria", 60));
        disMat2.add(new Disciplina("Análise Combinatória", "MAT03", "Princípios de contagem", 30));

        ArrayList<Disciplina> disMat3 = new ArrayList<>();
        disMat3.add(new Disciplina("Matemática", "MAT01", "Funções, Geometria", 60));
        disMat3.add(new Disciplina("Estatística", "MAT04", "Probabilidade e estatística", 35));

        ArrayList<Disciplina> disMat4 = new ArrayList<>();
        disMat4.add(new Disciplina("Álgebra", "MAT02", "Equações, Inequações", 40));
        disMat4.add(new Disciplina("Estatística", "MAT04", "Probabilidade e estatística", 35));

        ArrayList<Disciplina> disMat5 = new ArrayList<>();
        disMat5.add(new Disciplina("Matemática", "MAT01", "Funções, Geometria", 60));
        disMat5.add(new Disciplina("Álgebra", "MAT02", "Equações, Inequações", 40));
        disMat5.add(new Disciplina("Análise Combinatória", "MAT03", "Princípios de contagem", 30));

        ArrayList<Disciplina> disMat6 = new ArrayList<>();
        disMat6.add(new Disciplina("Estatística", "MAT04", "Probabilidade e estatística", 35));
        disMat6.add(new Disciplina("Álgebra", "MAT02", "Equações, Inequações", 40));

        // Português
        ArrayList<Disciplina> disPort1 = new ArrayList<>();
        disPort1.add(new Disciplina("Português", "POR01", "Gramática e interpretação", 50));
        disPort1.add(new Disciplina("Literatura", "POR02", "Estudos literários", 40));

        ArrayList<Disciplina> disPort2 = new ArrayList<>();
        disPort2.add(new Disciplina("Português", "POR01", "Gramática e interpretação", 50));
        disPort2.add(new Disciplina("Redação", "POR03", "Produção de textos", 30));

        ArrayList<Disciplina> disPort3 = new ArrayList<>();
        disPort3.add(new Disciplina("Literatura", "POR02", "Estudos literários", 40));
        disPort3.add(new Disciplina("Redação", "POR03", "Produção de textos", 30));

        ArrayList<Disciplina> disPort4 = new ArrayList<>();
        disPort4.add(new Disciplina("Português", "POR01", "Gramática e interpretação", 50));
        disPort4.add(new Disciplina("Redação", "POR03", "Produção de textos", 30));

        ArrayList<Disciplina> disPort5 = new ArrayList<>();
        disPort5.add(new Disciplina("Literatura", "POR02", "Estudos literários", 40));
        disPort5.add(new Disciplina("Gramática Avançada", "POR04", "Gramática aprofundada", 35));

        ArrayList<Disciplina> disPort6 = new ArrayList<>();
        disPort6.add(new Disciplina("Redação", "POR03", "Produção de textos", 30));
        disPort6.add(new Disciplina("Gramática Avançada", "POR04", "Gramática aprofundada", 35));

        // Informática
        ArrayList<Disciplina> disInfo1 = new ArrayList<>();
        disInfo1.add(new Disciplina("Redes", "INF01", "Topologias e protocolos", 25));
        disInfo1.add(new Disciplina("Programação", "INF02", "Algoritmos e lógica", 30));

        ArrayList<Disciplina> disInfo2 = new ArrayList<>();
        disInfo2.add(new Disciplina("Banco de Dados", "INF03", "SQL e modelagem", 40));
        disInfo2.add(new Disciplina("Redes", "INF01", "Topologias e protocolos", 25));

        ArrayList<Disciplina> disInfo3 = new ArrayList<>();
        disInfo3.add(new Disciplina("Segurança", "INF04", "Proteção de dados", 35));
        disInfo3.add(new Disciplina("Programação", "INF02", "Algoritmos e lógica", 30));

        ArrayList<Disciplina> disInfo4 = new ArrayList<>();
        disInfo4.add(new Disciplina("Redes", "INF01", "Topologias e protocolos", 25));
        disInfo4.add(new Disciplina("Banco de Dados", "INF03", "SQL e modelagem", 40));

        ArrayList<Disciplina> disInfo5 = new ArrayList<>();
        disInfo5.add(new Disciplina("Programação", "INF02", "Algoritmos e lógica", 30));
        disInfo5.add(new Disciplina("Segurança", "INF04", "Proteção de dados", 35));

        ArrayList<Disciplina> disInfo6 = new ArrayList<>();
        disInfo6.add(new Disciplina("Redes", "INF01", "Topologias e protocolos", 25));
        disInfo6.add(new Disciplina("Programação", "INF02", "Algoritmos e lógica", 30));
        disInfo6.add(new Disciplina("Banco de Dados", "INF03", "SQL e modelagem", 40));

        // Ciências
        ArrayList<Disciplina> disCie1 = new ArrayList<>();
        disCie1.add(new Disciplina("Física", "CIE01", "Mecânica e eletricidade", 40));
        disCie1.add(new Disciplina("Química", "CIE02", "Reações químicas", 35));

        ArrayList<Disciplina> disCie2 = new ArrayList<>();
        disCie2.add(new Disciplina("Biologia", "CIE03", "Genética e ecologia", 50));
        disCie2.add(new Disciplina("Física", "CIE01", "Mecânica e eletricidade", 40));

        ArrayList<Disciplina> disCie3 = new ArrayList<>();
        disCie3.add(new Disciplina("Química", "CIE02", "Reações químicas", 35));
        disCie3.add(new Disciplina("Biologia", "CIE03", "Genética e ecologia", 50));

        ArrayList<Disciplina> disCie4 = new ArrayList<>();
        disCie4.add(new Disciplina("Física", "CIE01", "Mecânica e eletricidade", 40));
        disCie4.add(new Disciplina("Química", "CIE02", "Reações químicas", 35));

        ArrayList<Disciplina> disCie5 = new ArrayList<>();
        disCie5.add(new Disciplina("Biologia", "CIE03", "Genética e ecologia", 50));
        disCie5.add(new Disciplina("Física", "CIE01", "Mecânica e eletricidade", 40));

        ArrayList<Disciplina> disCie6 = new ArrayList<>();
        disCie6.add(new Disciplina("Química", "CIE02", "Reações químicas", 35));
        disCie6.add(new Disciplina("Biologia", "CIE03", "Genética e ecologia", 50));

        // Humanas
        ArrayList<Disciplina> disHum1 = new ArrayList<>();
        disHum1.add(new Disciplina("História", "HUM01", "História do Brasil", 40));
        disHum1.add(new Disciplina("Geografia", "HUM02", "Geografia geral", 35));

        // --------------------
        // PROFESSORES MATEMÁTICA
        // --------------------
        Professor p1 = new Professor("Ana Silva", "111.222.333-44", "MG1234567", "MAT001", "ana@colegio.edu.br", 12, 3, 1980, "Rua A", "Bairro A", "Cidade A", 101, "Casa Azul", "99991111", "Ana123", "Licenciatura em Matemática", disMat1);
        pDAO.cadastrarProfessor(p1);

        Professor p2 = new Professor("Bruno Lima", "222.333.444-55", "MG2345678", "MAT002", "bruno@colegio.edu.br", 5, 7, 1982, "Rua B", "Bairro B", "Cidade B", 102, "Casa Verde", "99992222", "Bruno123", "Licenciatura em Matemática", disMat2);
        pDAO.cadastrarProfessor(p2);

        Professor p3 = new Professor("Carla Souza", "333.444.555-66", "MG3456789", "MAT003", "carla@colegio.edu.br", 20, 11, 1985, "Rua C", "Bairro C", "Cidade C", 103, "Casa Vermelha", "99993333", "Carla123", "Licenciatura em Matemática", disMat3);
        pDAO.cadastrarProfessor(p3);

        Professor p4 = new Professor("Diego Pereira", "444.555.666-77", "MG4567890", "MAT004", "diego@colegio.edu.br", 15, 1, 1979, "Rua D", "Bairro D", "Cidade D", 104, "Casa Amarela", "99994444", "Diego123", "Licenciatura em Matemática", disMat4);
        pDAO.cadastrarProfessor(p4);

        Professor p5 = new Professor("Eduarda Martins", "555.666.777-88", "MG5678901", "MAT005", "eduarda@colegio.edu.br", 8, 9, 1983, "Rua E", "Bairro E", "Cidade E", 105, "Casa Laranja", "99995555", "Eduarda123", "Licenciatura em Matemática", disMat5);
        pDAO.cadastrarProfessor(p5);

        Professor p6 = new Professor("Fernando Costa", "666.777.888-99", "MG6789012", "MAT006", "fernando@colegio.edu.br", 30, 6, 1981, "Rua F", "Bairro F", "Cidade F", 106, "Casa Rosa", "99996666", "Fernando123", "Licenciatura em Matemática", disMat6);
        pDAO.cadastrarProfessor(p6);

        // --------------------
        // PROFESSORES PORTUGUÊS
        // --------------------
        Professor p7 = new Professor("Gabriela Alves", "777.888.999-00", "MG7890123", "POR001", "gabriela@colegio.edu.br", 18, 4, 1980, "Rua G", "Bairro G", "Cidade G", 201, "Casa Azul", "99997777", "Gabriela123", "Licenciatura em Português", disPort1);
        pDAO.cadastrarProfessor(p7);

        Professor p8 = new Professor("Henrique Dias", "888.999.000-11", "MG8901234", "POR002", "henrique@colegio.edu.br", 12, 2, 1984, "Rua H", "Bairro H", "Cidade H", 202, "Casa Verde", "99998888", "Henrique123", "Licenciatura em Português", disPort2);
        pDAO.cadastrarProfessor(p8);

        Professor p9 = new Professor("Isabela Rocha", "999.000.111-22", "MG9012345", "POR003", "isabela@colegio.edu.br", 25, 12, 1982, "Rua I", "Bairro I", "Cidade I", 203, "Casa Vermelha", "99999999", "Isabela123", "Licenciatura em Português", disPort3);
        pDAO.cadastrarProfessor(p9);

        Professor p10 = new Professor("João Fernandes", "000.111.222-33", "MG0123456", "POR004", "joao@colegio.edu.br", 3, 5, 1981, "Rua J", "Bairro J", "Cidade J", 204, "Casa Amarela", "99990000", "Joao123", "Licenciatura em Português", disPort4);
        pDAO.cadastrarProfessor(p10);

        Professor p11 = new Professor("Karina Lima", "111.222.333-44", "MG1234567", "POR005", "karina@colegio.edu.br", 9, 8, 1983, "Rua K", "Bairro K", "Cidade K", 205, "Casa Laranja", "99991111", "Karina123", "Licenciatura em Português", disPort5);
        pDAO.cadastrarProfessor(p11);

        Professor p12 = new Professor("Lucas Andrade", "222.333.444-55", "MG2345678", "POR006", "lucas@colegio.edu.br", 21, 7, 1985, "Rua L", "Bairro L", "Cidade L", 206, "Casa Rosa", "99992222", "Lucas123", "Licenciatura em Português", disPort6);
        pDAO.cadastrarProfessor(p12);

        // --------------------
        // PROFESSORES INFORMÁTICA
        // --------------------
        Professor p13 = new Professor("Marcelo Santos", "333.444.555-66", "MG3456789", "INF001", "marcelo@colegio.edu.br", 11, 3, 1980, "Rua M", "Bairro M", "Cidade M", 301, "Casa Azul", "99993333", "Marcelo123", "Ciência da Computação", disInfo1);
        pDAO.cadastrarProfessor(p13);

        Professor p14 = new Professor("Natália Mendes", "444.555.666-77", "MG4567890", "INF002", "natalia@colegio.edu.br", 17, 6, 1982, "Rua N", "Bairro N", "Cidade N", 302, "Casa Verde", "99994444", "Natalia123", "Ciência da Computação", disInfo2);
        pDAO.cadastrarProfessor(p14);

        Professor p15 = new Professor("Otávio Lima", "555.666.777-88", "MG5678901", "INF003", "otavio@colegio.edu.br", 29, 9, 1984, "Rua O", "Bairro O", "Cidade O", 303, "Casa Vermelha", "99995555", "Otavio123", "Ciência da Computação", disInfo3);
        pDAO.cadastrarProfessor(p15);

        Professor p16 = new Professor("Patrícia Carvalho", "666.777.888-99", "MG6789012", "INF004", "patricia@colegio.edu.br", 14, 2, 1981, "Rua P", "Bairro P", "Cidade P", 304, "Casa Amarela", "99996666", "Patricia123", "Ciência da Computação", disInfo4);
        pDAO.cadastrarProfessor(p16);

        Professor p17 = new Professor("Quintino Rocha", "777.888.999-00", "MG7890123", "INF005", "quintino@colegio.edu.br", 6, 11, 1983, "Rua Q", "Bairro Q", "Cidade Q", 305, "Casa Laranja", "99997777", "Quintino123", "Ciência da Computação", disInfo5);
        pDAO.cadastrarProfessor(p17);

        Professor p18 = new Professor("Rafaela Pinto", "888.999.000-11", "MG8901234", "INF006", "rafaela@colegio.edu.br", 23, 1, 1985, "Rua R", "Bairro R", "Cidade R", 306, "Casa Rosa", "99998888", "Rafaela123", "Ciência da Computação", disInfo6);
        pDAO.cadastrarProfessor(p18);

        // --------------------
        // PROFESSORES CIÊNCIAS
        // --------------------
        Professor p19 = new Professor("Sérgio Costa", "999.000.111-22", "MG9012345", "CIE001", "sergio@colegio.edu.br", 12, 4, 1980, "Rua S", "Bairro S", "Cidade S", 401, "Casa Azul", "99999999", "Sergio123", "Licenciatura em Ciências", disCie1);
        pDAO.cadastrarProfessor(p19);

        Professor p20 = new Professor("Tatiane Alves", "000.111.222-33", "MG0123456", "CIE002", "tatiane@colegio.edu.br", 19, 6, 1982, "Rua T", "Bairro T", "Cidade T", 402, "Casa Verde", "99990000", "Tatiane123", "Licenciatura em Ciências", disCie2);
        pDAO.cadastrarProfessor(p20);

        Professor p21 = new Professor("Ulisses Ferreira", "111.222.333-44", "MG1234567", "CIE003", "ulisses@colegio.edu.br", 7, 9, 1984, "Rua U", "Bairro U", "Cidade U", 403, "Casa Vermelha", "99991111", "Ulisses123", "Licenciatura em Ciências", disCie3);
        pDAO.cadastrarProfessor(p21);

        Professor p22 = new Professor("Valéria Santos", "222.333.444-55", "MG2345678", "CIE004", "valeria@colegio.edu.br", 3, 12, 1981, "Rua V", "Bairro V", "Cidade V", 404, "Casa Amarela", "99992222", "Valeria123", "Licenciatura em Ciências", disCie4);
        pDAO.cadastrarProfessor(p22);

        Professor p23 = new Professor("William Lima", "333.444.555-66", "MG3456789", "CIE005", "william@colegio.edu.br", 28, 1, 1983, "Rua W", "Bairro W", "Cidade W", 405, "Casa Laranja", "99993333", "William123", "Licenciatura em Ciências", disCie5);
        pDAO.cadastrarProfessor(p23);

        Professor p24 = new Professor("Ximena Rocha", "444.555.666-77", "MG4567890", "CIE006", "ximena@colegio.edu.br", 16, 5, 1985, "Rua X", "Bairro X", "Cidade X", 406, "Casa Rosa", "99994444", "Ximena123", "Licenciatura em Ciências", disCie6);
        pDAO.cadastrarProfessor(p24);

        // --------------------
        // PROFESSORES HUMANAS
        // --------------------
        Professor p25 = new Professor("Yuri Martins", "555.666.777-88", "MG5678901", "HUM001", "yuri@colegio.edu.br", 2, 7, 1980, "Rua Y", "Bairro Y", "Cidade Y", 501, "Casa Azul", "99995555", "Yuri123", "Licenciatura em Humanas", disHum1);
        pDAO.cadastrarProfessor(p25);

        System.out.println("25 professores cadastrados com sucesso!");*/

        /*ArrayList<Professor> professores = pDAO.lerArquivo();
        for(Professor professor : professores){
            System.out.println("Professor " + professor.getNome() + " matricula " + professor.getMatricula());
        }*/

        /*ArrayList<Disciplina> disHum1 = new ArrayList<>();
        disHum1.add(new Disciplina("História", "HUM01", "História do Brasil", 40));
        disHum1.add(new Disciplina("Geografia", "HUM02", "Geografia geral", 35));

        Professor p25 = new Professor("Yuri Martins dos Santos Silva Seliton", "555.666.777-88", "MG5678901", "HUM001", "yuri@colegio.edu.br", 2, 7, 1980, "Rua Y", "Bairro Y", "Cidade Y", 501, "Casa Azul", "99995555", "Yuri123", "Licenciatura em Humanas", disHum1);*/
        // pDAO.cadastrarProfessor(p25);
        
        // pDAO.sobrescreverArquivo();
        // pDAO.listarProfessores();
        // pDAO.editarProfessor(p25, "HUM001");
        //pDAO.listarProfessores();
        // System.out.println(pDAO.buscarPorNome("Karina Lima"));
        // System.out.println(pDAO.buscarPorCpf("555.666.777-81"));
        //System.out.println(pDAO.buscarPorDisciplina("Química", "CIE006"));
        // pDAO.removerProfessor("MAT002");

        Professor p26 = new Professor("Everton Souza Fagundes", "092.804.235-93", "BA5678901", "INFO01", "yuri@colegio.edu.br", 18, 2, 2007, "Rua Y", "Bairro Y", "Cidade Y", 501, "Casa Azul", "99995555", "Everton123", "Professor de Informática");

        Administrador adm1 = new Administrador("Geovânio", null, null, null, null, 0, 0, 0, null, null, null, 0, null, null, null);

        Disciplina RedesI = new Disciplina("RedesII", "R001", "Disciplina de Redes I", 75);
        // adm1.cadastrarProfessor(p26);
        //adm1.adicionarDisciplinaAoProfessor(RedesI, "INFO01");

        // adm1.adicionarDisciplinaAoProfessor(RedesI, "INFO01");

        //Turma t1 = new Turma(2, "A");
        //adm1.adicionarTurmasAoProfessor(t1, "INFO01");

        // adm1.editarProfessor(p26);

    }
}