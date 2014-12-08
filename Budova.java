/**
 *
 * @author Kate
 */
public abstract class Budova {

    public final double x, y;
    public final String nazev;

    public Budova(String nazev, Uzemi u, double x, double y) {
        
        if(nazev == null) {
            throw new IllegalArgumentException("Název budovy nemůže být null");
        }
        
        this.x = x;
        this.y = y;
        this.nazev = nazev;
        
        if (u != null) {
            u.pridejBudovu(this);
        }
    }
}