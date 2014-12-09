
import java.util.ArrayList;
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
    
    public void objednej(Hospoda hospoda){
        
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
   
   /**
        Zkopiruje pole a promycha jeho pořadi
        @param hospody pole všech hospod
        @return hospody2 zkopirovane a promychane pole
   */
   public Hospoda[] promychejPole(Hospoda[] hospody){
        Hospoda[] hospody2 = new Hospoda[hospody.length];
        System.arraycopy(hospody, 0, hospody2, 0, hospody.length); 
        return hospody2;
   }
   
   
   public void vygenerujObjednavky(Hospoda[] hospody){
       Hospoda[] hospodyPromychane=promychejPole(hospody);

       int pocetObjednavekNaDen=4000;
       
       double [] procentualtniRozdeleni = { 0.25, 0.25 , 0.2, 0.15 , 0.1, 0.05 };
       int objednavkyOd=cas+8*60; //od osmi
       int objednavkydo=cas+16*60; //do 4 odpoledne
   
       double delkaUseku=(procentualtniRozdeleni.length/(objednavkydo-objednavkyOd));
       int pocetMinutNaUsek = (int) (60 * delkaUseku);
      
       int indexHospody=0;
       for(int i=0;i<(objednavkydo-objednavkyOd);i++){
           int pocetObjednavekNaDanyUsek = (int)(pocetObjednavekNaDen*procentualtniRozdeleni[i]);
           double usekOdHodin=8 + i * delkaUseku;
           
           for(int j=0;j<pocetObjednavekNaDanyUsek;j++){
               Random rand=new Random();
               
               int pocetMinutek = i*pocetMinutNaUsek+rand.nextInt(pocetMinutNaUsek);
               
               Objednavka obj=new Objednavka(hospodyPromychane[indexHospody], pocetMinutek);
               indexHospody++;
               
               //když bych vzala něco z čeho když si vezmu hodnotu tak se rovnou přemaže tak by to bylo super.. protože pak by
               //se mi nemohlo stát že se ta hospoda objedná víckrát za den
               //úsek po minutě pak si určim kolik to je minut a pak si vygeneruju kolik objednávek se má tu minutu provést??
         }
       }
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
