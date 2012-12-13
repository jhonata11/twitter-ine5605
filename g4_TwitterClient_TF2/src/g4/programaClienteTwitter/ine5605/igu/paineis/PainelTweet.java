package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.igu.cellRenderer.TweetCellRenderer;
import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;
import g4.programaClienteTwitter.ine5605.logica.Tweets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import twitter4j.TwitterException;

public class PainelTweet extends Painel {

	private static final long serialVersionUID = 1L;
	private static final String logoTweet =  "http://i49.tinypic.com/2814s54.png";

	private GerenciadorTwitter gerenciadorTwitter;	
	private JList<Tweets> listaTweets;
	private JScrollPane scrollJList;	

	private JTextArea escrevaMensagem;
	private JButton btTweet;



	public PainelTweet(GerenciadorTwitter gerenciador) {

		gerenciadorTwitter = gerenciador;

		this.definaComponentes();
		this.posicioneComponentes();
	}

	@Override
	protected void definaComponentes() {
		// define os componentes do painel

		listaTweets = new JList<Tweets>(gerenciadorTwitter.getModel());
		listaTweets.setPreferredSize(new Dimension(400, 1240));
		listaTweets.setCellRenderer(new TweetCellRenderer());
		scrollJList = new JScrollPane(listaTweets);
		scrollJList.getVerticalScrollBar();
		scrollJList.getHorizontalScrollBar();

		try {
			btTweet = new JButton(new ImageIcon( new URL(logoTweet)));
		} catch (MalformedURLException e) {}
		btTweet.addActionListener(this);


	

		escrevaMensagem = new JTextArea(5, 30);
		escrevaMensagem.setLineWrap(true);


		try {
			gerenciadorTwitter.getTimeLine();
		} catch (TwitterException e1) {}

	}

	@Override
	protected void posicioneComponentes() {
		// posiciona os componentes do painel
		setLayout(new BorderLayout(3, 3));
		setSize(800, 800);


		// painel com a lista de tweets
		JPanel painelTweets = new JPanel();
		painelTweets.setBackground(Color.black);
		this.add(scrollJList, BorderLayout.CENTER); 


		PainelOpcoes painelOpcoes = new PainelOpcoes(gerenciadorTwitter);
		this.add(painelOpcoes, BorderLayout.EAST);
		
		PainelInformacoesUsuario painelInformacoesUsuario= new PainelInformacoesUsuario(gerenciadorTwitter);
		this.add(painelInformacoesUsuario, BorderLayout.WEST);
		

		//painel com o campo de texto para escrever um tweet
		JPanel painelMensagem = new JPanel();
		painelMensagem.setBackground(Color.black);
		this.add(painelMensagem, BorderLayout.PAGE_END);
		painelMensagem.add(escrevaMensagem);
		painelMensagem.add(btTweet);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == btTweet
				&& escrevaMensagem.getText().length() <= 140) {

			try {
				gerenciadorTwitter.tweetar(escrevaMensagem.getText());

				try {
					gerenciadorTwitter.clearTimeline();
					gerenciadorTwitter.getTimeLine();
				} catch (TwitterException e1) {}

			} catch (TwitterException e1) {

			}
			escrevaMensagem.setText("");



			SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {

				@Override
				public Void doInBackground(){
					try {
						gerenciadorTwitter.clearTimeline();
						gerenciadorTwitter.getTimeLine();
					} catch (TwitterException e1) {}
					return null;
				}
			};
			swingWorker.execute();

		}
		

	}





}
