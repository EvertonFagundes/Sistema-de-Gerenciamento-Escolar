package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;     
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel; 

public class PainelBoletim extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtBuscaAluno;
    private JComboBox<String> comboBoxAnoEscolar;
    private JComboBox<String> comboBoxPeriodoLetivo;
    private JTable tabelaBoletim;
    private JButton btnVisualizar;

    public PainelBoletim() {
        setBackground(new Color(145, 196, 195));
        setLayout(null); 

        JLabel lblTituloBoletim = new JLabel("GERENCIAMENTO DE BOLETIM");
        lblTituloBoletim.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblTituloBoletim.setBounds(450, 40, 250, 30); 
        add(lblTituloBoletim);

     
        JLabel lblBuscarAluno = new JLabel("Buscar Aluno (Nome):");
        lblBuscarAluno.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblBuscarAluno.setBounds(83, 101, 140, 18);
        add(lblBuscarAluno);

        txtBuscaAluno = new JTextField();
        txtBuscaAluno.setBounds(223, 102, 250, 18);
        add(txtBuscaAluno);
        txtBuscaAluno.setColumns(10);

        JLabel lblAnoEscolar = new JLabel("Ano Escolar:");
        lblAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblAnoEscolar.setBounds(483, 101, 80, 18);
        add(lblAnoEscolar);

       
        comboBoxAnoEscolar = new JComboBox<>();
        comboBoxAnoEscolar.setModel(new DefaultComboBoxModel(new String[] {"Selecione..."}));
        comboBoxAnoEscolar.setBounds(562, 102, 100, 18);
        add(comboBoxAnoEscolar);

        JLabel lblPeriodo = new JLabel("Período Letivo:");
        lblPeriodo.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblPeriodo.setBounds(682, 101, 100, 18);
        add(lblPeriodo);

      
        String[] periodos = {"Selecione...", "1º Bimestre", "2º Bimestre", "Final"};
        comboBoxPeriodoLetivo = new JComboBox<>(periodos);
        comboBoxPeriodoLetivo.setBounds(782, 102, 120, 18);
        add(comboBoxPeriodoLetivo);

        btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnVisualizar.setBounds(928, 100, 89, 21);
        add(btnVisualizar);

        JScrollPane scrollPaneTabela = new JScrollPane();
        scrollPaneTabela.setBounds(83, 179, 950, 300); 
        add(scrollPaneTabela);

        tabelaBoletim = new JTable();
       
        tabelaBoletim.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Disciplina", "Nota 1º unidade", "Faltas 1º unidade", "Nota 2º unidade", "Faltas 2º unidade","Notas 3º unidade", "Faltas 3º unidade", "Média Final", "Frequência (%)"
            }
        ));
        tabelaBoletim.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        scrollPaneTabela.setViewportView(tabelaBoletim);
    }

	public JTextField getTxtBuscaAluno() {
		return txtBuscaAluno;
	}

	public JComboBox<String> getComboBoxAnoEscolar() {
		return comboBoxAnoEscolar;
	}

	public JComboBox<String> getComboBoxPeriodoLetivo() {
		return comboBoxPeriodoLetivo;
	}

	public JTable getTabelaBoletim() {
		return tabelaBoletim;
	}

	public JButton getBtnVisualizar() {
		return btnVisualizar;
	}
}