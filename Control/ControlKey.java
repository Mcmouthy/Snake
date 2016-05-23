package Control;

import Model.*;

import View.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControlKey implements KeyListener {
    Fenetre fenetre;
    Model model;

    public ControlKey(Fenetre fenetre, Model model ) {
        this.fenetre = fenetre;
        this.model = model;
        fenetre.setControlKey(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                model.change_direction_droite();
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                model.change_direction_gauche();
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                model.change_direction_haut();
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.change_direction_bas();
                break;

            case KeyEvent.VK_ESCAPE:
                model.setPause();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
