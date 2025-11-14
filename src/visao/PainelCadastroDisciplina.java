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

import dao.DisciplinaDAO;
import dao.Services;
import modelo.Disciplina;

import java.text.ParseException;

public class PainelCadastroDisciplina extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtNomeDisciplina;
    private JFormattedTextField formattedtxtCargaHoraria; 
    private JTextArea txtDescricaoDisciplina;
    private JButton btnSalvarDisciplina;

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
        txtNomeDisciplina.setColumns(10);
        add(txtNomeDisciplina);

        JLabel lblCargaHoraria = new JLabel("Carga Horária (horas):");
        lblCargaHoraria.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblCargaHoraria.setBounds(500, 182, 140, 12);
        add(lblCargaHoraria);

        try {
            formattedtxtCargaHoraria = new JFormattedTextField(new MaskFormatter("###"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedtxtCargaHoraria.setBounds(645, 181, 40, 18);
        add(formattedtxtCargaHoraria);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Century Gothic", Font.BOLD, 12));
        lblDescricao.setBounds(151, 254, 100, 18);
        add(lblDescricao);

        txtDescricaoDisciplina = new JTextArea();
        txtDescricaoDisciplina.setLineWrap(true);
        txtDescricaoDisciplina.setWrapStyleWord(true);
        txtDescricaoDisciplina.setFont(new Font("Century Gothic", Font.PLAIN, 12));

        JScrollPane scrollPaneDescricaoDisciplina = new JScrollPane(txtDescricaoDisciplina);
        scrollPaneDescricaoDisciplina.setBounds(230, 249, 640, 100);
        add(scrollPaneDescricaoDisciplina);

        btnSalvarDisciplina = new JButton("Salvar");
        btnSalvarDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSalvarDisciplina.setBounds(512, 396, 96, 25);
        btnSalvarDisciplina.addActionListener(e ->{
            System.out.println(getTxtNomeDisciplina().getText() + " " + getFormattedtxtCargaHoraria().getText() +  " " + getTxtDescricaoDisciplina().getText());
            String nome = getTxtNomeDisciplina().getText();
            String cargaHoraria = getFormattedtxtCargaHoraria().getText();
            String descricao = getTxtDescricaoDisciplina().getText();
            salvarDisciplina(nome, cargaHoraria, descricao);
        });
        add(btnSalvarDisciplina);
    }

    // ============================
    //        GETTERS & SETTERS
    // ============================

    public JTextField getTxtNomeDisciplina() {
        return txtNomeDisciplina;
    }

    public void setTxtNomeDisciplina(JTextField txtNomeDisciplina) {
        this.txtNomeDisciplina = txtNomeDisciplina;
    }

    public JFormattedTextField getFormattedtxtCargaHoraria() {
        return formattedtxtCargaHoraria;
    }

    public void setFormattedtxtCargaHoraria(JFormattedTextField formattedtxtCargaHoraria) {
        this.formattedtxtCargaHoraria = formattedtxtCargaHoraria;
    }

    public JTextArea getTxtDescricaoDisciplina() {
        return txtDescricaoDisciplina;
    }

    public void setTxtDescricaoDisciplina(JTextArea txtDescricaoDisciplina) {
        this.txtDescricaoDisciplina = txtDescricaoDisciplina;
    }

    public JButton getBtnSalvarDisciplina() {
        return btnSalvarDisciplina;
    }

    public void setBtnSalvarDisciplina(JButton btnSalvarDisciplina) {
        this.btnSalvarDisciplina = btnSalvarDisciplina;
    }

    public void salvarDisciplina(String nome, String cargaHoraria, String descricao){
        Disciplina nova_disciplina = new Disciplina();
        nova_disciplina.setNome(nome.trim());
        nova_disciplina.setCargaHoraria(Integer.parseInt(cargaHoraria.trim()));
        nova_disciplina.setDescricao(descricao.trim());
        String codigo = Services.criarCodigoDisciplina();
        nova_disciplina.setCodigo(codigo);
        DisciplinaDAO.criarDisciplina(nova_disciplina);
        JOptionPane.showMessageDialog(null, "Disciplina criada com sucesso!", "Disciplina criada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
}
