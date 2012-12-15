package g4.programaClienteTwitter.ine5605.logica;

import java.util.Date;

import javax.swing.Icon;

/**
 * 
 * Classe que define um tweet, composto por um nome, um texto, uma 
 * foto e um id especifico.
 *
 */

public class Tweets {
	
	String texto;
	String nome;
	Long Id;
	Icon fotoDoPerfil;
	Date data;
	boolean isRetweeted;
	String dataEmString;
	
	
	
	public String getDataEmString() {
		return dataEmString;
	}

	public void setDataEmString(String dataEmString) {
		this.dataEmString = dataEmString;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isRetweeted() {
		return isRetweeted;
	}

	public void setRetweeted(boolean isRetweeted) {
		this.isRetweeted = isRetweeted;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

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
