package Model;

import java.io.*;
import java.util.*;

/**
 * Created by PC-Dylan on 03/05/2016.
 */
public class Model {

    public static final int VIDE=0;
    public static final int MUR=1;
    public static final int SNACK=2;
    public static final int TETE=3;
    public static final int CORPS=4;
    public static final int QUEUE=5;

    public static int taille_X;
    public static int taille_Y;

    private static int position_X; // position des differents objets en X
    private static int position_Y; // position des differents objets en Y

    private static int[][] grille;
    private static int score; // score du joueur actuel
    private static int size; // taille actuelle du serpent
    private static int vitesse; // vitesse de deplacementdu serpent en nombre de case du tableau
    private static boolean pause; //booleen qui dit si la partie est en cours ou non

    private static float temps; // temps de la partie en cours
    private static Random random;
    private static boolean record; // booleen qui indique si un record a ete battu
    public static String[] tabScore;//tableau contenant des strings ayant pour valeur les scores
    private static String nom; // nom du joueur actuel
    private int[][] tabDir;
    private List<int[]> serpent;
    private List<int[]> pos_Snack;
    public Timer timerSST;
    public Timer timerJEU;
    public int[] timeSST;
    public int[] timeJEU;
    private boolean enJeu;
    private String affichagedesmeilleurs;

    public Model(){ // constructeur qui initialise  tous les parametres a zero.
        position_X=0;
        position_Y=0;
        taille_X=40;
        taille_Y=40;
        score=0;
        size=0;
        vitesse=100;
        temps=0f;
        record=false;
        pause =false;
        tabScore= new String[10];
        tabDir=new int[1][2];
        nom="";
        serpent= new ArrayList<>();
        pos_Snack= new ArrayList<>();
        timerSST=new Timer();
        timerJEU=new Timer();
        timeSST=new int[3];
        timeJEU=new int[3];
        enJeu=false;
        affichagedesmeilleurs="";
        random = new Random();
        grille=new int[taille_X][taille_Y];
        initGrille();
        initTimers();
        initScore();
        initAffichagemeilleures();

    }

    /*------------------les setters----------------------*/

    public void setPosition_X(){
        position_X=random.nextInt((taille_X-2))+1;
    }

    public void setPosition_Y(){
        position_Y=random.nextInt((taille_Y-2))+1;
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

    public void setPause(){pause = !pause;}

    public void setEnJeu() {
       enJeu= !enJeu;
    }

    public void setGrille(int i,int j,int nbre){grille[i][j]=nbre;}


    /*------------------les getters----------------------*/

    public int getPosition_X(){
        return this.position_X;
    }

    public int getPosition_Y(){
        return this.position_Y;
    }

    public int getScore(){
        return this.score;
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

    public boolean getPause(){
        return pause;
    }

    public boolean getEnJeu() {
        return enJeu;
    }

    public List<int[]> getSerpent() {
        return serpent;
    }

    public static int[][] getCoordGrille() {
        return grille;
    }

    public String getAffichagedesmeilleurs(){return affichagedesmeilleurs;}

    public int getGrille(int i, int j){ return grille[i][j];}

    /*-----------------les calculs----------------------*/

    public void change_direction(int x, int y){
        tabDir[0][0]=x;
        tabDir[0][1]=y;
    }

    /*-------------------------------------------------------------*/
    /*--------------------gestion des scores-----------------------*/
     public void initScore(){ // methode qui initialise les valeurs des scores dans tabScore
         try {
             BufferedReader record=new BufferedReader(new FileReader(new File("src/Record")));
             String[] strtab=new String[10];
             String buf;
             for (int i=0;i<10;i++){
                 buf=record.readLine();
                 if (buf!=null) {
                     tabScore[i]=buf;
                 }

             }
         } catch (FileNotFoundException e1) {
             e1.printStackTrace();
         } catch (IOException e1) {
             e1.printStackTrace();
         }
     }

    public boolean verifMeilleurScore(){ // methode qui verifie si il y a un score a changer
        String[] strtab= new String[10];
        try {
            BufferedReader record = new BufferedReader(new FileReader(new File("src/Record")));
            String buf;
            for (int i = 0; i < 10; i++) {
                buf = record.readLine();
                if (buf != null) {
                    strtab[i] = buf.split(" ")[1];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i<10;i++){
            if (score>Float.parseFloat(strtab[i])) {
                record = true;
            }
        }
        return record;
    }

    public void actualiseMeilleurScore(){ //methode qui actualise le score dans le fichier Record
        String[] strtab= new String[10];
        String[] strnom= new String[10];
        if(pause ==false) {
            try {
                BufferedReader record = new BufferedReader(new FileReader(new File("src/Record")));
                String buf;
                for (int i = 0; i < 10; i++) {
                    buf = record.readLine();
                    if (buf != null) {
                        strnom[i]= buf.split(" ")[0];
                        strtab[i] = buf.split(" ")[1];
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int index=0;
            for (int i=0;i<strtab.length;i++){
                if (score>Float.parseFloat(strtab[i])) index=i;
            }

            for ( int k=index;k<strtab.length;k++){
                strnom[k+1]=strnom[k];
                strtab[k+1]=strtab[k];
            }
            strnom[index]=nom;
            strtab[index]=score+"";

            try {
                BufferedWriter rec= new BufferedWriter(new FileWriter(new File("src/Record")));
                for (int i=0; i<10;i++){
                    rec.write(strnom[i]+" "+strtab[i]);
                    rec.newLine();
                }
                rec.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToSerpent(int x, int y){
        serpent.add(new int[]{x,y});
    }

    public void addToPosSnack(int x,int y) {
        pos_Snack.add(new int[]{x,y});
    }

    public void mouvementSerpent(int x,int y){
        for (int i=serpent.size()-1; i>0;i--){
            serpent.set(i,serpent.get(i-1));
        }
        serpent.set(0,new int[]{x,y});
    }

    /*-------------------------------------------------------------*/
    /*------------------------ Lancer jeux ------------------------*/

    public void gameStart(){
        setPosition_X();
        setPosition_Y();
    }

    /**/
    public void initGrille() {
        for (int i=0;i<taille_X;i++){
            for (int j=0;j<taille_Y;j++){
                if (i==0 || i==taille_X-1 || j==0 || j==taille_Y-1){
                    grille[i][j]=MUR;
                }else {
                    grille[i][j]=VIDE;
                }
            }
        }
        placeSnack();
        placeTete(17,19);
        placeCorps(18,19);
        placeCorps(19,19);
        placeCorps(20,19);
        placeQueue(21,19);
    }

    public void initTimers() {
        for(int i=0;i<3;i++){
            timeJEU[0]=0;
            timeJEU[1]=0;
            timeJEU[2]=0;
            timeSST[0]=0;
            timeSST[1]=0;
            timeSST[2]=0;
        }
    }

    public void initAffichagemeilleures(){
        for (int i=0;i<tabScore.length;i++){
            affichagedesmeilleurs+=(i+1)+"-"+tabScore[i]+"\n";
        }
    }

    public void placeSnack(){
        setPosition_X();
        setPosition_Y();
        addToPosSnack(position_X,position_Y);
        setGrille(position_X,position_Y,SNACK);
    }

    public void placeTete(int x, int y){
        grille[x][y]=TETE;
        addToSerpent(x,y);
    }

    public void placeCorps(int x, int y){
        grille[x][y]=CORPS;
        addToSerpent(x,y);
    }

    public void placeQueue(int x, int y) {
        grille[x][y]=QUEUE;
        addToSerpent(x,y);
    }


}