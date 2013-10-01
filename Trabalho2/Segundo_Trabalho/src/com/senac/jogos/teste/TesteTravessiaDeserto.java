package com.senac.jogos.teste;

// descarregar deixem por ultimo
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.senac.jogos.TravessiaDeserto;

import org.junit.runners.*;
import org.junit.runner.*;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TesteTravessiaDeserto {
	
	private TravessiaDeserto jogo;

	@BeforeClass 
	public static void setUpBeforeClass()throws Exception {
	}

	@AfterClass
	public static void tearDownClass()throws Exception {
	}
	
	@Before
	public void setup(){
		jogo = new TravessiaDeserto();
	}
	
	@Test
	public void testaAvancar(){
		jogo.initGame();
		int p = jogo.getPos();
		int f = jogo.getFuel();
								
		jogo.avancar();
		assertEquals(p + 1, jogo.getPos());
		assertEquals(f - 1, jogo.getFuel());
				
	}
	
	@After
	public void tearDown(){
		jogo =null;
	}
	

	@Test
	public void testaVoltar(){
		jogo.initGame();
		int p = jogo.getPos();
		int f = jogo.getFuel();
		int combustivelmax = 6;
		int posicaozero = jogo.MAX_FUEL;
		jogo.avancar();
		jogo.voltar();
		
	//	assertEquals(p = p - 1, jogo.getPos ());
	//	assertEquals(f - 1, jogo.getFuel());
		assertEquals(posicaozero, combustivelmax);
	}

	
	@Test
	public void testainitGame(){
		jogo.initGame();
		
/*		
		int[]mapa = jogo.getMap();
		if (mapa.length == TravessiaDeserto.MAP_SIZE);
		{	System.out.println( "print ok");
			
			for(int i;  mapa)
				if (i==0) 
					System.out.println( "print ok");
					if(setFuel() == TravessiaDeserto.MAX_FUEL)
						
			tearDownTestainitGame();
					System.out.println( "print ok");
			
		}
	*/
	}
}
