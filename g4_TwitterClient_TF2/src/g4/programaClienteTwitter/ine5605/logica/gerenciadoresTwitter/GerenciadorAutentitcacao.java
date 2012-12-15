package g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter;
import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *	Classe responsavel pelos servicos de autenticacao do programa
 */

public class GerenciadorAutentitcacao extends Gerenciador{

	private RequestToken requestToken;
	public boolean logado;


	public GerenciadorAutentitcacao() {

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
}


