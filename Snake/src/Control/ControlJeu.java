package Control;

import Model.*;

import View.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


public class ControlJeu implements KeyListener {
    Fenetre fenetre;
    Model model;

    public ControlJeu(Fenetre fenetre, Model model ) {
        this.fenetre = fenetre;
        this.model = model;
        fenetre.setControlJeu(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                model.change_direction(0,1);
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                model.change_direction(0,-1);
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                model.change_direction(-1,0);

                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.change_direction(1,0);
                break;

            case KeyEvent.VK_ENTER:
                if (model.getEnJeu()==false) {
                    fenetre.setTitle("Sneaky Snake");
                    fenetre.playSound();
                    model.setEnJeu();
                    testKeyJeu();
                    testKeySst();
                    }
                    break;


            case KeyEvent.VK_SPACE:
                if (model.getEnJeu()==true){
                    if (model.getPause()==false){
                        model.setPause();
                        fenetre.affichePause();
                        fenetre.clip.stop();
                        stopTimeSst();
                        stopTimeJeu();
                    }else{
                        model.setPause();
//                        long clipTime;
//                        fenetre.clip.setMicrosecondPosition(clipTime);
                        fenetre.clip.start();
                        startTimeJeu();
                        startTimeSst();
                    }

                }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

//    Control de SST

    private void testKeySst() {
        if (model.getEnJeu()==true) {
            if (model.getPause()==false){
                startTimeSst();
            }
        }
    }

    private void startTimeSst() {
        model.timerSST= new Timer();
        model.timerSST.schedule(new TimerTask() {
            @Override
            public void run() {
                model.timeSST[0]++;
                Sst.printScore.setText(""+model.getScore());
                if (model.timeSST[0] == 1000) {
                    model.timeSST[0] = 0;
                    model.timeSST[1]++;
                }
                if (model.timeSST[1] == 60) {
                    model.timeSST[1] = 0;
                    model.timeSST[2]++;
                }

                Sst.printTime.setText("" + model.timeSST[2] + " : " + model.timeSST[1]);/* rafraichir le label */
            }
        },0,1);
    }

    private void stopTimeSst() {
        model.timerSST.cancel();
        model.timerSST.purge();
    }


//    Controle du jeu


    private void testKeyJeu() {
        if (model.getEnJeu()==true) {
            model.timerJEU.schedule(new TimerTask() {
                @Override
                public void run() {
                    model.mouvementSerpent();
                    fenetre.refresh();
                }
            },0,100);
        }
    }

    private void startTimeJeu() {
    }

    private void stopTimeJeu() {
        model.timerJEU.cancel();
        model.timerJEU.purge();
    }
}