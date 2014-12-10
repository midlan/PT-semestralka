
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Kate
 */
public class Prekladiste extends Budova {
    
    public static final String ZKRATKA = "pp";

    private final int kapacita = 2000;
    private int pocetPlnychSudu;
    //private final ArrayList<Hospoda> zasobovaneHospody = new ArrayList<Hospoda>();
    private Queue<Objednavka> objednavky = new PriorityQueue<Objednavka>();
    ArrayList<NakladniVuz> nakladniVozy = new ArrayList<NakladniVuz>();

    //todo překladiště potřebuje pivovar
    public Prekladiste(String nazev, Uzemi u, double x, double y) {
        super(nazev, u, x, y);
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
        for(int i=0;i<nakladniVozy.size();i++){
            
        }
        //musime odečíst sudy
        //musime naložit auto
        //a objednavku vyndat s fronty a předat ji vozidlu
        //nevim jestli neni nejednodušší to auto naložit plný, páč tam se nic nepíše o tom že by se to nesmělo ..
        //možná nejlepší hned dát naložit auto a pak se jen koukat při přidání objednávky jestli náhodou tam neni nějaký auto s volnýma sudama navíc, nebo než se naloží 
        
    }
  
}
