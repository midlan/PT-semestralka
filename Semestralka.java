



/**
 *
 * @author Milan Davídek <midlan@students.zcu.cz>
 * @author Kateřina Kratochvílová <dtwok8@students.zcu.cz>
 */


    /**
     * @param args the command line arguments
     */
            import javax.swing.JFrame;

public class Semestralka extends JFrame {

    public Semestralka() {
        this.setTitle("Časovač");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Simulace panel = new Simulace();
        this.add(panel);

        this.pack();
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new Semestralka().setVisible(true);
 
    }
}
