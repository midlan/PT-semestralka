
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Kate
 */
public class Uzemi {

    private final double sirka;
    private final double vyska;

    private final HashSet<Budova> budovy = new HashSet<Budova>();

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
    
    public boolean budovaPobliz(double x, double y, double vzdalenost) {
        
        Iterator<Budova> it = budovy.iterator();
         
        while (it.hasNext()) {
            if(it.next().vzdalenost(x, y) <= vzdalenost) {
                return true;
            }
        }
        
        return false;
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
    
    public double vzdalenost(double x1, double y1, double x2, double y2) {
        
        if(!this.sourUvnitr(x2, y2) || !this.sourUvnitr(x1, y1)) {
            throw new IllegalArgumentException("Souřadnice jsou mimo toto území");
        }
        
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    @Override
    public String toString() {
        return this.sirka + Semestralka.DAT_SOUB_ODDELOVAC + this.vyska;
    }

    public double getSirka() {
        return sirka;
    }

    public double getVyska() {
        return vyska;
    }
}
