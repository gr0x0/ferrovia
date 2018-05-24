package FramePrincipal;

public class CtrlFramePrincipal
{
	private static CtrlFramePrincipal ctrlFramePrincipal = null;
	private static FramePrincipal framePrincipal = null;
	
	private CtrlFramePrincipal()
	{}
	
	public static CtrlFramePrincipal getCtrlFramePrincipal()
	{
		if(ctrlFramePrincipal == null)
		{
			ctrlFramePrincipal = new CtrlFramePrincipal();
			framePrincipal = new FramePrincipal();
		}
		return ctrlFramePrincipal;
	}
}


