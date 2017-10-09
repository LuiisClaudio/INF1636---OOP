package jogoInterface;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaTabuleiro extends JFrame{
	public BufferedImage myPicture;
	public JLabel picLabel;
	public JPanel painelTabuleiro;
	public imagemJogadores testeJogadores;
	public TelaTabuleiro(ArrayList<String> Jogando)
	{
		BufferedImage myPicture = null;
		testeJogadores = new imagemJogadores(Jogando);
		painelTabuleiro = new JPanel();
		try {
			myPicture = ImageIO.read(new File("Imagens/Tabuleiro-Clue-A.jpg"));
    	} 
		catch (IOException ex) {
         	System.out.println("Erro na imagem");
    	}
		picLabel = new JLabel(new ImageIcon(myPicture));
	}
	public void setFrame()
	{
		setLayout(null);
		setContentPane(picLabel);
		painelTabuleiro.setLayout(null);
		painelTabuleiro.setBounds(0, 0, 500, 500);
		painelTabuleiro.setOpaque(false);
		painelTabuleiro.add(testeJogadores);
		setBounds(0, 0, 730, 760);
		//setBounds(0, 0, 900, 760);
		picLabel.setBounds(0,0,1000,1000);
		//add(picLabel);
		getContentPane().add(testeJogadores);
		add(painelTabuleiro);
		//add(painelTabuleiro);
		//pack();
		setVisible(true);
		//painelTabuleiro.setLayout(null);
		//painelTabuleiro.add(testeJogadores.jogadores[0]);
		//painelTabuleiro.add(testeJogadores.jogadores[1]);
		//painelTabuleiro.setBackground(Color.BLACK);
		//frame.add(testeJogadores.jogadores[0]);
	} 
}
