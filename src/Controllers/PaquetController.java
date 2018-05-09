package Controllers;

import Models.*;
import Views.New.Graphiques;
import Views.New.JPanelImage;
import Views.New.VuePaquet;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaquetController  {
//    private VuePaquet vuePaquet;
//    private PaquetCarte paquetCarte;
//    private Partie partie;
//    public PaquetController(PaquetCarte paquetCarte, VuePaquet vuePaquet, Partie partie){
//        this.vuePaquet=vuePaquet;
//        this.paquetCarte=paquetCarte;
//        this.partie = partie;
//        this.paquetCarte.addObserver(this.vuePaquet);
//        vuePaquet.setPaquetCarte(paquetCarte);
//        vuePaquet.ajouterSourisListener(this);
//
//    }

    VuePaquet paquetRechercheCle;
    VuePaquet paquetCarteZone;
    JPanel paquetVue;
    Partie partie;
    public PaquetController(JPanel vue,VuePaquet cartesZone,VuePaquet cartesCles, Partie partie){
        this.paquetCarteZone=cartesZone;
        this.paquetRechercheCle=cartesCles;

        this.paquetCarteZone.ajouterSourisListener(this.listenerZones);
        this.paquetRechercheCle.ajouterSourisListener(this.listenerCle);
        this.partie=partie;
        this.paquetVue=vue;
    }


    private MouseListener listenerZones=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Je dois retirer une carte zone");
            PaquetCarteZone cartesZone=partie.getPaquetCarteZone();
            System.out.println("Nombre d'action est : "+cartesZone.getNombreCarteARetirer());

            if(cartesZone.getNombreCarteARetirer()>0){
                System.out.println("Nombre d'action dedans est : "+cartesZone.getNombreCarteARetirer());

                if(cartesZone.getNombreCarteARetirer()==1){
                    System.out.println("Vous avez fini");
                    partie.selectionnerCarteCle();
                }
                CarteZone carte=(CarteZone)cartesZone.tirerCarte();
              //  JOptionPane.showMessageDialog(paquetVue,"Vous avez tirer une carte "+carte.toString());
                if(carte.aDefausser()){
                    partie.getPaquetCarteZone().poserDansDefausse(carte);
                }else{
                    carte.effetCarte(partie.getJoueurActuel());
                }
                if(partie.partiePerdu()){
                    partie.tourSuivant();
                }
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
    };

    private MouseListener listenerCle=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Je dois retirer une carte cle");
            if(partie.getPaquqetCarteCle().getNombreCarteARetirer()>0){
                //Carte carte = partie.getPaquqetCarteCle().tirerCarte();
                //carte.effetCarte(partie.getJoueurActuel());

                Carte carte=partie.getPaquqetCarteCle().tirerCarte();
                JOptionPane.showMessageDialog(paquetVue,"Vous avez tirer une carte "+carte.toString());
                carte.effetCarte(partie.getJoueurActuel());
                if(partie.partiePerdu()){
                    partie.notifyObservers();
                }
                if(partie.getPaquqetCarteCle().getNombreCarteARetirer()==0){
                    partie.tourSuivant();
                }
            }
            else{
                System.out.println("Attendez un peu");
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
    };

    public void setListenerZones(MouseListener listenerZones) {
        this.listenerZones = listenerZones;
    }

    public MouseListener getListenerZones() {
        return listenerZones;
    }

    public MouseListener getListenerCle() {
        return listenerCle;
    }
}
