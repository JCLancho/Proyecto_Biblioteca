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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.feedback.FeedBackConstants;

import Controller.AlumnoController;

/**
 * Clase alumno detalle
 * encargada de a�adir y editar alumnos
 * @author Lancho
 *
 */
public class AlumnoDetalle extends JDialog {

	private JPanel contentPane, panel_1, panel_2, panel_3;
	private JTextField inputDni, inputNombre, inputApellido1, inputApellido2;
	private JButton btnGuardar, btnCancelar;

	private AlumnoController alumnoController;

	
	/**
	 * constructor para a�adir
	 * parametro el contenedor del padre, para referenciar la posicion de los objetos
	 * @param c
	 */
	public AlumnoDetalle(Container c) {
		alumnoController = new AlumnoController();
		dibujar();
		eventos();
		setTitle("A�adir Alumno");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(450, 300);
		setModal(true);
		setLocationRelativeTo(c);
		setVisible(true);
		
	}
	
	/**
	 * constructor para editar
	 * hay que pasarle todos los campos que se rellenan automaticamente
	 * @param c
	 * @param dni
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 */
	public AlumnoDetalle(Container c, String dni, String nombre, String apellido1, String apellido2) {
		alumnoController = new AlumnoController();
		dibujar();
		eventos();
		rellenarCampos(dni, nombre, apellido1, apellido2);
		setTitle("Editar Alumno");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(450, 300);
		setModal(true);
		setLocationRelativeTo(c);
		setVisible(true);
				
	}
	
	/**
	 * metodo dibujar, pinta la venta
	 */
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
		gbl_panel.columnWidths = new int[] {30, 180, 30, 180};
		gbl_panel.rowHeights = new int[] {5, 20, 5, 20, 5, 20, 5, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 1;
		panel.add(lblDni, gbc_lblDni);
		
		inputDni = new JTextField();
		GridBagConstraints gbc_inputDni = new GridBagConstraints();
		gbc_inputDni.fill = GridBagConstraints.BOTH;
		gbc_inputDni.insets = new Insets(0, 0, 5, 5);
		gbc_inputDni.gridx = 1;
		gbc_inputDni.gridy = 2;
		panel.add(inputDni, gbc_inputDni);
		inputDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		inputNombre = new JTextField();
		GridBagConstraints gbc_inputNombre = new GridBagConstraints();
		gbc_inputNombre.insets = new Insets(0, 0, 5, 0);
		gbc_inputNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputNombre.gridx = 3;
		gbc_inputNombre.gridy = 2;
		panel.add(inputNombre, gbc_inputNombre);
		inputNombre.setColumns(20);
		
		JLabel lblApellido1 = new JLabel("Apellido 1");
		GridBagConstraints gbc_lblApellido1 = new GridBagConstraints();
		gbc_lblApellido1.anchor = GridBagConstraints.WEST;
		gbc_lblApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido1.gridx = 1;
		gbc_lblApellido1.gridy = 3;
		panel.add(lblApellido1, gbc_lblApellido1);
		
		JLabel lblApellido2 = new JLabel("Apellido 2");
		GridBagConstraints gbc_lblApellido2 = new GridBagConstraints();
		gbc_lblApellido2.anchor = GridBagConstraints.WEST;
		gbc_lblApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_lblApellido2.gridx = 3;
		gbc_lblApellido2.gridy = 3;
		panel.add(lblApellido2, gbc_lblApellido2);
		
		inputApellido1 = new JTextField();
		GridBagConstraints gbc_inputApellido1 = new GridBagConstraints();
		gbc_inputApellido1.fill = GridBagConstraints.BOTH;
		gbc_inputApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_inputApellido1.gridx = 1;
		gbc_inputApellido1.gridy = 4;
		panel.add(inputApellido1, gbc_inputApellido1);
		inputApellido1.setColumns(10);
		
		inputApellido2 = new JTextField();
		GridBagConstraints gbc_inputApellido2 = new GridBagConstraints();
		gbc_inputApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_inputApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputApellido2.gridx = 3;
		gbc_inputApellido2.gridy = 4;
		panel.add(inputApellido2, gbc_inputApellido2);
		inputApellido2.setColumns(10);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setPreferredSize(new Dimension(90, 25));
		panel_3.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(90, 25));
		panel_3.add(btnCancelar);
	}
	
	/**
	 * metodo eventos, gestiona todo lo relacionado con eventos
	 */
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
				String dni = inputDni.getText();
				String nombre = inputNombre.getText();
				String apellido1 = inputApellido1.getText();
				String apellido2 = inputApellido2.getText();
				if(inputDni.isEditable()) {//añadiendo
					if(dni.equals("")) {
						AlumnoView.mensaje = "El DNI no puede estar vacio";
						AlumnoView.tipoMensaje = FeedBackConstants.INFO;
						AlumnoView.btnInvisible.doClick();
					}else {
						String[] valores = {dni, nombre, apellido1, apellido2};
//						para usar la estructura java
//						alumnoController.add(valores);
//						para usar el procedimiento almacenado
						alumnoController.procedureInsertar(valores);
						AlumnoView.mensaje = "Alumno insertado correctamente";
						AlumnoView.tipoMensaje = FeedBackConstants.CORRECTO;
						AlumnoView.btnInvisible.doClick();
						dispose();
					}
				}else {
					alumnoController.update(new String[] {nombre, apellido1, apellido2}, dni);
					AlumnoView.mensaje = "Alumno actualizado correctamente";
					AlumnoView.tipoMensaje = FeedBackConstants.CORRECTO;
					AlumnoView.btnInvisible.doClick();
					dispose();
				}
				
			}
		});
	
	}
	
	/**
	 * coloca toda la informacion en su sitio, informacion obtenida del constructor
	 * @param dni
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 */
	private void rellenarCampos(String dni, String nombre, String apellido1, String apellido2) {
		inputDni.setText(dni);
		inputDni.setEditable(false);
		inputDni.setFocusable(false);
		inputNombre.setText(nombre);
		inputApellido1.setText(apellido1);
		inputApellido2.setText(apellido2);
	}
	
	

}
