package Control;

import Model.Model;
import View.Fenetre;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control extends JFrame{
    private ControlGroup cg;
    KeyboardFocusManager manager;
    public Control(){
        init();
        NouveauJeu();
        Model m = new Model();
        cg = new ControlGroup(m,this);
    }
    public void init() {
        Model m = new Model();
        Fenetre f = new Fenetre(m);
         manager=KeyboardFocusManager.getCurrentKeyboardFocusManager();
    }
    public void NouveauJeu() {

    }
    public static void fin() {
        System.out.println("C'est la fin");
    }

    public void setControlKey(ControlKey listener) {
        manager.addKeyEventDispatcher(listener);
    }

}