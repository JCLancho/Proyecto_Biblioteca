package Vista;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

import Controller.AlumnoController;
import Controller.HistoricoController;
import Controller.PrestamoController;
import model.Alumno;
import model.Prestamo;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.JComboBox;

public class DevolucionView extends JPanel {

	private JTextField inputDni;
	private JTable table;
	private JPanel panel_1, panel_2, panel_3, panel_4, panel_5, panel_6;
	private JButton btnBuscar, btnRenovar, btnDevolver, btnLimpiar;
	private DefaultTableModel modelo;
	private JComboBox<Alumno> comboDni;
	private DefaultComboBoxModel<Alumno> modeloAlumno;
	
	private PrestamoController prestamoController;
	private AlumnoController alumnoController;

	public DevolucionView() {
		prestamoController = new PrestamoController();
		alumnoController = new AlumnoController();
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
		gbl_panel.columnWidths = new int[] {180};
		gbl_panel.rowHeights = new int[] {20, 5};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 0);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 0;
		panel.add(lblDni, gbc_lblDni);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		inputDni = new JTextField();
		panel_5.add(inputDni);
		inputDni.setToolTipText("12345678A");
		inputDni.setColumns(10);
		
		panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_6);
		
		comboDni = new JComboBox<Alumno>();
		panel_6.add(comboDni);
		
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
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3);
		
		btnRenovar = new JButton("Renovar");
		btnRenovar.setPreferredSize(new Dimension(90, 25));
		btnRenovar.setEnabled(false);
		panel_3.add(btnRenovar);
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.setPreferredSize(new Dimension(90, 25));
		btnDevolver.setEnabled(false);
		panel_3.add(btnDevolver);
		
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
				"Libro", "Fecha Prestamo", "Fecha Devolucion"
			});

		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		llenarComboAlumno();

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
					renovar();
				}
				
			}
		});
		
		
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent e) {
		    	
		    	if(listSelectionModel.isSelectionEmpty()) {
		    		btnRenovar.setEnabled(false);
					btnDevolver.setEnabled(false);
		        } else {
		        	btnRenovar.setEnabled(true);
					btnDevolver.setEnabled(true);		            
		        }
		    }
		});
		
		btnDevolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				devolver();
				filtrar();
				
			}
		});
		
		btnRenovar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				renovar();
			}
		});
		
		comboDni.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				
				filtrarComboAlumno();
				
			}
		});
		
		inputDni.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {

				filtrarComboAlumno();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {

				filtrarComboAlumno();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

				filtrarComboAlumno();
				
			}
		});
	}
	
	public void filtrar() {
		Alumno alumno = (Alumno) comboDni.getSelectedItem();
		if(alumno != null) {
			modelo.setRowCount(0);
			Prestamo filtro = new Prestamo();
			filtro.setAlumno(alumno);
			List<Prestamo> lista = prestamoController.findAll(filtro);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			for(Prestamo prestamo : lista) {
				modelo.addRow(new Object[] {
						prestamo, formato.format(prestamo.getFechaPrestamo()), formato.format(prestamo.getFechaDevolucion()), prestamo.getEstado()
				});
			}
		}else {
			JOptionPane.showMessageDialog(getParent(), "Selecciona un alumno");
		}
	}

	private void renovar() {
		int r = table.getSelectedRow();
		Prestamo prestamoSeleccionado = (Prestamo) modelo.getValueAt(r, 0);
		String[] keys = {prestamoSeleccionado.getAlumno().getDni(), prestamoSeleccionado.getLibro().getIsbn(), prestamoSeleccionado.getFechaPrestamo().toString()};
		prestamoController.update(new String[] {}, keys);
		filtrar();
		table.setRowSelectionInterval(r, r);
			
	}
	
	private void devolver() {
		int r = table.getSelectedRow();
		Prestamo prestamo = (Prestamo) modelo.getValueAt(r, 0);
		new DevolverDetalle(getParent(), prestamo);
		filtrar();		
		
	}
	
	public void limpiar() {
		inputDni.setText("");
		comboDni.setSelectedIndex(-1);
		modelo.setRowCount(0);
		
	}
	
	private void llenarComboAlumno() {
		Alumno filtro = new Alumno();
		Alumno[] alumnos = alumnoController.findAll(filtro).toArray(new Alumno[0]);
		modeloAlumno = new DefaultComboBoxModel<Alumno>(alumnos);
		comboDni.setModel(modeloAlumno);
		comboDni.setSelectedIndex(-1);
	}
	
	private void filtrarComboAlumno() {
		Alumno filtro = new Alumno();
		filtro.setDni(inputDni.getText());
		Alumno[] alumnos = alumnoController.findAll(filtro).toArray(new Alumno[0]);
		modeloAlumno = new DefaultComboBoxModel<Alumno>(alumnos);
		comboDni.setModel(modeloAlumno);
		comboDni.showPopup();
		comboDni.setSelectedIndex(-1);
	}
}
