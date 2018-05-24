package FrameTrens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import Trem.*;
import ObserverPattern.*;

class PainelSentido extends JPanel implements ObservadorIF
{
	private BasicArrowButton buttonRight = new BasicArrowButton(BasicArrowButton.EAST);
	private BasicArrowButton buttonLeft = new BasicArrowButton(BasicArrowButton.WEST);
	private int velocidade = 1;
		
	protected PainelSentido()
	{	
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		buttonLeft.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                Trem.insereTrem(1,velocidade);
            }
        });
		
		buttonRight.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	Trem.insereTrem(2,velocidade);
            }
        });
		
		this.add(buttonLeft);
		buttonLeft.setVisible(true);
		
		this.add(buttonRight);
		buttonRight.setVisible(true);				
	}

	public void notify(ObservadoIF o) 
	{
		velocidade = o.get(0);
	}
}