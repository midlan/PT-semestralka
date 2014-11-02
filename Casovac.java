
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kateřina Kratochvílová
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class Casovac extends JPanel {
    private JLabel navesti;
    private int minuta;
    private int den;
    private int hodina;
    private Timer casovac;
    private Simulace simulace;

    public Casovac() {
        this.minuta = 0;
        this.den=1;
        this.hodina=0;
        this.setPreferredSize(new Dimension(800, 300));

        navesti = new JLabel();
        this.add(navesti);
        navesti.setText(String.valueOf(minuta));
        System.out.println("run");
        PosluchacCasovace posluchac = new PosluchacCasovace();
        //po kolika milisekundách má generovat událost, druhý parametr poslouchač kterému bude tyto události zasílatkal
        //10 je po vteřině
        casovac = new Timer(10, posluchac);
       
        casovac.start(); 
        simulace=new Simulace();
    }

    @Override //proč mi to nefunguje.. :-x
    public String toString() {
        return ("Den: "+String.valueOf(den)+" "+String.valueOf(hodina)+" : "+String.valueOf(minuta));
    }
    
    /*
        Zastavi časovač;
    */
    public void stop(){
        casovac.stop();
    }
    
    /* 
        Upravi cas do pryslusneho formatu na hodiny, dny, minuty 
    */
    public void upravCas(){
         minuta++;
         
        if(minuta >= 60){
            hodina++;
            
            if(hodina>=24){
                den++;
                hodina=0;
            }
                
            minuta=0;
        }
    }
    
    private class PosluchacCasovace implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            minuta++;
            
            upravCas();
            
            if(den>=2){
                stop();
            }
            
            navesti.setText("Den: "+String.valueOf(den)+" "+String.valueOf(hodina)+" : "+String.valueOf(minuta));
            
            Calendar datum=new GregorianCalendar(2014, 11, den, hodina, minuta);
            simulace.simuluj(datum);
            
        }
    }
}