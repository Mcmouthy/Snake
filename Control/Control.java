package Control;

import Model.Model;
import View.Fenetre;

import java.awt.event.*;
import javax.swing.*;

public class Control extends JFrame{
    private ControlGroup cg;
    public Control(){
        init();
        NouveauJeu();
        Model m = new Model();
        cg = new ControlGroup(m);
    }
    public void init() {
        Model m = new Model();
        Fenetre f = new Fenetre(m);
    }
    public void NouveauJeu() {

    }
    public static void fin() {
        System.out.println("C'est la fin");
    }

    public void setControlKey(KeyListener listener) {
        addKeyListener(listener);
    }

}