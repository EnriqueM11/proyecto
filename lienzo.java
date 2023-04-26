package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class lienzo extends JPanel {

    private int[][] pixels;
    private Color currentColor = Color.BLUE;
    private int cellSize = 40;
    private int rows;
    private int cols;

    public lienzo(int rows, int cols) {
    	
        this.rows = rows;
        this.cols = cols;
        pixels = new int[rows][cols];
      
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                pixels[row][col] = Color.WHITE.getRGB();
            }
        }
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                paintPixel(e.getX(), e.getY());
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                paintPixel(e.getX(), e.getY());
                
            }
        });
    }

    private void paintPixel(int mouseX, int mouseY) {
        int row = mouseY / cellSize;
        int col = mouseX / cellSize;
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            pixels[row][col] = currentColor.getRGB();
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        drawGrid(g);
        
    }
    
    
    private void draw(Graphics g) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize;
                int y = row * cellSize;                 
                g.setColor(new Color(pixels[row][col]));
                g.fillRect(x, y, cellSize, cellSize); 
            }
        }
    }
    
    private void drawGrid(Graphics g) {
        // dibuja la cuadrícula
    	g.setColor(Color.BLACK);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                g.drawRect(x, y, cellSize, cellSize);
                
                }
            }
        }

	public void borrar() {
		
		for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                pixels[row][col] = 0;
            }
        }
		
		for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                pixels[row][col] = Color.WHITE.getRGB();
            }
        }
		repaint();
	}    
    
}

