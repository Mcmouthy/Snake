/**
 * Created by PC-Dylan on 03/05/2016.
 */
public class Model {

    final int taille_X = 1000;
    final int taille_Y= 1000;

    private int position_X; // position des differents objets en X
    private int position_Y; // position des differents objets en Y

    private int score; // score du joueur actuel
    private int size; // taille actuelle du serpent
    private int vitesse; // vitesse de deplacementdu serpent en nombre de case du tableau

    private float temps; // temps de la partie en cours

    public Model(){ // constructeur qui initialise  tous les parametres a zero.
        position_X=0;
        position_Y=0;

        score=0;
        size=0;
        vitesse=100;
        temps=0f;
    }

    /*------------------les setters----------------------*/

    public void setPosition_X(int x){
        if (x>=0)this.position_X=x;
    }

    public void setPosition_Y(int y){
        if (y>=0) this.position_Y=y;
    }

    public void setScore(int score){
        if (score>=0) this.score=score;
    }

    public void setSize(int size){
        if (size>=0) this.size=size;
    }

    public void setVitesse(int vitesse){
        if (vitesse>=100) this.vitesse=vitesse;
    }

    public void setTemps(float tps){
        if (tps>=0) this.temps=tps;
    }

    /*------------------les getters----------------------*/

    public int getPosition_X(){
        return this.position_X;
    }

    public int getPosition_Y(){
        return this.position_Y;
    }

    public String getScore(){
        return String.valueOf(this.score);
    }

    public int getSize(){
        return this.size;
    }

    public int getVitesse(){
        return this.vitesse;
    }

    public float getTemps(){
        return this.temps;
    }

    /*-----------------les calculs----------------------*/

    public void change_direction_gauche(){
        position_X=position_X-vitesse;
    }

    public void change_direction_droite(){
        position_X=position_X+vitesse;
    }

    public void change_direction_haut(){
        position_Y=position_Y+vitesse;
    }

    public void change_direction_bas(){
        position_Y=position_Y-vitesse;
    }

























}
