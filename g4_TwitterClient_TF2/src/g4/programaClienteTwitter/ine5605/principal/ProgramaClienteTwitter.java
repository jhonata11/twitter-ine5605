package g4.programaClienteTwitter.ine5605.principal;

import g4.programaClienteTwitter.ine5605.igu.JanelaPrincipal;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;


/**
 * 
 * @author Grupo 4 - INE5605
 *  - Eduardo de Meireles Koneski
 *	- Guilherme Schmitt
 *	- Jhonata da Rocha
 *	- Thiago Fernandes
 *
 *	Projeto "Piu!"
 *	
 */


public class ProgramaClienteTwitter {


	public static void main(String[] args) {
		
		GerenciadorAutentitcacao gerenciadorAutentitcacao = new GerenciadorAutentitcacao ();
		JanelaPrincipal janelaPrincipal;
		

		janelaPrincipal = new JanelaPrincipal(gerenciadorAutentitcacao);
		janelaPrincipal.interaja();
	}

}
