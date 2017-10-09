//import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import ControleDeJogo.*;
import jogoInterface.*;

public class principal {
	public static void main(String[] args) {
		
		TelaInicial t = new TelaInicial("Detetive");
		t.setTitle("Detetive");
		t.setVisible(true);
		
		/*JButton teste = new JButton("Teste");
		JCheckBox check = new JCheckBox("Check");
		teste.setBounds(50,30,120,30);
        check.setBounds(50,60,120,30);
        check.addActionListener(new TratadorSelec(check, teste));*/
		//Class c = teste.getClass();
		//System.out.println(c.getName());
		
		
		//JFrame f = new JFrame("Teste de imagemJogadores");
		//imagemJogadores jog = new imagemJogadores();
		//f.setSize(500, 500);
		//f.add(jog);
		//f.setVisible(true);
		//JPanel p = new JPanel();
		/*
		Scanner scanner = new Scanner(System.in);
		imagemJogadores Jog = new imagemJogadores();
		p.setLayout(null);
		p.add(Jog.jogadores[0]);
		p.add(Jog.jogadores[1]);
		f.setBounds(0, 0, 500, 500);
		//f.setBackground(Color.BLACK);
		//f.add(Jog.jogadores[0]);
		//f.add(Jog.jogadores[1]);
		f.add(p);
		f.setVisible(true);
		char c;
		System.out.println("Diga seu movimento");
		c = scanner.next().charAt(0);
		while(c != 'p')
		{
			System.out.println("Diga seu movimento");
			c = scanner.next().charAt(0);
			Jog.andaTabuleiro(0, c);
			p.repaint();
		}
		Jog.estadoJogador(1, false);
		*/
		
		//Tabuleiro tab = new Tabuleiro();
		//tab.desenhaTabuleiro();
		//tab.jogar("Luis");
		//ControleDeJogo control = new ControleDeJogo();
		//control.inicia_jogo();
	}
}


