/**
 *
 * @author Kate
 */
public class Budova {

    public final double x, y;

    public Budova(Uzemi u, double x, double y) throws SouradniceException {
        
        if(!u.souradniceUvnitr(x, y))
            throw new SouradniceException();
        
        this.x = x;
        this.y = y;
    }
}
