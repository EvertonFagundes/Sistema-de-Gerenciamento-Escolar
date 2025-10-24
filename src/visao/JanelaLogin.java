package visao;

import javax.swing.JFrame;

public class JanelaLogin extends JFrame {

	public static void main(String[] args) {
		// E aqui
		JanelaLogin janela = new JanelaLogin();
		janela.setVisible(true);
	}

	public JanelaLogin() {
		setTitle("Login - Sistema Colégio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);

		
		PainelLogin painelDeLogin = new PainelLogin();
		add(painelDeLogin);
	}
}