import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel1() {
		setBackground(Color.blue);
		setPreferredSize(new Dimension(200, 200));
		setVisible(false);
		
		JLabel l = new JLabel("label");
		this.add(l);
	}

}
