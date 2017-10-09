package ControleDeJogo;

//Cartas
public class Carta {
	String nomeCarta;
	int tipo_carta;
	int index_carta;
	public Carta(String nome){
		nomeCarta = nome;
	}
	public Carta(String nome, int tipo_da_carta, int index_carta){
		nomeCarta = nome;
		tipo_carta = tipo_da_carta;
		this.index_carta = index_carta;
	}
	public String getnome(){
		return this.nomeCarta;
	}
}
