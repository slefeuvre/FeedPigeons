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
	
	static int x=0;
	//static mouseListener _mListener = new mouseListener();
	
	public Window(){
		this.setVisible(true);
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(_panel);
	//	this.addMouseListener(this._mListener);
		this.addMouseListener(this);
		
		
	    _d=new DrawState();
	    this._fGenerator = new FoodGenerator();
	    
	    Trame();	
	}
	

	public static void Trame() {
		while(true){
			try {
				Thread.sleep(10);
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Position de x: "+e.getX()+" "+MouseInfo.getPointerInfo().getLocation());
		MouseInfo.getPointerInfo().getLocation();
		System.out.println("Position de Y: "+e.getY());
		this.addFood(new Pos(e.getX(),e.getY()));
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
