
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kate
 */
public class GUI extends JFrame {

    private final JPanel JPanel = new JPanel();

    /*

     */
    public GUI() {
        this.setTitle("Simulace pivovaru");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //Semestralka.simulace.metoda();
    
    public void Dlaisdwn(){
        Semestralka.simulace.vygenerujObjednavky();
    }
}
