package Vista;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Insets;

import Controller.AlumnoController;
import Controller.LibroController;
import Controller.PrestamoController;
import model.Alumno;
import model.Libro;
import model.Prestamo;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PrestamoView extends JPanel {

	private JTextField inputDni, inputIsbn;
	private JLabel lblResultado, lblMotivo;
	private JPanel panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7, panel_8, panel_9, panel_10, panel_11;
	private JButton btnComprobar, btnPrestar;
	private JComboBox<Alumno> comboDni;
	private JComboBox<Libro> comboIsbn;
	private DefaultComboBoxModel<Alumno> modeloAlumno;
	private DefaultComboBoxModel<Libro> modeloLibro;
	
	private AlumnoController alumnoController;
	private LibroController libroController;
	private PrestamoController prestamoController;


	public PrestamoView() {
		alumnoController = new AlumnoController();
		libroController = new LibroController();
		prestamoController = new PrestamoController();
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
		gbl_panel.columnWidths = new int[] {180, 180, 120};
		gbl_panel.rowHeights = new int[] {20, 5, 50};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 0;
		panel.add(lblDni, gbc_lblDni);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		
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
		
		JLabel lblIsbn = new JLabel("ISBN");
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.anchor = GridBagConstraints.WEST;
		gbc_lblIsbn.insets = new Insets(0, 0, 5, 0);
		gbc_lblIsbn.gridx = 1;
		gbc_lblIsbn.gridy = 0;
		panel.add(lblIsbn, gbc_lblIsbn);
		
		panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 1;
		panel.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		inputIsbn = new JTextField();
		inputIsbn.setToolTipText("13 digitos");
		panel_7.add(inputIsbn);
		inputIsbn.setColumns(30);
		
		panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		comboIsbn = new JComboBox<Libro>();
		panel_8.add(comboIsbn);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setEnabled(false);
		panel_2.add(btnComprobar);
		
		panel_10 = new JPanel();
		add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_10.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblResultado);
		
		panel_9 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_9.setBorder(new TitledBorder(null, "Motivos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_9);
		
		lblMotivo = new JLabel("");
		panel_9.add(lblMotivo);
		
		panel_11 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_11.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_10.add(panel_11, BorderLayout.SOUTH);
		
		btnPrestar = new JButton("Prestar");
		btnPrestar.setEnabled(false);
		panel_11.add(btnPrestar);
		
		llenarComboAlumno();
		llenarComboLibro();
	}
	
	private void eventos() {
		
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
		
		inputIsbn.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {

				filtrarComboLibro();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {

				filtrarComboLibro();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

				filtrarComboLibro();
				
			}
		});
		
		
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Alumno alumno = (Alumno) comboDni.getSelectedItem();
				Libro libro = (Libro) comboIsbn.getSelectedItem();
				if(alumno != null && libro != null) {
					Prestamo filtro = new Prestamo();
					filtro.setLibro(libro);
					List<Prestamo> librosPrestados = prestamoController.findAll(filtro);
					if(librosPrestados.size() > 0) {
						lblResultado.setText("ERROR");
						lblMotivo.setText("El libro seleccionado ya está prestado");
						btnPrestar.setEnabled(false);
					}else {
						btnPrestar.setEnabled(true);
						lblResultado.setText("CORRECTO");
						lblMotivo.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(getParent(), "Selecciona un alumno y un libro");
				}
				
			}
		});
		
		btnPrestar.addActionListener(new ActionListener( ) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Alumno alumno = (Alumno) comboDni.getSelectedItem();
				Libro libro = (Libro) comboIsbn.getSelectedItem();
				String[] valores = {alumno.getDni(), libro.getIsbn(), libro.getEstado().getCodigo()};
				prestamoController.add(valores);
				Date sqlDate = new Date(new java.util.Date().getTime());
				sqlDate.toString();
				Prestamo prestamo = prestamoController.find(new String[] {alumno.getDni(), libro.getIsbn(), sqlDate.toString()});
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				String info = "<html><ul>Prestamo realizado:</ul>"
						+ "<li> Alumno: " + prestamo.getAlumno().getNombreCompleto() + "</li>"
						+ "<li> Libro: " + prestamo.getLibro().getTitulo() + "</li>"
						+ "<li> Fecha devolucion: " + formato.format(prestamo.getFechaDevolucion()) + "</li></html>";
				lblResultado.setText(info);
				lblMotivo.setText("");
			}
		});
	
		comboDni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Alumno alumno = (Alumno) comboDni.getSelectedItem();
				Libro libro = (Libro) comboIsbn.getSelectedItem();
				if(alumno != null && libro != null)
					btnComprobar.setEnabled(true);
				else
					btnComprobar.setEnabled(false);
				
			}
		});
		
		comboIsbn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Alumno alumno = (Alumno) comboDni.getSelectedItem();
				Libro libro = (Libro) comboIsbn.getSelectedItem();
				if(alumno != null && libro != null)
					btnComprobar.setEnabled(true);
				else
					btnComprobar.setEnabled(false);
				
			}
		});
		
		comboDni.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				
				filtrarComboAlumno();
				btnPrestar.setEnabled(false);
				lblMotivo.setText("");
				lblResultado.setText("");
				
			}
		});
		
		comboIsbn.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				Alumno alumno = (Alumno) comboDni.getSelectedItem();
				Libro libro = (Libro) comboIsbn.getSelectedItem();
				if(alumno != null && libro != null)
					btnComprobar.setEnabled(true);
				else
					btnComprobar.setEnabled(false);
				filtrarComboLibro();
				btnPrestar.setEnabled(false);
				lblMotivo.setText("");
				lblResultado.setText("");
				
			}
		});
		

	}
	

	
	public void limpiar() {
		inputDni.setText("");
		inputIsbn.setText("");
		comboDni.setSelectedIndex(-1);
		comboIsbn.setSelectedIndex(-1);
		
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
		btnPrestar.setEnabled(false);
		lblMotivo.setText("");
		lblResultado.setText("");
	}
	
	private void llenarComboLibro() {
		Libro filtro = new Libro();
		Libro[] libros = libroController.findAll(filtro).toArray(new Libro[0]);
		modeloLibro = new DefaultComboBoxModel<Libro>(libros);
		comboIsbn.setModel(modeloLibro);
		comboIsbn.setSelectedIndex(-1);
	}
	
	private void filtrarComboLibro() {
		Libro filtro = new Libro();
		filtro.setIsbn(inputIsbn.getText());
		Libro[] libros = libroController.findAll(filtro).toArray(new Libro[0]);
		modeloLibro = new DefaultComboBoxModel<Libro>(libros);
		comboIsbn.setModel(modeloLibro);
		comboIsbn.showPopup();
		comboIsbn.setSelectedIndex(-1);
		btnPrestar.setEnabled(false);
		lblMotivo.setText("");
		lblResultado.setText("");
	}
}
