package hyppypotku.hyppypotku;

import hyppypotku.hyppypotku.dom.Pelaaja;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    private Main() {

        this.setTitle("Hyppypotku"); //asettaa ikkunalle nimen
        this.setSize(1024, 768); //ikkunan koko
        this.setLocationRelativeTo(null); // ikkuna keskelle ruutua
        this.setResizable(false); //käyttäjä ei voi muokata ikkunan kokoa

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }
}
