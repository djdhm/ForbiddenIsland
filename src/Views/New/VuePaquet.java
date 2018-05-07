package Views.New;

import Models.PaquetCarte;
import Models.PaquetCarteZone;

import javax.swing.*;
import java.awt.*;

public class VuePaquet extends JPanel {


    private PaquetCarte paquetCarte;
    private  JPanelImage image;
    private  JTextPane text;
    public VuePaquet(PaquetCarte paquetCarte){
        this.paquetCarte=paquetCarte;
        setLayout(new GridLayout(2,1,15,5));

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
}

