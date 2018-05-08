package Views.New;

import Controllers.PaquetController;
import Models.PaquetCarte;
import Models.PaquetCarteZone;
import TP.Observer;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;

public class VuePaquet extends JPanel implements Observer {


    private PaquetCarte paquetCarte;
    private  JPanelImage image;
    private  JTextPane text;
    private boolean selectionne;
    public VuePaquet(PaquetCarte paquetCarte){


        this.paquetCarte=paquetCarte;
        selectionne=false;
        setLayout(new GridLayout(2,1,15,20));

        image=new JPanelImage(VuePaquet.getImagePath(paquetCarte,false));
        text=new JTextPane();

        text.setText(getText(paquetCarte));

        add(image);
        add(text);

    }



    private String getText(PaquetCarte paquetCarte){
        if(paquetCarte instanceof PaquetCarteZone){
            return "Paquet Carte Zones ";
        }else{
            return "Paquet Carte Clés";
        }
    }

    private static String getImagePath(PaquetCarte carte,boolean selectionne){
        if(carte instanceof PaquetCarteZone){
            if(selectionne){
                return "./res/images/cards/Card_BackSelect@2x.png";

            }
            else{
                return "./res/images/cards/Card_Back@2x.png";

            }
        }else{
            if(selectionne){
                return "./res/images/cards/Flood_Card_BackSelect@2x.png";
            }else{
                return "./res/images/cards/Flood_Card_Back@2x.png";

            }
        }
    }

    public void setPaquetCarte(PaquetCarte paquetCarte) {
        this.paquetCarte = paquetCarte;
    }

    public void ajouterSourisListener(PaquetController paquetController) {
            this.addMouseListener(paquetController);
    }

    @Override
    public void update() {
        selectionne=!selectionne;
        if(selectionne){
            setBorder(Graphiques.ACTIVE_BORDER_SELECTED);
            text.setText("Tirer une carte ...");

        }else{
            setBorder(Graphiques.INACTIVE_BORDER);

        }

    }
}

