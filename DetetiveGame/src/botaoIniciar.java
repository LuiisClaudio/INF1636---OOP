//import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.lang.*;

public class botaoIniciar implements ActionListener{
	private JButton botao;
	botaoIniciar()
	{
		botao = new JButton("Iniciar");
		botao.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		//BufferedImage image;
		//BufferedImage myPicture = ImageIO.read(new File("C:/Users/Luis/Documents/POO/Tra1/Tabuleiros/Tabuleiro-Clue-A.jpg"));
		//JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		//add(picLabel);
	}
}
