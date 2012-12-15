package g4.programaClienteTwitter.ine5605.igu;


import g4.programaClienteTwitter.ine5605.igu.paineis.PainelPrincipalAjuda;

import java.awt.Color;

import javax.swing.JDialog;

public class JanelaAjuda extends JDialog {

	private static final long serialVersionUID = 1L;

	PainelPrincipalAjuda painelPrincipalAjuda;

	public JanelaAjuda(){
		this.setBackground(Color.white);
		this.setTitle("Ajuda");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setModal(true);
	}
	public void interaja() {
		this.setVisible(true);		
	}


	public void setTF1(){
		painelPrincipalAjuda = new PainelPrincipalAjuda("TF1");
		this.setContentPane(painelPrincipalAjuda);
	}
	
	public void setTF2(){
		painelPrincipalAjuda = new PainelPrincipalAjuda("TF2");
		this.setContentPane(painelPrincipalAjuda);
	}
	
	public void setTF3(){
		painelPrincipalAjuda = new PainelPrincipalAjuda("TF3");
		this.setContentPane(painelPrincipalAjuda);
	}
	
	public void setpainelSobre(){
		painelPrincipalAjuda = new PainelPrincipalAjuda("sobre");
		this.setContentPane(painelPrincipalAjuda);
	}


}