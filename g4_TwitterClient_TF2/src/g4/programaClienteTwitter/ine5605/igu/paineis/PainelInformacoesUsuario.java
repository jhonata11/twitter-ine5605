package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAmigos;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorTimeline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import twitter4j.TwitterException;


/**
 * 
 * Painel onde estao contidas as informacoes do usuario.
 *
 */

public class PainelInformacoesUsuario extends Painel {
	private static final long serialVersionUID = 1L;

	private static final Color COR_DA_FONTE = new Color(238, 233, 233);

	GerenciadorAmigos gerenciadorAmigos;
	GerenciadorTimeline gerenciadorTimeline;


	JLabel btSeguidores;
	JLabel btAmigos;

	public PainelInformacoesUsuario (GerenciadorAmigos gerenciador) {
		gerenciadorAmigos = gerenciador;


		this.setBackground(Color.BLACK);
		this.setSize(30,30);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		this.definaComponentes();
		this.posicioneComponentes();
	}

	@Override
	protected void definaComponentes() {

		try {
			btSeguidores = new JLabel("S: " + gerenciadorAmigos.getNumeroSeguidores());
		} catch (TwitterException e) {}
		btSeguidores.setForeground(COR_DA_FONTE);
		btSeguidores.setBackground(Color.BLACK);
		btSeguidores.setSize(new Dimension(30, 21));




		try {
			btAmigos = new JLabel("A: " + gerenciadorAmigos.getNumeroAmigos());
		} catch (TwitterException e) {}
		btAmigos.setForeground(COR_DA_FONTE);
		btAmigos.setBackground(Color.BLACK);
		btSeguidores.setSize(new Dimension(30, 21));



	}

	@Override
	protected void posicioneComponentes() {
		this.add(btSeguidores);
		this.add(btAmigos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//nada nesta versão do programa;
	}

}
