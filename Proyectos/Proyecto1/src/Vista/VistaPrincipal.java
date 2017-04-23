package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.Main;
import Controlador.Proceso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal {

	private JFrame frame;
	private JTextField txtNanosegundos;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private JTextField textField_2;
	private JTextField textFieldClientes;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	Thread hiloPasear;
	Thread hiloBuscar;
	Thread hiloParquear;
	Thread hiloanimar;
	
	boolean presionado = false;
	boolean presionadoprincipal = false;
	
	boolean buscaractiv = false;
	boolean pasearactiv = false;
	boolean parquearactiv = false;
	
	boolean ruta = false;
	boolean mostrar = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setToolTipText("Nanosegundos");
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Pasear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				if (presionadoprincipal == false){
					hiloPasear = new Proceso("Hilo Pasear","Pasear");
					hiloPasear.start();
					pasearactiv = true;
					presionadoprincipal = true;
				}
				else{
					
					//Si buscar esta activo lo detengo
					if (buscaractiv == true){
						hiloBuscar.stop();
					}
					
					
					hiloPasear = new Proceso("Hilo Pasear ","Pasear");
					hiloPasear.start();
					pasearactiv = true;
					
				}

			}
		});
		btnNewButton.setBounds(30, 116, 97, 25);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (presionadoprincipal == false){
					hiloBuscar = new Proceso("Hilo Buscar ","Buscar");
					hiloBuscar.start();
					buscaractiv = true;
					presionadoprincipal = true;
				}
				else{
					
					//Si buscar esta activo lo detengo
					if (pasearactiv == true){
						hiloPasear.stop();
					}
					
					
					hiloBuscar = new Proceso("Hilo Buscar ","Buscar");
					hiloBuscar.start();
					buscaractiv = true;
					
				}
				
				
			}
		});
		btnNewButton_1.setBounds(139, 116, 97, 25);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Animar");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (presionado == false){
					String tiempo;
					tiempo = txtNanosegundos.getText();
					float nanosegundos = Float.parseFloat(tiempo);
	
					hiloanimar = new Proceso("Proceso Animar",nanosegundos, "Animar");
					hiloanimar.start();
					presionado = true;
				}
				else{
					
					String tiempo;
					tiempo = txtNanosegundos.getText();
					float nanosegundos = Float.parseFloat(tiempo);
					((Proceso) hiloanimar).CambiarSegundos(nanosegundos);

				}

			}
		});
		btnNewButton_2.setBounds(30, 78, 97, 25);
		layeredPane.add(btnNewButton_2);
		
		JLabel lblTaxi = new JLabel("TAXI");
		lblTaxi.setBounds(222, 25, 56, 16);
		layeredPane.add(lblTaxi);
		
		txtNanosegundos = new JTextField();
		txtNanosegundos.setToolTipText("Nanosegundos");
		txtNanosegundos.setBounds(139, 81, 116, 22);
		layeredPane.add(txtNanosegundos);
		txtNanosegundos.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Mostrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if (mostrar == false){
					
					mostrar = true;
					lblNewLabel_4.setText("On");
					Main.Mostrar(mostrar);
				}
				else {
					
					mostrar = false;
					lblNewLabel_4.setText("Off");
					Main.Mostrar(mostrar);
				}
				
			}
		});
		btnNewButton_3.setBounds(55, 185, 97, 25);
		layeredPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ruta");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ruta == false){
					
					ruta = true;
					lblNewLabel_3.setText("On");
					Main.Ruta(ruta);
				}
				else {
					
					ruta = false;
					lblNewLabel_3.setText("Off");
					Main.Ruta(ruta);
				}
			}
		});
		btnNewButton_4.setBounds(281, 185, 97, 25);
		layeredPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clientes");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String numclien;
				numclien = textFieldClientes.getText();
				int numeroclients = Integer.parseInt(numclien);
				Main.Clientes(numeroclients);
				
			}
		});
		btnNewButton_5.setBounds(29, 247, 97, 25);
		layeredPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Cliente");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String cuadraorign;
				cuadraorign = textFieldOrigen.getText();
				char cuadrorigenfinal = cuadraorign.charAt(0);
				
				String cuadradest;
				cuadradest = textFieldDestino.getText();
				char cuadradestfinal = cuadradest.charAt(0);
				
				Main.Cliente(cuadrorigenfinal,cuadradestfinal);
			
			}
			
		});
		btnNewButton_6.setBounds(29, 302, 97, 25);
		layeredPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Parquear");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cuadradest;
				cuadradest = textField_2.getText();
				char cuadradestfinal = cuadradest.charAt(0);
				
				
				if (presionadoprincipal == false){

					hiloParquear = new Proceso("Proceso Animar", "Parquear",cuadradestfinal);
					hiloParquear.start();
					parquearactiv = true;
					presionado = true;
				}
				else{
					
					//Si buscar esta activo lo detengo
					if (pasearactiv == true){
						hiloPasear.stop();
					}
					else if (buscaractiv = true){
						hiloBuscar.stop();
					}
					
					parquearactiv = true;
					hiloPasear = new Proceso("Hilo Pasear ","Parquear",cuadradestfinal);
					hiloPasear.start();
					
				}
				
			}
		});
		btnNewButton_7.setBounds(29, 391, 97, 25);
		layeredPane.add(btnNewButton_7);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(139, 303, 116, 22);
		layeredPane.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(139, 338, 116, 22);
		layeredPane.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 392, 126, 22);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Indique la Cuadra:");
		lblNewLabel.setBounds(149, 373, 116, 16);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cuadra donde se va colocar el cliente");
		lblNewLabel_1.setBounds(267, 306, 235, 16);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destino del cliente");
		lblNewLabel_2.setBounds(267, 341, 126, 16);
		layeredPane.add(lblNewLabel_2);
		
		textFieldClientes = new JTextField();
		textFieldClientes.setBounds(139, 248, 116, 22);
		layeredPane.add(textFieldClientes);
		textFieldClientes.setColumns(10);
		
		JLabel lblNumeroDeClientes = new JLabel("Numero de clientes que desea agregar");
		lblNumeroDeClientes.setBounds(267, 251, 252, 16);
		layeredPane.add(lblNumeroDeClientes);
		
		JLabel lblNanosegundos = new JLabel("Segundos");
		lblNanosegundos.setBounds(158, 65, 97, 16);
		layeredPane.add(lblNanosegundos);
		
		lblNewLabel_3 = new JLabel("Off");
		lblNewLabel_3.setBounds(390, 189, 56, 16);
		layeredPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Off");
		lblNewLabel_4.setBounds(164, 189, 56, 16);
		layeredPane.add(lblNewLabel_4);
		initcomponents();
	}

	private void initcomponents() {
	}
}
