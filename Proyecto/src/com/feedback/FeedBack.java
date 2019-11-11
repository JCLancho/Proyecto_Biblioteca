package com.feedback;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;


/**
 * Clase que genera un hilo secundario para los mensajes de información, error y confirmacion con el usuario
 * @author Lancho
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
		switch (tipo) {
		case 0:
			panel.setBackground(new Color(255, 61, 61));
			break;
		case 1:
			panel.setBackground(new Color(132, 255, 128));
			break;
		case 2:
			panel.setBackground(new Color(255, 193, 79));
			break;
		default:
			break;
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
