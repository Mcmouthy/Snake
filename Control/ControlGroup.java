package Control;

import View.*;
import Model.*;

public class ControlGroup {

    public ControlGroup(Model Model){
        Fenetre fenetre= new Fenetre(Model);
        ControlKey controlKey = new ControlKey(fenetre, Model);
        ControlMenuScore controlMenuScore = new ControlMenuScore(fenetre, Model);
        ControlMenuReset controlMenuReset = new ControlMenuReset(fenetre, Model);
        fenetre.setVisible(true);
    }
}

