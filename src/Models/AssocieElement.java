package Models;

public class AssocieElement extends Zone {

        private  Artefact element;


    public AssocieElement(Artefact element) {
        this.element = element;
    }

    public Artefact getElement() {
        return element;
    }

    public void recupererTresor(Joueur joueur){
        joueur.recevoirTresor(element.getElement());
        element=null;

        notifyObservers();

    }

}
