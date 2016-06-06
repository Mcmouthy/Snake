package View;

import javax.swing.*;
import java.awt.*;
import Model.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Sst extends JPanel {

    private JPanel Score, Time, Size;
    private JLabel textScore, textTime,textSize;
    public static JLabel printScore;
    public static JLabel printTime;
    public JLabel printSize;
    public Model model;



    public Sst(Model model){
        this.model=model;
        JPanel all = new JPanel(new GridLayout(3,1));
        all.setPreferredSize(new Dimension(200,200));

        Score = new JPanel(new GridLayout(2,1));
        Score.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Score.setBackground(Color.BLACK);

        Time = new JPanel(new GridLayout(2,1));
        Time.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Time.setBackground(Color.BLACK);

        Size = new JPanel(new GridLayout(2,1));
        Size.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Size.setBackground(Color.BLACK);

        textScore = new JLabel("Score");
        textScore.setHorizontalAlignment(SwingConstants.CENTER);
        textScore.setFont(new Font("ArcadeClassic",1,20));
        textScore.setForeground(Color.WHITE);

        textTime = new JLabel("Time");
        textTime.setHorizontalAlignment(SwingConstants.CENTER);
        textTime.setFont(new Font("ArcadeClassic",1,20));
        textTime.setForeground(Color.WHITE);

        textSize = new JLabel("Size");
        textSize.setHorizontalAlignment(SwingConstants.CENTER);
        textSize.setFont(new Font("ArcadeClassic",1,20));
        textSize.setForeground(Color.WHITE);

        printScore = new JLabel();
        printScore.setHorizontalAlignment(SwingConstants.CENTER);
        printScore.setFont(new Font("ArcadeClassic",1,20));
        printScore.setForeground(Color.WHITE);
        printScore.setText(""+model.getScore());

        printTime = new JLabel();
        printTime.setHorizontalAlignment(SwingConstants.CENTER);
        printTime.setFont(new Font("Arial",1,20));
        printTime.setForeground(Color.WHITE);
        printTime.setText("" + model.timeSST[2] + " : " + model.timeSST[1]);

        printSize = new JLabel();
        printSize.setHorizontalAlignment(SwingConstants.CENTER);
        printSize.setFont(new Font("ArcadeClassic",1,20));
        printSize.setForeground(Color.WHITE);
        printSize.setText(""+model.getSize());

        Score.add(textScore);
        Score.add(printScore);
        Time.add(textTime);
        Time.add(printTime);
        Size.add(textSize);
        Size.add(printSize);

        all.add(Score);
        all.add(Time);
        all.add(Size);
        add(all);
    }

}
