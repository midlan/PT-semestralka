
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

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
    
    public static void main(String[] args) {
        
    }
}