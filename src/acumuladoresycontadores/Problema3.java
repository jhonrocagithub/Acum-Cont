package acumuladoresycontadores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox cmbCategoria;
	private JTextField txtHoras;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtAreaResultado;
	
	//declaramos variables globales
	double suelBrut0, suelBrut1, suelBrut2, suelBrut3;
	int sumHoras0, sumHoras1, sumHoras2, sumHoras3;
	int cantEmp0, cantEmp1, cantEmp2, cantEmp3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema3 frame = new Problema3();
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
	public Problema3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(10, 21, 59, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Horas");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cmbCategoria.setBounds(90, 17, 79, 22);
		contentPane.add(cmbCategoria);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(90, 43, 79, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 17, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 42, 89, 23);
		contentPane.add(btnBorrar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 85, 414, 165);
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
		//declarar variables locales
		int categoria, horas;
		double sueldoBruto;
		
		//entrada de datos
		categoria = getCategoria();
		horas = getHoras();
		
		//proceso de calculo
		sueldoBruto = calcularSueldoBruto(categoria, horas);
		efectuarIncrementos(categoria, horas, sueldoBruto);
		mostrarResultados(sueldoBruto);
		
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtHoras.setText("");
		txtAreaResultado.setText("");
		txtHoras.requestFocus();
	}
	int getCategoria() {
		return cmbCategoria.getSelectedIndex();
	}
	int getHoras() {
		return Integer.parseInt(txtHoras.getText());
	}
	double calcularSueldoBruto(int categoria, int horas) {
		switch(categoria) {
			case 0: 
				return 45.0 * horas;
			case 1: 
				return 42.5 * horas;
			case 2: 
				return 40.0 * horas;
			default: 
				return 37.5 * horas;
		}
	}
	void efectuarIncrementos(int categoria, int horas, double sueldoBruto) {
		switch(categoria) {
			case 0:
				suelBrut0 += sueldoBruto;
				sumHoras0 += horas;
				cantEmp0++;
				break;
			case 1:
				suelBrut1 += sueldoBruto;
				sumHoras1 += horas;
				cantEmp1++;
				break;
			case 2:
				suelBrut2 += sueldoBruto;
				sumHoras2 += horas;
				cantEmp2++;
				break;
			default:
				suelBrut3 += sueldoBruto;
				sumHoras3 += horas;
				cantEmp3++;
		}
	}
	
	void mostrarResultados(double sueldoBruto) {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Sueldo bruto...........: " + sueldoBruto + "\n");
		txtAreaResultado.append("\n");
		txtAreaResultado.append("Suma total de sueldos brutos" + "\n");
		txtAreaResultado.append("- De categoria A....: " + suelBrut0 + "\n"); 
		txtAreaResultado.append("- De categoria B...: " + suelBrut1 + "\n"); 
		txtAreaResultado.append("- De categoria C...: " + suelBrut2 + "\n"); 
		txtAreaResultado.append("- De categoria D.....: " + suelBrut3 + "\n");
		txtAreaResultado.append("\n");
		txtAreaResultado.append("\"Suma total de horas trabajadas" + "\n"); 
		txtAreaResultado.append("- De categoria A....: " + sumHoras0 + "\n"); 
		txtAreaResultado.append("- De categoria B...: " + sumHoras1 + "\n"); 
		txtAreaResultado.append("- De categoria C...: " + sumHoras2 + "\n"); 
		txtAreaResultado.append("- De categoria D.....: " + sumHoras3 + "\n"); 
		txtAreaResultado.append("\n"); 
		txtAreaResultado.append("Cantidad total de empleados" + "\n"); 
		txtAreaResultado.append("- De categoria A....: " + cantEmp0 + "\n"); 
		txtAreaResultado.append("- De categoria B...: " + cantEmp1 + "\n"); 
		txtAreaResultado.append("- De categoria C...: " + cantEmp2 + "\n"); 
		txtAreaResultado.append("- De categoria D.....: " + cantEmp3 + "\n"); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
