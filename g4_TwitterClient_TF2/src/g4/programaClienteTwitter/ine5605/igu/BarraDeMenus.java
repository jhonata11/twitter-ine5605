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

	private static final long serialVersionUID = 1L;
	JMenu menu;
	JMenuItem ajudaTF1;
	JMenuItem ajudaTF2;
	JMenuItem pesquisar;

	GerenciadorTwitter gerenciadorT;

	
	public BarraDeMenus (GerenciadorTwitter gt) {
		
		gerenciadorT = gt;

		
		menu = new JMenu("Menu");
		
		pesquisar = new JMenuItem("Pesquisar Tweets");
		pesquisar.addActionListener(this);
		
		ajudaTF1 = new JMenuItem("ajudaTF1");
		ajudaTF1.addActionListener(this);
		
		ajudaTF2 = new JMenuItem("ajudaTF2");
		ajudaTF2.addActionListener(this);

		menu.add(pesquisar);
		menu.add(ajudaTF1);
		menu.add(ajudaTF2);
				
		add(menu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajudaTF1){
			JOptionPane.showMessageDialog(this,
					"Instruções: \n" +
					"-Clique em GERAR CÓDIGO para gerar um código de ativação. \n " +
					"-Insira o código gerado no campo de texto, e clique em CONFIRMA \n " +
					"\n " +
					"-Digite uma mensagem com menos de 140 caracteres e clique em Tweetar.");
		}
		else if (e.getSource() == ajudaTF2){
			JOptionPane.showMessageDialog(this, "Instruções TF2 : \n"+ 
					" - Atualizar Timeline - Clique no botão atualizar timeline para ela atualizar. \n"+
					" - Adicionar Pessoa - Digite um usuário para seguir, não esqueça de colocar o @. \n"+
					" - Pesquisar por tweets - Insira um termo para ser pesquisado.");
		}
		
	
		else if (e.getSource() == pesquisar){
			if (gerenciadorT.logado != true)
				JOptionPane.showMessageDialog(this,"você precisa estar logado para fazer uma pesquisa");

			else{
				String pesquisa = JOptionPane.showInputDialog(null, "Insira o termo a ser pesquisado",
						"Pesquisar Tweets", JOptionPane.PLAIN_MESSAGE);
				gerenciadorT.getModel().clear();
				try {
					gerenciadorT.searchTweets(pesquisa);
				} catch (TwitterException e1) {}
			}

		}
	}

}
