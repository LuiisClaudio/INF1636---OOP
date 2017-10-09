package ControleDeJogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Tabuleiro {
	private static Tabuleiro instance = null;
	
	Casa tabuleiro[][];
	int xi, yi, xf, yf; // i de inicail e f de final
	int max_dado = 5; // maxima posicao do dado
	int mix_dado = 0; // minima posicao do dado
	int max_dim_x, max_dim_y, min_dim_x, min_dim_y; // maximox e minimos da dim
													// da matrix;
	int memoria_coordenada[][];
	char memoria_movimento[];
	int tamanho_eixo_x;
	int porta[][];
	
	protected Tabuleiro() {
		tabuleiro = new Casa[27][27];
		int tamanho_eixo_x = tabuleiro.length;
		max_dim_x = tamanho_eixo_x;
		max_dim_y = tamanho_eixo_x;
		min_dim_x = 0;
		min_dim_y = 0;
		xi = yi = xf = yf = 0;
		memoria_coordenada = new int[tamanho_eixo_x][2];
		memoria_movimento = new char[tamanho_eixo_x];
		limpa_memoria_movimento();
		limpa_memoria_coordenada();
		
		try (BufferedReader br = new BufferedReader(new FileReader("ArquivoTxt/modeloTabuleiro.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			int i = 0;
			char c;
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				//System.out.println(line);
				if (line == null)
					break;
				for (int j = 0; j < tamanho_eixo_x; j++) {
					c = line.charAt(j);
					tabuleiro[i][j] = new Casa(c);
					//System.out.printf("%c(%d)", c,j);
				}
				//System.out.printf(" [%d]\n",i);
				i++;
				if (i == tamanho_eixo_x + 1)
					break;
			}
			// String everything = sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*for (int i = 0; i < 27; i++) {

			for(int j = 0; j < 27; j++)
			{
				if(tabuleiro[i][j].bloqueio == true)
					System.out.printf("[%d][%d]B ", i,j);
				else 
					System.out.printf("[%d][%d]L ", i, j);
			}
			System.out.println();
		}*/
	}
	
	public static Tabuleiro getInstance() {
	      if(instance == null) {
	         instance = new Tabuleiro();
	      }
	      return instance;
	   }

	public void desenhaTabuleiro() {
		for (int j = 0; j < tamanho_eixo_x; j++) {
			for (int i = 0; i < tamanho_eixo_x; i++) {
				System.out.printf("%c ", tabuleiro[i][j].simbolo);
			}
			System.out.printf("\n");
		}
	}

	public void set_posicao() {

	}

	public void limpa_memoria_tabuleiro() {
		limpa_memoria_movimento();
		limpa_memoria_coordenada();

	}

	void limpa_memoria_movimento() {
		for (int i = 0; i < max_dado + 1; i++)
			memoria_movimento[i] = 0;
	}

	void limpa_memoria_coordenada() {
		for (int i = 0; i < max_dado + 1; i++)
			memoria_coordenada[i][0] = memoria_coordenada[i][1] = 0;
	}

	void mostra_memoria_movimento(char memoria_movimento[]) {
		for (int i = 0; i < max_dado + 1; i++)
			System.out.printf("%c ", memoria_movimento[i]);
		System.out.printf("\n");
	}

	void mostra_memoria_coordenada(int memoria_coordenada[][]) {
		for (int i = 0; i < max_dado + 1; i++)
			System.out.printf("[%d](%d,%d) ", i + 1, memoria_coordenada[i][0], memoria_coordenada[i][1]);
	}

	boolean presente_memoria_movimento(char memoria_movimento[], char movimento) {
		for (int i = 0; i < max_dado + 1; i++) {
			if (memoria_movimento[i] == movimento)
				return true;
		}
		return false;
	}

	boolean presente_memoria_coordenada(int memoria_coordenada[][], int x, int y) {
		for (int i = 0; i < max_dado + 1; i++) {
			if (memoria_coordenada[i][0] == x && memoria_coordenada[i][1] == y)
				return true;
		}
		return false;
	}

	boolean verifica_limite_tabuleiro(int x, int y) {
		if ((x > max_dim_x) || (y > max_dim_y) || (x < min_dim_x) || (y < min_dim_y)) {
			return true;
		}
		return false;
	}

	boolean verifica_bloqueio(int x, int y) {
		System.out.printf("[%d][%d]%b\n", y ,x , tabuleiro[x][y].bloqueio);
		if (tabuleiro[y][x].bloqueio == true)
			return true;
		return false;
	}
	public boolean move_se(int index_jogador, char movimento, int cont) {
		if (cont == 12) {
			System.out.printf("Contador: %d\n", cont);
			return false;
		}
		xf = xi;
		yf = yi;
		System.out.printf("\tValor de cont:%d e Coordenada(Xi,Yi):(%d,%d)\n", cont, xi, yi);
		// System.out.printf("\tValor de cont:%d e Coordenada(Xf,Yf):(%d,%d)\n",
		// cont, xf, yf);
		switch (movimento) {
		case 'w':
			// System.out.println("Entrei em w");
			if (anda_cima() == true) {
				xi = xf;
				yi = yf;
				memoria_movimento[cont] = movimento;
				memoria_coordenada[cont][0] = xf;
				memoria_coordenada[cont][1] = yf;
			} else {
				System.out.println("Movimento invalido");
				return false;
			}
			break;
		case 's':
			if (anda_baixo() == true) {
				xi = xf;
				yi = yf;
				memoria_movimento[cont] = movimento;
				memoria_coordenada[cont][0] = xf;
				memoria_coordenada[cont][1] = yf;
			} else {
				System.out.println("Movimento invalido");
				return false;
			}
			break;
		case 'd':
			if (anda_direita() == true) {
				xi = xf;
				yi = yf;
				memoria_movimento[cont] = movimento;
				memoria_coordenada[cont][0] = xf;
				memoria_coordenada[cont][1] = yf;
			} else {
				System.out.println("Movimento invalido");
				return false;
			}
			break;
		case 'a':
			if (anda_esquerda() == true) {
				xi = xf;
				yi = yf;
				memoria_movimento[cont] = movimento;
				memoria_coordenada[cont][0] = xf;
				memoria_coordenada[cont][1] = yf;
			} else {
				System.out.println("Movimento invalido");
				return false;
			}
			break;
		default:
			System.out.println("Não eh um caracter valido");
			return false;

		}
		System.out.printf("\tValor de cont:%d e Coordenada(Xf,Yf):(%d,%d)\n", cont, xf, yf);

		return true;
	}

	boolean anda_direita() {
		if (verifica_limite_tabuleiro(xf + 1, yf) == true)
			return false;
		if (verifica_bloqueio(xf + 1, yf) == true)
			return false;
		if (presente_memoria_coordenada(memoria_coordenada, xf + 1, yf) == true)
			return false;
		if (xf + 1 < max_dim_x) {
			xf = xf + 1;
			return true;
		}
		return false;
	}

	boolean anda_esquerda() {
		if (verifica_limite_tabuleiro(xf - 1, yf) == true)
			return false;
		if (verifica_bloqueio(xf - 1, yf) == true)
			return false;
		if (presente_memoria_coordenada(memoria_coordenada, xf - 1, yf) == true)
			return false;
		if (xf - 1 >= min_dim_x) {
			xf = xf - 1;
			return true;
		}
		return false;
	}

	boolean anda_cima() {
		if (verifica_limite_tabuleiro(xf, yf - 1) == true)
			return false;
		if (verifica_bloqueio(xf, yf - 1) == true)
			return false;
		if (presente_memoria_coordenada(memoria_coordenada, xf, yf - 1) == true)
			return false;
		if (yf - 1 >= min_dim_y) {
			yf = yf - 1;
			return true;
		}
		return false;
	}

	boolean anda_baixo() {
		if (verifica_limite_tabuleiro(xf, yf + 1) == true)
			return false;
		if (verifica_bloqueio(xf, yf + 1) == true)
			return false;
		if (presente_memoria_coordenada(memoria_coordenada, xf, yf + 1) == true)
			return false;
		if (yf + 1 < max_dim_x) {
			yf = yf + 1;
			return true;
		}
		return false;
	}
}
