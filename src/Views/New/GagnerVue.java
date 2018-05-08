package Views.New;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class GagnerVue extends JPanel {

    JTextPane texte;
    public GagnerVue(){
        texte=new JTextPane();
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attribs,true);
        StyleConstants.setFontSize(attribs,40);
        texte.setParagraphAttributes(attribs, true);

        texte.setText("BRAVO !!! Vous avez Gagné ");

        add(texte);
        add(new JPanel());
    }
}
