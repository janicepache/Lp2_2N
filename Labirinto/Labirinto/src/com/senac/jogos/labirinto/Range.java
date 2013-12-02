package com.senac.jogos.labirinto;

import java.util.Date;
import java.util.Random;

public class Range {
	
	private int min;
	private int max;
	private Random randomGenerator;
	
	public Range(int min, int max)
	{
		this.min = min;
		this.max = max;
		this.randomGenerator = new Random();
		this.randomGenerator.setSeed((new Date()).getTime());
	}
	
	public int getMin()
	{
		return min;
	}
	
	public int getMax()
	{
		return max;
	}
	
	public int getRandom()
	{
		int range = max - min;
		return randomGenerator.nextInt(range + 1) + min;
	}
	
	public static int getPercentual()
	{
		return (new Range(0,100)).getRandom();
	}
}
