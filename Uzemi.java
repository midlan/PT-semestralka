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

    public Umisteni vytvorUmisteni(double x, double y) throws SouradniceException {
        return new Umisteni(x, y, this);
    }

    public Pozice vytvorPozici(double x, double y) throws SouradniceException {
        return new Pozice(x, y, this);
    }

}
