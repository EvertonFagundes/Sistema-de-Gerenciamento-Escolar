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
    private JTextField txtProfessorResponsavel;

    public PainelCadastroDisciplina() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        JLabel lblCadastroDisciplinas = new JLabel("CADASTRO DE DISCIPLINAS");
        lblCadastroDisciplinas.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblCadastroDisciplinas.setBounds(450, 93, 250, 30); 
        add(lblCadastroDisciplinas);

        JLabel lblNomeDisciplina = new JLabel("Nome da Disciplina:");
        lblNomeDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblNomeDisciplina.setBounds(131, 179, 120, 21); 
        add(lblNomeDisciplina);

        txtNomeDisciplina = new JTextField();
        txtNomeDisciplina.setBounds(261, 181, 250, 18); 
        add(txtNomeDisciplina);
        txtNomeDisciplina.setColumns(10);

        JLabel lblCodigoDisciplina = new JLabel("Código:");
        lblCodigoDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCodigoDisciplina.setBounds(521, 180, 50, 18); 
        add(lblCodigoDisciplina);

        txtCodigoDisciplina = new JTextField(); 
        txtCodigoDisciplina.setBounds(581, 181, 100, 18); 
        add(txtCodigoDisciplina);
        txtCodigoDisciplina.setColumns(10);

        JLabel lblCargaHoraria = new JLabel("Carga Horária (horas):");
        lblCargaHoraria.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCargaHoraria.setBounds(691, 183, 140, 12); 
        add(lblCargaHoraria);

        try {
           
            formattedtxtCargaHoraria = new JFormattedTextField(new MaskFormatter("###"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedtxtCargaHoraria.setBounds(830, 181, 40, 18); 
        add(formattedtxtCargaHoraria);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblDescricao.setBounds(156, 301, 64, 18); 
        add(lblDescricao);
        JScrollPane scrollPaneDescricaoDisciplina = new JScrollPane();
        scrollPaneDescricaoDisciplina.setBounds(230, 298, 640, 100); 
        add(scrollPaneDescricaoDisciplina);

        JButton btnSalvarDisciplina = new JButton("Salvar");
        btnSalvarDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarDisciplina.setBounds(513, 429, 96, 25); 
        add(btnSalvarDisciplina);
        
        JLabel lblProfessorResponsavel = new JLabel("Professor responsável:");
        lblProfessorResponsavel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblProfessorResponsavel.setBounds(371, 244, 140, 16);
        add(lblProfessorResponsavel);
        
        txtProfessorResponsavel = new JTextField();
        txtProfessorResponsavel.setBounds(513, 242, 120, 18);
        add(txtProfessorResponsavel);
        txtProfessorResponsavel.setColumns(10);
    }
}