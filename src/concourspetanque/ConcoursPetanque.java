package concourspetanque;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ConcoursPetanque {

    public static void main(String[] args) {
        
        var tournoi = creationEquipes();
        tournoi.afficherEquipes();
        System.out.println("");
        
        // deroulement du tournoi
        deroulementTournoi(tournoi);
        
        System.out.println("\nClassement final : ");
        tournoi.afficherClassement();
    }
    
    
    public static void deroulementTournoi(Tournoi tournoi){
        
        for (String[] matches : tournoi.matchesAFaire) {
            var numMatch = 0;
            for (int j = 0; j < tournoi.matchesAFaire[0].length ; j++) {
                numMatch++;
                
                String[] equipesTirage = matches[j].split("-");
                Equipe equipe1 = tournoi.equipes.get(Integer.parseInt(equipesTirage[0]) - 1);
                Equipe equipe2 = tournoi.equipes.get(Integer.parseInt(equipesTirage[1]) - 1);
                
                var match = new Match(numMatch, equipe1, equipe2, 0, 0);
                tournoi.matches.add(match);
                
                System.out.println("equipe " + equipe1.id + " contre equipe " + equipe2.getId());
                
                
                // quelle equipe commence la partie ?
                Random rand = new Random();
                var equipe1Commence = rand.nextBoolean();
                
                do {
                    // une equipe peut gagner maximum 6 points et minimum 0
                    int max = 6;
                    int min = 0;
                    int range = max - min + 1;
                    if(equipe1Commence){
                        // on incremente le score de l'equipe 1
                        int score1 = (int)(Math.random() * range) + min;
                        match.scoreEquipe1 = match.scoreEquipe1 + score1;
                        
                        // on vérifie que ce n'est pas supérieur à 11
                        if(match.scoreEquipe1 > 11)
                            match.scoreEquipe1 = 11;
                        
                        if(match.scoreEquipe1 < 11){
                            int score2 = (int)(Math.random() * range) + min;
                            match.scoreEquipe2 = match.scoreEquipe2 + score2;
                            
                            if(match.scoreEquipe2 > 11)
                                match.scoreEquipe2 = 11;
                        }
                                                
                        // on retire le booleen pour la prochaine main
                        equipe1Commence = rand.nextBoolean();
                    } else {
                        // on incremente le score de l'equipe 2
                        int score2 = (int)(Math.random() * range) + min;
                        match.scoreEquipe2 = match.scoreEquipe2 + score2;
                        
                        if(match.scoreEquipe2 > 11)
                            match.scoreEquipe2 = 11;
                        
                        if(match.scoreEquipe2 < 11){
                            int score1 = (int)(Math.random() * range) + min;
                            match.scoreEquipe1 = match.scoreEquipe1 + score1;
                            
                            if(match.scoreEquipe1 > 11)
                                match.scoreEquipe1 = 11;
                        }
                        
                        // on retire le booleen pour la prochaine main
                        equipe1Commence = rand.nextBoolean();
                    } 
                } while(match.scoreEquipe1 < 11 && match.scoreEquipe2 < 11);
                match.ajouterNbPartiesGagnees();
            }
        }
    }
    
    public static Tournoi creationEquipes(){
        int max = 36;
        int min = 12;
        int range = max - min + 1;
  
        // generation du nombre de joueurs 
        double nombreJoueurs = (int)(Math.random() * range) + min;
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
        if(nombreJoueurs / 2 == 12.0 || nombreJoueurs / 2 == 10.0 || nombreJoueurs / 2 == 8.0 || nombreJoueurs / 2 == 6.0) {
            nombreEquipe = nombreJoueurs / 2;
            // on mélange la liste des joueurs
            Collections.shuffle(listeJoueursRestants);
            var lastIndex = listeJoueursRestants.size() - 1;
            
            for (int i = 1; i <= nombreEquipe; i++){
                // choix des deux joueurs
                var joueur1 = listeJoueursRestants.get(lastIndex);
                var joueur2 = listeJoueursRestants.get(lastIndex - 1);
                
                var equipe = new Equipe(i, new ArrayList<Joueur>());
                equipe.ajouterJoueur(joueur1);
                equipe.ajouterJoueur(joueur2);
                
                tournoi.addEquipe(equipe);
                
                lastIndex = lastIndex - 2;                
            }
        } else {
            var nombreEquipes = 0;
            // si c'est impaire, on fait une equipe de 3 puis on fait
            if(nombreJoueurs % 2 != 0) {
                nombreEquipes++;
                var joueur1 = listeJoueursRestants.get(listeJoueursRestants.size() - 1);
                listeJoueursRestants.remove(joueur1);
                var joueur2 = listeJoueursRestants.get(listeJoueursRestants.size() - 1);
                listeJoueursRestants.remove(joueur2);
                var joueur3 = listeJoueursRestants.get(listeJoueursRestants.size() - 1);
                listeJoueursRestants.remove(joueur3);

                var equipe = new Equipe(nombreEquipes, new ArrayList<Joueur>());
                equipe.ajouterJoueur(joueur1);
                equipe.ajouterJoueur(joueur2);
                equipe.ajouterJoueur(joueur3);
                
                tournoi.addEquipe(equipe);
            } 
            
            
            var nombreJoueursRestants = listeJoueursRestants.size();
            // on fait que des equipes de 2 jusqu'a ce qu'on ait plus de quoi faire
            while(nombreJoueursRestants > 0 && nombreEquipes <= 12){
                nombreEquipes++;
                var joueur1 = listeJoueursRestants.get(nombreJoueursRestants - 1);
                var joueur2 = listeJoueursRestants.get(nombreJoueursRestants - 2);

                var equipe = new Equipe(nombreEquipes, new ArrayList<Joueur>());
                equipe.ajouterJoueur(joueur1);
                equipe.ajouterJoueur(joueur2);
                
                tournoi.addEquipe(equipe);

                nombreJoueursRestants = nombreJoueursRestants - 2;
            }

            // là on verifie si on a le bon nombre d'equipe, si non, on prend les trois dernieres equipes pour en faire 2
            if(nombreEquipes != 12 && nombreEquipes != 10 && nombreEquipes != 8 && nombreEquipes != 6){
                // on enleve trois equipes pour en recreer deux
                var doublette1 = tournoi.equipes.get(tournoi.equipes.size() - 1);
                var doublette2 = tournoi.equipes.get(tournoi.equipes.size() - 2);
                var doublette3 = tournoi.equipes.get(tournoi.equipes.size() - 3);
                
                var idSecondToLast = doublette2.id;
                var idLast = doublette3.id;
                tournoi.removeTroisEquipes();
                
                // recuperation des joueurs
                var joueur1 = doublette1.joueurs.get(0);
                var joueur2 = doublette1.joueurs.get(1);
                var joueur3 = doublette2.joueurs.get(0);
                var joueur4 = doublette2.joueurs.get(1);
                var joueur5 = doublette3.joueurs.get(0);
                var joueur6 = doublette3.joueurs.get(1);
                
                // creation de la premier equipe
                Equipe equipe1 = new Equipe(idSecondToLast, new ArrayList<Joueur>());
                equipe1.ajouterJoueur(joueur1);
                equipe1.ajouterJoueur(joueur2);
                equipe1.ajouterJoueur(joueur3);
                
                // creation de la deuxieme equipe
                Equipe equipe2 = new Equipe(idLast, new ArrayList<Joueur>());
                equipe2.ajouterJoueur(joueur4);
                equipe2.ajouterJoueur(joueur5);
                equipe2.ajouterJoueur(joueur6);
                
                
                tournoi.addEquipe(equipe1);
                tournoi.addEquipe(equipe2);
            } else if (nombreJoueursRestants > 0) {
                var nbEquipe = 12;
                var count = 1;
                for(var i = nombreJoueursRestants; i > 0; i--){
                    var j = listeJoueursRestants.get(listeJoueursRestants.size() - count);
                    tournoi.equipes.get(nbEquipe).ajouterJoueur(j);
                    nbEquipe--;
                }
            }
        }
        tournoi.rangerEquipesOrdreId();
        tournoi.setMatchesAFaire();
        return tournoi;
    }
}
