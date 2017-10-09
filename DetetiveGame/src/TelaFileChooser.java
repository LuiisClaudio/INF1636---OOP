
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;


public class TelaFileChooser{
	
	public JButton botao;
	
	//BUTTONFRAME ADICIONA JBUTTONS AO JFRAME
	public TelaFileChooser()
	{
	
		botao = new JButton("Continuar");
		ButtonHandler handler = new ButtonHandler();
		botao.addActionListener(handler);
	}
	
	//CLASSE INTERNA PARA TRATAMENTO DO BOT�O
	public class ButtonHandler implements ActionListener
	{
		//TRATA EVENTO DO BOT�O
		public void actionPerformed(ActionEvent event)
		{
			
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
			}
		}
	}
}