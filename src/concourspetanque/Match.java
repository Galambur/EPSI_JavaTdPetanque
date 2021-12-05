package concourspetanque;

public class Match {
    public int id;
    public int numManche;
    public Equipe equipe1;
    public Equipe equipe2;
    public int scoreEquipe1;
    public int scoreEquipe2;
    
    public Match(int id, int numManche, Equipe equipe1, Equipe equipe2, int score1, int score2){
        this.id = id;
        this.numManche = numManche;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.scoreEquipe1 = score1;
        this.scoreEquipe2 = score2;
    }
    
    public void ajouterNbPartiesGagnees(){
        if(scoreEquipe1 > scoreEquipe2) {
            equipe1.scoreFinal = equipe1.scoreFinal + scoreEquipe1 - scoreEquipe2;
            equipe1.nombrePartiesGagnees++; 
        } else {
            equipe2.scoreFinal = equipe2.scoreFinal + scoreEquipe2 - scoreEquipe1;
            equipe2.nombrePartiesGagnees++;
        }
    }
    
    public void replaceEquipe2(Equipe e){
        this.equipe2 = e;
    }
}
