
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Kate
 */
public class Prekladiste extends Budova {

    private final int kapacita = 2000;
    private int pocetPlnychSudu;
    //private final ArrayList<Hospoda> zasobovaneHospody = new ArrayList<Hospoda>();
    private Queue<Objednavka> objednavky = new PriorityQueue<Objednavka>();
            
    public Prekladiste(Uzemi u, double x, double y) throws SouradniceException {
        super(u, x, y);
        this.pocetPlnychSudu=2000;
    }
    
    public void Objednej(Objednavka objednavka){
        //zkontroluj jestli se rovnou nedá hodit k nějakýmu autu
        objednavky.add(objednavka);
    }
    
    public void vysliVuz(){
        if(objednavky.isEmpty()){
            System.out.println("Chyba překladiště nemá žádné objednávky ve frontě.");
            return;
        }
        //musime odečíst sudy
        //musime naložit auto
        //a objednavku vyndat s fronty a předat ji vozidlu
        //nevim jestli neni nejednodušší to auto naložit plný, páč tam se nic nepíše o tom že by se to nesmělo ..
        //možná nejlepší hned dát naložit auto a pak se jen koukat při přidání objednávky jestli náhodou tam neni nějaký auto s volnýma sudama navíc, nebo než se naloží 
        
    }
    
    
    
    
}
