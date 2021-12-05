package concourspetanque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    
    public void afficherClassement(){
        // organiser la liste
        Collections.sort(equipes, (new Comparator<Equipe>() {
            public int compare(Equipe i1, Equipe i2) {
                return i2.scoreFinal - i1.scoreFinal;
            }
        }));
        Collections.sort(equipes, (new Comparator<Equipe>() {
            public int compare(Equipe i1, Equipe i2) {
                return i1.nombrePartiesGagnees - i2.nombrePartiesGagnees;
            }
        }));
    }
    
    public boolean compareTo(Equipe e1, Equipe e2){
        if(!(e1.getnombrePartiesGagnees() == (e2.getnombrePartiesGagnees()))){
          return e1.getnombrePartiesGagnees() > e2.getnombrePartiesGagnees();
       }else{
          return e1.getscoreFinal() > e2.getscoreFinal();
        }
    }
}
