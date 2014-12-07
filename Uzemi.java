
/**
 *
 * @author Kate
 */
public class Uzemi {

    public final double sirka;
    public final double vyska;

    public Uzemi(double sirka, double vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public boolean souradniceUvnitr(double x, double y) {
        return x >= 0 && y >= 0 && x <= this.sirka && y <= this.vyska;
    }

    public Misto vytvorMisto(double x, double y) throws Exception {
        return new Misto(x, y, this);
    }
    
    public Misto vytvorMisto() throws Exception {
        return new Misto(Math.random() * this.sirka, Math.random() * this.vyska, this);
        //todo je generování správně?
    }
}
