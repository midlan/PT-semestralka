
import java.util.ArrayList;

/**
 *
 * @author Kate
 */
public class Prekladiste extends Budova {

    private final int kapacita = 2000;
    private final ArrayList<Hospoda> zasobovaneHospody = new ArrayList<Hospoda>();

    public Prekladiste(Uzemi u, double x, double y) throws SouradniceException {
        super(u, x, y);
    }
}
