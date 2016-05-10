package View;

import Model.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Fenetre extends JFrame {

    JMenuBar menuBar;
    JMenu Option;
    JMenuItem reset;
    JMenuItem score;
    Model model;

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
        JPanel all = new JPanel();
        Grille jeu = new Grille(model.taille_X,model.taille_Y);
        Sst sst = new Sst();
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
}
