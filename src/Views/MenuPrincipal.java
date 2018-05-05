package Views;

import Views.New.JPanelImage;
import Views.New.JPanelMenu;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends  JFrame{

    private JPanel lesBoutons;
    private JPanelImage background;
    private JPanel main;
    private JPanelMenu menu;

    public MenuPrincipal(){
        super();
        menu=new JPanelMenu();

        main=new JPanel(new CardLayout());
        main.add(menu,"menu");
        main.add(background,"test");

    }
    public void initSize(){
        this.main.setSize(1000,1000);
        this.add(main);

    }


}
