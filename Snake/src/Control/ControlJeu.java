package Control;
import View.*;

import javax.swing.*;

import static javax.swing.JFrame.*;

/**
 * Created by mdemesy on 24/05/16.
 */
public class ControlJeu extends JFrame {
    private boolean gamelaunched=false;
    public void islaunched() { if (gamelaunched == false ) {
        setTitle("Snake");
        gamelaunched = true;
    }

    }

    }

