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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class PainelGerenciamentoAluno extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboFiltroBusca;
	private JTextField txtTermoBusca;
	private JButton btnBuscar;
	
	private JTextField txtNomeAluno;
	private JTextField txtRuaAluno;
	private JTextField txtBairroAluno;
	private JTextField txtEmailAluno;
	private JTextField txtNomeResponsavel;
	private JTextField txtEmailResponsavel;
	private JTextField txtCidadeAluno;
	private JFormattedTextField formattedtxtDataNascimentoAluno;
	private JFormattedTextField formattedtxtCpfAluno;
	private JFormattedTextField formattedtxtRgAluno;
	private JFormattedTextField formattedtxtTelefoneAluno;
	private JFormattedTextField formattedtxtTelefoneResponsavel;
	private JTextField txtComplementoAluno;
	private JFormattedTextField formattedtxtNumeroCasaAluno;
	
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvarEdicao;

	public PainelGerenciamentoAluno() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("GERENCIAMENTO DE ALUNOS");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTitulo.setBounds(400, 40, 300, 30);
		add(lblTitulo);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBuscarPor.setBounds(198, 115, 80, 18);
		add(lblBuscarPor);
		
		comboFiltroBusca = new JComboBox<>();
		comboFiltroBusca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboFiltroBusca.setModel(new DefaultComboBoxModel<>(new String[] {"Nome", "CPF", "Série", "Ano Escolar"}));
		comboFiltroBusca.setBounds(288, 115, 120, 18);
		add(comboFiltroBusca);

		txtTermoBusca = new JTextField();
		txtTermoBusca.setBounds(450, 116, 300, 18);
		add(txtTermoBusca);
		txtTermoBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnBuscar.setBounds(795, 114, 90, 21);
		add(btnBuscar);
		
		// --- CAMPOS DE DADOS DO ALUNO ---
		
		JLabel lblNomeAluno = new JLabel("Nome completo:");
		lblNomeAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeAluno.setBounds(143, 179, 100, 18);
		add(lblNomeAluno);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setEditable(false);
		txtNomeAluno.setBounds(253, 180, 199, 18);
		add(txtNomeAluno);
		txtNomeAluno.setColumns(10);
		
		JLabel lblDataNascAluno = new JLabel("Data de Nascimento:");
		lblDataNascAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDataNascAluno.setBounds(486, 182, 124, 12);
		add(lblDataNascAluno);
		
		try {
			formattedtxtDataNascimentoAluno = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtDataNascimentoAluno.setEditable(false);
		formattedtxtDataNascimentoAluno.setBounds(620, 180, 34, 18);
		add(formattedtxtDataNascimentoAluno);
		
		JLabel lblCpfAluno = new JLabel("CPF:");
		lblCpfAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCpfAluno.setBounds(686, 182, 25, 12);
		add(lblCpfAluno);
		
		try {
			formattedtxtCpfAluno = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtCpfAluno.setEditable(false);
		formattedtxtCpfAluno.setBounds(715, 180, 96, 18);
		add(formattedtxtCpfAluno);
		
		JLabel lblRgAluno = new JLabel("RG:");
		lblRgAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRgAluno.setBounds(839, 182, 25, 12);
		add(lblRgAluno);
		
		try {
			formattedtxtRgAluno = new JFormattedTextField(new MaskFormatter("##.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtRgAluno.setEditable(false);
		formattedtxtRgAluno.setBounds(863, 180, 100, 18);
		add(formattedtxtRgAluno);
		
		JLabel lblRuaAluno = new JLabel("Rua:");
		lblRuaAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRuaAluno.setBounds(143, 250, 34, 12);
		add(lblRuaAluno);
		
		txtRuaAluno = new JTextField();
		txtRuaAluno.setEditable(false);
		txtRuaAluno.setBounds(171, 248, 124, 18);
		add(txtRuaAluno);
		txtRuaAluno.setColumns(10);
		
		JLabel lblBairroAluno = new JLabel("Bairro:");
		lblBairroAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBairroAluno.setBounds(305, 250, 44, 12);
		add(lblBairroAluno);
		
		txtBairroAluno = new JTextField();
		txtBairroAluno.setEditable(false);
		txtBairroAluno.setBounds(344, 248, 96, 18);
		add(txtBairroAluno);
		txtBairroAluno.setColumns(10);
		
		JLabel lblNumeroCasaAluno = new JLabel("Número:");
		lblNumeroCasaAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNumeroCasaAluno.setBounds(450, 250, 62, 12);
		add(lblNumeroCasaAluno);
		
		try {
			formattedtxtNumeroCasaAluno = new JFormattedTextField(new MaskFormatter("###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtNumeroCasaAluno.setEditable(false);
		formattedtxtNumeroCasaAluno.setBounds(508, 248, 24, 18); 
		add(formattedtxtNumeroCasaAluno);
		
		JLabel lblCidadeAluno = new JLabel("Cidade:");
		lblCidadeAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCidadeAluno.setBounds(541, 250, 58, 12);
		add(lblCidadeAluno);
		
		txtCidadeAluno = new JTextField();
		txtCidadeAluno.setEditable(false);
		txtCidadeAluno.setBounds(597, 248, 96, 18);
		add(txtCidadeAluno);
		txtCidadeAluno.setColumns(10);
		
		JLabel lblComplementoAluno = new JLabel("Complemento:");
		lblComplementoAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblComplementoAluno.setBounds(711, 247, 100, 18);
		add(lblComplementoAluno);
		
		txtComplementoAluno = new JTextField();
		txtComplementoAluno.setEditable(false);
		txtComplementoAluno.setBounds(806, 248, 153, 18);
		add(txtComplementoAluno);
		txtComplementoAluno.setColumns(10);
		
		JLabel lblTelefoneAluno = new JLabel("Telefone:");
		lblTelefoneAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTelefoneAluno.setBounds(347, 314, 58, 12);
		add(lblTelefoneAluno);

		try {
			formattedtxtTelefoneAluno = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtTelefoneAluno.setEditable(false);
		formattedtxtTelefoneAluno.setBounds(412, 312, 100, 18);
		add(formattedtxtTelefoneAluno);
		
		JLabel lblEmailAluno = new JLabel("E-mail:");
		lblEmailAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailAluno.setBounds(593, 314, 44, 12);
		add(lblEmailAluno);
		
		txtEmailAluno = new JTextField();
		txtEmailAluno.setEditable(false);
		txtEmailAluno.setBounds(638, 312, 153, 18);
		add(txtEmailAluno);
		txtEmailAluno.setColumns(10);
		
		// --- CAMPOS DE DADOS DO RESPONSÁVEL ---
		
		JLabel lblNomeResponsavel = new JLabel("Nome do responsável:");
		lblNomeResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeResponsavel.setBounds(75, 377, 133, 16);
		add(lblNomeResponsavel);
		
		txtNomeResponsavel = new JTextField();
		txtNomeResponsavel.setEditable(false);
		txtNomeResponsavel.setBounds(217, 377, 199, 18);
		add(txtNomeResponsavel);
		txtNomeResponsavel.setColumns(10);
		
		JLabel lblEmailResponsavel = new JLabel("E-mail do responsável:");
		lblEmailResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailResponsavel.setBounds(698, 376, 133, 18);
		add(lblEmailResponsavel);
		
		txtEmailResponsavel = new JTextField();
		txtEmailResponsavel.setEditable(false);
		txtEmailResponsavel.setBounds(839, 377, 204, 18);
		add(txtEmailResponsavel);
		txtEmailResponsavel.setColumns(10);

		JLabel lblTelefoneResponsavel = new JLabel("Telefone do responsável:");
		lblTelefoneResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTelefoneResponsavel.setBounds(426, 376, 160, 18);
		add(lblTelefoneResponsavel);
		
		try {
			formattedtxtTelefoneResponsavel = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtTelefoneResponsavel.setEditable(false);
		formattedtxtTelefoneResponsavel.setBounds(581, 377, 100, 18);
		add(formattedtxtTelefoneResponsavel);

		// --- BOTÕES DE AÇÃO ---
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnEditar.setBounds(320, 461, 120, 25);
		add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnExcluir.setBounds(498, 461, 120, 25);
		add(btnExcluir);
		
		btnSalvarEdicao = new JButton("Salvar Alterações");
		btnSalvarEdicao.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSalvarEdicao.setBounds(668, 461, 150, 25);
		add(btnSalvarEdicao);
	}

	public JComboBox<String> getComboFiltroBusca() {
		return comboFiltroBusca;
	}

	public JTextField getTxtTermoBusca() {
		return txtTermoBusca;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getTxtNomeAluno() {
		return txtNomeAluno;
	}

	public JTextField getTxtRuaAluno() {
		return txtRuaAluno;
	}

	public JTextField getTxtBairroAluno() {
		return txtBairroAluno;
	}

	public JTextField getTxtEmailAluno() {
		return txtEmailAluno;
	}

	public JTextField getTxtNomeResponsavel() {
		return txtNomeResponsavel;
	}

	public JTextField getTxtEmailResponsavel() {
		return txtEmailResponsavel;
	}

	public JTextField getTxtCidadeAluno() {
		return txtCidadeAluno;
	}

	public JFormattedTextField getFormattedtxtDataNascimentoAluno() {
		return formattedtxtDataNascimentoAluno;
	}

	public JFormattedTextField getFormattedtxtCpfAluno() {
		return formattedtxtCpfAluno;
	}

	public JFormattedTextField getFormattedtxtRgAluno() {
		return formattedtxtRgAluno;
	}

	public JFormattedTextField getFormattedtxtTelefoneAluno() {
		return formattedtxtTelefoneAluno;
	}

	public JFormattedTextField getFormattedtxtTelefoneResponsavel() {
		return formattedtxtTelefoneResponsavel;
	}

	public JTextField getTxtComplementoAluno() {
		return txtComplementoAluno;
	}

	public JFormattedTextField getFormattedtxtNumeroCasaAluno() {
		return formattedtxtNumeroCasaAluno;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnSalvarEdicao() {
		return btnSalvarEdicao;
	}
}