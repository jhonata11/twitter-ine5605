package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.Dimension;
import javax.swing.JFrame;



public class JanelaPrincipal extends JFrame {
	
	GerenciadorTwitter gerenciadorT;

	public JanelaPrincipal(GerenciadorTwitter gerenciadorT){
		
		super("Piu!");
		this.gerenciadorT = gerenciadorT;
		
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(278, 508));

		setContentPane(new PainelEntrada(gerenciadorT, this));
		
		setJMenuBar(new BarraDeMenus(gerenciadorT));
		pack();
		setLocationRelativeTo(null);
}

	
	public void setPainelTweet (){
		//define o painel de tweets na janela principal
		
		
		setContentPane(new PainelTweet(gerenciadorT));
		setPreferredSize(new Dimension(500, 400));
		pack();
	}
	
	
	public void interaja() {
		setVisible(true);
	}
	
}
