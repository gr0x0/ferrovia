package Trem;

class StateParadoTunel extends TremState
{
	protected String status()
	{
		return "Parado";
	}
	
	protected TremState moveTrem(Trem t)
	{
		StateAndandoTunel st = new StateAndandoTunel();
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