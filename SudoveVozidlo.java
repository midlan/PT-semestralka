
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author midlan
 */
public abstract class SudoveVozidlo extends Vozidlo implements IUlozisteSudu {
    
    private final int kapacitaSudu;
    private final Queue<Sud> prazdneSudy = new LinkedList<Sud>();
    private final Queue<Sud> plneSudy = new LinkedList<Sud>();

    public SudoveVozidlo(int rychlost, int kapacitaSudu) {
        super(rychlost);
        this.kapacitaSudu = kapacitaSudu;
    }

    @Override
    public void ulozitSud(Sud s) {
        if(this.plneSudy.size() + this.prazdneSudy.size() >= this.kapacitaSudu) {
            throw new IllegalStateException("Už nelze uskladnit žádné sudy, kapacita je vyčerpána.");
        }
        
        if(s.isPlny()) {
            this.plneSudy.add(s);
        }
        else {
            this.prazdneSudy.add(s);
        }
    }
    
}
