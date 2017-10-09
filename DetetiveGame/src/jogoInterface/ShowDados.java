package jogoInterface;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShowDados extends JFrame implements Observer{
	private int dado1, dado2;
	JPanel imagemDados;
	public JLabel JL1, JL2;
	public ShowDados(){
		
		imagemDados = new JPanel();
		setLayout(null);
		setBounds(800, 0, 250, 150);
		//setOpaque(false);
		setVisible(true);
	}
	public void Exibe(int d1, int d2){
		JL1= new DadoOverlay(d1).getlabel();
		JL2= new DadoOverlay(d2).getlabel();
		JL1.setBounds(0, 0, 110, 110);
		JL2.setBounds(110,0,110,110);
		JL1.setVisible(true);
		JL2.setVisible(true);
		imagemDados.setBounds(0, 0, 250, 150);
		imagemDados.add(JL1);
		imagemDados.add(JL2);
		//imagemDados.setOpaque(false);
		imagemDados.setVisible(true);
		//imagemDados.repaint();
		add(imagemDados);
		
	}
	public void deixaDadoInvisivel()
	{
		JL1.setVisible(false);
		JL2.setVisible(false);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();		
	}
}
