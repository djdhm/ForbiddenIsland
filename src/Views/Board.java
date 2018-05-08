package Views;


import Controllers.PaquetController;
import Controllers.PartieController;
import Models.*;
import TP.Observer;
import Views.New.*;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.ArrayList;

public class Board extends  JPanel implements Observer {

    static Dimension PositionDepart[]={
            new Dimension(1,1),
            new Dimension(1,4),
            new Dimension(4,1),
            new Dimension(4,4)
    };


    PartieController controller;
    private Partie partie;
    JTextPane tour;
    JTextPane infoJeu;
    JTextPane copyright;
    private ZoneView zone;
    JPanel ouest;
    JPanel est;
    JPanel sud;
    JPanel nord;
    JPanel listAction;
    InfoJoueur cadreJoueur[];
    private JPanel vuePaquets;
    private CleView zoneCle[];
    private VuePaquet paquetZones;
    private VuePaquet paquetCles;
    private JTextPane infoTresor;


    public ZoneView getZone() {
        return zone;
    }

    public Board(){
        cadreJoueur=new InfoJoueur[4];
        tour=new JTextPane();
        infoJeu=new JTextPane();
        infoTresor=new JTextPane();
        copyright=new JTextPane();
        tour.setEditable(false);
        infoJeu.setEditable(false);
        copyright.setEditable(false);
        tour.setBackground(new Color(0,0,0,10));
        infoTresor.setBackground(new Color(0,0,0,5));
        infoJeu.setBackground(new Color(0,0,0,20));
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attribs,true);
        StyleConstants.setFontSize(attribs,15);
        tour.setParagraphAttributes(attribs, true);
        infoJeu.setParagraphAttributes(attribs,true);
        copyright.setParagraphAttributes(attribs,true);
        infoTresor.setParagraphAttributes(attribs,true);
        copyright.setText("Ce projet est realisé dans le cadre de TP ....");

        zoneCle=new CleView[4];
        ouest=new JPanel(new BorderLayout());
        est = new JPanel(new BorderLayout());
        sud=new JPanel(new BorderLayout());
        nord=new JPanel(new GridLayout(3,1,5,5));
        zone=new ZoneView(this.partie);

        vuePaquets =new JPanel(new GridLayout(2,1,15,0));

//        initAffichage();

