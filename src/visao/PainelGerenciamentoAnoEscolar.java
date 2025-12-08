package visao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import dao.AnoEscolarDAO;
import modelo.AnoEscolar;
import modelo.PeriodoLetivo;

public class PainelGerenciamentoAnoEscolar extends JPanel {

    private JList<String> listaAnos;
    private DefaultListModel<String> modeloLista;

    private JTextField txtAno;
    private JTextField txtPeriodos;
    private JLabel lblCodigo;
    private JLabel lblSituacao;

    private ArrayList<AnoEscolar> listaObjetos;

    public PainelGerenciamentoAnoEscolar() {

        setLayout(null);
        setBackground(new Color(180, 210, 210));

        JLabel lblTitulo = new JLabel("Gerenciamento de Ano Escolar");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(280, 20, 350, 30);
        add(lblTitulo);

        // Lista à esquerda
        modeloLista = new DefaultListModel<>();
        listaAnos = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaAnos);
        scroll.setBounds(40, 80, 200, 350);
        add(scroll);

        listaAnos.addListSelectionListener(e -> mostrarDadosSelecionado());

        // Área de edição à direita
        JLabel lblAno = new JLabel("Ano:");
        lblAno.setBounds(280, 100, 100, 20);
        add(lblAno);

        txtAno = new JTextField();
        txtAno.setBounds(350, 100, 120, 25);
        add(txtAno);

        JLabel lblCod = new JLabel("Código:");
        lblCod.setBounds(280, 140, 100, 20);
        add(lblCod);

        lblCodigo = new JLabel("-");
        lblCodigo.setBounds(350, 140, 200, 20);
        add(lblCodigo);

        JLabel lblPer = new JLabel("Períodos (vírgula):");
        lblPer.setBounds(280, 180, 150, 20);
        add(lblPer);

        txtPeriodos = new JTextField();
        txtPeriodos.setBounds(280, 205, 300, 25);
        add(txtPeriodos);

        JLabel lblSit = new JLabel("Situação:");
        lblSit.setBounds(280, 245, 100, 20);
        add(lblSit);

        lblSituacao = new JLabel("-");
        lblSituacao.setBounds(350, 245, 150, 20);
        add(lblSituacao);

        // Botões
        JButton btnSalvar = new JButton("Salvar alterações");
        btnSalvar.setBounds(280, 300, 150, 30);
        btnSalvar.addActionListener(e -> salvarAlteracoes());
        add(btnSalvar);

        JButton btnAtivarDesativar = new JButton("Ativar/Desativar");
        btnAtivarDesativar.setBounds(450, 300, 150, 30);
        btnAtivarDesativar.addActionListener(e -> alterarSituacao());
        add(btnAtivarDesativar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(350, 350, 120, 30);
        btnExcluir.addActionListener(e -> excluir());
        add(btnExcluir);

        carregarLista();
    }

    private void carregarLista() {
        modeloLista.clear();
        listaObjetos = AnoEscolarDAO.listarTodos();

        for (AnoEscolar a : listaObjetos) {
            modeloLista.addElement(a.getAno() + " (" + a.getCodigo() + ")");
        }
    }

    private void mostrarDadosSelecionado() {
        int idx = listaAnos.getSelectedIndex();
        if (idx == -1) return;

        AnoEscolar a = listaObjetos.get(idx);

        txtAno.setText(String.valueOf(a.getAno()));
        lblCodigo.setText(a.getCodigo());

        StringBuilder sb = new StringBuilder();
        for (PeriodoLetivo p : a.getPeriodoLetivo()) {
            sb.append(p.getNome()).append(", ");
        }
        if (sb.length() >= 2) sb.setLength(sb.length() - 2);

        txtPeriodos.setText(sb.toString());

        lblSituacao.setText(a.getSituacao() ? "Ativo" : "Inativo");
    }

    private void salvarAlteracoes() {
        int idx = listaAnos.getSelectedIndex();
        if (idx == -1) return;

        AnoEscolar a = listaObjetos.get(idx);

        try {
            a.setAno(Integer.parseInt(txtAno.getText()));

            String[] partes = txtPeriodos.getText().split(",");
            ArrayList<PeriodoLetivo> periodos = new ArrayList<>();
            for (String nome : partes) {
                if (!nome.trim().isEmpty())
                    periodos.add(new PeriodoLetivo(nome.trim()));
            }
            a.setPeriodoLetivo(periodos);

            AnoEscolarDAO.atualizarAnoEscolar(a);

            carregarLista();
            listaAnos.setSelectedIndex(idx);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar.");
        }
    }

    private void alterarSituacao() {
        int idx = listaAnos.getSelectedIndex();
        if (idx == -1) return;

        AnoEscolar a = listaObjetos.get(idx);

        a.setSituacao(!a.getSituacao());
        AnoEscolarDAO.atualizarAnoEscolar(a);

        mostrarDadosSelecionado();
    }

    private void excluir() {
        int idx = listaAnos.getSelectedIndex();
        if (idx == -1) return;

        AnoEscolar a = listaObjetos.get(idx);

        int opc = JOptionPane.showConfirmDialog(null,
                "Excluir este ano escolar?", "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (opc == JOptionPane.YES_OPTION) {
            AnoEscolarDAO.excluirAnoEscolar(a.getCodigo());
            carregarLista();
        }
    }
}
