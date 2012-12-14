package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.igu.JanelaPrincipal;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Painel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public JanelaPrincipal janela;
	public GerenciadorAutentitcacao gerenciadorAutentitcacao;
	
	

	
	protected abstract void definaComponentes();
	protected abstract void posicioneComponentes();
	
	public abstract void actionPerformed(ActionEvent e);

}
