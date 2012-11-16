package g4.programaClienteTwitter.ine5605.logica;


//FIXME erro gravíssimo: classes do pacote logica não usam objetos do pacote iu

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class GerenciadorTwitter {

	public Twitter twitter;
	private RequestToken requestToken;
	

	public GerenciadorTwitter(Twitter twitter) {

		this.twitter = twitter;
		this.twitter.setOAuthConsumer("A5ccYmi3riXRlo1fBv9bA",
				"H0yy96dit2aPH5I4nNKkf1wkTyB4iAJpxz1yw8bjaE");
	}

	public void fazLogin(String codigo) throws TwitterException {
		// confere o código gerado em geraCodigo(), e dá acesso ao twitter

		AccessToken accessToken = twitter.getOAuthAccessToken(requestToken,
				codigo);
		twitter.setOAuthAccessToken(accessToken);
	}

	public void geraCodigo() throws TwitterException {
		// classe que direciona para a página e gera código

		try {
			requestToken = twitter.getOAuthRequestToken();
			Desktop.getDesktop().browse(
					new URI(requestToken.getAuthenticationURL()));

		} catch (URISyntaxException e) {
			//FIXME e se der erro?
			e.printStackTrace();
		} catch (IOException e) {
			//FIXME e se der erro?
			e.printStackTrace();
		}
	}

	public void tweetar(String text) {
		// ação realizada pelo botão twittar

		try {
			twitter.updateStatus(text);

		} catch (TwitterException e) {
			//FIXME e se der erro?

			e.printStackTrace();
		}

	}

	public ResponseList<Status> geTimeLine() {
		ResponseList<Status> resposta = null;
		try {
			resposta = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			//FIXME e se der erro?
			
			e.printStackTrace();
		}
		return resposta;
	} 
	
	public void seguirAlguem (String nome) throws TwitterException{
		twitter.createFriendship(nome);
	}


}


