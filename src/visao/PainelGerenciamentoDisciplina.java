package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class PainelGerenciamentoDisciplina extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboFiltroBusca;
	private JTextField txtTermoBusca;
	private JButton btnBuscar;
	
	private JTextField txtNomeDisciplina;
	private JTextField txtCodigoDisciplina;
	private JFormattedTextField formattedtxtCargaHoraria;
	private JTextArea txtDescricao;
	
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvarEdicao;

	public PainelGerenciamentoDisciplina() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("GERENCIAMENTO DE DISCIPLINAS");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTitulo.setBounds(400, 40, 300, 30);
		add(lblTitulo);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBuscarPor.setBounds(230, 111, 80, 18);
		add(lblBuscarPor);
		
		comboFiltroBusca = new JComboBox<>();
		comboFiltroBusca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboFiltroBusca.setModel(new DefaultComboBoxModel<>(new String[] {"Nome", "Código"}));
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 145, 800, 2);
		add(separator);
		
		JLabel lblNomeDisciplina = new JLabel("Nome da Disciplina:");
        lblNomeDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblNomeDisciplina.setBounds(99, 179, 120, 21); 
        add(lblNomeDisciplina);

        txtNomeDisciplina = new JTextField();
        txtNomeDisciplina.setEditable(false);
        txtNomeDisciplina.setBounds(230, 182, 250, 18); 
        add(txtNomeDisciplina);
        txtNomeDisciplina.setColumns(10);

        JLabel lblCodigoDisciplina = new JLabel("Código:");
        lblCodigoDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCodigoDisciplina.setBounds(500, 182, 50, 18); 
        add(lblCodigoDisciplina);

        txtCodigoDisciplina = new JTextField(); 
        txtCodigoDisciplina.setEditable(false);
        txtCodigoDisciplina.setBounds(560, 180, 100, 18); 
        add(txtCodigoDisciplina);
        txtCodigoDisciplina.setColumns(10);

        JLabel lblCargaHoraria = new JLabel("Carga Horária (horas):");
        lblCargaHoraria.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCargaHoraria.setBounds(680, 182, 140, 12); 
        add(lblCargaHoraria);

        try {
            formattedtxtCargaHoraria = new JFormattedTextField(new MaskFormatter("###"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedtxtCargaHoraria.setEditable(false);
        formattedtxtCargaHoraria.setBounds(816, 181, 40, 18); 
        add(formattedtxtCargaHoraria);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblDescricao.setBounds(152, 240, 100, 18); 
        add(lblDescricao);
        
        JScrollPane scrollPaneDescricaoDisciplina = new JScrollPane();
        scrollPaneDescricaoDisciplina.setBounds(230, 240, 640, 100); 
        add(scrollPaneDescricaoDisciplina);
        
        txtDescricao = new JTextArea();
        txtDescricao.setEditable(false);
        scrollPaneDescricaoDisciplina.setViewportView(txtDescricao);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnEditar.setBounds(337, 427, 120, 25);
		add(btnEditar);
		
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

	public JTextField getTxtNomeDisciplina() {
		return txtNomeDisciplina;
	}

	public JTextField getTxtCodigoDisciplina() {
		return txtCodigoDisciplina;
	}

	public JFormattedTextField getFormattedtxtCargaHoraria() {
		return formattedtxtCargaHoraria;
	}

	public JTextArea getTxtDescricao() {
		return txtDescricao;
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