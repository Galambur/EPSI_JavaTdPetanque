package concourspetanque;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournoi {
    public List<Equipe> equipes;
    public List<Match> matches;    
    public List<Joueur> joueurs;
    
    public Tournoi(List<Joueur> joueurs){
        this.equipes = new ArrayList<Equipe>();
        this.matches = new ArrayList<Match>();
        this.joueurs = joueurs;
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
    
    public void afficherEquipes(){
        for(var i = 0; i < this.equipes.size(); i++){
            System.out.println(this.equipes.get(i).afficherJoueurs());
        }
    }
}
