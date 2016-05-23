package Control;

import Model.Model;
import View.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rydkey on 23/05/16.
 */
public class ControlMenuReset implements ActionListener {
    Fenetre fenetre;
    Model model;

    public ControlMenuReset(Fenetre fenetre, Model model ){
        this.fenetre=fenetre;
        this.model=model;
        fenetre.setControlMenuReset(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
