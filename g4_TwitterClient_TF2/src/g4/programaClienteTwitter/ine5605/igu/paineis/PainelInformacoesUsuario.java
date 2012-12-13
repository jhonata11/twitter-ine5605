package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import twitter4j.TwitterException;

public class PainelInformacoesUsuario extends Painel {
	private static final long serialVersionUID = 1L;
	
	private static final Color COR_DA_FONTE = new Color(238, 233, 233);


	JButton btSeguidores;
	JButton btAmigos;

	public PainelInformacoesUsuario (GerenciadorTwitter gerenciador) {
		gerenciadorTwitter = gerenciador;		
		this.setBackground(Color.BLACK);
		this.setSize(30,30);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		this.definaComponentes();
		this.posicioneComponentes();
	}

	@Override
	protected void definaComponentes() {
		
		try {
			btSeguidores = new JButton("S: " + gerenciadorTwitter.getNumeroSeguidores());
		} catch (TwitterException e) {}
		btSeguidores.setForeground(COR_DA_FONTE);
		btSeguidores.setBackground(Color.BLACK);
		btSeguidores.setPreferredSize(new Dimension(30, 21));

	
		

		try {
			btAmigos = new JButton("A: " + gerenciadorTwitter.getNumeroSeguidores());
		} catch (TwitterException e) {}
		btAmigos.setForeground(COR_DA_FONTE);
		btAmigos.setBackground(Color.BLACK);
		btSeguidores.setPreferredSize(new Dimension(30, 21));

		
		
	}

	@Override
	protected void posicioneComponentes() {
		this.add(btSeguidores);
		this.add(btAmigos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
