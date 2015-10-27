package fr.classes;
import fr.interfaces.*;

public class Pigeon extends Thread implements IObjectsToDraw{

	private Pos _pos;

	private String _toExecute;

	public void set_pos(Pos _pos) {
		this._pos = _pos;
	}

	
	@Override
	public Pos getPos() {
		// TODO Auto-generated method stub
		return _pos;
	}

	public String get_toExecute() {
		return _toExecute;
	}

	public void set_toExecute(String _toExecute) {
		this._toExecute = _toExecute;
	}
	
	
}
