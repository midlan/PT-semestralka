
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Importuje vstupní data ze souboru a rozděluje je do příslušných struktur. 
 *
 * @author Kateřina Kratochvílová <dtwok8@students.zcu.cz>
 */
public class ImportZeSouboru {
    static int pocetPlnychSuduVPrekladisti=2000;
    
    private Uzemi uzemi; 
    private Pivovar pivovar;
    private final List<Prekladiste> prekladiste=new ArrayList<Prekladiste>();
    private final List<SudovaHospoda> hospodySudove=new ArrayList<SudovaHospoda>();
    private final List<TankovaHospoda> hospodyTankove=new ArrayList<TankovaHospoda>();
    
    public ImportZeSouboru(){
    	BufferedReader reader;
    	try{
            reader = new BufferedReader(new FileReader("./src/data/input.txt")); //testovaci
            //reader = new BufferedReader(new FileReader("../data/mesta.txt"));

            String radka;
            while ((radka = reader.readLine()) != null) {
                String[] data=radka.split("\t");

                if(data.length == 2){ 
                   //prisla velikost mapy
                    this.uzemi=new Uzemi(Double.parseDouble(data[0]), Double.parseDouble(data[1]));
                }
                else if(data.length == 4 || data.length == 5){
                    //přišla budova
                    pridejBudovu(data);
                }
                else{
                    pridejCesty(data);  
                }
            }
    	}
        catch(IllegalArgumentException e){
            System.out.println("Soubor obsahuje špatný formát");
        }
        catch(Exception e){
    		System.out.println("Při čtení souboru vznikla chyba nebo soubor neexistuje.");
    	}
    }
    
    /**
     * Prida budovu. Na zakladě typu budovy (také se bere ze souboru) vime o jakou budovu se jedna. 
     * @param data řádek načtený ze souboru, rozsekaný na jednotlivé položky.
     */
    private void pridejBudovu(String[] data){
        try{
            String nazev=data[0];
            double souradniceX=Double.parseDouble(data[1]);
            double souradniceY=Double.parseDouble(data[2]);
            String typBudovy=data[3];


            if(typBudovy.equals("pp")){
                //prekladiste.add(new Prekladiste(nazev, 2000,uzemi, souradniceX, souradniceY));
            }
            else if(typBudovy.equals("s")){
                hospodySudove.add(new SudovaHospoda(nazev, uzemi, souradniceY, souradniceY));
            }
            else if(typBudovy.equals("t")){
                hospodyTankove.add(new TankovaHospoda(nazev, uzemi, souradniceY, souradniceY));
            }

            if(typBudovy.equals("p")){ 
                int produkce=Integer.parseInt(data[4]);
                pivovar=new Pivovar(nazev, produkce, uzemi, souradniceX, souradniceY);
            }
        }catch(Exception e){
            System.out.println("Při čtení souboru vznikla chyba, pravděpodobně formát neodpovídá požadavkům. ");
        }
    }
    /**
     * Přídádá cesty k hospodě. Na prvním míste řádku v souboru je jmenoho budovy. 
     * Nasledně jsou za ním budovy, ke kterým má budova přímou cestu. 
     * 
     * @param data řádek načtený ze souboru, rozsekaný na jednotlivé položky.
     */
    private void pridejCesty(String[] data){
        try{
            Budova budova=Budova.najdi(data[0]);                        
                        
            for(int i=1;i<data.length;i++){
                Budova CestaKBudove=Budova.najdi(data[i]);
                budova.pridejCestu(CestaKBudove);
                System.out.println(CestaKBudove.getNazev());
            }
        }catch(Exception e){
            System.out.println("Při čtení souboru vznikla chyba, pravděpodobně formát neodpovídá požadavkům. ");
        }
    }
    
    /**
    * Vrati sudove hospody jako pole. 
    * 
    * @return sudoveHospodyPole sudove hospody.
    */
    public SudovaHospoda[] getSudoveHospody(){
        SudovaHospoda[] sudoveHospodyPole=new SudovaHospoda[hospodySudove.size()];
        
        for(int i=0;i<sudoveHospodyPole.length;i++){
            sudoveHospodyPole[i]=hospodySudove.get(i);
        }
        
        return sudoveHospodyPole;
    }
    
    /**
     * Vrati tankove hospody jako pole. 
     * 
     * @return tankoveHospodyPole tankove hospody. 
     */
    public TankovaHospoda[] getTankoveHospody(){
        TankovaHospoda[] tankoveHospodyPole=new TankovaHospoda[hospodyTankove.size()];
        
        for(int i=0;i<tankoveHospodyPole.length;i++){
            tankoveHospodyPole[i]=hospodyTankove.get(i);
        }
        
        return tankoveHospodyPole;
    }
    
    /**
     * Vrati prekladiste jako pole. 
     * 
     * @return prekladistePole prekladiste.
     */
    public Prekladiste[] getPrekladiste(){
        Prekladiste[] prekladistePole=new Prekladiste[prekladiste.size()];
        
        for(int i=0;i<prekladistePole.length;i++){
            prekladistePole[i]=prekladiste.get(i);
        }
        
        return prekladistePole;
    }
    
    /**
     * Vrati uzemi.
     * @return uzemi uzemi.  
     */
    public Uzemi getUzemi(){
        return this.uzemi;
    }
    
    /**
     * Vrati pivovar
     * @return pivovar pivovar.
     */
    public Pivovar getPivovar(){
        return this.pivovar;
    }
}
