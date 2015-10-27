package fr.interfaces;
import fr.classes.DrawState;
import fr.classes.Pos;

public interface IElements {
	
	public DrawState getDrawState();
	
	public void addFood(Pos p);
}
