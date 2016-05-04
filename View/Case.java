package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by rydkey on 03/05/16.
 */

public class Case extends JPanel{

    public Case() {
        setBackground(Color.BLACK);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {}

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                setBackground(Color.BLACK);
            }
        });

    }
}
