package concourspetanque;

public class Match {
    public int id;
    public Equipe equipe1;
    public Equipe equipe2;
    public int scoreEquipe1;
    public int scoreEquipe2;
    
    public Match(int id, Equipe equipe1, Equipe equipe2, int score1, int score2){
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.scoreEquipe1 = score1;
        this.scoreEquipe2 = score2;
    }
}
