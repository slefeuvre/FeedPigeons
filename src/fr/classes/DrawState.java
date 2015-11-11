package fr.classes;

import java.util.ArrayList;

import fr.interfaces.IObjectsToDraw;

public class DrawState {
	
	private ArrayList<IObjectsToDraw> _objects;

	public DrawState() {
		_objects = new ArrayList<IObjectsToDraw>();
	}
	
	public void addElement(IObjectsToDraw o) {
		_objects.add(o);
	}
	
	public IObjectsToDraw getAtPos(int x) {
		return _objects.get(x);
	}
	
	public int getSize() {
		return _objects.size();
	}
}
