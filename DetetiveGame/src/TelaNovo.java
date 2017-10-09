import javax.swing.*;

import jogoInterface.TelaTabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;

public class TelaNovo implements ActionListener{
	JButton botao;
	private JFrame frame = new JFrame("Seleciona Jogadores");
	//private BufferedImage image;
	//JCheckBox cb1;
	//JCheckBox cb2;
	//JCheckBox cb3;
	TelaTabuleiro inicio;
	public TelaNovo()
	{
		
		botao = new JButton("Novo");
		botao.addActionListener(this);
	}
	public void setFrame()
	{	
		TelaJogadores Jogadores = new TelaJogadores();
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		setFrame();
	
	}
}
