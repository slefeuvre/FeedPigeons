package fr.classes;

import java.util.ArrayList;
import java.util.List;

import fr.interfaces.IFood;

public class PigeonCoop extends Element{

	
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
			_listPigeons.get(i).set_onmove(true);
		}
	}
}
