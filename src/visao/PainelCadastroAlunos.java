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

public class PainelCadastroAlunos extends JPanel {

	private static final long serialVersionUID = 1L;
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

	public PainelCadastroAlunos() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblCadastroAlunos = new JLabel("CADASTRO DE ALUNOS");
		lblCadastroAlunos.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblCadastroAlunos.setBounds(462, 92, 173, 30);
		add(lblCadastroAlunos);
		
		JLabel lblNomeAluno = new JLabel("Nome completo:");
		lblNomeAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeAluno.setBounds(99, 179, 100, 18);
		add(lblNomeAluno);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setBounds(209, 182, 199, 18);
		add(txtNomeAluno);
		txtNomeAluno.setColumns(10);
		
		JLabel lblDataNascAluno = new JLabel("Data de Nascimento:");
		lblDataNascAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDataNascAluno.setBounds(415, 182, 124, 12);
		add(lblDataNascAluno);
		
		try {
			formattedtxtDataNascimentoAluno = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtDataNascimentoAluno.setBounds(549, 180, 69, 18);
		add(formattedtxtDataNascimentoAluno);
		
		JLabel lblCpfAluno = new JLabel("CPF:");
		lblCpfAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCpfAluno.setBounds(638, 182, 25, 12);
		add(lblCpfAluno);
		
		try {
			formattedtxtCpfAluno = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtCpfAluno.setBounds(673, 180, 96, 18);
		add(formattedtxtCpfAluno);
		
		JLabel lblRgAluno = new JLabel("RG:");
		lblRgAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRgAluno.setBounds(806, 182, 25, 12);
		add(lblRgAluno);
		
		try {
			formattedtxtRgAluno = new JFormattedTextField(new MaskFormatter("##.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtRgAluno.setBounds(831, 180, 100, 18);
		add(formattedtxtRgAluno);
		
		JLabel lblRuaAluno = new JLabel("Rua:");
		lblRuaAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRuaAluno.setBounds(143, 250, 34, 12);
		add(lblRuaAluno);
		
		txtRuaAluno = new JTextField();
		txtRuaAluno.setBounds(171, 248, 124, 18);
		add(txtRuaAluno);
		txtRuaAluno.setColumns(10);
		
		JLabel lblBairroAluno = new JLabel("Bairro:");
		lblBairroAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBairroAluno.setBounds(305, 250, 44, 12);
		add(lblBairroAluno);
		
		txtBairroAluno = new JTextField();
		txtBairroAluno.setBounds(344, 248, 96, 18);
		add(txtBairroAluno);
		txtBairroAluno.setColumns(10);
		
		JLabel lblNumeroCasaAluno = new JLabel("Número:");
		lblNumeroCasaAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNumeroCasaAluno.setBounds(450, 250, 62, 12);
		add(lblNumeroCasaAluno);
		
		// --- CÓDIGO ALTERADO AQUI ---
		try {
			// Cria a máscara para aceitar até 3 números
			formattedtxtNumeroCasaAluno = new JFormattedTextField(new MaskFormatter("###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtNumeroCasaAluno.setBounds(508, 248, 24, 18); // Aumentei um pouco a largura
		add(formattedtxtNumeroCasaAluno);
		
		JLabel lblCidadeAluno = new JLabel("Cidade:");
		lblCidadeAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCidadeAluno.setBounds(541, 250, 58, 12);
		add(lblCidadeAluno);
		
		txtCidadeAluno = new JTextField();
		txtCidadeAluno.setBounds(597, 248, 96, 18);
		add(txtCidadeAluno);
		txtCidadeAluno.setColumns(10);
		
		
		JLabel lblComplementoAluno = new JLabel("Complemento:");
		lblComplementoAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblComplementoAluno.setBounds(711, 247, 100, 18);
		add(lblComplementoAluno);
		
		txtComplementoAluno = new JTextField();
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
		formattedtxtTelefoneAluno.setBounds(412, 312, 100, 18);
		add(formattedtxtTelefoneAluno);
		
		JLabel lblEmailAluno = new JLabel("E-mail:");
		lblEmailAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailAluno.setBounds(593, 314, 44, 12);
		add(lblEmailAluno);
		
		txtEmailAluno = new JTextField();
		txtEmailAluno.setBounds(638, 312, 153, 18);
		add(txtEmailAluno);
		txtEmailAluno.setColumns(10);
		
		JLabel lblNomeResponsavel = new JLabel("Nome do responsável:");
		lblNomeResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeResponsavel.setBounds(57, 377, 133, 16);
		add(lblNomeResponsavel);
		
		txtNomeResponsavel = new JTextField();
		txtNomeResponsavel.setBounds(193, 377, 199, 18);
		add(txtNomeResponsavel);
		txtNomeResponsavel.setColumns(10);
		
		JLabel lblEmailResponsavel = new JLabel("E-mail do responsável:");
		lblEmailResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailResponsavel.setBounds(659, 376, 133, 18);
		add(lblEmailResponsavel);
		
		txtEmailResponsavel = new JTextField();
		txtEmailResponsavel.setBounds(794, 377, 204, 18);
		add(txtEmailResponsavel);
		txtEmailResponsavel.setColumns(10);

		JLabel lblTelefoneResponsavel = new JLabel("Telefone do responsável:");
		lblTelefoneResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTelefoneResponsavel.setBounds(401, 376, 160, 18);
		add(lblTelefoneResponsavel);
		
		try {
			formattedtxtTelefoneResponsavel = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtTelefoneResponsavel.setBounds(549, 377, 100, 18);
		add(formattedtxtTelefoneResponsavel);

		JButton btnCadastrarAluno = new JButton("Salvar");
		btnCadastrarAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnCadastrarAluno.setBounds(508, 461, 96, 25);
		add(btnCadastrarAluno);
	}
}