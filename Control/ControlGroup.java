package Control;

import View.*;
import Model.*;

public class ControlGroup {

    public ControlGroup(Model Model){
        Fenetre fenetre= new Fenetre(Model);
        ControlKey controlKey = new ControlKey(fenetre, Model);
        fenetre.setVisible(true);
    }
}

