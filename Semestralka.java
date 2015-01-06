/**
 *
 * @author Milan Davídek <midlan@students.zcu.cz>
 * @author Kateřina Kratochvílová <dtwok8@students.zcu.cz>
 */


public class Semestralka{
    
    public static final String DAT_SOUB_ODDELOVAC = "\t";
    public static final String DAT_SOUB_ODRADKOVANI = "\r\n";
    public static Simulace simulace;
    public static final int RYCHLOST_NAKL_VUZ = 70;
    public static final int RYCHLOST_KAMION = 70;
    public static final int RYCHLOST_CISTERNA = 60;
    public static final int KAPACITA_SUDU_NAKL_VUZ = 90;
    public static final int KAPACITA_SUDU_KAMION = 90;
    public static final int KAPACITA_SUDU_PREKLADISTE = 2000;
    public static final int KAPACITA_CISTERNA = 5000;
    public static final int[] PRAVDEPODOBNOST_OBJEDNANY_POCET = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6};
    public static final int POCET_DNI = 7;
   
    public Semestralka() {
        simulace=new Simulace();
        GUI g= new GUI();
        //simulace.simuluj();

    }
    
      //    private void generujSoubor() {
//        new Generator(500, 500, 4000, 0.05, 2, "nazvy_hospod.txt", "data.txt", "\t", "\r\n");
//        
//        new Misto(Math.random() * this.sirka, Math.random() * this.vyska, this);
//    }
    
    public static void main(String[] args) {
        Semestralka semestralka=new Semestralka();
       
        
       
    }
}
