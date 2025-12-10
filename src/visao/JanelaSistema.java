package visao;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import visao.PainelLogin;

public class JanelaSistema extends JFrame {

    // Painéis principais
    private JPanel painelPrincipal;
    private JPanel painelInicio;
    private PainelLogin painelLogin;
    private JPanel painelCadastroAlunos;
    private JPanel painelCadastroProfessor;
    private JPanel painelGerenciamentoProfessor;
    private JPanel painelCadastroDisciplina;
    private JPanel painelGerenciamentoDisciplina;
    private PainelCadastroAnoEscolar painelCadastroAnoEscolar;
    private PainelGerenciamentoAluno painelGerenciamentoAluno;
    private PainelGerenciamentoAnoEscolar painelGerenciamentoAnoEscolar;
    private PainelCadastroTurma painelCadastroTurma;
    private PainelCadastroSerie painelCadastroSerie;
    private PainelGerenciamentoSerie painelGerenciamentoSerie;
    private PainelGerenciamentoTurma painelGerenciamentoTurma;


    // Menus principais
    private JMenuBar menuBarPrincipal;
    private JMenuBar menuBarAdministrador;
    private JMenuBar menuBarProfessor;
    private JMenuBar menuBarAluno;
    private JMenu menuCadastros;
    private JMenu menuFinanceiro;
    private JMenu menuGerenciamento;
    private JMenu menuMatriculasTurmas;
    private JMenu menuBoletim;
    private JMenu menuBuscar;

    // Itens de menu - Cadastros
    private JMenuItem itemCadastroAlunos;
    private JMenuItem itemCadastroProfessores;
    private JMenuItem itemCadastroDisciplinas;
    private JMenuItem itemCadastroAnoEscolar;
    private JMenuItem itemCadastroTurma;
    private JMenuItem itemCadastroSerie;

    // Itens de menu - Financeiro
    private JMenuItem itemFinanceiroMensalidades;
    private JMenuItem itemFinanceiroGestao;

    // Itens de menu - Gerenciamento
    private JMenuItem itemGerenciamentoAlunos;
    private JMenuItem itemGerenciamentoProfessores;
    private JMenuItem itemGerenciamentoDisciplinas;
    private JMenuItem itemGerenciamentoAnoEscolar;
    private JMenuItem itemGerenciamentoSerie;
    private JMenuItem itemGerenciamentoTurma;

    // Itens de menu - Matrículas e Turmas
    private JMenuItem itemMatriculaAlunoSerie;

    // Itens de menu - Buscar
    private JMenuItem itemBuscarAlunos;
    private JMenuItem itemBuscarProfessores;
    private JMenuItem itemBuscarDisciplinas;

    private JButton btnAdministrador;
    private JButton btnAluno;
    private JButton btnProfessor;

    // ------------------------------------------------------
    // MÉTODO PRINCIPAL
    // ------------------------------------------------------
    public static void main(String[] args) {
        JanelaSistema janela = new JanelaSistema();
        janela.setVisible(true);
    }

    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    public JanelaSistema() {
        configurarJanela();
        inicializarPaineis();
        // inicializarMenu();
        inicializarMenuAdministrador();
        inicializarMenuProfessor();
        inicializarMenuAluno();
        configurarEventos();
    }

