package g4.programaClienteTwitter.ine5605.logica;

import javax.swing.Icon;

public class Tweets {
	
	String texto;
	String nome;
	Icon fotoDoPerfil;
	
	public Icon getFotoDoPerfil() {
		return fotoDoPerfil;
	}

	public void setFotoDoPerfil(Icon fotoDoPerfil) {
		this.fotoDoPerfil = fotoDoPerfil;
	}

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
	
	
}
