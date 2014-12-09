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
    private int minut;
    private int mnozstvi;
    // private Calendar dovezeno

    public Objednavka(Hospoda hospoda, int minut) {
         Random rand= new Random();
         this.mnozstvi = rand.nextInt(6) + 1;
         this.hospoda=hospoda;
         this.minut=minut;  
    }
    
    public Objednavka(Hospoda hospoda, int minut, int mnozstvi) {
        this.hospoda = hospoda;
        this.minut = minut;
        this.mnozstvi = mnozstvi;
    }

    @Override
    public String toString() {
        return "Objednavka: "+minut+" - "+this.hospoda+" množství: "+this.mnozstvi; 
    }
    
    

        
        
       
    
}
