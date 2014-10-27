/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Uzemi {

    final double sirka;
    final double vyska;

    public Uzemi(double sirka, double vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }
    
    public boolean souradniceUvnitr(double x, double y) {
        return x < this.sirka && y < this.vyska;
    }
}