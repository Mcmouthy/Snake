package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rydkey on 03/05/16.
 */
public class Sst extends JPanel {

    public Sst(){
        JPanel all = new JPanel(new GridLayout(3,1));
        all.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JPanel Score = new JPanel();
        Score.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Score.setBackground(Color.BLACK);

        JPanel Time = new JPanel();
        Time.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Time.setBackground(Color.BLACK);

        JPanel Size = new JPanel();
        Size.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Size.setBackground(Color.BLACK);

        JLabel textScore = new JLabel("Score");
        textScore.setFont(new Font("ArcadeClassic",1,20));
        textScore.setForeground(Color.WHITE);

        JLabel textTime = new JLabel("Time");
        textTime.setFont(new Font("ArcadeClassic",1,20));
        textTime.setForeground(Color.WHITE);

        JLabel textSize = new JLabel("Size");
        textSize.setFont(new Font("ArcadeClassic",1,20));
        textSize.setForeground(Color.WHITE);

        Score.add(textScore);
        Time.add(textTime);
        Size.add(textSize);

        all.add(Score);
        all.add(Time);
        all.add(Size);
        add(all);
    }
}
