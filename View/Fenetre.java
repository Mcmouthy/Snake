package View;

import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by rydkey on 03/05/16.
 */
public class Fenetre extends JFrame {

    JMenuBar menuBar;
    JMenu Option;
    JMenuItem reset;
    JMenuItem score;
    Model model;
    JPanel all;
    Grille jeu;
    Sst sst;
    Serpent snake;
    JPanel display;

    public Fenetre(Model model){
        this.model= model;
        initAttributs();
        createJeu();
        pack();
        setTitle("Snake");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void createJeu() {
        all = new JPanel();
        jeu = new Grille(model.taille_X,model.taille_Y,this,model);
        sst= new Sst();
        snake= new Serpent();
        all.setBackground(Color.BLACK);
        all.add(jeu);
        all.add(sst);

        Option.add(reset);
        Option.add(score);
        menuBar.add(Option);

        setJMenuBar(menuBar);
        setContentPane(all);
        setMinimumSize(new Dimension(800,800));
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void initAttributs(){
        menuBar= new JMenuBar();
        Option = new JMenu("Options");
        reset = new JMenuItem("Reset Game");
        score = new JMenuItem("Score");
    }

    public void setControlKey(KeyListener all) {
        addKeyListener(all);
    }

    public void setControlMenuScore(ActionListener all){
        Option.addActionListener(all);
    }

    public void setControlMenuReset(ActionListener all){
        reset.addActionListener(all);
    }
}
