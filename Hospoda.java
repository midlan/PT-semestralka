
/**
 *
 * @author Kate
 */
public abstract class Hospoda extends Budova {

    private final Prekladiste prekladiste;

    public Hospoda(String nazev, Uzemi u, Prekladiste prekladiste, double x, double y) {
        super(nazev, u, x, y);
        this.prekladiste = prekladiste;
    }
}
