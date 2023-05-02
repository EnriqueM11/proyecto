package proyecto;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class main {
	

	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame("Lienzo");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    
	    Colores colores = new Colores();	    
	    lienzo lienzo = new lienzo(10, 10);
	  
	    

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
	     
	    

	    JPanel panelBotones = new JPanel();
	    panelBotones.add(botonBorrar);
	    panelBotones.add(enviarcolor);
	   

	    Container contentPane = frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());

	   
	    contentPane.add(lienzo, BorderLayout.CENTER);
	    contentPane.add(colores, BorderLayout.SOUTH);
	    contentPane.add(panelBotones, BorderLayout.WEST);

	    
	    

	    frame.setVisible(true);
	    
	    frame.setLocationRelativeTo(null);
	    
	   	
	    
	}
	
	
}
