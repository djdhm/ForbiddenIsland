import Controllers.PartieController;
import Controllers.ZoneController;
import Models.Grille;
import Models.Joueur;
import Models.PaquetRechercheCle;
import Models.Zone;
import Views.MenuPrincipal;
import Views.TutorialMenu;
import Views.ZoneView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] argc){

//        PartieController partieController=new PartieController();
//        ArrayList<Joueur> listeJ=new ArrayList<>();
//        listeJ.add(new Joueur("Djamel",null));
//        listeJ.add(new Joueur("Zineb",null));
//        listeJ.add(new Joueur("Dahmane",null));
//        listeJ.add(new Joueur("Test",null));
//        partieController.initialiserPartie(listeJ);
//        partieController.positionnerJoueurs(listeJ.get(0),2,2);
//        partieController.positionnerJoueurs(listeJ.get(1),2,2);
//        partieController.positionnerJoueurs(listeJ.get(2),2,2);
//        partieController.positionnerJoueurs(listeJ.get(3),2,2);
//        partieController.positionnerJoueurs(listeJ.get(0),1,1);
//        partieController.selectionZone(2,2);
//        partieController.innonderZone(1,2);
        TutorialMenu tuto=new TutorialMenu();
        JFrame main= new JFrame();
        main.add(tuto   ,BorderLayout.CENTER);
        main.setSize(new Dimension(1000,1000));
        main.setResizable(false);
        main.pack();
        main.setVisible(true);
    }
}
