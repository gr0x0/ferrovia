package FrameTrens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.*;
import ObserverPattern.*;
import Trem.Trem;

class PainelVelocidade extends JPanel implements ObservadoIF
{
	private ArrayList<ObservadorIF> observadorList = new ArrayList<ObservadorIF>();
	private JRadioButton b1 = new JRadioButton("40 Km/h",true);
	private JRadioButton b2 = new JRadioButton("50 Km/h");
	private JRadioButton b3 = new JRadioButton("60 Km/h");
	private ButtonGroup bg = new ButtonGroup();
	
	protected PainelVelocidade()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                atualiza();
            }
        });
		b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                atualiza();
            }
        });
		b3.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                atualiza();
            }
        });
		
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);		
		b1.setBounds(100,30,100,30);
		b2.setBounds(100,60,100,30);
		b3.setBounds(100,90,100,30);
		this.add(b1);
		this.add(b2);
		this.add(b3);
	}
	
	public void add(ObservadorIF o)
	{
		observadorList.add(o);
	}
	
	private void atualiza()
	{
		ListIterator<ObservadorIF> helpList = observadorList.listIterator();
		while(helpList.hasNext())
		{
			helpList.next().notify(this);
		}
			
	}
	
	public int get(int i)
	{
		if(b1.isSelected()==true)
			return 1;
		else if(b2.isSelected()==true)
			return 2;
		else if(b3.isSelected()==true)
			return 3;
		
		return 0;
	}
	
	public void remove(ObservadorIF o)
	{
		observadorList.clear();
	}
}
