package g4.programaClienteTwitter.ine5605.igu.paineis;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class PainelAjuda extends JScrollPane{
	private static final long serialVersionUID = 1L;

	private JLabel textoAjuda;

	public PainelAjuda() {
		this.setName("Ajuda Trabalho Final");
		this.setSize(300, 200);
		this.getViewport().setBackground(Color.white);
		iniciaComponents();
		posicionaComponents();

	}

	private void posicionaComponents() {
		this.getViewport().add(textoAjuda);
	}

	private void iniciaComponents() {
		textoAjuda = new JLabel(gereAjudaHTML());
	}

	private String gereAjudaHTML() {
		StringBuilder builderAjuda = new StringBuilder();
		builderAjuda
			.append("<html>")
			.append("<div style=\"width: 300px; margin: 10px;\">")
			
			.append("<h1>Ajuda Trabalho Final 1</h1>")
			
			.append("<p>")
			.append("<h2>Como logar</h2>")
			.append("Para acessar sua conta pelo Piu! " +
					"você precisa gerar um código, para gera-lo" +
					" clique no botão gerar código, entre com seus dados"+
					" no site, e copie o código que lhe foi dado, coloque-os"+
					" no campo em branco e clique em confirma.")
			.append("</p>")
			
			.append("<p>")
			.append("<h2>Como Twiitar</h2>")
			.append("Digite uma mensagem com menos de 140 caracteres " +
					"e clique no botão com uma imagem de passarinho.")
			.append("</p>")
			
			.append("<p>")
			.append("<h2>Como Ver suas mensagems</h2>")
			.append("Quando você loga no Piu! suas mensagens já aparecem" +
					" no painel principal.")
			.append("</p>")
			
			.append("<br/>")
			.append("<hr/>")
			
			.append("<p>")
			.append("<h1>Ajuda Trabalho Final 2</h1>")
			.append("<h2>Atualizar Timeline</h2>")
			.append(" Clique no botão que tem um ícone de voltar" +
					" para atualizar a Timeline. ")
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
					" pesquisado e clique no p.")
			.append("</p>")
			
			.append("<br/>")
			.append("<hr/>")

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
	

}