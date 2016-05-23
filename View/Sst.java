package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Sst extends JPanel {

    private JPanel Score, Time, Size;
    private JLabel textScore, textTime,textSize;
    private JLabel printScore, printTime,printSize;


    public Sst(){
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

        printScore = new JLabel("0");
        printScore.setHorizontalAlignment(SwingConstants.CENTER);
        printScore.setFont(new Font("ArcadeClassic",1,20));
        printScore.setForeground(Color.WHITE);

        printTime = new JLabel("0.00");
        printTime.setHorizontalAlignment(SwingConstants.CENTER);
        printTime.setFont(new Font("ArcadeClassic",1,20));
        printTime.setForeground(Color.WHITE);

        printSize = new JLabel("0");
        printSize.setHorizontalAlignment(SwingConstants.CENTER);
        printSize.setFont(new Font("ArcadeClassic",1,20));
        printSize.setForeground(Color.WHITE);

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

    public void setPrintScore(String TextScore){
        printScore.setText(TextScore);
    }
}
