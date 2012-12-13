package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import twitter4j.TwitterException;

public class PainelOpcoes extends Painel {

	private static final long serialVersionUID = 1L;
	private static final String logoAtualizar =  "http://i50.tinypic.com/sxggo5.png";
	private static final String logoFollow = "http://i46.tinypic.com/2eg5i88.jpg";
	private static final String logoUnfollow = "http://i47.tinypic.com/wak3li.png";
	
	JButton btAtualizaTimeline;
	JButton btFollow;
	JButton btUnfollow;

	GroupLayout gl = new GroupLayout(this);
	
	public PainelOpcoes(GerenciadorTwitter gerenciador) {
		gerenciadorTwitter = gerenciador;		
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

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == btAtualizaTimeline){

			try {
				gerenciadorTwitter.clearTimeline();
				gerenciadorTwitter.getTimeLine();
			} catch (TwitterException e1) {}
		}	
		 
		 
		 
		 else if(e.getSource() == btFollow) {
			if (gerenciadorTwitter.logado != true)
				JOptionPane.showMessageDialog(this,"você precisa estar logado para poder seguir alguém");
			
			else{			
				String usuario = JOptionPane.showInputDialog(null, "Insira um nome: Ex: @usuario", "Seguir Usuário",
						JOptionPane.PLAIN_MESSAGE);
				try {
					gerenciadorTwitter.seguirAlguem(usuario);
				} catch (TwitterException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this,"ocorreu um erro, e você não pôde seguir" + usuario +
							", verifique a ortografia." );
				}
			}

			
		}
		 
		 
		 
		 else if (e.getSource() == btUnfollow){
			 if (gerenciadorTwitter.logado != true)
					JOptionPane.showMessageDialog(this,"você precisa estar logado para poder deixar de seguir alguém");
				
				else{			
					String usuario = JOptionPane.showInputDialog(null, "Insira um nome: Ex: @usuario", "Deixar de seguir Usuário", 
							JOptionPane.PLAIN_MESSAGE);
					try {
						gerenciadorTwitter.deixarDeSeguirAlguem(usuario);
					} catch (TwitterException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(this,"ocorreu um erro, e você não pôde deixar de seguir" + usuario +
								", verifique a ortografia." );
					}
				}
		 }



	}

}
