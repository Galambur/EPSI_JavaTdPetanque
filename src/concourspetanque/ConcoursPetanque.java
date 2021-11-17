package concourspetanque;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

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
        List<Joueur> joueurs = new ArrayList<>();
        for(int i = 0; i < nombreJoueurs; i++){
            var joueur = new Joueur(i, "nom" + i, "prenom" + i);
            joueurs.add(joueur);
        }
        
        
        
        double nombreEquipe = 0;
        nombreEquipe = (double)nombreJoueurs / 2;
        System.out.println("nombreEquipe : " + nombreEquipe + " nombre joueurs : " + nombreJoueurs);
        // premiere possibilite
        if(nombreEquipe == 12 || nombreEquipe == 10 || nombreEquipe == 8 || nombreEquipe == 6) {
            System.out.println("que des doublettes");
            int nombreJoueursTempo = nombreJoueurs;
            for (int i = 1; i <= nombreEquipe; i++){
                System.out.println("creation equipe num " + i);
                nombreJoueursTempo = nombreJoueursTempo - 2 ;
                System.out.println("nombreJoueursTempo " + nombreJoueursTempo);
            }
        } 
        // deuxieme possibilite
        else if (nombreEquipe % 2 == 0){
            
        }
        
        
        
        
        
        
        
        
        /*var nombreEquipe = (double)nombreJoueurs / 2;
        System.out.println("nombreEquipe" + nombreEquipe);
        if(nombreEquipe == 12 || nombreEquipe == 10 || nombreEquipe == 8 || nombreEquipe == 6) {
            System.out.println("que des doublettes");
            // todo : creation des doublettes
        }
        // si le nombre de personnes est impair
        if(nombreJoueurs % 2 != 0){
            nombreJoueurs = nombreJoueurs - 3;
            System.out.println("creation d'une triplette");
            // todo : creation d'une triplette
        }
        
        
        
        
        
        
        
        
        
        
        // generation d'une equipe
        while (nombreJoueurs > 0){
            if(nombreJoueurs % 2 == 0){
                // todo : creation d'une equipe de 2
                nombreJoueurs = nombreJoueurs - 2;
            } else {
                // todo : creation d'une equipe de 3
                nombreJoueurs = nombreJoueurs - 3;
            }
        }
        
        
        
        
        
        
        
        
        // generation des equipes
        double nombreEquipe = 0;
        nombreEquipe = (double)nombreJoueurs / 2;
        System.out.println("nombreEquipe"+nombreEquipe);
        if(nombreEquipe == 12 || nombreEquipe == 10 || nombreEquipe == 8 || nombreEquipe == 6) {
            System.out.println("que des doublettes");
        } else {

        }*/
    }
    
}
