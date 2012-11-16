package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;
import g4.programaClienteTwitter.ine5605.logica.Tweets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;


import twitter4j.*;

public class PainelTweet extends JPanel implements ActionListener {

	/**
	 * 
	 */
	
	//FIXME vários atributos não usados. Descontada alguma nota por causa disso.
	
	private JScrollPane scrollJList;
	private DefaultListModel model=new DefaultListModel();
	private static final long serialVersionUID = 53543543;
	private GerenciadorTwitter gerenciadorT;
	
	
	private JList<Tweets> listaTweets;
	
	
	private JScrollPane scroll;
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
		listaTweets = new JList(model);
		listaTweets.setPreferredSize(new Dimension(400, 400));
	
		scrollJList=new JScrollPane(listaTweets);
		
		btTweet = new JButton("tweetar");
		btTweet.addActionListener(this);
		btAtualizaTimeline = new JButton("atualizar timeline");
		btAtualizaTimeline.addActionListener(this);
		

		escrevaMensagem = new JTextArea(5, 15);
		escrevaMensagem.setLineWrap(true);

		labelMsg = new JLabel("Insira sua mensagem: ");
		labelMsg.setForeground(Color.gray);

		scroll = new JScrollPane();
		preencheLista(gerenciadorT.geTimeLine());
		
		
	}

	private void posicionaComponentes() {
		// posiciona os componentes do painel

		setLayout(new GridLayout(3, 1));
		
		JPanel painelTweets = new JPanel();
		painelTweets.setBackground(Color.black);
		painelTweets.add(scrollJList);

		
		JPanel painelMensagem = new JPanel();
		painelMensagem.setBackground(Color.black);
		painelMensagem.add(labelMsg);
		painelMensagem.add(escrevaMensagem);
		painelMensagem.add(btTweet);

		JPanel painelBotao = new JPanel();
		painelBotao.setBackground(Color.black);
		painelBotao.add(btAtualizaTimeline);

		add(painelTweets);
		
		add(painelBotao);
		add(painelMensagem);
	}
	
	public void preencheLista(ResponseList<Status> listaPreenchida){
		for(Status status : listaPreenchida){

			JLabel foto = new JLabel(new ImageIcon(status.getUser().getProfileImageURL()));
			model.addElement(status.getUser().getName() + ": " + status.getText());
		}
		
		
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
					
					model.clear();
					preencheLista(gerenciadorT.geTimeLine());					
				}
			});
			

			
			//FIXME : comando sem sentido???? Descontada nota.
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			t.start();

		}
		
		else if(e.getSource() == btAtualizaTimeline){
			model.clear();
			preencheLista(gerenciadorT.geTimeLine());
		}
		
	}

}
