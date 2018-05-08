import Controllers.PartieController;
import Controllers.ZoneController;
import Models.*;
import Views.Board;
import Views.MenuPrincipal;
import Views.New.JMenuPrincipal;
import Views.New.JPanelImage;
import Views.TutorialMenu;
import Views.ZoneView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] argc){

//      PartieController partieController=new PartieController();
       ArrayList<Joueur> listeJ=new ArrayList<>();
        listeJ.add(new Joueur("Djamel",null));
        listeJ.add(new Joueur("Zineb",null));
        listeJ.add(new Joueur("Dahmane",null));
        listeJ.add(new Joueur("Test",null));
       Partie partie= new Partie(listeJ);
        partie.initialiserPartie();
//        partieController.positionnerJoueurs(listeJ.get(0),2,2);
//        partieController.positionnerJoueurs(listeJ.get(1),2,2);
//        partieController.positionnerJoueurs(listeJ.get(2),2,2);
//        partieController.positionnerJoueurs(listeJ.get(3),2,2);
//        partieController.positionnerJoueurs(listeJ.get(0),1,1);
//        partieController.selectionZone(2,2);
//        partieController.innonderZone(1,2);
//        JPanelImage menu =new JPanelImage("./res/images/background.png");
      //  menu.add(new MenuPrincipal() );
        JFrame main= new JFrame();
        Board board=new Board();
        board.initialiserPartie(partie);

        main.add(board);
        main.setSize(new Dimension(1000,1000));
        main.setResizable(true);
        main.pack();
        main.setVisible(true);
    }
}
