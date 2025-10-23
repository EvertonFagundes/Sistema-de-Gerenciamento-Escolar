package visao;

import javax.swing.JFrame;

// O nome da classe foi alterado aqui
public class JanelaLogin extends JFrame {

	/**
	 * Método main: o ponto de partida do programa.
	 */
	public static void main(String[] args) {
		// E aqui
		JanelaLogin janela = new JanelaLogin();
		janela.setVisible(true);
	}

	/**
	 * Construtor da janela. O nome também foi alterado aqui.
	 */
	public JanelaLogin() {
		// --- Configurações da Janela ---
		setTitle("Login - Sistema Colégio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);

		// --- Adiciona o painel de login na tela ---
		PainelLogin painelDeLogin = new PainelLogin();
		add(painelDeLogin);
	}
}