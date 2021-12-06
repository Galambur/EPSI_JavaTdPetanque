package concourspetanque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    
    public Equipe findEquipeAdverse(Equipe equipe, int numManche){
        Equipe equipeAdverse = null;
        for(var j = 0; j < equipes.size(); j++){
            if(equipes.get(j).getId() != equipe.getId() 
                    && hasAlreadyPlayed(equipes.get(j), equipe) == false 
                    && isAlreadyPlaying(equipes.get(j), numManche) == false){
                equipeAdverse = equipes.get(j);
            }
        }
        return equipeAdverse;
    }
    
    private boolean isAlreadyPlaying(Equipe equipeCherchee, int numManche){
        for(var i = 0; i < matches.size(); i++){
            if(matches.get(i).numManche == numManche && (equipeCherchee.getId() == matches.get(i).equipe1.getId() || equipeCherchee.getId() == matches.get(i).equipe2.getId())
                    || (equipeCherchee.getId() % 2 != 0)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasAlreadyPlayed(Equipe e1, Equipe e2){
        for(var i = 0; i < matches.size(); i++){
            if(matches.get(i).equipe1.getId() == e1.getId() && matches.get(i).equipe2.getId() == e2.getId()){
                return true;
            }
            if(matches.get(i).equipe1.getId() == e2.getId() && matches.get(i).equipe2.getId() == e1.getId()){
                return true;
            }
        }
        return false;
    }
}
