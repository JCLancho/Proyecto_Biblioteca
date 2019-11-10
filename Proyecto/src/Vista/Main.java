package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import com.redim.RedimImage;

import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class Main extends JFrame {

	private JPanel contentPane, panelNorte, panelCentral, panelBotones;
	private JToggleButton btnAlumno, btnLibro, btnPrestamos, btnDevoluciones;
	
	public static JPanel panelFeedback;

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
		setSize(800, 700);
		dibujar();
		eventos();
		
	}
	
	private void dibujar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelBotones = new JPanel();
		FlowLayout fl_panelBotones = (FlowLayout) panelBotones.getLayout();
		fl_panelBotones.setHgap(0);
		fl_panelBotones.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelBotones);
		
		btnAlumno = new JToggleButton("Alumnos");
		btnAlumno.setPreferredSize(new Dimension(120, 25));
		panelBotones.add(btnAlumno);
		
		btnLibro = new JToggleButton("Libros");
		btnLibro.setPreferredSize(new Dimension(120, 25));
		panelBotones.add(btnLibro);
		
		btnPrestamos = new JToggleButton("Prestamos");
		btnPrestamos.setPreferredSize(new Dimension(120, 25));
		panelBotones.add(btnPrestamos);
		
		btnDevoluciones = new JToggleButton("Devoluciones");
		btnDevoluciones.setPreferredSize(new Dimension(120, 25));
		panelBotones.add(btnDevoluciones);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(btnAlumno);
		grupo.add(btnLibro);
		grupo.add(btnPrestamos);
		grupo.add(btnDevoluciones);
		
		panelFeedback = new JPanel();
		panelNorte.add(panelFeedback);
		panelFeedback.setLayout(new BoxLayout(panelFeedback, BoxLayout.X_AXIS));
		
		panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(panelCentral, BorderLayout.CENTER);
	}
	
	private void eventos() {
		
		btnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				reset();
				panelCentral.add(new AlumnoView(), BorderLayout.CENTER);
				repaint();
				revalidate();

				
			}
		});
		
		btnLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				reset();
				panelCentral.add(new LibroView(), BorderLayout.CENTER);
				repaint();
				revalidate();

			}
		});
		
		btnPrestamos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				reset();
				panelCentral.add(new PrestamoView(), BorderLayout.CENTER);
				repaint();
				revalidate();

			}
		});
		
		btnDevoluciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				reset();
				panelCentral.add(new DevolucionView(), BorderLayout.CENTER);
				repaint();
				revalidate();
				
			}
		});
	}
	
	private void reset() {
		for(Component c : panelCentral.getComponents()) {
			panelCentral.remove(c);
		}

	}

}
