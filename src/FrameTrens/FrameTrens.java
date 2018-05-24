package FrameTrens;

import java.awt.*;
import javax.swing.*;
import ObserverPattern.*;

import java.util.ArrayList;
import java.util.ListIterator;

class FrameTrens extends JFrame
{	
	private PainelSentido pSentido;
	private PainelVelocidade pVelocidade;
		
	protected FrameTrens()
	{					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setBounds(1050, 100, 300, 512);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		this.setLayout(new BorderLayout());
		this.setVisible(true);	
		
		JPanel painelGeral = new JPanel();
		BoxLayout layout = new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS);
		painelGeral.setLayout(layout);
		
		
		JLabel labelVelocidade = new JLabel("-VELOCIDADE-");
		painelGeral.add(labelVelocidade);
		pVelocidade = new PainelVelocidade();
		painelGeral.add(pVelocidade);
		pVelocidade.setVisible(true);
		
		JLabel labelSentido = new JLabel("-SENTIDO-");		
		painelGeral.add(labelSentido);
		pSentido = new PainelSentido();
		painelGeral.add(pSentido);
		pSentido.setVisible(true);
		
		this.add(painelGeral,BorderLayout.CENTER);        
		this.validate();		
	}
	
	public void registraObservadores()
	{
		pVelocidade.add((ObservadorIF)pSentido);
	}
}