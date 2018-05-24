package Trem;

import Controlador.*;

class StateAndandoReta2 extends TremState
{
	int stepsMAXRight = 51;
	int stepsMAXLeft = 51;

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

		t.setX(x + (sz*v));
		t.incSteps();
		steps = t.getSteps();
		
		//Caso 1: trem da direita para a esquerda já no fim do percurso ou passado dele
		if(s == 1 && steps >= stepsMAXRight)
		{
			return nextState();
		}

		//Caso 2: trem da esquerda para a direita já no fim do percurso ou passado dele
		else if(s == 2 && steps == stepsMAXLeft)
		{
			return nextState();
		}		

		return this;
	}

	protected TremState nextState()
	{
		return new StateAndandoReta2();
	}

	protected TremState stopState()
	{
		return new StateParadoReta2();
	}
}