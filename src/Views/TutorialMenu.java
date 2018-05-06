package Views;

import Views.New.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class TutorialMenu extends JPanel {
    CardLayout pages;
    private JPanelImage page1=new JPanelImage("./res/images/tutorial/page1.jpg");
    private JPanelImage page2=new JPanelImage("./res/images/tutorial/page2.jpg");
    private JPanelImage page3=new JPanelImage("./res/images/tutorial/page3.jpg");
    private JPanelImage page4=new JPanelImage("./res/images/tutorial/page4.jpg");
    private JPanelImage page5=new JPanelImage("./res/images/tutorial/page5.jpg");
    private JPanelImage page6=new JPanelImage("./res/images/tutorial/page6.jpg");
    private JPanelImage page7=new JPanelImage("./res/images/tutorial/page7.jpg");
    private JPanelImage page8=new JPanelImage("./res/images/tutorial/page8.jpg");
    int indice;

    public TutorialMenu(){
        super();
        setFocusable(true);
        pages=new CardLayout();
        setLayout(pages);
        setPreferredSize(new Dimension(450,600));
        setMaximumSize(new Dimension(450,600));
        setMinimumSize(new Dimension(450,600));
        indice=1;
        add(page1,"page1");
        add(page2,"page2");
        add(page3,"page3");
        add(page4,"page4");
        add(page5,"page5");
        add(page6,"page6");
        add(page7,"page7");
        add(page8,"page8");
        pages.show(this,"page1");
        initialiserEvenement();


    }

    private void initialiserEvenement(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("TestClavier"+e.getKeyCode());
                switch (e.getKeyCode()){
                    case 39:
                        pageSuivante();
                        break;
                    case 37:
                        pagePrecedente();
                        break;

                }
            }
        });



    }


    private  void pageSuivante(){
        if(indice<8){
            pages.show(this,"page"+(++indice));
        }
    }

    private  void pagePrecedente(){
        if(indice!=1){
            pages.show(this,"page"+(--indice));
        }
    }
}
