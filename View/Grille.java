package View;

import Model.Model;
import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Grille extends JPanel{

    public Grille(int x, int y){

        JPanel display = new JPanel(new GridLayout(x,y));
        display.setPreferredSize(new Dimension(800,800));
        Case tab[][] = new Case[x][y];
        for (int i=0;i<x;i++){
            for (int j=0; j<y;j++){
                tab[i][j] = new Case();
                display.add(tab[i][j]);
            }
        }
        add(display);
    }
}
