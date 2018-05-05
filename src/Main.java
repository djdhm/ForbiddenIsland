import Controllers.PartieController;
import Controllers.ZoneController;
import Models.Grille;
import Models.Joueur;
import Models.PaquetRechercheCle;
import Models.Zone;
import Views.MenuPrincipal;
import Views.ZoneView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] argc){

        PartieController partieController=new PartieController();
        ArrayList<Joueur> listeJ=new ArrayList<>();
        listeJ.add(new Joueur("Djamel",null));
        listeJ.add(new Joueur("Zineb",null));
        partieController.initialiserPartie(listeJ);
        partieController.positionnerJoueurs(listeJ.get(0),2,2);
        partieController.positionnerJoueurs(listeJ.get(1),2,2);
        partieController.positionnerJoueurs(listeJ.get(0),1,1);
        JFrame main= new JFrame();
        main.add(partieController.getZoneView(),BorderLayout.CENTER);
        main.setSize(new Dimension(1000,1000));
        main.setResizable(false);
        main.pack();
        main.setVisible(true);
    }
}
