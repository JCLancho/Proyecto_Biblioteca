package Vista;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.feedback.FeedBack;
import com.feedback.FeedBackConstants;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.util.List;

import Controller.AlumnoController;
import model.Alumno;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;

public class AlumnoView extends JPanel {

	private JTextField inputDni, inputNombre, inputApellido1, inputApellido2;
	private JTable table;
	private JPanel panel_1, panel_2, panel_3, panel_4;
	private JButton btnAnadir, btnBuscar, btnEditar, btnBorrar, btnLimpiar;
	private DefaultTableModel modelo;
	
	private AlumnoController alumnoController;

	public static JButton btnInvisible;
	public static int tipoMensaje;
	public static String mensaje;


	public AlumnoView() {
		alumnoController = new AlumnoController();
		tipoMensaje = -1;
		mensaje = "";
		dibujar();
		eventos();
		setVisible(true);
	}
	
	private void dibujar() {
		this.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1 = new JPanel();
		this.add(panel_1);
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
		inputDni.setToolTipText("12345678A");
		GridBagConstraints gbc_inputDni = new GridBagConstraints();
		gbc_inputDni.anchor = GridBagConstraints.WEST;
		gbc_inputDni.fill = GridBagConstraints.VERTICAL;
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
		inputNombre.setColumns(30);
		
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
		inputApellido1.setColumns(30);
		
		inputApellido2 = new JTextField();
		GridBagConstraints gbc_inputApellido2 = new GridBagConstraints();
		gbc_inputApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_inputApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputApellido2.gridx = 3;
		gbc_inputApellido2.gridy = 4;
		panel.add(inputApellido2, gbc_inputApellido2);
		inputApellido2.setColumns(30);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setPreferredSize(new Dimension(85, 25));
		panel_4.add(btnBuscar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setPreferredSize(new Dimension(85, 25));
		panel_4.add(btnLimpiar);
		
		btnInvisible = new JButton();
		btnInvisible.setVisible(false);
		panel_4.add(btnInvisible);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3);
		
		btnAnadir = new JButton("Añadir");
		btnAnadir.setPreferredSize(new Dimension(85, 25));
		panel_3.add(btnAnadir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setPreferredSize(new Dimension(85, 25));
		btnEditar.setEnabled(false);
		panel_3.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setPreferredSize(new Dimension(85, 25));
		btnBorrar.setEnabled(false);
		panel_3.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		this.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		modelo.setColumnIdentifiers(new String[] {
				"DNI", "Nombre", "Apellido 1", "Apellido 2"
			});

		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}
	
	private void eventos() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrar();
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limpiar();
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(arg0.getClickCount() == 2) {
					editar();
				}
				
			}
		});
		
		
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent e) {
		    	
		    	if(listSelectionModel.isSelectionEmpty()) {
		    		btnEditar.setEnabled(false);
					btnBorrar.setEnabled(false);
		        } else {
		        	btnEditar.setEnabled(true);
					btnBorrar.setEnabled(true);		            
		        }
		    }
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String dni = modelo.getValueAt(table.getSelectedRow(), 0).toString();
				try {
					alumnoController.delete(dni);
				} catch (MySQLIntegrityConstraintViolationException e) {
					JOptionPane.showMessageDialog(getParent(), "No se puede borrar un alumno con libros prestados");
				}
				filtrar();
				
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				editar();
				filtrar();
			}
		});
		
		btnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new AlumnoDetalle(getParent());
				filtrar();
				
			}
		});
		
		btnInvisible.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				mostrar(tipoMensaje, mensaje);
				
			}
		});
	}
	
	private void filtrar() {
		modelo.setRowCount(0);
		Alumno filtro = new Alumno();
		filtro.setDni(inputDni.getText());
		filtro.setNombre(inputNombre.getText());
		filtro.setApellido1(inputApellido1.getText());
		filtro.setApellido2(inputApellido2.getText());
		List<Alumno> lista = alumnoController.findAll(filtro);
		for(Alumno alumno : lista) {
			modelo.addRow(new Object[] {
					alumno.getDni(), alumno.getNombre(), alumno.getApellido1(), alumno.getApellido2()
			});
		}
	}

	private void editar() {
		int r = table.getSelectedRow();
		String dni = modelo.getValueAt(r, 0).toString();
		String nombre = modelo.getValueAt(r, 1).toString();
		String apellido1 = modelo.getValueAt(r, 2).toString();
		String apellido2 = modelo.getValueAt(r, 3).toString();
		new AlumnoDetalle(getParent(), dni, nombre, apellido1, apellido2);
			
	}
	
	public void limpiar() {
		inputDni.setText("");
		inputNombre.setText("");
		inputApellido1.setText("");
		inputApellido2.setText("");
		modelo.setRowCount(0);
		
	}
	
	private void mostrar(int tipo, String mensaje) {
		FeedBack fb = new FeedBack(Main.panelFeedback, tipo, mensaje);
		revalidate();
		fb.execute();
	}
}
