package jogoInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ExibeCartaString extends JFrame implements ActionListener {

	private BufferedImage pictures;
	// private boolean isused[];
	private List<JLabel> imagensusa;
	private int x = 300;
	private int L = 0;
	private JButton vista;
	int k;
	JLabel ibagens1, ibagens2, ibagens3, ibagens4, ibagens5, ibagens6, ibagens7, ibagens8, ibagens9, ibagens10,
			ibagens11, ibagens12, ibagens13, ibagens14, ibagens15, ibagens16, ibagens17, ibagens18, ibagens19,
			ibagens20, ibagens21;




	public ExibeCartaString(String nome) {
	
		setLayout(null);
		imagensusa = new ArrayList<JLabel>();
		vista = new JButton("Carta já vista");
		vista.setBounds(10, 500, 200, 50);
		vista.setVisible(true);
		vista.addActionListener(this);
		add(vista);
		//system.out.println("ta no nome '"+nome+"'");
		//system.out.println("Erro foi depois");
		switch (nome) {
		case "Srta. Scarlet":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Scarlet.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens1 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens1);
			//isused[0]=true;
			break;
		case "Coronel Mustard":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Mustard.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens2 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens2);
			//isused[1]=true;
			break;
		case "Sra. White":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/White.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens3 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens3);
			//isused[2]=true;
			break;
		case "Rev. Green":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Green.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens4 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens4);
			//isused[3]=true;
			break;
		case "Sra. Peacock":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Peacock.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens5 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens5);
			//isused[4]=true;
			break;
		case "Professor Plum":
			try {
				pictures = ImageIO.read(new File("Imagens/Plum.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens6 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens6);
			//isused[5]=true;
			break;
		case "Cano":
			try {
				pictures = ImageIO.read(new File("Imagens/Cano.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens7 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens7);
			//isused[6]=true;
			break;
		case "castical":
			try {
				pictures = ImageIO.read(new File("Imagens/Castical.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens8 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens8);
			//isused[7]=true;
			break;
		case "Chave Inglesa":
			try {
				pictures = ImageIO.read(new File("Imagens/ChaveInglesa.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens9 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens9);
			//isused[8]=true;
			break;
		case "Corda":
			try {
				pictures = ImageIO.read(new File("Imagens/Corda.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens10 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens10);
			//isused[9]=true;
			break;
		case "Faca":
			try {
				pictures = ImageIO.read(new File("Imagens/Faca.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens11 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens11);
			//isused[10]=true;
			break;
		case "Revolver":
			try {
				pictures = ImageIO.read(new File("Imagens/Revolver.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens12 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens12);
			//isused[11]=true;
			break;
		case "Biblioteca":
			try {
				pictures = ImageIO.read(new File("Imagens/Biblioteca.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens13 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens13);
			//isused[12]=true;
			break;
		case "Cozinha":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Cozinha.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens14 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens14);
			////isused[13]=true;
			break;
		case "Entrada":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Entrada.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens15 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens15);
			////isused[14]=true;
			break;
		case "Escritorio":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/Escritorio.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens16 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens16);
			////isused[15]=true;
			break;
		case "Jardim de Inverno":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/JardimInverno.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens17 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens17);
			////isused[16]=true;
			break;
		case "Sala de Estar":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/SalaDeEstar.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens18 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens18);
			////isused[17]=true;
			break;
		case "Sala de Jantar":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/SalaDeJantar.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens19 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens19);
			////isused[18]=true;
			break;
		case "Sala de Musica":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/SalaDeMusica.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens20 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens20);
			//isused[19]=true;
			break;
		case "Salao de Jogos":
			try {
				//system.out.println("passou no:" +nome);
				pictures = ImageIO.read(new File("Imagens/SalaoDeJogos.jpg"));
			} catch (IOException ex) {
				//system.out.println("Erro na imagem");
			}
			ibagens21 = new JLabel(nome ,new ImageIcon(pictures), JLabel.CENTER);
			imagensusa.add(ibagens21);
			//isused[20]=true;
			break;
		}
		//system.out.println("IMAGEM VAMO VE SE FOI");
		imagensusa.get(0).setVisible(true);
		imagensusa.get(0).setBounds(0, 0,315, 470);
		imagensusa.get(0).setVerticalTextPosition(JLabel.BOTTOM);		
		imagensusa.get(0).setVerticalAlignment(JLabel.CENTER);
		this.add(imagensusa.get(0));
		this.setSize(400,600);
		this.setVisible(true);
		this.setTitle("Carta Exibida:");
		
	
	}
	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
	}
}
