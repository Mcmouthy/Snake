package Control;

import Model.Model;
import View.Fenetre;
import View.Sst;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by platylux on 03/06/16.
 */

public class ControlSst implements KeyListener
{
    Fenetre fenetre;
    Model model;

    public ControlSst(Fenetre fenetre, Model model)
    {
        this.fenetre = fenetre;
        this.model = model;
        fenetre.setControlSst(this);

    }


    @Override
    public void keyTyped(KeyEvent keyEvent)
    {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (model.getEnJeu()==false) {
                    model.setEnJeu();
                    fenetre.setTitle("Sneaky Snake");
                }
                testKey();
                break;

            case KeyEvent.VK_SPACE:
                if (model.getEnJeu()==true){
                    if (model.getPause()==false){
                        model.setPause();
                        stopTime();
                        fenetre.affichePause();
                    }else{
                        model.setPause();
                        startTime();
                    }
                }
                break;
        }

        }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {}

    private void testKey() {
        if (model.getEnJeu()==true) {
            if (model.getPause()==false){
               startTime();
            }
        }
    }

    private void startTime() {
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

    private void stopTime() {
        model.timerSST.cancel();
        model.timerSST.purge();
    }
}