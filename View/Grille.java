package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Grille extends JPanel{

    public Grille(){

        JPanel display = new JPanel(new GridLayout(60,60));
        display.setMinimumSize(new Dimension(800,800));
        Case tab[][] = new Case[60][60];
        for (int i=0;i<60;i++){
            for (int j=0; j<60;j++){
                tab[i][j] = new Case();
                display.add(tab[i][j]);
            }
        }
        add(display);
    }
}
