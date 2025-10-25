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

public class PainelCadastroDisciplina extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtNomeDisciplina;
    private JTextField txtCodigoDisciplina;
    private JFormattedTextField formattedtxtCargaHoraria; 

    public PainelCadastroDisciplina() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        JLabel lblCadastroDisciplinas = new JLabel("CADASTRO DE DISCIPLINAS");
        lblCadastroDisciplinas.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblCadastroDisciplinas.setBounds(450, 93, 250, 30); 
        add(lblCadastroDisciplinas);

        JLabel lblNomeDisciplina = new JLabel("Nome da Disciplina:");
        lblNomeDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblNomeDisciplina.setBounds(99, 179, 120, 21); 
        add(lblNomeDisciplina);

        txtNomeDisciplina = new JTextField();
        txtNomeDisciplina.setBounds(230, 182, 250, 18); 
        add(txtNomeDisciplina);
        txtNomeDisciplina.setColumns(10);

        JLabel lblCodigoDisciplina = new JLabel("Código:");
        lblCodigoDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCodigoDisciplina.setBounds(500, 182, 50, 18); 
        add(lblCodigoDisciplina);

        txtCodigoDisciplina = new JTextField(); 
        txtCodigoDisciplina.setBounds(560, 180, 100, 18); 
        add(txtCodigoDisciplina);
        txtCodigoDisciplina.setColumns(10);

        JLabel lblCargaHoraria = new JLabel("Carga Horária (horas):");
        lblCargaHoraria.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCargaHoraria.setBounds(680, 182, 140, 12); // Ajustei a coordenada X
        add(lblCargaHoraria);

        try {
           
            formattedtxtCargaHoraria = new JFormattedTextField(new MaskFormatter("###"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedtxtCargaHoraria.setBounds(816, 181, 40, 18); 
        add(formattedtxtCargaHoraria);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblDescricao.setBounds(151, 254, 100, 18); // Nova linha
        add(lblDescricao);
        JScrollPane scrollPaneDescricaoDisciplina = new JScrollPane();
        scrollPaneDescricaoDisciplina.setBounds(230, 249, 640, 100); 
        add(scrollPaneDescricaoDisciplina);


        // --- BOTÃO ---
        JButton btnSalvarDisciplina = new JButton("Salvar");
        btnSalvarDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarDisciplina.setBounds(512, 396, 96, 25); 
        add(btnSalvarDisciplina);
    }
}