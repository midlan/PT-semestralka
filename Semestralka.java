



/**
 *
 * @author Milan Davídek <midlan@students.zcu.cz>
 * @author Kateřina Kratochvílová <dtwok8@students.zcu.cz>
 */

import javax.swing.JFrame;

public class Semestralka extends JFrame {
    
    public static final String DAT_SOUB_ODDELOVAC = "\t";
    public static final String DAT_SOUB_ODRADKOVANI = "\r\n";
    
//    private void generujSoubor() {
//        new Generator(500, 500, 4000, 0.05, 2, "nazvy_hospod.txt", "data.txt", "\t", "\r\n");
//        
//        new Misto(Math.random() * this.sirka, Math.random() * this.vyska, this);
//    }
    
    public Semestralka() {
        this.setTitle("Časovač");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Casovac panel = new Casovac();
        this.add(panel);

        this.pack();
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new Semestralka().setVisible(true);
       
        
       
    }
}
