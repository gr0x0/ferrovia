package Trem;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import ObserverPattern.*;
import FrameTrens.*;
import Controlador.*;
import Main.*;

public class Trem
{
	private static int randomChance = 10;
	private static ArrayList<Trem> tremList = new ArrayList<Trem>();
	private int velocidade;
	private int sentido;
	private int x;
	private int y;
	private TremState state;
	private int steps;
	private int stepSize;
	private static Controlador ctrl = Controlador.getCtrl();
	private static Random randomizer = new Random();

	public Trem(int v, int s)
	{
		velocidade = v;
		sentido = s;
		steps = 0;
		if(s==1)
		{
			x = 994;
			y = 220;
			stepSize = -20;
		}
		else
		{
			x = 0;
			y = 217;
			stepSize = 20;
		}
		
		state = TremState.getInitialState(this);
		tremList.add(this);
	}

	public int getX()
	{
		return x;
	}

	protected void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	protected void setY(int y)
	{
		this.y = y;
	}

	public int getVelocidade()
	{
		return velocidade;
	}

	public int getSentido()
	{
		return sentido;
	}

	public int getSteps()
	{
		return steps;
	}

	protected void setSteps(int steps)
	{
		this.steps = steps;
	}

	protected void incSteps()
	{
		steps += velocidade;
	}

	public int getStepSize()
	{
		return stepSize;
	}

	public static int getRandomChance()
	{
		return randomChance;
	}

	public String status()
	{
		return state.status();
	}

	public void complete()
	{
		TremState st = state.complete();
		if(st != null)
			state = st;
	}

	public static ArrayList<Trem> getTremList()
	{
		return tremList;
	}

	public static void atualizarTrens()
	{
		ListIterator<Trem> helpList = tremList.listIterator();
		while(helpList.hasNext())
		{
			Trem t = helpList.next();
			if(t.checkBloqueado() == false)
				t.state = t.state.moveTrem(t);
			else
				t.state.stopState();
		}
	}

	private boolean checkBloqueado()
	{	
		ListIterator<Trem> helpList = tremList.listIterator();
		while(helpList.hasNext() && tremList.isEmpty()==false)
		{
			Trem t = helpList.next();
			if(this.sentido == t.sentido && 
					this.steps < t.steps && 
					this.steps + this.velocidade >= t.steps)
			{
				return true;
			}
		}
		return false;
	}

	public static void insereRandomTrem()
	{
		int i = randomizer.nextInt(randomChance);
		if(i==0)
		{
			int v = randomizer.nextInt(3);
			int s = randomizer.nextInt(2);
			v++; s++;
			Trem t = new Trem(v,s);
		
			if(s==1) ctrl.sensPDirAcionado();
			if(s==2) ctrl.sensPEsqAcionado();

			String sen = new String();
			switch(s)
			{
			case(1): sen = "Direita para esquerda"; break;
			case(2): sen = "Esquerda para direita"; break;
			default: sen = "Sentido desconhecido"; break;
			}
			int vel;
			switch(v)
			{
			case(1): vel = 40; break;
			case(2): vel = 50; break;
			case(3): vel = 60; break;
			default: vel = 0; break;
			}
			System.out.printf("---Trem inserido aleatoriamente---\nSentido: %s\nVelocidade: %d km/h\n", sen, vel);
		}
	}

	public static void insereTrem(int s, int v)
	{
		Trem t = new Trem(v,s);
		
		if(s==1) ctrl.sensPDirAcionado();
		if(s==2) ctrl.sensPEsqAcionado();

		String sen = new String();
		switch(s)
		{
		case(1): sen = "Direita para esquerda"; break;
		case(2): sen = "Esquerda para direita"; break;
		default: sen = "Sentido desconhecido"; break;
		}
		int vel;
		switch(v)
		{
		case(1): vel = 40; break;
		case(2): vel = 50; break;
		case(3): vel = 60; break;
		default: vel = 0; break;
		}
		System.out.printf("---Trem inserido por usuario---\nSentido: %s\nVelocidade: %d km/h\n", sen, vel);
	}
}
