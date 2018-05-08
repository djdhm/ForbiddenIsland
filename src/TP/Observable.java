package TP;

import java.util.ArrayList;

/**
 * Classe des objets pouvant Ãªtre observÃ©s.
 */
public abstract class Observable {
    /**
     * On a une liste [observers] d'observateurs, initialement vide, Ã  laquelle
     * viennent s'inscrire les observateurs via la mÃ©thode [addObserver].
     */
    private ArrayList<Observer> observers;
    public Observable() {
        this.observers = new ArrayList<Observer>();
    }
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Lorsque l'Ã©tat de l'objet observÃ© change, il est convenu d'appeler la
     * mÃ©thode [notifyObservers] pour prÃ©venir l'ensemble des observateurs
     * enregistrÃ©s.
     * On le fait ici concrÃ¨tement en appelant la mÃ©thode [update] de chaque
     * observateur.
     */
    public void notifyObservers() {
        for(Observer o : observers) {
            System.out.println(this+"Test Observer "+observers);

            if(o!=null){
                o.update();
            }
        }
    }
}
/** Fin du schÃ©ma observateur/observÃ©. */
