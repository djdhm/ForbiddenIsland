package Controllers;


import Models.Partie;
import Models.Zone;
import Views.New.JPanelImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ZoneController implements ActionListener,MouseListener{

    Partie partie;
    JPanelImage vue;
    Zone zone;

    public ZoneController(JPanelImage vue,Zone zone ){
        this.zone=zone;
        this.vue =vue;
        this.vue.ajouterListenerSouris(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        //    partie.getJoueurActuel().setPosition((Zone) e.getSource());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Salam Alikoum");
        if(e.getSource() instanceof JPanelImage){
            JPanelImage z= (JPanelImage) e.getSource();
            if(zone.getTypeSelection()==1){
                for (Zone adjacente:
                        partie.getGrille().getZoneAdjacentes(zone)) {
                    adjacente.setTypeSelection(0);

                }
            }
//            switch (z.getTypeSelection()){
//                case 1:
//                    System.out.println("Clique pour deplacement");
//                    break;
//                default:
//                        System.out.println("Clique pour Autre chose");
//                     break;
//
//            }
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
