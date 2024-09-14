package acumuladoresycontadores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema4 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCantidad;
	private JComboBox cmbTipo;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtAreaResultado;
	
	//variables globales
	int tipo0, tipo1, tipo2, tipo3;
	int cant0, cant1, cant2, cant3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema4 frame = new Problema4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Problema4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de veh\u00EDculo");
		lblNewLabel.setBounds(10, 11, 96, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad de pasajeros");
		lblNewLabel_1.setBounds(10, 36, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(127, 33, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"autom\u00F3vil", "cami\u00F3n", "caminoneta", "omnib\u00FAs", "otros"}));
		cmbTipo.setBounds(127, 7, 86, 22);
		contentPane.add(cmbTipo);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 189);
		contentPane.add(scpScroll);
		
		txtAreaResultado = new JTextArea();
		scpScroll.setViewportView(txtAreaResultado);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnProcesar)
			actionPerformedBtnProcesar(e);
		if(e.getSource() == btnBorrar)
			actionPerformedBtnBorrar(e);
	}
	public void actionPerformedBtnProcesar(ActionEvent e) {
		//declaracion de variables
		int tipo, cantidad;
		
		//entrada de datos
		tipo = getTipo();
		cantidad = getCantidad();
		
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		txtAreaResultado.setText("");
		txtCantidad.requestFocus();
	}
	int getTipo() {
		return cmbTipo.getSelectedIndex();
	}
	int getCantidad() {
		return txtCantidad.getText();
	}
	
}
