
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
    int xMapy;
    int yMapy;
    
    Pivovar pivovar;
    ArrayList<Prekladiste> prekladiste=new ArrayList<Prekladiste>();
    ArrayList<SudovaHospoda> hospodySudove=new ArrayList<SudovaHospoda>();
    ArrayList<TankovaHospoda> hospodyTankove=new ArrayList<TankovaHospoda>();
    
    public importZeSouboru(){
    	BufferedReader reader;
    	try{
            reader = new BufferedReader(new FileReader("./src/data/input.txt")); //testovaci
            //reader = new BufferedReader(new FileReader("../data/mesta.txt"));
            System.out.println("reader good");
            String radka;
            while ((radka = reader.readLine()) != null) {
                    System.out.println("cyklus");
                    String[] data=radka.split("\t");

                    if(data.length == 2){ 
                       //prisla velikost mapy
                        System.out.println("prisla velikost mapy");
                       this.xMapy=Integer.parseInt(data[0]);
                       this.yMapy=Integer.parseInt(data[1]);
                    }
                    else if(data.length == 4){
                        System.out.println("prisla budova");
                        
                        for (int i = 0; i < data.length; i++) {
                            System.out.println(i+":"+data[i]);
                        }
                        //přišla budova
                        String nazev=data[0];
                        System.out.println("0");
                        double souradniceX=Double.parseDouble(data[1]);
                        System.out.println("1");
                        double souradniceY=Double.parseDouble(data[2]);
                        System.out.println("2");
                        String typBudovy=data[3];
                        
                        if(typBudovy.equals("p")){
                            System.out.println("pivovar");
                            //todo 
                            pivovar=new Pivovar(null, souradniceX, souradniceY, 7000);
                            System.out.println("pivovar má probl");
                        }
                        else if(typBudovy.equals("pp")){
                            System.out.println("prekladist");
                            prekladiste.add(new Prekladiste(null, souradniceX, souradniceY));
                        }
                        else if(typBudovy.equals("s")){
                            hospodySudove.add(new SudovaHospoda());
                        }
                        else if(typBudovy.equals("t")){
                            hospodyTankove.add(new TankovaHospoda());
                        }
                        
                    }
                    else{
                        System.out.println("Řadek neleze rozpoznat:  "+data.toString());
                    }
                    System.out.println("konec cyklu");
            }
        
    	}catch(Exception e){
    		System.out.println("Při čtení souboru vznikla chyba. Soubor neexistuje. Nebo obsahuje špatný formát. ");
    	}
    }
    
}
