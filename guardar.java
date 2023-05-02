package proyecto;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class guardar {
	
	lienzo lienzo = new lienzo();
	
	 public guardar(proyecto.lienzo lienzo2) {
		 
	 }
	 
	 public void save(lienzo lienzo, String nombreArchivo) {
	        // Obtener la matriz de colores actual
	        Color[][] pixels = lienzo.getPixels();

	        // Crear una nueva imagen y dibujar los pixeles
	        BufferedImage image = new BufferedImage(pixels[0].length * lienzo.cellSize, pixels.length * lienzo.cellSize, BufferedImage.TYPE_INT_RGB);
		    Graphics2D g = image.createGraphics();
		    g.setBackground(Color.WHITE); // Configurar el color de fondo
		    g.clearRect(0, 0, image.getWidth(), image.getHeight()); // Limpiar la imagen
		    for (int row = 0; row < pixels.length; row++) {
		        for (int col = 0; col < pixels[0].length; col++) {
		            g.setColor(pixels[row][col]);
		            g.fillRect(col * lienzo.cellSize, row * lienzo.cellSize, lienzo.cellSize, lienzo.cellSize);
		        }
		    }

	        // Guardar la imagen en un archivo
	        try {
	            ImageIO.write(image, "jpg", new File(nombreArchivo + ".jpg"));
	           JOptionPane.showMessageDialog(null, "Imagen guardada con exito");
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Imagen guardada con exito"+ e.getMessage());
	        }
	    }
	 

}


