package g4.programaClienteTwitter.ine5605.principal;

import g4.programaClienteTwitter.ine5605.igu.JanelaPrincipal;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;


public class ProgramaClienteTwitter {


	public static void main(String[] args) {
		
		GerenciadorAutentitcacao gerenciadorAutentitcacao = new GerenciadorAutentitcacao ();
		JanelaPrincipal janelaPrincipal;
		

		janelaPrincipal = new JanelaPrincipal(gerenciadorAutentitcacao);
		janelaPrincipal.interaja();
	}

}
