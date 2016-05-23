package Control;

import javax.swing.*;
import View.*;
import Model.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.EventListener;
public class ControlGroup {

    private final Model model;

    public Grille getGrille() {
        return grille;
    }

    private Grille grille;
    private ControlKey controlKey;
    private Control control;
    protected Timer timer;
    //public ControlMenu controlMenu;



    public ControlGroup(Model model, Control control) {

        this.model = model;
        this.control=control;
        controlKey = new ControlKey(model,this.control);
        //controlMenu=new ControlMenu();

        timer = new Timer(150, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(model.jouable()){
                    //model.startJeu();
                    //model.platSnake();
                    grille = new Grille(20,20);
                }else{
                    timer.stop();
                    Control.fin();
                }
            }
        });
        timer.start();
    }
    }
