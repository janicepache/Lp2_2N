package com.senac.jogos.labirinto;


public class Arma extends Item {

	private static int dano;
	private String tipo;
	
	public Arma(String tipo, int dano)
	{
		super(tipo);
		if (dano > 0 )
			this.dano = dano;
		else
			this.dano = 1;
	}	
	 
	public Arma(String tipo)
	{
		super(tipo);
		this.tipo = tipo;
        
        if(tipo.equals("adaga")){
            this.dano = 1;
        }else{
            if(tipo.equals("faca")){
                this.dano = 2;
            }
            else{
                if(tipo.equals("espada")){
                    this.dano = 4;
                }
            }
        } 
	}
	public static Arma Arma(){
	       int numero = (int) (Math.random()*3);
	       String n = "";
	       switch (numero) {
	           case 0:
	               n = "adaga";
	               break;
	           case 1:
	               n = "faca";
	               break;
	           case 2:
	               n = "espada";
	               break;
	       }
	       return new Arma(n, dano);
	   }
	   
	   public int getDano(){
	       return dano;
	   }
	   /**
	* retorna o nome da arma. O nome funciona como tipo da arma.
	* @return valor do nome
	*/
	   public String getNome(){
	       return tipo;
	   }
}
