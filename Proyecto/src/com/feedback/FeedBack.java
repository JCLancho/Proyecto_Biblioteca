package com.feedback;

import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
/**
 * @source http://chuwiki.chuidiang.org/index.php?title=Ejemplo_sencillo_con_SwingWorker
 * @author dm2
 *
 */
public class FeedBack extends JPanel implements java.util.concurrent.RunnableFuture<JPanel> {
	
	private JLabel label;
	
	public FeedBack() {
		label = new JLabel();
		this.add(label);
		this.setPreferredSize(new Dimension(0, 50));
	}
	
	public void showFeedBack(int valor) {
		if(valor == 1) {
			this.setBackground(new Color( 167, 252, 135));
			this.label.setText("CORRECTO");
		}else {
			this.setBackground(new Color( 255, 97, 97 ));
			this.label.setText("ERROR");
		}
		this.setVisible(true);
		run();
	}

	@Override
	public void run() {

		try {
			
			Thread.sleep(2000);
			this.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean cancel(boolean arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JPanel get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel get(long arg0, TimeUnit arg1) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Override
//	protected String doInBackground() throws Exception {
//		try {
//			
//			Thread.sleep(2000);
//			this.panel.setVisible(false);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}


	
}
