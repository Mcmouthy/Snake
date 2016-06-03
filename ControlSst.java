package Control;

import Model.Model;
import View.Fenetre;
import View.Grille;
import View.Sst;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by platylux on 03/06/16.
 */

public class ControlSst implements KeyListener
{
    Fenetre fenetre;
    Model model;
    Grille grille;
    boolean enJeu;

    public ControlSst(Fenetre fenetre, Model model)
    {
        this.fenetre = fenetre;
        this.model = model;
        fenetre.setControlSst(this);

    }


    @Override
    public void keyTyped(KeyEvent keyEvent)
    {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        if (keyEvent.getKeyCode()==KeyEvent.VK_SPACE){
            model.setEnJeu();
            testKey();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {

    }

    private void testKey() {
        if (model.getEnJeu()==false) {
            model.setEnJeu();

            ActionListener timer_SST = new ActionListener() {
                public void actionPerformed(ActionEvent e1) {
                    model.timeSST[0]++;
                    if (model.timeSST[0] == 1000) {
                        model.timeSST[0] = 0;
                        model.timeSST[1]++;
                    }
                    if (model.timeSST[1] == 60) {
                        model.timeSST[1] = 0;
                        model.timeSST[2]++;
                    }
                    Sst.printTime.setText("" + model.timeSST[2] + ":" + model.timeSST[1] + ":" + model.timeSST[0]);/* rafraichir le label */
                }
            };
            model.timer
        }
    }
}
