package com.senac.jogos.labirinto;

public class Sala {
	
	private int numSala;
	public static int EXIT = 0;
	
	Conexao[] conexoes = new Conexao[6];
	
	public Sala (int numSala){
		this.numSala = numSala;
		
	}
	public Sala (){
		
		
	}
	public int getConexao(String direcao) throws Exception
	{
		Direcao dir = Direcao.converte(direcao);
		return dir.getIndex();
	}
	private static int getDirecaoIndex(String direcao) throws Exception
	{
		Direcao dir = Direcao.converte(direcao);
		return dir.getIndex();
	}
	
	public void setArmadilha(String direcao) throws Exception
	{
		conexoes[getDirecaoIndex(direcao)].setArmadilha();
	}

	public void addConexao(String direcao, int sala) throws Exception
	{
		int ndx = getDirecaoIndex(direcao);
		if (conexoes[ndx] != null)
			throw new Exception("Conexao j‡ existente.");
		
		conexoes[ndx] = new Conexao(sala);
	}
	
	public String toString()
	{	
		try {
			String res =  "A sala tem saida nas direcoes:\n";
			for (int i = 0; i < 6; i++)
				if (conexoes[i] != null)
					res += "\t" + Direcao.converte(i) + " " + conexoes[i] + "\n";
			return res;
		} catch (Exception e) {
			return "SALA COM ESTADO INVALIDO!";
		}
		
	}
	public int getSaida(String direcao) throws Exception{
		
		Conexao conexao = conexoes[getConexao(direcao)];
		return conexao.getSala();
	}
	
}
