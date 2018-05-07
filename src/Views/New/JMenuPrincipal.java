package Views.New;


import Controllers.MenuController;
import Views.MenuPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class JMenuPrincipal extends JPanel {

    private MenuPrincipal menuPrincipal;
    private JPanel          titre;
    private DregerButton         quitter;
    private JPanel          card;
    private JPanel          grid;
    private DregerButton         jouer;
    private DregerButton         score;
    private DregerButton         tuto;
    private DregerButton         option;

    private JLabel          titreLabel;

    public static final String JEU    = "jeu";
    public static final String MAIN   = "main";
    public static final String TUTO   = "tuto";
    public static final String OPTION = "option";
    public static final String SCORES = "scores";


    public JMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal=menuPrincipal;
        setLayout(new BorderLayout());
        initComponent();
        initLayout();
        setOpaque(false);
    }


    public void initComponent() {

        titre = new JPanel();
        add(titre, BorderLayout.NORTH);
        quitter = new DregerButton("quitter");
        add(quitter, BorderLayout.SOUTH);
        card = new JPanel(new CardLayout());
        add(card, BorderLayout.CENTER);

        // ** les cardlayout**//

        // le main
        grid = new JPanel(new GridLayout(6, 1,15,15));
        grid.setBackground(new Color(0,0,0,10));
        card.add(grid, "main");
        jouer = new DregerButton("jouer");
        grid.add(jouer);
        option = new DregerButton("option");
        grid.add(option);
      //  score = new JButton("scores");
     //   grid.add(score);
        tuto = new DregerButton("tutoriel");
        grid.add(tuto);

        // les options


        // les scores


        // les options du jeu

        // le tuto
        // toutdoux tuto a faire

        // **fin**//

        titreLabel = new JLabel("L'Ile Interdite");
        titre.add(titreLabel);
    }


    /**
     *
     */
    public void initLayout() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(jouer)) {

                    ((CardLayout) (card.getLayout())).show(card, JEU);

                } else if (e.getSource().equals(option)) {

                    ((CardLayout) (card.getLayout())).show(card, OPTION);

                } else if (e.getSource().equals(score)) {

                    ((CardLayout) (card.getLayout())).show(card, SCORES);

                } else if (e.getSource().equals(tuto)) {

                    menuPrincipal.afficherTutorial();
                } else if (e.getSource().equals(quitter)) {

                    quitter();

                }
            }

        };


        jouer.addActionListener(listener);
        option.addActionListener(listener);
//        score.addActionListener(listener);
        tuto.addActionListener(listener);
        quitter.addActionListener(listener);
    }


    private JPanel getSuperParent() {
        return (JPanel) getParent().getParent();
    }


    private CardLayout getCardLayout() {
        return (CardLayout) getSuperParent().getLayout();
    }


    public void quitter() {
        System.exit(0);
    }


    public JPanel getCard() {
        return card;
    }





}
