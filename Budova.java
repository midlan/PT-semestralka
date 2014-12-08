
import java.util.ArrayList;

/**
 *
 * @author Kate
 */
public abstract class Budova {

    private final double x, y;
    private final Uzemi uzemi;
    private final String nazev;

    private final ArrayList<Cesta> cesty = new ArrayList<Cesta>();

    public static final String ZKRATKA = null;

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
    }

    public double vzdalenost(Budova b) {

        if (b == null) {
            throw new IllegalArgumentException("Budova je null");
        }

        if (!this.uzemi.obsahujeBudovu(b)) {
            throw new IllegalArgumentException("Budova je v z jiného území");
        }

        return Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
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
        return (Cesta[]) this.cesty.toArray();
    }

    @Override
    public String toString() {
        return this.nazev.trim() + Semestralka.DAT_SOUB_ODDELOVAC + this.x + Semestralka.DAT_SOUB_ODDELOVAC + this.y + Semestralka.DAT_SOUB_ODDELOVAC + ZKRATKA;
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
}
