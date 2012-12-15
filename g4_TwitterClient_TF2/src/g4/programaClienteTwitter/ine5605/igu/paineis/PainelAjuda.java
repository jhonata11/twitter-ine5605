package g4.programaClienteTwitter.ine5605.igu.paineis;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class PainelAjuda extends JScrollPane{
	private static final long serialVersionUID = 1L;

	private JLabel textoAjuda;

	JLabel textoAjudaTF1;
	JLabel textoAjudaTF2;
	JLabel textoAjudaTF3;
	String versaoTF;


	public PainelAjuda(String versaoTF) {
		this.setName("Ajuda Trabalho Final");
		this.setSize(300, 200);
		this.getViewport().setBackground(Color.white);

		this.versaoTF = versaoTF;
		iniciaComponents();
		posicionaComponents();

	}

	private void posicionaComponents() {
		if(versaoTF.equals("TF1"))
			this.getViewport().add(textoAjudaTF1);


		if(versaoTF.equals("TF2"))
			this.getViewport().add(textoAjudaTF2);

		if(versaoTF.equals("TF3"))
			this.getViewport().add(textoAjudaTF3);

		if(versaoTF.equals("sobre"))
			this.getViewport().add(textoAjuda);



	}

	private void iniciaComponents() {
		textoAjudaTF1 = new JLabel(ajudaTF1());
		textoAjudaTF2 = new JLabel(ajudaTF2());
		textoAjudaTF3 = new JLabel(ajudaTF3());
		textoAjuda = new JLabel(gereAjudaInteira());


	}

	private String ajudaTF1(){
		StringBuilder builderAjuda = new StringBuilder();
		builderAjuda
		.append("<html>")
		.append("<div style=\"width: 300px; margin: 10px;\">")

		.append("<h1>Ajuda Trabalho Final 1</h1>")

		.append("<p>")
		.append("<h2>Como logar</h2>")
		.append("Para acessar sua conta pelo Piu! " +
				"você precisa gerar um código. Para gera-lo" +
				" clique no botão gerar código, entre com seus dados"+
				" no site, e copie o código que lhe foi dado, coloque-os"+
				" no campo em branco e clique em confirma.")
				.append("</p>")

				.append("<p>")
				.append("<h2>Como Twittar</h2>")
				.append("Digite uma mensagem com menos de 140 caracteres " +
						"e clique no botão com uma imagem de passarinho.")
						.append("</p>")

						.append("<p>")
						.append("<h2>Como Ver suas mensagems</h2>")
						.append("Quando você loga no Piu! suas mensagens já aparecem" +
								" no painel principal. As mensagens que estão em verde")
								.append("</p>")

								.append("<br/>")
								.append("<hr/>")
								.append("</div>");


		return builderAjuda.toString();

	}

	private String ajudaTF2(){
		StringBuilder builderAjuda = new StringBuilder();
		builderAjuda
		.append("<html>")
		.append("<div style=\"width: 300px; margin: 10px;\">")
		.append("<p>")
		.append("<h1>Ajuda Trabalho Final 2</h1>")
		.append("<h2>Atualizar Timeline</h2>")
		.append(" Clique no botão com símbolo de atualização no canto direito do programa.")
				.append("</p>")

				.append("<p>")
				.append("<h2>Adicionar Pessoas</h2>")
				.append("Clique no botão com um + ao lado direito do painel " +
						"que contém os tweets. Logo em seguida digite um usuário para seguir " +
						"Exemplo : @fiuk")
						.append("</p>")

						.append("<p>")
						.append("<h2>Pesquisar por tweets</h2>")
						.append("Coloque o termo no campo vazio "+ 
								"ao lado direito do painel que contém " +
								"os tweets e insira um termo para ser"+
								" pesquisado e clique no botão ao lado, que contém uma lupa." +
								" Os tweets contendo este termo aparecerão em sua Timeline. Para retornar aos seus tweets, simplesmente " +
								"clique em atualizar")
								.append("</p>")

								.append("<br/>")
								.append("<hr/>")
								.append("</div>");


		return builderAjuda.toString();
	}

	private String ajudaTF3(){
		StringBuilder builderAjuda = new StringBuilder();
		builderAjuda
		.append("<html>")
		.append("<div style=\"width: 300px; margin: 10px;\">")
		.append("<p>")
		.append("<h1>Ajuda Trabalho Final 3</h1>")
		.append("<h2> Deixar de seguir alguém</h2>")
		.append("Para deixar de seguir algéum, clique no botão que " +
				"tem um - e coloque o usuário que você deseja" +
				" deixar de seguir." +
				"Exemplo : @justinbieber")
				.append("</p>")

				.append("<p>")
				.append("<h2>Quantas pessoas eu sigo?</h2>")
				.append("Para ver quantas pessoas você segue é simples," +
						" ao lado esquerdo do painel que contém os tweets tem um" +
						"ícone 'A', lá lhe dirá quantas pessoas você segue. ")
						.append("</p>")

						.append("<p>")
						.append("<h2>Quantas pessoas te seguem?</h2>")
						.append("Para ver quantas te seguem, é o mesmo esquema de pessoas que eu sigo,"+
								" ao invés de olhar no 'A' você olha no 'S'")
								.append("</p>")

								.append("<p>")
								.append("<h2>Como retwiitar</h2>")
								.append("Para retwittar uma mensagem, você tem que clicar com o"+
										" botão direito em cima da mensagem que você quer retwittar"+
										" e clique no botão retwittar.")
										.append("</p>")

										.append("<br/>")
										.append("<hr/>")

										.append("</div>");


		return builderAjuda.toString();

	}


	private String stringDesenvolvedores(){
		StringBuilder builderAjuda = new StringBuilder();
		builderAjuda
		.append("<html>")
		.append("<div style=\"width: 300px; margin: 10px;\">")
		.append("<p>")
		.append("<h1>Sobre os desenvolvedores</h1>")
		.append("<h2></h2>")
		.append("Alunos da segunda fase de Sistemas de Informação da UFSC"+
				"os graduandos : Jhonata da Rocha, Guilherme Schmitt, Eduardo M. Konevski e Thiago Frenandes, "+
				"desenvolveram este software como trabalho final da disciplina de Desenvolvimento de Sistemas"+ 
				"Orientado a Objetos I, cujo o professor é Leandro José Komosinki.")


				.append("</div>");

		return builderAjuda.toString();
	}

	private String gereAjudaInteira(){
		StringBuilder builderAjuda = new StringBuilder();
		builderAjuda
			.append(stringDesenvolvedores());

		return builderAjuda.toString();

	}



}