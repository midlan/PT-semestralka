/**
 *
 * @author Kate
 */
public abstract class Hospoda extends Budova {
    private final Prekladiste prekladiste;
    
    public Hospoda(Uzemi u, double x, double y) throws SouradniceException {
        super(u, x, y);
        this.prekladiste=null;
    }

    public Prekladiste getPrekladiste() {
        return prekladiste;
    }
    
    
}
