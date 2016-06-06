package View;

import Control.ControlSst;
import Model.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;

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

    public Fenetre(Model model){
        this.model= model;
        initAttributs();
        createJeu();
        pack();
        setTitle("Snake - appuyez sur entrée pour commencer");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700,700));
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void createJeu() {
        all = new JPanel();
        jeu = new Grille(model.taille_X,model.taille_Y,this,model);
        sst= new Sst(model);
        all.setBackground(Color.BLACK);
        all.add(jeu);
        all.add(sst);

        Option.add(reset);
        Option.add(score);
        menuBar.add(Option);

        setJMenuBar(menuBar);
        setContentPane(all);

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
        score.addActionListener(all);
    }

    public void setControlMenuReset(ActionListener all){
        reset.addActionListener(all);
    }

    public void setControlSst (KeyListener all) {
        addKeyListener(all);
    }

    public void afficheScore(){
        JOptionPane.showMessageDialog(this,model.getAffichagedesmeilleurs(),"Meilleurs Scores",JOptionPane.INFORMATION_MESSAGE);
    }

    public void refresh(){
        all.remove(jeu);
        all.remove(sst);
        jeu=new Grille(model.taille_X,model.taille_Y,this,model);
        sst=new Sst(model);
        all.add(jeu);
        all.add(sst);
        setContentPane(all);
    }
    public void recommencer(){
        all.remove(jeu);
        all.remove(sst);
        jeu=new Grille(model.taille_X,model.taille_Y,this,model);
        sst=new Sst(model);
        all.add(jeu);
        all.add(sst);
        playSound();
        setContentPane(all);
    }

    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/musicSnake.WAV").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(9999);

        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
