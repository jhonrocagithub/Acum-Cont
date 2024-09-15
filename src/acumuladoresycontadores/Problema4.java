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
	int cantVehi0, cantVehi1, cantVehi2, cantVehi3, cantVehi4;
	int cantPsj0, cantPsj1, cantPsj2, cantPsj3, cantPsj4;

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
		lblNewLabel_1.setBounds(10, 36, 143, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(163, 33, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"autom\u00F3vil", "cami\u00F3n", "caminoneta", "omnib\u00FAs", "otros"}));
		cmbTipo.setBounds(163, 7, 86, 22);
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
		
		//Proceso de calculo
		efectuarIncrementos(tipo, cantidad);
		mostrarResultados();
		
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
		return Integer.parseInt(txtCantidad.getText());
	}
	void efectuarIncrementos(int tipo, int cantidad) {
		switch(tipo) {
			case 0:
				cantVehi0++;
				cantPsj0 += cantidad;
				break;
			case 1:
				cantVehi1++;
				cantPsj1 += cantidad;
				break;
			case 2:
				cantVehi2++;
				cantPsj2 += cantidad;
				break;
			case 3:
				cantVehi3++;
				cantPsj3 += cantidad;
				break;
			default:
				cantVehi4++;
				cantPsj4 += cantidad;
				break;
		}
	}
	void mostrarResultados() {
		txtAreaResultado.setText("\n"); 
		txtAreaResultado.append("Cantidad total de vehículos" + "\n"); 
		txtAreaResultado.append("- Automóviles  : " + cantVehi0 + "\n"); 
		txtAreaResultado.append("- Camiones     : " + cantVehi1 + "\n"); 
		txtAreaResultado.append("- Camionetas   : " + cantVehi2 + "\n"); 
		txtAreaResultado.append("- Omnibuses    : " + cantVehi3 + "\n"); 
		txtAreaResultado.append("- Otros        : " + cantVehi4 + "\n"); 
		txtAreaResultado.append("\n"); 
		txtAreaResultado.append("Cantidad total de pasajeros" + "\n"); 
		txtAreaResultado.append("- Automóviles  : " + cantPsj0 + "\n"); 
		txtAreaResultado.append("- Camiones     : " + cantPsj1 + "\n"); 
		txtAreaResultado.append("- Camionetas   : " + cantPsj2 + "\n"); 
		txtAreaResultado.append("- Omnibuses    : " + cantPsj3 + "\n"); 
		txtAreaResultado.append("- Otros        : " + cantPsj4 + "\n");
	}
	
}
