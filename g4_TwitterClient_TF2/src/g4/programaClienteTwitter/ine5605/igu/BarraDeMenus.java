package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorTimeline;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraDeMenus extends JMenuBar implements ActionListener{

	/**
	 * Classe responsavel pela barra de menus, presente na janela principal.
	 * 
	 */

	private static final long serialVersionUID = 1L;
	JMenu menu;

	JMenuItem sobre;
	JMenuItem ajuda1;
	JMenuItem ajuda2;
	JMenuItem ajuda3;




	GerenciadorTimeline gerenciadorTimeline;


	public BarraDeMenus (GerenciadorTimeline gerenciadorTimeline) {

		this.gerenciadorTimeline = gerenciadorTimeline;


		menu = new JMenu("Menu");
		sobre = new JMenuItem("Sobre Piu!");
		sobre.addActionListener(this);

		ajuda1 = new JMenuItem("TF1");
		ajuda1.addActionListener(this);

		ajuda2 = new JMenuItem("TF2");
		ajuda2.addActionListener(this);

		ajuda3 = new JMenuItem("TF3");
		ajuda3.addActionListener(this);


		menu.add(ajuda1);
		menu.add(ajuda2);
		menu.add(ajuda3);

		menu.add(sobre);




		this.add(menu);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JanelaAjuda ja = new JanelaAjuda();


		if (e.getSource() == ajuda1){
			ja.setTF1();
			ja.interaja();

		}

		else if (e.getSource() == ajuda2){
			ja.setTF2();
			ja.interaja();

		}

		else if (e.getSource() == ajuda3){
			ja.setTF3();
			ja.interaja();
		}
		
		else if (e.getSource() == sobre){
			ja.setpainelSobre();
			ja.interaja();
		}
		
		
	}


}
