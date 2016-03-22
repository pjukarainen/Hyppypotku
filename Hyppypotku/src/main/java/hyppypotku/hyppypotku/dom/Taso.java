
package hyppypotku.hyppypotku.dom;

import javax.swing.JPanel;

public class Taso extends JPanel{
    
    private Pelaaja pelaajaYksi;
    private Pelaaja pelaajaKaksi;
    private int aika;

    public Taso(Pelaaja pelaajaYksi, Pelaaja pelaajaKaksi, int aika) {
        this.pelaajaYksi = pelaajaYksi;
        this.pelaajaKaksi = pelaajaKaksi;
        this.aika = aika;
    }
    
    
}
