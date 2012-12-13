package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.igu.paineis.PainelEntrada;
import g4.programaClienteTwitter.ine5605.igu.paineis.PainelTweet;
import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.Dimension;
import javax.swing.JFrame;



public class JanelaPrincipal extends JFrame {
	
 static final long serialVersionUID = 1L;
	GerenciadorTwitter gerenciadorTwiter;

	public JanelaPrincipal(GerenciadorTwitter gerenciadorT){
		
		super("Piu!");
		this.gerenciadorTwiter = gerenciadorT;
		
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(278, 508));
		setResizable(true);
		
		setContentPane(new PainelEntrada(gerenciadorT, this));
		setJMenuBar(new BarraDeMenus(gerenciadorT));
		pack();
		setLocationRelativeTo(null);
}

	
	public void setPainelTweet (){
		//define o painel de tweets na janela principal
		
		
		setContentPane(new PainelTweet(gerenciadorTwiter));
		setPreferredSize(new Dimension(493, 667));
		
		pack();
	}
	
	
	public void interaja() {
		setVisible(true);
	}
	
}
