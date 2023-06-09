package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class lienzo extends JPanel {

    private int[][] pixels;
    public int cellSize = 20;
    private int rows=30;
    private int cols=30;
    private Color selectedColor = Color.white;
    private BufferedImage img;                         // Imagen en el lienzo.
    private Graphics2D g2d;   
    

    public lienzo() {

        pixels = new int[rows][cols];
        
        setOpaque(false); 
        
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
        g.setColor(Color.BLACK);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
    }

    public void setPixelColor(Color color) {
        this.selectedColor = color;
    }

    private void paintPixel(int mouseX, int mouseY) {
        int row = mouseY / cellSize;
        int col = mouseX / cellSize;
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            pixels[row][col] = selectedColor.getRGB();
            repaint();
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
    
    public Color[][] getPixels() {
        Color[][] pixelsCopy = new Color[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                pixelsCopy[row][col] = new Color(pixels[row][col]);
            }
        }
        return pixelsCopy;
    }
    

	public void setPixels(Color[][] pixels2) {
		// TODO Auto-generated method stub
		this.pixels = pixels;
        repaint();
	}
	
	public void setCellSize(int size) {
	    this.cellSize = size;
	    repaint();
	}

	public void setGridSize(int rows, int cols) {
	    this.rows = rows;
	    this.cols = cols;
	    pixels = new int[rows][cols];

	    for (int row = 0; row < rows; row++) {
	        for (int col = 0; col < cols; col++) {
	            pixels[row][col] = Color.WHITE.getRGB();
	        }
	    }

	    repaint();
	}
	
	
}