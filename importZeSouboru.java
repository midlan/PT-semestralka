
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class importZeSouboru {
    static int pocetPlnychSuduVPrekladisti=2000;
    
    Uzemi uzemi;
    
    Pivovar pivovar;
    private ArrayList<Prekladiste> prekladiste=new ArrayList<Prekladiste>();
    private ArrayList<SudovaHospoda> hospodySudove=new ArrayList<SudovaHospoda>();
    private ArrayList<TankovaHospoda> hospodyTankove=new ArrayList<TankovaHospoda>();
    
    public importZeSouboru(){
    	BufferedReader reader;
    	try{
            reader = new BufferedReader(new FileReader("./src/data/input.txt")); //testovaci
            //reader = new BufferedReader(new FileReader("../data/mesta.txt"));

            String radka;
            while ((radka = reader.readLine()) != null) {
                    String[] data=radka.split("\t");

                    if(data.length == 2){ 
                       //prisla velikost mapy
                        this.uzemi=new Uzemi(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                    }
                    else if(data.length == 4){

                        //přišla budova
                        String nazev=data[0];
                        double souradniceX=Double.parseDouble(data[1]);
                        double souradniceY=Double.parseDouble(data[2]);
                        String typBudovy=data[3];
                        
                        
                        if(typBudovy.equals("pp")){
                            prekladiste.add(new Prekladiste(pocetPlnychSuduVPrekladisti, nazev, uzemi, souradniceX, souradniceY));
                        }
                        else if(typBudovy.equals("s")){
                            hospodySudove.add(new SudovaHospoda(nazev, uzemi, souradniceY, souradniceY));
                        }
                        else if(typBudovy.equals("t")){
                            hospodyTankove.add(new TankovaHospoda(nazev, uzemi, souradniceY, souradniceY));
                        }
                        
                    }
                    else if(data.length==5){
                        String nazev=data[0];
                        double souradniceX=Double.parseDouble(data[1]);
                        double souradniceY=Double.parseDouble(data[2]);
                        String typBudovy=data[3];
                        int produkce=Integer.parseInt(data[4]);

                        
                        if(typBudovy.equals("p")){
                            pivovar=new Pivovar(nazev, produkce, uzemi, souradniceX, souradniceY);
                        }
                    }
                    else{
                        Budova budova=Budova.najdi(data[0]);
                        
                        budova.pridejCestu(budova);
                        
                        
                        for(int i=1;i<data.length;i++){
                            
                        }
                        
                        System.out.println("Řadek neleze rozpoznat:  "+data.toString());
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
    
    public SudovaHospoda[] getSudoveHospody(){
        SudovaHospoda[] sudoveHospodyPole=new SudovaHospoda[hospodySudove.size()];
        
        for(int i=0;i<sudoveHospodyPole.length;i++){
            sudoveHospodyPole[i]=hospodySudove.get(i);
        }
        
        return sudoveHospodyPole;
    }
    
    public TankovaHospoda[] getTankoveHospody(){
        TankovaHospoda[] tankoveHospodyPole=new TankovaHospoda[hospodyTankove.size()];
        
        for(int i=0;i<tankoveHospodyPole.length;i++){
            tankoveHospodyPole[i]=hospodyTankove.get(i);
        }
        
        return tankoveHospodyPole;
    }
    
    public Prekladiste[] getPrekladiste(){
        Prekladiste[] prekladistePole=new Prekladiste[prekladiste.size()];
        
        for(int i=0;i<prekladistePole.length;i++){
            prekladistePole[i]=prekladiste.get(i);
        }
        
        return prekladistePole;
    }
    
}
