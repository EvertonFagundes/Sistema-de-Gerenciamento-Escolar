package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.lang.classfile.constantpool.IntegerEntry;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import dao.TurmaDAO;
import dao.SerieDAO;
import dao.AnoEscolarDAO;
import modelo.Turma;
import modelo.Serie;

public class PainelCadastroTurma extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtIdentificador;
    private JComboBox<String> comboSerie;
    private int anoAtivo;

    public PainelCadastroTurma() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        // Obtém o ano escolar ativo
        anoAtivo = AnoEscolarDAO.getAnoEscolarAtivo().getAno();

        JLabel lblCadastroTurma = new JLabel("CADASTRO DE TURMAS - Ano " + anoAtivo);
        lblCadastroTurma.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblCadastroTurma.setBounds(460, 50, 300, 30);
        add(lblCadastroTurma);

        JLabel lblIdentificador = new JLabel("Identificador:");
        lblIdentificador.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblIdentificador.setBounds(100, 120, 100, 20);
        add(lblIdentificador);

        txtIdentificador = new JTextField();
        txtIdentificador.setBounds(210, 120, 50, 20);
        add(txtIdentificador);

        JLabel lblSerie = new JLabel("Série:");
        lblSerie.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblSerie.setBounds(280, 120, 50, 20);
        add(lblSerie);

        comboSerie = new JComboBox<>();
        comboSerie.setBounds(330, 120, 150, 20);
        add(comboSerie);

        // Preencher combo com séries existentes
        for (Serie s : SerieDAO.listarSeries()) {
            comboSerie.addItem(s.getNome());
        }

        JButton btnSalvarTurma = new JButton("Salvar");
        btnSalvarTurma.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarTurma.setBounds(330, 180, 100, 25);
        add(btnSalvarTurma);
        btnSalvarTurma.addActionListener(e -> salvarTurma());
    }

    private void salvarTurma() {
        try {
            String identificador = txtIdentificador.getText().trim();
            String nomeSerie = (String) comboSerie.getSelectedItem();

            if (identificador.isEmpty() || nomeSerie == null) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Serie serie = SerieDAO.getSerie(nomeSerie);
            Turma turma = new Turma(Integer.parseInt(serie.getNome().substring(0, 1)), identificador);
            turma.setSerie(serie);

            TurmaDAO.criarTurma(turma);

            JOptionPane.showMessageDialog(this, "Turma cadastrada com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar turma: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void limparCampos() {
        txtIdentificador.setText("");
        comboSerie.setSelectedIndex(0);
    }
}
