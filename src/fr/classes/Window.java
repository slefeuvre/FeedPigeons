package fr.classes;
import javax.swing.JFrame;
import java.awt.event.*;


public class Window extends JFrame{
	private ThreadGroup threadGroupPigeons;
	
	public Window(){
		
		//
		threadGroupPigeons = new ThreadGroup("Pigeons");
		
		//ajout de thread dans le groupe
		Thread t1 = new Thread(threadGroupPigeons,new Pigeon(), "numero 1");
		Thread t2 = new Thread(threadGroupPigeons,new Pigeon(), "numero 2");
		
	
		
		JFrame f = new JFrame("ma fenetre");
		f.setSize(800,500);
		f.setTitle("Feed Pigeons");
		f.setVisible(true);
		
		/*WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};*/
		
	}
	
	
	
	
}
