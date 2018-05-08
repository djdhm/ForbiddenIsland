package Controllers;

import Models.Carte;
import Models.PaquetCarte;
import Models.Partie;
import Views.New.VuePaquet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaquetController  implements MouseListener{
    private VuePaquet vuePaquet;
    private PaquetCarte paquetCarte;
    private Partie partie;
    public PaquetController(PaquetCarte paquetCarte, VuePaquet vuePaquet, Partie partie){
        this.vuePaquet=vuePaquet;
        this.paquetCarte=paquetCarte;
        this.partie = partie;
        this.paquetCarte.addObserver(this.vuePaquet);
        vuePaquet.setPaquetCarte(paquetCarte);
        vuePaquet.ajouterSourisListener(this);

    }





    @Override
    public void mouseClicked(MouseEvent e) {
            if(paquetCarte.getNombreCarteARetirer()>0){
                System.out.println("Tirer Une Carte");
                Carte carte =paquetCarte.tirerCarte();
                carte.effetCarte(partie.getJoueurActuel());

            }
            else{
                System.out.println("C bon vous avez fini");
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
