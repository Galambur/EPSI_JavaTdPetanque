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
}
