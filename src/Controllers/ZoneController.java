package Controllers;


import Models.Grille;
import Models.Partie;
import Models.Zone;
import Views.New.Graphiques;
import Views.New.JPanelImage;
import Views.ZoneView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoneController implements ActionListener{

    Partie partie;
    ZoneView zones;

    public ZoneController(Partie partie,ZoneView zone ){
        this.partie=partie;
        this.zones=zone;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

            partie.getJoueurActuel().setPosition((Zone) e.getSource());
    }
}
