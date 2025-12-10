package visao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import dao.SerieDAO;
import dao.TurmaDAO;
import modelo.Serie;
import modelo.Turma;

public class PainelGerenciamentoTurma extends JPanel {

    private JList<String> listaTurmas;
    private DefaultListModel<String> modeloLista;

    private JComboBox<String> comboSerie;
    private JTextField txtLetra;
    private JLabel lblCodigo;
    private JLabel lblSituacao;

    private ArrayList<Turma> listaObjetos;
    private ArrayList<Serie> listaSeries;

    public PainelGerenciamentoTurma() {
        setLayout(null);
        setBackground(new Color(145, 196, 195));

        JLabel lblTitulo = new JLabel("Gerenciamento de Turmas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(280, 20, 350, 30);
        add(lblTitulo);

        // Lista à esquerda
        modeloLista = new DefaultListModel<>();
        listaTurmas = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaTurmas);
        scroll.setBounds(40, 80, 200, 350);
        add(scroll);

        listaTurmas.addListSelectionListener(e -> mostrarDadosSelecionado());

        // Área de edição à direita
        JLabel lblSerie = new JLabel("Série:");
        lblSerie.setBounds(280, 100, 100, 20);
        add(lblSerie);

        comboSerie = new JComboBox<>();
        comboSerie.setBounds(350, 100, 150, 25);
        add(comboSerie);

        JLabel lblLetra = new JLabel("Letra:");
        lblLetra.setBounds(280, 140, 100, 20);
        add(lblLetra);

        txtLetra = new JTextField();
        txtLetra.setBounds(350, 140, 50, 25);
        add(txtLetra);

        JLabel lblCod = new JLabel("Código:");
        lblCod.setBounds(280, 180, 100, 20);
        add(lblCod);

        lblCodigo = new JLabel("-");
        lblCodigo.setBounds(350, 180, 150, 20);
        add(lblCodigo);

        JLabel lblSit = new JLabel("Situação:");
        lblSit.setBounds(280, 220, 100, 20);
        add(lblSit);

        lblSituacao = new JLabel("-");
        lblSituacao.setBounds(350, 220, 150, 20);
        add(lblSituacao);

        // Botões
        JButton btnSalvar = new JButton("Salvar alterações");
        btnSalvar.setBounds(280, 260, 150, 30);
        btnSalvar.addActionListener(e -> salvarAlteracoes());
        add(btnSalvar);

        JButton btnAtivarDesativar = new JButton("Ativar/Desativar");
        btnAtivarDesativar.setBounds(450, 260, 150, 30);
        btnAtivarDesativar.addActionListener(e -> alterarSituacao());
        add(btnAtivarDesativar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(350, 310, 120, 30);
        btnExcluir.addActionListener(e -> excluir());
        add(btnExcluir);

        carregarSeries();
        carregarLista();
    }

    private void carregarSeries() {
        comboSerie.removeAllItems();
        listaSeries = SerieDAO.listarSeries();
        for (Serie s : listaSeries) {
            comboSerie.addItem(s.getNome());
        }
    }

    private void carregarLista() {
        modeloLista.clear();
        listaObjetos = TurmaDAO.listarTodasTurmas();

        for (Turma t : listaObjetos) {
            String nomeSerie = t.getSerie() != null ? t.getSerie().getNome() : "-";
            modeloLista.addElement(nomeSerie + " - " + t.getIdentificador() + " (" + t.getCodigo() + ")");
        }
    }

    private void mostrarDadosSelecionado() {
        int idx = listaTurmas.getSelectedIndex();
        if (idx == -1) return;

        Turma t = listaObjetos.get(idx);

        txtLetra.setText(t.getIdentificador());
        lblCodigo.setText(t.getCodigo());
        lblSituacao.setText(t.getSituacao() ? "Ativo" : "Inativo");

        if (t.getSerie() != null) {
            comboSerie.setSelectedItem(t.getSerie().getNome());
        }
    }

    private void salvarAlteracoes() {
        int idx = listaTurmas.getSelectedIndex();
        if (idx == -1) return;

        Turma t = listaObjetos.get(idx);

        try {
            String letra = txtLetra.getText().trim();
            if (letra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A letra da turma não pode ficar vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String serieNome = (String) comboSerie.getSelectedItem();
            Serie serieSelecionada = listaSeries.stream()
                    .filter(s -> s.getNome().equals(serieNome))
                    .findFirst()
                    .orElse(null);

            if (serieSelecionada == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma série válida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            t.setIdentificador(letra);
            t.setSerie(serieSelecionada);

            TurmaDAO.sobrescreverArquivoTurma(t);

            carregarLista();
            listaTurmas.setSelectedIndex(idx);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar alterações: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void alterarSituacao() {
        int idx = listaTurmas.getSelectedIndex();
        if (idx == -1) return;

        Turma t = listaObjetos.get(idx);
        t.setSituacao(!t.getSituacao());

        TurmaDAO.sobrescreverArquivoTurma(t);
        mostrarDadosSelecionado();
    }

    private void excluir() {
        int idx = listaTurmas.getSelectedIndex();
        if (idx == -1) return;

        Turma t = listaObjetos.get(idx);

        int anoSelecionado = comboSerie.getSelectedIndex() + 1; // ou getSelectedItem(), dependendo do comboBox

        if (t.getAno() != anoSelecionado) {
            JOptionPane.showMessageDialog(this, 
                "A turma selecionada não corresponde ao ano escolhido no comboBox!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opc = JOptionPane.showConfirmDialog(
                this,
                "Excluir esta turma?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (opc == JOptionPane.YES_OPTION) {
            String numeroSerie = String.valueOf(t.getAno());
            String identificador = t.getIdentificador();

            boolean excluiu = TurmaDAO.excluirTurma(numeroSerie, identificador);

            if (excluiu) {
                JOptionPane.showMessageDialog(this, "Turma excluída com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível excluir a turma.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            carregarLista();
        }
    }





}
