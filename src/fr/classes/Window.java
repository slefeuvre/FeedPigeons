package fr.classes;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.interfaces.IElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Window extends JFrame implements MouseListener , IElements{
	
	private DrawState _d;
	
	static  FoodGenerator _fGenerator;	
	static PigeonCoop _pCoop;
	static Panel _panel = new Panel();
	static Boolean _init=false;	
	static int x=0;
	
	public Window(){
		this.setVisible(true);
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(_panel);
		this.addMouseListener(this);
		
	    _d=new DrawState();
	    this._fGenerator = new FoodGenerator();
	    this._pCoop = new PigeonCoop();
	    
	    Trame();	
	}
	

	public static void Trame() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_panel.repaint();
		}
	}
	
	public void addFood(Pos p){
		
		this._fGenerator.addFood(p);
		System.out.println("Food add");
		ArrayList<Pigeon> f = Window._pCoop.getPigeons();
		for(int i=0; i<f.size();i++)
		{
			f.get(i).set_Tpos(p);
			f.get(i).set_onmove(true);
			System.out.println(f.get(i).get_TPos().getX()+" "+f.get(i).get_TPos().getY());
			System.out.println(f.get(i).get_onmove());
		}
		Window._panel.repaint();
	}
	
	public static void stopPigeon() {
		ArrayList<Pigeon> f = Window._pCoop.getPigeons();
		for(int i=0; i<f.size();i++)
		{
			f.get(i).set_position("arret");
			f.get(i).set_onmove(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(!this._init)
		{
			this.addFood(new Pos(e.getX()-10,e.getY()-30));
			this._init=true;
		}
		else
		{
			this.addFood(new Pos(e.getX()-10,e.getY()-30));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DrawState getDrawState() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
