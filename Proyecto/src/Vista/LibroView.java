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

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.util.List;

import Controller.AsignaturaController;
import Controller.EstadoController;
import Controller.LibroController;
import model.Asignatura;
import model.Estado;
import model.Libro;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Component;

public class LibroView extends JPanel {

	private JTextField inputIsbn, inputTitulo, inputAutor, inputEditorial;
	private JTable table;
	private JPanel panel_1, panel_2, panel_3, panel_4, panel_5;
	private JButton btnAnadir, btnBuscar, btnEditar, btnBorrar, btnLimpiar, btnAgregarAsignatura;
	private DefaultTableModel modelo;
	private JLabel lblAsignatura, lblEstado;
	private JComboBox<Estado> comboEstado;
	private JComboBox<Asignatura> comboAsignatura;
	private DefaultComboBoxModel<Asignatura> modeloAsignaturas;
	private DefaultComboBoxModel<Estado> modeloEstados;
	
	private AsignaturaController asignaturaController;
	private EstadoController estadoController;
	private LibroController libroController;
	
	public static JButton btnFiltrar, btnCargarAsignaturas;


	/**
	 * Create the frame.
	 */
	public LibroView() {
		libroController = new LibroController();
		asignaturaController = new AsignaturaController();
		estadoController = new EstadoController();
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
		gbl_panel.columnWidths = new int[] {180, 180};
		gbl_panel.rowHeights = new int[] {20, 5, 20, 5, 20, 5};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblISBN = new JLabel("ISBN");
		GridBagConstraints gbc_lblISBN = new GridBagConstraints();
		gbc_lblISBN.anchor = GridBagConstraints.WEST;
		gbc_lblISBN.insets = new Insets(0, 0, 5, 5);
		gbc_lblISBN.gridx = 0;
		gbc_lblISBN.gridy = 0;
		panel.add(lblISBN, gbc_lblISBN);
		
		inputIsbn = new JTextField();
		inputIsbn.setToolTipText("13 digitos");
		GridBagConstraints gbc_inputISBN = new GridBagConstraints();
		gbc_inputISBN.anchor = GridBagConstraints.WEST;
		gbc_inputISBN.fill = GridBagConstraints.VERTICAL;
		gbc_inputISBN.insets = new Insets(0, 0, 5, 5);
		gbc_inputISBN.gridx = 0;
		gbc_inputISBN.gridy = 1;
		panel.add(inputIsbn, gbc_inputISBN);
		inputIsbn.setColumns(15);
		
		JLabel lblTitulo = new JLabel("Titulo");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.WEST;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		inputTitulo = new JTextField();
		GridBagConstraints gbc_inputTitulo = new GridBagConstraints();
		gbc_inputTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_inputTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTitulo.gridx = 1;
		gbc_inputTitulo.gridy = 1;
		panel.add(inputTitulo, gbc_inputTitulo);
		inputTitulo.setColumns(30);
		
		JLabel lblAutor = new JLabel("Autor");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.WEST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 2;
		panel.add(lblAutor, gbc_lblAutor);
		
		inputAutor = new JTextField();
		GridBagConstraints gbc_inputAutor = new GridBagConstraints();
		gbc_inputAutor.fill = GridBagConstraints.BOTH;
		gbc_inputAutor.insets = new Insets(0, 0, 5, 5);
		gbc_inputAutor.gridx = 0;
		gbc_inputAutor.gridy = 3;
		panel.add(inputAutor, gbc_inputAutor);
		inputAutor.setColumns(30);
		
		JLabel lblEditorial = new JLabel("Editorial");
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.anchor = GridBagConstraints.WEST;
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_lblEditorial.gridx = 1;
		gbc_lblEditorial.gridy = 2;
		panel.add(lblEditorial, gbc_lblEditorial);
				
		inputEditorial = new JTextField();
		GridBagConstraints gbc_inputEditorial = new GridBagConstraints();
		gbc_inputEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_inputEditorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputEditorial.gridx = 1;
		gbc_inputEditorial.gridy = 3;
		panel.add(inputEditorial, gbc_inputEditorial);
		inputEditorial.setColumns(30);
		
		lblAsignatura = new JLabel("Asignatura");
		GridBagConstraints gbc_lblAsignatura = new GridBagConstraints();
		gbc_lblAsignatura.anchor = GridBagConstraints.WEST;
		gbc_lblAsignatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsignatura.gridx = 0;
		gbc_lblAsignatura.gridy = 4;
		panel.add(lblAsignatura, gbc_lblAsignatura);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 5;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		comboAsignatura = new JComboBox<Asignatura>();
		panel_5.add(comboAsignatura);

		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 4;
		panel.add(lblEstado, gbc_lblEstado);
		
		comboEstado = new JComboBox<Estado>();
		GridBagConstraints gbc_comboEstado = new GridBagConstraints();
		gbc_comboEstado.anchor = GridBagConstraints.WEST;
		gbc_comboEstado.gridx = 1;
		gbc_comboEstado.gridy = 5;
		panel.add(comboEstado, gbc_comboEstado);
		
		btnAgregarAsignatura = new JButton("+");
		panel_5.add(btnAgregarAsignatura);
		
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
		
		btnFiltrar = new JButton();
		btnFiltrar.setVisible(false);
		panel_4.add(btnFiltrar);
		
		btnCargarAsignaturas = new JButton();
		btnCargarAsignaturas.setVisible(false);
		panel_4.add(btnCargarAsignaturas);

		
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
				"ISBN", "Título", "Autor", "Editorial", "Asignatura", "Estado"
			});

		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		llenarComboAsignatura();
		llenarComboEstado();
		
		
	}
	
	private void eventos() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrar();
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
					libroController.delete(dni);
				} catch (MySQLIntegrityConstraintViolationException e) {
					JOptionPane.showMessageDialog(getParent(), "No se puede borrar un libro prestado");
				}
				filtrar();
				
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				editar();
				
			}
		});
		
		btnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new LibroDetalle(getParent());
				
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limpiar();
			}
		});
		
		btnAgregarAsignatura.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new AsignaturaDetalle(getParent());
				
			}
		});
		
		btnFiltrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				filtrar();				
			}
		});
		
		btnCargarAsignaturas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				llenarComboAsignatura();
				
			}
		});
		
		
	}
	
	private void filtrar() {
		modelo.setRowCount(0);
		Libro filtro = new Libro();
		filtro.setIsbn(inputIsbn.getText());
		filtro.setTitulo(inputTitulo.getText());
		filtro.setAutor(inputAutor.getText());
		filtro.setEditorial(inputEditorial.getText());
		filtro.setAsignatura((Asignatura) comboAsignatura.getSelectedItem());
		filtro.setEstado((Estado) comboEstado.getSelectedItem());
		List<Libro> lista = libroController.findAll(filtro);
		for(Libro libro : lista) {
			modelo.addRow(new Object[] {
					libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getAsignatura().getAbreviatura(), libro.getEstado().getDescripcion()
			});
		}
	}

	private void editar() {
		int r = table.getSelectedRow();
		String isbn = modelo.getValueAt(r, 0).toString();
		String titulo = modelo.getValueAt(r, 1).toString();
		String autor = modelo.getValueAt(r, 2).toString();
		String editorial = modelo.getValueAt(r, 3).toString();
		String asignaturaAbreviatura = modelo.getValueAt(r, 4).toString();
		String estadoDescripcion = modelo.getValueAt(r, 5).toString();
		
		Asignatura asignatura = new Asignatura();
		asignatura.setAbreviatura(asignaturaAbreviatura);
		for(Asignatura a : asignaturaController.findAll(asignatura)) {
			if(asignaturaAbreviatura.equals(a.getAbreviatura())) {
				asignatura.setCodAsignatura(a.getCodAsignatura());
				asignatura.setNombreAsignatura(a.getNombreAsignatura());
				asignatura.setAbreviatura(a.getAbreviatura());
				break;
			}
		}
		Estado estado = new Estado();
		estado.setDescripcion(estadoDescripcion);
		for(Estado e : estadoController.findAll(estado)) {
			if(estadoDescripcion.equals(e.getDescripcion())) {
				estado.setCodigo(e.getCodigo());
				estado.setDescripcion(e.getDescripcion());
				break;
			}
		}
		new LibroDetalle(getParent(), isbn, titulo, autor, editorial, asignatura , estado);
			
	}
	
	public void limpiar() {
		inputIsbn.setText("");
		inputTitulo.setText("");
		inputAutor.setText("");
		inputEditorial.setText("");
		modelo.setRowCount(0);
		comboEstado.setSelectedIndex(-1);
		comboAsignatura.setSelectedIndex(-1);
		
	}
	
	private void llenarComboAsignatura() {
		Asignatura[] asignaturas = asignaturaController.findAll(new Asignatura()).toArray(new Asignatura[0]);
		modeloAsignaturas = new DefaultComboBoxModel<Asignatura>(asignaturas);
		comboAsignatura.setModel(modeloAsignaturas);
		comboAsignatura.setSelectedIndex(-1);
	}
	
	private void llenarComboEstado() {
		Estado[] estados = estadoController.findAll(new Estado()).toArray(new Estado[0]);
		modeloEstados = new DefaultComboBoxModel<Estado>(estados);
		comboEstado.setModel(modeloEstados);
		comboEstado.setSelectedIndex(-1);
	}
}
