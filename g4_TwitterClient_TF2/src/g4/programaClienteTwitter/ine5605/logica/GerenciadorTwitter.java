package g4.programaClienteTwitter.ine5605.logica;


import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;



import twitter4j.IDs;
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
	private DefaultListModel<Tweets>  model = new DefaultListModel<Tweets>();
	public Formatador formatador =  new Formatador();

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
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação!");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação!");
			e.printStackTrace();
		}
	}

	public void tweetar(String text) throws TwitterException {

		twitter.updateStatus(text);
	}


	public void searchTweets (String s) throws TwitterException{
		twitter4j.Query query = new twitter4j.Query(s);

		QueryResult resultado = twitter.search(query);

		for (Tweet tweet : resultado.getTweets()) {
			Tweets tweets = new Tweets();
			tweets.setNome(tweet.getFromUser());
			tweets.setTexto(tweet.getText());
			//				tweets.setFotoDoPerfil(formatador.getIconFromString(tweet.getProfileImageUrl()));

			model.addElement(tweets);
		}
	}

	public void seguirAlguem (String nome) throws TwitterException{
		twitter.createFriendship(nome);
	}

	public void deixarDeSeguirAlguem (String nome) throws TwitterException{
		twitter.destroyFriendship(nome);
	}


	public void preencheLista(ResponseList<Status> listaPreenchida){
		for(Status status : listaPreenchida){
			Tweets tweets = new Tweets();
			tweets.setFotoDoPerfil(formatador.getIconFromUrl(status.getUser().getProfileImageURL()));
			tweets.setNome(status.getUser().getName());
			tweets.setTexto(status.getText());

			model.addElement(tweets);
		}
	}

	public DefaultListModel<Tweets> getModel() {
		return model;
	}


	public void getTimeLine() throws TwitterException{
		ResponseList<Status> resposta = null;

		resposta = twitter.getHomeTimeline();
		preencheLista(resposta);
	}

	public void clearTimeline(){
		model.clear();
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


