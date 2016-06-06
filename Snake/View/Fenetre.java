package View;

import Model.Model;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by rydkey on 03/05/16.
 */
public class Fenetre extends JFrame {

    public JMenuBar menuBar;
    public JMenu Option;
    public JMenuItem reset;
    public JMenuItem score;
    public Model model;
    public JPanel all;
    public Grille jeu;
    public Sst sst;
    public JPanel display;
    public Clip clip;

    public Fenetre(Model model) {
        this.model = model;
        initAttributs();
        createJeu();
        pack();
        setTitle("Snake - appuyez sur entrée pour commencer");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 700));
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void createJeu() {
        all = new JPanel();
        jeu = new Grille(model.taille_X, model.taille_Y, this, model);
        sst = new Sst(model);
        all.setBackground(Color.BLACK);
        all.add(jeu);
        all.add(sst);

        Option.add(reset);
        Option.add(score);
        menuBar.add(Option);

        setJMenuBar(menuBar);
        setContentPane(all);
    }

    public void setTitle(){
        setTitle("Sneaky Snake");
    }

    public void setTitleEntre(){
        setTitle("Sneaky Snake - Appuyez sur entré pour commencer");
    }

    public void setTitleSpace(){
        setTitle("Sneaky Snake - Appuyez sur espace pour reprendre");
    }

    public void initAttributs() {
        menuBar = new JMenuBar();
        Option = new JMenu("Options");
        reset = new JMenuItem("Reset Game");
        score = new JMenuItem("Score");
    }

    public void setControlJeu(KeyListener all) {
        addKeyListener(all);
    }

    public void setControlMenuScore(ActionListener all) {
        score.addActionListener(all);
    }

    public void setControlMenuReset(ActionListener all) {
        reset.addActionListener(all);
    }

    public void afficheScore() {
        JOptionPane.showMessageDialog(this, model.getAffichagedesmeilleurs(), "Meilleurs Scores", JOptionPane.INFORMATION_MESSAGE);
    }

    public void affichePause() {
        JOptionPane.showMessageDialog(this, "Appuyez sur espace pour reprendre", "Pause", JOptionPane.WARNING_MESSAGE);
    }

    public void refresh() {
        all.remove(jeu);
        all.remove(sst);
        jeu=new Grille(model.taille_X,model.taille_Y,this,model);
        sst=new Sst(model);
        all.add(jeu);
        all.add(sst);
        setContentPane(all);
    }

    public void recommencer() {
        model.initTimers();
        model.initSerpent();
        all.remove(jeu);
        all.remove(sst);
        jeu = new Grille(model.taille_X, model.taille_Y, this, model);
        sst = new Sst(model);
        all.add(jeu);
        all.add(sst);
        setTitleSpace();
        setContentPane(all);
    }

    public void playSound() {
        try {
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src/musicSnake.WAV"));
                DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(inputStream);

            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            clip.start();

        } catch (Exception e) {
        }
    }
}
