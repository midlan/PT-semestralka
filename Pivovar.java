
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kate
 */
public class Pivovar extends Budova {
    
    public static final String ZKRATKA = "p";
    
    private final int denniProdukce;

    public Pivovar(String nazev, int denniProdukce, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
        this.denniProdukce = denniProdukce;
    }
    
    public void naplnitSud(Sud s) {
        
        if(s.isPlny()) {
            throw new IllegalArgumentException("Sud už je plný, nelze ho znovu naplnit");
        }
        
        s.setPlny(true);
    }
    
    @Override
    public String toString() {
        return super.toString() + Semestralka.DAT_SOUB_ODDELOVAC + ZKRATKA + Semestralka.DAT_SOUB_ODDELOVAC + denniProdukce;
    }
}
