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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.feedback.FeedBackConstants;

import Controller.LibroController;
import Controller.AsignaturaController;
import Controller.EstadoController;
import model.Asignatura;
import model.Estado;

public class LibroDetalle extends JDialog {

	private JPanel contentPane, panel_1, panel_2, panel_3;
	private JButton btnGuardar, btnCancelar;
	private JTextField inputTitulo, inputAutor, inputEditorial, inputISBN;
	private JComboBox<Asignatura> comboAsignatura;
	private JComboBox<Estado> comboEstado;
	private DefaultComboBoxModel<Asignatura> modeloAsignaturas;
	private DefaultComboBoxModel<Estado> modeloEstados;
	
	private LibroController libroController;
	private AsignaturaController asignaturaController;
	private EstadoController estadoController;


	private static String OPERACION;
	
	
	public LibroDetalle(Container c) {
		OPERACION = "add";
		inicializar(c);
		dibujar();
		eventos();
		setTitle("Añadir libro");
		setVisible(true);
	}
	
	public LibroDetalle(Container c, String isbn, String titulo, String autor, String editorial, Asignatura asignatura, Estado estado) {
		OPERACION = "edit";
		inicializar(c);
		dibujar();
		eventos();
		rellenarCampos(isbn, titulo, autor, editorial, asignatura, estado);
		setTitle("Editar libro");
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
		gbl_panel.columnWidths = new int[] {30, 180, 30, 180};
		gbl_panel.rowHeights = new int[] {5, 20, 5, 20, 5, 20, 5, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblISBN = new JLabel("ISBN");
		GridBagConstraints gbc_lblISBN = new GridBagConstraints();
		gbc_lblISBN.anchor = GridBagConstraints.WEST;
		gbc_lblISBN.insets = new Insets(0, 0, 5, 5);
		gbc_lblISBN.gridx = 1;
		gbc_lblISBN.gridy = 1;
		panel.add(lblISBN, gbc_lblISBN);
		
		inputISBN = new JTextField();
		GridBagConstraints gbc_inputISBN = new GridBagConstraints();
		gbc_inputISBN.fill = GridBagConstraints.BOTH;
		gbc_inputISBN.insets = new Insets(0, 0, 5, 5);
		gbc_inputISBN.gridx = 1;
		gbc_inputISBN.gridy = 2;
		panel.add(inputISBN, gbc_inputISBN);
		inputISBN.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.WEST;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 3;
		gbc_lblTitulo.gridy = 1;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		inputTitulo = new JTextField();
		GridBagConstraints gbc_inputTitulo = new GridBagConstraints();
		gbc_inputTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_inputTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTitulo.gridx = 3;
		gbc_inputTitulo.gridy = 2;
		panel.add(inputTitulo, gbc_inputTitulo);
		inputTitulo.setColumns(20);
		
		JLabel lblAutor = new JLabel("Autor");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.WEST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 1;
		gbc_lblAutor.gridy = 3;
		panel.add(lblAutor, gbc_lblAutor);
		
		inputAutor = new JTextField();
		GridBagConstraints gbc_inputAutor = new GridBagConstraints();
		gbc_inputAutor.fill = GridBagConstraints.BOTH;
		gbc_inputAutor.insets = new Insets(0, 0, 5, 5);
		gbc_inputAutor.gridx = 1;
		gbc_inputAutor.gridy = 4;
		panel.add(inputAutor, gbc_inputAutor);
		inputAutor.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial");
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.anchor = GridBagConstraints.WEST;
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_lblEditorial.gridx = 3;
		gbc_lblEditorial.gridy = 3;
		panel.add(lblEditorial, gbc_lblEditorial);
				
		inputEditorial = new JTextField();
		GridBagConstraints gbc_inputEditorial = new GridBagConstraints();
		gbc_inputEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_inputEditorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputEditorial.gridx = 3;
		gbc_inputEditorial.gridy = 4;
		panel.add(inputEditorial, gbc_inputEditorial);
		inputEditorial.setColumns(10);
		
		JLabel lblAsignatura = new JLabel("Asignatura");
		GridBagConstraints gbc_lblAsignatura = new GridBagConstraints();
		gbc_lblAsignatura.anchor = GridBagConstraints.WEST;
		gbc_lblAsignatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsignatura.gridx = 1;
		gbc_lblAsignatura.gridy = 5;
		panel.add(lblAsignatura, gbc_lblAsignatura);
		
		comboAsignatura = new JComboBox<Asignatura>();
		GridBagConstraints gbc_comboAsignatura = new GridBagConstraints();
		gbc_comboAsignatura.anchor = GridBagConstraints.WEST;
		gbc_comboAsignatura.insets = new Insets(0, 0, 5, 5);
		gbc_comboAsignatura.gridx = 1;
		gbc_comboAsignatura.gridy = 6;
		panel.add(comboAsignatura, gbc_comboAsignatura);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 3;
		gbc_lblEstado.gridy = 5;
		panel.add(lblEstado, gbc_lblEstado);
		
		comboEstado = new JComboBox<Estado>();
		GridBagConstraints gbc_comboEstado = new GridBagConstraints();
		gbc_comboEstado.anchor = GridBagConstraints.WEST;
		gbc_comboEstado.insets = new Insets(0, 0, 5, 5);
		gbc_comboEstado.gridx = 3;
		gbc_comboEstado.gridy = 6;
		panel.add(comboEstado, gbc_comboEstado);
		
		llenarComboAsignatura();
		llenarComboEstado();
		
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
				if(comboAsignatura.getSelectedIndex() != -1 && comboEstado.getSelectedIndex() != -1) {
					String isbn = inputISBN.getText();
					String titulo = inputTitulo.getText();
					String autor = inputAutor.getText();
					String editorial = inputEditorial.getText();
					Asignatura asignatura = (Asignatura) comboAsignatura.getSelectedItem();
					Estado estado = (Estado) comboEstado.getSelectedItem();
					if(OPERACION.equals("add")) {
						if(isbn.equals("")) {
							LibroView.mensaje = "El ISBN no puede estar vacio";
							LibroView.tipoMensaje = FeedBackConstants.INFO;
							LibroView.btnInvisible.doClick();
						}else {
							libroController.add(new String[] {isbn, titulo, autor, editorial, asignatura.getCodAsignatura()+"", estado.getCodigo()});
							LibroView.mensaje = "Libro insertado correctamente";
							LibroView.tipoMensaje = FeedBackConstants.CORRECTO;
							LibroView.btnInvisible.doClick();
							dispose();
						}
					}else {
						libroController.update(new String[] {titulo, autor, editorial, asignatura.getCodAsignatura()+"", estado.getCodigo()}, isbn);
						LibroView.mensaje = "Libro actualizado correctamente";
						LibroView.tipoMensaje = FeedBackConstants.CORRECTO;
						LibroView.btnInvisible.doClick();
						dispose();
					}
				}else {
					LibroView.mensaje = "Campos obligatorio: 'Estado', 'Asignatura'";
					LibroView.tipoMensaje = FeedBackConstants.INFO;
					LibroView.btnInvisible.doClick();
				}
				
			}
		});
	}
	
	
	private void rellenarCampos(String isbn, String titulo, String autor, String editorial, Asignatura asignatura, Estado estado) {

		inputISBN.setText(isbn);
		inputISBN.setEditable(false);
		inputTitulo.setText(titulo);
		inputAutor.setText(autor);
		inputEditorial.setText(editorial);

		comboAsignatura.setSelectedItem(asignatura);
		comboEstado.setSelectedItem(estado);
		
	}
	
	private void inicializar(Container c) {
		asignaturaController = new AsignaturaController();
		estadoController = new EstadoController();
		libroController = new LibroController();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(450, 300);
		setModal(true);
		setLocationRelativeTo(c);

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
