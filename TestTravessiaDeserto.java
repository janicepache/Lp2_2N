package com.senac.jogos.teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.senac.jogos.TravessiaDeserto;
import org.junit.runners.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

/**
* Classe de testes da Travessia Deserto
* @author Janice Medianeira Moreira de Souza
* Trabalho 2
*/

@RunWith(JUnit4.class)
public class TestTravessiaDeserto {
	
	private TravessiaDeserto jogo;

	@BeforeClass 
	public static void setUpBeforeClass()throws Exception {
		System.out.println("Iniciando os testes");
	}

	@AfterClass
	public static void tearDownClass()throws Exception {
	}


	// Teste do AVANÇAR
	@Before
	public void setUpA() {
		jogo = new TravessiaDeserto();
	}

	@Test
	public void testAvancar() {
		System.out.println("Teste do Avançar");
		jogo.initGame();

		int pos = jogo.getPos();
		int fuel = jogo.getFuel();

		if (fuel<1) {  				// Testa condicao de nao poder avancar
			jogo.avancar();
			assertEquals(pos, jogo.getPos());
			assertEquals(fuel, jogo.getFuel());
		}
		else if (pos>9) {			// Testa condicao de nao poder avancar
			jogo.avancar();
			assertEquals(pos, jogo.getPos());
			assertEquals(fuel, jogo.getFuel());
		}
		else {						// Testa quando deve avancar
			jogo.avancar();
			assertEquals(pos + 1, jogo.getPos());
			assertEquals(fuel - 1, jogo.getFuel());
		}

	}
	
	
	@After
	public void tearDownA() {
		jogo = null;
	}
		
	@Before
	public void setUpV() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testVoltar() {

		jogo.initGame();

		int pos = jogo.getPos();
		int fuel = jogo.getFuel();

		if (fuel<1) {  				// Testa condicao de nao poder voltar
			jogo.voltar();
			assertEquals(pos, jogo.getPos());
			assertEquals(fuel, jogo.getFuel());
		}
		else if (pos==0) {			// Testa condicao de nao poder voltar
			jogo.voltar();
			assertEquals(pos, jogo.getPos());
			assertEquals(fuel, jogo.getFuel());
		}
		else {						// DEVE VOLTAR 
			jogo.voltar();
			assertEquals(pos - 1, jogo.getPos());
			assertEquals(fuel - 1, jogo.getFuel());
		}

	}
	
	@After
	public void tearDownV() {
		jogo = null;
	}
	
	
	//Testa a inicializacao do jogo
	
	@Before
	public void setUpI() {
		jogo = new TravessiaDeserto();
	}

	@Test
	public void testInitGame() {
		jogo.initGame();
		
		assertEquals(0, jogo.getPos());
		assertEquals(6, jogo.getFuel());
		assertEquals(10,jogo.MAP_SIZE);
	}
	
	@After
	public void tearDownI() {
		jogo = null;
	}
	
	
	//Testa CARREGAR
	
		@Before
		public void setUpC() {
			jogo = new TravessiaDeserto();

		}

		@Test
		public void testCarregar() {
			System.out.println("Test Carregar");

			jogo.initGame();
		
			int fuel = jogo.getFuel();
			int [] estoque = jogo.getMap();
	
			
			if (fuel>5) {			//NAO PODE CARREGAR
				jogo.carregar();
				assertEquals(fuel, jogo.getFuel());
			}
			if (jogo.getPos()==0) {		//DEVE REPOR 6 NO FUEL
//				jogo.descarregar();
//				jogo.descarregar();
				jogo.carregar();
				assertEquals(6, jogo.getFuel());
			}
			

			for (int i=1; i<10; i++) {			//NAO PODE CARREGAR
				if (estoque[i]==0) {
				jogo.carregar();
				assertEquals(fuel, jogo.getFuel());
				System.out.println("nao"+i);
				}
			}

			jogo.descarregar();
			jogo.descarregar();
			jogo.descarregar();
			jogo.descarregar();
			estoque[1]=1;
			estoque[2]=1;
			estoque[3]=0;
			
			for (int cont=0; cont<10; cont++) {
				
				fuel=jogo.getFuel();
				
				if (estoque[cont]>0) {
					jogo.carregar();
					assertEquals(fuel+1, jogo.getFuel());
					System.out.println("deve"+cont);
				}
				else {
					System.out.println("nao tem gasolina"+cont);
				}
				
			}
		
		} 
		
		@After
		public void tearDownC() {
			jogo = null;
		}
	
}
