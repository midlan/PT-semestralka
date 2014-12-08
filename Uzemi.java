
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Kate
 */
public class Uzemi {

    public final double sirka;
    public final double vyska;

    private final HashSet<Budova> budovy = new HashSet<Budova>();

    public Uzemi(double sirka, double vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public boolean sourUvnitr(double x, double y) {
        return x >= 0 && y >= 0 && x <= this.sirka && y <= this.vyska;
    }

    public void pridejBudovu(Budova b) {

        if (!this.sourUvnitr(b.x, b.y)) {
            throw new IllegalArgumentException("Souřadnice budovy jsou mimo toto území");
        }

        budovy.add(b);
    }

    public double vzdalenost(Budova a, Budova b) {

        if (a == null || b == null) {
            throw new IllegalArgumentException("Jedna z budov je null");
        }

        if (!budovy.contains(a) || !budovy.contains(b)) {
            throw new IllegalArgumentException("Jedna z budov není v tomto území.");
        }

        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public ArrayList<Budova> nejblizsiBudovy(double x, double y, int pocet) {

        if (!this.sourUvnitr(x, y)) {
            throw new IllegalArgumentException("Souřadnice jsou mimo toto území");
        }
        //todo získat budovy
        return new ArrayList<Budova>();
    }

    public ArrayList<Budova> nejblizsiBudovy(Budova b, int pocet) {

        if (!this.budovy.contains(b)) {
            throw new IllegalArgumentException("Budova nepatří do tohoto území");
        }

        return this.nejblizsiBudovy(b.x, b.y, pocet);
    }
}
