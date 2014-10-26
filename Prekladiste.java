

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Prekladiste extends Budova {
    final Umisteni umisteni;
    final int kapacita = 2000;
    private int pocetPlnychSudu;
    private int pocetPrazdnychSudu;

    public Prekladiste() throws SouradniceException {
        super(0, 0, null);
        this.umisteni = null;
    }

    

}
