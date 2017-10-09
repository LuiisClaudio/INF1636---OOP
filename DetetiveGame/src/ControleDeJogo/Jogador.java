package ControleDeJogo;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	String nome;
	boolean escolhido;
	boolean aindaJogando;
	private List<Carta> mao;
	int total_de_cartas;
	
	int x, y;
	public Jogador(String nomeDado, boolean selecionado, int X, int Y)
	{
		mao=new ArrayList<Carta>();
		nome = new String();
		nome = nomeDado;
		escolhido = selecionado;
		x = X;
		y = Y;
		if(escolhido == true)
			aindaJogando = true;
		total_de_cartas = 0;
	}
	public void sairDoJogo()
	{
		aindaJogando = false;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void inserecarta(Carta a){
		mao.add(a);
		total_de_cartas = total_de_cartas + 1;
	}

	public List<Carta> getMao(){
		return mao;
	}
	public int total_de_cartas_na_mao()
	{
		return mao.size();
		//return total_de_cartas;
	}
	public boolean nome_carta_mao(String nome_carta)
	{
		for(int i = 0; i < total_de_cartas;i++)
		{
			//System.out.println(mao.get(i).nomeCarta);
			if(nome_carta.equals(mao.get(i).nomeCarta) == true)
				return true;
		}
		return false;
	}
	
}
