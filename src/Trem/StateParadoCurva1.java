package Trem;

import Controlador.*;

class StateParadoCurva1 extends TremState
{
	private Controlador ctrl = Controlador.getCtrl();
	
	protected String status()
	{
		return "Parado";
	}
	
	protected TremState moveTrem(Trem t)
	{
		//Caso 1: trem da direita pra esquerda parado no sinal
		if(t.getSentido()==1 && t.getSteps()==9)
		{
			//Caso 1.1: sinal ainda fechado
			if(ctrl.isSinalDirVerde()==false)
			{
				return this;
			}
			//Caso 1.2: sinal já abriu
			else if(ctrl.isSinalDirVerde()==true)
			{
				StateAndandoCurva1 st = new StateAndandoCurva1();
				return st.moveTrem(t);
			}
		}
		//Caso 2: trem da esquerda pra direita parado no sinal
		if(t.getSentido()==2 && t.getSteps()==11)
		{
			//Caso 1.1: sinal ainda fechado
			if(ctrl.isSinalEsqVerde()==false)
			{
				return this;
			}
			//Caso 1.2: sinal já abriu
			else if(ctrl.isSinalEsqVerde()==true)
			{
				StateAndandoCurva1 st = new StateAndandoCurva1();
				return st.moveTrem(t);
			}
		}
		
		//Caso 3: trem em qualquer sentido parado antes ou depois do sinal
		StateAndandoCurva1 st = new StateAndandoCurva1();
		return st.moveTrem(t);
	}

	protected TremState nextState()
	{
		return this;
	}

	protected TremState stopState()
	{
		return this;
	}
}