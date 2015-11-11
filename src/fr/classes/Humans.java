package fr.classes;

import java.util.ArrayList;

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
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			spawnHuman();
		}
	}
	
	public void spawnHuman() {
		Human h = new Human(_ipc);
		h.start();
		_listHumans.add(h);
	}
}
