package Model;

import View.Grille;
import View.Sst;

import java.util.Random;

/**
 * Created by PC-Dylan on 03/05/2016.
 */
public class Model {

    // rajouter une enumeration pour les etats des cases du tableau
    public static enum Case{VIDE,MUR,SNACKS,TETE,CORPS}
    public Grille jeu;
    public Sst sst;

    public static int taille_X;
    public static int taille_Y;
    public boolean gamelaunched=false;

    private static int position_X; // position des differents objets en X
    private static int position_Y; // position des differents objets en Y

    private static int score; // score du joueur actuel
    private static int size; // taille actuelle du serpent
    private static int vitesse; // vitesse de deplacementdu serpent en nombre de case du tableau
    private static boolean pause;// booléen qui definit si la pause est en cours ou non
    private static boolean enJeu;

    private static float temps; // temps de la partie en cours
    private static Random randomx,randomy;

    public Model(){ // constructeur qui initialise  tous les parametres a zero.
        position_X=0;
        position_Y=0;
        taille_X=40;
        taille_Y=40;
        score=0;
        size=0;
        vitesse=100;
        pause=false;
        temps=0f;
    }

    /*------------------les setters----------------------*/

    public void setPosition_X(){
        position_X=randomx.nextInt((taille_X-1)+1);
    }

    public void setPosition_Y(){
        position_Y=randomy.nextInt((taille_Y-1)+1);
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
    public void setJouable(boolean jeu){
        enJeu=jeu;
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

    public boolean getEnJeu(){
        return enJeu;
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
        int index_snacks_X= random.nextInt((taille_X-1)+1);
        int index_snackq_Y= random.nextInt((taille_Y-1)+1);
        if (grille[index_snacks_X][index_snackq_Y]!=Case.MUR){
            grille[index_snacks_X][index_snackq_Y]=Case.SNACKS;
        }else{
            genereSnacks(grille);
        }
    }

    /*------------------------ Lancer jeux ------------------------*/

    public void gameStart(){
        setJouable(true);
        randomx = new Random();
        randomy = new Random();
        setPosition_X();
        setPosition_Y();
    }
}