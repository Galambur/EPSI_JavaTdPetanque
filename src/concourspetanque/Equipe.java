package concourspetanque;

import java.util.List;
import java.util.Random;

public class Equipe {
    public int id;
    public List<Joueur> joueurs;
    public int nombrePartiesGagnees;
    
    public Equipe(int id, List<Joueur> joueurs, int nombrePartiesGagnees){
        this.id = id;
        this.joueurs = joueurs;
        this.nombrePartiesGagnees = nombrePartiesGagnees;
    }
}
