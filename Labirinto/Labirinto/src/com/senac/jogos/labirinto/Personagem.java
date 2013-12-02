package com.senac.jogos.labirinto;

abstract public class Personagem {
	protected int ataque;
	protected int resistencia;
	protected int vida;
	
	private int ensureValidValue(int value, int min)
	{
		if (value >= min)
			return value;
		return min;
	}
	
	protected Personagem(int ataque, int resistencia, int vida)
	{
		this.ataque      = ensureValidValue(ataque, 1);
		this.resistencia = ensureValidValue(resistencia, 0);
		this.vida        = ensureValidValue(vida, 1);
	}
	
	public boolean isAlive()
	{
		return vida > 0;
	}
	
	public void setDano(int value)
	{
		int total = value - resistencia;
		if (total > 0)
			vida -= total;
	}
	
	public int getAtaque()
	{
		return ataque;
	}
}
