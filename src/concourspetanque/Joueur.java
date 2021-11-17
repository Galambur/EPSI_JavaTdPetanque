package concourspetanque;

public class Joueur {
    private int id;
    private String nom;
    private String prenom;
    private int numeroEquipe;
    
    // constructeur
    public Joueur(int id, String nom, String prenom){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEquipe = 0;
    }

    // getters et setters
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }   

    public int getId() {
        return this.id;
    }


    public int getNumeroEquipe() {
        return this.numeroEquipe;
    }

}
