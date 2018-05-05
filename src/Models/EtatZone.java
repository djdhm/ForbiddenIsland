package Models;

public enum EtatZone {
    SUBMERGEE(null),
    INNONDE(SUBMERGEE),
    NORMAL(INNONDE)
    ;
    private  EtatZone suivant;
    EtatZone(EtatZone etat){
        this.suivant=etat;
    }

    public EtatZone getSuivant() {
        return suivant;
    }

}
