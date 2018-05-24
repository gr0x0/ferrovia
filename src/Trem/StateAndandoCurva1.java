package Trem;

import Controlador.*;

class StateAndandoCurva1 extends TremState
{
	private int stepsSinalRight = 9;
	private int stepsSinalLeft = 11;
	private int stepsMAXRight = 12;
	private int stepsMAXLeft = 15;
	private int stepSizeY = 4;
	private Controlador ctrl = Controlador.getCtrl();

	protected String status()
	{
		return "Andando";
	}

	protected TremState moveTrem(Trem t)
	{
		int x = t.getX();
		int y = t.getY();
		int v = t.getVelocidade();
		int s = t.getSentido();
		int sz = t.getStepSize();
		int steps = t.getSteps();
		
		//Movendo em x:
		x += sz*v;
		t.setX(x);
		//Movendo em y:
		y += stepSizeY*v;
		t.setY(y);
		//Atualizando os steps:
		t.incSteps();
		steps = t.getSteps();

		//Caso 1: trem da direita para a esquerda
		if(s == 1)
		{	
			//Caso 1.1: chegou ou acabou de passar do sinal
			if(steps >= stepsSinalRight && steps - stepsSinalRight < v)
			{
				//Caso 1.1.1: sinal aberto
				if(ctrl.isSinalDirVerde()==true)
				{
					return this;
				}
				//Caso 1.1.2: sinal fechado
				else if(ctrl.isSinalDirVerde()==false)
				{
					x -= steps - stepsSinalRight;
					t.setX(x);
					y -= steps - stepsSinalRight;
					t.setY(y);
					t.setSteps(stepsSinalRight);
					return stopState();
				}
			}
			//Caso 1.2: está na borda do túnel
			else if(steps == stepsMAXRight)
				return nextState();
			//Caso 1.3: já entrou no túnel
			else if(steps > stepsMAXRight)
			{				
				return nextState();
			}
		}
		//Caso 2: trem da esquerda para a direita
		else if(s == 2)
		{		
			//Caso 2.1: chegou ou acabou de passar do sinal
			if(steps >= stepsSinalLeft && steps - stepsSinalLeft < v)
			{
				//Caso 2.1.1: sinal aberto
				if(ctrl.isSinalEsqVerde()==true)
				{
					return this;
				}
				//Caso 2.1.2: sinal fechado
				else if(ctrl.isSinalEsqVerde()==false)
				{
					x -= steps - stepsSinalLeft;
					t.setX(x);
					y -= steps - stepsSinalLeft;
					t.setY(y);
					t.setSteps(stepsSinalLeft);
					return stopState();
				}
			}
			//Caso 2.2: está na borda do túnel
			else if(steps == stepsMAXLeft)
				return nextState();
			//Caso 2.3: já entrou no túnel
			else if(steps > stepsMAXLeft)
			{
				return nextState();
			}
		}
		return this;
	}

	protected TremState nextState()
	{
		return new StateAndandoTunel();
	}

	protected TremState stopState()
	{
		return new StateParadoCurva1();
	}
}