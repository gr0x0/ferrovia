package Trem;

class StateAndandoTunel extends TremState
{
	int stepsMAXRight = 35;
	int stepsMAXLeft = 37;
	int stepSizeY = 5;

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

		//Caso 1: trem da direita para a esquerda
		if(s == 1)
		{
			//Caso 1.1: está na borda da curva
			if(steps == stepsMAXRight)
			{
				if(s==1&&v==2) t.setY(y+4);
				return nextState();
			}
			//Caso 1.2: já entrou na curva
			else if(steps > stepsMAXRight)
			{
				int stepsY = steps - stepsMAXRight;
				while(stepsY > 0)
				{
					y += stepSizeY;
					stepsY--;
				}
				t.setY(y);
				return nextState();
			}
		}		
		//Caso 2: trem da esquerda para a direita
		else if(s == 2)
		{
			//Caso 2.1: está na borda da curva
			if(steps == stepsMAXLeft)
				return nextState();
			//Caso 2.2: já entrou na curva
			else if(steps > stepsMAXLeft)
			{
				int stepsY = steps - stepsMAXLeft;
				while(stepsY > 0)
				{
					y += stepSizeY;
					stepsY--;
				}
				t.setY(y);
				return nextState();
			}
		}		
		
		return this;
	}

	protected TremState nextState()
	{
		return new StateAndandoCurva2();
	}

	protected TremState stopState()
	{
		return new StateParadoTunel();
	}
}