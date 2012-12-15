package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.igu.cellRenderer.TweetCellRenderer;
import g4.programaClienteTwitter.ine5605.logica.Tweets;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAmigos;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorAutentitcacao;
import g4.programaClienteTwitter.ine5605.logica.gerenciadoresTwitter.GerenciadorTimeline;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import twitter4j.TwitterException;

public class PainelTweet extends Painel {

	private static final long serialVersionUID = 1L;
	private static final String logoTweet =  "http://i49.tinypic.com/2814s54.png";

	GerenciadorAmigos gerenciadorAmigos;
	GerenciadorTimeline gerenciadorTimeline;


	private JList<Tweets> listaTweets;
	private JScrollPane scrollJList;	
	private JTextArea escrevaMensagem;
	private JButton btTweet;

	private JPopupMenu cliqueEsquerdo;
	private JMenuItem itemRetwittar;


	public PainelTweet(GerenciadorAutentitcacao gerenciadorAutenticacao) {

		this.gerenciadorAmigos = new GerenciadorAmigos();
		this.gerenciadorTimeline = new GerenciadorTimeline();
		this.gerenciadorAutentitcacao = gerenciadorAutenticacao;

		this.definaComponentes();
		this.posicioneComponentes();
	}

	@Override
	protected void definaComponentes() {
		// define os componentes do painel
		
		this.defineListaTweets();

		cliqueEsquerdo = new JPopupMenu();
		itemRetwittar = new JMenuItem("Retwittar");
		itemRetwittar.addActionListener(this);
		cliqueEsquerdo.add(itemRetwittar);



		try {
			btTweet = new JButton(new ImageIcon( new URL(logoTweet)));
		} catch (MalformedURLException e) {}
		btTweet.addActionListener(this);


		escrevaMensagem = new JTextArea(5, 30);
		escrevaMensagem.setLineWrap(true);


		try {
			gerenciadorTimeline.getTimeLine();
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



		PainelOpcoes painelOpcoes = new PainelOpcoes(gerenciadorAutentitcacao, gerenciadorAmigos, gerenciadorTimeline);
		this.add(painelOpcoes, BorderLayout.EAST);

		PainelInformacoesUsuario painelInformacoesUsuario= new PainelInformacoesUsuario(gerenciadorAmigos);
		this.add(painelInformacoesUsuario, BorderLayout.WEST);


		//painel com o campo de texto para escrever um tweet
		JPanel painelMensagem = new JPanel();
		painelMensagem.setBackground(Color.black);
		this.add(painelMensagem, BorderLayout.PAGE_END);
		painelMensagem.add(escrevaMensagem);
		painelMensagem.add(btTweet);


	}
	
	public void defineListaTweets(){

		listaTweets = new JList<Tweets>(gerenciadorTimeline.getModel());
		listaTweets.setCellRenderer(new TweetCellRenderer());
		scrollJList = new JScrollPane(listaTweets);
		scrollJList.getVerticalScrollBar();
		scrollJList.getHorizontalScrollBar();

		listaTweets.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				if (SwingUtilities.isRightMouseButton(evt)) {           	
					listaTweets.setSelectedIndex(
							listaTweets.locationToIndex(evt.getPoint()));
					cliqueEsquerdo.show(listaTweets, evt.getX(), evt.getY()); 
				}
			}
		});


		cliqueEsquerdo = new JPopupMenu();
		itemRetwittar = new JMenuItem("Retwittar");
		itemRetwittar.addActionListener(this);
		cliqueEsquerdo.add(itemRetwittar);


	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == btTweet
				&& escrevaMensagem.getText().length() <= 140) {

			final String textoParaTwittar = escrevaMensagem.getText();

			try {
				gerenciadorTimeline.tweetar(escrevaMensagem.getText());

				try {
					gerenciadorTimeline.clearTimeline();
					gerenciadorTimeline.getTimeLine();
				} catch (TwitterException e1) {}

			} catch (TwitterException e1) {

			}
			escrevaMensagem.setText("");



			SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {

				protected void done(){
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {}
				}


				@Override
				protected Void doInBackground(){
					try {
						gerenciadorTimeline.tweetar(textoParaTwittar);
					} catch (TwitterException e1) {}
					return null;
				}
			};
			swingWorker.execute();

		}

		else if(e.getSource() == itemRetwittar){
			Tweets tweet = listaTweets.getSelectedValue();

			try {
				gerenciadorTimeline.retwittar(tweet.getId());
			} catch (TwitterException e1) {}
		}


	}






}
