package com.senac.jogos.labirinto;

abstract public class Item {
	private String descricao;
	
	protected Item(String descricao)
	{
		this.descricao = descricao;
	}
	
	public String getDescricao()
	{
		return this.descricao;
	}
	
	public String toString()
	{
		return descricao;
	}
	
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		
		String item = null;
		if (o instanceof Item)
			item = ((Item)o).getDescricao();
		else if (o instanceof String)
			item = (String)(o);
		else
			return false;
		
		return this.descricao.equalsIgnoreCase(item);
	}
}
