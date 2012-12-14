package g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter;

import g4.programaClienteTwitter.ine5605.logica.Formatador;
import g4.programaClienteTwitter.ine5605.logica.Tweets;

import javax.swing.DefaultListModel;

import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.TwitterException;

public class GerenciadorTimeline extends Gerenciador {
	
	private DefaultListModel<Tweets>  model = new DefaultListModel<Tweets>();
	public Formatador formatador =  new Formatador();
	
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
	
	public void preencheLista(ResponseList<Status> listaPreenchida){
		for(Status status : listaPreenchida){
			Tweets tweets = new Tweets();
			tweets.setId(status.getId());
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

	public void retwittar(long idTweet) throws TwitterException{
		twitter.retweetStatus(idTweet);
	}

}
