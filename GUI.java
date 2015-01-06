import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Kate
 */
public class GUI extends JFrame {
    private final JPanel tlacitka = new JPanel();
    public JTextPane textArea = new JTextPane();

    /*

     */
    public GUI() {
        this.setTitle("Simulace pivovaru");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        addButton();
        addTextArea();
        this.pack();
        textArea.setText("ahoj");
    }
    
    
    public void addButton(){
        JButton but1 = new JButton("Dalsi hodina");
        JButton but2 = new JButton("Konec dne");
        JButton but3 = new JButton("Na konec simulace");
        JButton but4 = new JButton("Konec programu");
        
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        
        tlacitka.add(but1);
        this.add(tlacitka, BorderLayout.SOUTH);
    }
    
    public void addTextArea() {
        textArea.setEditable(false);
        textArea.setContentType("text/html");
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(400, 400));
        this.add(scroll);
    }
    
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
