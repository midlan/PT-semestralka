
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kate
 */
public class Uzemi {

    public final double sirka;
    public final double vyska;

    private final Set<Budova> budovy = new HashSet<Budova>();

    public Uzemi(double sirka, double vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public boolean sourUvnitr(double x, double y) {
        return x >= 0 && y >= 0 && x <= this.sirka && y <= this.vyska;
    }

    public void pridejBudovu(Budova b) {

        if (!this.sourUvnitr(b.getX(), b.getY())) {
            throw new IllegalArgumentException("Souřadnice budovy jsou mimo toto území");
        }

        this.budovy.add(b);
    }

    public boolean obsahujeBudovu(Budova b) {
        return this.budovy.contains(b);
    }

    public Budova[] nejblizsiBudovy(double x, double y, int pocet) {

        if (!this.sourUvnitr(x, y)) {
            throw new IllegalArgumentException("Souřadnice jsou mimo toto území");
        }

        ArrayList<Budova> budovy = new ArrayList<Budova>();

        //todo získat budovy
        return (Budova[]) budovy.toArray();
    }

    public Budova[] getBudovy() {
        return (Budova[]) this.budovy.toArray();
    }

    @Override
    public String toString() {
        return this.sirka + Semestralka.DAT_SOUB_ODDELOVAC + this.vyska;
    }
}
