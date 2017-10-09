package jogoInterface;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;

import ControleDeJogo.ControleDeJogo;

public class TelaPalpite extends JFrame {
	private JCheckBox s1, s2, s3, s4, s5, s6, arma_no_comodo, /*a1, a2, a3, a4, a5, a6,*/ c1, c2, c3, c4, c5, c6, c7, c8, c9;
	private Container container;
	private JButton Confirma;
	public String[] retornando;
	private boolean flag2;
	public TelaPalpite(ControleDeJogo controlaJogadores) {
		
		retornando = new String[3];
		Confirma = new JButton("Confirmar Palpite");
		Confirma.setVisible(true);
		s1 = new JCheckBox("Srta. Scarlet");
		s2 = new JCheckBox("Coronel Mustard");
		s3 = new JCheckBox("Sra. White");
		s4 = new JCheckBox("Rev. Green");
		s5 = new JCheckBox("Sra. Peacock");
		s6 = new JCheckBox("Professor Plum");

		s1.setBounds(50, 30, 130, 30);
		s2.setBounds(50, 60, 130, 30);
		s3.setBounds(50, 90, 130, 30);
		s4.setBounds(50, 120, 130, 30);
		s5.setBounds(50, 150, 130, 30);
		s6.setBounds(50, 180, 130, 30);
		
		int index_jogadores = controlaJogadores.index_player;
		int index_comodo = controlaJogadores.comodo_porta(index_jogadores);
		//System.out.printf("index_jogador_paltite: %d e index_comodo_palpite %d/n", index_jogadores, index_comodo);
		System.out.println(controlaJogadores.nome_da_arma_pelo_comodo(index_comodo));
		arma_no_comodo = new JCheckBox(controlaJogadores.nome_da_arma_pelo_comodo(index_comodo));
		arma_no_comodo.setBounds(200, 30, 160, 30);
		
		/*
		a1 = new JCheckBox("Cano");
		a2 = new JCheckBox("Castical");
		a3 = new JCheckBox("Chave Inglesa");
		a4 = new JCheckBox("Corda");
		a5 = new JCheckBox("Faca");
		a6 = new JCheckBox("Revolver");

		a1.setBounds(200, 30, 160, 30);
		a2.setBounds(200, 60, 160, 30);
		a3.setBounds(200, 90, 160, 30);
		a4.setBounds(200, 120, 160, 30);
		a5.setBounds(200, 150, 160, 30);
		a6.setBounds(200, 180, 160, 30);
		*/

		c1 = new JCheckBox("Biblioteca");
		c2 = new JCheckBox("Cozinha");
		c3 = new JCheckBox("Entrada");
		c4 = new JCheckBox("Escritorio");
		c5 = new JCheckBox("Jardim de Inverno");
		c6 = new JCheckBox("Sala de Estar");
		c7 = new JCheckBox("Sala de Jantar");
		c8 = new JCheckBox("Sala de Musica");
		c9 = new JCheckBox("Sala de Jogos");

		c1.setBounds(380, 30, 170, 30);
		c2.setBounds(380, 60, 170, 30);
		c3.setBounds(380, 90, 170, 30);
		c4.setBounds(380, 120, 170, 30);
		c5.setBounds(380, 150, 170, 30);
		c6.setBounds(380, 180, 170, 30);
		c7.setBounds(380, 210, 170, 30);
		c8.setBounds(380, 240, 170, 30);
		c9.setBounds(380, 270, 170, 30);

		ButtonGroup Suspeitos = new ButtonGroup();
		ButtonGroup Armas = new ButtonGroup();
		ButtonGroup Comodos = new ButtonGroup();

		s1.addActionListener(new TratadorPalpite(s1, Confirma, controlaJogadores, this));
		s2.addActionListener(new TratadorPalpite(s2, Confirma, controlaJogadores, this));
		s3.addActionListener(new TratadorPalpite(s3, Confirma, controlaJogadores, this));
		s4.addActionListener(new TratadorPalpite(s4, Confirma, controlaJogadores, this));
		s5.addActionListener(new TratadorPalpite(s5, Confirma, controlaJogadores, this));
		s6.addActionListener(new TratadorPalpite(s6, Confirma, controlaJogadores, this));

		arma_no_comodo.addActionListener(new TratadorPalpite(arma_no_comodo, Confirma, controlaJogadores, this));
		/*
		a1.addActionListener(new TratadorPalpite(a1, Confirma, controlaJogadores, this));
		a2.addActionListener(new TratadorPalpite(a2, Confirma, controlaJogadores, this));
		a3.addActionListener(new TratadorPalpite(a3, Confirma, controlaJogadores, this));
		a4.addActionListener(new TratadorPalpite(a4, Confirma, controlaJogadores, this));
		a5.addActionListener(new TratadorPalpite(a5, Confirma, controlaJogadores, this));
		a6.addActionListener(new TratadorPalpite(a6, Confirma, controlaJogadores, this));
		*/
		
		c1.addActionListener(new TratadorPalpite(c1, Confirma, controlaJogadores, this));
		c2.addActionListener(new TratadorPalpite(c2, Confirma, controlaJogadores, this));
		c3.addActionListener(new TratadorPalpite(c3, Confirma, controlaJogadores, this));
		c4.addActionListener(new TratadorPalpite(c4, Confirma, controlaJogadores, this));
		c5.addActionListener(new TratadorPalpite(c5, Confirma, controlaJogadores, this));
		c6.addActionListener(new TratadorPalpite(c6, Confirma, controlaJogadores, this));
		c7.addActionListener(new TratadorPalpite(c7, Confirma, controlaJogadores, this));
		c8.addActionListener(new TratadorPalpite(c8, Confirma, controlaJogadores, this));
		c9.addActionListener(new TratadorPalpite(c9, Confirma, controlaJogadores, this));
		Confirma.addActionListener(new TratadorPalpite(c1, Confirma, controlaJogadores, this));

		Suspeitos.add(s1);
		Suspeitos.add(s2);
		Suspeitos.add(s3);
		Suspeitos.add(s4);
		Suspeitos.add(s5);
		Suspeitos.add(s6);
		
		Armas.add(arma_no_comodo);
		/*
		Armas.add(a1);
		Armas.add(a2);
		Armas.add(a3);
		Armas.add(a4);
		Armas.add(a5);
		Armas.add(a6);*/

		Comodos.add(c1);
		Comodos.add(c2);
		Comodos.add(c3);
		Comodos.add(c4);
		Comodos.add(c5);
		Comodos.add(c6);
		Comodos.add(c7);
		Comodos.add(c8);
		Comodos.add(c9);

		container = getContentPane();
		container.add(s1);
		container.add(s2);
		container.add(s3);
		container.add(s4);
		container.add(s5);
		container.add(s6);

		container.add(arma_no_comodo);
		/*
		container.add(a1);
		container.add(a2);
		container.add(a3);
		container.add(a4);
		container.add(a5);
		container.add(a6);
		*/
		container.add(c1);
		container.add(c2);
		container.add(c3);
		container.add(c4);
		container.add(c5);
		container.add(c6);
		container.add(c7);
		container.add(c8);
		container.add(c9);

		container.add(Confirma);

		Confirma.setBounds(400, 350, 150, 80);
		Confirma.setEnabled(false);
		setLayout(null);
		setBounds(550, 0, 600, 500);
		setVisible(true);
		repaint();
	
	
	}

