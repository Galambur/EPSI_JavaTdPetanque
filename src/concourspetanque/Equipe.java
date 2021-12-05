package concourspetanque;

import java.util.List;
import java.util.Random;

public class Equipe {
    public int id;
    public List<Joueur> joueurs;
    public int scoreFinal;
    public int nombrePartiesGagnees;
    
    public Equipe(int id, List<Joueur> joueurs, int nombrePartiesGagnees){
        this.id = id;
        this.joueurs = joueurs;
        this.nombrePartiesGagnees = nombrePartiesGagnees;
    }
    
    public void ajouterJoueur(Joueur j){
        this.joueurs.add(j);
        j.setNumeroEquipe(this.id);
    }
    
    public String afficherJoueurs(){
        var str = "Equipe num " + this.id + " :";
        for(var i = 0; i < this.joueurs.size(); i++){
            str = str + " score : " + Integer.toString(this.scoreFinal) + " | " + this.joueurs.get(i).afficheToi();
        }
        return str;
    }
}
