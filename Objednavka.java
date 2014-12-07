import java.util.Calendar;
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
    private Calendar datum;
    private int mnozstvi;
    // private Calendar dovezeno

    public Objednavka(Hospoda hospoda, Calendar datum) {
         Random rand= new Random();
         this.mnozstvi = rand.nextInt(6) + 1;
         this.hospoda=hospoda;
         this.datum=datum;  
    }
    
    public Objednavka(Hospoda hospoda, Calendar datum, int mnozstvi) {
        this.hospoda = hospoda;
        this.datum = datum;
        this.mnozstvi = mnozstvi;
    }

    @Override
    public String toString() {
        return "Objednavka: "+datum+" - "+this.hospoda+" množství: "+this.mnozstvi; 
    }
    
    

        
        
       
    
}
