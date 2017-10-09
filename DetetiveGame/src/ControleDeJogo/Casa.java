package ControleDeJogo;

public class Casa {
	public char simbolo;
	boolean ativada;
	boolean bloqueio;
	
	Casa()
	{
		simbolo = 'X';
		ativada = false;
		bloqueio = false;
	}
	Casa(char c)
	{
		if(c == 'B')
		{
			simbolo = 'B';
			ativada = false;
			bloqueio = true;
		}
		else
		{
			simbolo = c;
			ativada = false;
			bloqueio = false;
		}
	}
	public void set_simbolo(char c)
	{
		simbolo = c;
	}
	public void set_bloqueio()
	{
		bloqueio = true;
	}
}
