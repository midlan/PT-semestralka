
import java.util.HashSet;

/**
 *
 * @author Kate
 */
public class Pivovar extends Budova {
    
    public static final String ZKRATKA = "p";
    
    private final int denniProdukce;
    private HashSet<Prekladiste> prekladiste = new HashSet<Prekladiste>();

    public Pivovar(String nazev, int denniProdukce, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
        this.denniProdukce = denniProdukce;
    }

    @Override
    public String toString() {
        return super.toString() + Semestralka.DAT_SOUB_ODDELOVAC + denniProdukce;
    }
}
