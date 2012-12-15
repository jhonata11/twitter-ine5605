package g4.programaClienteTwitter.ine5605.igu;


import g4.programaClienteTwitter.ine5605.igu.paineis.PainelPrincipalAjuda;

import java.awt.Color;

import javax.swing.JDialog;

public class JanelaAjuda extends JDialog {

	private static final long serialVersionUID = 1L;
	private PainelPrincipalAjuda principalPainel = new PainelPrincipalAjuda();
	
	public JanelaAjuda(){
		this.setBackground(Color.white);
		this.setTitle("Ajuda");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(principalPainel);
		this.setModal(true);
	}
	public void interaja() {
		this.setVisible(true);		
	}

}