package ControleDeJogo;

public class Comodo {
	String nome;
	int num_comodo;
	int num_jogador[];
	int num_arma;
	public Comodo()
	{
		//nome = new String();
		num_jogador = new int[6];
		for(int i = 0; i < num_jogador.length; i++)
		{
			num_jogador[i] = -1;
			num_arma = -1;
		}
	}
	public void set_nome(String nomeEscolhido)
	{
		nome = nomeEscolhido;
	}
	public void set_num_comodo(int index_comodo)
	{
		num_comodo = index_comodo;
	}
	public void set_arma_comodo(int arma)
	{
		num_arma = arma;
	}
	public int get_num_arma()
	{
		return num_arma;
	}
}
