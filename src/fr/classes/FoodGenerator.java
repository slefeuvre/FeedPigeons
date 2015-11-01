package fr.classes;

import java.util.ArrayList;
import java.util.List;

public class FoodGenerator {
	
	private ArrayList<Food> _listFood;
	
	public FoodGenerator() {
		
		this._listFood =  new ArrayList<Food>();
		System.out.println("FoodGenerator : Constructeur end\n");
	}
	

	public void addFood(Pos p) {
		// TODO Auto-generated method stub
		if(this._listFood.size()>4)
		{
			this._listFood.remove(0);
		}

		for(int i=0;i<this._listFood.size();i++)
		{
			this._listFood.get(i).set_etat(false);
		}
		this._listFood.add(new Food(p,"food"));
	}
	
	public ArrayList<Food> getFood(){
		return _listFood;
		
	}

	public void removeFood() {
		for(int i=0;i<this._listFood.size();i++)
		{
			if(this._listFood.get(i).getEtat()==true)
			{
				this._listFood.remove(i);
			}
		}
	}
	
}
