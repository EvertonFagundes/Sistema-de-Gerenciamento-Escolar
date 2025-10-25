package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaSistema extends JFrame {

    public static void main(String[] args) {
        JanelaSistema janela = new JanelaSistema();
        janela.setVisible(true);
    }

    public JanelaSistema() {
        // --- CONFIGURAÇÕES DA JANELA ---
        setTitle("Sistema Principal - Testando Cadastro de Disciplina"); // Título atualizado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // --- CÓDIGO COMPLETO DO SEU MENU ---
        JMenuBar menuBarTelaPrincipal = new JMenuBar();
        menuBarTelaPrincipal.setBackground(new Color(255, 247, 221));
        setJMenuBar(menuBarTelaPrincipal);
        
        JMenu menuCadastros = new JMenu("Cadastros");
        menuCadastros.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuBarTelaPrincipal.add(menuCadastros);
        
        JMenuItem menuItemAlunos = new JMenuItem("Alunos");
        menuItemAlunos.setBackground(new Color(255, 247, 221));
        menuItemAlunos.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuCadastros.add(menuItemAlunos);
        
        JMenuItem menuItemProfessores = new JMenuItem("Professores");
        menuItemProfessores.setBackground(new Color(255, 247, 221));
        menuItemProfessores.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuCadastros.add(menuItemProfessores);
        
        JMenuItem menuItemDisciplinas = new JMenuItem("Disciplinas");
        menuItemDisciplinas.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuItemDisciplinas.setBackground(new Color(255, 247, 221));
        menuCadastros.add(menuItemDisciplinas);
        
        JMenu menuFinanceiro = new JMenu("Financeiro");
        menuFinanceiro.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuBarTelaPrincipal.add(menuFinanceiro);
        
        JMenuItem menuItemMensalidades = new JMenuItem("Mensalidades");
        menuItemMensalidades.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuItemMensalidades.setBackground(new Color(255, 247, 221));
        menuFinanceiro.add(menuItemMensalidades);
        
        JMenuItem menuItemGestaoFinanceira = new JMenuItem("Gestão Financeira");
        menuItemGestaoFinanceira.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuItemGestaoFinanceira.setBackground(new Color(255, 247, 221));
        menuFinanceiro.add(menuItemGestaoFinanceira);
        
        JMenu mnNewMenu = new JMenu("Gerenciamento");
        mnNewMenu.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuBarTelaPrincipal.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Alunos");
        mntmNewMenuItem.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Professores");
        mntmNewMenuItem_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Disciplinas");
        mntmNewMenuItem_2.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu.add(mntmNewMenuItem_2);
        
        JMenu mnNewMenu_1 = new JMenu("Matrículas e Turmas");
        mnNewMenu_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuBarTelaPrincipal.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Matricula de aluno em ano escolar e série");
        mntmNewMenuItem_3.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu_1.add(mntmNewMenuItem_3);
        
        JMenu mnNewMenu_2 = new JMenu("Boletim");
        mnNewMenu_2.setBackground(new Color(255, 247, 221));
        mnNewMenu_2.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuBarTelaPrincipal.add(mnNewMenu_2);
        
        JMenu mnNewMenu_3 = new JMenu("Buscar");
        mnNewMenu_3.setBackground(new Color(255, 247, 221));
        mnNewMenu_3.setFont(new Font("Century Gothic", Font.BOLD, 12));
        menuBarTelaPrincipal.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Alunos");
        mntmNewMenuItem_4.setBackground(new Color(255, 247, 221));
        mntmNewMenuItem_4.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu_3.add(mntmNewMenuItem_4);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Professores");
        mntmNewMenuItem_5.setBackground(new Color(255, 247, 221));
        mntmNewMenuItem_5.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu_3.add(mntmNewMenuItem_5);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Disciplinas");
        mntmNewMenuItem_6.setBackground(new Color(255, 247, 221));
        mntmNewMenuItem_6.setFont(new Font("Century Gothic", Font.BOLD, 12));
        mnNewMenu_3.add(mntmNewMenuItem_6);
        
        
        // --- ADIÇÃO DO PAINEL PARA TESTE ---
        // A linha abaixo carrega a tela de cadastro de disciplina
        PainelCadastroDisciplina painel = new PainelCadastroDisciplina();
        getContentPane().add(painel);
    }
}