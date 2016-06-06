package View;


import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */

public class Case extends JPanel{
    Model model=new Model();
    
    public Case(final int x,final int y) {
        if (model.getGrille(x,y)==model.VIDE){
            setBackground(Color.BLACK);
        }else if (model.getGrille(x,y)==model.MUR){
            setBackground(Color.WHITE);
        }else if (model.getGrille(x,y)==model.SNACK){
            setBackground(Color.RED);
        }else if (model.getGrille(x,y)==model.TETE){
            setBackground(Color.BLUE);
        }else if (model.getGrille(x,y)==model.CORPS){
            setBackground(Color.GREEN);
        }else if (model.getGrille(x,y)==model.QUEUE){
            setBackground(Color.YELLOW);
        }
    }
}
