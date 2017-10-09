package ControleDeJogo;

public class Arma {
	String nome;
	int num_arma;
	int comodo;
	boolean alocado;
	
	public Arma(boolean ja_alocado)
	{
		alocado = ja_alocado;
	}
	public Arma(String nomeDado, int comodoDado, boolean ja_alocado)
	{
		nome = nomeDado;
		comodo = comodoDado;
		alocado = ja_alocado;
	}
	public void set_num_arma(int numero_arma)
	{
		num_arma = numero_arma;
	}
	public boolean ja_alocado_comodo()
	{
		return alocado;
	}
	public void set_nome(String nomeEscolhido)
	{
		nome = nomeEscolhido;
	}
	public void set_comodo(int comodoEscolhido)
	{
		comodo = comodoEscolhido;
	}
	public void set_alocado(boolean ja_alocado)
	{
		alocado = ja_alocado;
	}
	public int get_num_comodo()
	{
		return comodo;
	}
	public String get_nome()
	{
		return nome;
	}
}
