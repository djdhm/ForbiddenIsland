package Views.New;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class JPanelMenu extends JPanel {

    private JPanel          titre;
    private JButton         quitter;
    private JPanel          card;
    private JPanel          grid;
    private JButton         jouer;
    private JButton         score;
    private JButton         tuto;
    private JButton         option;
    private Image  backGroundImage;
    private JLabel          titreLabel;

    public static final String JEU    = "jeu";
    public static final String MAIN   = "main";
    public static final String TUTO   = "tuto";
    public static final String OPTION = "option";
    public static final String SCORES = "scores";


    public JPanelMenu() {
        super();
        try{
            backGroundImage= ImageIO.read(new File("./res/images/background.jpg"));
        }catch (Exception e){
                System.out.println("Test Image");
        }
        setLayout(new BorderLayout());
        initComponent();
        initLayout();

    }
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(backGroundImage,0,0,null);

    }

    public void initComponent() {


        titre = new JPanel();
        add(titre, BorderLayout.NORTH);
        quitter = new JButton("quitter");
        add(quitter, BorderLayout.SOUTH);
        card = new JPanel(new CardLayout());
        add(card, BorderLayout.CENTER);

        // ** les cardlayout**//

        // le main
        grid = new JPanel(new GridLayout(6, 1));
        card.add(grid, "main");
        jouer = new JButton("jouer");
        grid.add(jouer);
        option = new JButton("option");
        grid.add(option);
        score = new JButton("scores");
        grid.add(score);
        tuto = new JButton("tutoriel");
        grid.add(tuto);

        // les options
//        optionPanel = new JPanelOption();
//        card.add(optionPanel, "option");
//
//        // les scores
//        scorePanel = new JPanelScore();
//        card.add(scorePanel, "scores");
//
//        // les options du jeu
//        jeu = new JPanelOptionJeu(this);
//        card.add(jeu, "jeu");

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

                    System.out.println("Printing logo");

                    getCardLayout().show(getSuperParent(), "tutoPanel");

                } else if (e.getSource().equals(quitter)) {

                    quitter();

                }
            }

        };

        jouer.addActionListener(listener);
        option.addActionListener(listener);
        score.addActionListener(listener);
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


//    public void addObs(Observer observer) {
//        jeu.addObs(observer);
//    }
//
//
//    public JPanelOptionJeu getjeu() {
//        return jeu;
//    }

}
