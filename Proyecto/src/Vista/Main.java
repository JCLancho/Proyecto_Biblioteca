package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

public class Main extends JFrame {

	private JPanel contentPane;
	private AlumnoView alumno;
	private LibroView libro;
	private PrestamoView prestamo;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		FlowLayout fl_panelNorte = (FlowLayout) panelNorte.getLayout();
		fl_panelNorte.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel();
		FlowLayout fl_panelBotones = (FlowLayout) panelBotones.getLayout();
		fl_panelBotones.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelBotones);
		
		JToggleButton btnAlumno = new JToggleButton("Gestionar Alumnos");
		panelBotones.add(btnAlumno);
		
		JToggleButton btnLibro = new JToggleButton("Gestionar Libros");
		panelBotones.add(btnLibro);
		
		JToggleButton btnPrestamos = new JToggleButton("Gestionar Prestamos");
		panelBotones.add(btnPrestamos);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(btnAlumno);
		grupo.add(btnLibro);
		grupo.add(btnPrestamos);
		
		JPanel panelFeedback = new JPanel();
		panelNorte.add(panelFeedback);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout(0, 0));
		alumno = new AlumnoView();
		libro = new LibroView();
		prestamo = new PrestamoView();
		
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		btnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(Component c : panelCentral.getComponents()) {
					panelCentral.remove(c);
				}
				panelCentral.add(alumno, BorderLayout.CENTER);
				alumno.setVisible(true);
				libro.setVisible(false);
				prestamo.setVisible(false);
				
			}
		});
		
		btnLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				for(Component c : panelCentral.getComponents()) {
					panelCentral.remove(c);
				}
				panelCentral.add(libro, BorderLayout.CENTER);
				libro.setVisible(true);
				alumno.setVisible(false);
				prestamo.setVisible(false);
				
			}
		});
		
		btnPrestamos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				for(Component c : panelCentral.getComponents()) {
					panelCentral.remove(c);
				}
				panelCentral.add(prestamo, BorderLayout.CENTER);
				prestamo.setVisible(true);
				libro.setVisible(false);
				alumno.setVisible(false);
				
			}
		});
	}

}
