



/**
 *
 * @author Milan Davídek <midlan@students.zcu.cz>
 * @author Kateřina Kratochvílová <dtwok8@students.zcu.cz>
 */

import javax.swing.JFrame;

public class Semestralka extends JFrame {
    
    public static final String DAT_SOUB_ODDELOVAC = "\t";
    public static final String DAT_SOUB_ODRADKOVANI = "\r\n";
    
    Simulace simulace;
    
//    private void generujSoubor() {
//        new Generator(500, 500, 4000, 0.05, 2, "nazvy_hospod.txt", "data.txt", "\t", "\r\n");
//        
//        new Misto(Math.random() * this.sirka, Math.random() * this.vyska, this);
//    }
    
    public Semestralka() {
        this.simulace=new Simulace();
    }
    
    public void spustSimulaci(){
        simulace.simuluj();
    }
    
    
    public static void main(String[] args) {
        Semestralka semestralka=new Semestralka();
        semestralka.spustSimulaci();
        
       
        
       
    }
}
