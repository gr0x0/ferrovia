package Trem;

class StateParadoReta1 extends TremState
{
	protected String status()
	{
		return "Parado";
	}
	
	protected TremState moveTrem(Trem t)
	{
		StateAndandoReta1 st = new StateAndandoReta1();
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