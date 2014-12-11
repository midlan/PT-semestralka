
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author Kate
 */
public abstract class Budova {

    private final double x, y;
    private final Uzemi uzemi;
    private final String nazev;

    private final List<Cesta> cesty = new ArrayList<Cesta>();
    
    private static final Map<String, Budova> budovy = new HashMap<String, Budova>();

    public Budova(String nazev, Uzemi u, double x, double y) {

        if (nazev == null) {
            throw new IllegalArgumentException("Název nemůže být null");
        }

        if (u == null) {
            throw new IllegalArgumentException("Území nemůže být null");
        }

        if (!u.sourUvnitr(x, y)) {
            throw new IllegalArgumentException("Souřadnice jsou mimo území");
        }

        this.x = x;
        this.y = y;
        this.nazev = nazev;
        this.uzemi = u;
        this.uzemi.pridejBudovu(this);
        budovy.put(nazev, this);
    }
    
    public double vzdalenost(double x, double y) {
        
        if(!this.uzemi.sourUvnitr(x, y)) {
            throw new IllegalArgumentException("Souřadnice jsou mimo území, ve kterém je tato budova");
        }
        
        return this.uzemi.vzdalenost(this.x, this.y, x, y);
    }

    public double vzdalenost(Budova b) {

        if (b == null) {
            throw new IllegalArgumentException("Budova je null");
        }

        if (!this.uzemi.obsahujeBudovu(b)) {
            throw new IllegalArgumentException("Budova je v z jiného území");
        }

        return this.vzdalenost(b.x, b.y);
    }

    public Budova[] nejblizsiBudovy(Budova b, int pocet) {

        if (!this.uzemi.obsahujeBudovu(b)) {
            throw new IllegalArgumentException("Budova je v z jiného území");
        }

        return this.uzemi.nejblizsiBudovy(this.x, this.y, pocet);
    }

    public void pridejCestu(Budova kam) {

        if (kam == null) {
            throw new IllegalArgumentException("Budova je null");
        }

        this.cesty.add(new Cesta(kam, this.vzdalenost(kam)));
    }

    public Cesta[] getCesty() {
        return this.cesty.toArray(new Cesta[this.cesty.size()]);
    }
    
    @Override
    public String toString() {
        return String.format(Locale.ROOT, this.nazev.trim() + Semestralka.DAT_SOUB_ODDELOVAC + "%.2f" + Semestralka.DAT_SOUB_ODDELOVAC + "%.2f", this.x, this.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getNazev() {
        return nazev;
    }
    
    public static Budova najdi(String nazev) {
        return budovy.get(nazev);
    }
}
