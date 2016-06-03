package Control;

import View.Fenetre;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rydkey on 23/05/16.
 */
public class ControlMenuScore implements ActionListener{
    Fenetre fenetre;
    Model model;

    public ControlMenuScore(Fenetre fenetre, Model model){
        this.fenetre=fenetre;
        this.model=model;
        fenetre.setControlMenuScore(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (fenetre.score.equals(actionEvent.getSource())){
            fenetre.afficheScore();
        }
    }

}
