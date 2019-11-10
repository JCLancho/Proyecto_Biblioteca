package com.feedback;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;


/**
 * @author dm2
 *
 */
public class FeedBack extends SwingWorker<Void, Void>{
	
	private JPanel panel;
	private JLabel label;
	private JPanel panelPrincipal;
	
	public FeedBack(JPanel panelFeeback, int tipo, String mensaje) {
		for(Component c : panelFeeback.getComponents()) {
			c.setVisible(false);
		}
		panel = new JPanel(new FlowLayout());
		FlowLayout fl = (FlowLayout) panel.getLayout();
		fl.setAlignment(FlowLayout.LEFT);
		if(tipo == 1) {
			panel.setBackground(new Color(132, 255, 128));
		}else {
			panel.setBackground(new Color(255, 61, 61));
		}
		label = new JLabel(mensaje);
		panel.add(label);
		panelPrincipal = panelFeeback;
		panelPrincipal.add(panel);
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		Thread.sleep(2000);
		panel.setVisible(false);
		return null;
	}
	

}
