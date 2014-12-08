
/**
 *
 * @author midlan_
 */
public class Sud {
    
    private final int objem = 50, vyrobniCislo;
    private boolean plny = false;
    

    private static int poslVyrCislo = 0;
    
    public Sud() {
        this.vyrobniCislo = ++poslVyrCislo;
    }

    public boolean isPlny() {
        return this.plny;
    }
    
    public void naplnit() {
        
        if(this.plny) {
            throw new IllegalArgumentException("Sud už je plný, nelze ho znovu naplnit");
        }
        
        this.plny = true;
    }

    public void vyprazdnit() {
        
        if(!this.plny) {
            throw new IllegalArgumentException("Sud už je prázdný, nelze ho znovu vyprázdnit");
        }
        
        this.plny = false;
    }

    public int getObjem() {
        return this.objem;
    }

    public int getVyrobniCislo() {
        return this.vyrobniCislo;
    }
}
