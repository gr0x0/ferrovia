package Controlador;

import FramePrincipal.*;
import FrameTrens.*;
import Trem.*;

public class Controlador
{	
	private static Controlador ctrl = null;
	private static boolean luzVerdeDir = true;
	private static boolean luzVermelhaDir = false;
	private static boolean luzVerdeEsq = true;
	private static boolean luzVermelhaEsq = false;
	private static int numTrensDir;
	private static int numTrensEsq;
	
	private Controlador()
	{}
	
	public static Controlador getCtrl()
	{
		if(ctrl==null)
		{
			ctrl = new Controlador();
		}
		
		return ctrl;
	}
	
	public static void sensPDirAcionado() //informa que um trem entrou no sistema pela direita
	{
		incDir();
		atualizarSinais();
	}
	
	public static void sensSDirAcionado() //informa que um trem saiu do sistema pela direita
	{
		decEsq();
		atualizarSinais();
	}
	
	public static void sensPEsqAcionado() //informa que um trem entrou no sistema pela esquerda
	{
		incEsq();
		atualizarSinais();
	}
	
	public static void sensSEsqAcionado() //informa que um trem saiu do sistema pela esquerda
	{
		decDir();
		atualizarSinais();
	}
	
	private static void atualizarSinais()
	{
		if(luzVerdeDir == true && luzVerdeEsq == true)
		{
			if(numTrensDir!=0 && numTrensEsq==0)
			{
				setSinalDir(true);
				setSinalEsq(false);
			}
			else if(numTrensDir==0 && numTrensEsq!=0)
			{
				setSinalDir(false);
				setSinalEsq(true);
			}
		}
		if(luzVerdeDir == true && luzVerdeEsq == false)
		{
			if(numTrensDir==0 && numTrensEsq==0)
			{
				setSinalDir(true);
				setSinalEsq(true);
			}
			else if(numTrensDir==0 && numTrensEsq!=0)
			{
				setSinalDir(false);
				setSinalEsq(true);
			}
		}
		if(luzVerdeDir == false && luzVerdeEsq == true)
		{
			if(numTrensDir==0 && numTrensEsq==0)
			{
				setSinalDir(true);
				setSinalEsq(true);
			}
			else if(numTrensDir!=0 && numTrensEsq==0)
			{
				setSinalDir(true);
				setSinalEsq(false);
			}
		}
	}
	
	private static void setSinalEsq(boolean est) //recebe TRUE para acender luz verde esquerda e apagar luz vermelha esquerda e 
											//FALSE para acender luz vermelha esquerda e apagar luz verde esquerda
	{
		if(est==true)
		{
			luzVerdeEsq = true;
			luzVermelhaEsq = false;
		}
		else
		{
			luzVerdeEsq = false;
			luzVermelhaEsq = true;
		}
	}
	
	private static void setSinalDir(boolean est) //recebe TRUE para acender luz verde direita e apagar luz vermelha direita e 
											//FALSE para acender luz vermelha direita e apagar luz verde direita
	{
		if(est==true)
		{
			luzVerdeDir = true;
			luzVermelhaDir = false;
		}
		else
		{
			luzVerdeDir = false;
			luzVermelhaDir = true;
		}
	}
	
	private static void incDir() //incrementa a variável numTrensDir de uma unidade
	{
		numTrensDir++;
	}
	
	private static void decDir() //decrementa a variável numTrensDir de uma unidade
	{
		numTrensDir--;
	}
	
	private static void incEsq() //incrementa a variável numTrensEsq de uma unidade
	{
		numTrensEsq++;
	}
	
	private static void decEsq() //decrementa a variável numTrensEsq de uma unidade
	{
		numTrensEsq--;
	}
	
	public boolean isSinalEsqVerde()
	{
		if(luzVerdeEsq==true)
			return true;
		else
			return false;
	}
	
	public boolean isSinalDirVerde()
	{
		if(luzVerdeDir==true)
			return true;
		else
			return false;
	}
}
