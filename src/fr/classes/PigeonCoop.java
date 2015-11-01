package fr.classes;

import java.util.ArrayList;
import java.util.List;

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
}
