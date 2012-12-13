package g4.programaClienteTwitter.ine5605.igu.paineis;

import g4.programaClienteTwitter.ine5605.igu.JanelaPrincipal;
import g4.programaClienteTwitter.ine5605.logica.GerenciadorTwitter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.TwitterException;

public class PainelEntrada extends Painel {

	private static final long serialVersionUID = 1L;
	private static final String LOGO = "http://i46.tinypic.com/mt1rip.png";
	private JLabel icon;
	
	JButton gera_codigo;
	JButton confirma;
	JTextField codigo;
	JLabel frase;
	
	
	
	public PainelEntrada(GerenciadorTwitter gerenciador, JanelaPrincipal jp) {

		this.janela = jp;
		this.gerenciadorTwitter = gerenciador; 
		definaComponentes();
		posicioneComponentes();

	}

	protected void definaComponentes() {
		gera_codigo = new JButton("Gerar Codigo");
		confirma = new JButton("Confirma");

		codigo = new JTextField(15);
		frase = new JLabel("Insira o codigo :");
		frase.setForeground(Color.gray);

		confirma.addActionListener(this);
		gera_codigo.addActionListener(this);

	}

	protected void posicioneComponentes() {

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
				gerenciadorTwitter.geraCodigo();
			} catch (TwitterException e1) {
				e1.printStackTrace();
			}
		}


		else {
			try {
				gerenciadorTwitter.fazLogin(codigo.getText());
				this.setVisible(false);
				gerenciadorTwitter.logado = true;
				janela.setPainelTweet();

			} catch (TwitterException e1){
				JOptionPane.showMessageDialog(this, "ocorreu um erro, e não foi possível conectar");


			}catch (Exception e1) {

				if (codigo.getText().length() == 0)		
					JOptionPane.showMessageDialog(this, "você deve inserir um código para poder confirmar");

				else
					JOptionPane.showMessageDialog(this, "o código informado está incorreto");

				e1.printStackTrace();

			}
		}

	}

}
