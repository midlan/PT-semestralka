
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
    /*
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

    
    */
}
