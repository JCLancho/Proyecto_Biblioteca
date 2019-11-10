package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.feedback.FeedBackConstants;

import Controller.AlumnoController;
import Controller.AsignaturaController;

public class AsignaturaDetalle extends JDialog {

	private JPanel contentPane, panel_1, panel_2;
	private JTextField inputAsignatura, inputAbreviatura;
	private JButton btnGuardar, btnCancelar;

	private AsignaturaController asignaturaController;

	
	
	public AsignaturaDetalle(Container c) {
		asignaturaController = new AsignaturaController();
		dibujar();
		eventos();
		setTitle("Añadir Asignatura");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(466, 182);
		setModal(true);
		setLocationRelativeTo(c);
		setVisible(true);		
		
	}
	
	private void dibujar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 180, 30, 180, 30};
		gbl_panel.rowHeights = new int[] {5, 20, 5, 20, 5};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblAsignatura = new JLabel("Asignatura");
		GridBagConstraints gbc_lblAsignatura = new GridBagConstraints();
		gbc_lblAsignatura.anchor = GridBagConstraints.WEST;
		gbc_lblAsignatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsignatura.gridx = 1;
		gbc_lblAsignatura.gridy = 1;
		panel.add(lblAsignatura, gbc_lblAsignatura);
		
		inputAsignatura = new JTextField();
		GridBagConstraints gbc_inputAsignatura = new GridBagConstraints();
		gbc_inputAsignatura.fill = GridBagConstraints.BOTH;
		gbc_inputAsignatura.insets = new Insets(0, 0, 5, 5);
		gbc_inputAsignatura.gridx = 1;
		gbc_inputAsignatura.gridy = 2;
		panel.add(inputAsignatura, gbc_inputAsignatura);
		inputAsignatura.setColumns(10);
		
		JLabel lblAbreviatura = new JLabel("Abreviatura");
		GridBagConstraints gbc_lblAbreviatura = new GridBagConstraints();
		gbc_lblAbreviatura.anchor = GridBagConstraints.WEST;
		gbc_lblAbreviatura.insets = new Insets(0, 0, 5, 0);
		gbc_lblAbreviatura.gridx = 3;
		gbc_lblAbreviatura.gridy = 1;
		panel.add(lblAbreviatura, gbc_lblAbreviatura);
		
		inputAbreviatura = new JTextField();
		GridBagConstraints gbc_inputAbreviatura = new GridBagConstraints();
		gbc_inputAbreviatura.insets = new Insets(0, 0, 5, 0);
		gbc_inputAbreviatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputAbreviatura.gridx = 3;
		gbc_inputAbreviatura.gridy = 2;
		panel.add(inputAbreviatura, gbc_inputAbreviatura);
		inputAbreviatura.setColumns(20);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setPreferredSize(new Dimension(90, 25));
		panel_2.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(90, 25));
		panel_2.add(btnCancelar);

	}
	
	private void eventos() {
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre = inputAsignatura.getText();
				String abrev = inputAbreviatura.getText();
				if(nombre.equals("") || abrev.equals("")) {
					LibroView.mensaje = "Rellena todos los campos";
					LibroView.tipoMensaje = FeedBackConstants.INFO;
					LibroView.btnInvisible.doClick();
				}else {
					asignaturaController.add(new String[] {nombre, abrev});
					LibroView.mensaje = "Asignatura insertada correctamente";
					LibroView.tipoMensaje = FeedBackConstants.CORRECTO;
					LibroView.btnInvisible.doClick();
					dispose();
				}
				LibroView.btnCargarAsignaturas.doClick();

				
			}
		});
		

	}
	
	
	

}
