package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import twitter4j.TwitterException;

public class BarraDeMenus extends JMenuBar implements ActionListener{
	JMenu menu;
	JMenuItem instrucoes;
	JMenuItem follow;
	JMenuItem pesquisar;

	GerenciadorTwitter gerenciadorT;

	
	public BarraDeMenus (GerenciadorTwitter gt) {
		
		gerenciadorT = gt;

		
		menu = new JMenu("Menu");
		
		follow = new JMenuItem("seguir alguem");
		follow.addActionListener(this);
		
		pesquisar = new JMenuItem("Pesquisar Tweets");
		pesquisar.addActionListener(this);
		
		instrucoes = new JMenuItem("Intruções");
		instrucoes.addActionListener(this);
		
		menu.add(follow);
		menu.add(pesquisar);
		menu.add(instrucoes);
				
		add(menu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == instrucoes){
			JOptionPane.showMessageDialog(this,
					"Instruções: \n" +
					"-Clique em GERAR CÓDIGO para gerar um código de ativação. \n " +
					"-Insira o código gerado no campo de texto, e clique em CONFIRMA \n " +
					"\n " +
					"-DIgite uma mensagem com menos de 140 caracteres e clique em Tweetar.");
		}
		
		else if(e.getSource() == follow){
			if (gerenciadorT.logado != true)
				JOptionPane.showMessageDialog(this,"você precisa estar logado para poder seguir alguém");
			
			else{			
				String usuario = JOptionPane.showInputDialog(null, "Insira um nome: Ex: @usuario", "Seguir Usuário", JOptionPane.PLAIN_MESSAGE);
				try {
					gerenciadorT.seguirAlguem(usuario);
				} catch (TwitterException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this,"ocorreu um erro, e você não pôde seguir" + usuario +
							", verifique a ortografia." );
				}
			}

			
		}
		
		else if (e.getSource() == pesquisar){
			if (gerenciadorT.logado != true)
				JOptionPane.showMessageDialog(this,"você precisa estar logado para fazer uma pesquisa");

			else{
				String pesquisa = JOptionPane.showInputDialog(null, "Insira o termo a ser pesquisado",
						"Pesquisar Tweets", JOptionPane.PLAIN_MESSAGE);
				gerenciadorT.getModel().clear();
				gerenciadorT.searchTweets(pesquisa);
			}

		}
	}

}
