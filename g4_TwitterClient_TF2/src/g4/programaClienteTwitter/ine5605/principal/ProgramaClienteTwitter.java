package g4.programaClienteTwitter.ine5605.principal;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import g4.programaClienteTwitter.ine5605.igu.JanelaPrincipal;
import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

/**
 * Leiam todos os comentários marcados com //FIXME
 * 
 * - Uso incorreto da biblioteca twitter4j. O projeto só deve conter as bibliotecas usadas.
 * - O arquivo twitter4j-2.2.6.zip (mais de 5Mb) não deve fazer parte do projeto!!
 * 
 * @author leandro
 *
 */


public class ProgramaClienteTwitter {


	public static void main(String[] args) {
		
		Twitter twitter = TwitterFactory.getSingleton();
		
		//FIXME erro de modelagem. Do ponto de vista do método main, só existe o gerenciadorTwitter
		GerenciadorTwitter gerenciadorTwitter = new GerenciadorTwitter (twitter);
		JanelaPrincipal jp;
		

		//FIXME janela principal só interage com gerenciadorTwitter
		jp = new JanelaPrincipal(gerenciadorTwitter);
		jp.interaja();
	}

}
