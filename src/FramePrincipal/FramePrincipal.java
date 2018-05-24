package FramePrincipal;

import java.awt.*;
import javax.swing.*;

class FramePrincipal extends JFrame
{	
	private PainelPrincipal background;
		
	public FramePrincipal()
	{					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setBounds(10, 100, 1024, 512);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		this.setLayout(new BorderLayout());
		this.setVisible(true);	
		
		background = new PainelPrincipal();
		this.add(background);
		background.setVisible(true);
        
		this.validate();
		
	}
}