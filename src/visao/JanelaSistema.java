package visao;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener; // IMPORT ADICIONADO
import java.awt.event.ActionEvent; // IMPORT ADICIONADO
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
    private PainelLogin painelLogin; // ADICIONADO
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
    private JMenuItem itemMatriculaAlunoSerie;
    
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
        
        // --- MODIFICAÇÕES AQUI ---
        // 1. Esconde a barra de menu
        setJMenuBar(null); 
        
        // 2. Define o login como o painel inicial
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

        painelLogin = new PainelLogin(); // ADICIONADO
        painelInicio = new PainelPrincipal(); 

        painelCadastroAlunos = new PainelCadastroAlunos();
        painelCadastroProfessor = new PainelCadastroProfessor();
        painelGerenciamentoAlunos = new PainelGerenciamentoAluno();
        painelGerenciamentoProfessor = new PainelGerenciamentoProfessor();
        painelGerenciamentoDisciplinas = new PainelGerenciamentoDisciplina(); 
        painelCadastroDisciplinas = new PainelCadastroDisciplina(); 
        painelBoletim = new PainelBoletim(); 


        painelPrincipal.add(painelLogin, "login"); // ADICIONADO
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
        // Barra de menu
        menuBarPrincipal = new JMenuBar();
        menuBarPrincipal.setBackground(new Color(255, 247, 221));
        // setJMenuBar(menuBarPrincipal); // REMOVIDO DAQUI (só aparece após login)

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
        // Você removeu os itens, pode adicionar se precisar
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
        
        // --- EVENTOS DOS BOTÕES DE LOGIN ---
        ActionListener listenerLogin = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // (Aqui entraria a validação de tipo de usuário)
                realizarLogin();
            }
        };
        painelLogin.getBtnAdministrador().addActionListener(listenerLogin);
        painelLogin.getBtnProfessor().addActionListener(listenerLogin);
        painelLogin.getBtnAluno().addActionListener(listenerLogin);
        
        
        // --- EVENTOS DOS MENUS ---
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
    
  // MÉTODO PARA LIDAR COM O LOGIN
    private void realizarLogin() {
        setJMenuBar(menuBarPrincipal);
        abrirPainel("inicio");
    }
}