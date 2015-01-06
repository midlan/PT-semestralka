
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Kate
 */
public class Pivovar extends Budova implements IUlozisteSudu {
    
    public static final String ZKRATKA = "p";
    
    private final int denniProdukce;
    private final Queue<Sud> prazdneSudy = new LinkedList<Sud>();

    public Pivovar(String nazev, int denniProdukce, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
        this.denniProdukce = denniProdukce;
    }

    @Override
    public void ulozitSud(Sud s) {
        
        if(s.isPlny()) {
            throw new IllegalArgumentException("Do pivovaru lze vracet jen prázdné sudy.");
        }
        
        prazdneSudy.add(s);
    }
    
    @Override
    public String toString() {
        return super.toString() + Semestralka.DAT_SOUB_ODDELOVAC + ZKRATKA + Semestralka.DAT_SOUB_ODDELOVAC + denniProdukce;
    }
}
