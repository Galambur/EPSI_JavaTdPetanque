package concourspetanque;

import java.util.Collections;
import java.util.List;

public class Equipe {
    public int id;
    public List<Joueur> joueurs;
    public int scoreFinal;
    public int nombrePartiesGagnees;
    
    public Equipe(int id, List<Joueur> joueurs){
        this.id = id;
        this.joueurs = joueurs;
        this.nombrePartiesGagnees = 0;
    }
    
    public int getId(){
        return id;
    }
    
    public int getscoreFinal(){
        return scoreFinal;
    }
    
    public int getnombrePartiesGagnees(){
        return nombrePartiesGagnees;
    }
    
    public void ajouterJoueur(Joueur j){
        this.joueurs.add(j);
        j.setNumeroEquipe(this.id);
    }
    
    public String afficherJoueurs(){
        var str = "Equipe num " + this.id + " :";
        for(var i = 0; i < this.joueurs.size(); i++){
            str = str + " nombre parties gagnees : " + nombrePartiesGagnees + " score : " + Integer.toString(this.scoreFinal) + " | " + this.joueurs.get(i).afficheToi();
        }
        return str;
    }
}
