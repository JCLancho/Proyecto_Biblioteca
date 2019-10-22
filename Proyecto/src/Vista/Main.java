package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnGestionarAlumno = new JButton("Gestionar Alumno");
		panel.add(btnGestionarAlumno);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnGestionarLibro = new JButton("Gestionar Libro");
		panel_1.add(btnGestionarLibro);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnGestionarPrestamo = new JButton("Gestionar Prestamo");
		panel_2.add(btnGestionarPrestamo);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_4.add(btnNewButton_1);
		
		JLabel label_2 = new JLabel("");
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3);
	}

}
