package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import dao.AnoEscolarDAO;
import dao.Services;
import modelo.AnoEscolar;
import modelo.PeriodoLetivo;

import java.util.ArrayList;

public class PainelCadastroAnoEscolar extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtAno;
    private JComboBox<String> comboPeriodo;
    private JButton btnSalvarAnoEscolar;

    public PainelCadastroAnoEscolar() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        JLabel lblCadastroAnoEscolar = new JLabel("CADASTRO DE ANO ESCOLAR");
        lblCadastroAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblCadastroAnoEscolar.setBounds(450, 93, 250, 30);
        add(lblCadastroAnoEscolar);

        JLabel lblAno = new JLabel("Ano (Ex: 2025):");
        lblAno.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblAno.setBounds(99, 179, 190, 21);
        add(lblAno);

        txtAno = new JTextField();
        txtAno.setBounds(295, 182, 250, 18);
        add(txtAno);

        JLabel lblPeriodo = new JLabel("Período Letivo:");
        lblPeriodo.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblPeriodo.setBounds(99, 240, 190, 21);
        add(lblPeriodo);

        comboPeriodo = new JComboBox<>();
        comboPeriodo.setBounds(295, 240, 250, 22);
        comboPeriodo.addItem("4 Bimestres");
        comboPeriodo.addItem("3 Trimestres");
        comboPeriodo.addItem("2 Semestres");
        add(comboPeriodo);

        btnSalvarAnoEscolar = new JButton("Salvar");
        btnSalvarAnoEscolar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarAnoEscolar.setBounds(512, 396, 96, 25);
        btnSalvarAnoEscolar.addActionListener(e -> {
            salvarAnoEscolar(txtAno.getText().trim());
        });
        add(btnSalvarAnoEscolar);
    }

    // Cria os períodos conforme a seleção do usuário
    private ArrayList<PeriodoLetivo> gerarPeriodos(String tipo) {
        ArrayList<PeriodoLetivo> lista = new ArrayList<>();

        if (tipo.equals("4 Bimestres")) {
            for (int i = 1; i <= 4; i++) {
                PeriodoLetivo p = new PeriodoLetivo();
                p.setNome(i + "º Bimestre");
                lista.add(p);
            }
        } 
        else if (tipo.equals("3 Trimestres")) {
            for (int i = 1; i <= 3; i++) {
                PeriodoLetivo p = new PeriodoLetivo();
                p.setNome(i + "º Trimestre");
                lista.add(p);
            }
        } 
        else if (tipo.equals("2 Semestres")) {
            for (int i = 1; i <= 2; i++) {
                PeriodoLetivo p = new PeriodoLetivo();
                p.setNome(i + "º Semestre");
                lista.add(p);
            }
        }

        return lista;
    }

    public void salvarAnoEscolar(String anoStr) {
        try {
            if (anoStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O ano é obrigatório!", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int ano = Integer.parseInt(anoStr);

            String tipoPeriodo = comboPeriodo.getSelectedItem().toString();
            ArrayList<PeriodoLetivo> periodos = gerarPeriodos(tipoPeriodo);

            // Criar AnoEscolar compatível com o DAO
            AnoEscolar novoAno = new AnoEscolar();
            novoAno.setAno(ano);
            novoAno.setPeriodoLetivo(periodos);
            novoAno.setSituacao(true);
            novoAno.setCodigo(Services.criarCodigoAnoEscolar());  

            // CHAMADA DO DAO
            AnoEscolarDAO.criarAnoEscolar(novoAno);

            JOptionPane.showMessageDialog(null, "Ano Escolar criado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);

            txtAno.setText("");
            comboPeriodo.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar Ano Escolar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
