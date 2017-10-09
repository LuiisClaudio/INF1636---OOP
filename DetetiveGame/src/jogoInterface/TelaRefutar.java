package jogoInterface;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaRefutar extends JFrame {

	private ArrayList<String> cartasRefutar;
	private ArrayList<JCheckBox> Escolher;
	private JCheckBox check;
	private Container container;
 	private int num;
 	private ButtonGroup c;
 	private int h;
 	private JButton confirma;
	public TelaRefutar (ArrayList<String> cartas){
		this.setLayout(null);
		this.setVisible(true);
		Escolher = new ArrayList<JCheckBox>();
		cartasRefutar = new ArrayList<String>();
		c=new ButtonGroup();
		confirma = new JButton("Confirmar");

		cartasRefutar = cartas;
		num = cartas.size();
		for (int i =0; i<num; i++){
			//system.out.println("to adicionando na lista de checkbox");
			Escolher.add(new JCheckBox(cartasRefutar.get(i),false));
		}
		container = this.getContentPane();
		for (h=0;h<Escolher.size();h++){
			//system.out.println("to adicionando os botao no panel");
			c.add(Escolher.get(h));
			container.add(Escolher.get(h));
			Escolher.get(h).setBounds(50,30+(70*h),150,80);
			Escolher.get(h).addActionListener( new TratadorRefutar(Escolher.get(h),confirma, this));
		}
		container.add(confirma);
		confirma.addActionListener(new TratadorRefutar(null, confirma, this));
		confirma.setVisible(true);
		confirma.setBounds(150, 50+(70*h),100,80);
		this.setBounds(650,0,320,200+(70*h));
		this.setVisible(true);
		this.setTitle("Selecione a carta que deseja revelar:");
	}
	
	
}


class TratadorRefutar implements ActionListener{
		private JCheckBox component;
		private static String nomecarta;
		private JButton k;
		JFrame tela_refutar;
	public TratadorRefutar(JCheckBox c,JButton confirmando, JFrame telaRefutar){
		component = c;
		k = confirmando; 
		tela_refutar = telaRefutar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton){
			//system.out.println("era pra ta funcionando");
			tela_refutar.setVisible(false);
			new ExibeCartaString(nomecarta);
		}
		else{
			if(component.isSelected()){
				//system.out.println("to vendo se foi selecionado e botando nome");
				nomecarta = component.getText();
				//system.out.println("nome do slecionado"+"'"+nomecarta+"'");
				k.setEnabled(true);
			}
		}
		
	}
	
	
}