package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;
import g4.programaClienteTwitter.ine5605.logica.Tweets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class PainelTweet extends JPanel implements ActionListener {


	

	private static final long serialVersionUID = 53543543;
	private GerenciadorTwitter gerenciadorT;	

	private JList<Tweets> listaTweets;
	private JScrollPane scrollJList;	
	
	private JTextArea escrevaMensagem;
	private JButton btAtualizaTimeline;
	private JButton btTweet;
	private JLabel labelMsg;

	
	
	public PainelTweet(GerenciadorTwitter gerenciador) {
		gerenciadorT = gerenciador;

		this.defineComponentes();
		this.posicionaComponentes();
	}

	private void defineComponentes() {
		// define os componentes do painel
				
		listaTweets = new JList(gerenciadorT.getModel());
		listaTweets.setPreferredSize(new Dimension(470, 400));
		
		scrollJList = new JScrollPane(listaTweets);
	
		btTweet = new JButton("tweetar");
		btTweet.addActionListener(this);
		btAtualizaTimeline = new JButton("atualizar timeline");
		btAtualizaTimeline.addActionListener(this);
		

		escrevaMensagem = new JTextArea(5, 15);
		escrevaMensagem.setLineWrap(true);

		labelMsg = new JLabel("Insira sua mensagem: ");
		labelMsg.setForeground(Color.gray);


		gerenciadorT.preencheLista(gerenciadorT.getTimeLine());
		
		
	}

	private void posicionaComponentes() {
		// posiciona os componentes do painel

		setLayout(new GridLayout(3, 1));
		
		
		// painel com a lista de tweets
		JPanel painelTweets = new JPanel();
		painelTweets.setBackground(Color.black);
		painelTweets.add(scrollJList); 
		
		
		// painel que contém o botão atualizar
		JPanel painelBotao = new JPanel();
		painelBotao.setBackground(Color.black);
		painelBotao.add(btAtualizaTimeline);
		
		//painel com o campo de texto para escrever um tweet
		JPanel painelMensagem = new JPanel();
		painelMensagem.setBackground(Color.black);
		painelMensagem.add(labelMsg);
		painelMensagem.add(escrevaMensagem);
		painelMensagem.add(btTweet);


		add(painelTweets);
		add(painelBotao);
		add(painelMensagem);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// define a ação realizada quando o botão for apertado

		if (e.getSource() == btTweet
				&& escrevaMensagem.getText().length() <= 140) {

			gerenciadorT.tweetar(escrevaMensagem.getText());
			escrevaMensagem.setText("");
			
			//FIXME muito perigoso usar thread. O correto é usar SwingWorker
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					gerenciadorT.getModel().clear();
					gerenciadorT.preencheLista(gerenciadorT.getTimeLine());					
				}
			});
			
			t.start();

		}
		
		else if(e.getSource() == btAtualizaTimeline){
			gerenciadorT.getModel().clear();
			gerenciadorT.preencheLista(gerenciadorT.getTimeLine());
		}
		
	}

}
