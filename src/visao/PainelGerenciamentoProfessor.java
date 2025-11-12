package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class PainelGerenciamentoProfessor extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtTermoBusca;
	private JComboBox<String> comboFiltro;
	private JButton btnBuscar;
	private JTable tabelaProfessores;
	private JButton btnEditar;
	private JButton btnExcluir;

	public PainelGerenciamentoProfessor() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("GERENCIAMENTO DE PROFESSORES");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTitulo.setBounds(400, 40, 300, 30);
		add(lblTitulo);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBuscarPor.setBounds(100, 100, 80, 18);
		add(lblBuscarPor);
		
		comboFiltro = new JComboBox<>();
		comboFiltro.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboFiltro.setModel(new DefaultComboBoxModel<>(new String[] {"Nome", "CPF", "Disciplina"}));
		comboFiltro.setBounds(180, 100, 120, 18);
		add(comboFiltro);

		txtTermoBusca = new JTextField();
		txtTermoBusca.setBounds(310, 100, 300, 18);
		add(txtTermoBusca);
		txtTermoBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnBuscar.setBounds(620, 98, 90, 21);
		add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 140, 800, 350);
		add(scrollPane);
		
		tabelaProfessores = new JTable();
		tabelaProfessores.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		tabelaProfessores.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Nome", "CPF", "Telefone", "E-mail", "Formação", "Disciplinas"
			}
		));
		scrollPane.setViewportView(tabelaProfessores);
		
		btnEditar = new JButton("Editar Professor");
		btnEditar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnEditar.setBounds(100, 510, 150, 25);
		add(btnEditar);
		
		btnExcluir = new JButton("Excluir Professor");
		btnExcluir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnExcluir.setBounds(270, 510, 150, 25);
		add(btnExcluir);
	}

	public JTextField getTxtTermoBusca() {
		return txtTermoBusca;
	}

	public JComboBox<String> getComboFiltro() {
		return comboFiltro;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTable getTabelaProfessores() {
		return tabelaProfessores;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}
}