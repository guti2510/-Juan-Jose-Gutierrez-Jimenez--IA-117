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
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import Controler.EventEmitter;
import Controler.Mapa;
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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class VistaPrincipal {

	private JFrame frame;
	private JTextField txtNanosegundos;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;

	private JTextField textFieldClientes;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private static JLabel lblTiempo;
	
	static JTextPane textPaneMapa;
	static JTextPane textPaneEdificios;
	
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
	
	static int idsgenerales = 1;
	
	static Taxi taxi;
	static Mapa mapaprincipal;
	
	static EventEmitter eventEmitter = EventEmitter.getInstance( );
	
	private JFileChooser openFileChooser = new JFileChooser();
	private StringBuilder stringbuilder = new StringBuilder();
	
	private PrintStream standardOut;
	private JTextField TiempoField;
	
	static DefaultStyledDocument document;
	static DefaultStyledDocument document2;
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
		frame.setBounds(100, 100, 1606, 808);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.ORANGE);
		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(70, 130, 180));
		layeredPane.setToolTipText("");
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Pasear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				eventEmitter.send("pasear",0);

			}
		});
		btnNewButton.setBounds(107, 158, 97, 25);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
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
					for (int i = 0; i< Mapa.TaxiList.size(); i++){
						Taxi taxiactual = Mapa.TaxiList.get(i);
						taxiactual.Mostrar(mostrar);
					}
					
				}
				else {
					
					mostrar = false;
					lblNewLabel_4.setText("Off");
					for (int i = 0; i< Mapa.TaxiList.size(); i++){
						Taxi taxiactual = Mapa.TaxiList.get(i);
						taxiactual.Mostrar(mostrar);
					}
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
					
					for (int i = 0; i< Mapa.TaxiList.size(); i++){
						Taxi taxiactual = Mapa.TaxiList.get(i);
						taxiactual.Ruta(ruta);
					}

				}
				else {
					
					ruta = false;
					lblNewLabel_3.setText("Off");
					
					for (int i = 0; i< Mapa.TaxiList.size(); i++){
						Taxi taxiactual = Mapa.TaxiList.get(i);
						taxiactual.Ruta(ruta);
					}
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
				
				Mapa.Clientes(numeroclients,idsgenerales,eventEmitter);
				idsgenerales+= numeroclients;
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
				
				Mapa.Cliente(idsgenerales,cuadrorigenfinal,cuadradestfinal,eventEmitter);
				eventEmitter.send("esperando",idsgenerales);
				idsgenerales++;
			}
			
		});
		btnNewButton_6.setBounds(30, 337, 97, 25);
		layeredPane.add(btnNewButton_6);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Casa");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(267, 341, 235, 16);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trabajo");
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
		
		JButton btnNewButton_8 = new JButton("Taxi Nuevo");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Mapa.nuevoTaxi(idsgenerales);

			    idsgenerales ++;
				
			}
		});
		btnNewButton_8.setBounds(30, 419, 97, 25);
		layeredPane.add(btnNewButton_8);
		
		
		
		JLabel pathlabel = new JLabel("");
		pathlabel.setForeground(Color.WHITE);
		pathlabel.setBackground(Color.WHITE);
		pathlabel.setBounds(766, 65, 261, 16);
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
		TiempoField.setForeground(new Color(255, 255, 255));
		TiempoField.setBounds(267, 123, 116, 22);
		layeredPane.add(TiempoField);
		TiempoField.setColumns(10);
		
		JLabel lblTiempoDa = new JLabel("Tiempo D\u00EDa:");
		lblTiempoDa.setForeground(Color.WHITE);
		lblTiempoDa.setBounds(281, 106, 112, 16);
		layeredPane.add(lblTiempoDa);
		
		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTiempo.setForeground(new Color(230, 230, 250));
		lblTiempo.setBounds(390, 123, 56, 16);
		layeredPane.add(lblTiempo);
		
		document = new DefaultStyledDocument();
		textPaneMapa = new JTextPane(document);
		textPaneMapa.setEditable(false);
		textPaneMapa.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textPaneMapa.setBackground(new Color(100, 149, 237));
		textPaneMapa.setBounds(509, 94, 907, 619);
		layeredPane.add(textPaneMapa);
		
		document2 = new DefaultStyledDocument();
		
		JLabel lblEdificios = new JLabel("Edificios");
		lblEdificios.setForeground(Color.WHITE);
		lblEdificios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdificios.setBounds(1479, 62, 97, 25);
		layeredPane.add(lblEdificios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1442, 94, 134, 625);
		layeredPane.add(scrollPane);
		textPaneEdificios = new JTextPane(document2);
		scrollPane.setViewportView(textPaneEdificios);
		textPaneEdificios.setEditable(false);

		initcomponents();
	}

	private void initcomponents() {
	}
	
	
	public static void printMapa() {
		
		char mapa[][] =	Mapa.getMapa();
		
		int ciudadfilas = mapaprincipal.getCiudadFilas();
		int ciudadcolumnas = mapaprincipal.getCiudadColumnas();
		
		
		int i = 0;
	    int j = 0;
	    char caracter;
	    
	    String caract;
	    String fila = "";
	    String mapacompleto = "";
	    
	    /*

	   for( i = 0; i< ciudadfilas; i++){
		   for ( j = 0 ; j< ciudadcolumnas; j++){
			   
			   
			   
			   caract = Character.toString(' ');
	    	   fila = fila + caract;
	    	   
			   caracter = mapa[i][j];
			   
			   if ( caracter == ' ' || caracter =='*'){
				   
				  
				   caract = Character.toString(caracter);
			       fila = fila + caract;
			       
			       caract = Character.toString(' ');
		    	   fila = fila + caract;
		    	   
		    	   caract = Character.toString(' ');
		    	   fila = fila + caract;
			   }
			   else if (caracter == '#' || Character.isLowerCase(caracter) || Character.isUpperCase(caracter) ){
				   
				   
				   if (caracter == 'T' && primeravez == true){
						 System.out.println("TAXI EN"+ i +" "+ j);
					     Taxi taxi = new Taxi(idsgenerales,eventEmitter,i,j);
					     
					     Mapa.TaxiList.add(taxi);
					     idsgenerales ++;
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
		
		*/
	    
	    StyleContext context = new StyleContext();
		// build a style
		Style style = context.addStyle("azul", null);
		Style style2 = context.addStyle("amarillo", null);
		Style style3 = context.addStyle("rojo", null);
		Style style4 = context.addStyle("amarillo", null);
		
		// set some style properties
	    StyleConstants.setFontFamily(style, "Monospaced");
	    StyleConstants.setFontSize(style, 20);
		StyleConstants.setForeground(style, Color.WHITE);	

		StyleConstants.setFontFamily(style2, "Monospaced");
	    StyleConstants.setFontSize(style2, 20);
		StyleConstants.setForeground(style2, Color.YELLOW);	
		
		StyleConstants.setFontFamily(style3, "Monospaced");
	    StyleConstants.setFontSize(style3, 20);
		StyleConstants.setForeground(style3, Color.RED);	
		
		StyleConstants.setFontFamily(style4, "Monospaced");
	    StyleConstants.setFontSize(style4, 20);
		StyleConstants.setForeground(style4, Color.GREEN);
		
		textPaneMapa.setText("");
	    
	    
	    for( i = 0; i< ciudadfilas; i++){
			   for ( j = 0 ; j< ciudadcolumnas; j++){
				   
		    	   
				   caracter = mapa[i][j];
				   
				   if ( caracter == ' ' || caracter =='*'){
					   
					  
					   caract = Character.toString(caracter);
				       fila = fila + caract;

				   }
				   else if (caracter == '#' || Character.isLowerCase(caracter) || Character.isUpperCase(caracter) ){
					   
					   
					   if (caracter == 'T' && primeravez == true){
							 System.out.println("TAXI EN"+ i +" "+ j);
						     Taxi taxi = new Taxi(idsgenerales,eventEmitter,i,j);
						     
						     Mapa.TaxiList.add(taxi);
						     idsgenerales ++;
					   }

					   if (caracter == 'T' ){
						   
						   for (int contador= 0; contador< Mapa.TaxiList.size(); contador++){
								Taxi taxiactual = Mapa.TaxiList.get(contador);
								
								if (taxiactual.posX == i && taxiactual.posY == j){
									
									if (taxiactual.estado == "Disponible"){
	
										try {
											document.insertString(document.getLength(), fila, style);
										} catch (BadLocationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  
										caract = Character.toString(caracter);
										
										try {
											document.insertString(document.getLength(), caract, style2);
										} catch (BadLocationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										fila = "";
									}
									else if (taxiactual.estado == "Ocupado"){
										
										try {
											document.insertString(document.getLength(), fila, style);
										} catch (BadLocationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										  
										caract = Character.toString(caracter);
										
										try {
											document.insertString(document.getLength(), caract, style3);
										} catch (BadLocationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										fila = "";
									}
								}

							}
					   }
					   else if(caracter == 'o'){
						   
						   try {
								document.insertString(document.getLength(), fila, style);
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							  
							caract = Character.toString(caracter);
							
							try {
								document.insertString(document.getLength(), caract, style4);
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fila = "";
							
					   }
					   else{
					   
						   caract = Character.toString(caracter);
					       fila = fila + caract;
				       
					   }
				   }
				   else{
					   
					   
					   caract = Character.toString(caracter);
				       fila = fila + caract;

					   
					   
				   }
	 

			   }
			   fila = fila +'\n';
			   
			   try {
					document.insertString(document.getLength(), fila, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   mapacompleto = mapacompleto + fila;
			   fila = "";
			   
		   }
	    
	    primeravez = false;
	}

	public static void setTiempo(String tiempo) {

		if (tiempo == "Dia"){
			textPaneMapa.setBackground(new Color(222, 160, 73));
			lblTiempo.setText("Día");
			lblTiempo.setForeground(new Color(222, 160, 73));

		}
		else if (tiempo == "Noche"){
			textPaneMapa.setBackground(new Color(0, 46, 99));
			lblTiempo.setText("Noche");
			lblTiempo.setForeground(new Color(0, 46, 99));
		}
	}
	
	public static void calcularEdificios(){
		
		
		StyleContext context = new StyleContext();
		// build a style
		Style style = context.addStyle("azul", null);
		
		// set some style properties
	    StyleConstants.setFontFamily(style, "Monospaced");
	    StyleConstants.setFontSize(style, 15);
		StyleConstants.setForeground(style, Color.BLACK);
		
		textPaneEdificios.setText("");
		
		for (int i = 0; i< Mapa.listahogares.size(); i++){
		
			char edificio = Mapa.listahogares.get(i);
		    int cantidad = Mapa.calcularEdificio(edificio);
			String caract = Character.toString(edificio);
			
			caract = caract+ " = " + Integer.toString(cantidad);

			caract = caract +'\n';
			
			 try {
				 document2.insertString(document2.getLength(), caract , style);
			 } catch (BadLocationException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			 }
		}

		for (int i = 0; i< Mapa.listatrabajos.size(); i++){
			
			char edificio = Mapa.listatrabajos.get(i);
			int cantidad = Mapa.calcularEdificio(edificio);
			String caract = Character.toString(edificio);
			
			caract = caract+ " = " + Integer.toString(cantidad);

			caract = caract +'\n';
			
			 try {
				 document2.insertString(document2.getLength(), caract , style);
			 } catch (BadLocationException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			 }
		}
	
	}
}
