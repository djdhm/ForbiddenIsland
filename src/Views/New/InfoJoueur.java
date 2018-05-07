package Views.New;
import Models.Carte;
import Models.Cle;
import Models.Joueur;
import TP.Observer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



public class InfoJoueur extends JPanel implements Observer {

    private Joueur joueur;
    private ArrayList<Cle> cles;
    private JPanel inventory;
    private boolean left;
    private boolean top;
    private GridBagConstraints gLCC;
    private GridBagConstraints gLCT;
    private JPanel treasure;
    private Observer obs;


    public InfoJoueur(boolean left, boolean top,Joueur joueur) {
        this.joueur=joueur;
        this.left = left;
        this.top = top;
        cles=new ArrayList<>();
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        initLayout();
        initTreasures();
    }


    /**
     * @author nihil
     */
    private void initTreasures() {
        treasure = new JPanel();
        GridBagLayout lT = new GridBagLayout();
        gLCT = new GridBagConstraints();
        lT.columnWidths = new int[2];
        lT.rowHeights = new int[2];
        double[] nb = {0.5, 0.5};
        lT.columnWeights = nb;
        lT.rowWeights = nb;

        treasure.setLayout(lT);
        if (left) {
            treasure.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        } else {
            treasure.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));
        } // end if
        gLCT.gridheight = 1;
        gLCT.gridwidth = 1;
        gLCT.weighty = 1;
        gLCT.fill = GridBagConstraints.BOTH;

        gLCC.gridx = left ? 0 : 6; // 0 for left *...... inventories and 6 for right ......*
        add(treasure, gLCC);
    }


    /**
     * @author nihil
     */
    private void initLayout() {
        GridBagLayout lT = new GridBagLayout();
        if (left) {
            double[] nb = {0.25, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2};
            lT.columnWeights = nb;
        } else {
            double[] nb = {0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.25};
            lT.columnWeights = nb;
        } // end if
        // to set the number of columns
        int[] nb2 = new int[7];
        lT.columnWidths = nb2;
        gLCC = new GridBagConstraints();

        setLayout(lT);
        gLCC.gridy = 0;
        gLCC.gridheight = 1;
        gLCC.gridwidth = 1;
        gLCC.ipadx = 10;
        gLCC.weighty = 1;
        gLCC.fill = GridBagConstraints.BOTH;
    }

    public void ajouterCarte(Cle cle) {

        if (left) {
            cles.add(cle);
            gLCC.gridx = cles.size();
            add(new CarteCle(cle), gLCC);
        } else {
            cles.add(cle);
            gLCC.gridx = 6 - cles.size();
            add(new CarteCle(cle), gLCC);
        } // end if

    }// end
    // addCard


    public void addTreasure(Cle cle) {
        int nb = (treasure.getComponentCount()) % 2;
        if (left && top) {
            gLCT.gridx = nb;
            gLCT.gridy = ((((treasure.getComponentCount() - nb) + 1) % 3) + 1) % 2;
        } else if (!left && top) {
            gLCT.gridx = (nb + 1) % 2;
            gLCT.gridy = ((((treasure.getComponentCount() - nb) + 1) % 3) + 1) % 2;
        } else if (left && !top) {
            gLCT.gridx = nb;
            gLCT.gridy = (((treasure.getComponentCount() - nb) + 1) % 3) % 2;
        } else {
           gLCT.gridx = (nb + 1) % 2;
            gLCT.gridy = (((treasure.getComponentCount() - nb) + 1) % 3) % 2;
        } // end if
        treasure.add(new Tresor(cle), gLCT);
    }// end
//    // name
//
//
//    /**
//     * @author nihil
//     *
//     * @param cardPlace
//     * place of the card in the player inventory to remove
//     */
////    public void removeCard(int cardPlace) {
////        if (left) {
////            remove(cards.remove(cardPlace - 1));
////            for (int i = cardPlace; i < cards.size(); i++) {
////                remove(cards.get(i));
////                gLCC.gridx = i + 1;
////                add(cards.get(i).setCardPlace(i + 1), gLCC);
////            } // end for
////        } else {
////            remove(cards.remove(5 - cardPlace));
////            for (int i = cardPlace; i > 5 - cards.size(); i--) {
////                remove(cards.get(5 - i));
////                gLCC.gridx = i;
////                add(cards.get(5 - i).setCardPlace(cardPlace - cards.size() + 1), gLCC);
////            } // end for
////        } // end if
////        doLayout();
////    }// end removeCard
//
//
    /**
     * @author nihil
     *
     */
//    public PlayerCard getCard(int i) {
//        return cards.get(left ? i - 1 : 5 - i);
//    }
//

    /**
     * @return the cards
//     */
//    public ArrayList<PlayerCard> getCards() {
//        return cards;
//    }
//

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)(1000* 0.3), (int) (1000 * 0.1));
    }

    @Override
    public void update() {
        System.out.println("affichage et mise a jour ");
        
        for (Cle cle:this.cles
             ) {
            ajouterCarte(cle);
        }
        this.repaint();

    }


    /**
     * @author nihil
//     *
//     */
//    public void addObs(Observer obs) {
//        if (obs instanceof GameController) {
//            this.obs = obs;
//        } // end if
//    }

}
