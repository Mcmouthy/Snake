/**
 * Created by Michael on 12/05/2016.
 */
import Control.*;
import Model.*;
public class Game {
    public static void main (String[] args){

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Model model = new Model();
                ControlGroup control = new ControlGroup(model);
            }
        });
    }
}
