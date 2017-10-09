 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*;

import javax.swing.*;

import jogoInterface.TelaTabuleiro;

public class TelaJogadores  extends JFrame{
	   
	    public JButton iniciar;
	    private ArrayList<String> JogadoresAtivos;
	    
	    public TelaJogadores(){
	    	//TelaTabuleiro iniciar = new TelaTabuleiro();
	    	JogadoresAtivos = new ArrayList<String>();
	    	iniciar = new JButton("Inciar");
	    	JCheckBox b1 = new JCheckBox("Srta. Scarlet (Vermelho)",false);
	        JCheckBox b2 = new JCheckBox("Coronel Mustard (Amarelo)", false);
	        JCheckBox b3 = new JCheckBox("Sra. White (Branco)",false);
	        JCheckBox b4 = new JCheckBox("Rev. Green (Verde)", false);
	        JCheckBox b5 = new JCheckBox("Sra. Peacock (Azul)",false);
	        JCheckBox b6 = new JCheckBox("Professor Plum (Roxo)", false);
	        
	        b1.setName("Srta. Scarlet");
	        b2.setName("Coronel Mustard");
	        b3.setName("Sra. White");
	        b4.setName("Rev. Green");
	        b5.setName("Sra. Peacock");
	        b6.setName("Professor Plum");
	        
	        b1.setBounds(50,30,200,30);
	        b2.setBounds(50,60,200,30);
	        b3.setBounds(50,90,200,30);
	        b4.setBounds(50,120,200,30);
	        b5.setBounds(50,150,200,30);
	        b6.setBounds(50,180,200,30);
	        
	        Container c= getContentPane();
	        
	        b1.addActionListener(new TratadorSelec(b1,iniciar,JogadoresAtivos));
	        b2.addActionListener(new TratadorSelec(b2,iniciar,JogadoresAtivos));
	        b3.addActionListener(new TratadorSelec(b3,iniciar,JogadoresAtivos));
	        b4.addActionListener(new TratadorSelec(b4,iniciar,JogadoresAtivos));
	        b5.addActionListener(new TratadorSelec(b5,iniciar,JogadoresAtivos));
	        b6.addActionListener(new TratadorSelec(b6,iniciar,JogadoresAtivos));
	        iniciar.addActionListener(new TratadorSelec(b6,iniciar,JogadoresAtivos));
	        
	        iniciar.setBounds(300, 300, 100, 50);
	        JPanel p = new JPanel();
	        p.setLayout(null);
	        
	        c.add(p);
	        p.add(b1);
	        p.add(b2);
	        p.add(b3);
	        p.add(b4);
	        p.add(b5);
	        p.add(b6);
	        
	        iniciar.setEnabled(false);
	        iniciar.setToolTipText("Selecione pelo menos 3 para ativar.");
	        p.add(iniciar);


	        setSize(450,420);
	        setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	} // fim classe TelaJogadores

		//inicio do tratador de bot�es
	class TratadorSelec implements ActionListener{
	    private JCheckBox x;
	    private JButton ki;
	    private static int Contador=0;
	    private ArrayList<String> listajogadores;
	    
	    public TratadorSelec(JCheckBox c, JButton zi, ArrayList<String> nova){
	        x=c;
	        ki=zi;
	        listajogadores = nova;
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // TODO Auto-generated method stub\\
	    	if(e.getSource() instanceof JButton)
	    	{
    			TelaTabuleiro gameplay = new TelaTabuleiro(listajogadores);
    			gameplay.setFrame();
    			gameplay.setVisible(true);
    		
	    	}
	        int i;
	        if (x.isSelected())
	        {
	            ContMais(); //contador marcando que mais um checkbox foi marcado
	            listajogadores.add(x.getName());
	        }
	        else {
	            ContMenos(); // contador marcando que um checkbox foi DESmarcado
	            listajogadores.remove(x.getName());
	        }
	        i = getCont();
	        if (i>=3){
	            ki.setEnabled(true); // acima de tres marca��es ele permite o bot�o
	        }
	        else{
	            ki.setEnabled(false); // menos de tr�s ele desmarca o bot�o
	        }
	            
	    }
	    
	    static void ContMais(){
	        Contador++;
	    }
	    static void ContMenos(){
	        if (Contador>0){
	            Contador--;
	        }
	        
	    }
	    static int getCont(){
	        return (Contador);
	    }

	}
//fim tratador de bot�es
