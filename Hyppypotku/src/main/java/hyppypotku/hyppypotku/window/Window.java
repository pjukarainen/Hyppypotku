package hyppypotku.hyppypotku.window;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int widht;
    private int height;

    public Window(String title, int widht, int height) {
        this.title = title;
        this.widht = widht;
        this.height = height;

        createWindow();
    }

    private void createWindow() {
        frame = new JFrame(title);
        frame.setSize(widht, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(widht, height));
        canvas.setMaximumSize(new Dimension(widht, height));
        canvas.setMinimumSize(new Dimension(widht, height));

        frame.add(canvas);
        frame.pack();

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

    public int getHeight() {
        return height;
    }

    public int getWidht() {
        return widht;
    }

    public String getTitle() {
        return title;
    }
    
    

    @Override
    public String toString() {
        return this.title + " " + this.widht + " x " + this.height;  
    }

}
