package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField; 
import javax.swing.JButton;
import javax.swing.JTextArea; 
import javax.swing.JScrollPane; 
import javax.swing.text.MaskFormatter;

import dao.AnoEscolarDAO;
import dao.DisciplinaDAO;
import dao.Services;
import modelo.AnoEscolar;
import modelo.Serie;

import java.text.ParseException;
import java.util.ArrayList;

public class PainelCadastroAnoEscolar extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtNomeAnoEscolar;
    private JFormattedTextField formattedtxtSerie; 
    private JTextArea txtDescricaoAnoEscolar;
    private JButton btnSalvarAnoEscolar;

    public PainelCadastroAnoEscolar() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        JLabel lblCadastroAnoEscolar = new JLabel("CADASTRO DE ANO ESCOLAR");
        lblCadastroAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblCadastroAnoEscolar.setBounds(450, 93, 250, 30); 
        add(lblCadastroAnoEscolar);

        JLabel lblNomeAnoEscolar = new JLabel("Nome/Nível (Ex: Ensino Médio):");
        lblNomeAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblNomeAnoEscolar.setBounds(99, 179, 190, 21); 
        add(lblNomeAnoEscolar);

        txtNomeAnoEscolar = new JTextField();
        txtNomeAnoEscolar.setBounds(295, 182, 250, 18);
        txtNomeAnoEscolar.setColumns(10);
        add(txtNomeAnoEscolar);

        JLabel lblSerie = new JLabel("Série (Ex: 1º, 2º, 3º):");
        lblSerie.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblSerie.setBounds(560, 182, 130, 12);
        add(lblSerie);

        try {
            formattedtxtSerie = new JFormattedTextField(new MaskFormatter("###")); 
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedtxtSerie.setBounds(695, 181, 40, 18);
        add(formattedtxtSerie);

        JLabel lblDescricao = new JLabel("Descrição (Opcional):");
        lblDescricao.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblDescricao.setBounds(99, 254, 150, 18);
        add(lblDescricao);

        txtDescricaoAnoEscolar = new JTextArea();
        txtDescricaoAnoEscolar.setLineWrap(true);
        txtDescricaoAnoEscolar.setWrapStyleWord(true);
        txtDescricaoAnoEscolar.setFont(new Font("Century Gothic", Font.PLAIN, 12));

        JScrollPane scrollPaneDescricaoAnoEscolar = new JScrollPane(txtDescricaoAnoEscolar);
        scrollPaneDescricaoAnoEscolar.setBounds(295, 249, 575, 100);
        add(scrollPaneDescricaoAnoEscolar);

        btnSalvarAnoEscolar = new JButton("Salvar");
        btnSalvarAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarAnoEscolar.setBounds(512, 396, 96, 25);
        btnSalvarAnoEscolar.addActionListener(e ->{
            String nome = getTxtNomeAnoEscolar().getText();
            String serieStr = getFormattedtxtSerie().getText().trim();
            String descricao = getTxtDescricaoAnoEscolar().getText();
            salvarAnoEscolar(nome, serieStr);
        });
        add(btnSalvarAnoEscolar);
    }

    public JTextField getTxtNomeAnoEscolar() {
        return txtNomeAnoEscolar;
    }

    public void setTxtNomeAnoEscolar(JTextField txtNomeAnoEscolar) {
        this.txtNomeAnoEscolar = txtNomeAnoEscolar;
    }

    public JFormattedTextField getFormattedtxtSerie() {
        return formattedtxtSerie;
    }

    public void setFormattedtxtSerie(JFormattedTextField formattedtxtSerie) {
        this.formattedtxtSerie = formattedtxtSerie;
    }

    public JTextArea getTxtDescricaoAnoEscolar() {
        return txtDescricaoAnoEscolar;
    }

    public void setTxtDescricaoAnoEscolar(JTextArea txtDescricaoAnoEscolar) {
        this.txtDescricaoAnoEscolar = txtDescricaoAnoEscolar;
    }

    public JButton getBtnSalvarAnoEscolar() {
        return btnSalvarAnoEscolar;
    }

    public void setBtnSalvarAnoEscolar(JButton btnSalvarAnoEscolar) {
        this.btnSalvarAnoEscolar = btnSalvarAnoEscolar;
    }

    public void salvarAnoEscolar(String nome, String serieStr){
        try {
            if (nome.trim().isEmpty() || serieStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome do Ano Escolar e Série são obrigatórios!", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //int serieDig = Integer.parseInt(serieStr);

            ArrayList<modelo.Serie> series = new ArrayList<>();
            Serie serie = new Serie();
            serie.setNome(nome);
            series.add(serie);
            
            AnoEscolar novo_ano = new AnoEscolar();
            novo_ano.setSeries(series);
            
            String codigo = Services.criarCodigoAnoEscolar(); 
            novo_ano.setCodigo(codigo);
            
            AnoEscolarDAO.criarAnoEscolar(novo_ano); 
            
            JOptionPane.showMessageDialog(null, "Ano Escolar criado com sucesso! Código: " + codigo, "Ano Escolar Criado", JOptionPane.INFORMATION_MESSAGE);
            
            getTxtNomeAnoEscolar().setText("");
            getFormattedtxtSerie().setText("");
            getTxtDescricaoAnoEscolar().setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo Série deve conter apenas números.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar Ano Escolar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void criarAnoEscolar(){
        AnoEscolarDAO.criarAnoEscolar(null);
    }

}