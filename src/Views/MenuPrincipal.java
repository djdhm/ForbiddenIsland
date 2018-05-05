package Views;

import Views.New.JPanelImage;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends  JFrame{

    private JPanel lesBoutons;
    private JPanelImage background;
    private JPanel main;
    public MenuPrincipal(){

        background=new JPanelImage();
        main=new JPanel(new CardLayout());



        main.add(background,"test");

    }
    public void initSize(){
        this.main.setSize(400,500);

    }


}
