package concourspetanque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tournoi {
    public List<Equipe> equipes;
    public List<Match> matches;    
    public List<Joueur> joueurs;
    public String[][] matchesAFaire;
    
    public String[][] matchesPour6Equipes = {
        {"1-2", "3-4", "5-6"},
        {"1-3","2-6","4-5"},
        {"1-4","5-2","3-6"},
        {"1-5","6-4","2-3"},
    };

    public String[][] matchesPour8Equipes = {
            {"1-2", "3-4", "5-6","7-8"},
            {"1-3","2-4","5-7","6-8"},
            {"1-4","2-3","5-8","6-7"},
            {"1-5","2-8","3-7","4-6"},
    };

    public String[][] matchesPour10Equipes = {
            {"1-2", "3-4", "5-6","7-8","9-10"},
            {"2-3","4-5","6-7","8-9","10-1"},
            {"1-3","2-4","9-6","8-10","5-7"},
            {"6-8","7-9","10-3","5-2","4-1"},
    };

    public String[][] matchesPour12Equipes = {
            {"1-2", "3-4", "5-6","7-8","9-10","11-12"},
            {"1-12","2-11","3-10","4-9","5-8","6-7"},
            {"1-3","2-4","5-7","6-8","12-9","10-11"},
            {"12-6","3-8","11-7","1-9","4-10","5-2"},
    };
    
    public Tournoi(List<Joueur> joueurs){
        this.equipes = new ArrayList<Equipe>();
        this.matches = new ArrayList<Match>();
        this.joueurs = joueurs;
        this.matchesAFaire = new String[0][0];
    }
    
    public void addMatch(Match match) {
        this.matches.add(match);
    }
    
    public void addEquipe(Equipe equipe){
        this.equipes.add(equipe);
    }
    
    public void removeTroisEquipes(){
        this.equipes.remove(this.equipes.size() - 1);
        this.equipes.remove(this.equipes.size() - 1);
        this.equipes.remove(this.equipes.size() - 1);
    }
    
    public void setMatchesAFaire(){
        var nbEquipes = equipes.size();
        switch (nbEquipes) {
            case 6:
              this.matchesAFaire = matchesPour6Equipes;
              break;
              
            case 8:
              this.matchesAFaire = matchesPour8Equipes;
              break;
              
            case 10:
              this.matchesAFaire = matchesPour10Equipes;
              break;
              
            case 12:
              this.matchesAFaire = matchesPour12Equipes;
              break;
        }
    }
    
    public void afficherEquipes(){
        for(var i = 0; i < this.equipes.size(); i++){
            System.out.println(this.equipes.get(i).afficherJoueurs());
        }
    }
    
    public void rangerEquipesOrdreId(){
        Collections.sort(equipes, (new Comparator<Equipe>() {
            public int compare(Equipe i1, Equipe i2) {
                return i1.id - i2.id;
            }
        }));
    }
    
    public void afficherClassement(){
        faireClassement();
        for (var i = 0; i < equipes.size(); i++){
            System.out.println("Rang " + (i+1) + " Equipe " + equipes.get(i).getId() + " --> nombre parties gagnées : " + equipes.get(i).nombrePartiesGagnees + " score total : " + equipes.get(i).scoreFinal);
            for(var j = 0; j < equipes.get(i).joueurs.size(); j++){
                System.out.println("\t" + equipes.get(i).joueurs.get(j).getNom());
            }
        }
    }
    
    private void faireClassement(){
        // organiser la liste
        Collections.sort(equipes, (new Comparator<Equipe>() {
            public int compare(Equipe i1, Equipe i2) {
                return i2.scoreFinal - i1.scoreFinal;
            }
        }));
        Collections.sort(equipes, (new Comparator<Equipe>() {
            public int compare(Equipe i1, Equipe i2) {
                return i2.nombrePartiesGagnees - i1.nombrePartiesGagnees;
            }
        }));
    }
}
