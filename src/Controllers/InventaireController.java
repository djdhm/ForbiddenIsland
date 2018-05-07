package Controllers;

import Models.InventaireJoueur;
import Views.New.InfoJoueur;

public class InventaireController {

    private InfoJoueur infoJoueur;
    private InventaireJoueur inventaireJoueur;

    public InventaireController(InventaireJoueur inventaire,InfoJoueur info){
            this.inventaireJoueur=inventaire;
            this.infoJoueur=info;
            inventaire.addObserver(info);

    }

}
