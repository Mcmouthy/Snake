import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;




class Serpent{


	private ArrayList<Point> listePoint;        //liste contenant les coordonnées des points
	//qui composent le serpent
	private static final int haut = 40;
	private static final int larg = 40;
	public int score;

	private int direction;
	private int tourne;

	public Serpent(){
		listePoint = new ArrayList<Point>();

		Random r = new Random();
		//on determine aleatoirement la position du serpent
		int x = Math.abs(r.nextInt() % larg);
		int y = Math.abs(r.nextInt() % haut);

		x=x*10;
		y=y*10;

		direction=3; //par défaut le serpent part à droite
		//0 = bas
		//1 = gauche
		//2 = haut
		//3 = droite

		//on construit le serpent par une liste chainee
		listePoint.add(new Point(x,y));
		listePoint.add(new Point(x + 10,y));
		listePoint.add(new Point(x + 20,y));
		listePoint.add(new Point(x + 30,y));
		listePoint.add(new Point(x + 40,y));
		listePoint.add(new Point(x + 50,y));

		score=0;

	};

	void tourne(int t) {
		tourne=t;
		if(tourne==1) {
			direction--;
			if (direction<0)
				direction=3;
		}
		if(tourne==2) {
			direction++;
			if(direction>3)
				direction=0;
		}
	}


	

	ArrayList<Point> getList() {return listePoint;}


	// gere le deplacement du serpent et les changements de direction
	public void avancerSerpent(){

//		System.out.println("début avance");
//		
//		for(Point p:listePoint){
//			System.out.println(p);
//		}
		Point tete1 = new Point(listePoint.get(0));

		
//		System.out.println("tete "+tete1);
//
//		System.out.println("direction "+direction);
		
		switch(direction) {
		case 0 :
			tete1.y = tete1.y + 10;
			break;
		case 1 :
			tete1.x = tete1.x - 10;
			break;
		case 2 :
			tete1.y = tete1.y - 10;
			break;
		case 3 :
			tete1.x = tete1.x + 10;
			break;
		}
//		System.out.println("tete "+tete1);
//		for(Point p:listePoint){
//			System.out.println(p);
//		}
//		System.out.println("azeazeaz");

		listePoint.add(0,new Point (tete1.x, tete1.y));

		listePoint.remove(listePoint.size()-1);
		
		
//		for(Point p:listePoint){
//			System.out.println(p);
//		}
//		System.out.println("fin avance");
		
	}


}
