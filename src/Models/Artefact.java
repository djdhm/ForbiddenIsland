package Models;

public class Artefact {
    private int idArtefacte;
    private ElementArtefact elementArtefact;
    static  int idCompteur=1;


    public Artefact(ElementArtefact elementArtefact){
        this.idArtefacte=idCompteur++;
        this.elementArtefact=elementArtefact;
    }

    public ElementArtefact getElementArtefact() {
        return elementArtefact;
    }


    public int getIdArtefacte() {
        return idArtefacte;
    }


}
