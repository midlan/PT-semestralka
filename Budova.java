/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Budova {

    private final Umisteni umisteni;

    public Budova(int x, int y, Uzemi uzemi) throws SouradniceException {
        this.umisteni = uzemi.vytvorUmisteni(x, y);
    }

    public Umisteni getUmisteni() {
        return umisteni;
    }
    
}
