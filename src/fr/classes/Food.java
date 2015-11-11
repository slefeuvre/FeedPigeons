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
	
	public void set_etat(boolean b){
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

	public Boolean getEtat() {
		return _etat;
	}


	@Override
	public synchronized void eat() {
		_eaten = true;
	}


	@Override
	public Boolean getEaten() {
		return _eaten;
	}


	@Override
	public String getPosition() {
		return "none";
	}
}
