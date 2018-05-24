package Trem;

import Controlador.*;

class StateAndandoCurva2 extends TremState
{
	int stepsMAXRight = 44;
	int stepsMAXLeft = 45;
	int stepSizeY = 10;
	Controlador ctrl = Controlador.getCtrl();
	
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
		t.setX(x + (sz*v));
		//Movendo em y:
		if(s==1) t.setY(y + (6*v));
		if(s==2) t.setY(y + (6*v));
		//Atualizando os steps:
		t.incSteps();
		steps = t.getSteps();
		
		//Caso 1: trem da direita para a esquerda
		if(s == 1)
		{				
			//Caso 1.1: está na borda da reta
			if(steps == stepsMAXRight)
			{
				ctrl.sensSEsqAcionado();
				return nextState();
			}
			//Caso 1.2: já entrou na reta
			else if(steps > stepsMAXRight)
			{
				int stepsY = steps - stepsMAXRight;
				while(stepsY > 0)
				{
					y += stepSizeY;
					stepsY--;
				}
				t.setY(y);
				ctrl.sensSEsqAcionado();
				return nextState();
			}
			return this;
		}

		//Caso 2: trem da esquerda para a direita
		else if(s == 2)
		{				
			//Caso 2.1: está na borda da reta
			if(steps == stepsMAXLeft)
			{
				ctrl.sensSDirAcionado();
				return nextState();
			}
			//Caso 2.2: já entrou na reta
			else if(steps > stepsMAXLeft)
			{
				int stepsY = steps - stepsMAXLeft;
				while(stepsY > 0)
				{
					y += stepSizeY;
					stepsY--;
				}
				t.setY(y);
				ctrl.sensSDirAcionado();
				return nextState();
			}
			return this;
		}
		return this;
	}
	
	protected TremState nextState()
	{
		return new StateAndandoReta2();
	}
	
	protected TremState stopState()
	{
		return new StateParadoCurva2();
	}
}