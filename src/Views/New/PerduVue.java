package Views.New;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class PerduVue extends JPanel {


    JTextPane texte ;
    public  PerduVue(){

        texte=new JTextPane();
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attribs,true);
        StyleConstants.setFontSize(attribs,40);
        texte.setParagraphAttributes(attribs, true);

        texte.setText("Vous Avez Perdu la partie ");

        add(texte);
        add(new JPanel());

    }


}
