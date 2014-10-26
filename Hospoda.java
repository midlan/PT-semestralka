

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Hospoda extends Budova{
    final Umisteni umisteni;
    final Prekladiste prekladiste;
    private DruhHospody druhHospody;
    private int zasoba;
    //spotřebuje 1-6 sodů nebo 1-6 Hl piva (5%)
    
    
    public Hospoda() throws SouradniceException {
        super(0, 0, null);
        this.umisteni = null;
        this.prekladiste = null;
        druhHospody=DruhHospody.SUDOVA;
    }
    
    
}
