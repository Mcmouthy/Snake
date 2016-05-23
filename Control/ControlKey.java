package Control;

import Model.*;

import View.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControlKey implements KeyEventDispatcher {
    Model model;
    Control control;

    public ControlKey(Model model, Control control) {
        this.control = control;
        this.model = model;
        this.control.setControlKey(this);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {

        switch (keyEvent.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                model.change_direction_droite();
                System.out.println("A droite");
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                model.change_direction_gauche();
                System.out.println("A gauche");
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                model.change_direction_haut();
                System.out.println("En haut");
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.change_direction_bas();
                System.out.println("En bas");
                break;
        }

        return false;
    }
}
