
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;
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
    Prekladiste[] prekladiste;
    SudovaHospoda[] hospodySudove;
    TankovaHospoda[] hospodyTankove;
    int cas; //v minutach
    //ArrayList<Objednavka> objednavky=new ArrayList<>(); to nepotřebuju ne?
    //prioritní fronta řazená podle datumu a potřebuju se dostat k prvnímu datumju
    
    public Simulace(){ 
        
        importZeSouboru importDat=new importZeSouboru();
        
        this.prekladiste=importDat.getPrekladiste();
        this.hospodySudove=importDat.getSudoveHospody();
        this.hospodyTankove=importDat.getTankoveHospody();
        //stejnym způsobem by sme mohli řešit i objednávky .. jo to by vlastně nešlo to musí jít pro každej den .. 
        
       
    }
    
    public void objednej(Calendar datum){
        /*
        Random rand=new Random();
        int poradi = rand.nextInt(hospody.size()+1); 
        Hospoda hospoda = hospody.get(poradi);
        Objednavka objednavka=new Objednavka(hospoda ,datum);
        hospoda.getPrekladiste().Objednej(objednavka);
        System.out.println("Byla vytvořena "+objednavka.toString());
                */
    }
  
   public void skontrolujAkce(){
       //možná lepší přejmenovat a upravit na skontroluj akce na prioritní frontě
       // že by sme udělali výčtovej typ na stav nakládání, na cestě, volné ????
   }
   
   public void vygenerujObjednavky(Calendar datum, ArrayList<Hospoda> hospody ){

       
   }
   
   public void vypisCas(){
       System.out.println(this.cas);
       int hodin = (this.cas/60%24);
       int den=this.cas/60/24;
       
       System.out.println("Den: "+den+" hodina: "+hodin);
   }
   
   public void simuluj(){
         // objednej(datum);
         while(cas < 7*24*60){
             vypisCas();
             cas=cas+60; 
         } 
          
          
         
      
   }
   

    
    
}
