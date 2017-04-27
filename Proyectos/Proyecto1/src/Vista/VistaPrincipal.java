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
import java.awt.Font;
import javax.swing.JTextArea;

public class VistaPrincipal {

	private JFrame frame;
	private JTextField txtNanosegundos;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private JTextField textField_2;
	private JTextField textFieldClientes;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private static JTextArea textArea;
	
	Thread hiloPasear;
	Thread hiloBuscar;
	Thread hiloParquear;
	Thread hiloanimar;
	
	Thread hiloPasear2;
	Thread hiloBuscar2;
	
	boolean buscaractiv2 = false;
	boolean pasearactiv2 = false;
	boolean presionadoprincipal2 = false;
	
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
		frame.setBounds(100, 100, 1432, 669);
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
		lblTaxi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaxi.setBounds(106, 32, 56, 16);
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
		
		JLabel lblCambios = new JLabel("Modificaciones");
		lblCambios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCambios.setBounds(77, 447, 135, 16);
		layeredPane.add(lblCambios);
		
		JButton btnNewButton_8 = new JButton("Taxi 2");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main.Taxi2();
				
			}
		});
		btnNewButton_8.setBounds(30, 489, 97, 25);
		layeredPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Pasear2");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (presionadoprincipal2 == false){
					
					hiloPasear2 = new Proceso("Hilo Pasear","Pasear2");
					hiloPasear2.start();
					pasearactiv2 = true;
					presionadoprincipal2 = true;
				}
				else{
					
					//Si buscar esta activo lo detengo
					if (buscaractiv2 == true){
						hiloBuscar2.stop();
					}
					
					
					hiloPasear2 = new Proceso("Hilo Pasear ","Pasear2");
					hiloPasear2.start();
					pasearactiv2 = true;
					
				}
				
				
			}
		});
		btnNewButton_9.setBounds(30, 540, 97, 25);
		layeredPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Buscar2");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if (presionadoprincipal2 == false){
					hiloBuscar2 = new Proceso("Hilo Buscar ","Buscar2");
					hiloBuscar2.start();
					buscaractiv2 = true;
					presionadoprincipal2 = true;
				}
				else{
					
					//Si buscar esta activo lo detengo
					if (pasearactiv2 == true){
						hiloPasear2.stop();
					}
					
					
					hiloBuscar2 = new Proceso("Hilo Buscar ","Buscar2");
					hiloBuscar2.start();
					buscaractiv2 = true;
					
				}
				
			}
		});
		btnNewButton_10.setBounds(139, 540, 97, 25);
		layeredPane.add(btnNewButton_10);
		
		textArea = new JTextArea();
		textArea.setBounds(495, 101, 907, 464);
		Font font = textArea.getFont();
	   float size = font.getSize() + 2.0f;
	   textArea.setFont( font.deriveFont(size) );
		layeredPane.add(textArea);
		initcomponents();
	}

	private void initcomponents() {
	}
	
	
	public static void printMapa(){
		
		char mapa[][] =	Main.getMapa();
		
		int ciudadfilas1 = 16;
		int ciudadcolumnas1 = 31;

		int ciudadfilas2 = 23;
		int ciudadcolumnas2 = 54;
		
		
		int i = 0;
	    int j = 0;
	    char caracter;
	    
	    String caract;
	    String fila = "";
	    String mapacompleto = "";
	    
	    for( i = 0; i< ciudadfilas1; i++){
		    for ( j = 0 ; j< ciudadcolumnas1; j++){
			   
		    	caracter = mapa[i][j];
		    	
		    	
		    	if ( (i == 1 || i == 5 || i == 9 || i == 13) && (j == 29 )){
			    	
		    		
		    	  if (i == 5 || i == 9 || i == 13){
		    		  
		    		caract = Character.toString(' ');
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
		    		  
		    	  }
		    	  else {
		    		  
		    		  caract = Character.toString(' ');
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					
		    		  
		    	  }
			    	
 	
			    }
		    	
		    	else if (caracter == ' ' && (i == 1 || i == 5 || i == 9 || i == 13)){
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;

		    	}
		    	else if (caracter == ' ' ){
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;

		    	}
		    	else if (caracter == '#'){
					   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;

			    	   
				   }
		    	else if (caracter == '%'){
					   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;

			    	   
				   }
		    	else if (caracter == 'T' ){
					   
		    		   fila = fila + ' ';
		    		
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;

			    	   
				   }
		    	else if (caracter == 't'){
					   
		    		   fila = fila + ' ';
		    		
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				   	}
		    	else if (caracter == '*'){
					   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;

			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				}
		    	else if (caracter == 'I' ){
					   
			    	   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;

			    	   
				}
		    	
		    	else if (caracter == 'C' || caracter == 'E' || caracter == 'O'  || caracter == 'R' || caracter == 'U' || caracter == 'N' || caracter == 'G' || caracter == 'W' || caracter == 'X'){
					   
			    	   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				}

		    	else if (caracter != 't' && caracter != ' ' && caracter != '%' && caracter != 'T' && caracter != '*'){
					   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				   }
				   else if (caracter == '0' ){
					   
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				   }
				   
		    	else{
		    		
			    	caract = Character.toString(caracter);
			    	fila = fila + caract;
		    	
		    	}
		    }
		    
		    
		    fila = fila +'\n';
		    mapacompleto = mapacompleto + fila;
		    fila = "";
	    }
	   
	
	   for( i = 16; i< ciudadfilas2; i++){
		   for ( j = 0 ; j< ciudadcolumnas2; j++){
			   
				
			   caracter = mapa[i][j];
			   
			   if ((i == 16 || i == 17 || i == 21 || i == 22  ) && (j == 32)){
				   
				   caract = Character.toString(' ');
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					
					fila = fila + caract;
					fila = fila + caract;

				   
			   }			   
			   else if ( (i == 17 || i == 21 ) && (j == 29 || j == 52 )){
			    	
				   if (j == 52){
					   
					   caract = Character.toString(' ');
						fila = fila + caract;
						fila = fila + caract;
						fila = fila + caract;
						fila = fila + caract;

					   
				   }
				   else {
			    	caract = Character.toString(' ');
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;
					fila = fila + caract;

					
					
				   }
			    	
			    }
			   else if (caracter == ' ' ){
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    		caract = Character.toString(caracter);
		    		fila = fila + caract;
		    		
		    	}

			   else if (caracter == '%'){
				   
				   caract = Character.toString(caracter);
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;

		    	   
			   }
			   else if (caracter == '#'){
				   
				   caract = Character.toString(caracter);
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;

		    	   
			   }
			   	else if (caracter == 'T' ){
				   
	    		   fila = fila + ' ';
	    		
				   caract = Character.toString(caracter);
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;

		    	   
			   	}
			   
			   	else if (caracter == 't'){
					   
		    		   fila = fila + ' ';
		    		
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				   	}
		    	else if (caracter == '*'){
					   
					   caract = Character.toString(caracter);
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
	
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				}
		    	else if (caracter == 'o' ){
					   
		    			fila = fila + ' ';
			    	   
		    		   caract = Character.toString(caracter);
			    	   fila = fila + caract;

			    	   caract = Character.toString(' ');
			    	   fila = fila + caract;
			    	   
				   }
			   else if (caracter == '0' ){
				   
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
			   }
			   else if ( caracter == '3' || caracter == '4'  || caracter == '5' || caracter == '6' || caracter == '7' || caracter == '8' || caracter == '9' || caracter == 'z' || caracter == 'w' || caracter == 'y' || caracter == 'k' ){
				   
		    	   
				   caract = Character.toString(caracter);
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;

		    	   
			   }
			   else if (caracter != 't' && caracter != ' ' && caracter != '%' && caracter != 'T' && caracter != '*'){
				   
				   caract = Character.toString(caracter);
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
			   }
		    	else{
		    		
			    	caract = Character.toString(caracter);
			    	fila = fila + caract;
		    	
			    	
		    	}
			   
		   }
		   fila = fila +'\n';
		   
		   mapacompleto = mapacompleto + fila;
		   fila = "";
	   }
		
		
	   
	   
	   	textArea.setText(mapacompleto);
		textArea.setEditable(false);

	}
}
