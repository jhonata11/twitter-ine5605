package g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter;

import twitter4j.IDs;
import twitter4j.TwitterException;

public class GerenciadorAmigos extends Gerenciador {
	
	
	public GerenciadorAmigos() {

	
	}
	
	
	public void seguirAlguem (String nome) throws TwitterException{
		twitter.createFriendship(nome);
	}

	public void deixarDeSeguirAlguem (String nome) throws TwitterException{
		twitter.destroyFriendship(nome);
	}
	
	public int getNumeroSeguidores() throws TwitterException{
		int cont = 0;
		IDs ids = twitter.getFollowersIDs(-1);
		cont = ids.getIDs().length;	
		return cont;
	}
	
	public int getNumeroAmigos() throws TwitterException{
		int cont = 0;
		IDs ids = twitter.getFriendsIDs(-1);
		cont = ids.getIDs().length;	
		return cont;
	}


}
