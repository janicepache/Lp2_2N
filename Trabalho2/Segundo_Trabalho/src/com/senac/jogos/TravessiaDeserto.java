package com.senac.jogos;

/**
* @author Janice Medianeira Moreira de Souza
* Trabalho 2
* Algoritmo do Jogo Travessia no Deserto
*/
public class TravessiaDeserto {

	public static final int MAP_SIZE = 10;
	public static final int MAX_FUEL = 6;

//cria��o do objeto de leitura
	public static final
		java.util.Scanner sc = new java.util.Scanner(System.in);

// declaracao das variaveis
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

	public static int getAjuda() {
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
	
// declaracao das variaveis posicao, combustivel e vetor mapa
	private int[] map;
	private int fuel;
	private int pos;

// m�todo principal
	public static void main(String[] args) {
		(new TravessiaDeserto()).run();
	}

	/**
	 *  m�todo de inicializa��o do jogo
	/ imprime no console o Status do jogo
	/ recebe atrav�s do Scanner - o comando do usu�rio e armazena na variavel cmd
	/ enquanto 
	/ 
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

// m�todo que retorna uma String da mensagem final
	public String getEndMessage() {
		if (isWinner())
			return "Voce GANHOU!";
		else
			return "Voce PERDEU.";
	}

// recebe um parametro se for verdadeiro retorna ...?
	public boolean isGameOver() {
		if (isWinner())
			return true;
		if (fuel == 0 && map[pos] == 0)
			return true;
		return false;
	}

// m�todo que quando o retorno for verdadeiro finaliza o jogo.
// m�todo para finalizar o jogo ??
	public boolean isWinner() {
		return pos == MAP_SIZE;
	}

// m�todo de inicializa��o do jogo
	public void initGame() {
		pos = 0;
		fuel = MAX_FUEL;
		map = new int[MAP_SIZE];
	}

// imprime no console o status do jogo - posicao e combustivel
	public void printStatus() {
		System.out.println(String.format("Voce esta na posicao %d.", pos));
		System.out.println(String.format("Voce possui %d unidades de combustivel.",fuel));
		if (pos > 0)
			System.out.println(String.format("Existem %d unidades de combustivel nessa posicao.", map[pos]));
	}

// armazena na variavel cmd o comando do jogo
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

// mostra no console os comandos do jogo
	public void ajuda() {
		System.out.println("Comandos: avancar voltar carregar descarregar ajuda");
	}

// m�todo que descarrega 01 unid de combustivel, se combustivel maior que 0, aumentando 01 combustivel na posicao
	public void descarregar() {
		if (fuel > 0) {
			fuel--;
			map[pos]++;
		}
	}

//m�todo que carrega 01 combust�vel sempre que posicao maior que 0, diminuindo 01 unid de combustivel na posicao.
	public void carregar() {
		if (map[pos] > 0) {
			map[pos]--;
			fuel++;
		}
	}

/** m�todo que volta 01 posicao sempre que combust�vel e posi��o maior que zero, diminuindo 01 unid de combustivel
 * se a posicao � zero carrega o maximo de combustivel(06).
*/
	public void voltar() {
		if (fuel > 0 && pos > 0) {
			fuel--;
			pos--;
		}
		if (pos == 0)
			fuel = MAX_FUEL;
	}

// m�todo que avan�a 01 posi��o se combust�vel maior que 0, diminuindo 01 unid. de combust�vel
	public void avancar() {
		if (fuel > 0) {
			fuel--;
			pos++;
		}
	}

}

