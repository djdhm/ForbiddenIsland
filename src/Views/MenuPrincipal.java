package Views;

import Models.Joueur;
import Models.Partie;
import Views.New.JMenuPrincipal;
import Views.New.JPanelImage;
import Views.New.JPanelMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MenuPrincipal extends  JPanelImage {

    private JPanel lesBoutons;
    private JPanelImage background;
    private JPanel main;
    private JMenuPrincipal menu;
    private TutorialMenu tutorial ;
    public MenuPrincipal(){
        super("./res/images/background.png");
        menu=new JMenuPrincipal(this);
        tutorial=new TutorialMenu();
        ArrayList<Joueur> listeJ=new ArrayList<>();
        listeJ.add(new Joueur("Joueur 1",null));
        listeJ.add(new Joueur("Joueur 2 ",null));
        listeJ.add(new Joueur("Joueur 3",null));
        listeJ.add(new Joueur("Joueur 4",null));
        Partie partie= new Partie(listeJ);
       partie.initialiserPartie();
       Board board=new Board();
       board.initialiserPartie(partie);

        main=new JPanel(new CardLayout());
        main.add(menu,"menu");
        initSize();
        main.setBackground(new Color(0,0,0,0));
        setBackground(new Color(0,0,0,25));
    //    main.add(background,"test");
        main.add(tutorial,"tutorial");
        ((CardLayout)main.getLayout()).show(main,"menu");
        main.add(board,"jeu");
        this.add(main);
        main.setFocusable(true);
    }
    public void initSize(){
        this.main.setSize(480,640);


    }
    public void afficherTutorial(){
        System.out.println("Affichage de tutorial ..");
        (  (CardLayout) main.getLayout()).show(main,"tutorial");
    }

    public void afficherPlateau(){
        System.out.println("Affichage de Plateau de jeu  ..");
        (  (CardLayout) main.getLayout()).show(main,"jeu");
    }



}
