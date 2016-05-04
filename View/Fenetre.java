package View;

import Model.Model;
import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Fenetre extends JFrame {

    public Fenetre(Model model){

        JMenuBar menuBar= new JMenuBar();
        JMenu Option = new JMenu("Options");
        JMenuItem reset = new JMenuItem("Reset Game");
        JMenuItem score = new JMenuItem("Score");
        Option.add(reset);
        Option.add(score);
        menuBar.add(Option);

        JPanel all = new JPanel();

        Grille jeu = new Grille(Model.x,Model.y);

        Sst sst = new Sst();

        all.setBackground(Color.BLACK);
        all.add(jeu);
        all.add(sst);

        setJMenuBar(menuBar);
        setContentPane(all);
        setVisible(true);
        setMinimumSize(new Dimension(800,800));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }
}
