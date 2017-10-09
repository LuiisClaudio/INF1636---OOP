package jogoInterface;


import java.awt.Container;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaVencedor extends JFrame {
	JLabel vencedor;
	JLabel mensagem1;
	JLabel mensagem2;
	Container c;
	public TelaVencedor(int nome){
		vencedor = new JLabel(Integer.toString(nome));
		mensagem1 = new JLabel("O Jogador:");
		mensagem2 = new JLabel("Venceu a partida!");
		vencedor.setHorizontalAlignment(JLabel.CENTER);
		mensagem1.setBounds(50, 10, 100, 80);
		vencedor.setBounds(160, 90, 100, 80);
		mensagem2.setBounds(270, 370 , 100, 80);
		c=this.getContentPane();
		c.add(vencedor);
		c.add(mensagem1);
		c.add(mensagem2);
		this.setVisible(true);
		this.setBounds(600, 400, 400, 400);
		
		this.setVisible(true);
	}
}
