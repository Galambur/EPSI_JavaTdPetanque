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
            System.out.println("Ce tournoi n'aura que des doublettes");
            nombreEquipe = nombreJoueurs / 2;
            // on mélange la liste des joueurs
            Collections.shuffle(listeJoueursRestants);
            var lastIndex = listeJoueursRestants.size() - 1;
            
            for (int i = 1; i <= nombreEquipe; i++){
                // choix des deux joueurs
                var joueur1 = listeJoueursRestants.get(lastIndex);
                joueur1.setNumeroEquipe(i);
                var joueur2 = listeJoueursRestants.get(lastIndex - 1);
                joueur2.setNumeroEquipe(i);

                lastIndex = lastIndex - 2;
                
                List<Joueur> joueursEquipe = new ArrayList<Joueur>();
                joueursEquipe.add(joueur1);
                joueursEquipe.add(joueur2);
                
                var equipe = new Equipe(i, joueursEquipe, 0);
                tournoi.addEquipe(equipe);
                
            }
        } else {
            var nombreEquipes = 0;
            // si c'est impaire, on fait une equipe de 3 puis on fait
            if(nombreJoueurs % 2 != 0) {
                nombreEquipes++;
                System.out.println("Si c'est impaire, on fait une equipe de 3 puis on fait");
                var joueur1 = listeJoueursRestants.get(listeJoueursRestants.size() - 1);
                listeJoueursRestants.remove(joueur1);
                var joueur2 = listeJoueursRestants.get(listeJoueursRestants.size() - 1);
                listeJoueursRestants.remove(joueur2);
                var joueur3 = listeJoueursRestants.get(listeJoueursRestants.size() - 1);
                listeJoueursRestants.remove(joueur3);


                List<Joueur> joueursEquipe = new ArrayList<Joueur>();
                joueursEquipe.add(joueur1);
                joueursEquipe.add(joueur2);
                joueursEquipe.add(joueur3);

                var equipe = new Equipe(nombreEquipes, joueursEquipe, 0);
                tournoi.addEquipe(equipe);
            } 
            
            
            var nombreJoueursRestants = listeJoueursRestants.size();
            // on fait que des equipes de 2 jusqu'a ce qu'on ait plus de quoi faire
            while(nombreJoueursRestants > 0 && nombreEquipes <= 12){
                nombreEquipes++;
                var joueur1 = listeJoueursRestants.get(nombreJoueursRestants - 1);
                var joueur2 = listeJoueursRestants.get(nombreJoueursRestants - 2);

                List<Joueur> joueursEquipe = new ArrayList<Joueur>();
                joueursEquipe.add(joueur1);
                joueursEquipe.add(joueur2);

                var equipe = new Equipe(nombreEquipes, joueursEquipe, 0);
                tournoi.addEquipe(equipe);

                nombreJoueursRestants = nombreJoueursRestants - 2;
            }

            // là on verifie si on a le bon nombre d'equipe, si non, on prend les trois dernieres equipes pour en faire 2
            if(nombreEquipes != 12 && nombreEquipes != 10 && nombreEquipes != 8 && nombreEquipes != 6){
                System.out.println("on enleve trois equipes pour en recreer deux");
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
                List<Joueur> triplette1 = new ArrayList<Joueur>();
                triplette1.add(joueur1);
                triplette1.add(joueur2);
                triplette1.add(joueur3);
                Equipe equipe1 = new Equipe(idSecondToLast, triplette1, 0);
                
                // creation de la deuxieme equipe
                List<Joueur> triplette2 = new ArrayList<Joueur>();
                triplette2.add(joueur4);
                triplette2.add(joueur5);
                triplette2.add(joueur6);
                Equipe equipe2 = new Equipe(idLast, triplette2, 0);
                
                
                tournoi.addEquipe(equipe1);
                tournoi.addEquipe(equipe2);
            } else if (nombreJoueursRestants > 0) {
                System.out.println("else if");
                var nbEquipe = 12;
                var count = 1;
                for(var i = nombreJoueursRestants; i > 0; i--){
                    var j = listeJoueursRestants.get(listeJoueursRestants.size() - count);
                    tournoi.equipes.get(nbEquipe).ajouterJoueur(j);
                    nbEquipe--;
                }
            }
        }
        
        tournoi.afficherEquipes();
    }
}
