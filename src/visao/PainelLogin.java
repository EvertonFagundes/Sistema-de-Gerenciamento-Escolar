package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PainelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JPasswordField pwdtxtSenha;

	public PainelLogin() {
		setBackground(new Color(145, 196, 195));
		setLayout(new GridBagLayout());

		JPanel painelInterno = new JPanel(new GridBagLayout());
		painelInterno.setBackground(getBackground()); 

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15); 

		JLabel lblSistemaColégio = new JLabel("Sistema - Colégio");
		lblSistemaColégio.setFont(new Font("Century Gothic", Font.BOLD, 20));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		painelInterno.add(lblSistemaColégio, gbc);

		JLabel lblRealizeLogin = new JLabel("Realize o seu login");
		lblRealizeLogin.setFont(new Font("Century Gothic", Font.BOLD, 16));
		gbc.gridy = 1;
		painelInterno.add(lblRealizeLogin, gbc);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 14));
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		painelInterno.add(lblEmail, gbc);

		txtEmail = new JTextField(20);
		txtEmail.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		painelInterno.add(txtEmail, gbc);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 14));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		painelInterno.add(lblSenha, gbc);

		pwdtxtSenha = new JPasswordField(20);
		pwdtxtSenha.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		painelInterno.add(pwdtxtSenha, gbc);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		painelInterno.add(btnEntrar, gbc);

		add(painelInterno);
	}
}