        setLayout(new BorderLayout());
        add(zone,BorderLayout.CENTER);
        add(ouest,BorderLayout.WEST);
        add(est,BorderLayout.EAST);
        add(nord,BorderLayout.NORTH);
        add(sud,BorderLayout.SOUTH);
        setVisible(true);
        setSize(new Dimension(480,640));
    }
    private void  initAffichage(){
        // Ajout des buttons des actions
        JButton endTurnBtn = new DregerButton("Fin de tour");
        endTurnBtn.addActionListener(controller);
        JButton moveBtn = new DregerButton("Se deplacer");
        moveBtn.addActionListener(controller);
        JButton shoreUpBtn = new DregerButton("Assecher Zone");
        shoreUpBtn.addActionListener(controller);
      //  JButton useCapacityBtn = new DregerButton("Utiliser sa capacité");
        JButton discardCard = new DregerButton("Défausser une carte");
        JButton invoque = new DregerButton("Recuperer un tresor");
        invoque.addActionListener(controller);
        JButton giveCard = new DregerButton("Donner une carte");
        JButton useCard = new DregerButton("Utiliser une carte");
        JButton senvoler =new DregerButton("S'envoler ");
        senvoler.addActionListener(controller);
        listAction=new JPanel(new GridLayout(8,1,2,2));
        listAction.add(endTurnBtn);
        listAction.add(discardCard);
        listAction.add(moveBtn);
        listAction.add(shoreUpBtn);
        listAction.add(invoque);
        listAction.add(senvoler);

        est.add(listAction,BorderLayout.CENTER);
        //ajout des zone de cle
        //Ajout des zones D'informations (Tour et nombre Action ) et INFO
        nord.add(infoTresor);
        nord.add(infoJeu);
        nord.add(tour);
        sud.add(copyright,BorderLayout.CENTER);
        // Ajout Des PAquets de cartes
        ouest.add(vuePaquets,BorderLayout.CENTER);
        initialiserPaquet();
        ajouterJoueurs();


    }

    public void initialiserPartie(Partie partie){
            this.partie=partie;
          //  partie.addObserver(this);
            this.zone.setPartie(partie);
             controller=new PartieController(partie,this);
             initAffichage();
          //  partie.initialiserPartie();
            zone.loadZones(partie.getGrille());
            ajouterJoueurs();
    }
    private void initialiserPaquet(){

        paquetZones=new VuePaquet(this.partie.getPaquetCarteZone());

        vuePaquets.add(paquetZones);
        paquetCles=new VuePaquet(this.partie.getPaquqetCarteCle());
        this.partie.getPaquetCarteZone().addObserver(paquetZones);
        this.partie.getPaquqetCarteCle().addObserver(paquetCles);
        vuePaquets.add(paquetCles);
        new PaquetController(vuePaquets,paquetZones,paquetCles, partie);



    }
    public void ajouterJoueurs(){

        // Pour savoir comment dessiner le Cadre de joueur selon sa position
        //
        Boolean contraintesGauche[]= {true,false,true,false};
        Boolean contraintesHaut[]={true,true,false,false};
        ArrayList<Joueur> listeJoueurs=this.partie.getJoueurs();
        int i;
        for(i=0;i<listeJoueurs.size()&&i<4;i++){
            cadreJoueur[i]=new InfoJoueur(contraintesGauche[i],contraintesHaut[i],listeJoueurs.get(i));
          //  listeJoueurs.get(i).getInventaire().addObserver(cadreJoueur[i]);
        }

        cadreJoueur[0].setBorder(Graphiques.ACTIVE_BORDER_SELECTED);
        ouest.add(cadreJoueur[0],BorderLayout.NORTH);
        if(cadreJoueur[2]!=null) ouest.add(cadreJoueur[2],BorderLayout.SOUTH);
        est.add(cadreJoueur[1],BorderLayout.NORTH);
        if(cadreJoueur[3]!=null) est.add(cadreJoueur[3],BorderLayout.SOUTH);
        for (int l=0;l<partie.getJoueurs().size();l++) {
            System.out.println(partie.getGrille().getZone(PositionDepart[l].width,PositionDepart[l].height));
            this.partie.getJoueurs().get(l).setPosition(partie.getGrille().getZone(PositionDepart[l].width,PositionDepart[l].height));
        }

    }


    public void setPartie(Partie partie) {
        this.partie = partie;
    }



    @Override
    public void update() {
        // Mise a jour de l'affichage de la fenetre de la partie

        this.infoTresor.setText("Vous avez rassemblez  "+this.partie.getNombreTresors() + " Tresors Jusqu'a maintenant");
        this.infoJeu.setText("Il vous reste "+this.partie.getNombreAction()+" A jouer !   ");
        this.tour.setText("Tour de Joueur : "+this.partie.getNomJoueurActuel()+"     ");
        boolean resteActionTour=(this.partie.getNombreAction()!=0);
        listAction.getComponent(0).setEnabled(true);
        for(int k=1;k<listAction.getComponents().length;k++){
            listAction.getComponent(k).setEnabled(resteActionTour);

        }
        listAction.getComponent(5).setEnabled(this.partie.getJoueurActuel().getPosition()  instanceof Heliport);
        listAction.getComponent(4).setEnabled(this.partie.getJoueurActuel().getPosition() instanceof AssocieElement);

        // Recherche et coloriage des zones adjacentes a la case de joueur
        // Pour la selection
        Dimension dim;
        for (Zone z:this.partie.getGrille().getZoneAdjacentes(this.partie.getJoueurActuel().getPosition())
             ) {
            z.setTypeSelection(1);
        }
//        Dimension pos=this.partie.getGrille().chercherZone(this.partie.getJoueurActuel().getPosition());
//        Dimension ancienPos=this.partie.getGrille().chercherZone(this.partie.getJoueurActuel().getAnciennePosition());
//        System.out.println("Retirer le joueur ....a "+ancienPos.height+" "+ancienPos.width);
//        this.zone.retirerJoueur(partie.getJoueurActuel(),ancienPos.width,ancienPos.height);
//        this.zone.positionnerJoueur(partie.getJoueurActuel(),pos.width,pos.height);

        repaint();
    }

    public void afficherMessageVictoire() {
//        JOptionPane.showConfirmDialog(this,"Vous avez Gagne!!");
        JOptionPane.showMessageDialog(this,"Vous avez Gagne la partie ! Bravo! :) ");
        System.exit(0);
    }

    public void afficherMessagePerte() {
        JOptionPane.showMessageDialog(this,"Vous avez Perdu :( :( ");
        System.exit(0);
    }
}
