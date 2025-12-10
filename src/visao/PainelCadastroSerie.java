package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import dao.SerieDAO;
import modelo.Serie;

public class PainelCadastroSerie extends JPanel {

    private static final long serialVersionUID = 1L;

    private JComboBox<String> comboAnoSerie;

    public PainelCadastroSerie() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        JLabel lblCadastroSerie = new JLabel("CADASTRO DE SÉRIES");
        lblCadastroSerie.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblCadastroSerie.setBounds(460, 50, 300, 30);
        add(lblCadastroSerie);

        JLabel lblAnoSerie = new JLabel("Escolha o Ano da Série:");
        lblAnoSerie.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblAnoSerie.setBounds(100, 120, 150, 20);
        add(lblAnoSerie);

        comboAnoSerie = new JComboBox<>();
        comboAnoSerie.setBounds(260, 120, 100, 20);
        comboAnoSerie.addItem("1º Ano");
        comboAnoSerie.addItem("2º Ano");
        comboAnoSerie.addItem("3º Ano");
        add(comboAnoSerie);

        JButton btnSalvarSerie = new JButton("Salvar");
        btnSalvarSerie.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarSerie.setBounds(260, 180, 100, 25);
        add(btnSalvarSerie);
        btnSalvarSerie.addActionListener(e -> salvarSerie());
    }

    private void salvarSerie() {
        try {
            String nomeSerie = (String) comboAnoSerie.getSelectedItem();

            if (SerieDAO.getSerie(nomeSerie) != null) {
                JOptionPane.showMessageDialog(this, "Esta série já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Serie serie = new Serie();
            serie.setNome(nomeSerie);
            SerieDAO.salvarSerie(serie);

            JOptionPane.showMessageDialog(this, "Série cadastrada com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar série: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void limparCampos() {
        comboAnoSerie.setSelectedIndex(0);
    }
}
