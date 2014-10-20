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

    final int sirka;
    final int vyska;

    public Uzemi(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public Umisteni vytvorUmisteni(int x, int y) throws SouradniceException {
        return new Umisteni(x, y, this);
    }

    public Pozice vytvorPozici(int x, int y) throws SouradniceException {
        return new Pozice(x, y, this);
    }

}
