package fr.classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1069262196257160478L;
	private BufferedImage imagefood,imagefood2,imagePigeon1,imageHuman;
	private Image imagePigeonDroite,imagePigeonGauche;
	
	public Panel() {
		URL resource = getClass().getResource("/images/food.png");
		URL resource2 = getClass().getResource("/images/food2.jpg");
		URL resource3 = getClass().getResource("/images/pigeon3.gif");
		URL resource4 = getClass().getResource("/images/pigeon4.gif");
		URL resource5 = getClass().getResource("/images/pigeon.png");
		URL resource6 = getClass().getResource("/images/human.png");
		imagePigeonDroite = new ImageIcon(resource3).getImage();
		imagePigeonGauche = new ImageIcon(resource4).getImage();

        try {
            imagefood = ImageIO.read(resource);
            imagefood2 = ImageIO.read(resource2);
            imagePigeon1 = ImageIO.read(resource5);
            imageHuman = ImageIO.read(resource6);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void paintComponent(Graphics g) {	
		//dans cette m�thode on r�cup�re tous ce qu'il y a a afficher

		super.paintComponent(g);
		for(int i = 0; i < Window._d.getSize(); i++) {
			if(Window._d.getAtPos(i).getClassName() == "food") {
				if(!Window._d.getAtPos(i).getEaten()) {
					if(Window._d.getAtPos(i).getEtat()) {
						g.drawImage(imagefood,Window._d.getAtPos(i).getPos().getX(), Window._d.getAtPos(i).getPos().getY(), 40, 40, this);
					}
					else
					{
						g.drawImage(imagefood2,Window._d.getAtPos(i).getPos().getX(), Window._d.getAtPos(i).getPos().getY(), 40, 40, this);
					}
				}
			}
			else if(Window._d.getAtPos(i).getClassName() == "pigeon"){
				if(Window._d.getAtPos(i).getToExecute().equals("arret"))
				{
					g.drawImage(imagePigeon1,Window._d.getAtPos(i).getPos().getX(), Window._d.getAtPos(i).getPos().getY(), 30, 30, this);
				}
				else
				{
					if(Window._d.getAtPos(i).getPosition().equals("droite"))
					{
						g.drawImage(imagePigeonDroite,Window._d.getAtPos(i).getPos().getX(), Window._d.getAtPos(i).getPos().getY(), 40, 40, this);
					}
					else
					{
						g.drawImage(imagePigeonGauche,Window._d.getAtPos(i).getPos().getX(), Window._d.getAtPos(i).getPos().getY(), 40, 40, this);
					}
				}
			}
			else if(Window._d.getAtPos(i).getClassName() == "human") {
				if(Window._d.getAtPos(i).getEtat()){
					g.drawImage(imageHuman, Window._d.getAtPos(i).getPos().getX(), Window._d.getAtPos(i).getPos().getY(), 60, 60, this);
				}
			}
		}
	}
}
