package FrameTrens;

public class CtrlFrameTrens 
{
	private static CtrlFrameTrens ctrlFrameTrens = null;
	private static FrameTrens frameTrens = null;
	
	private CtrlFrameTrens()
	{}
	
	public static CtrlFrameTrens getCtrlFrameTrens()
	{
		if(ctrlFrameTrens == null)
		{
			ctrlFrameTrens = new CtrlFrameTrens();
			frameTrens = new FrameTrens();
			
			frameTrens.registraObservadores();
		}
		return ctrlFrameTrens;
	}

}