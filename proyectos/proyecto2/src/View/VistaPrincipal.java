package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Mapa;
import Controler.EventEmitter;
import Controler.Proceso;
import Model.Taxi;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

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
	Thread hiloParquear2;
	
	boolean buscaractiv2 = false;
	boolean pasearactiv2 = false;
	boolean parquearactiv2 = false;
	boolean presionadoprincipal2 = false;
	
	boolean presionado = false;
	boolean presionadoprincipal = false;
	
	boolean buscaractiv = false;
	boolean pasearactiv = false;
	boolean parquearactiv = false;
	
	boolean ruta = false;
	boolean mostrar = false;
	
	static boolean primeravez = true;
	
	static int idstaxis = 1;
	
	static Taxi taxi;
	static Mapa mapaprincipal;
	
	static EventEmitter eventEmitter = EventEmitter.getInstance( );
	
	private JFileChooser openFileChooser = new JFileChooser();
	private StringBuilder stringbuilder = new StringBuilder();
	
	private PrintStream standardOut;
	private JTextField TiempoField;
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		
	
		//Taxi taxi = new Taxi(1,eventEmitter,1,1);
		//Taxi taxi2 = new Taxi(2,eventEmitter,21,1);
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
		frame.setBounds(100, 100, 1432, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.ORANGE);
		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(70, 130, 180));
		layeredPane.setToolTipText("");
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Pasear");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
					
				eventEmitter.send("pasear",0);

			}
		});
		btnNewButton.setBounds(107, 158, 97, 25);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				eventEmitter.send("buscar",0);
	
			}
		});
		btnNewButton_1.setBounds(238, 158, 97, 25);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Animar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (presionadoprincipal == false){
					String tiempo;
					tiempo = txtNanosegundos.getText();
					float nanosegundos = Float.parseFloat(tiempo);
					
					String dia;
					dia = TiempoField.getText();
					int diasegundos = Integer.parseInt(dia);
					
					Mapa.setDia(diasegundos);
					
					hiloanimar = new Proceso("Proceso Animar",nanosegundos, "Animar");
					hiloanimar.start();
					presionadoprincipal = true;
				}
				else{
					
					String tiempo;
					tiempo = txtNanosegundos.getText();
					float nanosegundos = Float.parseFloat(tiempo);
					((Proceso) hiloanimar).CambiarSegundos(nanosegundos);

				}

			}
		});
		btnNewButton_2.setBounds(30, 120, 97, 25);
		layeredPane.add(btnNewButton_2);
		
		JLabel lblTaxi = new JLabel("TAXI");
		lblTaxi.setForeground(Color.WHITE);
		lblTaxi.setBackground(Color.WHITE);
		lblTaxi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaxi.setBounds(199, 65, 56, 16);
		layeredPane.add(lblTaxi);
		
		txtNanosegundos = new JTextField();
		txtNanosegundos.setForeground(Color.WHITE);
		txtNanosegundos.setBackground(new Color(100, 149, 237));
		txtNanosegundos.setToolTipText("");
		txtNanosegundos.setBounds(139, 123, 116, 22);
		layeredPane.add(txtNanosegundos);
		txtNanosegundos.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Mostrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if (mostrar == false){
					
					mostrar = true;
					lblNewLabel_4.setText("On");
					//taxi.Mostrar(mostrar);
				}
				else {
					
					mostrar = false;
					lblNewLabel_4.setText("Off");
					//taxi.Mostrar(mostrar);
				}
				
			}
		});
		btnNewButton_3.setBounds(56, 221, 97, 25);
		layeredPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ruta");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ruta == false){
					
					ruta = true;
					lblNewLabel_3.setText("On");
					//taxi.Ruta(ruta);
				}
				else {
					
					ruta = false;
					lblNewLabel_3.setText("Off");
					//taxi.Ruta(ruta);
				}
			}
		});
		btnNewButton_4.setBounds(281, 221, 97, 25);
		layeredPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clientes");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String numclien;
				numclien = textFieldClientes.getText();
				int numeroclients = Integer.parseInt(numclien);
				//taxi.Clientes(numeroclients);
				
			}
		});
		btnNewButton_5.setBounds(30, 285, 97, 25);
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
				
				Mapa.Cliente(cuadrorigenfinal,cuadradestfinal);
			
			}
			
		});
		btnNewButton_6.setBounds(30, 337, 97, 25);
		layeredPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Parquear");
		btnNewButton_7.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String cuadradest;
				cuadradest = textField_2.getText();
				char cuadradestfinal = cuadradest.charAt(0);
				
				
				if (presionadoprincipal == false){

					hiloParquear = new Proceso("Hilo Parquear", "Parquear",cuadradestfinal);
					hiloParquear.start();
					parquearactiv = true;
					presionadoprincipal = true;
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
					hiloParquear = new Proceso("Hilo Parquear ","Parquear",cuadradestfinal);
					hiloParquear.start();
					
				}
				
			}
		});
		btnNewButton_7.setBounds(30, 435, 97, 25);
		layeredPane.add(btnNewButton_7);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setForeground(Color.WHITE);
		textFieldOrigen.setBackground(new Color(100, 149, 237));
		textFieldOrigen.setBounds(139, 338, 116, 22);
		layeredPane.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setForeground(Color.WHITE);
		textFieldDestino.setBackground(new Color(100, 149, 237));
		textFieldDestino.setBounds(139, 371, 116, 22);
		layeredPane.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setBackground(new Color(100, 149, 237));
		textField_2.setBounds(139, 436, 126, 22);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Indique la Cuadra:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(139, 420, 116, 16);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cuadra donde se va colocar el cliente");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(267, 341, 235, 16);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destino del cliente");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(267, 374, 126, 16);
		layeredPane.add(lblNewLabel_2);
		
		textFieldClientes = new JTextField();
		textFieldClientes.setForeground(Color.WHITE);
		textFieldClientes.setBackground(new Color(100, 149, 237));
		textFieldClientes.setBounds(139, 286, 116, 22);
		layeredPane.add(textFieldClientes);
		textFieldClientes.setColumns(10);
		
		JLabel lblNumeroDeClientes = new JLabel("Numero de clientes que desea agregar");
		lblNumeroDeClientes.setForeground(Color.WHITE);
		lblNumeroDeClientes.setBounds(265, 289, 252, 16);
		layeredPane.add(lblNumeroDeClientes);
		
		JLabel lblNanosegundos = new JLabel("Segundos");
		lblNanosegundos.setForeground(Color.WHITE);
		lblNanosegundos.setBounds(156, 106, 97, 16);
		layeredPane.add(lblNanosegundos);
		
		lblNewLabel_3 = new JLabel("Off");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(390, 225, 56, 16);
		layeredPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Off");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(156, 225, 56, 16);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblCambios = new JLabel("Modificaciones");
		lblCambios.setForeground(Color.WHITE);
		lblCambios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCambios.setBounds(77, 489, 135, 16);
		layeredPane.add(lblCambios);
		
		JButton btnNewButton_8 = new JButton("Taxi 2");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//taxi.Taxi2();
				
			}
		});
		btnNewButton_8.setBounds(30, 518, 97, 25);
		layeredPane.add(btnNewButton_8);
		
		
		
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(100, 149, 237));
		textArea.setBounds(495, 101, 907, 464);
        
		
		Font font = textArea.getFont();
	    float size = font.getSize() + 2.0f;
	    textArea.setFont( font.deriveFont(size) );
		layeredPane.add(textArea);
		
		
		
		JLabel pathlabel = new JLabel("");
		pathlabel.setForeground(Color.WHITE);
		pathlabel.setBackground(Color.WHITE);
		pathlabel.setBounds(741, 65, 261, 16);
		layeredPane.add(pathlabel);
		
		JButton filebutton = new JButton("Cargar Mapa..");
		filebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int returnValue = openFileChooser.showOpenDialog(frame);
				
				if (returnValue == JFileChooser.APPROVE_OPTION){
					
					try{
						File file = openFileChooser.getSelectedFile();
						
						Scanner input = new Scanner(file);
						
						while(input.hasNext()){
							stringbuilder.append(input.nextLine());
							stringbuilder.append("\n");
						}
						
						input.close();
						
						mapaprincipal = new Mapa(stringbuilder);
						pathlabel.setText("Mapa elegido correctamente");
						printMapa();
					}
					catch(Exception e){
						e.printStackTrace();
						
					}
					
				}
				else{
					
					pathlabel.setText("No se ha elegido un mapa correctamente");
				}
			}
		});
		
		filebutton.setBounds(630, 61, 126, 25);
		layeredPane.add(filebutton);
		
		TiempoField = new JTextField();
		TiempoField.setBackground(new Color(100, 149, 237));
		TiempoField.setForeground(new Color(100, 149, 237));
		TiempoField.setBounds(267, 123, 116, 22);
		layeredPane.add(TiempoField);
		TiempoField.setColumns(10);
		
		JLabel lblTiempoDa = new JLabel("Tiempo D\u00EDa:");
		lblTiempoDa.setForeground(Color.WHITE);
		lblTiempoDa.setBounds(281, 106, 112, 16);
		layeredPane.add(lblTiempoDa);

		
		initcomponents();
	}

	private void initcomponents() {
	}
	
	
	public static void printMapa(){
		
		char mapa[][] =	mapaprincipal.getMapa();
		
		int ciudadfilas = mapaprincipal.getCiudadFilas();
		int ciudadcolumnas = mapaprincipal.getCiudadColumnas();
		
		
		int i = 0;
	    int j = 0;
	    char caracter;
	    
	    String caract;
	    String fila = "";
	    String mapacompleto = "";
	    
	    /*
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
	   */
	
	   for( i = 0; i< ciudadfilas; i++){
		   for ( j = 0 ; j< ciudadcolumnas; j++){
			   
			   
			   
			   caract = Character.toString(' ');
	    	   fila = fila + caract;
	    	   
			   caracter = mapa[i][j];
			   
			   if ( caracter == ' ' ){
				   
				  
				   caract = Character.toString(caracter);
			       fila = fila + caract;
			       
			       caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
			   }
			   else if (caracter == '#' || Character.isLowerCase(caracter) || Character.isUpperCase(caracter)){
				   
				   
				   if (caracter == 'T' && primeravez == true){
						 System.out.println("TAXI EN"+ i +" "+ j);
					     Taxi taxi = new Taxi(idstaxis,eventEmitter,i,j);
					     idstaxis +=1;
				   }
				   
				   
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
	    primeravez = false;
	   	textArea.setText(mapacompleto);
		textArea.setEditable(false);
	}

	public static void setTiempo(String tiempo) {

		textArea.setBackground(new Color(222, 160, 73));
	}
}
