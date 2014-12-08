
/**
 *
 * @author midlan_
 */
public class TankovaHospoda extends Hospoda {
    
    private int objemZasobPiva = 0;
    
    public static final String ZKRATKA = "t";

    public TankovaHospoda(String nazev, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
    }
    
    public void dodatPivo(int objem) {
        this.objemZasobPiva += objem;
    }
}
