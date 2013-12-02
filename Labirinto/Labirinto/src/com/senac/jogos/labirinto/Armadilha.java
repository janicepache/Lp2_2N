package com.senac.jogos.labirinto;

public class Armadilha extends Inimigo {
	public Armadilha() {
		super("Armadilha",1000,0,1);
	}
	
	@Override
	public void setDano(int dano)
	{
		if (Range.getPercentual() > 20)
			this.vida = 0;
	}
}
