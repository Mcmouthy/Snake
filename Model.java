import java.util.Random;

/**
 * Created by PC-Dylan on 03/05/2016.
 */
public class Model {

    // rajouter une enumeration pour les etats des cases du tableau
    public static enum Case{VIDE,MUR,SNACKS,TETE,CORPS}

    static int taille_X;
    static int taille_Y;

    private static int position_X; // position des differents objets en X
    private static int position_Y; // position des differents objets en Y

    private static Case[][] grille;
    private static int score; // score du joueur actuel
    private static int size; // taille actuelle du serpent
    private static int vitesse; // vitesse de deplacementdu serpent en nombre de case du tableau
    private static boolean pause;// booléen qui definit si la pause est en cours ou non

    private static float temps; // temps de la partie en cours

    public Model(){ // constructeur qui initialise  tous les parametres a zero.
        position_X=0;
        position_Y=0;

        taille_X=40;
        taille_Y=40;
        grille=new Case[taille_X][taille_Y];

        score=0;
        size=0;
        vitesse=100;
        pause=false;
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

    public void setPause(){
        if (pause==false){
            pause=true;
        }else if (pause==true){
            pause=false;
        }
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

    public void genereMur(Case[][] grille){
        for (int i=0;i<taille_Y;i++) {
            grille[0][i] = Case.MUR;
            grille[taille_X - 1][i] = Case.MUR;
        }
        for (int i=0;i<taille_X;i++){
            grille[i][0]=Case.MUR;
            grille[i][taille_Y-1]=Case.MUR;
        }
    }

    public void genereSnacks(Case[][] grille){
        Random random=new Random();
        int index_snacks_X= random.nextInt(taille_X);
        int index_snackq_Y= random.nextInt(taille_Y);
        if (grille[index_snacks_X][index_snackq_Y]!=Case.MUR){
            grille[index_snacks_X][index_snackq_Y]=Case.SNACKS;
        }else{
            genereSnacks(grille);
        }
    }
























}
