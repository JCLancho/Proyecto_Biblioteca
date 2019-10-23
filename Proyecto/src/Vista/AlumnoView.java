package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import Controller.AlumnoController;
import model.Alumno;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlumnoView extends JFrame {

	private JPanel contentPane;
	private JTextField inputDni;
	private JTextField inputNombre;
	private JTextField inputApellido1;
	private JTextField inputApellido2;
	private JTable table;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAnadir;
	private JButton btnBuscar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JPanel panel_3;
	private AlumnoController alumnoController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoView frame = new AlumnoView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlumnoView() {
		alumnoController = new AlumnoController();
		setResizable(false);
		setTitle("Gestionar Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnBuscar);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3);
		
		btnAnadir = new JButton("Añadir");

		panel_3.add(btnAnadir);
		btnAnadir.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAnadir.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnEditar = new JButton("Editar");
		panel_3.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		panel_3.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setFillsViewportHeight(true);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] {
				"DNI", "Nombre", "Apellido 1", "Apellido 2"
			});
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				List<Alumno> lista = alumnoController.findAll();
				for(Alumno a : lista) {
					modelo.addRow(new Object[] {
							a.getDni(),a.getNombre(),a.getApellido1(),a.getApellido2()
					});
				}
			}
		});
		
	}
}
