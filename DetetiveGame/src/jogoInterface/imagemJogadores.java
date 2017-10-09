package jogoInterface;

import ControleDeJogo.*;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.*;

public class imagemJogadores extends JPanel implements KeyListener, ActionListener, Observer {
	public JButton[] jogadores;
	float local_xy[][];
	int maximo_de_jogadores;
	int unidade_de_movimento;
	int size_jogador;
	int index_player;
	ControleDeJogo controlaJogadores;
	private Jogador osmano[];
	JButton jogarDados;
	private TelaPalpite TestePalpite;
	private TelaAcusacao TesteAcusacao;

	public imagemJogadores(ArrayList<String> Jogando) {

		osmano = new Jogador[6];
		jogarDados = new JButton("Jogar Dados");
		index_player = 0;
		maximo_de_jogadores = 6;
		unidade_de_movimento = 25;
		size_jogador = 23;

		controlaJogadores = new ControleDeJogo(this, Jogando);

		jogadores = new JButton[maximo_de_jogadores];
		local_xy = new float[maximo_de_jogadores][2];
		jogadores[0] = new JButton();
		jogadores[1] = new JButton();
		jogadores[2] = new JButton();
		jogadores[3] = new JButton();
		jogadores[4] = new JButton();
		jogadores[5] = new JButton();

		jogarDados.setBounds(10, 10, 100, 20);
		jogarDados.setVisible(true);
		jogarDados.addActionListener(this);

		osmano = controlaJogadores.retornajogadores();

		TratadorBotJogadores mostraCartasJogador1 = new TratadorBotJogadores(jogadores[0], osmano[0]);
		jogadores[0].setBackground(Color.RED);
		jogadores[0].setForeground(Color.GRAY);
		jogadores[0].setContentAreaFilled(true);
		jogadores[0].setOpaque(true);
		jogadores[0].setBounds(50, 30, size_jogador, size_jogador);
		jogadores[0].setBorderPainted(false);
		jogadores[0].setName("Jogador 1");
		jogadores[0].setFocusable(false);
		jogadores[0].addActionListener(mostraCartasJogador1);

		TratadorBotJogadores mostraCartasJogador2 = new TratadorBotJogadores(jogadores[1], osmano[1]);
		jogadores[1].setBackground(Color.YELLOW);
		jogadores[1].setForeground(Color.GRAY);
		jogadores[1].setBounds(1, 1, size_jogador, size_jogador);
		jogadores[1].setContentAreaFilled(true);
		jogadores[1].setOpaque(true);
		jogadores[1].setBorderPainted(false);
		jogadores[1].setName("Jogador 2");
		jogadores[1].setFocusable(false);
		jogadores[1].addActionListener(mostraCartasJogador2);

		TratadorBotJogadores mostraCartasJogador3 = new TratadorBotJogadores(jogadores[2], osmano[2]);
		jogadores[2].setBackground(Color.WHITE);
		jogadores[2].setForeground(Color.GRAY);
		jogadores[2].setContentAreaFilled(true);
		jogadores[2].setOpaque(true);
		jogadores[2].setBounds(1, 1, size_jogador, size_jogador);
		jogadores[2].setBorderPainted(false);
		jogadores[2].setName("Jogador 3");
		jogadores[2].setFocusable(false);
		jogadores[2].addActionListener(mostraCartasJogador3);

		TratadorBotJogadores mostraCartasJogador4 = new TratadorBotJogadores(jogadores[3], osmano[3]);
		jogadores[3].setBackground(Color.GREEN);
		jogadores[3].setForeground(Color.GRAY);
		jogadores[3].setContentAreaFilled(true);
		jogadores[3].setOpaque(true);
		jogadores[3].setBounds(1, 1, size_jogador, size_jogador);
		jogadores[3].setBorderPainted(false);
		jogadores[3].setName("Jogador 4");
		jogadores[3].setFocusable(false);
		jogadores[3].addActionListener(mostraCartasJogador4);

		TratadorBotJogadores mostraCartasJogador5 = new TratadorBotJogadores(jogadores[4], osmano[4]);
		jogadores[4].setBackground(Color.BLUE);
		jogadores[4].setForeground(Color.GRAY);
		jogadores[4].setContentAreaFilled(true);
		jogadores[4].setOpaque(true);
		jogadores[4].setBounds(1, 1, size_jogador, size_jogador);
		jogadores[4].setBorderPainted(false);
		jogadores[4].setName("Jogador 5");
		jogadores[4].setFocusable(false);
		jogadores[4].addActionListener(mostraCartasJogador5);

		TratadorBotJogadores mostraCartasJogador6 = new TratadorBotJogadores(jogadores[5], osmano[5]);
		jogadores[5].setBackground(Color.PINK);
		jogadores[5].setForeground(Color.GRAY);
		jogadores[5].setContentAreaFilled(true);
		jogadores[5].setOpaque(true);
		jogadores[5].setBounds(1, 1, size_jogador, size_jogador);
		jogadores[5].setBorderPainted(false);
		jogadores[5].setName("Jogador 6");
		jogadores[5].setFocusable(false);
		jogadores[5].addActionListener(mostraCartasJogador6);

		local_xy[0][0] = controlaJogadores.vet_player[0].getX() * 30.5f;// Vermelho
		local_xy[0][1] = controlaJogadores.vet_player[0].getY() * 26.5f;

		local_xy[1][0] = controlaJogadores.vet_player[1].getX() * 65;// *415.4f;//Amarelo
		local_xy[1][1] = controlaJogadores.vet_player[1].getY() * 26.8f;// *3.3f;

		local_xy[2][0] = controlaJogadores.vet_player[2].getX() * 28.7f;// Branco
		local_xy[2][1] = controlaJogadores.vet_player[2].getY() * 60;

		local_xy[3][0] = controlaJogadores.vet_player[3].getX() * 27.5f;// Verde
		local_xy[3][1] = controlaJogadores.vet_player[3].getY() * 60;

		local_xy[4][0] = controlaJogadores.vet_player[4].getX() * 26.6f;// *2.7f;//Azul
		local_xy[4][1] = controlaJogadores.vet_player[4].getY() * 30f;// *69;

		local_xy[5][0] = controlaJogadores.vet_player[5].getX() * 26.8f;// Roxo
		local_xy[5][1] = controlaJogadores.vet_player[5].getY() * 26.7f;
		setLocalJogadores();

		// setFocusTraversalKeysEnabled(false);
		setLayout(null);
		setFocusable(true);
		setBounds(0, 0, 1000, 1000);
		setOpaque(false);
		add(jogadores[0]);
		add(jogadores[1]);
		add(jogadores[2]);
		add(jogadores[3]);
		add(jogadores[4]);
		add(jogadores[5]);
		add(jogarDados);
		// add(mostraCartasJogador1.cartaJogador1);
		// add(mostraCartasJogador2.cartaJogador2);
		// add(mostraCartasJogador3.cartaJogador3);
		// add(mostraCartasJogador4.cartaJogador4);
		// add(mostraCartasJogador5.cartaJogador5);
		// add(mostraCartasJogador6.cartaJogador6);
		addKeyListener(this);

	}

