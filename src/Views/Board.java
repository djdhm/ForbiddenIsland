package Views;


import Models.*;
import Views.New.CleView;
import Views.New.DregerButton;
import Views.New.InfoJoueur;
import Views.New.VuePaquet;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.ArrayList;

public class Board extends  JPanel {


    Partie partie;
    JTextPane tour;
    JTextPane copyright;
    private ZoneView zone;
    JPanel ouest;
    JPanel est;
    JPanel sud;
    JPanel nord;
    JPanel listAction;
    JPanel paquetsCarte;
    private CleView zoneCle[];

    public ZoneView getZone() {
        return zone;
    }

    public Board(){


        tour=new JTextPane();
        copyright=new JTextPane();
        tour.setEditable(false);
        copyright.setEditable(false);
        tour.setBackground(new Color(0,0,0,20));
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        tour.setParagraphAttributes(attribs, true);
        copyright.setParagraphAttributes(attribs,true);
        copyright.setText("Ce projet est realisé dans le cadre de TP ....");
        tour.setText("Tour de Monsiieur");

        zoneCle=new CleView[4];
        ouest=new JPanel(new BorderLayout());
        est = new JPanel(new BorderLayout());
        sud=new JPanel(new BorderLayout());
        nord=new JPanel(new BorderLayout());
        zone=new ZoneView();
        paquetsCarte=new JPanel(new GridLayout(2,1,15,0));

    initAffichage();
        setLayout(new BorderLayout());
        add(zone,BorderLayout.CENTER);
        add(ouest,BorderLayout.WEST);
        add(est,BorderLayout.EAST);
        add(nord,BorderLayout.NORTH);
        add(sud,BorderLayout.SOUTH);
        ajouterJoueur();
        setVisible(true);
        setSize(new Dimension(480,640));
    }
    private void  initAffichage(){
        // Ajout des buttons des actions
        JButton endTurnBtn = new DregerButton("Fin de tour");
        JButton moveBtn = new DregerButton("Se déplacer");
        JButton shoreUpBtn = new DregerButton("Assécher un endroit");
        JButton useCapacityBtn = new DregerButton("Utiliser sa capacité");
        JButton discardCard = new DregerButton("Défausser une carte");
        JButton invoque = new DregerButton("Invoquer un trésor");
        JButton giveCard = new DregerButton("Donner une carte");
        JButton useCard = new DregerButton("Utiliser une carte");
        listAction=new JPanel(new GridLayout(8,1,2,2));
        listAction.add(endTurnBtn);
        listAction.add(moveBtn);
        listAction.add(shoreUpBtn);
        listAction.add(useCapacityBtn);
        listAction.add(discardCard);
        listAction.add(giveCard);
        listAction.add(useCard);
        listAction.add(invoque);
        est.add(listAction,BorderLayout.CENTER);
        //ajout des zone de cle
        nord.add(tour,BorderLayout.CENTER);
        sud.add(copyright,BorderLayout.CENTER);
        // Ajout Des PAquets de cartes
        ouest.add(paquetsCarte,BorderLayout.CENTER);
        initialiserPaquet();

    }

    public void initialiserPartie(Partie partie){
            partie.initialiserPartie();
            zone.loadZones(partie.getGrille());

    }
    private void initialiserPaquet(){
        paquetsCarte.add(new VuePaquet(new PaquetCarteZone()));
        paquetsCarte.add(new VuePaquet(new PaquetRechercheCle()));

    }
    public void ajouterJoueur(){
        InfoJoueur info=new InfoJoueur(false,true);
        InfoJoueur info2=new InfoJoueur(true,true);
        InfoJoueur info3=new InfoJoueur(true,false);
        InfoJoueur info4=new InfoJoueur(false,false);
        info.ajouterCarte(new Cle(ElementArtefact.TERRE));
        info.ajouterCarte(new Cle(ElementArtefact.TERRE));
        info.ajouterCarte(new Cle(ElementArtefact.TERRE));
        info2.addTreasure(new Cle(ElementArtefact.EAU));
        info2.addTreasure(new Cle(ElementArtefact.FEU));
        info.addTreasure(new Cle(ElementArtefact.FEU));
        est.add(info,BorderLayout.NORTH);
        est.add(info4,BorderLayout.SOUTH);
        ouest.add(info3,BorderLayout.NORTH);
        ouest.add(info2,BorderLayout.SOUTH);

    }



}
