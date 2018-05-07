package Views.New;

import Controllers.ControlCle;
import Models.Cle;
import TP.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CleView extends JPanel implements Observer {


    public ControlCle controlleur;
    private ArrayList<JPanelImage> listeCle;
    public CleView() {
            setMinimumSize(new Dimension(100,100));


            setSize(new Dimension(100,40));
            setLayout(new GridLayout(1,4,5,5));
            setVisible(true);

    }

    public void ajouterCle(Cle cle){
        JPanelImage image=new JPanelImage(cle.toString());
            this.listeCle.add(image);
            this.add(image);

    }
    public void retirerCle(Cle cle){
            listeCle.remove(0);
            print();
    }

    private void print(){
        this.removeAll();
        for (JPanelImage image:listeCle
             ) {
            this.add(image);

        }
        repaint();
    }

    @Override
    public void update() {
        repaint();
    }
}
