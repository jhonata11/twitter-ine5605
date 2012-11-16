package g4.programaClienteTwitter.ine5605.igu;

import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.TwitterException;

public class PainelEntrada extends JPanel implements ActionListener {

	JButton gera_codigo;
	JButton confirma;
	JTextField codigo;
	JLabel frase;
	private GerenciadorTwitter gerenciadorT;
	JanelaPrincipal jp;
	private static final String LOGO = "http://i46.tinypic.com/mt1rip.png";
	private JLabel icon;

	public PainelEntrada(GerenciadorTwitter gerenciadorT, JanelaPrincipal janela) {
		definaComponentes();
		posicionaComponente();
		this.jp = janela;
		this.gerenciadorT = gerenciadorT;
	}

	private void definaComponentes() {
		gera_codigo = new JButton("Gerar Codigo");
		confirma = new JButton("Confirma");

		codigo = new JTextField(15);
		frase = new JLabel("Insira o codigo :");
		frase.setForeground(Color.gray);

		confirma.addActionListener(this);
		gera_codigo.addActionListener(this);

	}

	private void posicionaComponente() {
	
		JPanel painelBotoes = new JPanel(); // o código insere 2 painéis, uma
		JPanel campo = new JPanel(); // dos botões, e outra do campo.
		JPanel painelImagem = new JPanel();
		try {
		
		icon = new JLabel (new ImageIcon(new URL (LOGO)));}
		catch (MalformedURLException e1){}
		painelImagem.add(icon);

		painelImagem.setBackground(Color.black);
		campo.setBackground(Color.black);
		painelBotoes.setBackground(Color.black);


		setLayout(new GridLayout(3, 1)); // Decide o Layout do painel

		campo.add(frase); // insere a mensagem "insira o código
		campo.add(codigo); // insere o campo de texto
		painelBotoes.add(confirma); // insere o botão confirma
		painelBotoes.add(gera_codigo);

		add(painelImagem);
		add(campo); // insere o painel campo
		add(painelBotoes); // insere o painel de botões
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == gera_codigo) {
			try {
				gerenciadorT.geraCodigo();
			} catch (TwitterException e1) {
				e1.printStackTrace();
			}
		}

		
		else {
			try {
				gerenciadorT.fazLogin(codigo.getText());
				this.setVisible(false);
				jp.setPainelTweet();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
				if (codigo.getText().length() == 0)		
					JOptionPane.showMessageDialog(this, "você deve inserir um código para poder confirmar");
				
				else
					JOptionPane.showMessageDialog(this, "o código informado está incorreto");
				
			}
		}

	}

}
