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
	private IFood _toEat;
	
	public Pigeon() {
		Random r = new Random();
		int valeur = r.nextInt(800);
		int valeur2 = r.nextInt(500);
		Pos p = new Pos(valeur,valeur2);
		_toEat = null;
		_targetPos = null;
		_name = "pigeon";
		
		this.set_pos(p);
	}

	public void set_onmove(Boolean b) {
		this._onmove = b;
		System.out.println("set_onmove");
	}
	
	public void set_pos(Pos _pos) {
		this._actualPos = _pos;
	}

	public void set_target(IFood food) {
		_toEat = food;
		_targetPos = _toEat.getPos();
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
		if(_toEat.getEaten()){
			_toEat = null;
			_targetPos = null;
			_onmove = false;
		}
		else {
			if(_targetPos.getX()==_actualPos.getX() && _targetPos.getY()==_actualPos.getY())
			{
				System.out.println("Trying to eat");
				_toEat.eat();
			}
			else
			{
				//On change la position du pigeon
				// on vérifie sur l'axe x
				if(_actualPos.getX() != _targetPos.getX())
				{
					if(_actualPos.getX() < _targetPos.getX())
					{
						this._position="droite";
						this._actualPos.setX(_actualPos.getX()+1);
					}
					else
					{
						this._position="gauche";
						this._actualPos.setX(_actualPos.getX()-1);
					}
				}
				// on vérifie sur l'axe y
				if(_actualPos.getY() != _targetPos.getY())
				{
					if(_actualPos.getY() < _targetPos.getY())
					{
						this._actualPos.setY(_actualPos.getY()+1);
					}
					else
					{
						this._actualPos.setY(_actualPos.getY()-1);
					}
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
	
	@Override
	public String getClassName() {
		return this._name;
	}
	
	public Pos get_TPos() {
		return this._targetPos;
	}
	
	public Boolean get_onmove()
	{
		return this._onmove;
	}
	
	@Override
	public String getPosition()
	{
		return this._position;
	}
	
	public void set_position(String s)
	{
		this._position=s;
	}

	@Override
	public Boolean getEtat() {
		return true;
	}

	@Override
	public Boolean getEaten() {
		// TODO Auto-generated method stub
		return null;
	}
}
