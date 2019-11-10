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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.feedback.FeedBackConstants;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Controller.EstadoController;
import Controller.HistoricoController;
import Controller.PrestamoController;
import model.Estado;
import model.Prestamo;

import javax.swing.JComboBox;

public class DevolverDetalle extends JDialog {

	private JPanel contentPane, panel_1, panel_2, panel_3, panel_4;
	private JTextField inputEstadoInical;
	private JButton btnDevolver, btnCancelar;
	private JComboBox<Estado> comboEstado;
	private DefaultComboBoxModel<Estado> modeloEstados;

	private EstadoController estadoController;
	private PrestamoController prestamoController;
	private HistoricoController historicoController;
	
	
	private Prestamo prestamo;
	
	public DevolverDetalle(Container c, Prestamo prestamo) {
		estadoController = new EstadoController();
		prestamoController = new PrestamoController();
		historicoController = new HistoricoController();
		this.prestamo = prestamo;
		dibujar();
		eventos();
		setTitle("Editar estado del libro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(450, 270);
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
		gbl_panel.columnWidths = new int[] {180, 180};
		gbl_panel.rowHeights = new int[] {20, 5};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblEstadoInicial = new JLabel("Estado inical");
		GridBagConstraints gbc_lblEstadoInicial = new GridBagConstraints();
		gbc_lblEstadoInicial.anchor = GridBagConstraints.WEST;
		gbc_lblEstadoInicial.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoInicial.gridx = 0;
		gbc_lblEstadoInicial.gridy = 0;
		panel.add(lblEstadoInicial, gbc_lblEstadoInicial);
		
		inputEstadoInical = new JTextField();
		inputEstadoInical.setText(prestamo.getEstado().toString());
		inputEstadoInical.setEditable(false);
		inputEstadoInical.setFocusable(false);
		GridBagConstraints gbc_inputEstadoInical = new GridBagConstraints();
		gbc_inputEstadoInical.fill = GridBagConstraints.BOTH;
		gbc_inputEstadoInical.insets = new Insets(0, 0, 0, 5);
		gbc_inputEstadoInical.gridx = 0;
		gbc_inputEstadoInical.gridy = 1;
		panel.add(inputEstadoInical, gbc_inputEstadoInical);
		inputEstadoInical.setColumns(10);
		
		JLabel lblEstadoFinal = new JLabel("Nuevo estado");
		GridBagConstraints gbc_lblEstadoFinal = new GridBagConstraints();
		gbc_lblEstadoFinal.anchor = GridBagConstraints.WEST;
		gbc_lblEstadoFinal.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstadoFinal.gridx = 1;
		gbc_lblEstadoFinal.gridy = 0;
		panel.add(lblEstadoFinal, gbc_lblEstadoFinal);
		
		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		comboEstado = new JComboBox<Estado>();
		panel_4.add(comboEstado);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3);
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.setPreferredSize(new Dimension(90, 25));
		panel_3.add(btnDevolver);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(90, 25));
		panel_3.add(btnCancelar);
		
		llenarComboEstado();
		
	}
	
	private void eventos() {
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		
		btnDevolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Estado estadoNuevo = (Estado) comboEstado.getSelectedItem();
				if(estadoNuevo != null) {
					String[] keys = {prestamo.getAlumno().getDni(), prestamo.getLibro().getIsbn(), prestamo.getFechaPrestamo().toString()};
					String[] valores = {prestamo.getAlumno().getDni(),
							prestamo.getLibro().getIsbn(),
							prestamo.getFechaPrestamo().toString(),
							prestamo.getFechaDevolucion().toString(),
							prestamo.getEstado().getCodigo(),
							estadoNuevo.getCodigo()
							};
					try {
						prestamoController.delete(keys);
						historicoController.add(valores);
						DevolucionView.mensaje = "Libro devuelto";
						DevolucionView.tipoMensaje = FeedBackConstants.CORRECTO;
						DevolucionView.btnInvisible.doClick();
						dispose();
					} catch (MySQLIntegrityConstraintViolationException e) {
						DevolucionView.mensaje = "No se puede borrar ese prestamo";
						DevolucionView.tipoMensaje = FeedBackConstants.ERROR;
						DevolucionView.btnInvisible.doClick();
					}
				}else {
					DevolucionView.mensaje = "Selecciona un estado";
					DevolucionView.tipoMensaje = FeedBackConstants.INFO;
					DevolucionView.btnInvisible.doClick();
				}
				
			}
		});
	
	}
	
	
	
	private void llenarComboEstado() {
		Estado[] estados = estadoController.findAll(new Estado()).toArray(new Estado[0]);
		modeloEstados = new DefaultComboBoxModel<Estado>(estados);
		comboEstado.setModel(modeloEstados);
		comboEstado.setSelectedIndex(-1);
	}
	

}
