package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import dao.ProfessorDAO;
import modelo.Professor;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class PainelGerenciamentoProfessor extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboFiltroBusca;
	private JTextField txtTermoBusca;
	private JButton btnBuscar;
	
	private JTextField txtNomeProfessor;
	private JTextField txtRuaProfessor;
	private JTextField txtBairroProfessor;
	private JTextField txtEmailProfessor;
	private JTextField txtCidadeProfessor;
	private JFormattedTextField formattedtxtDataNascimentoProfessor;
	private JFormattedTextField formattedtxtCpfProfessor;
	private JFormattedTextField formattedtxtRgProfessor;
	private JFormattedTextField formattedtxtTelefoneProfessor;
	private JTextField txtComplementoProfessor;
	private JFormattedTextField formattedtxtNumeroCasaProfessor;
	private JTextField txtFormacaoAcademica;
	
	
	private JButton btnExcluir;
	private JButton btnSalvarEdicao;

	public PainelGerenciamentoProfessor() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("GERENCIAMENTO DE PROFESSORES");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTitulo.setBounds(425, 40, 300, 30);
		add(lblTitulo);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBuscarPor.setBounds(230, 111, 80, 18);
		add(lblBuscarPor);
		
		comboFiltroBusca = new JComboBox<>();
		comboFiltroBusca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboFiltroBusca.setModel(new DefaultComboBoxModel<>(new String[] {"Nome", "CPF", "Disciplina"}));
		comboFiltroBusca.setBounds(305, 111, 120, 18);
		add(comboFiltroBusca);

		txtTermoBusca = new JTextField();
		txtTermoBusca.setBounds(450, 112, 300, 18);
		add(txtTermoBusca);
		txtTermoBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnBuscar.setBounds(776, 110, 90, 21);
		add(btnBuscar);

		btnBuscar.addActionListener(e ->{
			String termo = txtTermoBusca.getText().trim();
			String filtro = comboFiltroBusca.getSelectedItem().toString();
			System.out.println(termo);
			System.out.println(filtro);
			buscar(filtro, termo);

		});
		
		// --- CAMPOS DE DADOS (IGUAIS AO PAINELCADASTROPROFESSOR) ---
		
		JLabel lblNomeProfessor = new JLabel("Nome completo:");
		lblNomeProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNomeProfessor.setBounds(168, 179, 100, 18);
		add(lblNomeProfessor);
		
		txtNomeProfessor = new JTextField();
		txtNomeProfessor.setEditable(false);
		txtNomeProfessor.setBounds(278, 180, 199, 18);
		add(txtNomeProfessor);
		txtNomeProfessor.setColumns(10);
		
		JLabel lblDataNascProfessor = new JLabel("Data de Nascimento:");
		lblDataNascProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDataNascProfessor.setBounds(487, 182, 124, 12);
		add(lblDataNascProfessor);
		
		try {
			formattedtxtDataNascimentoProfessor = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtDataNascimentoProfessor.setEditable(false);
		formattedtxtDataNascimentoProfessor.setBounds(621, 180, 80, 18);
		add(formattedtxtDataNascimentoProfessor);
		
		JLabel lblCpfProfessor = new JLabel("CPF:");
		lblCpfProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCpfProfessor.setBounds(700, 182, 25, 12);
		add(lblCpfProfessor);
		
		try {
			formattedtxtCpfProfessor = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtCpfProfessor.setEditable(false);
		formattedtxtCpfProfessor.setBounds(735, 180, 96, 18);
		add(formattedtxtCpfProfessor);
		
		JLabel lblRgProfessor = new JLabel("RG:");
		lblRgProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRgProfessor.setBounds(841, 182, 25, 12);
		add(lblRgProfessor);
		
		try {
			formattedtxtRgProfessor = new JFormattedTextField(new MaskFormatter("##.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtRgProfessor.setEditable(false);
		formattedtxtRgProfessor.setBounds(872, 180, 100, 18);
		add(formattedtxtRgProfessor);
		
		JLabel lblRuaProfessor = new JLabel("Rua:");
		lblRuaProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRuaProfessor.setBounds(143, 250, 34, 12);
		add(lblRuaProfessor);
		
		txtRuaProfessor = new JTextField();
		txtRuaProfessor.setEditable(false);
		txtRuaProfessor.setBounds(171, 248, 124, 18);
		add(txtRuaProfessor);
		txtRuaProfessor.setColumns(10);
		
		JLabel lblBairroProfessor = new JLabel("Bairro:");
		lblBairroProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBairroProfessor.setBounds(305, 250, 44, 12);
		add(lblBairroProfessor);
		
		txtBairroProfessor = new JTextField();
		txtBairroProfessor.setEditable(false);
		txtBairroProfessor.setBounds(344, 248, 96, 18);
		add(txtBairroProfessor);
		txtBairroProfessor.setColumns(10);
		
		JLabel lblNumeroCasaProfessor = new JLabel("Número:");
		lblNumeroCasaProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNumeroCasaProfessor.setBounds(466, 250, 62, 12);
		add(lblNumeroCasaProfessor);
		
		try {
			formattedtxtNumeroCasaProfessor = new JFormattedTextField(new MaskFormatter("###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtNumeroCasaProfessor.setEditable(false);
		formattedtxtNumeroCasaProfessor.setBounds(526, 248, 40, 18);
		add(formattedtxtNumeroCasaProfessor);
		
		JLabel lblCidadeProfessor = new JLabel("Cidade:");
		lblCidadeProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCidadeProfessor.setBounds(570, 250, 58, 12);
		add(lblCidadeProfessor);
		
		txtCidadeProfessor = new JTextField();
		txtCidadeProfessor.setEditable(false);
		txtCidadeProfessor.setBounds(621, 248, 96, 18);
		add(txtCidadeProfessor);
		txtCidadeProfessor.setColumns(10);
		
		JLabel lblComplementoProfessor = new JLabel("Complemento:");
		lblComplementoProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblComplementoProfessor.setBounds(731, 247, 100, 18);
		add(lblComplementoProfessor);
		
		txtComplementoProfessor = new JTextField();
		txtComplementoProfessor.setEditable(false);
		txtComplementoProfessor.setBounds(825, 248, 153, 18);
		add(txtComplementoProfessor);
		txtComplementoProfessor.setColumns(10);
		
		JLabel lblTelefoneProfessor = new JLabel("Telefone:");
		lblTelefoneProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTelefoneProfessor.setBounds(181, 314, 58, 12); 
		add(lblTelefoneProfessor);

		try {
			formattedtxtTelefoneProfessor = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedtxtTelefoneProfessor.setEditable(false);
		formattedtxtTelefoneProfessor.setBounds(249, 312, 100, 18); 
		add(formattedtxtTelefoneProfessor);
		
		JLabel lblEmailProfessor = new JLabel("E-mail:");
		lblEmailProfessor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailProfessor.setBounds(358, 314, 44, 12); 
		add(lblEmailProfessor);
		
		txtEmailProfessor = new JTextField();
		txtEmailProfessor.setEditable(false);
		txtEmailProfessor.setBounds(400, 312, 153, 18);
		add(txtEmailProfessor);
		txtEmailProfessor.setColumns(10);
		
		JLabel lblFormacao = new JLabel("Formação Acadêmica:");
		lblFormacao.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblFormacao.setBounds(575, 314, 140, 12);
		add(lblFormacao);
		
		txtFormacaoAcademica = new JTextField();
		txtFormacaoAcademica.setEditable(false);
		txtFormacaoAcademica.setBounds(722, 312, 250, 18); 
		add(txtFormacaoAcademica);
		txtFormacaoAcademica.setColumns(10);
		
		// --- BOTÕES DE AÇÃO ---
		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnExcluir.setBounds(491, 427, 120, 25);
		add(btnExcluir);

		
		btnSalvarEdicao = new JButton("Salvar Alterações");
		btnSalvarEdicao.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSalvarEdicao.setBounds(645, 427, 150, 25);
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

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnSalvarEdicao() {
		return btnSalvarEdicao;
	}

	public void buscar(String filtro, String termo){
		Professor professor_procurado = null;
		ProfessorDAO professorDAO = new ProfessorDAO();
		ArrayList<Professor> professores = professorDAO.getProfessores();
		switch (filtro) {
			case "CPF":
			{
				if(professorDAO.buscarPorCpf(termo.trim())){
				
				
				for(Professor professor : professores){
					if(professor.getCpf().equals(termo.trim())){
						professor_procurado = professorDAO.getProfessor(professor.getMatricula());
					}
				}
				}
			}
			break;
			case "Nome":
			{
				if(professorDAO.buscarPorNome(termo)){
					for(Professor professor : professores){
						if(professor.getNome().equals(termo.trim())){
							professor_procurado = professorDAO.getProfessor(professor.getMatricula());
						}
					}
				}
			}
				
		
			default:
				break;
		
			}
			JTextField nome = getTxtNomeProfessor();
			nome.setText(professor_procurado.getNome());
			nome.setEditable(true);

			JFormattedTextField cpf = getFormattedtxtCpfProfessor();
			cpf.setText(professor_procurado.getCpf());
			cpf.setEditable(true);

			JFormattedTextField rg = getFormattedtxtRgProfessor();
			rg.setText(professor_procurado.getRg());
			rg.setEditable(true);

			JFormattedTextField data_nasc = getFormattedtxtDataNascimentoProfessor();
			String professor_data_nasc = String.format("%02d", professor_procurado.getDiaNasc()) + "/" 
				+ String.format("%02d", professor_procurado.getMesNasc()) + "/" 
				+ professor_procurado.getAnoNasc();
			System.out.println(professor_data_nasc);
			data_nasc.setText(professor_data_nasc);
			data_nasc.setEditable(true);

			JFormattedTextField telefone = getFormattedtxtTelefoneProfessor();
			telefone.setText(professor_procurado.getNumeroTelefone());
			telefone.setEditable(true);

			JFormattedTextField numero_da_casa = getFormattedtxtNumeroCasaProfessor();
			numero_da_casa.setText(String.format("%03d", professor_procurado.getNumeroCasa()));
			numero_da_casa.setEditable(true);

			JTextField rua = getTxtRuaProfessor();
			rua.setText(professor_procurado.getNomeRua());
			rua.setEditable(true);

			JTextField cidade = getTxtCidadeProfessor();
			cidade.setText(professor_procurado.getNomeCidade());
			cidade.setEditable(true);

			JTextField complemento = getTxtComplementoProfessor();
			complemento.setText(professor_procurado.getComplemento());
			complemento.setEditable(true);

			JTextField bairro = getTxtBairroProfessor();
			bairro.setText(professor_procurado.getNomeBairro());
			bairro.setEditable(true);

			JTextField email = getTxtEmailProfessor();
			email.setText(professor_procurado.getEmail());
			email.setEditable(true);

			JTextField formacao_academica = getTxtFormacaoAcademica();
			formacao_academica.setText(professor_procurado.getFormacaoAcademica());
			formacao_academica.setEditable(true);

			/*DefaultTableModel model = (DefaultTableModel) tabelaProfessores.getModel();
			model.addRow(new Object[]{
				professor_procurado.getNome(),
				professor_procurado.getCpf(),
				professor_procurado.getNumeroTelefone(),
				professor_procurado.getEmail(),
				professor_procurado.getFormacaoAcademica(),
				professor_procurado.getDisciplinasLeciona()

			});
			*/
		}
}