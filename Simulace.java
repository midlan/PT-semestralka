
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Simulace extends JPanel{
    private JLabel texty;
    Prekladiste[] prekladiste;
    SudovaHospoda[] hospodySudove;
    TankovaHospoda[] hospodyTankove;
    int cas; //v minutach
    //ArrayList<Objednavka> objednavky=new ArrayList<>(); to nepotřebuju ne?
    //prioritní fronta řazená podle datumu a potřebuju se dostat k prvnímu datumju
    

    
    public Simulace(){ 
        
        ImportZeSouboru importDat=new ImportZeSouboru();
        
        this.prekladiste=importDat.getPrekladiste();
        this.hospodySudove=importDat.getSudoveHospody();
        this.hospodyTankove=importDat.getTankoveHospody();
        //stejnym způsobem by sme mohli řešit i objednávky .. jo to by vlastně nešlo to musí jít pro každej den .. 
        
        
        this.setPreferredSize(new Dimension(800, 300));
 
        texty=new JLabel();
        add(texty);
        
        JPanel komponenty;
        JButton sudovaHospodaButon;
        JButton tankovaHospodaButon;
        JButton tik;
        
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        
        komponenty = new JPanel();
        add(komponenty);

        sudovaHospodaButon = new JButton("Objednavka pro sudovou hospodu ");
        komponenty.add(sudovaHospodaButon);
        
        tankovaHospodaButon = new JButton("Objednavka pro tankovou hospod. ");
        komponenty.add(tankovaHospodaButon);
        
        tik = new JButton("Tik ");
        komponenty.add(tik);

    }
    
    public void objednej(){
        /*
        Random rand=new Random();
        int poradi = rand.nextInt(hospodySudove.length+hospodyTankove.length+1); 
        Hospoda hospoda;
        if(poradi>hospodySudove.length){
             hospoda = hospodyTankove[poradi-hospodySudove.length];
        }
        else{
            Hospoda hospoda = hospody.get(poradi);
        }
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
   
   
   public void vygenerujObjednavky(){
       int objednavekNaDen=4000;
       
       for(int i=0;i<objednavekNaDen;i++){
           
       }
       
   }
   
   public void vypisCas(){
       int hodin = (this.cas/60%24);
       int den=this.cas/60/24;
       
      texty.setText("Den: "+den+" hodina: "+hodin);
   }
   
   public void simuluj(){
         // objednej(datum);

       Budova budova=Budova.najdi("Cuba Liberta");
 
       System.out.println(budova.getNazev()+" - ");
       Cesta [] cesty=budova.getCesty();
       
       for (int i = 0; i < cesty.length; i++) {
           System.out.println(cesty[i].getKam());
       }
      
         /*
         for(int i=0;i<hospodyTankove.length;i++){
             System.out.print(hospodyTankove[i].getNazev());
                System.out.println(hospodyTankove[i].getCesty().toString());
         }
                 */
       
         while(cas < 7*24*60){
             vypisCas();
             cas=cas+60; 
         } 
   }   
}
