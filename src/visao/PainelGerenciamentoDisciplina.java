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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelGerenciamentoDisciplina extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboFiltroBusca;
	private JTextField txtTermoBusca;
	private JButton btnBuscar;
	
	private JTextField txtNomeDisciplina;
	private JTextField txtCodigoDisciplina;
	private JFormattedTextField formattedtxtCargaHoraria;
	private JButton btnExcluir;
	private JButton btnSalvarEdicao;
	private JTextField txtProfessorResponsavel;

	public PainelGerenciamentoDisciplina() {
		setBackground(new Color(145, 196, 195));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("GERENCIAMENTO DE DISCIPLINAS");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTitulo.setBounds(423, 40, 300, 30);
		add(lblTitulo);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBuscarPor.setBounds(230, 111, 80, 18);
		add(lblBuscarPor);
		
		comboFiltroBusca = new JComboBox<>();
		comboFiltroBusca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		comboFiltroBusca.setModel(new DefaultComboBoxModel<>(new String[] {"Nome", "Código"}));
		comboFiltroBusca.setBounds(304, 111, 120, 18);
		add(comboFiltroBusca);

		txtTermoBusca = new JTextField();
		txtTermoBusca.setBounds(450, 112, 300, 18);
		add(txtTermoBusca);
		txtTermoBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnBuscar.setBounds(776, 110, 90, 21);
		add(btnBuscar);
		
		JLabel lblNomeDisciplina = new JLabel("Nome da Disciplina:");
        lblNomeDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblNomeDisciplina.setBounds(156, 179, 120, 21); 
        add(lblNomeDisciplina);

        txtNomeDisciplina = new JTextField();
        txtNomeDisciplina.setEditable(false);
        txtNomeDisciplina.setBounds(286, 181, 250, 18); 
        add(txtNomeDisciplina);
        txtNomeDisciplina.setColumns(10);

        JLabel lblCodigoDisciplina = new JLabel("Código:");
        lblCodigoDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCodigoDisciplina.setBounds(546, 180, 50, 18); 
        add(lblCodigoDisciplina);

        txtCodigoDisciplina = new JTextField(); 
        txtCodigoDisciplina.setEditable(false);
        txtCodigoDisciplina.setBounds(600, 181, 100, 18); 
        add(txtCodigoDisciplina);
        txtCodigoDisciplina.setColumns(10);

        JLabel lblCargaHoraria = new JLabel("Carga Horária (horas):");
        lblCargaHoraria.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCargaHoraria.setBounds(726, 183, 140, 12); 
        add(lblCargaHoraria);

        try {
            formattedtxtCargaHoraria = new JFormattedTextField(new MaskFormatter("###"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedtxtCargaHoraria.setEditable(false);
        formattedtxtCargaHoraria.setBounds(860, 181, 40, 18); 
        add(formattedtxtCargaHoraria);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblDescricao.setBounds(185, 294, 100, 18); 
        add(lblDescricao);
        
        JScrollPane scrollPaneDescricaoDisciplina = new JScrollPane();
        scrollPaneDescricaoDisciplina.setBounds(260, 294, 640, 100); 
        add(scrollPaneDescricaoDisciplina);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnExcluir.setBounds(400, 439, 120, 25);
		add(btnExcluir);
		
		btnSalvarEdicao = new JButton("Salvar Alterações");
		btnSalvarEdicao.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSalvarEdicao.setBounds(600, 439, 150, 25);
		add(btnSalvarEdicao);
		
		JLabel lblProfessorResponsavel = new JLabel("Professor responsável:");
		lblProfessorResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblProfessorResponsavel.setBounds(400, 237, 134, 18);
		add(lblProfessorResponsavel);
		
		txtProfessorResponsavel = new JTextField();
		txtProfessorResponsavel.setBounds(532, 238, 113, 18);
		add(txtProfessorResponsavel);
		txtProfessorResponsavel.setColumns(10);
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