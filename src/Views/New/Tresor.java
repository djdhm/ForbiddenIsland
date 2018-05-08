package Views.New;

import Models.Cle;
import Models.ElementArtefact;

import java.awt.*;

public class Tresor extends JPanelImage {
    public Tresor(ElementArtefact cle) {
        super("./res/images/tresors/"+cle.toString()+".png");
        setOpaque(false);

    }
}
