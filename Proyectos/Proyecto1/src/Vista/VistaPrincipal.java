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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Thread hiloprincipal;
	Thread hiloanimar;
	
	boolean presionado = false;
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
					
					hiloprincipal = new Proceso("Hilo Principal","Pasear");
					hiloprincipal.start();

			}
		});
		btnNewButton.setBounds(30, 116, 97, 25);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				((Proceso) hiloprincipal).CambiarAccion("Buscar");
				
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
					int nanosegundos = Integer.parseInt(tiempo);
	
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
		btnNewButton_3.setBounds(79, 185, 97, 25);
		layeredPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ruta");
		btnNewButton_4.setBounds(214, 185, 97, 25);
		layeredPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clientes");
		btnNewButton_5.setBounds(29, 247, 97, 25);
		layeredPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Cliente");
		btnNewButton_6.setBounds(29, 302, 97, 25);
		layeredPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Parquear");
		btnNewButton_7.setBounds(29, 391, 97, 25);
		layeredPane.add(btnNewButton_7);
		
		textField = new JTextField();
		textField.setBounds(139, 303, 116, 22);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 338, 116, 22);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 248, 116, 22);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNumeroDeClientes = new JLabel("Numero de clientes que desea agregar");
		lblNumeroDeClientes.setBounds(267, 251, 252, 16);
		layeredPane.add(lblNumeroDeClientes);
		
		JLabel lblNanosegundos = new JLabel("Nanosegundos");
		lblNanosegundos.setBounds(158, 65, 97, 16);
		layeredPane.add(lblNanosegundos);
		initcomponents();
	}

	private void initcomponents() {
	}
}
