package ControleDeJogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck{ 
	private List<Carta> ListPessoas = new ArrayList<Carta>();
	private List<Carta> ListArmas = new ArrayList<Carta>();
	private List<Carta> ListLocal = new ArrayList<Carta>();
	private List<Carta> lista_cartas = new ArrayList<Carta>();
	private Random general;
	private int num;
	private static int ArmRemov; 
	private static int PessoRemov;
	private static int ComodRemov;
	private static int total_removidas;
	private int total_cartas;
	private int total_cartas_armas;
	private int total_cartas_pessoas;
	private int total_cartas_comodos;
	
	//dando new deck ele preenche os negocio e inicia os contadores em zero
	public Deck(){
		int tipo_comodo = 0;
		int tipo_jogador = 1;
		int tipo_arma = 2;
		total_cartas = 21;
		total_cartas_armas = 6;
		total_cartas_pessoas = 6;
		total_cartas_comodos = 9;
		general = new Random();
		PessoRemov=ArmRemov=ComodRemov=total_removidas=0;
		ListPessoas.add(new Carta("Srta. Scarlet", tipo_jogador, 0));
		ListPessoas.add(new Carta("Coronel Mustard", tipo_jogador, 1));
		ListPessoas.add(new Carta("Sra. White", tipo_jogador, 2 ));
		ListPessoas.add(new Carta("Rev. Green", tipo_jogador, 3));
		ListPessoas.add(new Carta("Sra. Peacock", tipo_jogador, 4));
		ListPessoas.add(new Carta("Professor Plum", tipo_jogador, 5));
		
	
		ListArmas.add(new Carta("Corda",tipo_arma, 0));
		ListArmas.add(new Carta("Cano",tipo_arma, 1));
		ListArmas.add(new Carta("Faca",tipo_arma, 2));
		ListArmas.add(new Carta("Chave Inglesa",tipo_arma, 3));
		ListArmas.add(new Carta("Castical",tipo_arma, 4));
		ListArmas.add(new Carta("Revolver",tipo_arma, 5));
		

		ListLocal.add(new Carta("Biblioteca", tipo_comodo, 6));
		ListLocal.add(new Carta("Cozinha", tipo_comodo, 2));
		ListLocal.add(new Carta("Entrada", tipo_comodo, 8));
		ListLocal.add(new Carta("Escritorio", tipo_comodo, 7));
		ListLocal.add(new Carta("Jardim de Inverno", tipo_comodo, 4));
		ListLocal.add(new Carta("Sala de Estar", tipo_comodo, 0));
		ListLocal.add(new Carta("Sala de Jantar", tipo_comodo, 1));
		ListLocal.add(new Carta("Sala de Musica", tipo_comodo, 3));
		ListLocal.add(new Carta("Salao de Jogos", tipo_comodo, 5));
		
		
		lista_cartas.addAll(ListLocal); 
		lista_cartas.addAll(ListPessoas);
		
		for(int i = 0; i < lista_cartas.size(); i++)
		{
			System.out.println(lista_cartas.get(i).getnome());
		}
	}
	
	//funcao que retorna uma carta aleat�ria de jogador
	public Carta getRandJogador()throws ErroGetRand{
		if(PessoRemov>=6){
			throw new ErroGetRand("N�o h� mais cartas jogadores");
		}
		Carta temp;
		num=general.nextInt(ListPessoas.size());
		
		temp=ListPessoas.get(num);
		ListPessoas.remove(num);
		lista_cartas.remove(total_cartas_comodos - ComodRemov - 1 + num);
		PessoRemov=PessoRemov+1;
		total_removidas = total_removidas + 1;
		return temp;
	}
	
	//funcao que retorna uma carta aleat�ria de arma
	public Carta getRandArma() throws ErroGetRand{
		if(ArmRemov>=6){
			throw new ErroGetRand("Nao h� mais cartas de Armas");
		}
		Carta temp;
		num=general.nextInt(ListArmas.size());
		
		temp=ListArmas.get(num);
		ListArmas.remove(num);
		ArmRemov=ArmRemov+1;
		return temp;
	}
	public Carta getRandCarta() throws ErroGetRand
	{
		if(total_removidas >=total_cartas - total_cartas_armas)
		{
			throw new ErroGetRand("Nao ha mais cartas");
		}
		Carta temp;
		num=general.nextInt(lista_cartas.size());
		
		temp=lista_cartas.get(num);
		lista_cartas.remove(num);
		total_removidas = total_removidas + 1;
		return temp;
	}
	
	//funcao q retorna uma carta aleat�ria de local
	public Carta getRandLocal()throws ErroGetRand{
		if(ComodRemov>=9){
			throw new ErroGetRand("N�o h� mais cartas de comodos");
		}
		Carta temp;
		num=general.nextInt(ListLocal.size());
		lista_cartas.remove(num);
		temp=ListLocal.get(num);
		ListLocal.remove(num);
		ComodRemov=ComodRemov+1;
		total_removidas = total_removidas + 1;
		return temp;
	}
	
	//Funcao que retorna uma lista com a resposta do JOGO
	public List<Carta> getResp() throws ErroGetRand{
		List<Carta> tempList= new ArrayList<Carta>();
		Carta TempCardPess;
		
		TempCardPess= this.getRandJogador();
		
		Carta TempCardArm;
	
		TempCardArm = this.getRandArma();
	
		Carta TempCardLocal;
	
		TempCardLocal = this.getRandLocal();
	
		tempList.add(TempCardPess);
		tempList.add(TempCardArm);
		tempList.add(TempCardLocal);
		
		return tempList;
	}
	
	
	// as statics s�o pra ver se tem alguma carta livre
	static int getArmsLeft(){
		return (6-ArmRemov);
	}
	
	static int getPessLeft(){
		return (6-PessoRemov);
	}
	
	static int getComodsLeft(){
		return (9-ComodRemov);
	}
	static int getCartasLeft(){
		return (15- total_removidas);
	}
}

