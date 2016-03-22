
package hyppypotku.hyppypotku.dom;


public class Pelaaja {
    
    private String nimi;
    private boolean elossa;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.elossa = true;
    }

    public String getNimi() {
        return nimi;
    }

    public void setElossa(boolean elossa) {
        this.elossa = elossa;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
    
    
    
    
    
}
