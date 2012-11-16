package g4.programaClienteTwitter.ine5605.logica;


//FIXME erro gravíssimo: classes do pacote logica não usam objetos do pacote iu

import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.DefaultListModel;
import javax.swing.JList;



import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class GerenciadorTwitter {

	public Twitter twitter;
	private RequestToken requestToken;

	//teste	
	private DefaultListModel model = new DefaultListModel();
	private JList<Tweets> listaTweets;

	//teste
	
	public boolean logado;


	public GerenciadorTwitter(Twitter twitter) {

		this.twitter = twitter;
		this.twitter.setOAuthConsumer("A5ccYmi3riXRlo1fBv9bA",
				"H0yy96dit2aPH5I4nNKkf1wkTyB4iAJpxz1yw8bjaE");
		
		logado = false;
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

	public ResponseList<Status> getTimeLine() {
		ResponseList<Status> resposta = null;
		try {
			resposta = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			//FIXME e se der erro?

			e.printStackTrace();
		}
		return resposta;
	} 

	public void searchTweets (String s) {
		ResponseList<Status> resposta = null;

		twitter4j.Query query = new twitter4j.Query(s);
		try {
			QueryResult resultado = twitter.search(query);

			for (Tweet tweet : resultado.getTweets()) {
				model.addElement(tweet.getFromUser() + ":" + tweet.getText());
			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public DefaultListModel getModel() {
		return model;
	}



	public void seguirAlguem (String nome) throws TwitterException{
		twitter.createFriendship(nome);
	}


	public void preencheLista(ResponseList<Status> listaPreenchida){
		for(Status status : listaPreenchida){
			model.addElement(status.getUser().getName() + 
					": " + status.getText());
		}
	}
}


