
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
    ArrayList<Prekladiste> prekladiste=new ArrayList<Prekladiste>();
    ArrayList<SudovaHospoda> hospodySudove=new ArrayList<SudovaHospoda>();
    ArrayList<TankovaHospoda> hospodyTankove=new ArrayList<TankovaHospoda>();
    //ArrayList<Objednavka> objednavky=new ArrayList<>(); to nepotřebuju ne?
    //prioritní fronta řazená podle datumu a potřebuju se dostat k prvnímu datumju
    
    public Simulace(){ 
        importZeSouboru importDat=new importZeSouboru();
        
        this.prekladiste=importDat.prekladiste;
        this.hospodySudove=importDat.hospodySudove;
        this.hospodyTankove=importDat.hospodyTankove;
        //stejnym způsobem by sme mohli řešit i objednávky .. jo to by vlastně nešlo to musí jít pro každej den .. 
        for (int i = 0; i < prekladiste.size(); i++) {
            System.out.println(prekladiste.get(i).x+", "+prekladiste.get(i).y);
        }
        
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
       int pocetObjednavekNaDen=4000;
       
       double procentualtniRozdeleni[] = { 0.25, 0.25 , 0.2, 0.15 , 0.1, 0.05 };
       int objednavkyOd=8;
       int objednavkydo=16;
       
       
       double delkaUseku=(procentualtniRozdeleni.length/(objednavkydo-objednavkyOd));
       int pocetMinutNaUsek = (int) (60 * delkaUseku);
       
       for(int i=0;i<(objednavkydo-objednavkyOd);i++){
           int pocetObjednavekNaDanyUsek = (int)(pocetObjednavekNaDen*procentualtniRozdeleni[i]);
           double usekOdHodin=8 + i * delkaUseku;
           
           for(int j=0;j<pocetObjednavekNaDanyUsek;j++){
               Random rand=new Random();
               
               int pocetMinutek = i*pocetMinutNaUsek+rand.nextInt(pocetMinutNaUsek);
               
               int minut = (int) (pocetMinutek % 60);
               int hodin = pocetMinutek / 60;
               
               
               Hospoda h=hospody.get(rand.nextInt(hospody.size()));
               Objednavka obj=new Objednavka(h, new GregorianCalendar(datum.get(Calendar.YEAR) , datum.get(Calendar.MONTH), datum.get(Calendar.DAY_OF_MONTH), hodin, minut));
               hospody.remove(h);
               //když bych vzala něco z čeho když si vezmu hodnotu tak se rovnou přemaže tak by to bylo super.. protože pak by
               //se mi nemohlo stát že se ta hospoda objedná víckrát za den
               //úsek po minutě pak si určim kolik to je minut a pak si vygeneruju kolik objednávek se má tu minutu provést??
           }
       }
       
   }
    
   public void simuluj(Calendar datum){
          objednej(datum);
          
          
          
  
          for(int i=0;i<1000;i++){
              
          }
   }
   

    
    
}
