package jogoInterface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ControleDeJogo.Jogador;

public class TratadorBotJogadores implements ActionListener {
	Component c;
	Jogador Jogam;
	ExibeCarta cartaJogador1;
	ExibeCarta cartaJogador2;
	ExibeCarta cartaJogador3;
	ExibeCarta cartaJogador4;
	ExibeCarta cartaJogador5;
	ExibeCarta cartaJogador6;
	public TratadorBotJogadores(Component x, Jogador jog){
		c=x;
		Jogam = new Jogador("a",true, 1,1);
		Jogam =jog;
		
		cartaJogador1 = new ExibeCarta(Jogam.getMao());
		cartaJogador2 = new ExibeCarta(Jogam.getMao());
		cartaJogador3 = new ExibeCarta(Jogam.getMao());
		cartaJogador4 = new ExibeCarta(Jogam.getMao());
		cartaJogador5 = new ExibeCarta(Jogam.getMao());
		cartaJogador6 = new ExibeCarta(Jogam.getMao());
	}
	public void actionPerformed(ActionEvent e){
		switch (c.getName()){
		case "Jogador 1":
			//System.out.println("PRIMEIRO JOGADOR" + c.getName());
			cartaJogador1.setVisibilidade();
			break;
		case "Jogador 2":
			cartaJogador2.setVisibilidade();
			break;
		case "Jogador 3":
			cartaJogador3.setVisibilidade();
			break;
		case "Jogador 4":
			cartaJogador4.setVisibilidade();
			break;
		case "Jogador 5":
			cartaJogador5.setVisibilidade();
			break;
		case "Jogador 6":
			cartaJogador6.setVisibilidade();
			break;
			
		}
	}
}
