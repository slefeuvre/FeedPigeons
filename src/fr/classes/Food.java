package fr.classes;
import fr.interfaces.*;


public class Food implements IObjectsToDraw{
	
	private Pos _pos;
	private boolean _etat; 
	private String _name;

	public Food(Pos p, String name) {

		this._pos = p;
		this._etat=true;
		this._name=name;
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
	public String getName() {
		return this._name;
	}

	public Boolean getEtat() {
		return _etat;
	}
}
