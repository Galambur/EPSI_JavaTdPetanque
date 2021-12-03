package concourspetanque;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcoursPetanque {

    public static void main(String[] args) {
        int max = 36;
        int min = 12;
        int range = max - min + 1;
  
        // generation du nombre de joueurs 
        int nombreJoueurs = (int)(Math.random() * range) + min;
        List<Joueur> joueurs = new ArrayList<>();
        System.out.println("Il y a " + nombreJoueurs + " joueurs dans ce tournoi");

        for(int i = 0; i < nombreJoueurs; i++){
            var joueur = new Joueur(i, "nom" + i, "prenom" + i);
            joueurs.add(joueur);
        }
        
        var tournoi = new Tournoi(joueurs);
        
        
        double nombreEquipe = 0;
        var listeJoueursRestants = tournoi.joueurs;
        
        // premiere possibilite
        // 24 20 16 12
        if(nombreJoueurs / 2 == 12 || nombreJoueurs / 2 == 10 || nombreJoueurs / 2 == 8 || nombreJoueurs / 2 == 6) {
            System.out.println("Ce tournoi n'aura que des doublettes");
            nombreEquipe = nombreJoueurs / 2;
            // on mélange la liste des joueurs
            Collections.shuffle(listeJoueursRestants);
            var lastIndex = listeJoueursRestants.size() - 1;
            
            for (int i = 1; i <= nombreEquipe; i++){
                // choix des deux joueurs
                System.out.println("equipe num " + i);
                var joueur1 = listeJoueursRestants.get(lastIndex);
                joueur1.setNumeroEquipe(i);
                var joueur2 = listeJoueursRestants.get(lastIndex - 1);
                joueur2.setNumeroEquipe(i);

                lastIndex = lastIndex - 2;
                
                System.out.println(joueur1.getPrenom());
                System.out.println(joueur2.getPrenom());
                
                List<Joueur> joueursEquipe = new ArrayList<Joueur>();
                joueursEquipe.add(joueur1);
                joueursEquipe.add(joueur2);
                
                var equipe = new Equipe(i, joueursEquipe, 0);
                tournoi.addEquipe(equipe);
                
            }
        } 
        // deuxieme possibilite 
        // tous les autres nombres
        else {
            System.out.println("Ce tournoi aura des doublettes et des triplettes");
            Collections.shuffle(listeJoueursRestants);
            int nombreJoueursRestants = nombreJoueurs;
            int numEquipe = 1;
            boolean endTriplette = false;
            if(nombreJoueursRestants % 12 == 0|| nombreJoueursRestants % 10 == 0 || nombreJoueursRestants % 8 == 0 || nombreJoueursRestants % 6 == 0){
                endTriplette = true;
            }
            
            
            
            while (nombreJoueursRestants > 0){
                if((nombreJoueursRestants % 12 == 0|| nombreJoueursRestants % 10 == 0 || nombreJoueursRestants % 8 == 0 || nombreJoueursRestants % 6 == 0) || endTriplette == true){
                    // doublette
                    System.out.println("equipe num " + numEquipe);
                    var joueur1 = listeJoueursRestants.get(nombreJoueursRestants - 1);
                    var joueur2 = listeJoueursRestants.get(nombreJoueursRestants - 2);
                
                    List<Joueur> joueursEquipe = new ArrayList<Joueur>();
                    joueursEquipe.add(joueur1);
                    joueursEquipe.add(joueur2);
                    
                    var equipe = new Equipe(numEquipe, joueursEquipe, 0);
                    tournoi.addEquipe(equipe);
                
                    System.out.println(joueur1.getPrenom());
                    System.out.println(joueur2.getPrenom());
                    
                    nombreJoueursRestants = nombreJoueursRestants - 2;
                    numEquipe++;
                    
                } else {
                    // triplette
                    System.out.println("equipe num " + numEquipe);
                    var joueur1 = listeJoueursRestants.get(nombreJoueursRestants - 1);
                    var joueur2 = listeJoueursRestants.get(nombreJoueursRestants - 2);
                    var joueur3 = listeJoueursRestants.get(nombreJoueursRestants - 3);
                
                    System.out.println(joueur1.getPrenom());
                    System.out.println(joueur2.getPrenom());
                    System.out.println(joueur3.getPrenom());

                
                    List<Joueur> joueursEquipe = new ArrayList<Joueur>();
                    joueursEquipe.add(joueur1);
                    joueursEquipe.add(joueur2);
                    joueursEquipe.add(joueur3);
                    
                    var equipe = new Equipe(numEquipe, joueursEquipe, 0);
                    tournoi.addEquipe(equipe);
                    
                    numEquipe++;
                    nombreJoueursRestants = nombreJoueursRestants - 3;
                    if(nombreJoueursRestants % 12 == 0|| nombreJoueursRestants % 10 == 0 || nombreJoueursRestants % 8 == 0 || nombreJoueursRestants % 6 == 0){
                        endTriplette = true;
                    }
                }
            }
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
