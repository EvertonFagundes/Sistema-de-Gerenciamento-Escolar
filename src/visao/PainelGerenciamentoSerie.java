package visao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import dao.SerieDAO;
import modelo.Serie;

public class PainelGerenciamentoSerie extends JPanel {

    private JList<String> listaSeries;
    private DefaultListModel<String> modeloLista;

    private JTextField txtNomeSerie;
    private JLabel lblCodigo;
    private JLabel lblSituacao;

    private ArrayList<Serie> listaObjetos;

    public PainelGerenciamentoSerie() {
        setLayout(null);
        setBackground(new Color(145, 196, 195));

        JLabel lblTitulo = new JLabel("Gerenciamento de Séries");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(280, 20, 350, 30);
        add(lblTitulo);

        // Lista à esquerda
        modeloLista = new DefaultListModel<>();
        listaSeries = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaSeries);
        scroll.setBounds(40, 80, 200, 350);
        add(scroll);

        listaSeries.addListSelectionListener(e -> mostrarDadosSelecionado());

        // Área de edição à direita
        JLabel lblNome = new JLabel("Nome da Série:");
        lblNome.setBounds(280, 100, 120, 20);
        add(lblNome);

        txtNomeSerie = new JTextField();
        txtNomeSerie.setBounds(410, 100, 150, 25);
        add(txtNomeSerie);

        JLabel lblCod = new JLabel("Código:");
        lblCod.setBounds(280, 140, 100, 20);
        add(lblCod);

        lblCodigo = new JLabel("-");
        lblCodigo.setBounds(410, 140, 150, 20);
        add(lblCodigo);

        JLabel lblSit = new JLabel("Situação:");
        lblSit.setBounds(280, 180, 100, 20);
        add(lblSit);

        lblSituacao = new JLabel("-");
        lblSituacao.setBounds(410, 180, 150, 20);
        add(lblSituacao);

        // Botões
        JButton btnSalvar = new JButton("Salvar alterações");
        btnSalvar.setBounds(280, 220, 150, 30);
        btnSalvar.addActionListener(e -> salvarAlteracoes());
        add(btnSalvar);

        JButton btnAtivarDesativar = new JButton("Ativar/Desativar");
        btnAtivarDesativar.setBounds(450, 220, 150, 30);
        btnAtivarDesativar.addActionListener(e -> alterarSituacao());
        add(btnAtivarDesativar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(350, 270, 120, 30);
        btnExcluir.addActionListener(e -> excluir());
        add(btnExcluir);

        carregarLista();
    }

    private void carregarLista() {
        modeloLista.clear();
        listaObjetos = SerieDAO.listarSeries();

        for (Serie s : listaObjetos) {
            modeloLista.addElement(s.getNome() + " (" + s.getCodigo() + ")");
        }
    }

    private void mostrarDadosSelecionado() {
        int idx = listaSeries.getSelectedIndex();
        if (idx == -1) return;

        Serie s = listaObjetos.get(idx);

        txtNomeSerie.setText(s.getNome());
        lblCodigo.setText(s.getCodigo());
        lblSituacao.setText(s.getTurmas().isEmpty() ? "Inativo" : "Ativo");
    }

    private void salvarAlteracoes() {
        int idx = listaSeries.getSelectedIndex();
        if (idx == -1) return;

        Serie s = listaObjetos.get(idx);

        try {
            String novoNome = txtNomeSerie.getText().trim();
            if (novoNome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome da série não pode ficar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            s.setNome(novoNome);
            SerieDAO.atualizarSerie(s);

            carregarLista();
            listaSeries.setSelectedIndex(idx);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar alterações: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void alterarSituacao() {
        int idx = listaSeries.getSelectedIndex();
        if (idx == -1) return;

        Serie s = listaObjetos.get(idx);

        boolean ativo = !s.getTurmas().isEmpty(); // ativo se tiver turmas
        if (ativo) {
            s.setTurmas(new ArrayList<>()); // desativa limpando turmas
        } else {
            JOptionPane.showMessageDialog(this, "Para ativar a série, cadastre turmas primeiro.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        SerieDAO.atualizarSerie(s);
        mostrarDadosSelecionado();
    }

    private void excluir() {
        int idx = listaSeries.getSelectedIndex();
        if (idx == -1) return;

        Serie s = listaObjetos.get(idx);

        int opc = JOptionPane.showConfirmDialog(
                this,
                "Excluir esta série?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (opc == JOptionPane.YES_OPTION) {
            boolean excluiu = SerieDAO.excluirSerie(s.getCodigo());
            if (excluiu) {
                JOptionPane.showMessageDialog(this, "Série excluída com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível excluir a série.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            carregarLista();
        }
    }

    
}
