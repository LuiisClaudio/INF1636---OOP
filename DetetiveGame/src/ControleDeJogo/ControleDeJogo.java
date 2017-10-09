package ControleDeJogo;

import java.util.Scanner;

import javax.swing.JCheckBox;

import jogoInterface.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ControleDeJogo extends Observable {
	public Jogador vet_player[];
	public Tabuleiro tab;
	boolean fim_de_jogo;
	boolean fim_jogada;
	boolean fim_palpite;
	boolean fim_acusacao;
	int vez_player[];
	int vez_palpite[];
	int qtd_player;
	int qtd_player_jogando;
	public int contador;
	public int valor_dados;
	public int index_player;
	private Deck cartas;
	private List<Carta> resposta_final;
	private ArrayList<String> para_refutar;
	public ShowDados mostraDados;
	Comodo comodos[];
	Arma armas[];
	private String vet_palpite[];
	private String vet_acusacao[];

	private ArrayList<String> JogAtivos;

	public ControleDeJogo(Observer c, ArrayList<String> Jogando) {
		
		addObserver(c);
		vet_palpite = new String[3];
		vet_acusacao = new String[3];
		JogAtivos = Jogando;
		System.out.println(JogAtivos);
		// addObserver(d);
		tab = Tabuleiro.getInstance();
		comodos = new Comodo[9];
		// System.out.println(comodos[0].num_arma[0]);
		inicializa_comodo();
		armas = new Arma[6];
		distribui_armas();
		bota_arma_no_comodo();
		//mostra_comodos();
		// mostra_armas();
		qtd_player = 6;
		vet_player = new Jogador[qtd_player];
		vez_player = new int[qtd_player];
		vez_palpite = new int[qtd_player];
		mostraDados = new ShowDados();
		cartas = new Deck();
		addObserver(mostraDados);
		fim_de_jogo = false;
		fim_jogada = false;
		qtd_player = 6;
		contador = 0;
		valor_dados = 0;
		index_player = 0;
		int max_valor_dados = 12;
		fim_palpite = false;
		fim_acusacao = false;
		resposta_final = new ArrayList<Carta>();
		para_refutar = new ArrayList<String>();
		inicializa_vet_player();
		qtd_player_jogando = num_playerJogando();		
		inicializa_vez_player();
		inicializa_vez_palpite();
		//System.out.println(vez_player[0] +"  1:" +vez_player[1] +"  2:" +vez_player[2]);
		define_resposta();
		distrib_cartas();
		mostra_resposta_final();
		//salva_jogo();
		//carrega_jogo();
		System.out.println("TEST PLS WORK"+ vet_palpite[0] +"  |  "+ vet_palpite[1] +"  |  "+ vet_palpite[2]);
	}

	void inicializa_vet_player() {
		if (JogAtivos.contains("Srta. Scarlet")) {
			vet_player[0] = new Jogador("Srt. Scarlet", true, 8, 25); // Vermelho
		} else {
			vet_player[0] = new Jogador("Srt. Scarlet", false, 8, 25);
		}

		if (JogAtivos.contains("Coronel Mustard")) {
			vet_player[1] = new Jogador("Coronel Mustard", true, 1, 18); // Amarelo
		} else {
			vet_player[1] = new Jogador("Coronel Mustard", false, 1, 18);
		}
		// vet_player[1] = new Jogador("Coronel Mustard", true, 1, 18);//Amarelo

		if (JogAtivos.contains("Sra. White")) {
			vet_player[2] = new Jogador("Sra. White", true, 10, 1);// Branco
		} else {
			vet_player[2] = new Jogador("Sra. White", false, 10, 1);// Branco
		}
		// vet_player[2] = new Jogador("Sra. White", true, 10,1 );//Branco

		if (JogAtivos.contains("Rev. Green")) {
			vet_player[3] = new Jogador("Green", true, 15, 1);// Verde
		} else {
			vet_player[3] = new Jogador("Green", false, 15, 1);// Verde
		}

		// vet_player[3] = new Jogador("Green", true, 15, 1);// Verde]

		if (JogAtivos.contains("Sra. Peacock")) {
			vet_player[4] = new Jogador("Srt. Peacock", true, 24, 7);// Azul
		} else {
			vet_player[4] = new Jogador("Srt. Peacock", false, 24, 7);// Azul
		}
		// vet_player[4] = new Jogador("Srt. Peacock", true, 24, 7);//Azul
		if (JogAtivos.contains("Professor Plum")) {
			vet_player[5] = new Jogador("Plum", true, 24, 20);// Roxo
		} else {
			vet_player[5] = new Jogador("Plum", false, 24, 20);// Roxo
		}
		// vet_player[5] = new Jogador("Plum", true, 24, 20);//Roxo
		System.out.println("Vetplayer" + vet_player[1].escolhido);
	}

	void inicializa_comodo() {
		for (int i = 0; i < comodos.length; i++) {
			comodos[i] = new Comodo();
		}

		comodos[0].set_nome("Sala de Estar");
		comodos[0].set_num_comodo(0);
		comodos[1].set_nome("Sala de Jantar");
		comodos[1].set_num_comodo(1);
		comodos[2].set_nome("Cozinha");
		comodos[2].set_num_comodo(2);
		comodos[3].set_nome("Sala de Musica");
		comodos[3].set_num_comodo(3);
		comodos[4].set_nome("Jardim de Inverno");
		comodos[4].set_num_comodo(4);
		comodos[5].set_nome("Salão de Jogos");
		comodos[5].set_num_comodo(5);
		comodos[6].set_nome("Biblioteca");
		comodos[6].set_num_comodo(6);
		comodos[7].set_nome("Escritorio");
		comodos[7].set_num_comodo(7);
		comodos[8].set_nome("Entrada");
		comodos[8].set_num_comodo(8);

	}

	void mostra_comodos() {
		int n = comodos.length;
		for (int i = 0; i < n; i++) {
			System.out.printf("%s, %d %d\n", comodos[i].nome, comodos[i].num_comodo, comodos[i].num_arma);
		}
	}

	public void inicializa_vez_palpite()
	{
		for (int i = 0; i < qtd_player; i++) {
			if (vet_player[i].escolhido) {
				vez_palpite[i] = 0;
			} else {
				vez_palpite[i] = -1;
			}
		}
	}
	void inicializa_vez_player() {
		for (int i = 0; i < qtd_player; i++) {
			if (vet_player[i].escolhido) {
				vez_player[i] = 0;
			} else {
				vez_player[i] = -1;
			}
		}
		// vez_player[0] = -1;
		// vez_player[3] = -1;
		// vez_player[5] = -1;
	}

	void distribui_armas() 
	{
		int n = armas.length;
		for (int i = 0; i < n; i++) {
			armas[i] = new Arma(false);
		}
		boolean comodo_escolhido[] = new boolean[9];
		for (int i = 0; i < 9; i++)
			comodo_escolhido[i] = false;
		String nomeArmas[] = new String[n];
		nomeArmas[0] = "Corda";
		nomeArmas[1] = "Cano";
		nomeArmas[2] = "Faca";
		nomeArmas[3] = "Chave Inglesa";
		nomeArmas[4] = "Castical";
		nomeArmas[5] = "Revolver";
		
		int cont = 0;
		while (cont < n) {
			Random gerador = new Random();
			int r = gerador.nextInt(9);
			if (comodo_escolhido[r] == false) {
				comodo_escolhido[r] = true;
				armas[cont].set_num_arma(cont);
				armas[cont].set_nome(nomeArmas[cont]);
				armas[cont].set_comodo(r);
				armas[cont].set_alocado(true);
				cont = cont + 1;
			}
		}
	}
	void bota_arma_no_comodo()
	{
		for(int i = 0; i < armas.length; i++)
		{
			comodos[armas[i].get_num_comodo()].set_arma_comodo(armas[i].num_arma);
		}
	}
	void mostra_armas() {
		int n = armas.length;
		for (int i = 0; i < n; i++) {
			System.out.printf("%s, %d, %b\n", armas[i].nome, armas[i].comodo, armas[i].alocado);
		}
	}
	public String nome_da_arma_pelo_comodo(int index_comodo)
	{
		if (comodos[index_comodo].get_num_arma() == -1)
		{
			return "Sem arma";
		}
		return armas[comodos[index_comodo].get_num_arma()].get_nome();
	}
	public void inicia_jogo() {
		boolean jogada;
		int continuar_jogar;
		Scanner scanner = new Scanner(System.in);
		int index_vez_player;
		int ask;
		while (fim_de_jogo == false) {
			inicializa_vez_player();
			System.out.println("");
			System.out.println("Deseja jogar? Se sim, aperte 1; Se nao, aperte qualquer outro caracter");
			continuar_jogar = scanner.nextInt();
			// Deve se implementar ainda o dado
			if (continuar_jogar == 1) {
				while (fim_jogada == false) {
					// mostra_vez();
					index_vez_player = controla_vez_jogada();
					System.out.printf("vez_jogador: %d", index_vez_player);
					if (index_vez_player == -1) {
						fim_de_jogo = true;
						break;
					}
					// jogada(index_vez_player);
					System.out.printf("Deseja dar quit? Então aperte -1");
					ask = scanner.nextInt();
					if (ask == -1) {
						continuar_jogar = -1;
						fim_jogada = true;
						break;
					}

				}
			} else {
				System.out.printf("Jogo finalizado!\n");
				fim_de_jogo = true;
			}
		}
	}

	// Deverá retornar a primeira ocorrencia de quem tiver menos jogadas se o
	// jogador estiver participando
	int controla_vez_jogada() {
		int maior, maior_index, primeiro_nao_nulo = 0, ultimo_nulo = qtd_player - 1;
		// Esse while descobre a primeira ocorrencia do player escolhido
		while (vez_player[primeiro_nao_nulo] == -1) {
			primeiro_nao_nulo = primeiro_nao_nulo + 1;
			if (primeiro_nao_nulo == qtd_player)
				return -1;// Caso nenhum jogador esteja jogando
		}
		// Tratar o caso dos ultimos jogadores serem nulo
		while (vez_player[ultimo_nulo] == -1) {
			ultimo_nulo = ultimo_nulo - 1;
		}
		// System.out.printf("Ultimo Nulo:%d\n", ultimo_nulo);
		maior = vez_player[primeiro_nao_nulo];
		maior_index = primeiro_nao_nulo;
		// System.out.printf("Primeiro M_Index:%d, Primeiro maior:%d\n",
		// maior_index, maior);
		for (int i = 0; i < qtd_player; i++) {
			if ((vez_player[i] >= 0) && (maior >= vez_player[i])) {
				// System.out.printf("Maior:%d, M_Index:%d\n", maior,
				// maior_index);
				maior = vez_player[i];
				maior_index = i;
				if (maior_index == ultimo_nulo) {
					// System.out.printf("Ultimo Nulo:%d\n", ultimo_nulo);
					maior = vez_player[i];
					for (int j = 0; j < qtd_player; j++) {
						if (vez_player[j] == maior) {
							vez_player[j] = vez_player[j] + 1;
							return j;
						}
					}
				}
			}
		}
		if (vez_player[maior_index] >= 0)
			vez_player[maior_index] = vez_player[maior_index] + 1;
		return maior_index;
	}
	
	public int controla_vez_palpite(int index_player) {
		int maior, maior_index, primeiro_nao_nulo = 0, ultimo_nulo = qtd_player - 1;
		System.out.printf("\n%d\n", index_player);
		for(int i = 0; i <= index_player; i++)
		{
			if(vez_palpite[i] != -1)
			{
				vez_palpite[i] = 1;
			}
		}
		//for(int i = 0; i < 6; i++)
			//System.out.printf("%d ", vez_palpite[i]);
		System.out.printf("\n");
		// Esse while descobre a primeira ocorrencia do player escolhido
		while (vez_palpite[primeiro_nao_nulo] == -1) {
			primeiro_nao_nulo = primeiro_nao_nulo + 1;
			if (primeiro_nao_nulo == qtd_player)
				return -1;// Caso nenhum jogador esteja jogando
		}
		// Tratar o caso dos ultimos jogadores serem nulo
		while (vez_palpite[ultimo_nulo] == -1) {
			ultimo_nulo = ultimo_nulo - 1;
		}
		// System.out.printf("Ultimo Nulo:%d\n", ultimo_nulo);
		maior = vez_palpite[primeiro_nao_nulo];
		maior_index = primeiro_nao_nulo;
		// System.out.printf("Primeiro M_Index:%d, Primeiro maior:%d\n",
		// maior_index, maior);
		for (int i = 0; i < qtd_player; i++) {
			if ((vez_palpite[i] >= 0) && (maior >= vez_palpite[i])) {
				// System.out.printf("Maior:%d, M_Index:%d\n", maior,
				// maior_index);
				maior = vez_palpite[i];
				maior_index = i;
				if (maior_index == ultimo_nulo) {
					// System.out.printf("Ultimo Nulo:%d\n", ultimo_nulo);
					maior = vez_palpite[i];
					for (int j = 0; j < qtd_player; j++) {
						if (vez_palpite[j] == maior) {
							vez_palpite[j] = vez_palpite[j] + 1;
							return j;
						}
					}
				}
			}
		}
		if (vez_palpite[maior_index] >= 0)
			vez_palpite[maior_index] = vez_palpite[maior_index] + 1;
		return maior_index;
	}
	public void chama_refutacao() {
		// inicializa_vez_palpite();
		int index_vez_refutacao = 0, index_player_aux = index_player;
		for (int i = 0; i < qtd_player_jogando - 1; i++) {
			index_vez_refutacao = controla_vez_palpite(index_player_aux);
			System.out.printf("%d index_vez_refutacao\n", index_vez_refutacao);
			index_player_aux = index_vez_refutacao;
			if (verifica_se_possui_carta(index_player_aux) == true) {
				System.out.println("Refutada");
				fim_palpite = false;
				new TelaRefutar(para_refutar);
				break;
			} else {
				fim_palpite = false;
				System.out.println("To no else");
			}
		}
	}

	public boolean verifica_se_possui_carta(int index_player)
	{
		int qtd_cartas = vet_player[index_player].total_de_cartas_na_mao();
		if(para_refutar.size() > 0)
		{
			for(int i = 0; i < para_refutar.size(); i++)
			{
				para_refutar.remove(i);
			}
		}
		if(vet_player[index_player].nome_carta_mao(vet_palpite[0]) == true)
		{
			para_refutar.add(vet_palpite[0]);
		}
		else if(vet_player[index_player].nome_carta_mao(vet_palpite[1])==true) 
		{
			para_refutar.add(vet_palpite[1]);
		}
		else if(vet_player[index_player].nome_carta_mao(vet_palpite[2]) == true)
		{
			para_refutar.add(vet_palpite[2]);
		}
		if(para_refutar.size() > 0)
		{
			for(int i = 0; i < para_refutar.size(); i++)
				System.out.println("Para refutar " + para_refutar.get(i));
			return true;
		}
		return false;
	}
	
	public void jogada() {
		index_player = controla_vez_jogada();
		fim_jogada = false;
		int dado1 = sorteia_dado();
		int dado2 = sorteia_dado();

		mostraDados.Exibe(dado1, dado2);
		setChanged();
		notifyObservers();
		// valor_dados = dado1 + dado2-1;
		valor_dados = dado1 + dado2;
		tab.limpa_memoria_coordenada();
		tab.limpa_memoria_movimento();
		contador = 0;
		System.out.printf("\tValor real da COORDENADA de cont:%d e Coordenada(X,Y):(%d,%d)\n", contador,
				vet_player[index_player].x, vet_player[index_player].y);
		return;
	}

	public boolean pedeMovimentoTabuleiro(int index_vez_player, char movimento) {
		// Move-se pelo tabuleiro
		// tab.desenhaTabuleiro();
		if (pede_movimento(index_vez_player, movimento) == true) {
			contador++;

			setChanged();
			notifyObservers();

			return true;
		}
		return false;
	}

	public boolean pede_movimento(int index_jogador, char movimento) {
		tab.xi = vet_player[index_jogador].x;// tab.xi = player.x;
		tab.yi = vet_player[index_jogador].y;// tab.yi = player.y;
		boolean validade_de_movimento = tab.move_se(index_jogador, movimento, contador);
		if (validade_de_movimento == true) {
			vet_player[index_jogador].x = tab.xf;// player.x = tab.xf;//tem que
													// confimar se muda por
													// referencia
			vet_player[index_jogador].y = tab.yf;// player.y = tab.yf;//tem que
													// confimar se muda por
													// referencia
			return validade_de_movimento;
		}

		return validade_de_movimento;
	}

	public boolean presente_na_porta(int index_jogador) {
		// System.out.println(tab.tabuleiro[vet_player[index_jogador].x][vet_player[index_jogador].y].simbolo);
		// System.out.printf("%d %d", vet_player[index_jogador].y,
		// vet_player[index_jogador].x);
		if (tab.tabuleiro[vet_player[index_jogador].y][vet_player[index_jogador].x].simbolo == 'P') {
			return true;
		}
		return false;
	}

	public int comodo_porta(int index_player) {
		int x = vet_player[index_player].x;
		int y = vet_player[index_player].y;
		if ((x == 7) & (y == 19)) {
			return 0;
		} else if ((x == 7) & (y == 17)) {
			return 1;
		} else if ((x == 8) & (y == 13)) {
			return 1;
		} else if ((x == 5) & (y == 8)) {
			return 2;
		} else if ((x == 8) & (y == 6)) {
			return 3;
		} else if ((x == 10) & (y == 9)) {
			return 3;
		} else if ((x == 17) & (y == 3)) {
			return 3;
		} else if ((x == 15) & (y == 9)) {
			return 3;
		} else if ((x == 19) & (y == 6)) {
			return 4;
		} else if ((x == 18) & (y == 10)) {
			return 5;
		} else if ((x == 18) & (y == 21)) {
			return 5;
		} else if ((x == 23) & (y == 14)) {
			return 5;
		} else if ((x == 21) & (y == 14)) {
			return 5;
		} else if ((x == 17) & (y == 17)) {
			return 6;
		} else if ((x == 12) & (y == 18)) {
			return 8;
		} else if ((x == 16) & (y == 21)) {
			return 8;
		} else if ((x == 13) & (y == 18)) {
			return 8;
		}
		return -1;
	}

	boolean faz_palpite(int index_jogador) {

		return false;
	}

	void mostra_vez() {
		for (int i = 0; i < qtd_player; i++) {
			System.out.printf("%d ", vez_player[i]);
		}
		System.out.println();
	}

	int sorteia_dado() {
		Random gerador = new Random();
		return gerador.nextInt(6) + 1;
	}

	public boolean define_resposta() {
		try {
			resposta_final = cartas.getResp();
			return true;
		} catch (ErroGetRand e) {
			return false;
		}
	}
	public boolean retorna_final()
	{
		  return fim_de_jogo;
	}
	public boolean distrib_cartas() 
	{
		int cont1 = cartas.getPessLeft(), cont2 = cartas.getArmsLeft(), cont3 = cartas.getComodsLeft(), i = 0;
		boolean jogador_sorteado[] = new boolean[qtd_player];
		int cont = 0;
		int cartas_restantes = cartas.getCartasLeft();
		while (cartas_restantes > 0)
		{
			for (int j = 0; j < qtd_player; j++) 
			{	
				if (vez_player[j] == -1) 
				{
					jogador_sorteado[j] = true;
				} else {
					jogador_sorteado[j] = false;
				}
			}
			while (cont < qtd_player_jogando) 
			{
				Random gerador = new Random();
				int r = gerador.nextInt(qtd_player);
				if (jogador_sorteado[r] == false) 
				{
					cont = cont + 1;
					jogador_sorteado[r] = true;
					System.out.printf("R:%d", r);

					try {
						vet_player[r].inserecarta(cartas.getRandCarta());
					} catch (ErroGetRand e) {
						return false;
					}
				}
			}
			cont = 0;
		}
		return true;
	}
	public Jogador[] retornajogadores() {
		return vet_player;
	}

	public void salva_jogo() {
		try {
			PrintWriter writer = new PrintWriter("ArquivoTxt/jogador.txt", "UTF-8");
			// Guarda as posicoes dos jogadores
			writer.println();
			for (int i = 0; i < vet_player.length; i++) {
				writer.printf("J %d %d %d %b %b\n", vet_player[i].x, vet_player[i].y, vet_player[i].total_de_cartas,
						vet_player[i].escolhido, vet_player[i].aindaJogando);
				// Falta a lista de cartas aqui
			}
			// Mao do jogador
			for (int i = 0; i < vet_player.length; i++) {
				// writer.printf("C \n", vet_player[i].);
				// Falta a lista de cartas aqui
			}
			// Vez dos jogadores
			writer.printf("V ");
			for (int i = 0; i < vet_player.length; i++) {
				writer.printf("%d ", vez_player[i]);
			}
			writer.println();
			for(int i = 0; i <vet_player.length;i++)
			{
				List<Carta> mao = vet_player[i].getMao();
				for(int j = 0; j < mao.size(); j++)
				{
					writer.printf("%d ", mao.get(j).index_carta);
				}
				writer.println();
				
			}
			writer.close();
		} catch (IOException e) {
			// do something
		}

		try {
			PrintWriter writer = new PrintWriter("ArquivoTxt/comodo.txt", "UTF-8");
			for (int i = 0; i < comodos.length; i++) {
				writer.printf("%d\n", comodos[i].num_arma);
				for (int j = 0; j < comodos[i].num_jogador.length; j++) {
					writer.printf("%d ", comodos[i].num_jogador[j]);
				}
				
				writer.println();
			}
			writer.close();
		} catch (IOException e) {
			// do something
		}

		try {
			PrintWriter writer = new PrintWriter("ArquivoTxt/arma.txt", "UTF-8");
			// Status armas
			for (int i = 0; i < armas.length; i++) {
				writer.printf("%d %d %b ", armas[i].num_arma, armas[i].comodo, armas[i].alocado);
			}
			// writer.println();
			writer.close();
		} catch (IOException e) {
			// do something
		}

		try {
			PrintWriter writer = new PrintWriter("ArquivoTxt/cartas.txt", "UTF-8");
			
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	public void carrega_jogo() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("ArquivoTxt/jogador.txt"));
			int[] tall = new int[100];
			int k = 0;
			System.out.println("Entrei no try");
			while (scanner.hasNextInt()) {
				System.out.println("Entrei");
				tall[k] = scanner.nextInt();
				k++;
			}
			for (int i = 0; i < k; i++) {
				System.out.printf("%d ", tall[i]);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		/*
		 * try (BufferedReader br = new BufferedReader(new
		 * FileReader("ArquivoTxt/jogador.txt"))) { StringBuilder sb = new
		 * StringBuilder(); String line = br.readLine();
		 * //System.out.println(line); char c;
		 * 
		 * 
		 * while (line != null) { int cont = 0; sb.append(line);
		 * sb.append(System.lineSeparator()); line = br.readLine(); if (line ==
		 * null) break; c = line.charAt(0); if(c == 'J') { vet_player[cont].x =
		 * Integer.toString(line.charAt(2)).charAt(0); vet_player[cont].y =
		 * Integer.toString(line.charAt(2)).charAt(0); cont++; } if(c == 'V') {
		 * for(int i = 1; i < line.length(); i++) { int index = 0; c =
		 * line.charAt(i); //System.out.println(c); if(c != ' ') {
		 * System.out.println(Integer.toString(c).charAt(0)); vez_player[index]
		 * = Integer.toString(c).charAt(0); //System.out.printf("%d ",
		 * vez_player[index]); index++; } } } //System.out.println(line); } //
		 * String everything = sb.toString(); } catch (FileNotFoundException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		try (BufferedReader br = new BufferedReader(new FileReader("ArquivoTxt/comodo.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			// System.out.println(line);
			char c;
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				if (line == null)
					break;
				for (int j = 0; j < 2; j++) {
					c = line.charAt(j);
				}
				// System.out.println(line);
			}
			// String everything = sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("ArquivoTxt/arma.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			// System.out.println(line);
			char c;
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				if (line == null)
					break;
				for (int j = 0; j < 2; j++) {
					c = line.charAt(j);
				}
				// System.out.println(line);
			}
			// String everything = sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int num_playerJogando() {
		int i = 0, j = 0;
		while (j < qtd_player) {
			if (vet_player[j].escolhido) {
				i++;
			}
			j++;
		}
		return i;
	}
	public void insere_palpite(String[] palpite){
		for(int i = 0; i < palpite.length; i++)
			vet_palpite[i] = palpite[i]; 
		//this.vet_palpite = palpite ;
		
	}
	public void insere_acusacao(String[] acusacao){
		for(int i = 0; i < acusacao.length; i++)
			vet_acusacao[i] = acusacao[i]; 
	}
	public String retorna_palpite_acusado()
	{
		return vet_palpite[1];
	}
	public void retorno_confirmar_palpite()
	{
		fim_palpite = true;
		inicializa_vez_palpite();
		chama_refutacao();
		//for(int i = 0; i < vet_palpite.length; i++)
			//System.out.println("Estou no controle de jogo" + vet_palpite[i] +" i: " + index_player);
	}
	public void retorno_confirmar_acusacao() {
		fim_acusacao = true;
		if (define_vencedor() == true) {
			new TelaVencedor(index_player);
			System.out.printf("O jogador %d eh o vencedor\n", index_player);
	
			
		} else {
			System.out.printf("O jogador %d esta eliminado\n", index_player);
		}
	}
	public boolean ja_confirmou_palpite()
	{
		return fim_palpite;
	}
	public boolean ja_confirmou_acusacao()
	{
		return fim_acusacao;
	}
	public void mostra_resposta_final()
	{
		System.out.println("Resposta final: "+ resposta_final.get(0).getnome());
		System.out.println("Resposta final: "+ resposta_final.get(1).getnome());
		System.out.println("Resposta final: "+ resposta_final.get(2).getnome());
	}
	public boolean define_vencedor()
	{
		System.out.println("------------");
		for(int i = 0; i < vet_acusacao.length; i++)
		{
			System.out.println(vet_acusacao[i]);
			System.out.println(resposta_final.get(i).getnome());
			if(vet_acusacao[i].equals(resposta_final.get(i).getnome()) == true)
			{
				fim_de_jogo = true;	 
			}
			else
			{
				fim_acusacao = false;
				fim_de_jogo = false;
				tira_jogador(index_player);
				break;
			}
		}
		System.out.println("ˆˆˆˆˆˆˆˆˆˆˆˆ");
		return fim_de_jogo;
	}
	public void tira_jogador(int index_perdedor)
	{
		vez_player[index_perdedor] = -1;
		qtd_player_jogando--;
		if(qtd_player_jogando == 1)
		{
			new TelaVencedor(controla_vez_jogada());
		}
	}
}