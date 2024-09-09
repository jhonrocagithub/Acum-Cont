package acumuladoresycontadores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtAreaResultado;
	private JComboBox cmbTipo;
	
	//Declaracion de variables globales para el algoritmo
	double imptot0, imptot1, imptot2, imptot3; 
	int canlic0, canlic1, canlic2, canlic3; 
	int canven0, canven1, canven2, canven3; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema1 frame = new Problema1();
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
	public Problema1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 36, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(95, 33, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(315, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(315, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 73, 414, 177);
		contentPane.add(scpScroll);
		
		txtAreaResultado = new JTextArea();
		scpScroll.setViewportView(txtAreaResultado);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Cobre", "Bronze", "Silver", "Gold"}));
		cmbTipo.setBounds(95, 7, 86, 22);
		contentPane.add(cmbTipo);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnProcesar)
			actionPerformedBtnProcesar(e);
		
		if(e.getSource() == btnBorrar)
			actionPerformedBtnBorrar(e);
	}
	public void actionPerformedBtnProcesar(ActionEvent e) {
		//declarar variables locales
		int tipo, cantidad;
		double impPag, impPagTot;
		
		//Entrada de datos
		tipo = getTipo();
		cantidad = getCantidad();
		
		//Proceso de calculo
		impPag = calcularImportePagar(tipo, cantidad);
		efectuarIncrementos(tipo,cantidad, impPag);
		
		//mostrar resultados
		mostrarResultados(impPag);
		
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
	double calcularImportePagar(int tipo, int cantidad) {
		switch(tipo) {
			case 0:
				return 510 * cantidad;
			case 1:
				return 1500 * cantidad;
			case 2:
				return 3100 * cantidad;
			default:
				return 4500 * cantidad;
		}
	}
	void efectuarIncrementos(int tipo, int cantidad, double impPag) {
		switch(tipo) {
			case 0:
				imptot0 += impPag;
				canlic0 += cantidad;
				canven0++;
				break;
			case 1:
				imptot1 += impPag;
				canlic1 += cantidad;
				canven1++;
				break;
			case 2:
				imptot2 += impPag;
				canlic2 += cantidad;
				canven2++;
				break;
			default:
				imptot3 += impPag;
				canlic3 += cantidad;
				canven3++;
				break;
		}
	}
	void mostrarResultados(double impPag) {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Importe a pagar...........: " + impPag + "\n");
		txtAreaResultado.append("\n");
		txtAreaResultado.append("Importe total recaudado" + "\n");
		txtAreaResultado.append("- Por licencias Cobre....: " + imptot0 + "\n"); 
		txtAreaResultado.append("- Por licencias Bronze...: " + imptot1 + "\n"); 
		txtAreaResultado.append("- Por licencias Silver...: " + imptot2 + "\n"); 
		txtAreaResultado.append("- Por licencias Gold.....: " + imptot3 + "\n");
		txtAreaResultado.append("\n");
		txtAreaResultado.append("Cantidad de licencias vendidas" + "\n"); 
		txtAreaResultado.append("- Por licencias Cobre....: " + canlic0 + "\n"); 
		txtAreaResultado.append("- Por licencias Bronze...: " + canlic1 + "\n"); 
		txtAreaResultado.append("- Por licencias Silver...: " + canlic2 + "\n"); 
		txtAreaResultado.append("- Por licencias Gold.....: " + canlic3 + "\n"); 
		txtAreaResultado.append("\n"); 
		txtAreaResultado.append("Cantidad de  ventas efectuadas" + "\n"); 
		txtAreaResultado.append("- Por licencias Cobre....: " + canven0 + "\n"); 
		txtAreaResultado.append("- Por licencias Bronze...: " + canven1 + "\n"); 
		txtAreaResultado.append("- Por licencias Silver...: " + canven2 + "\n"); 
		txtAreaResultado.append("- Por licencias Gold.....: " + canven3 + "\n"); 
	}
	
	
	
	
	
	
}
