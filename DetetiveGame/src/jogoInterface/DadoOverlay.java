package jogoInterface;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*Unica classe que importa desse projeto/package � essa. 
 * Controla a imagem dos dados.
 * Chamada do new Overlay(INT numero gerado pelo dado).
 * 
 * A imagem vai estar em JLabel e vai ser retornada quando usado o m�todo getlabel()
 * 
 * 
 * 
 * */
public class DadoOverlay {

	private BufferedImage pictures;
	private JLabel ibagens;

	public DadoOverlay(int a) {

		BufferedImage pictures = null;
		//System.out.println("Entrei pra pesquisa a imagem do dado");
		if (a == 1) {
			try {
				pictures = ImageIO.read(new File("Imagens/dado1.jpg"));
			} catch (IOException ex) {
				System.out.println("Erro na imagem");
			}
		} else if (a == 2) {
			try {
				pictures = ImageIO.read(new File("Imagens/dado2.jpg"));
			} catch (IOException ex) {
				System.out.println("Erro na imagem");
			}
		} else if (a == 3) {
			try {
				pictures = ImageIO.read(new File("Imagens/dado3.jpg"));
			} catch (IOException ex) {
				System.out.println("Erro na imagem");
			}
		} else if (a == 4) {

			try {
				pictures = ImageIO.read(new File("Imagens/dado4.jpg"));
			} catch (IOException ex) {
				System.out.println("Erro na imagem");
			}

		} else if (a == 5) {
			try {
				pictures = ImageIO.read(new File("Imagens/dado5.jpg"));
			} catch (IOException ex) {
				System.out.println("Erro na imagem");
			}
		} else if (a == 6) {
			try {
				pictures = ImageIO.read(new File("Imagens/dado6.jpg"));
			} catch (IOException ex) {
				System.out.println("Erro na imagem");
			}
		}
		
		ibagens = new JLabel(new ImageIcon(pictures));
		System.out.println(a);

			
	}
	public JLabel getlabel(){
		return this.ibagens;
	}

}
