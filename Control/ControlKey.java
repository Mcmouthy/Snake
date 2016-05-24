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
    Grille grille;
    boolean enJeu;

    public ControlKey(Fenetre fenetre, Model model ) {
        this.fenetre = fenetre;
        this.model = model;
        fenetre.setControlKey(this);
    }
    public void initgame() {
        fenetre.setTitle("Snake");
        model.gamelaunched = true;
        grille = new Grille(40, 40, fenetre, model); }


    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                model.change_direction_droite();
                testKey();
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                model.change_direction_gauche();
                testKey();
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                model.change_direction_haut();
                testKey();
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.change_direction_bas();
                testKey();
                break;

            case KeyEvent.VK_ESCAPE:
                model.setPause();
                testKey();
                break;

            case KeyEvent.VK_SPACE:
                if(model.gamelaunched==false) { initgame(); }
                testKey();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    private void testKey() {
        enJeu=model.getEnJeu();
        if (enJeu==false){
            model.gameStart();
        }else{

        }
    }
}
