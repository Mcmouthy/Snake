
package Control;

import View.*;
import Model.*;

public class ControlGroup {

    public ControlGroup(Model model){
        Fenetre fenetre= new Fenetre(model);
        ControlJeu controlJeu = new ControlJeu(fenetre, model);
        ControlMenuScore controlMenuScore = new ControlMenuScore(fenetre, model);
        ControlMenuReset controlMenuReset = new ControlMenuReset(fenetre, model);
        fenetre.setVisible(true);
    }
}