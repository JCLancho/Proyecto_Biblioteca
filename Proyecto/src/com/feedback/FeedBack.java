package com.feedback;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class FeedBack extends SwingWorker<String, Object>{
	
	JPanel panel;
	JLabel label;
	
	public FeedBack(JPanel panel, int valor){
		this.panel = panel;
		if(valor == 1) {
			this.panel.setBackground(new Color( 167, 252, 135));
			this.label = new JLabel("Correcto");
		}else {
			this.panel.setBackground(new Color( 255, 97, 97 ));
			this.label = new JLabel("Error");
		}
		this.panel.add(label);
		this.panel.setVisible(true);
		this.panel.setPreferredSize(new Dimension(0, 50));
	}
	
	@Override
	protected String doInBackground() throws Exception {
		try {
			
			Thread.sleep(2000);
			this.panel.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
