package proyecto;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;

public class main {
	

	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame("Lienzo");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    
	    
	    
	    Colores colores = new Colores();	    
	    lienzo lienzo = new lienzo();	    
	    guardar guardar= new guardar(lienzo);
	  
	    JLabel filasLabel = new JLabel("Filas:");
	    JTextField filasTextField = new JTextField("",40);
	    

	    JLabel renglonesLabel = new JLabel("Renglones:");
	    JTextField renglonesTextField = new JTextField("",40);

	    JLabel tamanoPixelLabel = new JLabel("Tamaño de pixel:");
	    JTextField tamanoPixelTextField = new JTextField("",40);

	    JButton botonBorrar = new JButton("Borrar");
	    botonBorrar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            lienzo.borrar();
	        }
	    });
	    JButton enviarcolor = new JButton("actualizar color");
	    enviarcolor.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Color newColor = colores.getColor();
	            lienzo.setPixelColor(newColor);

	        }
	    });
	    
	    JButton guardar_imagen = new JButton ("Guardar imagen");
	    guardar_imagen.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Crear un JFileChooser para seleccionar la ubicación y el nombre del archivo
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setDialogTitle("Guardar imagen");

	            int userSelection = fileChooser.showSaveDialog(frame);

	            if (userSelection == JFileChooser.APPROVE_OPTION) {
	                // Obtener el archivo seleccionado por el usuario
	                File fileToSave = fileChooser.getSelectedFile();
	                
	                // Obtener el nombre ingresado por el usuario
	                String nombreArchivo = fileToSave.getName();

	                // Guardar la imagen en un archivo con el nombre ingresado por el usuario
	                guardar.save(lienzo, nombreArchivo);
	            }
	        }
	    });
	    
	    JButton cargar_imagen = new JButton("Cargar imagen");
	    cargar_imagen.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Crear un JFileChooser para seleccionar la ubicación y el nombre del archivo
	            JFileChooser fileChooser = new JFileChooser();
	            int result = fileChooser.showOpenDialog(null);
	            // Si se selecciona un archivo, abrir la imagen con el método open de la clase Guardar
	            if (result == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                guardar.open(selectedFile);
	            }
	        }
	    });
	    
	   JButton aplicarCambiosButton = new JButton("Aplicar cambios");
	    aplicarCambiosButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                int filas = Integer.parseInt(filasTextField.getText());
	                int renglones = Integer.parseInt(renglonesTextField.getText());
	                int tamanoPixel = Integer.parseInt(tamanoPixelTextField.getText());

	                lienzo.setGridSize(filas, renglones);
	                lienzo.setCellSize(tamanoPixel);

	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(frame, "Ingrese valores numéricos válidos");
	            }
	        }
	    });
	    Font font = new Font(null, Font.BOLD, 50); 
	    JLabel label = new JLabel("PIXEL ART");
	    label.setFont(font);

	    JPanel panelBotones = new JPanel();
	    panelBotones.setBackground(Color.LIGHT_GRAY);
	    panelBotones.add(guardar_imagen);
	    panelBotones.add(cargar_imagen);
	    panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
	    panelBotones.setPreferredSize(new Dimension(200, 0));
	    panelBotones.add(filasLabel);
	    panelBotones.add(filasTextField);
	    panelBotones.add(renglonesLabel);
	    panelBotones.add(renglonesTextField);
	    panelBotones.add(tamanoPixelLabel);
	    panelBotones.add(tamanoPixelTextField);
	    panelBotones.add(aplicarCambiosButton);
	    
	    JPanel panelBotones2 = new JPanel();
	    panelBotones2.setBackground(Color.LIGHT_GRAY);
	    panelBotones2.add(enviarcolor);
	    panelBotones2.add(botonBorrar);
	    
	    JPanel panelColores = new JPanel();
	    panelColores.setBackground(Color.LIGHT_GRAY);
	    panelColores.setLayout(new BoxLayout(panelColores, BoxLayout.Y_AXIS));
	    panelColores.setPreferredSize(new Dimension(200, 0));
	    panelColores.add(colores);
	    panelColores.add(panelBotones2);    
	 
	    Container contentPane = frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
	    contentPane.setBackground(Color.LIGHT_GRAY);
	    //contentPane.add(lienzo, BorderLayout.CENTER);
	    contentPane.add(panelBotones, BorderLayout.WEST);
	    contentPane.add(panelColores, BorderLayout.EAST);
	    contentPane.add(label, BorderLayout.NORTH);
	    
	    lienzo.setPreferredSize(new Dimension(500, 500)); // Establece un tamaño preferido en el lienzo
	    JPanel lienzoContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Crea un panel para contener el lienzo y centrarlo
	    lienzoContainer.setBackground(Color.LIGHT_GRAY); // Establece un color de fondo en el contenedor
	    lienzoContainer.add(lienzo); // Agrega el lienzo al contenedor
	    contentPane.add(lienzoContainer, BorderLayout.CENTER); // Agrega el contenedor centrado al contenedor principal
	      
	    frame.setVisible(true);
	    
	    frame.setLocationRelativeTo(null);
	    
	   	
	    
	}
	
	
}
