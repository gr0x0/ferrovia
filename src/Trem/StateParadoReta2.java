package Trem;

class StateParadoReta2 extends TremState
{
	protected String status()
	{
		return "Parado";
	}
	
	protected TremState moveTrem(Trem t)
	{
		StateAndandoReta2 st = new StateAndandoReta2();
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