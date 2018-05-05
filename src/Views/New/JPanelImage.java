package Views.New;


import Models.Joueur;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class JPanelImage extends JPanel {
    private String image;
    ArrayList<Joueur> joueurs;
    public JPanelImage(String path)
    {
        super();
        joueurs=new ArrayList<>();
        this.setSize(new Dimension(200,200));
        this.image=path;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage bImage = ImageIO.read(new File( image));
            BufferedImage jImage ;
            g.drawImage(bImage, 2, 2, (int) getSize().getWidth(), (int) getSize().getHeight(), this);
           for(int k=0;k<joueurs.size();k++) {
                jImage= ImageIO.read(new File(Graphiques.Pions[joueurs.get(k).getId()]));
                System.out.println("Affichage des joueurs X:"+32*(int)(k%2) +" Y:"+ (getSize().getHeight()/2-40*(k/2)));
                g.drawImage(jImage,32*(k%2), (int) getSize().getHeight()/2-40*(int)(k/2),28,40, this);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterJoueur(Joueur j) {
        this.joueurs.add(j);
        this.repaint();
    }
    public void innonderZone(String path){
        image=path;
        this.repaint();
    }

}
