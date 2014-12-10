
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Generator {
    
    private static final int SIRKA_UZEMI = 500;
    private static final int VYSKA_UZEMI = 500;
    private static final String PIVOVAR_NAZEV = "Chmelokvas";
    private static final int PIVOVAR_PRODUKCE = 700000;
    private static final int HOSPY_PIVOVAR_CEST = 15;
    private static final int PREKLADISTE_CEST = 50;
    private static final int MIN_VZDALENOST_HOSP = 2;
    public static final double HOSPOD_TANK_KOEF = 0.05;
    public static final String SOUBOR_NAZVY_HOSP = "." + File.separator + "data" + File.separator + "nazvy_hospod.txt";
    public static final String SOUBOR_VSTUP = "." + File.separator + "data" + File.separator + "input.txt";
    private static final String NAZEV_PREKLADISTE_FORMAT = "Překladiště %d";

    public static void zapisDoSouboru(Uzemi u, File soubor, String oddelovac, String zalomeniRadku) throws IOException {
        
        try {
            FileWriter fw = new FileWriter(soubor);
            
            Budova[] budovy = u.getBudovy();
            
            //zapsat území
            fw.write(u.toString() + zalomeniRadku);
            
            //zapsat budovy
            for (Budova b : budovy) {
                fw.write(b.toString() + zalomeniRadku);
            }
            
            //zapsat cesty
            for (Budova b : budovy) {
                
                fw.write(b.getNazev() + oddelovac);
                
                Cesta cesty[] = b.getCesty();
                
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cesty.length - 1; i++) {
                    
                    sb.append(cesty[i].toString());
                    
                    if (i != cesty.length - 1) {
                        sb.append(oddelovac);
                    }
                }
                
                fw.write(sb.toString() + zalomeniRadku);
            }
            
            fw.close();
        }
        catch (IOException e) {
            System.err.format("Zápis dat do souboru se nezdařil (%s)", soubor.getPath());
            throw e;
        }
    }
    
    private static void posunoutHodnoty(int[] pole, int od) {
        for (int i = pole.length - 2; i >= od; i--) {
            pole[i + 1] = pole[i];
        }
    }
    
    private static int[] kliceNejnizsichHodnot(double[] pole, int pocet) {
    
        int[] klice = new int[pocet];

        Arrays.fill(klice, 0);
    
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < klice.length; j++) {
                if(pole[i] < pole[klice[j]]) {
                    posunoutHodnoty(klice, j);
                    klice[j] = i;
                    break;
                }
            }
        }
    
        return klice;
    }
    
    public static void main(String[] args) {
        
        if(args.length <= 0 || args[0] == null) {
            throw new IllegalArgumentException("Jako první parametr uveďte název souboru, do kterého se mají vygenerovaná data zapsat.");
        }
        
        try {
            try {
                Uzemi uzemi = new Uzemi(SIRKA_UZEMI, VYSKA_UZEMI);
                
                int poradiPrekladiste = 1;
                double sirkaUzPul = uzemi.getSirka() / 2, vyskaUzPul = uzemi.getVyska() / 2;
                
                Pivovar pivovar = new Pivovar(PIVOVAR_NAZEV, PIVOVAR_PRODUKCE, uzemi, sirkaUzPul, vyskaUzPul);
                
                Prekladiste[] prekladiste = {
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, sirkaUzPul + 2 * sirkaUzPul / 3, vyskaUzPul + vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, sirkaUzPul + sirkaUzPul / 3, vyskaUzPul + 2 * vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, 2 * sirkaUzPul / 3, vyskaUzPul + 2 * vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, sirkaUzPul / 3, vyskaUzPul + vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, sirkaUzPul / 3, 2 * vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, 2 * sirkaUzPul / 3, vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, sirkaUzPul + sirkaUzPul / 3, vyskaUzPul / 3),
                    new Prekladiste(String.format(Generator.NAZEV_PREKLADISTE_FORMAT, poradiPrekladiste++), uzemi, sirkaUzPul + 2 * sirkaUzPul / 3, 2 * vyskaUzPul / 3),
                };

                //načtení názvů hospod
                String nazvyHosp[] = new Scanner(new File(Generator.SOUBOR_NAZVY_HOSP)).useDelimiter("\\A").next().split(Semestralka.DAT_SOUB_ODRADKOVANI);
                Budova hospyPivovar[] = new Budova[nazvyHosp.length + 1];
                
                //rozmístění hospod
                for (int i = 0, tankHosp = (int)(nazvyHosp.length * HOSPOD_TANK_KOEF); i < nazvyHosp.length; i++) {
                    
                    double x, y;
                    
                    do {
                        x = Math.random() * uzemi.getSirka();
                        y = Math.random() * uzemi.getVyska();
                    }
                    while(uzemi.budovaPobliz(x, y, MIN_VZDALENOST_HOSP));
                    
                    hospyPivovar[i] = i < tankHosp ? new TankovaHospoda(nazvyHosp[i], uzemi, x, y) : new SudovaHospoda(nazvyHosp[i], uzemi, x, y);
                }
                
                //přidání pivovaru k výpočtu vzdáleností
                hospyPivovar[hospyPivovar.length - 1] = pivovar;
                
                //spočtení vzdáleností mezi budovami
                double vzdalenosti[][] = new double[hospyPivovar.length][hospyPivovar.length];
                
                for (int i = 0; i < hospyPivovar.length; i++) {
                    for (int j = 0; j < hospyPivovar.length; j++) {
                        vzdalenosti[i][j] = hospyPivovar[i].vzdalenost(hospyPivovar[j]);
                    }
                }
                
                //přidání cest mezi hospodami a pivovarem
                for (int i = 0; i < hospyPivovar.length; i++) {
                    for (int klic : kliceNejnizsichHodnot(vzdalenosti[i], HOSPY_PIVOVAR_CEST)) {
                        hospyPivovar[i].pridejCestu(hospyPivovar[klic]);
                    }
                }
                
                //přidání cest mezi překladištěmi a hospodami
                double maxVzdalHospaPreklad = prekladiste[0].vzdalenost(prekladiste[1]) / 2;
                
                for (Prekladiste preklad : prekladiste) {
                    for (int i = 0; i < PREKLADISTE_CEST; i++) {
                        
                        Budova bud;
                        
                        do {
                            //výběr hospody z kruhu kolem překladiště
                            bud = hospyPivovar[(int)(Math.random() * (hospyPivovar.length - 2))];
                        }
                        while(preklad.vzdalenost(bud) > maxVzdalHospaPreklad);
                        
                        preklad.pridejCestu(bud);
                    }
                }
                
                zapisDoSouboru(uzemi, new File(args[0]), Semestralka.DAT_SOUB_ODDELOVAC, Semestralka.DAT_SOUB_ODRADKOVANI);

            }
            catch (FileNotFoundException e) {
                System.err.format("Soubor s názvy hospod nebyl nalezen (%s)", Generator.SOUBOR_NAZVY_HOSP);
                throw e;
            }
        
        }
        catch(IOException e) {
            
            System.out.println(e.getClass().getName());
            System.err.println("Vytvoření vstupního datavého souboru selhalo, program bude ukončen");
            System.exit(1);
        }
    }
}