package fr.classes;
import java.util.Random;

import fr.interfaces.*;

public class Human extends Thread implements IObjectsToDraw{
	
	private Pos _pos;
	private String _name;
	private Pos _start;
	private Pos _end;
	private IPigeonCoop _ipc;
	private Boolean _etat = true;
	
	public Human(IPigeonCoop ipc) {
		_name = "human";
		_ipc = ipc;
		Random r = new Random();
		int valeur = r.nextInt(4);
		int valeur2;
		
		do {
			valeur2 = r.nextInt(4);
		}while(valeur == valeur2);
		
		switch(valeur) {
			case 0: 
				_start = new Pos(400,0);
				break;
			case 1:
				_start = new Pos(800,250);
				break;
			case 2:
				_start = new Pos(400,500);
				break;
			case 3:
				_start = new Pos(0,250);
				break;
			default:
				System.out.println("SHOULDN'T HAPPEN CAARARARASTADGSAFSDFGSGSDF");
		}
		
		switch(valeur2) {
			case 0: 
				_end = new Pos(400,0);
				break;
			case 1:
				_end = new Pos(800,250);
				break;
			case 2:
				_end = new Pos(400,500);
				break;
			case 3:
				_end = new Pos(0,250);
				break;
			default:
				System.out.println("SHOULDN'T HAPPEN CAARARARASTADGSAFSDFGSGSDF");
		}
		_pos = _start;
		_ipc.notify_pigeons_human();
	}
	
	@Override
	public void run() {
		while(_etat) {
			if(_pos.getX() == _end.getX() && _pos.getY() == _end.getY()) {
				_ipc.notify_pigeons_move();
				_etat = false;
			}
			else {
				_ipc.notify_pigeons_human();
				if(_pos.getX() != _end.getX()){
					if(_pos.getX() < _end.getX()) {
						_pos.setX(_pos.getX()+5);
					}
					else{
						_pos.setX(_pos.getX()-5);
					}
				}
				if(_pos.getY() != _end.getY()) {
					if(_pos.getY() < _end.getY()) {
						_pos.setY(_pos.getY()+5);
					}
					else{
						_pos.setY(_pos.getY()-5);
					}
				}
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

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
		return _etat;
	}

	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getEaten() {
		// TODO Auto-generated method stub
		return null;
	}

}
