package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import dao.MatriculaAlunoDAO;
import modelo.Aluno;
import modelo.MatriculaAluno;

import java.text.ParseException;
import java.util.ArrayList;

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
		lblBuscarPor.setBounds(100, 100, 80, 18);
		add(lblBuscarPor);
		
		comboFiltroBusca = new JComboBox<>();
		comboFiltroBusca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboFiltroBusca.setModel(new DefaultComboBoxModel<>(new String[] {"Nome", "CPF", "Série", "Ano Escolar"}));
		comboFiltroBusca.setBounds(180, 100, 120, 18);
		add(comboFiltroBusca);

		txtTermoBusca = new JTextField();
		txtTermoBusca.setBounds(310, 100, 300, 18);
		add(txtTermoBusca);
		txtTermoBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnBuscar.setBounds(620, 98, 90, 21);
		add(btnBuscar);
		btnBuscar.addActionListener(e -> acaoBuscarAluno());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 135, 800, 2);
		add(separator);
		
		// --- CAMPOS DE DADOS DO ALUNO ---
		
		JLabel lblNomeAluno = new JLabel("Nome completo:");
		lblNomeAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeAluno.setBounds(99, 179, 100, 18);
		add(lblNomeAluno);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setEditable(false);
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
		formattedtxtDataNascimentoAluno.setEditable(false);
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
		formattedtxtCpfAluno.setEditable(false);
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
		formattedtxtRgAluno.setEditable(false);
		formattedtxtRgAluno.setBounds(831, 180, 100, 18);
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
		lblNomeResponsavel.setBounds(57, 377, 133, 16);
		add(lblNomeResponsavel);
		
		txtNomeResponsavel = new JTextField();
		txtNomeResponsavel.setEditable(false);
		txtNomeResponsavel.setBounds(193, 377, 199, 18);
		add(txtNomeResponsavel);
		txtNomeResponsavel.setColumns(10);
		
		JLabel lblEmailResponsavel = new JLabel("E-mail do responsável:");
		lblEmailResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailResponsavel.setBounds(659, 376, 133, 18);
		add(lblEmailResponsavel);
		
		txtEmailResponsavel = new JTextField();
		txtEmailResponsavel.setEditable(false);
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
		formattedtxtTelefoneResponsavel.setEditable(false);
		formattedtxtTelefoneResponsavel.setBounds(549, 377, 100, 18);
		add(formattedtxtTelefoneResponsavel);

		// --- BOTÕES DE AÇÃO ---
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnEditar.setBounds(280, 461, 120, 25);
		add(btnEditar);
		btnEditar.addActionListener(e -> acaoAtivarEdicao());
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnExcluir.setBounds(420, 461, 120, 25);
		add(btnExcluir);
		btnExcluir.addActionListener(e -> acaoExcluirAluno());
		
		btnSalvarEdicao = new JButton("Salvar Alterações");
		btnSalvarEdicao.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSalvarEdicao.setBounds(560, 461, 150, 25);
		add(btnSalvarEdicao);
		btnSalvarEdicao.addActionListener(e -> acaoSalvarEdicao());
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

	public void preencherCampos(Aluno aluno) {
		txtNomeAluno.setText(aluno.getNome());
		formattedtxtCpfAluno.setText(aluno.getCpf());
		formattedtxtRgAluno.setText(aluno.getRg());
		
		String data = aluno.getDiaNasc() + "/" + aluno.getMesNasc() + "/" + aluno.getAnoNasc();
		formattedtxtDataNascimentoAluno.setText(data);

		txtRuaAluno.setText(aluno.getNomeRua());
		txtBairroAluno.setText(aluno.getNomeBairro());
		formattedtxtNumeroCasaAluno.setText(String.valueOf(aluno.getNumeroCasa()));
		txtCidadeAluno.setText(aluno.getNomeCidade());
		txtComplementoAluno.setText(aluno.getComplemento());
		formattedtxtTelefoneAluno.setText(aluno.getNumeroTelefone());
		txtEmailAluno.setText(aluno.getEmail());

		txtNomeResponsavel.setText(aluno.getNomeResponsavel());
		txtEmailResponsavel.setText(aluno.getEmailResponsavel());
		formattedtxtTelefoneResponsavel.setText(aluno.getTelefoneResponsavel());
	}

	public void habilitarEdicao(boolean status) {
		txtNomeAluno.setEditable(status);
		formattedtxtDataNascimentoAluno.setEditable(status);
		formattedtxtCpfAluno.setEditable(status);
		formattedtxtRgAluno.setEditable(status);

		txtRuaAluno.setEditable(status);
		txtBairroAluno.setEditable(status);
		formattedtxtNumeroCasaAluno.setEditable(status);
		txtCidadeAluno.setEditable(status);
		txtComplementoAluno.setEditable(status);
		formattedtxtTelefoneAluno.setEditable(status);
		txtEmailAluno.setEditable(status);

		txtNomeResponsavel.setEditable(status);
		txtEmailResponsavel.setEditable(status);
		formattedtxtTelefoneResponsavel.setEditable(status);
	}

	public void limparCampos() {
		txtNomeAluno.setText("");
		formattedtxtCpfAluno.setText("");
		formattedtxtRgAluno.setText("");
		formattedtxtDataNascimentoAluno.setText("");

		txtRuaAluno.setText("");
		txtBairroAluno.setText("");
		formattedtxtNumeroCasaAluno.setText("");
		txtCidadeAluno.setText("");
		txtComplementoAluno.setText("");
		formattedtxtTelefoneAluno.setText("");
		txtEmailAluno.setText("");

		txtNomeResponsavel.setText("");
		txtEmailResponsavel.setText("");
		formattedtxtTelefoneResponsavel.setText("");
	}

	private void acaoAtivarEdicao() {
		setCamposEditaveis(true);
		btnSalvarEdicao.setEnabled(true);
		btnEditar.setEnabled(false);
		System.out.println("Edição ativada.");
	}

	public void acaoBuscarAluno() {
		String termo = txtTermoBusca.getText().trim();
		if (termo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite algo para buscar.");
			return;
		}

		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = null;
		MatriculaAluno matricula = null;

		String filtro = (String) comboFiltroBusca.getSelectedItem();

		if (filtro.equals("Nome")) {
			aluno = dao.getAlunoNome(termo);
		} else if (filtro.equals("CPF")) {
			aluno = dao.getAlunoCpf(termo);
		} else if (filtro.equals("Série")) {
			ArrayList<Aluno> lista = dao.getAlunosPorSerie(termo);
			if (!lista.isEmpty()) {
				aluno = lista.get(0);
			}
		} else if (filtro.equals("Ano Escolar")) {
			try {
				int ano = parseIntSeguro(termo);
				ArrayList<Aluno> lista = dao.getAlunosPorAnoEscolar(ano);
				if (!lista.isEmpty()) {
					aluno = lista.get(0);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ano inválido!");
				return;
			}
		}

		if (aluno == null) {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
			return;
		}

		// Agora pega a matrícula para preencher série, turma e ano escolar
		if (MatriculaAlunoDAO.existe(aluno.getMatricula())) {
			matricula = MatriculaAlunoDAO.getMatricula(aluno.getMatricula());
		}

		// Preenche os campos do painel
		preencherCamposAluno(aluno, matricula);

		setCamposEditaveis(false);
	}


	private void acaoExcluirAluno() {
		String cpf = formattedtxtCpfAluno.getText().trim();

		if (cpf.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado para excluir.");
			return;
		}

		int opc = JOptionPane.showConfirmDialog(
			null,
			"Deseja realmente excluir este aluno?",
			"Confirmar exclusão",
			JOptionPane.YES_NO_OPTION
		);

		if (opc == JOptionPane.YES_OPTION) {
			AlunoDAO dao = new AlunoDAO();
			Aluno aluno = dao.getAlunoCpf(cpf);

			if (aluno != null) {
				dao.removerAluno(aluno.getMatricula());
				limparCampos();
				JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
			}
		}
	}

	private void acaoSalvarEdicao() {
		String cpf = formattedtxtCpfAluno.getText().trim();

		if (cpf.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum aluno carregado para edição.");
			return;
		}

		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.getAlunoCpf(cpf);

		if (aluno == null) {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
			return;
		}

		aluno.setNome(txtNomeAluno.getText());
		aluno.setEmail(txtEmailAluno.getText());
		aluno.setRg(formattedtxtRgAluno.getText());
		aluno.setNomeRua(txtRuaAluno.getText());
		aluno.setNomeBairro(txtBairroAluno.getText());
		aluno.setNumeroCasa(parseIntSeguro(formattedtxtNumeroCasaAluno.getText()));
		aluno.setNomeCidade(txtCidadeAluno.getText());
		aluno.setComplemento(txtComplementoAluno.getText());
		aluno.setNumeroTelefone(formattedtxtTelefoneAluno.getText());
		aluno.setNomeResponsavel(txtNomeResponsavel.getText());
		aluno.setTelefoneResponsavel(formattedtxtTelefoneResponsavel.getText());
		aluno.setEmailResponsavel(txtEmailResponsavel.getText());

		dao.sobrescreverArquivo(aluno);

		JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");

		setCamposEditaveis(false);
		btnSalvarEdicao.setEnabled(false);
		btnEditar.setEnabled(true);

		System.out.println("Edição salva.");
	}

	public static int parseIntSeguro(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return 0;
		}
		try {
			return Integer.parseInt(texto.trim());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private void setCamposEditaveis(boolean ativo) {
		txtNomeAluno.setEditable(ativo);
		formattedtxtDataNascimentoAluno.setEditable(ativo);
		formattedtxtCpfAluno.setEditable(ativo);
		formattedtxtRgAluno.setEditable(ativo);
		txtRuaAluno.setEditable(ativo);
		txtBairroAluno.setEditable(ativo);
		formattedtxtNumeroCasaAluno.setEditable(ativo);
		txtCidadeAluno.setEditable(ativo);
		txtComplementoAluno.setEditable(ativo);
		formattedtxtTelefoneAluno.setEditable(ativo);
		txtEmailAluno.setEditable(ativo);
		txtNomeResponsavel.setEditable(ativo);
		formattedtxtTelefoneResponsavel.setEditable(ativo);
		txtEmailResponsavel.setEditable(ativo);
	}
	
	private void preencherCamposAluno(Aluno aluno, MatriculaAluno matricula) {
		txtNomeAluno.setText(aluno.getNome());
		formattedtxtCpfAluno.setText(aluno.getCpf());
		formattedtxtRgAluno.setText(aluno.getRg());
		formattedtxtDataNascimentoAluno.setText(
			String.format("%02d/%02d/%04d", aluno.getDiaNasc(), aluno.getMesNasc(), aluno.getAnoNasc())
		);
		txtRuaAluno.setText(aluno.getNomeRua());
		txtBairroAluno.setText(aluno.getNomeBairro());
		txtCidadeAluno.setText(aluno.getNomeCidade());
		formattedtxtNumeroCasaAluno.setText(String.valueOf(aluno.getNumeroCasa()));
		txtComplementoAluno.setText(aluno.getComplemento());
		formattedtxtTelefoneAluno.setText(aluno.getNumeroTelefone());
		txtEmailAluno.setText(aluno.getEmail());
		txtNomeResponsavel.setText(aluno.getNomeResponsavel());
		txtEmailResponsavel.setText(aluno.getEmailResponsavel());
		formattedtxtTelefoneResponsavel.setText(aluno.getTelefoneResponsavel());

		// Preenche os campos da matrícula (série, turma e ano escolar)
		if (matricula != null) {
			JLabel lblSerieAluno = new JLabel("Série: " + matricula.getSerie());
			lblSerieAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblSerieAluno.setBounds(100, 420, 150, 18);
			add(lblSerieAluno);

			JLabel lblTurmaAluno = new JLabel("Turma: " + matricula.getTurma());
			lblTurmaAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblTurmaAluno.setBounds(260, 420, 150, 18);
			add(lblTurmaAluno);

			JLabel lblAnoEscolar = new JLabel("Ano Escolar: " + matricula.getAnoEscolar());
			lblAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblAnoEscolar.setBounds(420, 420, 150, 18);
			add(lblAnoEscolar);
		}
	}

	 public void buscar(String filtro, String termo) {
		Aluno aluno = buscarAluno(filtro, termo);
		if (aluno == null) return;

		// Preenche os campos do aluno
		txtNomeAluno.setText(aluno.getNome());
		formattedtxtCpfAluno.setText(aluno.getCpf());
		formattedtxtRgAluno.setText(aluno.getRg());
		formattedtxtDataNascimentoAluno.setText(
			String.format("%02d/%02d/%04d", aluno.getDiaNasc(), aluno.getMesNasc(), aluno.getAnoNasc())
		);
		formattedtxtTelefoneAluno.setText(aluno.getNumeroTelefone());
		formattedtxtNumeroCasaAluno.setText(String.format("%03d", aluno.getNumeroCasa()));
		txtRuaAluno.setText(aluno.getNomeRua());
		txtBairroAluno.setText(aluno.getNomeBairro());
		txtCidadeAluno.setText(aluno.getNomeCidade());
		txtComplementoAluno.setText(aluno.getComplemento());
		//txtInativoAluno.setText(aluno.getSituacao().equalsIgnoreCase("Inativo") ? "Sim" : "Não");

		// Pega os dados da matrícula
		MatriculaAluno m = MatriculaAlunoDAO.getMatricula(aluno.getMatricula());
		if (m != null) {
			//txtSerieAluno.setText(m.getSerie());
			//txtTurmaAluno.setText(m.getTurma());
			//txtAnoEscolarAluno.setText(m.getAnoEscolar());
		}

		// Deixa os campos editáveis
		txtNomeAluno.setEditable(true);
		formattedtxtCpfAluno.setEditable(true);
		formattedtxtRgAluno.setEditable(true);
		formattedtxtDataNascimentoAluno.setEditable(true);
		formattedtxtTelefoneAluno.setEditable(true);
		formattedtxtNumeroCasaAluno.setEditable(true);
		txtRuaAluno.setEditable(true);
		txtBairroAluno.setEditable(true);
		txtCidadeAluno.setEditable(true);
		txtComplementoAluno.setEditable(true);
		//txtSerieAluno.setEditable(true);
		//txtTurmaAluno.setEditable(true);
		//txtAnoEscolarAluno.setEditable(true);
		//txtInativoAluno.setEditable(true);
	}


    public Aluno buscarAluno(String filtro, String termo) {
        AlunoDAO dao = new AlunoDAO();
        ArrayList<Aluno> alunos = dao.getAlunos();
        Aluno encontrado = null;

        switch (filtro) {
            case "CPF":
                for (Aluno a : alunos) {
                    if (a.getCpf().equals(termo.trim())) {
                        encontrado = a;
                        break;
                    }
                }
                break;
            case "Nome":
                for (Aluno a : alunos) {
                    if (a.getNome().equalsIgnoreCase(termo.trim())) {
                        encontrado = a;
                        break;
                    }
                }
                break;
            case "Matrícula":
                for (Aluno a : alunos) {
                    if (a.getMatricula().equals(termo.trim())) {
                        encontrado = a;
                        break;
                    }
                }
                break;
        }

        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado", "Erro ao procurar Aluno", JOptionPane.ERROR_MESSAGE);
        }

        return encontrado;
    }

    public void excluirAluno(String filtro, String termo) {
        Aluno aluno = buscarAluno(filtro, termo);
        if (aluno == null) return;

        AlunoDAO dao = new AlunoDAO();
        dao.removerAluno(aluno.getMatricula());
        JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
    }

    public void editarAluno(String filtro, String termo) {
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = buscarAluno(filtro, termo);
		if (aluno == null) return;

		// Atualiza dados do aluno
		aluno.setNome(txtNomeAluno.getText());
		aluno.setCpf(formattedtxtCpfAluno.getText());
		aluno.setRg(formattedtxtRgAluno.getText());
		aluno.setNumeroTelefone(formattedtxtTelefoneAluno.getText());
		aluno.setNumeroCasa(Integer.parseInt(formattedtxtNumeroCasaAluno.getText()));
		String[] data = formattedtxtDataNascimentoAluno.getText().split("/");
		aluno.setDiaNasc(Integer.parseInt(data[0]));
		aluno.setMesNasc(Integer.parseInt(data[1]));
		aluno.setAnoNasc(Integer.parseInt(data[2]));
		aluno.setNomeRua(txtRuaAluno.getText());
		aluno.setNomeBairro(txtBairroAluno.getText());
		aluno.setNomeCidade(txtCidadeAluno.getText());
		aluno.setComplemento(txtComplementoAluno.getText());
		// Define "Ativo" ou "Inativo" de acordo com o texto do campo
		//aluno.setSituacao(txtInativoAluno.getText().equalsIgnoreCase("Sim") ? "Inativo" : "Ativo");

		// Atualiza matrícula
		MatriculaAluno matricula = MatriculaAlunoDAO.getMatricula(aluno.getMatricula());
		if (matricula != null) {
			//matricula.setSerie(txtSerieAluno.getText());
			//matricula.setTurma(txtTurmaAluno.getText());
			//matricula.setAnoEscolar(txtAnoEscolarAluno.getText());

			MatriculaAlunoDAO.atualizar(matricula);
		}

		// Salva aluno
		alunoDAO.editarAluno(aluno, aluno.getMatricula());
		JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
	}


}