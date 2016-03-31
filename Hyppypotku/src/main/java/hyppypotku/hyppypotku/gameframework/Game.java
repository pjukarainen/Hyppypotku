package hyppypotku.hyppypotku.gameframework;

import hyppypotku.hyppypotku.gfx.ImageLoader;
import hyppypotku.hyppypotku.window.Window;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private Window window;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    
    private BufferedImage testImage;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        window = new Window(title, width, height);
        testImage = ImageLoader.loadImage("/textures/testi.png");
    }

    private void tick() {

    }

    private void render() { //PIIRTÄÄ RUUDULLE
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
		//piirrä

        g.drawImage(testImage, 20, 20, null);
        
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        while (running) {
            tick();
            render();
        }

        stop();

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
