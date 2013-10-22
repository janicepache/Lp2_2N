
public class Personagem {

	private int vida;
	private int forca;
	private int resistencia;


	public boolean isVivo(){
		if (vida < 1){
			return false;
		}
		return true;
		
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getForca() {
		return forca;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	public Personagem(int v, int f, int r) throws Exception{
		if(v <=0) throw new Exception ("Vc não tem mais vida");
		if(f <=0) throw new Exception ("Não tem força");
		if(r <=0) throw new Exception ("Não tem resistência");
		vida = v;
		forca = f;
		resistencia = r;
		
		
	}
	public int getAtaque(){
		return forca;
	}

	public void setDano(int dano){
		if (dano > 0){
			vida -= dano - resistencia;
		}
		
		
	}
}
