/**
 *
 * @author Kate
 */
public class Pivovar extends Budova {
    
    public final double denniProdukce;
    private Prekladiste[] prekladiste;

    public Pivovar(Uzemi u, double x, double y, double denniProdukce) throws SouradniceException {
        super(u, x, y);
        this.denniProdukce = denniProdukce;
    }
}