	public String[] getresp() {
		return retornando;
	}


	
}

class TratadorPalpite implements ActionListener {
	private JButton Confirma;
	private JCheckBox Checkbox;
	private static int Contador = 0;
	static private ArrayList<String> selecionados;
	private String[] reajuste;
	private Palpitando Palpite;
	private ControleDeJogo controll;
	private JFrame tela_palpite;
	public TratadorPalpite(JCheckBox c, JButton botao, ControleDeJogo controlaJogadores, JFrame telaPalpite) {
		tela_palpite = telaPalpite;
		reajuste = new String[3];
		Confirma = botao;
		Checkbox = c;
		selecionados = new ArrayList<String>();
		Palpite = new Palpitando();
		controll = controlaJogadores;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) {
			System.out.println("reajuste: "+reajuste + reajuste[0]);
			
			
			reajuste = Palpite.get(selecionados, reajuste, controll);
			//reajuste = te.get();
			for(int i = 0; i <reajuste.length; i++){
				System.out.println("Tentativa "+i +": "  +reajuste[i]);
			}
			controll.retorno_confirmar_palpite();
			tela_palpite.setVisible(false);
			//this.setVisible(false);
			// System.out.println(reajuste);
			// System.out.println("entrei hehe");
			// System.out.println(reajuste);
		} else {
			
			int j = 0;
			int tamanho_lista = selecionados.size();
			boolean confirma_presenca_na_lista= false;
			while(tamanho_lista > 0)
			{
				if(selecionados.get(j).equals(Checkbox.getText()))
				{
					//confirma_presenca_na_lista = true;
					selecionados.remove(j);
					j--;
					ContMenos();
				}
				//System.out.println("\t" + selecionados.get(j) + " " + confirma_presenca_na_lista);
				tamanho_lista--;
				j++;
			}
			if ((Checkbox.isSelected() == true) & (confirma_presenca_na_lista == false) & (selecionados.size() < 3)) {
				
				ContMais(); // contador marcando que mais um checkbox foi
							// marcado
				selecionados.add(Checkbox.getText());
				//System.out.println(selecionados.get(selecionados.size()-1));
			}
			System.out.println("tamanho:" + selecionados.size());
			for(int k = 0; k < selecionados.size(); k++)
				System.out.println("\t" + selecionados.get(k) + " " + confirma_presenca_na_lista +" " + k);
			/*
			 * else { ContMenos(); // contador marcando que um checkbox foi
			 * DESmarcado selecionados.remove(Checkbox.getText());
			 * System.out.println("?"); }
			 */

			if (getCont() >= 3) {
				Confirma.setEnabled(true); // acima de tres marca��es ele
											// permite o bot�o
			} else {
				Confirma.setEnabled(false); // menos de tr�s ele desmarca o
											// bot�o
			}
		}
	}

	static void ContMais() {
		Contador++;
	}

	static void ContMenos() {
		if (Contador > 0) {
			Contador--;
		}

	}

	static int getCont() {
		return (Contador);
	}

}

class Palpitando {
	private int i;
	private String a[];

	Palpitando() {
		
	}
	
	String[] get(ArrayList<String> c, String[] w,ControleDeJogo controlaJogadores) {
		
		i = c.size();
		a = new String[i];
		a=w;
		
		for (int j = 0; j < i; j++) {
			a[j] = c.get(j);
			System.out.println("Sysout:"+a[j]);
		}
		controlaJogadores.insere_palpite(a);
		return a;

	}

}
