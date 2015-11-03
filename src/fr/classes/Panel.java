package fr.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private BufferedImage imagefood,imagefood2,imagePigeon1;
	private Image imagePigeonDroite,imagePigeonGauche;
	
	public Panel() {
		URL resource = getClass().getResource("/images/food.jpg");
		URL resource2 = getClass().getResource("/images/food2.jpg");
		URL resource3 = getClass().getResource("/images/pigeon3.gif");
		URL resource4 = getClass().getResource("/images/pigeon4.gif");
		URL resource5 = getClass().getResource("/images/pigeon.png");
		imagePigeonDroite = new ImageIcon(resource3).getImage();
		imagePigeonGauche = new ImageIcon(resource4).getImage();

			
        try {
            imagefood = ImageIO.read(resource);
            imagefood2 = ImageIO.read(resource2);
            imagePigeon1 = ImageIO.read(resource5);

        } catch (IOException e) {
            e.printStackTrace();
        }
        

		
	}
	
	public void paintComponent(Graphics g) {	
		//dans cette méthode on récupère tous ce qu'il y a a afficher

		super.paintComponent(g);
		if(Window._init)
		{
			ArrayList<Food> f = Window._fGenerator.getFood();
			ArrayList<Pigeon> p = Window._pCoop.getPigeons();
			
			for(int i=0; i<f.size();i++)
			{
				if(f.get(i).getEtat()) {
					g.drawImage(imagefood,f.get(i).getPos().getX(), f.get(i).getPos().getY(), 40, 40, this);
				}
				else
				{
					g.drawImage(imagefood2,f.get(i).getPos().getX(), f.get(i).getPos().getY(), 40, 40, this);
				}
			}
			
			for(int i=0; i<p.size();i++)
			{
				if(p.get(i).get_position().equals("arret"))
				{
					g.drawImage(imagePigeon1,p.get(i).getPos().getX(), p.get(i).getPos().getY(), 30, 30, this);
				}
				else
				{
					if(p.get(i).get_position().equals("droite"))
					{
						g.drawImage(imagePigeonDroite,p.get(i).getPos().getX(), p.get(i).getPos().getY(), 40, 40, this);
					}
					else
					{
						g.drawImage(imagePigeonGauche,p.get(i).getPos().getX(), p.get(i).getPos().getY(), 40, 40, this);
					}
				}
				
					
					//g.drawImage(mt,p.get(i).getPos().getX(), p.get(i).getPos().getY(), 40, 40, this);
					//g.drawImage(image, 0, 0, 300, 300, this);
					
			}
			
			
			
		}
		
	}
	
}
