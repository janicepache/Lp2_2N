
public enum Cor {
	AMARELO ("amarelo"),
	AZUL ("azul"),
	VERDE ("verde"),
	VERMELHO ("vermelho"),
	MARROM ("");
	
	
	private Cor(String d){
		descricao = d;
	}
	
	private String descricao;
		
		
	public String toString(){
		return descricao;
		
	}

}
