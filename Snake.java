import javax.swing.JToolBar;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.ListIterator;


public class Snake extends JFrame implements KeyListener{
	protected FenetreGraphique dessin;

	public Snake() {
		super("Snake");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(this);
		dessin = new FenetreGraphique();

		JPanel cadre = new JPanel();
		cadre.setLayout(new BorderLayout());
		cadre.setPreferredSize(new Dimension(800, 600));
		cadre.add(dessin, BorderLayout.CENTER);
		setContentPane(cadre);
	}

	public void keyTyped(KeyEvent e) {}

	//si une touche est pressee
	//suivant le code on appelle la methode touche avec un parametre different
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			dessin.touche('q');
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			System.out.println("d");
			dessin.touche('d');
		}
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD4) {
			dessin.touche('4');
		}
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD6) {
			dessin.touche('6');
		}
		//si on presse sur escape, on quitte
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			dessin.touche('p');
		}
		//si on presse sur escape, on quitte
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent e) {
	}



	public static void main(String[] args) {
		Snake frame = new Snake();
		frame.pack();
		frame.setVisible(true);

	}
}






