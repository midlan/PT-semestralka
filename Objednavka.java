
import java.util.Date;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Objednavka {
    private Hospoda hospoda;
    private Date datum;
    private int mnozstvi;
    // private Date dovezeno

    public Objednavka(Hospoda hospoda, Date datum) {
         Random rand= new Random();
         this.mnozstvi = rand.nextInt(6) + 1;
         this.hospoda=hospoda;
         this.datum=datum;  
    }
    
    public Objednavka(Hospoda hospoda, Date datum, int mnozstvi) {
        this.hospoda = hospoda;
        this.datum = datum;
        this.mnozstvi = mnozstvi;
    }

    @Override
    public String toString() {
        return "Objednavka: "+datum+" - "+this.hospoda+" množství: "+this.mnozstvi; 
    }
    
    

        
        
       
    
}
