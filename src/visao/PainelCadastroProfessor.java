package visao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

import modelo.Professor;
import dao.ProfessorDAO;
import dao.Services;

public class PainelCadastroProfessor extends JPanel {

    private static final long serialVersionUID = 1L;

    // Campos de texto
    private JTextField campoNome;
    private JTextField campoRua;
    private JTextField campoBairro;
    private JTextField campoEmail;
    private JTextField campoCidade;
    private JTextField campoComplemento;
    private JTextField campoFormacaoAcademica;
    private JTextField campoDisciplinas;

    // Campos formatados
    private JFormattedTextField campoDataNascimento;
    private JFormattedTextField campoCpf;
    private JFormattedTextField campoRg;
    private JFormattedTextField campoCep;
    private JFormattedTextField campoTelefone;
    private JFormattedTextField campoNumeroCasa;

    // Botões
    private JButton botaoSalvar;

    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    public PainelCadastroProfessor() {
        configurarPainel();
        inicializarLabels();
        inicializarCampos();
        inicializarBotoes();
    }

    // ------------------------------------------------------
    // CONFIGURAÇÕES BÁSICAS DO PAINEL
    // ------------------------------------------------------
    private void configurarPainel() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);
    }

    // ------------------------------------------------------
    // LABELS
    // ------------------------------------------------------
    private void inicializarLabels() {
        JLabel titulo = criarLabel("CADASTRO DE PROFESSORES", 450, 93, 250, 30, 15);
        add(titulo);

        add(criarLabel("Nome completo:", 99, 179, 100, 18));
        add(criarLabel("Data de Nascimento:", 415, 182, 124, 12));
        add(criarLabel("CPF:", 638, 182, 25, 12));
        add(criarLabel("RG:", 806, 182, 25, 12));

        add(criarLabel("Rua:", 143, 250, 34, 12));
        add(criarLabel("Bairro:", 305, 250, 44, 12));
        add(criarLabel("Número:", 450, 250, 62, 12));
        add(criarLabel("Cidade:", 541, 250, 58, 12));
        add(criarLabel("Complemento:", 711, 247, 100, 18));

        add(criarLabel("Telefone:", 120, 314, 58, 12));
        add(criarLabel("E-mail:", 305, 314, 44, 12));
        add(criarLabel("Formação Acadêmica:", 520, 314, 140, 12));

        //add(criarLabel("Disciplinas que leciona:", 290, 376, 160, 18));
    }

    // ------------------------------------------------------
    // CAMPOS DE ENTRADA
    // ------------------------------------------------------
    private void inicializarCampos() {
        // Primeira linha
        campoNome = criarCampoTexto(209, 182, 199, 18);
        campoDataNascimento = criarCampoFormatado("##/##/####", 549, 180, 69, 18);
        campoCpf = criarCampoFormatado("###.###.###-##", 673, 180, 96, 18);
        campoRg = criarCampoFormatado("##.###.###-##", 831, 180, 100, 18);

        // Endereço
        campoRua = criarCampoTexto(171, 248, 124, 18);
        campoBairro = criarCampoTexto(344, 248, 96, 18);
        campoNumeroCasa = criarCampoFormatado("###", 508, 248, 24, 18);
        campoCidade = criarCampoTexto(597, 248, 96, 18);
        campoComplemento = criarCampoTexto(806, 248, 153, 18);

        // Contato
        campoTelefone = criarCampoFormatado("(##) #####-####", 185, 312, 100, 18);
        campoEmail = criarCampoTexto(350, 312, 153, 18);

        // Acadêmico
        campoFormacaoAcademica = criarCampoTexto(665, 312, 250, 18);
        //campoDisciplinas = criarCampoTexto(431, 377, 400, 18);
    }

    // ------------------------------------------------------
    // BOTÕES
    // ------------------------------------------------------
    private void inicializarBotoes() {
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        botaoSalvar.setBounds(508, 461, 96, 25);
        add(botaoSalvar);

        botaoSalvar.addActionListener(e -> salvarProfessor());
    }

    // ------------------------------------------------------
    // MÉTODOS DE AJUDA
    // ------------------------------------------------------
    private JLabel criarLabel(String texto, int x, int y, int largura, int altura) {
        return criarLabel(texto, x, y, largura, altura, 12);
    }

    private JLabel criarLabel(String texto, int x, int y, int largura, int altura, int tamanhoFonte) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Century Gothic", Font.BOLD, tamanhoFonte));
        label.setBounds(x, y, largura, altura);
        return label;
    }

    private JTextField criarCampoTexto(int x, int y, int largura, int altura) {
        JTextField campo = new JTextField();
        campo.setBounds(x, y, largura, altura);
        add(campo);
        return campo;
    }

    private JFormattedTextField criarCampoFormatado(String mascara, int x, int y, int largura, int altura) {
        JFormattedTextField campo = null;
        try {
            campo = new JFormattedTextField(new MaskFormatter(mascara));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (campo != null) {
            campo.setBounds(x, y, largura, altura);
            add(campo);
        }
        return campo;
    }

    // ------------------------------------------------------
    // SALVAR PROFESSOR
    // ------------------------------------------------------
    private void salvarProfessor() {
        try {
            ProfessorDAO professorDAO = new ProfessorDAO();
            ArrayList <Professor> arrayProfessores = professorDAO.getProfessores();
            boolean cpfIgual = false;
            boolean rgIgual = false;

            String nome = campoNome.getText();
            String dataNasc = campoDataNascimento.getText();
            String cpf = campoCpf.getText();
            String rg = campoRg.getText();
            String rua = campoRua.getText();
            String bairro = campoBairro.getText();
            String numero = campoNumeroCasa.getText();
            String cidade = campoCidade.getText();
            String complemento = campoComplemento.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();
            String formacao = campoFormacaoAcademica.getText();
            //String disciplina = campoDisciplinas.getText();

            String[] dataSplit = dataNasc.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);
            //verificar se existe algum cpf e/ou rg igual
            for(Professor p : arrayProfessores){
                if(p.getCpf().equals(cpf)){
                    cpfIgual = true;
                }if(p.getRg().equals(rg)){
                    rgIgual = true;
                }
            }

            if(cpfIgual || rgIgual){
                JOptionPane.showMessageDialog(null, "Já existe professor com essas credenciais", "Credenciais inválidas", JOptionPane.ERROR_MESSAGE);
            }else{
                Professor professor = new Professor(
                    nome, cpf, rg, "", email,
                    dia, mes, ano, rua, bairro, cidade,
                    Integer.parseInt(numero), complemento, telefone,
                    "senhaPadrao", formacao 
                );

                //ProfessorDAO professorDAO = new ProfessorDAO();
                professorDAO.cadastrarProfessor(professor);

                JOptionPane.showMessageDialog(this, "Professor cadastrado com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar professor: " + ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    // ------------------------------------------------------
    // GETTERS PÚBLICOS
    // ------------------------------------------------------
    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoEmail() {
        return campoEmail;
    }
}
