package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorTimeline;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class BarraDeMenus extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;
	JMenu menu;
	JMenuItem ajudaTF1;
	JMenuItem ajudaTF2;

	GerenciadorTimeline gerenciadorTimeline;

	
	public BarraDeMenus (GerenciadorTimeline gerenciadorTimeline) {
		
		this.gerenciadorTimeline = gerenciadorTimeline;

		
		menu = new JMenu("Menu");
		

		
		ajudaTF1 = new JMenuItem("ajudaTF1");
		ajudaTF1.addActionListener(this);
		
		ajudaTF2 = new JMenuItem("ajudaTF2");
		ajudaTF2.addActionListener(this);

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
	
	}

}
