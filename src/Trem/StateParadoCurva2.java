package Trem;

class StateParadoCurva2 extends TremState
{
	protected String status()
	{
		return "Parado";
	}
	
	protected TremState moveTrem(Trem t)
	{
		StateAndandoCurva2 st = new StateAndandoCurva2();
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