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
	JMenuItem ajuda;

	GerenciadorTimeline gerenciadorTimeline;


	public BarraDeMenus (GerenciadorTimeline gerenciadorTimeline) {

		this.gerenciadorTimeline = gerenciadorTimeline;


		menu = new JMenu("Menu");
		ajuda = new JMenuItem("Ajuda");
		ajuda.addActionListener(this);

		menu.add(ajuda);



		this.add(menu);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajuda){
			JanelaAjuda ja = new JanelaAjuda();
			ja.interaja();
		}
	}


}
