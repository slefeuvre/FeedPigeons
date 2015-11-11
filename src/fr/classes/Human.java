package fr.classes;
import fr.interfaces.*;

public class Human extends Thread implements IObjectsToDraw{
	
	private Pos _pos;
	private String _name;

	public void set_pos(Pos _pos) {
		this._pos = _pos;
	}

	@Override
	public Pos getPos() {
		// TODO Auto-generated method stub
		return _pos;
	}
	
	@Override
	public String getClassName() {
		return _name;
	}

	@Override
	public Boolean getEtat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
