package concourspetanque;

import java.lang.Math;

public class ConcoursPetanque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 36;
        int min = 12;
        int range = max - min + 1;
  
        // generation du nombre de joueurs 
        int nombreJoueurs = (int)(Math.random() * range) + min;
        
        System.out.println(nombreJoueurs);
        
        // generation des equipes
        double nombreEquipe = 0;
        nombreEquipe = (double)nombreJoueurs / 2;
        if(nombreEquipe == 12 || nombreEquipe == 10 || nombreEquipe == 8 || nombreEquipe == 6) {
            System.out.println("cool");
        }
    }
    
}
