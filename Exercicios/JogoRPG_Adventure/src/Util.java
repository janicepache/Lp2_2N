
public class Util {

	private Range ataque;
	
	public int getAtaque(int min, int max){
		
		return
			(int)(Math.random() * (ataque.max - ataque.min) + ataque.min);
		
	}
}
