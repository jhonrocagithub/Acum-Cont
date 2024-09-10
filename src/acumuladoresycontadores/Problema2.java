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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtSueldo;
	private JButton btnBorrar;
	private JButton btnProcesar;
	private JScrollPane scpScroll;
	private JTextArea txtAreaResultado;
	
	// Declaración de variables globales para el algoritmo
	int conta1, conta2, conta3, conta4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema2 frame = new Problema2();
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
	public Problema2() {
		setTitle("Sueldos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sueldo");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(76, 8, 86, 20);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(245, 7, 89, 23);
		contentPane.add(btnBorrar);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 53, 414, 197);
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
		double sueldo;
		
		//entrada de datos
		sueldo = getSueldo();
		
		//Proceso de calculo
		efectuarIncrementos(sueldo);
		
		//mostrar resultados
		mostrarResultados();
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtSueldo.setText("");
		txtAreaResultado.setText("");
		txtSueldo.requestFocus();
	}
	double getSueldo() {
		return Double.parseDouble(txtSueldo.getText());
	}
	void efectuarIncrementos(double sueldo) {
		if(sueldo <= 2500)
			conta1++;
		else if(sueldo <= 3000)
			conta2++;
		else if(sueldo <= 3500)
			conta3++;
		else
			conta4++;
	}
	//mostrar resultados
	void mostrarResultados() {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Cantidad de sueldos <= 2500 : " + conta1 +"\n");
		txtAreaResultado.append("Cantidad de sueldos > 2500 y <= 3000 : " + conta2 +"\n");
		txtAreaResultado.append("Cantidad de sueldos > 3000 y <= 3500 : " + conta3 +"\n");
		txtAreaResultado.append("Cantidad de sueldos > 3500 : " + conta4);
	}
	
}
