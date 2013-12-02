package com.senac.jogos.labirinto;

public class Armadura extends Item {
	private int resistencia;
	
	public Armadura(String tipo, int resistencia)
	{
		super(tipo);
		if (resistencia > 0 )
			this.resistencia = resistencia;
		else
			this.resistencia = 0;
	}
	
	public int getResistencia()
	{
		return resistencia;
	}
}
