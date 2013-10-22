
public class Inimigo extends Personagem {
	
	private String tipo;
	
	public Inimigo(TipoInimigo inimigo) throws Exception{
		super(inimigo.getVida(), inimigo.getForca(), inimigo.getResistencia());
		this.tipo = inimigo.getTipo();
		
	}

	public String toString (){
		return tipo;

	}
}
