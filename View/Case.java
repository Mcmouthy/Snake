package View;


import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */

public class Case extends JPanel{

    public Case(final int x,final int y) {
        if (x==0 || x==39 || y==0 || y==39){
            setBackground(Color.WHITE);
        }else{
            setBackground(Color.BLACK);
        }
    }
}
