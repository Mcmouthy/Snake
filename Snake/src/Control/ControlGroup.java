package Control;

import View.*;
import Model.*;

public class ControlGroup {

    public ControlGroup(Model model){
        Fenetre fenetre= new Fenetre(model);
        ControlKey controlKey = new ControlKey(fenetre, model);
        ControlMenuScore controlMenuScore = new ControlMenuScore(fenetre, model);
        ControlMenuReset controlMenuReset = new ControlMenuReset(fenetre, model);
        ControlSst controlSst = new ControlSst(fenetre, model);
        fenetre.setVisible(true);
    }
}

