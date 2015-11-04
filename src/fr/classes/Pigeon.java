package fr.classes;
import java.util.ArrayList;
import java.util.Random;

import fr.interfaces.*;

public class Pigeon extends Thread implements IObjectsToDraw{

	private Pos _actualPos;
	private Pos _targetPos;
	private String _name;
	private Boolean _onmove=false;
	private String _toExecute;
	private String _position="arret";
	
	public Pigeon() {
		Random r = new Random();
		int valeur = r.nextInt(800);
		int valeur2 = r.nextInt(500);
		Pos p = new Pos(valeur,valeur2);
		
		this.set_pos(p);
	}

	public void set_onmove(Boolean b) {
		this._onmove = b;
		System.out.println("set_onmove");
	}
	
	public void set_pos(Pos _pos) {
		this._actualPos = _pos;
	}

	public void set_Tpos(Pos _pos) {
		this._targetPos = _pos;
	}
	
	@Override
	public Pos getPos() {
		return _actualPos;
	}

	public String get_toExecute() {
		return _toExecute;
	}

	public void set_toExecute(String _toExecute) {
		this._toExecute = _toExecute;
	}

	public void move()
	{
		System.out.println("move");
		int px = this._actualPos.getX();
		int py = this._actualPos.getY();
		int x = this._targetPos.getX();
		int y = this._targetPos.getY();
		System.out.println("Position du pigeon :"+px+"  "+py);
		System.out.println("Position de target :"+x+"  "+y);
		if(px==x && py==y)
		{
			System.out.println("false");
			Window.stopPigeon();
			Window._fGenerator.removeFood();
		}
		else
		{
			//On change la position du pigeon
			// on vérifie sur l'axe x
			if(px != x)
			{
				if(px < x)
				{
					px++;
					this._position="droite";
					this._actualPos.setX(px);
				}
				else
				{
					px--;
					this._position="gauche";
					this._actualPos.setX(px);
				}
			}
			// on vérifie sur l'axe y
			if(py != y)
			{
				if(py<y)
				{
					py++;
					this._actualPos.setY(py);
				}
				else
				{
					py--;
					this._actualPos.setY(py);
				}
			}
		}
	}
	@Override
	public void run() {

		while(true)
		{
			if(this._onmove == true)
			{
				System.out.println(this._onmove);
				this.move();
			}
			else
			{
				
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
	
	public String get_Name() {
		return this._name;
	}
	
	public Pos get_TPos() {
		return this._targetPos;
	}
	
	public Boolean get_onmove()
	{
		return this._onmove;
	}
	
	public String get_position()
	{
		return this._position;
	}
	
	public void set_position(String s)
	{
		this._position=s;
	}
}
