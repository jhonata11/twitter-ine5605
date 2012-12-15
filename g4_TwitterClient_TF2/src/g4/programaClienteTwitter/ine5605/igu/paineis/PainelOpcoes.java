package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAmigos;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorTimeline;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.TwitterException;


/**
 * 
 * Painel onde estao as ferramentas que o usuario tem
 *
 */

public class PainelOpcoes extends Painel {

	private static final long serialVersionUID = 1L;
	private static final String logoAtualizar =  "http://i50.tinypic.com/sxggo5.png";
	private static final String logoFollow = "http://i46.tinypic.com/2eg5i88.jpg";
	private static final String logoUnfollow = "http://i47.tinypic.com/wak3li.png";
	private static final String logoPesquisa = "http://i47.tinypic.com/24q4mrl.png";

	JButton btAtualizaTimeline;
	JButton btFollow;
	JButton btUnfollow;
	JButton btPesquisa;
	JTextField campoDePesquisa;


	GerenciadorAmigos gerenciadorAmigos;
	GerenciadorAutentitcacao gerenciadorAutentiticacao;
	GerenciadorTimeline gerenciadorTimeline;

	GroupLayout gl = new GroupLayout(this);
	JPanel painelPesquisa = new JPanel(new FlowLayout());


	public PainelOpcoes(GerenciadorAutentitcacao gerenciadorAutenticacao, GerenciadorAmigos gerenciadorAmigos,
			GerenciadorTimeline gerenciadorTimeline) {

		this.gerenciadorAmigos = gerenciadorAmigos;
		this.gerenciadorAutentiticacao = gerenciadorAutenticacao;
		this.gerenciadorTimeline = gerenciadorTimeline;


		this.setBackground(Color.BLACK);
		this.setSize(30,30);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		this.definaComponentes();
		this.posicioneComponentes();
	}


	@Override
	protected void posicioneComponentes() {


		this.add(btAtualizaTimeline);
		this.add(btFollow);
		this.add(btUnfollow);
		this.add(painelPesquisa);



	}


	@Override
	protected void definaComponentes() {
		try {
			btAtualizaTimeline = new JButton(new ImageIcon(new URL(logoAtualizar)));
		} catch (MalformedURLException e) {	}
		btAtualizaTimeline.setBackground(Color.BLACK);
		btAtualizaTimeline.addActionListener(this);


		try {
			btFollow = new JButton(new ImageIcon(new URL(logoFollow)));
		} catch (MalformedURLException e) {	}
		btFollow.setBackground(Color.BLACK);
		btFollow.addActionListener(this);

		try {
			btUnfollow = new JButton(new ImageIcon(new URL(logoUnfollow)));
		} catch (MalformedURLException e) {	}
		btUnfollow.setBackground(Color.BLACK);
		btUnfollow.addActionListener(this);


		campoDePesquisa = new JTextField(5);
		try {
			btPesquisa = new JButton(new ImageIcon(new URL(logoPesquisa)));
		} catch (MalformedURLException e) {}
		btPesquisa.setBackground(Color.BLACK);
		btPesquisa.addActionListener(this);


		painelPesquisa.setBackground(Color.BLACK);
		painelPesquisa.add(campoDePesquisa);
		painelPesquisa.add(btPesquisa);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAtualizaTimeline){

			try {
				gerenciadorTimeline.clearTimeline();
				gerenciadorTimeline.getTimeLine();
			} catch (TwitterException e1) {}
		}	



		else if(e.getSource() == btFollow) {


			String usuario = JOptionPane.showInputDialog(null, "Insira um nome: Ex: @usuario", "Seguir Usuário",
					JOptionPane.PLAIN_MESSAGE);
			
			if (usuario.length() == 0)
				JOptionPane.showMessageDialog(this, "você deve digitar algo no campo");

			
			try {
				gerenciadorAmigos.seguirAlguem(usuario);
			} catch (TwitterException e1) {
				JOptionPane.showMessageDialog(this,"ocorreu um erro, e você não pôde seguir " + usuario +
						", verifique a ortografia." );
			}

			JOptionPane.showMessageDialog(this, "Sucesso! você está seguindo" + usuario +  " agora. =)");

		}



		else if (e.getSource() == btUnfollow){



			String usuario = JOptionPane.showInputDialog(null, "Insira um nome: Ex: @usuario", "Deixar de seguir Usuário", 
					JOptionPane.PLAIN_MESSAGE);
			try {
				gerenciadorAmigos.deixarDeSeguirAlguem(usuario);
			} catch (TwitterException e1) {
				JOptionPane.showMessageDialog(this,"ocorreu um erro, e você não pôde deixar de seguir " + usuario +
						", verifique a ortografia." );

			}

			JOptionPane.showMessageDialog(this, "Você não está mais segundo " + usuario + " =(");
		}

		else if(e.getSource() == btPesquisa){
			gerenciadorTimeline.clearTimeline();

			try {
				gerenciadorTimeline.searchTweets(campoDePesquisa.getText());
			} catch (TwitterException e1) {}
		}



	}

}
