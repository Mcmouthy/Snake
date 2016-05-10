package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {}

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                if (x==0 || x==39 || y==0 || y==39){
                    setBackground(Color.WHITE);
                }else{
                    setBackground(Color.BLACK);
                }
            }
        });

    }
}
