package Control;
import Model.*;

/**
 * Created by mdemesy on 23/05/16.
 */
public class ControlMenu {
    private Model model;
    public void getScores() {model.lireScores();}
    public void setScores() {model.ecrireScores();}
}
