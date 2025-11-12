package visao;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JanelaSistema extends JFrame {

    // Painéis principais
    private JPanel painelPrincipal;
    private JPanel painelInicio;
    private JPanel painelCadastroAlunos;
    private JPanel painelCadastroProfessor;
    private JPanel painelGerenciamentoProfessor;

    // Menus principais
    private JMenuBar menuBarPrincipal;
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

    // Itens de menu - Financeiro
    private JMenuItem itemFinanceiroMensalidades;
    private JMenuItem itemFinanceiroGestao;

    // Itens de menu - Gerenciamento
    private JMenuItem itemGerenciamentoAlunos;
    private JMenuItem itemGerenciamentoProfessores;
    private JMenuItem itemGerenciamentoDisciplinas;

    // Itens de menu - Matrículas e Turmas
    private JMenuItem itemMatriculaAlunoSerie;

    // Itens de menu - Buscar
    private JMenuItem itemBuscarAlunos;
    private JMenuItem itemBuscarProfessores;
    private JMenuItem itemBuscarDisciplinas;

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
        inicializarMenu();
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

        painelInicio = new JPanel();
        painelInicio.add(new JLabel("Bem-vindo ao Sistema", SwingConstants.CENTER));

        painelCadastroAlunos = new PainelCadastroAlunos();
        painelCadastroProfessor = new PainelCadastroProfessor();
        painelGerenciamentoProfessor = new PainelGerenciamentoProfessor();

        painelPrincipal.add(painelInicio, "inicio");
        painelPrincipal.add(painelCadastroAlunos, "cadastroAlunos");
        painelPrincipal.add(painelCadastroProfessor, "cadastroProfessor");
        painelPrincipal.add(painelGerenciamentoProfessor, "gerenciamentoProfessor");

        getContentPane().add(painelPrincipal);
    }

    // ------------------------------------------------------
    // MENU
    // ------------------------------------------------------
    private void inicializarMenu() {
        // Barra de menu
        menuBarPrincipal = new JMenuBar();
        menuBarPrincipal.setBackground(new Color(255, 247, 221));
        setJMenuBar(menuBarPrincipal);

        // ------------------- MENU CADASTROS -------------------
        menuCadastros = criarMenu("Cadastros");
        itemCadastroAlunos = criarItemMenu("Alunos");
        itemCadastroProfessores = criarItemMenu("Professores");
        itemCadastroDisciplinas = criarItemMenu("Disciplinas");
        menuCadastros.add(itemCadastroAlunos);
        menuCadastros.add(itemCadastroProfessores);
        menuCadastros.add(itemCadastroDisciplinas);
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
        menuGerenciamento.add(itemGerenciamentoAlunos);
        menuGerenciamento.add(itemGerenciamentoProfessores);
        menuGerenciamento.add(itemGerenciamentoDisciplinas);
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
    }

    private void abrirPainel(String nomePainel) {
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, nomePainel);
    }
}
