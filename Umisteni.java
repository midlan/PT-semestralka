/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Umisteni {

    final double x;
    final double y;

    public Umisteni(double x, double y, Uzemi uzemi) throws SouradniceException {
        if (x < uzemi.sirka && y < uzemi.vyska) {
            this.x = x;
            this.y = y;
            return;
        }
        throw new SouradniceException();
    }

}
