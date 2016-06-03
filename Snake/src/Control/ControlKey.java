package Control;

import Model.*;

import View.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControlKey implements KeyListener {
    Fenetre fenetre;
    Model model;
    Grille grille;

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
                model.change_direction(1,0);
                testKey();
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                model.change_direction(-1,0);
                testKey();
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                model.change_direction(0,1);
                testKey();
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.change_direction(0,-1);
                testKey();
                break;

            case KeyEvent.VK_SPACE:
                model.setEnJeu();
                testKey();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    private void testKey() {
        if (model.getEnJeu()==true) {
            if (model.getPause()==false){

            }else{

            }
        }else{

        }
    }
}
