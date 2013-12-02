package com.senac.jogos.labirinto;

public enum Direcao {
	NORTE("North", 0),
	SUL("South", 1),
	LESTE("East", 2),
	OESTE("West", 3),
	ACIMA("Up", 4),
	ABAIXO("Down", 5);
	
	private String name;
	private int index;
	
	public static Direcao converte(String name)
		throws Exception
	{
		if (NORTE.name.equalsIgnoreCase(name))
		return NORTE;
		if (SUL.name.equalsIgnoreCase(name))
			return SUL;
		if (LESTE.name.equalsIgnoreCase(name))
			return LESTE;
		if (OESTE.name.equalsIgnoreCase(name))
			return OESTE;
		if (ACIMA.name.equalsIgnoreCase(name))
			return ACIMA;
		if (ABAIXO.name.equalsIgnoreCase(name))
			return ABAIXO;
		throw new Exception("Direcao invalida.");
	}
	
	private Direcao(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
	
	public int getIndex()
	{
		return this.index;
	}
	
	public String toString()
	{
		return name;
	}

	public static Direcao converte(int dir) throws Exception {
		switch (dir) {
		case 0: return NORTE; 
		case 1: return SUL; 
		case 2: return LESTE; 
		case 3: return OESTE; 
		case 4: return ACIMA; 
		case 5: return ABAIXO; 
		}
		throw new Exception("Direcao invalida.");
	}


}
