package hyppypotku.hyppypotku.window;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Ikkuna-luokka, joka asettaa ikkunalle halutut ominaisuudet.
 */
public class Window {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int widht;
    private int height;

    /**
     * Konstruktori.
     *
     * @param title pelin nimi
     * @param widht ikkunan leveys
     * @param height ikkunan korkeus
     */
    public Window(String title, int widht, int height) {
        this.title = title;
        this.widht = widht;
        this.height = height;

        setupCanvas();
        createWindow();
    }

    private void createWindow() {
        frame = new JFrame(title);
        frame.setSize(widht, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(canvas);
        frame.pack();

    }

    private void setupCanvas() {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(widht, height));
        canvas.setMaximumSize(new Dimension(widht, height));
        canvas.setMinimumSize(new Dimension(widht, height));
        canvas.setFocusable(false);
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
