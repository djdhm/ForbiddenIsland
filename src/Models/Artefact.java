package Models;

import javafx.scene.shape.ArcTo;

import java.util.HashMap;

public class Artefact {
    private int idArtefacte;
    private ElementArtefact elementArtefact;
    static  int idCompteur=1;
    static HashMap<ElementArtefact,Artefact> listeArtefact=new HashMap<>();
    public Artefact(ElementArtefact elementArtefact){
        this.idArtefacte=idCompteur++;
        this.elementArtefact=elementArtefact;
    }

    public static Artefact getArtefactElement(ElementArtefact elementArtefact) {
        Artefact artefact=listeArtefact.get(elementArtefact);
        if(artefact==null){
            artefact=new Artefact(elementArtefact);
            listeArtefact.put(elementArtefact,artefact);
        }
        return artefact;
    }



    public ElementArtefact getElement(){
        return  elementArtefact;
    }
    public String getElementArtefact() {
        return elementArtefact.toString();
    }
}
