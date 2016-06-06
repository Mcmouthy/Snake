package Control;

import Model.*;

import View.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


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
                model.change_direction(1,0);
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                model.change_direction(-1,0);
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                model.change_direction(0,1);
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.change_direction(0,-1);
                break;

            case KeyEvent.VK_ENTER:
                break;

            case KeyEvent.VK_SPACE:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
    
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/musicSnake.WAV").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(9999);
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    private void testKey() {
        if (model.getEnJeu()==true) {
            model.timerSST.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (model.getPause()==true){
                        model.timerSST.cancel();
                        model.timerSST.purge();
                    }
                    if (model.getEnJeu()==false){
                        model.timerSST.cancel();
                        model.timerSST.purge();
                        model.initTimers();
                    }
                }
            },0,1);
        }
    }
}
