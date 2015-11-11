package fr.classes;

import java.util.ArrayList;
import java.util.Random;

import fr.interfaces.IPigeonCoop;

public class Humans extends Thread{

	private ArrayList<Human> _listHumans;
	private IPigeonCoop _ipc;
	
	public Humans(IPigeonCoop ipc) {
		_listHumans = new ArrayList<Human>();
		_ipc = ipc;
		this.start();
	}
	
	public ArrayList<Human> getHumans() {
		return _listHumans;
	}
	
	@Override
	public void run() {
		while(true)
		{
			int valeur = 99;
			try {
				Thread.sleep(2000);
				Random r = new Random();
				valeur = r.nextInt(100);
				if(valeur < 20) {
					spawnHuman();
					if(!_listHumans.get(0).getEtat()) {
						_listHumans.remove(0);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void spawnHuman() {
		Human h = new Human(_ipc);
		h.start();
		_listHumans.add(h);
	}
}
