package fr.classes;
import fr.interfaces.*;


public class Food implements IObjectsToDraw, IFood{
	
	private Pos _pos;
	private boolean _etat; 
	private String _name;
	private Boolean _eaten;

	public Food(Pos p) {

		this._pos = p;
		this._etat=true;
		this._name="food";
		this._eaten = false;
	}

	
	public void set_pos(Pos _pos) {
		this._pos = _pos;
	}
	
	public synchronized void set_etat(boolean b){
		this._etat = b;
	}

	@Override
	public Pos getPos() {
		return _pos;
	}

	@Override
	public String getClassName() {
		return this._name;
	}

	public synchronized Boolean getEtat() {
		return _etat;
	}


	@Override
	public synchronized void eat() {
		System.out.println("Eating");
		_eaten = true;
	}


	@Override
	public synchronized Boolean getEaten() {
		return _eaten;
	}


	@Override
	public synchronized String getPosition() {
		return "none";
	}
}
