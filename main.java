package proyecto;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
	   
	    

	    

	    JPanel panelBotones = new JPanel();
	    panelBotones.add(botonBorrar);
	    panelBotones.add(enviarcolor);
	    panelBotones.add(guardar_imagen);

	   

	    Container contentPane = frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());

	   
	    contentPane.add(lienzo, BorderLayout.CENTER);
	    contentPane.add(colores, BorderLayout.SOUTH);
	    contentPane.add(panelBotones, BorderLayout.WEST);

	    
	    

	    frame.setVisible(true);
	    
	    frame.setLocationRelativeTo(null);
	    
	   	
	    
	}
	
	
}
