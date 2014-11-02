
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class NakladniVuz extends Vozidlo{
    private final int rychlost=70;
    private final int kapacita=30;
    private ArrayList<Sud> sudy=new ArrayList<Sud>();
    
    public NakladniVuz(int x, int y) {
        super(x, y);
    }
    
    public void nalozitSudy(int pocet){
        
        // Naložení/vyložení jednoho sudu trvá 5 minut 
    }
    
    public void vylozitSudy(int pocet){
    
    }
    
}