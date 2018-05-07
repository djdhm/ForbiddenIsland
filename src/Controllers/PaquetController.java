package Controllers;

import Models.Carte;
import Models.PaquetCarte;
import Views.New.VuePaquet;

public class PaquetController {
    private VuePaquet vuePaquet;
    private PaquetCarte paquetCarte;

    public PaquetController(PaquetCarte paquetCarte,VuePaquet vuePaquet){
        this.vuePaquet=vuePaquet;
        this.paquetCarte=paquetCarte;
        vuePaquet.setPaquetCarte(paquetCarte);

    }

    public Carte tirerCarte(){
        return paquetCarte.tirerCarte();

    }


}
