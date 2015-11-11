package fr.classes;

import java.util.ArrayList;

import fr.interfaces.IElements;

public class Element implements IElements{
	
	private FoodGenerator _foodG;
	private Humans _humans;
	private PigeonCoop _pigeonCoop;
	
	public Element() {
		_foodG = new FoodGenerator();
		_humans = new Humans();
		_pigeonCoop = new PigeonCoop();
	}
	
	@Override
	public DrawState getDrawState() {
		DrawState ds = new DrawState();
		ArrayList<Food> listFood;
		ArrayList<Human> listHumans;
		ArrayList<Pigeon> listPigeons;
		
		listFood = _foodG.getFood();
		listHumans = _humans.getHumans();
		listPigeons = _pigeonCoop.getPigeons();
		
		for(int i = 0; i < listFood.size(); i++) {
			ds.addElement(listFood.get(i));
		}
		for(int i = 0; i < listHumans.size(); i++) {
			ds.addElement(listHumans.get(i));
		}
		for(int i = 0; i < listPigeons.size(); i++) {
			ds.addElement(listPigeons.get(i));
		}
		
		return ds;
	}
	@Override
	public void addFood(Pos p) {
		Food f = _foodG.addFood(p);
		_pigeonCoop.notify_pigeons_food(f);
	}
	

}
