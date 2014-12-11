
import java.util.LinkedList;

/**
 *
 * @author midlan_
 */
public class SudovaHospoda extends Hospoda {
    public static final String ZKRATKA = "s";

    private Prekladiste prekladiste;
    private LinkedList<Sud> sudy = new LinkedList<Sud>();

    public SudovaHospoda(String nazev, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
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

    @Override
    public String toString() {
        return super.toString() + Semestralka.DAT_SOUB_ODDELOVAC + ZKRATKA;
    }
}
