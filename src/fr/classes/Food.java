package fr.classes;
import fr.interfaces.*;


public class Food extends Thread implements IObjectsToDraw{
	
	private Pos _pos;

	public void set_pos(Pos _pos) {
		this._pos = _pos;
	}

	@Override
	public Pos getPos() {
		// TODO Auto-generated method stub
		return _pos;
	}

}
