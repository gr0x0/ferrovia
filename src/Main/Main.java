package Main;

import Controlador.*;
import FramePrincipal.*;
import FrameTrens.*;
import Trem.*;

public class Main
{		
	public static void main(String[] args)
	{
		Controlador ctrl = Controlador.getCtrl();
		CtrlFramePrincipal ctrlFramePrincipal = CtrlFramePrincipal.getCtrlFramePrincipal();
		CtrlFrameTrens ctrlFrameTrens = CtrlFrameTrens.getCtrlFrameTrens();
	}
}
