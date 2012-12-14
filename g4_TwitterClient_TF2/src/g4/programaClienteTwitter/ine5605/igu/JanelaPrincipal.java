package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.igu.paineis.PainelEntrada;
import g4.programaClienteTwitter.ine5605.igu.paineis.PainelTweet;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAmigos;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorTimeline;

import java.awt.Dimension;
import javax.swing.JFrame;



public class JanelaPrincipal extends JFrame {

	static final long serialVersionUID = 1L;
	GerenciadorAutentitcacao gerenciadorAutenticacao;
	GerenciadorAmigos gerenciadorAmigos;
	GerenciadorTimeline gerenciadorTimeline;

	public JanelaPrincipal(GerenciadorAutentitcacao gerenciadorAutenticacao){

		super("Piu!");
		this.gerenciadorAutenticacao = gerenciadorAutenticacao;
		this.gerenciadorAmigos = new GerenciadorAmigos();
		this.gerenciadorTimeline = new GerenciadorTimeline();



		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(278, 508));
		setResizable(true);

		setContentPane(new PainelEntrada(gerenciadorAutenticacao, this));
		setJMenuBar(new BarraDeMenus(new GerenciadorTimeline()));
		pack();
		setLocationRelativeTo(null);
	}


	public void setPainelTweet (){
		//define o painel de tweets na janela principal


		setContentPane(new PainelTweet(gerenciadorAutenticacao));
		setPreferredSize(new Dimension(652, 674));

		pack();
	}


	public void interaja() {
		setVisible(true);
	}

}
