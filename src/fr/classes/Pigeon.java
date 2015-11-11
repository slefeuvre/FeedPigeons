package fr.classes;
import java.util.Random;

import fr.interfaces.*;

public class Pigeon extends Thread implements IObjectsToDraw{

	private Pos _actualPos;
	private Pos _targetPos;
	private String _name;
	private String _toExecute = "arret";
	private String _position="droite";
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
	
	public synchronized void set_pos(Pos _pos) {
		this._actualPos = _pos;
	}

	public synchronized void set_target(IFood food) {
		_toEat = food;
		_targetPos = _toEat.getPos();
	}
	
	@Override
	public synchronized Pos getPos() {
		return _actualPos;
	}

	public void move()
	{
		if(_toEat.getEaten()){
			_toEat = null;
			_targetPos = null;
			_toExecute = "arret";
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
				// on v�rifie sur l'axe x
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
				// on v�rifie sur l'axe y
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
	
	public void move_randomly() {
		Random r = new Random();
		int valeur = r.nextInt(8);
		
		switch(valeur){
			case 0:
				if(_actualPos.getX()+4 < 800) {
					_position = "droite";
					_actualPos.setX(_actualPos.getX()+4);
				}
				break;
			case 1:
				if(_actualPos.getX()+4 < 800 && _actualPos.getY()+4 < 500) {
					_position = "droite";
					_actualPos.setX(_actualPos.getX()+4);
					_actualPos.setY(_actualPos.getY()+4);
				}
				break;
			case 2:
				if(_actualPos.getY()+4 < 500) {
					_actualPos.setY(_actualPos.getY()+4);
				}
				break;
			case 3:
				if(_actualPos.getX()-4 > 0 && _actualPos.getY()+4 < 500) {
					_position = "gauche";
					_actualPos.setX(_actualPos.getX()-4);
					_actualPos.setY(_actualPos.getY()+4);
				}
				break;
			case 4:
				if(_actualPos.getX()-4 > 0) {
					_position = "gauche";
					_actualPos.setX(_actualPos.getX()-4);
				}
				break;
			case 5:
				if(_actualPos.getX()-4 > 0 && _actualPos.getY()-4 > 0) {
					_position = "gauche";
					_actualPos.setX(_actualPos.getX()-4);
					_actualPos.setY(_actualPos.getY()-4);
				}
				break;
			case 6:
				if(_actualPos.getY()-4 > 0) {
					_actualPos.setY(_actualPos.getY()-4);
				}
				break;
			case 7:
				if(_actualPos.getX()+4 < 800 && _actualPos.getY()-4 > 0) {
					_position = "droite";
					_actualPos.setX(_actualPos.getX()+4);
					_actualPos.setY(_actualPos.getY()-4);
				}
				break;
			default:
				System.out.println("NOT SUPPOSED TO HAPPEN AHDHGSGSDFHDFGHDFH");
		}
	}
	
	@Override
	public void run() {

		while(true)
		{
			if(this._toExecute.equals("move"))
			{
				this.move();
			}
			else if(this._toExecute.equals("random"))
			{
				this.move_randomly();
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
	
	@Override
	public String getPosition()
	{
		return this._position;
	}
	
	public synchronized void set_position(String s)
	{
		this._position=s;
	}
	
	public synchronized void setToExecute(String s) {
		this._toExecute = s;
	}
	
	public synchronized String getToExecute() {
		return this._toExecute;
	}

	@Override
	public synchronized Boolean getEtat() {
		return true;
	}

	@Override
	public synchronized Boolean getEaten() {
		// TODO Auto-generated method stub
		return null;
	}
}
