package Views;

import Views.New.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    TutorialMenu  getElement(){
        return this;
    }
    private MouseListener eventHandler=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(indice==9){
                indice=0;
            }
            pages.show(getElement(),"page"+(indice++));

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
    private void initialiserEvenement(){

        page1.addMouseListener(eventHandler);
        page2.addMouseListener(eventHandler);
        page3.addMouseListener(eventHandler);
        page4.addMouseListener(eventHandler);
        page5.addMouseListener(eventHandler);
        page6.addMouseListener(eventHandler);
        page7.addMouseListener(eventHandler);
        page8.addMouseListener(eventHandler);
    }



}
