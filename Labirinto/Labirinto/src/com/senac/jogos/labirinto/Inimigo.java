package com.senac.jogos.labirinto;

public class Inimigo extends Personagem {

	String tipo;
	
	protected Inimigo(TipoInimigo tipo)
	{
		super(tipo.getAtaque(), tipo.getResistencia(), tipo.getVida());
		this.tipo = tipo.getTipo();
	}
	
	protected Inimigo(String tipo, int ataque, int resistencia, int vida)
	{
		super(ataque, resistencia, vida);
		this.tipo = tipo;
	}

	public String toString()
	{
		return tipo;
	}
}