	void setLocalJogadores() {
		for (int i = 0; i < maximo_de_jogadores; i++) {
			jogadores[i].setLocation((int) local_xy[i][0], (int) local_xy[i][1]);
		}
	}

	public void andaTabuleiro(int indexJogador, char movimento) {
		switch (movimento) {
		case 'w':
			local_xy[indexJogador][1] = local_xy[indexJogador][1] - unidade_de_movimento;
			break;
		case 's':
			local_xy[indexJogador][1] = local_xy[indexJogador][1] + unidade_de_movimento;
			break;
		case 'a':
			local_xy[indexJogador][0] = local_xy[indexJogador][0] - unidade_de_movimento;
			break;
		case 'd':
			local_xy[indexJogador][0] = local_xy[indexJogador][0] + unidade_de_movimento;
			break;
		}
		jogadores[indexJogador].setLocation((int) local_xy[indexJogador][0], (int) local_xy[indexJogador][1]);
	}

	public void estadoJogador(int indexJogador, boolean estado) {
		jogadores[indexJogador].setEnabled(estado);
		jogadores[indexJogador].setVisible(estado);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {
		if (jogarDados.isEnabled() == true) {
			return;
		}
		System.out.printf("index_player: %d, valor_dados %d\n", controlaJogadores.index_player,
				controlaJogadores.valor_dados);
		int index_player = controlaJogadores.index_player;
		if (e.getKeyChar() == 'd') {
			if (controlaJogadores.pedeMovimentoTabuleiro(index_player, 'd') == true) {
				// System.out.println("d");
				andaTabuleiro(index_player, 'd');
			}
		} else if (e.getKeyChar() == 'a') {
			if (controlaJogadores.pedeMovimentoTabuleiro(index_player, 'a') == true) {
				// System.out.println("a");
				andaTabuleiro(index_player, 'a');
			}
		} else if (e.getKeyChar() == 's') {
			if (controlaJogadores.pedeMovimentoTabuleiro(index_player, 's') == true) {
				// System.out.println("a");
				andaTabuleiro(index_player, 's');
			}
		} else if (e.getKeyChar() == 'w') {
			if (controlaJogadores.pedeMovimentoTabuleiro(index_player, 'w') == true) {
				andaTabuleiro(index_player, 'w');
			}
		} else if (e.getKeyChar() == 'e') 
		{
			//System.out.println("eeeee");
			if (controlaJogadores.presente_na_porta(index_player) == true) {
				int index_comodo =  controlaJogadores.comodo_porta(index_player);
				if ((index_comodo != -1) & (controlaJogadores.ja_confirmou_palpite() == false)) {
					System.out.println("esse aqui eh o resultado 2:" + palpitou()[2]);
					//System.out.println("esse aqui eh o resultado 1:" + controlaJogadores.retorna_palpite_acusado());
				}
				jogarDados.setEnabled(true);
			}
		}
		else if (e.getKeyChar() == 'f') 
		{
			//System.out.println("ffffff");
			controlaJogadores.mostra_resposta_final();
			if ((controlaJogadores.ja_confirmou_acusacao() == false)) {
				System.out.println("esse aqui eh o resultado 2:" + acusou()[2]);
			}
			jogarDados.setEnabled(true);
		}
		else if (e.getKeyChar() == 'r') 
		{
			controlaJogadores.salva_jogo();
		}
		if (controlaJogadores.valor_dados == controlaJogadores.contador) {
			jogarDados.setEnabled(true);
			controlaJogadores.mostraDados.deixaDadoInvisivel();
			
		}

	}

	public void actionPerformed(ActionEvent e) {
		//if (e.getSource() )
		jogarDados.setEnabled(false);
		controlaJogadores.jogada();
		controlaJogadores.tab.limpa_memoria_tabuleiro();
		controlaJogadores.tab.set_posicao();
	}

	public String[] palpitou() {
		String[] Resposta = new String[3];
	
		TestePalpite = new TelaPalpite(controlaJogadores);
		
		controlaJogadores.insere_palpite(Resposta); ;
		
		System.out.println("SERA?" + Resposta[0] + Resposta[1] + Resposta[2]);
		return Resposta;
	}
	
	public String[] acusou() {
		String[] Resposta = new String[3];
		TesteAcusacao = new TelaAcusacao(controlaJogadores);
		controlaJogadores.insere_acusacao(Resposta);
		System.out.println("SERA?" + Resposta[0] + Resposta[1] + Resposta[2]);
		return Resposta;
	}
	public void vencedor(int nome){
		new TelaVencedor(nome);
	}
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
