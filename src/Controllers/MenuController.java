package Controllers;

import Views.MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    private MenuPrincipal menu;
    public MenuController(MenuPrincipal menu){
        this.menu=menu;
    }

    public void actionPerformed(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            this.menu.afficherTutorial();
            
    }
}
