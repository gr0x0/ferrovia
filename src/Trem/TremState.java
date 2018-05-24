package Trem;

import java.util.ArrayList;

abstract class TremState 
{
	private static Trem trem;
	
	protected static TremState getInitialState(Trem t)
	{
		trem = t;
		return new StateAndandoReta1();
	}
	
	protected abstract String status();
	
	protected abstract TremState moveTrem(Trem t);
	
	protected abstract TremState nextState();
	
	protected abstract TremState stopState();
		
	protected TremState complete()
	{
		return null;
	}
	
}
