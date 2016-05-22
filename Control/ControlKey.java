package Control;

import Model.*;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControlKey implements ActionListener, KeyListener {
    Model model;
    Control control;

    public ControlKey(Model model) {
        this.model = model;
        this.control.setControlKey(this);
    }

    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Touche appuyée");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                model.change_direction_droite();
                System.out.println("Touche appuyée");
                //model.platSnake();
                break;
            case KeyEvent.VK_LEFT:
                model.change_direction_gauche();
                System.out.println("Touche appuyée");
                //model.platSnake();
                break;
            case KeyEvent.VK_UP:
                model.change_direction_haut();
                System.out.println("Touche appuyée");
                //model.platSnake();
                break;
            case KeyEvent.VK_DOWN:
                model.change_direction_bas();
                System.out.println("Touche appuyée");
                //model.platSnake();
                break;
        }


    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}
