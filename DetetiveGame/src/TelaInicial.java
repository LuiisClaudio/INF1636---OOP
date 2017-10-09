import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
	public TelaNovo novo;
	public TelaFileChooser continuar;
	
	public TelaInicial(String nome) {
		super(nome);
		setLayout(null);
		Container c=getContentPane();
		TelaNovo novo = new TelaNovo();
		TelaFileChooser continuar = new TelaFileChooser();
		novo.botao.setBounds(50,50,200,30);
		continuar.botao.setBounds(50,110,120,30);
		c.add(novo.botao);
		c.add(continuar.botao);
		setSize(400,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
}
