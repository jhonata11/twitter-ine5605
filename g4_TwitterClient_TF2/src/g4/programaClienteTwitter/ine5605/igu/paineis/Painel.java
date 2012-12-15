package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.igu.JanelaPrincipal;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Painel extends JPanel implements ActionListener{

	/**
	 * 
	 * Classe que define os mais diferentes paineis. 
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	public JanelaPrincipal janela;
	public GerenciadorAutentitcacao gerenciadorAutentitcacao;
	
	

	/**
	 * Metodo que define os componentes que serao aplicados a cada painel
	 */
	protected abstract void definaComponentes();
	
	/**
	 * metodo que posiciona os componentes em cada painel
	 */
	protected abstract void posicioneComponentes();
	
	
	/**
	 * acao que o computador deve tomar caso o haja um clique.
	 */
	public abstract void actionPerformed(ActionEvent e);

}
