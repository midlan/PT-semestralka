
import java.util.ArrayList;
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
public class Simulace {
    ArrayList<Prekladiste> prekladiste=new ArrayList<Prekladiste>();
    ArrayList<Hospoda> hospody=new ArrayList<Hospoda>();
    ArrayList<Objednavka> objednavky=new ArrayList<>();
    
    public Simulace(){ 
        //musime naplnit proměnnné nahoře
        
    }
    
    public void objednej(Date datum){
        Random rand=new Random();
        int poradi = rand.nextInt(hospody.size()+1);
        Hospoda hospoda = hospody.get(poradi);
        Objednavka objednavka=new Objednavka(hospoda ,datum);
        hospoda.getPrekladiste().Objednej(objednavka);
        System.out.println("Byla vytvořena "+objednavka.toString());
    }
  
   public void skontrolujStavPrekladis(){
       
   }
    
   public void simuluj(Date datum){
          objednej(datum);
          
          
          System.out.println(datum);
  
          for(int i=0;i<1000;i++){
              
          }
   }
   

    
    
}
