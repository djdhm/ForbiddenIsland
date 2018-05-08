package Views;

import Views.New.JPanelImage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
        setLayout(new BorderLayout());
        setFocusable(true);
        JPanel centre=new JPanel();
        pages=new CardLayout();
        centre.setLayout(pages);
        setPreferredSize(new Dimension(300,600));
        centre.setMaximumSize(new Dimension(300,600));
        centre.setMinimumSize(new Dimension(300,600));
        indice=1;
        centre.add(page1,"page1");
        centre.add(page2,"page2");
        centre.add(page3,"page3");
        centre.add(page4,"page4");
        centre.add(page5,"page5");
        centre.add(page6,"page6");
        centre.add(page7,"page7");
        centre.add(page8,"page8");
        pages.show(centre,"page1");
        initialiserEvenement();
        add(centre, BorderLayout.CENTER);
        add(new JPanel(),BorderLayout.EAST);
        add(new JPanel(),BorderLayout.WEST);
        centre.setBorder(new EmptyBorder(20,150,20,150));

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
                    case 27:
                        System.exit(1);
                        break;
                }
            }
        });



                    page1.addMouseListener(eventHandler);
                    page2.addMouseListener(eventHandler);
                    page3.addMouseListener(eventHandler);
                    page4.addMouseListener(eventHandler);
                    page5.addMouseListener(eventHandler);
                    page6.addMouseListener(eventHandler);
                    page7.addMouseListener(eventHandler);
                    page8.addMouseListener(eventHandler);

    }

    MouseListener eventHandler=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            pageSuivante();
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
