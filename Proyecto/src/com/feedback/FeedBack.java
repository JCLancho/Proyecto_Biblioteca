package com.feedback;

import javax.swing.JPanel;
import javax.swing.SwingWorker;
/**
 * @source http://chuwiki.chuidiang.org/index.php?title=Ejemplo_sencillo_con_SwingWorker
 * @author dm2
 *
 */
public class FeedBack extends SwingWorker<Boolean, Void> {
	
	private JPanel panel;
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	@Override
	protected Boolean doInBackground() throws Exception {
		panel.setVisible(true);
		try {
			Thread.sleep(2000);
			this.panel.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}


	
}
