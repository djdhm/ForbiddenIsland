package Views.New;

import Models.Cle;

public class CarteCle extends  JPanelImage {

    public CarteCle(Cle cle){
        super("./res/images/cles/"+cle.getElementCle().toString()+".png");

    }
}
