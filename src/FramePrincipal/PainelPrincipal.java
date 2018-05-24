package FramePrincipal;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import Trem.*;
import Controlador.*;
import Main.*;

public class PainelPrincipal extends JPanel
{
	private Image imgBackground;
	private static Timer timer;
	private static int RepaintTimer;
	private static ActionListener repaintListener;
	private ArrayList<Trem> tremList;
	private Controlador ctrl = Controlador.getCtrl();
	
	public PainelPrincipal()
	{
		tremList = Trem.getTremList();
		
		repaintListener = new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				  Trem.atualizarTrens();
				  Trem.insereRandomTrem();			  
				  repaintFrame();
			  }
			};
			
		timer = new Timer(1000, repaintListener);
		timer.start();
		System.out.printf("Chance de um trem ser inserido por segundo: 1/%d\n", Trem.getRandomChance());
		System.out.printf("Para modifica-la:\n     1) Abra a package Trem.\n     2) Abra a classe Trem\n     3) Modifique o valor da variavel RandomChance para o desejado (linha 12)\n");
		System.out.printf("O tempo de atualizacao da movimentacao dos trens e de 1 segundo.\n");
		System.out.printf("Para modifica-lo:\n     1) Abra a package FramePrincipal\n     2) Abra a classe PainelPrincipal.\n     3) Modifique o valor do parametro do construtor da classe Timer para o desejado (linha 35).\n");
		System.out.printf("OBS: As velocidades possuem chances iguais (1/3), assim como o sentido (1/2).\n");
		System.out.printf("LOG de inserção de trens:\n\n");
	}
	
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g;

		try
		{
			imgBackground = ImageIO.read(new File("img\\Trem_menor.gif"));
			graphics2D.drawImage(imgBackground, 0, 0, null);
			
			ListIterator<Trem> helpList = tremList.listIterator();
			while(helpList.hasNext())
			{
				Trem t = helpList.next();
				g.drawOval(t.getX(), t.getY(), 18, 18);
				if(t.getSentido()==1) g.setColor(Color.BLACK);
				else g.setColor(Color.RED);
				g.fillOval(t.getX(), t.getY(), 18, 18);
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	private void repaintFrame()
	{		
		this.repaint();
	}
}
