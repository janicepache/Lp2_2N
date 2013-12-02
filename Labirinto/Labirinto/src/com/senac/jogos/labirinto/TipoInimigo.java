package com.senac.jogos.labirinto;

public enum TipoInimigo {
	GOBLIN("Goblin", new Range(1,3), new Range(0,1), new Range(2,4)),
	ORC("Orc", new Range(2,4), new Range(1,2), new Range(3,6)),
	TROLL("Troll", new Range(3,6), new Range(2,4), new Range(4,10));
	
	private Range vida;
	private Range ataque;
	private Range resistencia;
	private String tipo;
	
	private TipoInimigo(String tipo, Range ataque, Range resistencia, Range vida)
	{
		this.ataque = ataque;
		this.resistencia = resistencia;
		this.vida = vida;
		this.tipo = tipo;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public int getVida()
	{
		return vida.getRandom();
	}
	
	public int getAtaque()
	{
		return ataque.getRandom();
	}
	
	public int getResistencia()
	{
		return resistencia.getRandom();
	}
}
