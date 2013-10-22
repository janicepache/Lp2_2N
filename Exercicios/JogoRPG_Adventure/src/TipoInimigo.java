
public enum TipoInimigo {

	GOBLIN ("Goblin", new Range(1,3), new Range(1,2), new Range (1,3)),
	ORC ("Orc", new Range(2,6), new Range(1,2), new Range (1,3)),
	TROL ("Trol", new Range (4,8), new Range(3,5), new Range (4,8));
	
	private String tipo;
	private Range ataque;
	private Range resistencia;
	private Range vida;

	private TipoInimigo (String tipo, Range ataque, Range resistencia, Range vida){
		this.tipo = tipo;
		this.ataque = ataque;
		this.resistencia = resistencia;
		this.vida = vida;
	}
	
	
	private int getAtaque(){
		return
			(int)(Math.random() * (ataque.max - ataque.min) + ataque.min);
		
	}

	public String getTipo() {
		return null;
	}

	public int getVida() {
		return 0;
	}

	public int getResistencia() {
		return 0;
	}

	public int getForca() {
		return 0;
	}
}


