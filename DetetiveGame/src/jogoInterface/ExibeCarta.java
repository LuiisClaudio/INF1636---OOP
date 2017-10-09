package jogoInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import ControleDeJogo.Carta;

public class ExibeCarta extends JFrame {
	private BufferedImage pictures;
	//private boolean isused[];
	private List<JLabel> imagensusa;
	private int x=300;
	private int L=0;
	int k;
	JLabel ibagens1,ibagens2,ibagens3,ibagens4,ibagens5,ibagens6,ibagens7,
			ibagens8,ibagens9,ibagens10,ibagens11,ibagens12,ibagens13,ibagens14,
			ibagens15,ibagens16,ibagens17,ibagens18,ibagens19,ibagens20,ibagens21;
	
	String nome_carta;
	boolean visibilidade = false;
	JTextArea textArea;

	public ExibeCarta(List<Carta> mao) {
		setLayout(null);
		textArea = new JTextArea("Minhas anotacoes:");
		imagensusa = new ArrayList<JLabel>();
		/*isused = new boolean[21];
		for (int i=0;i<21;i++){
			isused[i]= false;
		}*/
		//System.out.println(this);
		for (Carta a : mao) {
			
			nome_carta = a.getnome();
			switch (nome_carta) {
			case "Srta. Scarlet":
				try {
					pictures = ImageIO.read(new File("Imagens/Scarlet.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens1 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens1);
				//isused[0]=true;
				break;
			case "Coronel Mustard":
				try {
					pictures = ImageIO.read(new File("Imagens/Mustard.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens2 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens2);
				//isused[1]=true;
				break;
			case "Sra. White":
				try {
					pictures = ImageIO.read(new File("Imagens/White.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens3 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens3);
				//isused[2]=true;
				break;
			case "Rev. Green":
				try {
					pictures = ImageIO.read(new File("Imagens/Green.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens4 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens4);
				//isused[3]=true;
				break;
			case "Sra. Peacock":
				try {
					pictures = ImageIO.read(new File("Imagens/Peacock.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens5 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens5);
				//isused[4]=true;
				break;
			case "Professor Plum":
				try {
					pictures = ImageIO.read(new File("Imagens/Plum.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens6 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens6);
				//isused[5]=true;
				break;
			case "Cano":
				try {
					pictures = ImageIO.read(new File("Imagens/Cano.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens7 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens7);
				//isused[6]=true;
				break;
			case "castical":
				try {
					pictures = ImageIO.read(new File("Imagens/Castical.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens8 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens8);
				//isused[7]=true;
				break;
			case "Chave Inglesa":
				try {
					pictures = ImageIO.read(new File("Imagens/ChaveInglesa.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens9 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens9);
				//isused[8]=true;
				break;
			case "Corda":
				try {
					pictures = ImageIO.read(new File("Imagens/Corda.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens10 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens10);
				//isused[9]=true;
				break;
			case "Faca":
				try {
					pictures = ImageIO.read(new File("Imagens/Faca.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens11 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens11);
				//isused[10]=true;
				break;
			case "Revolver":
				try {
					pictures = ImageIO.read(new File("Imagens/Revolver.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens12 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens12);
				//isused[11]=true;
				break;
			case "Biblioteca":
				try {
					pictures = ImageIO.read(new File("Imagens/Biblioteca.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens13 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens13);
				//isused[12]=true;
				break;
			case "Cozinha":
				try {
					pictures = ImageIO.read(new File("Imagens/Cozinha.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens14 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens14);
				////isused[13]=true;
				break;
			case "Entrada":
				try {
					pictures = ImageIO.read(new File("Imagens/Entrada.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens15 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens15);
				////isused[14]=true;
				break;
			case "Escritorio":
				try {
					pictures = ImageIO.read(new File("Imagens/Escritorio.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens16 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens16);
				////isused[15]=true;
				break;
			case "Jardim de Inverno":
				try {
					pictures = ImageIO.read(new File("Imagens/JardimInverno.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens17 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens17);
				////isused[16]=true;
				break;
			case "Sala de Estar":
				try {
					pictures = ImageIO.read(new File("Imagens/SalaDeEstar.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens18 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens18);
				////isused[17]=true;
				break;
			case "Sala de Jantar":
				try {
					pictures = ImageIO.read(new File("Imagens/SalaDeJantar.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens19 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens19);
				////isused[18]=true;
				break;
			case "Sala de Musica":
				try {
					pictures = ImageIO.read(new File("Imagens/SalaDeMusica.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens20 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens20);
				//isused[19]=true;
				break;
			case "Salao de Jogos":
				try {
					pictures = ImageIO.read(new File("Imagens/SalaoDeJogos.jpg"));
				} catch (IOException ex) {
					System.out.println("Erro na imagem");
				}
				ibagens21 = new JLabel(new ImageIcon(pictures));
				imagensusa.add(ibagens21);
				//isused[20]=true;
				break;
			}
			textArea.setBounds(0, 500, 700, 300);
			add(textArea);
			//setOpaque(false);
			setVisible(false);
		
		}
		for(k=0; k<imagensusa.size();k++){
			//System.out.println(imagensusa.size());
			imagensusa.get(k).setBounds(0, 0, x, 470);
			this.add(imagensusa.get(k));
			x=x+530;
			
			setSize(x-(700), 500);
		}
		this.setSize((L+(280*k)), 800);
		for (int temp=k;temp>0;temp--){
			imagensusa.remove(temp-1);
		}
		//pack();
	}
	public boolean setVisibilidade()
	{
		if(visibilidade == false)
		{
			visibilidade = true;
			setVisible(visibilidade);
			return true;
		}
		visibilidade = false;
		setVisible(visibilidade);
		return false;
	}
	
}
