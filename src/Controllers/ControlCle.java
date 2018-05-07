package Controllers;

import Models.ElementArtefact;
import Models.InventaireJoueur;
import Views.New.CleView;

import java.util.ArrayList;

public class ControlCle {

    private InventaireJoueur inventaireJoueurs;
    private CleView vue;
    public ControlCle(InventaireJoueur inventaireJoueur,CleView vue){

        this.inventaireJoueurs=inventaireJoueur;
        this.vue=vue;
    }

    public void  init(){
        inventaireJoueurs.addObserver(vue);


    }



}
