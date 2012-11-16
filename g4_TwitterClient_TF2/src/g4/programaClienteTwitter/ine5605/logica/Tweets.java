package g4.programaClienteTwitter.ine5605.logica;

import javax.swing.Icon;

public class Tweets {
	
	String texto;
	String nome;
	Icon foto;
	
	public Tweets (){
	}
	
	public void setNome (String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

	public void setTexto (String texto){
		this.texto = texto;
	}
	
	public String getTexto(){
		return this.texto;
	}
	
	public void setFoto(Icon foto){
		this.foto = foto;
	}
	
	public Icon getFoto(){
		return this.foto;
	}
	
	
	
	
}
