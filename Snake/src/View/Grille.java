package View;

import javax.swing.*;
import java.awt.*;
import Model.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Grille extends JPanel{

    public Grille(int x, int y, Fenetre fenetre, Model model){
        fenetre.display = new JPanel(new GridLayout(x,y));
        fenetre.display.setPreferredSize(new Dimension(650,650));
        fenetre.display.setBorder(null);
        Case tab[][] = new Case[x][y];
        for (int i=0;i<x;i++){
            for (int j=0; j<y;j++){
                tab[i][j]= new Case(i,j);
                fenetre.display.add(tab[i][j]);
            }
        }

        add(fenetre.display);
    }
}
