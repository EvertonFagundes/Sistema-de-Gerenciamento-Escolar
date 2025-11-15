package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter; 
import java.text.ParseException;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.JOptionPane; 
import modelo.Professor; // IMPORT ADICIONADO (verifique o nome do pacote do Everton)

public class PainelCadastroProfessor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNomeProfessor;
	private JTextField txtRuaProfessor;
	private JTextField txtBairroProfessor;
	private JTextField txtEmailProfessor;
	private JTextField txtCidadeProfessor;
	private JFormattedTextField formattedtxtDataNascimentoProfessor;
	private JFormattedTextField formattedtxtCpfProfessor;
	private JFormattedTextField formattedtxtRgProfessor;
	private JFormattedTextField formattedtxtCepProfessor; 
	private JFormattedTextField formattedtxtTelefoneProfessor;
	private JTextField txtComplementoProfessor;
	private JFormattedTextField formattedtxtNumeroCasaProfessor;
	private JTextField txtFormacaoAcademica;
	private JButton btnCadastrarProfessor;

	public PainelCadastroProfessor() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblCadastroProfessores = new JLabel("CADASTRO DE PROFESSORES");
		lblCadastroProfessores.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblCadastroProfessores.setBounds(450, 93, 250, 30);
		add(lblCadastroProfessores);
		
		JLabel lblNomeProfessor = new JLabel("Nome completo:");
		lblNomeProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeProfessor.setBounds(99, 179, 100, 18);
		add(lblNomeProfessor);
		
		txtNomeProfessor = new JTextField();
		txtNomeProfessor.setBounds(209, 182, 199, 18);
		add(txtNomeProfessor);
		txtNomeProfessor.setColumns(10);
		
		JLabel lblDataNascProfessor = new JLabel("Data de Nascimento:");
		lblDataNascProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDataNascProfessor.setBounds(415, 182, 124, 12);
		add(lblDataNascProfessor);
		
		try {
			formattedtxtDataNascimentoProfessor = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtDataNascimentoProfessor.setBounds(549, 180, 69, 18);
		add(formattedtxtDataNascimentoProfessor);
		
		JLabel lblCpfProfessor = new JLabel("CPF:");
		lblCpfProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCpfProfessor.setBounds(638, 182, 25, 12);
		add(lblCpfProfessor);
		
		try {
			formattedtxtCpfProfessor = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtCpfProfessor.setBounds(673, 180, 96, 18);
		add(formattedtxtCpfProfessor);
		
		JLabel lblRgProfessor = new JLabel("RG:");
		lblRgProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRgProfessor.setBounds(806, 182, 25, 12);
		add(lblRgProfessor);
		
		try {
			formattedtxtRgProfessor = new JFormattedTextField(new MaskFormatter("##.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtRgProfessor.setBounds(831, 180, 100, 18);
		add(formattedtxtRgProfessor);
		
		JLabel lblRuaProfessor = new JLabel("Rua:");
		lblRuaProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRuaProfessor.setBounds(143, 250, 34, 12);
		add(lblRuaProfessor);
		
		txtRuaProfessor = new JTextField();
		txtRuaProfessor.setBounds(171, 248, 124, 18);
		add(txtRuaProfessor);
		txtRuaProfessor.setColumns(10);
		
		JLabel lblBairroProfessor = new JLabel("Bairro:");
		lblBairroProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBairroProfessor.setBounds(305, 250, 44, 12);
		add(lblBairroProfessor);
		
		txtBairroProfessor = new JTextField();
		txtBairroProfessor.setBounds(344, 248, 96, 18);
		add(txtBairroProfessor);
		txtBairroProfessor.setColumns(10);
		
		JLabel lblNumeroCasaProfessor = new JLabel("Número:");
		lblNumeroCasaProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNumeroCasaProfessor.setBounds(450, 250, 62, 12);
		add(lblNumeroCasaProfessor);
		
		try {
			formattedtxtNumeroCasaProfessor = new JFormattedTextField(new MaskFormatter("###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtNumeroCasaProfessor.setBounds(508, 248, 24, 18);
		add(formattedtxtNumeroCasaProfessor);
		
		JLabel lblCidadeProfessor = new JLabel("Cidade:");
		lblCidadeProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCidadeProfessor.setBounds(541, 250, 58, 12);
		add(lblCidadeProfessor);
		
		txtCidadeProfessor = new JTextField();
		txtCidadeProfessor.setBounds(597, 248, 96, 18);
		add(txtCidadeProfessor);
		txtCidadeProfessor.setColumns(10);
		
		JLabel lblComplementoProfessor = new JLabel("Complemento:");
		lblComplementoProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblComplementoProfessor.setBounds(711, 247, 100, 18);
		add(lblComplementoProfessor);
		
		txtComplementoProfessor = new JTextField();
		txtComplementoProfessor.setBounds(806, 248, 153, 18);
		add(txtComplementoProfessor);
		txtComplementoProfessor.setColumns(10);
		
		JLabel lblTelefoneProfessor = new JLabel("Telefone:");
		lblTelefoneProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTelefoneProfessor.setBounds(120, 314, 58, 12); 
		add(lblTelefoneProfessor);

		try {
			formattedtxtTelefoneProfessor = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtTelefoneProfessor.setBounds(185, 312, 100, 18); 
		add(formattedtxtTelefoneProfessor);
		
		JLabel lblEmailProfessor = new JLabel("E-mail:");
		lblEmailProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailProfessor.setBounds(305, 314, 44, 12); 
		add(lblEmailProfessor);
		
		txtEmailProfessor = new JTextField();
		txtEmailProfessor.setBounds(350, 312, 153, 18);
		add(txtEmailProfessor);
		txtEmailProfessor.setColumns(10);
		
		JLabel lblFormacao = new JLabel("Formação Acadêmica:");
		lblFormacao.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblFormacao.setBounds(520, 314, 140, 12);
		add(lblFormacao);
		
		txtFormacaoAcademica = new JTextField();
		txtFormacaoAcademica.setBounds(665, 312, 250, 18); 
		add(txtFormacaoAcademica);
		txtFormacaoAcademica.setColumns(10);
		
		btnCadastrarProfessor = new JButton("Salvar");
		btnCadastrarProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnCadastrarProfessor.setBounds(508, 427, 96, 25);
		
		// --- ACTION LISTENER ATUALIZADO ---
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nome = txtNomeProfessor.getText();
				String dataNasc = formattedtxtDataNascimentoProfessor.getText();
				String cpf = formattedtxtCpfProfessor.getText();
				String rg = formattedtxtRgProfessor.getText();
				String rua = txtRuaProfessor.getText();
				String bairro = txtBairroProfessor.getText();
				String numero = formattedtxtNumeroCasaProfessor.getText();
				String cidade = txtCidadeProfessor.getText();
				String complemento = txtComplementoProfessor.getText();
				String telefone = formattedtxtTelefoneProfessor.getText();
				String email = txtEmailProfessor.getText();
				String formacao = txtFormacaoAcademica.getText();
				
				// 2. Cria o objeto do Modelo (USANDO O CONSTRUTOR, COMO PEDIDO)
				// (Atenção: A classe Professor do Everton precisa ter um construtor
				// que aceite todos estes 12 campos, EXATAMENTE NESTA ORDEM)
				Professor professor = new Professor(nome, dataNasc, cpf, rg, rua, bairro, 
													numero, cidade, complemento, telefone, 
													email, formacao);
				
				// 3. (FUTURO) Chama o DAO do Everton para salvar
				// ProfessorDAO dao = new ProfessorDAO();
				// dao.salvar(professor);
				
				JOptionPane.showMessageDialog(null, "Professor " + nome + " cadastrado!");
				
				// 5. Limpa os campos
				txtNomeProfessor.setText("");
				formattedtxtDataNascimentoProfessor.setText("");
				formattedtxtCpfProfessor.setText("");
				formattedtxtRgProfessor.setText("");
				txtRuaProfessor.setText("");
				txtBairroProfessor.setText("");
				formattedtxtNumeroCasaProfessor.setText("");
				txtCidadeProfessor.setText("");
				txtComplementoProfessor.setText("");
				formattedtxtTelefoneProfessor.setText("");
				txtEmailProfessor.setText("");
				txtFormacaoAcademica.setText("");
			}
		});
		
		add(btnCadastrarProfessor);
	}

	public JTextField getTxtNomeProfessor() {
		return txtNomeProfessor;
	}

	public JTextField getTxtRuaProfessor() {
		return txtRuaProfessor;
	}

	public JTextField getTxtBairroProfessor() {
		return txtBairroProfessor;
	}

	public JTextField getTxtEmailProfessor() {
		return txtEmailProfessor;
	}

	public JTextField getTxtCidadeProfessor() {
		return txtCidadeProfessor;
	}

	public JFormattedTextField getFormattedtxtDataNascimentoProfessor() {
		return formattedtxtDataNascimentoProfessor;
	}

	public JFormattedTextField getFormattedtxtCpfProfessor() {
		return formattedtxtCpfProfessor;
	}

	public JFormattedTextField getFormattedtxtRgProfessor() {
		return formattedtxtRgProfessor;
	}

	public JFormattedTextField getFormattedtxtCepProfessor() {
		return formattedtxtCepProfessor;
	}

	public JFormattedTextField getFormattedtxtTelefoneProfessor() {
		return formattedtxtTelefoneProfessor;
	}

	public JTextField getTxtComplementoProfessor() {
		return txtComplementoProfessor;
	}

	public JFormattedTextField getFormattedtxtNumeroCasaProfessor() {
		return formattedtxtNumeroCasaProfessor;
	}

	public JTextField getTxtFormacaoAcademica() {
		return txtFormacaoAcademica;
	}

	public JButton getBtnCadastrarProfessor() {
		return btnCadastrarProfessor;
	}
}