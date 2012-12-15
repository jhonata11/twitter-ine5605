package g4.programaClienteTwitter.ine5605.logica;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 * 
 * Classe que faz formatacoes em geral.
 *
 */

public class Formatador {


	public Icon getIconFromUrl(URL url){
		ImageIcon icone = new ImageIcon(url);
		return icone;
	}

	/**
	 *	os metodos a seguir transformam um Url ou um String em um icone.
	 */


	public Icon getIconFromString(String url){
		ImageIcon icone = new ImageIcon(url);
		return icone;
	}


	/**
	 * 
	 * @param tweum o texto a ser exibido em um tweet.
	 * @return uma String html, com formatacoes e cores diferentes para os tweets.
	 */	
	public String formatHTML(String tweet) {
		StringBuilder builder = new StringBuilder("<html>");
		String style = "width: 250px; " +
				"font-family: Verdana; " +
				"font-size: 12pt; ";

		builder.append("<body style=\"" + style + "\">");

		//Separado por espaços
		String[] palavras = tweet.split("\\s");

		for(String palavra : palavras){
			if(palavra.length() > 0){

				//muda a cor da palavra caso ela possua @ no primeiro caractere
				if(palavra.charAt(0) == '@'){
					builder.append("<font color=\"#3399FF\">" + palavra + "</font> ");
				}

				//muda a cor da palavra caso ela possua # no primeiro caractere
				else if(palavra.charAt(0) == '#'){
					builder.append("<font color=\"#003366\">" + palavra + "</font> ");
				}

				//muda a cor da palavra caso ela comece com http
				else if(palavra.contains("http")){
					builder.append("<a href=\""+ palavra +"\">" + palavra + "</a> ");
				}
				else{
					builder.append(palavra + " ");
				}
			}
		}

		builder.append("</body>");
		builder.append("</html>");
		return builder.toString();
	}


	public String formatarData(Date d){
		String formatoData = "dd/MM/yyyy";
		String formatoHora = "HH:mm:ss";

		SimpleDateFormat formatadorData = new SimpleDateFormat(formatoData);
		SimpleDateFormat formatadorHora = new SimpleDateFormat(formatoHora);



		return "postado em "+ formatadorData.format(d) + 
				" às " +formatadorHora.format(d);

	}

}
