package concourspetanque;

import java.util.List;

public class Equipe {
    private int id;
    private List<Joueur> joueurs;
    private int nombrePartiesGagnees;
    
    public Equipe(int id, List<Joueur> joueurs, int nombrePartiesGagnees){
        this.id = id;
        this.joueurs = joueurs;
        this.nombrePartiesGagnees = nombrePartiesGagnees;
    }
}
