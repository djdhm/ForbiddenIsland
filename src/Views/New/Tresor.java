package Views.New;

import Models.Cle;

import java.awt.*;

public class Tresor extends JPanelImage {
    public Tresor(Cle cle) {
        super("./res/images/tresors/"+cle.getElementCle().toString()+".png");
        setOpaque(false);

    }
}
