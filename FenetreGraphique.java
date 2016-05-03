import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


class FenetreGraphique extends JPanel {


	public Serpent snake1;

	private boolean ret;

	public Point tete1;

	public Point queue;
	public Point pointcourant;

	public Pomme golden;

	public Pomme grany;

	boolean pause=true;

	private Timer timer;

	public FenetreGraphique(){
		setBackground(Color.white);

		timer=new Timer();

		snake1=new Serpent(); // on cree deux nouveaux serpents
		golden=new Pomme();

		grany=new Pomme();


		tete1=new Point();// deux points qui serviront à recuperer les 
		queue=new Point();// coordonnees de la tete et de la queue du serpent


	}

	public void touche(char t) {
		if(t=='q'){
			snake1.tourne(1);

		}
		if(t=='d'){
			snake1.tourne(2);

		}
		if(t=='4'){


		}
		if(t=='6'){

		}
		if(t=='p') {
			if(pause){
				pause=false;

				//démarrage de celui-ci
				timer.scheduleAtFixedRate(new TimerTask() {
					//cette méthode est appelée par le timer chaque fois que celui-ci se déclenche
					public void run(){
						//gereColision();
						snake1.avancerSerpent();

						//testPomme(snake1);


						repaint();  //on redessine
					}	

				},100,100);

				repaint();
			}
		}
	}


	//methode qui teste si le serpent a mangé une pomme
	public void testPomme(Serpent couleuvre){

		tete1 = couleuvre.getList().get(0);

		if(tete1.x == golden.p.x && tete1.y == golden.p.y){
			golden = new Pomme();
			queue = couleuvre.getList().get(couleuvre.getList().size());
			couleuvre.getList().add(new Point(queue.x, queue.y));
			couleuvre.score++;
		}

		if(tete1.x == grany.p.x && tete1.y == grany.p.y){
			grany = new Pomme();

			queue = couleuvre.getList().get(couleuvre.getList().size());
			couleuvre.getList().add(new Point(queue.x, queue.y));
			couleuvre.score++;
		}

	}




	// methode qui teste si les serpents n'ont rien heurté
	public void gereColision(){

		tete1 = snake1.getList().get(0);




		boolean first=true;
		System.out.println(tete1);
		for (Point p:snake1.getList() ) {
			System.out.println(p);
			if (first){
				first=false;
			}
			else {

				if(p.x == tete1.x && p.y == tete1.y){
					System.out.println("Le joueur 1 s'est mangé la queue... c'est bon ?");
					System.out.println("score joueur 1 : "+ snake1.score);
					
					System.exit(0);
				}  
			}
		}
	}

//cette méthode dit comment on redessine
//elle est appelée indirectement par un appel à repaint
//donc si on met repaint() dans le code, java appelle automatiquement
//paintComponent
public void paintComponent(Graphics g){
	super.paintComponent(g);
	if(pause == true){
		g.setColor(Color.red);
		g.setFont(new Font("Arial", 10, 30));
		g.drawString("Snake", 100 , 100);
		g.setFont(new Font("Arial", 0, 20));
		g.setColor(Color.blue);
		g.drawString("Touches du joueur 1 :", 75 , 200);
		g.drawString("Touches du joueur 2 :", 475 , 200);

		g.setColor(Color.red);
		g.setFont(new Font("Arial", 0, 15));
		
		g.drawString("Q pour aller à gauche", 0, 325);
		g.drawString("D pour aller à droite", 210, 325);
		

		g.setColor(Color.green);
		
		g.drawString("4 pour aller à gauche", 400, 325);
		g.drawString("6 pour aller à droite", 610, 325);
		

		g.setColor(Color.blue);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Appuyer sur Espace pour démarrer", 225, 550);
		g.drawString("Appuyer sur Echap pour quitter", 225, 580);

	}else{

		//parcours de la liste avec un itérateur
		//tant que l'itérateur a une suivant (i.hasNext())
		//on dessine le premier serpent
		//tete1 = snake1.getList().get(1);
		//g.setColor(Color.red);
		//g.drawRect(tete1.x,tete1.y,10,10);
		for (Point p:snake1.getList() ) { 
			g.setColor(Color.red);
			g.fillRect(p.x,p.y,10,10);
		}
		
		//on dessine la pomme dans la fenetre
		g.setColor(Color.blue);
		g.fillOval(golden.p.x, golden.p.y,10,10);
		g.fillOval(grany.p.x, grany.p.y,10,10);
	}
}

}