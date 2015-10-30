package fr.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private Image image;
	private BufferedImage imagefood,imagefood2;
	
	public Panel() {
		URL resource = getClass().getResource("/images/food.jpg");
		URL resource2 = getClass().getResource("/images/food2.jpg");
        try {
            imagefood = ImageIO.read(resource);
            imagefood2 = ImageIO.read(resource2);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void paintComponent(Graphics g) {	
		//dans cette méthode on récupère tous ce qu'il y a a afficher

		super.paintComponent(g);
		image = new ImageIcon("/images/food.jpg").getImage();
		ArrayList<Food> f = Window._fGenerator.getFood();
		
		for(int i=0; i<f.size();i++)
		{
			if(f.get(i).getEtat()) {
				g.drawImage(imagefood,f.get(i).getPos().getX()-10, f.get(i).getPos().getY()-30, 40, 40, this);
			}
			else
			{
				g.drawImage(imagefood2,f.get(i).getPos().getX()-10, f.get(i).getPos().getY()-30, 40, 40, this);
			}
		}
	}
	
}
