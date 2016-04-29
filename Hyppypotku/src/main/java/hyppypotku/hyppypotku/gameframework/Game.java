package hyppypotku.hyppypotku.gameframework;

import hyppypotku.hyppypotku.entities.characters.Blockman;
import hyppypotku.hyppypotku.entities.characters.Stickman;
import hyppypotku.hyppypotku.gfx.Assets;
import hyppypotku.hyppypotku.input.KeyManager;
import hyppypotku.hyppypotku.states.GameState;
import hyppypotku.hyppypotku.states.MenuState;
import hyppypotku.hyppypotku.states.State;
import hyppypotku.hyppypotku.states.TutorialState;
import hyppypotku.hyppypotku.window.Window;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Luokan tehtävänä hallinnoida pelin kulkua.
 */
public class Game implements Runnable {

    private Window window;
    private int width, height;
    public String title;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    //characters
    private Stickman stickman;
    private Blockman blockman;
    //states
    private State gameState;
    private State menuState;
    private State tutorialState;
    //keyboard
    private KeyManager keymanager;

    /**
     * Konstruktori.
     *
     * @param title pelin nimi
     * @param width peliruudun leveys
     * @param height peliruudun korkeus
     */
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keymanager = new KeyManager();
        stickman = new Stickman(this, 200, this.height - 100);
        blockman = new Blockman(this, 800, this.height - 100);
    }

    private void init() {
        window = new Window(title, width, height);
        window.getFrame().addKeyListener(keymanager);
        Assets.init();
        gameState = new GameState(this, stickman, blockman);
        menuState = new MenuState(this);
        tutorialState = new TutorialState(this);
        State.setState(menuState);
    }

    private void tick() {
        keymanager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render() { //PIIRTÄÄ RUUDULLE
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().render(g);
        }
        bs.show();
        g.dispose();
    }

    /**
     * Pakotetaan peli pyörimään tasaisesti 60 fps + visuaalinen fps-laskuri
     * konsoliin.
     */
    public void run() {
        init();

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

    /**
     * Pelin käynnistysmetodi.
     */
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Pelin pysäytysmetodi.
     */
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

    public Window getWindow() {
        return window;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isRunning() {
        return running;
    }

    public Graphics getG() {
        return g;
    }

    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

    public State getTutorialState() {
        return tutorialState;
    }

    public KeyManager getKeymanager() {
        return keymanager;
    }

    public Blockman getBlockman() {
        return blockman;
    }

    public Stickman getStickman() {
        return stickman;
    }

}
