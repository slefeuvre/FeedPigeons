package fr.classes;

import java.util.ArrayList;

import fr.interfaces.IFood;
import fr.interfaces.IPigeonCoop;

public class PigeonCoop implements IPigeonCoop{

	
	private ArrayList<Pigeon> _listPigeons;
	
	
	public PigeonCoop() {
		this._listPigeons =  new ArrayList<Pigeon>();
		for(int i=0;i<5;i++)
		{
			Pigeon p = new Pigeon();
			p.start();
			this._listPigeons.add(p);
		}
		System.out.println("PigeonCoop: Constructeur end\n");
	}
	
	public ArrayList<Pigeon> getPigeons(){
		return _listPigeons;
	}
	
	public void notify_pigeons_food(IFood f) {
		for(int i = 0; i < _listPigeons.size(); i++) {
			_listPigeons.get(i).set_target(f);
			_listPigeons.get(i).setToExecute("move");
		}
	}
	
	@Override
	public void notify_pigeons_human() {
		for(int i = 0; i < _listPigeons.size(); i++) {
			_listPigeons.get(i).setToExecute("random");
		}
	}
	
	@Override
	public void notify_pigeons_move() {
		for(int i = 0; i < _listPigeons.size(); i++) {
			_listPigeons.get(i).setToExecute("move");
		}
	}
}
