package visao;

import java.awt.Color;
import java.awt.FlowLayout; // Usaremos FlowLayout para centralizar
import java.awt.Font;
import java.awt.GridLayout; // Usaremos GridLayout para os botões
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class PainelPrincipal extends JPanel {

    public PainelPrincipal() {
        setBackground(new Color(145, 196, 195));
        setLayout(null);

        
        JPanel painelDeBotoes = new JPanel();
        painelDeBotoes.setBounds(0, 0, 800, 600);
        painelDeBotoes.setBackground(new Color(145, 196, 195));
        add(painelDeBotoes);
        painelDeBotoes.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Sistema de Gerenciamento Escolar");
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblNewLabel.setBounds(405, 281, 307, 44);
        painelDeBotoes.add(lblNewLabel);
    }
}