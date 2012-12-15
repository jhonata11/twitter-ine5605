package g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * Classe abstrata para um gerenciador.
 */
public abstract class Gerenciador {
	public Twitter twitter = TwitterFactory.getSingleton();
}
