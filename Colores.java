package proyecto;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Colores extends JPanel implements ActionListener, ChangeListener {
    private static final long serialVersionUID = 1L;
    private JPanel colorPanel;
    private JLabel redLabel, greenLabel, blueLabel;
    private JSlider redSlider, greenSlider, blueSlider;
    private JButton[] colorButtons;
    private Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA,
            Color.PINK, Color.WHITE, Color.GRAY, Color.BLACK };

    public Colores() {
       
        setLayout(null);
        setResizable(false);
        
        // Color panel
        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(10, 100));
        add(colorPanel);

        // Sliders
        redLabel = new JLabel("Red: 0");
        add(redLabel);

        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        redSlider.addChangeListener(this);
        add(redSlider);

        greenLabel = new JLabel("Green: 0");  
        add(greenLabel);

        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider.addChangeListener(this);
        add(greenSlider);

        blueLabel = new JLabel("Blue: 0");
        add(blueLabel);

        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider.addChangeListener(this);
        add(blueSlider);

        // Color buttons
        colorButtons = new JButton[colors.length];
        for (int i = 0; i < colors.length; i++) {
            colorButtons[i] = new JButton();
            colorButtons[i].setBackground(colors[i]);
            colorButtons[i].addActionListener(this);
            add(colorButtons[i]);
        }
    }

      

    private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}



	@Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < colorButtons.length; i++) {
            if (e.getSource() == colorButtons[i]) {
                colorPanel.setBackground(colors[i]);
                redSlider.setValue(colors[i].getRed());
                greenSlider.setValue(colors[i].getGreen());
                blueSlider.setValue(colors[i].getBlue());
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int redValue = redSlider.getValue();
        int greenValue = greenSlider.getValue(); 
        int blueValue = blueSlider.getValue();
        colorPanel.setBackground(new Color(redValue, greenValue, blueValue));
        redLabel.setText("Red: " + redValue);
        greenLabel.setText("Green: " + greenValue);
        blueLabel.setText("Blue: " + blueValue);
    }

    
}