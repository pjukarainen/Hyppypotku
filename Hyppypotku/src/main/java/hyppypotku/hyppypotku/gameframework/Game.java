package hyppypotku.hyppypotku.gameframework;

import hyppypotku.hyppypotku.gfx.Assets;
import hyppypotku.hyppypotku.gfx.ImageLoader;
import hyppypotku.hyppypotku.gfx.SpriteSheet;
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

    public Game(String title, int width, int height) {
        if (width <= 0 || height <= 0) {
            System.out.println("Insert positive resolution values please");

        }
        this.width = width;
        this.height = height;
        this.title = title;

    }

    private void init() {
        window = new Window(title, width, height);
        Assets.init();

    }

    int x = 0;

    private void tick() {
        x++;

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

        g.drawImage(Assets.hpfull, 30, 30, null);
        g.drawImage(Assets.hpzero, 350, 30, null);
        g.drawImage(Assets.player, 60 + x, 200, null);
        g.drawImage(Assets.roundfull, 100, 80, null);
        g.drawImage(Assets.roundempty, 300, 80, null);
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        //pakotetaan peli pyörimään tasaisesti 60 fps + visuaalinen fps-laskuri konsoliin
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        long timer = 0;
        long ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
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

    @Override
    public String toString() {
        return this.title + " " + this.width + " x " + this.height;
    }

    public boolean isRunning() {
        return running;
    }

    public Window getWindow() {
        return window;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Thread getThread() {
        return thread;
    }

    public Graphics getG() {
        return g;
    }

}
