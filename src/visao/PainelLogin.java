package visao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelLogin extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnAdministrador;
	private JButton btnProfessor;
	private JButton btnAluno;

	public PainelLogin() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblSistemaGerenciamentoEscolar = new JLabel("Sistema de Gerenciamento Escolar");
		lblSistemaGerenciamentoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblSistemaGerenciamentoEscolar.setBounds(385, 149, 310, 21);
		add(lblSistemaGerenciamentoEscolar);
		
		btnAdministrador = new JButton("Administrador"); 
		btnAdministrador.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnAdministrador.setBounds(454, 268, 132, 20);
		add(btnAdministrador);
		
		btnProfessor = new JButton("Professor");
		btnProfessor.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnProfessor.setBounds(454, 331, 132, 20);
		add(btnProfessor);
		
		JLabel lblSelecione = new JLabel("Selecione:");
		lblSelecione.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSelecione.setBounds(479, 213, 89, 12);
		add(lblSelecione);
		
		btnAluno = new JButton("Aluno"); 
		btnAluno.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnAluno.setBounds(454, 403, 132, 20);
		add(btnAluno);
	}

	
	public JButton getBtnAdministrador() {
		return btnAdministrador;
	}

	public JButton getBtnProfessor() {
		return btnProfessor;
	}

	public JButton getBtnAluno() {
		return btnAluno;
	}
}