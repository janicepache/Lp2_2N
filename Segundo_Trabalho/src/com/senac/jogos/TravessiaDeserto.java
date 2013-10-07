package com.senac.jogos;

/**
* @author Janice Medianeira Moreira de Souza
* Trabalho 2
* Algoritmo do Jogo Travessia no Deserto
*/
public class TravessiaDeserto {

	public static final int MAP_SIZE = 10;
	public static final int MAX_FUEL = 6;

/** Criacao do objeto de leitura sc */
public static final
		java.util.Scanner sc = new java.util.Scanner(System.in);

	/** declaracao das variaveis */
	public static final int AVANCAR = 0;
	
	public static int getMapSize() {
		return MAP_SIZE;
	}

	public static int getMaxFuel() {
		return MAX_FUEL;
	}

	public static java.util.Scanner getSc() {
		return sc;
	}

	public static int getAvancar() {
		return AVANCAR;
	}

	public static int getVoltar() {
		return VOLTAR;
	}

	public static int getCarregar() {
		return CARREGAR;
	}

	public static int getDescarregar() {
		return DESCARREGAR;
	}

	public int getAjuda() {
		return AJUDA;
	}

	public static int getError() {
		return ERROR;
	}

	public int[] getMap() {
		return map;
	}

	public int getFuel() {
		return fuel;
	}

	public int getPos() {
		return pos;
	}

	public static final int VOLTAR = 1;
	public static final int CARREGAR = 2;
	public static final int DESCARREGAR = 3;
	public static final int AJUDA = 4;
	public static final int ERROR = -1;
	
	/** declaracao das variaveis posicao, combustivel e vetor mapa */
	private int[] map;
	private int fuel;
	private int pos;

	/** método principal - instancia o objeto TravessiaDeserto*/
	public static void main(String[] args) {
		(new TravessiaDeserto()).run();
	}

	/** Método de inicialização do jogo
	 * onde irá imprimir no console o Status do jogo
	 * recebe através do Scanner - o comando do usuário e armazena na variavel cmd
	 * enquanto o jogo em andamento.
	 * Imprimindo no final a mensagem
	*/
	public void run() {
		initGame();
		do {
			printStatus();
			int cmd = translateCommand( sc.next() );
			processCommand( cmd );
		} while (!isGameOver());
		
		System.out.println(getEndMessage());
	}

	/** Método que se o retorno do método isWinner for verdadeiro
	 * retorna uma String da mensagem final - "voce ganhou"
	 * senão retorna String "voce perdeu"	
	 * @return String "Voce ganhou" ou "Voce perdeu".
 	*/
	public String getEndMessage() {
		if (isWinner())
			return "Voce GANHOU!";
		else
			return "Voce PERDEU.";
	}

	/** Método isGameOver só termina se 
	 * jogo tiver iniciado,
	 * se não tiver combustível, 
	 * se o local onde estiver , não tem combustível para carregar  Map[pos]>0,
	 * se estiver na posição 10
	 * @return booleano
	 */
	public boolean isGameOver() {
		if (isWinner())
			return true;
		if (fuel == 0 && map[pos] == 0)
			return true;
		return false;
	}


	/** método booleano que atribui a variavel pos o valor de MAP_SIZE.*/
	public boolean isWinner() {
		return pos == MAP_SIZE;
	}

	/** método de inicialização do jogo */
	public void initGame() {
		pos = 0;
		fuel = MAX_FUEL;
		map = new int[MAP_SIZE];
	}

	/** Método que imprime no console o status do jogo - posicao e combustivel,
	 * se posicao maior que 0 - informa a quantidade de combustivel
	*/
	public void printStatus() {
		System.out.println(String.format("Voce esta na posicao %d.", pos));
		System.out.println(String.format("Voce possui %d unidades de combustivel.",fuel));
		if (pos > 0)
			System.out.println(String.format("Existem %d unidades de combustivel nessa posicao.", map[pos]));
	}

	/** armazena na variavel cmd o comando do jogo */
	public int translateCommand(String command) {
		String cmd = command.toLowerCase();
		if (cmd.equals("avancar"))
			return AVANCAR;
		if (cmd.equals("voltar"))
			return VOLTAR;
		if (cmd.equals("carregar"))
			return CARREGAR;
		if (cmd.equals("descarregar"))
			return DESCARREGAR;
		if (cmd.equals("ajuda"))
			return AJUDA;
		return ERROR;
	}

// switch 
	public void processCommand(int command) {
		switch (command) {
			case AVANCAR:
				avancar();
				break;
			case VOLTAR:
				voltar();
				break;
			case CARREGAR:
				carregar();
				break;
			case DESCARREGAR:
				descarregar();
				break;
			case AJUDA:
				ajuda();
				break;
			default:
				System.err.println("Comando invalido.");
		}
	}

	/** Método Ajuda - mostra no console os comandos do jogo */
	public void ajuda() {
		System.out.println("Comandos: avancar voltar carregar descarregar ajuda");
	}

	/** Método descarregar - só pode descarregar se:
	* jogo tiver iniciado,
	* se ele tiver combustível para descarregar,
	* Se não tiver combustível para descarregar , mas o local onde ele estiver tenha combustível
	* não deve estar na posição 10 ; pois aí o jogo já terminou
	 */
	public void descarregar() {
		if (fuel > 0) {
			fuel--;
			map[pos]++;
		}
	}

	/** Método carregar – só pode carregar se jogo tiver iniciado,
	 * Local onde estiver, deverá ter combustível para carregar  Map[pos]>0,
	 * não pode carregar mais que 6, não deve estar na posição 10 
	 */
 	public void carregar() {
		if (map[pos] > 0) {
			map[pos]--;
			fuel++;
		}
	}
	
	/** Método voltar - só pode voltar se:
	* jogo tiver iniciado,
	* não estiver na posição zero, se tiver combustível,
	* diminui 01 combustivel e 01 posicao.
	* Se voltar para a posicao 0 = atribui o MAX_FUEL (06 unidades de combustivel).
	*/
	public void voltar() {
		if (fuel > 0 && pos > 0) {
			fuel--;
			pos--;
		}
		if (pos == 0)
			fuel = MAX_FUEL;
	}
	
	/** Método avançar - só pode avançar se:
	* jogo tiver iniciado, tiver gasolina,
	* Dimunui 01 combustivel e aumenta 01 posicao.
	* não deve estar na posição 10; pois aí o jogo já terminou
	*/ 
	public void avancar() {
		if (fuel > 0) {
			fuel--;
			pos++;
		}
	}

}

