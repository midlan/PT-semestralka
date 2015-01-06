
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Kate
 */
public class Prekladiste extends Budova implements IUlozisteSudu {
    
    public static final String ZKRATKA = "pp";

    private final int kapacitaSudu;
    
    private final Queue<Objednavka> objednavky = new LinkedList<Objednavka>();
    private final Queue<NakladniVuz> nakladniVozy = new LinkedList<NakladniVuz>();
    private final Queue<Sud> plneSudy = new LinkedList<Sud>();
    private final Queue<Sud> prazdneSudy = new LinkedList<Sud>();
    private final Pivovar pivovar;

    //todo překladiště potřebuje pivovar
    public Prekladiste(String nazev, int kapacitaSudu, Pivovar p, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
        this.kapacitaSudu = kapacitaSudu;
        this.pivovar = p;
    }
    
    public void Objednej(Objednavka objednavka){
        //zkontroluj jestli se rovnou nedá hodit k nějakýmu autu
        objednavky.add(objednavka);
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
    
    public Sud odevzdatPrazdnySud() {
        try {
            return this.prazdneSudy.remove();
        }
        catch(NoSuchElementException e) {
            return null;
        }
    }
    
    public void vysliVuz(){
        if(objednavky.isEmpty()){
            System.out.println("Chyba překladiště nemá žádné objednávky ve frontě.");
            return;
        }
        for(int i=0;i<nakladniVozy.size();i++){
            
        }
        //musime odečíst sudy
        //musime naložit auto
        //a objednavku vyndat s fronty a předat ji vozidlu
        //nevim jestli neni nejednodušší to auto naložit plný, páč tam se nic nepíše o tom že by se to nesmělo ..
        //možná nejlepší hned dát naložit auto a pak se jen koukat při přidání objednávky jestli náhodou tam neni nějaký auto s volnýma sudama navíc, nebo než se naloží 
        
    }

    @Override
    public String toString() {
        return super.toString() + Semestralka.DAT_SOUB_ODDELOVAC + ZKRATKA;
    }
}
