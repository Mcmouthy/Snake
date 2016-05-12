package Control;
import Model.*;
import View.*;
import java.util.*;


/**
 * Created by Michael on 12/05/2016.
 */
public class Control {
    long t1,t2;
    public Control(){
        init();
        NouveauJeu();
    }
    public void init() {
        Model m = new Model();
        Fenetre f = new Fenetre(m);
    }
    public void NouveauJeu() {
        t1 = java.lang.System.currentTimeMillis();
        chrono c;
        c = new chrono();
    }
}
