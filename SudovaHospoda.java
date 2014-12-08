
import java.util.LinkedList;

/**
 *
 * @author midlan_
 */
public class SudovaHospoda extends Hospoda {

    public static final String ZKRATKA = "s";

    private LinkedList<Sud> sudy = new LinkedList<Sud>();

    public SudovaHospoda(String nazev, Uzemi u, Prekladiste prekladiste, double x, double y) {
        super(nazev, u, prekladiste, x, y);
    }
    
    public void dodatSud(Sud s) {
        
        if(!s.isPlny()) {
            throw new IllegalArgumentException("Dodat lze jen plný sud");
        }
        
        sudy.add(s);
    }
    
    public Sud vratitSud() {
        Sud s = sudy.peek();
        
        if(s != null && s.isPlny()) {
            throw new IllegalStateException("Už nelze vrátit žádný sud, hospoda už má jen plné sudy");
        }
        
        return sudy.poll();
    }
}
