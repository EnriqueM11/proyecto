package proyecto;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Lienzo");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);

	    lienzo lienzo = new lienzo(10, 10);
	    Colores colores = new Colores();

	    JButton botonBorrar = new JButton("Borrar");
	    botonBorrar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            lienzo.borrar();
	        }
	    });
	    
	    

	    JPanel panelBotones = new JPanel();
	    panelBotones.add(botonBorrar);
	    
	    JPanel color = new JPanel();
	    color.add(colores);
	   
	    Container contentPane = frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
	    contentPane.add(lienzo, BorderLayout.CENTER);
	    contentPane.add(color, BorderLayout.SOUTH);
	    //contentPane.add(botonBorrar, BorderLayout.SOUTH);
	    

	    frame.setVisible(true);
	    
	  
	    

	}

}