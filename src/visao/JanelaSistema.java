package visao;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane; // Importado (embora não usado na lógica de login)
import javax.swing.SwingConstants;

public class JanelaSistema extends JFrame {

    // Painéis principais
    private JPanel painelPrincipal;
    private PainelLogin painelLogin;
    private PainelPrincipal painelInicio; 
    private JPanel painelCadastroAlunos;
    private JPanel painelCadastroProfessor;
    private PainelGerenciamentoAluno painelGerenciamentoAlunos;
    private PainelGerenciamentoProfessor painelGerenciamentoProfessor;
    private PainelGerenciamentoDisciplina painelGerenciamentoDisciplinas;
    private PainelCadastroDisciplina painelCadastroDisciplinas; 
    private PainelBoletim painelBoletim; 


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
    // (Vazio conforme solicitado)
    
    // Item de menu - Boletim
    private JMenuItem itemBoletimVisualizar; 

    // Itens de menu - Buscar
    private JMenuItem itemBuscarAlunos;
    private JMenuItem itemBuscarProfessores;
    private JMenuItem itemBuscarDisciplinas;

    
    // MÉTODO PRINCIPAL

    public static void main(String[] args) {
        JanelaSistema janela = new JanelaSistema();
        janela.setVisible(true);
    }

   
    // CONSTRUTOR
    public JanelaSistema() {
        configurarJanela();
        inicializarPaineis();
        inicializarMenu();
        configurarEventos();
        
        setJMenuBar(null); 
        abrirPainel("login");
    }

    
    private void configurarJanela() {
        setTitle("Sistema de Gerenciamento Escolar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicializarPaineis() {
        painelPrincipal = new JPanel(new CardLayout());
        painelPrincipal.setBackground(new Color(145, 196, 195)); 

        painelLogin = new PainelLogin(); 
        painelInicio = new PainelPrincipal(); 

        painelCadastroAlunos = new PainelCadastroAlunos();
        painelCadastroProfessor = new PainelCadastroProfessor();
        painelGerenciamentoAlunos = new PainelGerenciamentoAluno();
        painelGerenciamentoProfessor = new PainelGerenciamentoProfessor();
        painelGerenciamentoDisciplinas = new PainelGerenciamentoDisciplina(); 
        painelCadastroDisciplinas = new PainelCadastroDisciplina(); 
        painelBoletim = new PainelBoletim(); 


        painelPrincipal.add(painelLogin, "login"); 
        painelPrincipal.add(painelInicio, "inicio");
        painelPrincipal.add(painelCadastroAlunos, "cadastroAlunos");
        painelPrincipal.add(painelCadastroProfessor, "cadastroProfessor");
        painelPrincipal.add(painelGerenciamentoAlunos, "gerenciamentoAlunos");
        painelPrincipal.add(painelGerenciamentoProfessor, "gerenciamentoProfessor");
        painelPrincipal.add(painelGerenciamentoDisciplinas, "gerenciamentoDisciplina");
        painelPrincipal.add(painelCadastroDisciplinas, "cadastroDisciplina"); 
        painelPrincipal.add(painelBoletim, "boletim"); 

        getContentPane().add(painelPrincipal);
    }

    // MENU
    
    private void inicializarMenu() {
       
        menuBarPrincipal = new JMenuBar();
        menuBarPrincipal.setBackground(new Color(255, 247, 221));

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
        menuMatriculasTurmas = criarMenu("Matrículas");
        menuBarPrincipal.add(menuMatriculasTurmas);

        // ------------------- MENU BOLETIM -------------------
        menuBoletim = criarMenu("Boletim");
        itemBoletimVisualizar = criarItemMenu("Visualizar Boletim"); 
        menuBoletim.add(itemBoletimVisualizar); 
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


    // MÉTODOS DE AJUDA
    
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
    
    // EVENTOS
    
    private void configurarEventos() {
        
        // --- EVENTOS DOS BOTÕES DE LOGIN (LÓGICA DE VALIDAÇÃO) ---
        
        // 1. Botão Administrador
        painelLogin.getBtnAdministrador().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                configurarMenusParaAdmin();
                setJMenuBar(menuBarPrincipal);
                abrirPainel("inicio");
            }
        });
        
        // 2. Botão Professor
        painelLogin.getBtnProfessor().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                configurarMenusParaProfessor();
                setJMenuBar(menuBarPrincipal);
                abrirPainel("inicio");
            }
        });

        // 3. Botão Aluno
        painelLogin.getBtnAluno().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                configurarMenusParaAluno();
                setJMenuBar(menuBarPrincipal);
                abrirPainel("boletim"); // Aluno vai direto para o boletim
            }
        });
        
        
        // --- EVENTOS DOS MENUS (após login) ---
        itemCadastroAlunos.addActionListener(e -> abrirPainel("cadastroAlunos"));
        itemCadastroProfessores.addActionListener(e -> abrirPainel("cadastroProfessor"));
        itemCadastroDisciplinas.addActionListener(e -> abrirPainel("cadastroDisciplina")); 
        
        itemGerenciamentoAlunos.addActionListener(e -> abrirPainel("gerenciamentoAlunos"));
        itemGerenciamentoProfessores.addActionListener(e -> abrirPainel("gerenciamentoProfessor"));
        itemGerenciamentoDisciplinas.addActionListener(e -> abrirPainel("gerenciamentoDisciplina"));
        
        itemBoletimVisualizar.addActionListener(e -> abrirPainel("boletim"));
    }

    private void abrirPainel(String nomePainel) {
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, nomePainel);
    }
    
    // --- MÉTODOS DE CONTROLE DE ACESSO ADICIONADOS ---
    
    /**
     * Administrador: Vê tudo.
     */
    private void configurarMenusParaAdmin() {
        menuCadastros.setVisible(true);
        menuFinanceiro.setVisible(true);
        menuGerenciamento.setVisible(true);
        menuMatriculasTurmas.setVisible(true);
        menuBoletim.setVisible(true);
        menuBuscar.setVisible(true);
    }
    
    private void configurarMenusParaProfessor() {
        menuFinanceiro.setVisible(false);
        menuMatriculasTurmas.setVisible(false);
        menuBoletim.setVisible(false); 
        
        menuCadastros.setVisible(true);
        menuGerenciamento.setVisible(true);
        menuBuscar.setVisible(true);
        
        itemCadastroAlunos.setVisible(false);
        itemCadastroProfessores.setVisible(false);
        itemCadastroDisciplinas.setVisible(true); 
        
        itemGerenciamentoAlunos.setVisible(false);
        itemGerenciamentoProfessores.setVisible(true);
        itemGerenciamentoDisciplinas.setVisible(true); 
    }
   
    private void configurarMenusParaAluno() {
        menuCadastros.setVisible(false);
        menuFinanceiro.setVisible(false);
        menuGerenciamento.setVisible(false);
        menuMatriculasTurmas.setVisible(false);
        menuBuscar.setVisible(false);
      
        menuBoletim.setVisible(true);
    }
}