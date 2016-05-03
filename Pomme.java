import java.awt.Point;
import java.util.Random;


class Pomme{
	public Point p;
	private static final int haut = 60;
	private static final int larg = 80;
	//private boolean cree;
	public Pomme(){


		//cree = false;
		//while(cree == false){ // on determine aleatoirement la position de la pomme
		Random r = new Random(); // on verifie qu'elle ne soit pas sur un serpent
		int x = Math.abs(r.nextInt() % larg);
		int y = Math.abs(r.nextInt() % haut);
		int i;
		int j=2;
		x=x*10;
		y=y*10;

		for(i=0; i<1000000; i++){
			j=j+2;
		}
		
		p = new Point(x,y);


	}

}