    // ------------------------------------------------------
    // CONFIGURAÇÕES BÁSICAS DA JANELA
    // ------------------------------------------------------
    private void configurarJanela() {
        setTitle("Sistema Principal - Testando Cadastro de Disciplina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // ------------------------------------------------------
    // PAINÉIS
    // ------------------------------------------------------
    private void inicializarPaineis() {
        painelPrincipal = new JPanel(new CardLayout());
        painelPrincipal.setBackground(new Color(230, 240, 240));

        //painelInicio = new JPanel();
        //painelInicio.add(new JLabel("Bem-vindo ao Sistema", SwingConstants.CENTER));
        
        painelLogin = new PainelLogin();
        painelCadastroAlunos = new PainelCadastroAlunos();
        painelCadastroProfessor = new PainelCadastroProfessor();
        painelGerenciamentoProfessor = new PainelGerenciamentoProfessor();
        painelCadastroDisciplina = new PainelCadastroDisciplina();
        painelGerenciamentoDisciplina = new PainelGerenciamentoDisciplina();
        painelCadastroAnoEscolar = new PainelCadastroAnoEscolar();
        painelGerenciamentoAluno = new PainelGerenciamentoAluno();
        painelGerenciamentoAnoEscolar = new PainelGerenciamentoAnoEscolar();
        painelCadastroTurma = new PainelCadastroTurma();
        painelCadastroSerie = new PainelCadastroSerie();
        painelGerenciamentoSerie = new PainelGerenciamentoSerie();
        painelGerenciamentoTurma = new PainelGerenciamentoTurma();

        //painelPrincipal.add(painelInicio, "inicio");
        painelPrincipal.add(painelLogin);
        btnAdministrador = painelLogin.getBtnAdministrador();
        btnAluno = painelLogin.getBtnAluno();
        btnProfessor = painelLogin.getBtnProfessor();

        painelPrincipal.add(painelCadastroAlunos, "cadastroAlunos");
        painelPrincipal.add(painelCadastroProfessor, "cadastroProfessor");
        painelPrincipal.add(painelGerenciamentoProfessor, "gerenciamentoProfessor");
        painelPrincipal.add(painelCadastroDisciplina, "cadastroDisciplina");
        painelPrincipal.add(painelGerenciamentoDisciplina, "gerenciamentoDisciplina");
        painelPrincipal.add(painelCadastroAnoEscolar, "cadastroAnoEscolar");
        painelPrincipal.add(painelGerenciamentoAluno, "gerenciamentoAluno");
        painelPrincipal.add(painelGerenciamentoAnoEscolar, "gerenciamentoAnoEscolar");
        painelPrincipal.add(painelCadastroTurma, "cadastroTurma");
        painelPrincipal.add(painelCadastroSerie, "cadastroSerie");
        painelPrincipal.add(painelGerenciamentoSerie, "gerenciamentoSerie");
        painelPrincipal.add(painelGerenciamentoTurma, "gerenciamentoTurma");

        getContentPane().add(painelPrincipal);
    }

    // ------------------------------------------------------
    // MENU
    // ------------------------------------------------------
    /*private void inicializarMenu() {
        // Barra de menu
        menuBarPrincipal = new JMenuBar();
        menuBarAdministrador = new JMenuBar();
        menuBarProfessor = new JMenuBar();
        menuBarAluno = new JMenuBar();
        menuBarAdministrador.setBackground(new Color(255, 247, 221));
        menuBarProfessor.setBackground(new Color(255, 247, 221));
        menuBarAluno.setBackground(new Color(255, 247, 221));
        menuBarPrincipal.setBackground(new Color(255, 247, 221));
        //setJMenuBar(menuBarPrincipal);

        // ------------------- MENU CADASTROS -------------------
        menuCadastros = criarMenu("Cadastros");
        itemCadastroAlunos = criarItemMenu("Alunos");
        itemCadastroProfessores = criarItemMenu("Professores");
        itemCadastroDisciplinas = criarItemMenu("Disciplinas");
        itemCadastroAnoEscolar = criarItemMenu("Ano Escolar");
        itemCadastroTurma = criarItemMenu("Turma");
        itemCadastroSerie = criarItemMenu("Serie");
        menuCadastros.add(itemCadastroAlunos);
        menuCadastros.add(itemCadastroProfessores);
        menuCadastros.add(itemCadastroDisciplinas);
        menuCadastros.add(itemCadastroAnoEscolar);
        menuCadastros.add(itemCadastroTurma);
        menuCadastros.add(itemCadastroSerie);
        menuBarPrincipal.add(menuCadastros);

        // ------------------- MENU FINANCEIRO -------------------
        menuFinanceiro = criarMenu("Financeiro");
        itemFinanceiroMensalidades = criarItemMenu("Mensalidades");
        itemFinanceiroGestao = criarItemMenu("Gestão Financeira");
        menuFinanceiro.add(itemFinanceiroMensalidades);
        menuFinanceiro.add(itemFinanceiroGestao);
        menuBarPrincipal.add(menuFinanceiro);

        // ------------------- MENU GERENCIAMENTO -------------------
        menuGerenciamento = criarMenu("Gerenciamento");
        itemGerenciamentoAlunos = criarItemMenu("Alunos");
        itemGerenciamentoProfessores = criarItemMenu("Professores");
        itemGerenciamentoDisciplinas = criarItemMenu("Disciplinas");
        itemGerenciamentoAnoEscolar = criarItemMenu("Ano Escolar");
        itemGerenciamentoSerie = criarItemMenu("Serie");
        itemGerenciamentoTurma = criarItemMenu("Turma");
        menuGerenciamento.add(itemGerenciamentoAlunos);
        menuGerenciamento.add(itemGerenciamentoProfessores);
        menuGerenciamento.add(itemGerenciamentoDisciplinas);
        menuGerenciamento.add(itemGerenciamentoAnoEscolar);
        menuGerenciamento.add(itemGerenciamentoSerie);
        menuGerenciamento.add(itemGerenciamentoTurma);
        menuBarPrincipal.add(menuGerenciamento);

        // ------------------- MENU MATRÍCULAS -------------------
        menuMatriculasTurmas = criarMenu("Matrículas e Turmas");
        itemMatriculaAlunoSerie = criarItemMenu("Matrícula de aluno em ano escolar e série");
        menuMatriculasTurmas.add(itemMatriculaAlunoSerie);
        menuBarPrincipal.add(menuMatriculasTurmas);

        // ------------------- MENU BOLETIM -------------------
        menuBoletim = criarMenu("Boletim");
        menuBarPrincipal.add(menuBoletim);

        // ------------------- MENU BUSCAR -------------------
        menuBuscar = criarMenu("Buscar");
        itemBuscarAlunos = criarItemMenu("Alunos");
        itemBuscarProfessores = criarItemMenu("Professores");
        itemBuscarDisciplinas = criarItemMenu("Disciplinas");
        menuBuscar.add(itemBuscarAlunos);
        menuBuscar.add(itemBuscarProfessores);
        menuBuscar.add(itemBuscarDisciplinas);
        menuBarPrincipal.add(menuBuscar);
    }
    */
   private void inicializarMenuAdministrador() {
        menuBarPrincipal = new JMenuBar();
        menuBarAdministrador = new JMenuBar();
        menuBarAdministrador.setBackground(new Color(255, 247, 221));

        // --- CADASTROS ---
        menuCadastros = criarMenu("Cadastros");
        itemCadastroAlunos = criarItemMenu("Alunos");
        itemCadastroProfessores = criarItemMenu("Professores");
        itemCadastroDisciplinas = criarItemMenu("Disciplinas");
        itemCadastroAnoEscolar = criarItemMenu("Ano Escolar");
        itemCadastroTurma = criarItemMenu("Turma");
        itemCadastroSerie = criarItemMenu("Serie");
        menuCadastros.add(itemCadastroAlunos);
        menuCadastros.add(itemCadastroProfessores);
        menuCadastros.add(itemCadastroDisciplinas);
        menuCadastros.add(itemCadastroAnoEscolar);
        menuCadastros.add(itemCadastroTurma);
        menuCadastros.add(itemCadastroSerie);
        menuBarPrincipal.add(menuCadastros);

        // --- GERENCIAMENTO ---
       menuGerenciamento = criarMenu("Gerenciamento");
        itemGerenciamentoAlunos = criarItemMenu("Alunos");
        itemGerenciamentoProfessores = criarItemMenu("Professores");
        itemGerenciamentoDisciplinas = criarItemMenu("Disciplinas");
        itemGerenciamentoAnoEscolar = criarItemMenu("Ano Escolar");
        itemGerenciamentoSerie = criarItemMenu("Serie");
        itemGerenciamentoTurma = criarItemMenu("Turma");
        menuGerenciamento.add(itemGerenciamentoAlunos);
        menuGerenciamento.add(itemGerenciamentoProfessores);
        menuGerenciamento.add(itemGerenciamentoDisciplinas);
        menuGerenciamento.add(itemGerenciamentoAnoEscolar);
        menuGerenciamento.add(itemGerenciamentoSerie);
        menuGerenciamento.add(itemGerenciamentoTurma);
        menuBarPrincipal.add(menuGerenciamento);

        // --- MATRÍCULAS ---
         menuMatriculasTurmas = criarMenu("Matrículas e Turmas");
        itemMatriculaAlunoSerie = criarItemMenu("Matrícula de aluno em ano escolar e série");
        menuMatriculasTurmas.add(itemMatriculaAlunoSerie);
        menuBarPrincipal.add(menuMatriculasTurmas);

        // --- FINANCEIRO ---
       menuFinanceiro = criarMenu("Financeiro");
        itemFinanceiroMensalidades = criarItemMenu("Mensalidades");
        itemFinanceiroGestao = criarItemMenu("Gestão Financeira");
        menuFinanceiro.add(itemFinanceiroMensalidades);
        menuFinanceiro.add(itemFinanceiroGestao);
        menuBarPrincipal.add(menuFinanceiro);

        // --- BOLETIM ---
        menuBoletim = criarMenu("Boletim");
        menuBarPrincipal.add(menuBoletim);

        // --- BUSCAR ---
        menuBuscar = criarMenu("Buscar");
        itemBuscarAlunos = criarItemMenu("Alunos");
        itemBuscarProfessores = criarItemMenu("Professores");
        itemBuscarDisciplinas = criarItemMenu("Disciplinas");
        menuBuscar.add(itemBuscarAlunos);
        menuBuscar.add(itemBuscarProfessores);
        menuBuscar.add(itemBuscarDisciplinas);
        menuBarPrincipal.add(menuBuscar);
    }

    private void inicializarMenuProfessor() {
        menuBarProfessor = new JMenuBar();
        menuBarProfessor.setBackground(new Color(255, 247, 221));

        // --- GERENCIAMENTO ---
        menuGerenciamento = criarMenu("Gerenciamento");
        menuGerenciamento.add(criarItemMenu("Alunos"));
        menuGerenciamento.add(criarItemMenu("Disciplinas"));
        menuGerenciamento.add(criarItemMenu("Turma"));
        menuBarProfessor.add(menuGerenciamento);

        // --- BOLETIM ---
        menuBoletim = criarMenu("Boletim");
        menuBarProfessor.add(menuBoletim);

        // --- BUSCAR ---
        menuBuscar = criarMenu("Buscar");
        menuBuscar.add(criarItemMenu("Alunos"));
        menuBuscar.add(criarItemMenu("Disciplinas"));
        menuBarProfessor.add(menuBuscar);
    }

    private void inicializarMenuAluno() {
        menuBarAluno = new JMenuBar();
        menuBarAluno.setBackground(new Color(255, 247, 221));

        // --- MATRÍCULAS ---
        menuMatriculasTurmas = criarMenu("Matrículas");
        menuMatriculasTurmas.add(criarItemMenu("Minha matrícula"));
        menuBarAluno.add(menuMatriculasTurmas);

        // --- BOLETIM ---
        menuBoletim = criarMenu("Boletim");
        menuBarAluno.add(menuBoletim);

        // --- BUSCAR ---
        menuBuscar = criarMenu("Buscar");
        menuBuscar.add(criarItemMenu("Minhas Disciplinas"));
        menuBarAluno.add(menuBuscar);
    }



    // ------------------------------------------------------
    // MÉTODOS DE AJUDA
    // ------------------------------------------------------
    private JMenu criarMenu(String titulo) {
        JMenu menu = new JMenu(titulo);
        menu.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menu.setBackground(new Color(255, 247, 221));
        return menu;
    }

    private JMenuItem criarItemMenu(String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.setFont(new Font("Century Gothic", Font.BOLD, 12));
        item.setBackground(new Color(255, 247, 221));
        return item;
    }

    // ------------------------------------------------------
    // EVENTOS
    // ------------------------------------------------------
    private void configurarEventos() {
        itemCadastroAlunos.addActionListener(e -> abrirPainel("cadastroAlunos"));
        itemCadastroProfessores.addActionListener(e -> abrirPainel("cadastroProfessor"));
        itemGerenciamentoProfessores.addActionListener(e -> abrirPainel("gerenciamentoProfessor"));
        itemCadastroDisciplinas.addActionListener(e -> abrirPainel("cadastroDisciplina"));
        itemGerenciamentoDisciplinas.addActionListener(e -> abrirPainel("gerenciamentoDisciplina"));
        itemCadastroAnoEscolar.addActionListener(e -> abrirPainel("cadastroAnoEscolar"));
        itemCadastroTurma.addActionListener(e -> abrirPainel("cadastroTurma"));
        itemCadastroSerie.addActionListener(e -> abrirPainel("cadastroSerie"));
        itemGerenciamentoAlunos.addActionListener(e -> abrirPainel("gerenciamentoAluno"));
        itemGerenciamentoAnoEscolar.addActionListener(e -> abrirPainel("gerenciamentoAnoEscolar"));
        itemGerenciamentoSerie.addActionListener(e -> abrirPainel("gerenciamentoSerie"));
        itemGerenciamentoTurma.addActionListener(e -> abrirPainel("gerenciamentoTurma"));
        btnAdministrador.addActionListener(e -> {
            menuBarPrincipal.setVisible(true);
            setJMenuBar(menuBarPrincipal);
            revalidate();
            repaint();
        });
        btnProfessor.addActionListener(e -> {
            menuBarProfessor.setVisible(true);
            setJMenuBar(menuBarProfessor);
            revalidate();
            repaint();
        });
        btnAluno.addActionListener(e -> {
            menuBarAluno.setVisible(true);
            setJMenuBar(menuBarAluno);
            revalidate();
            repaint();
        });
    }

    private void abrirPainel(String nomePainel) {
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, nomePainel);
    }
}