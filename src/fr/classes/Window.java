package fr.classes;
import javax.swing.JFrame;
import fr.interfaces.IElements;
import java.awt.event.*;


public class Window extends JFrame implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5634244598882775716L;
	static DrawState _d;
	private Panel _panel = new Panel();
	static Boolean _init=false;	
	static int x=0;
	private IElements _ie;
	
	public Window(IElements ie){
		this.setVisible(true);
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(_panel);
		this.addMouseListener(this);
		
	    _d=new DrawState();
	    
	    _ie = ie;
	    
	    Trame();	
	}
	

	public void Trame() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_d = _ie.getDrawState();
			_panel.repaint();
		}
	}
	
	public void addFood(Pos p){
		_ie.addFood(p);
		System.out.println("Food add");
		_panel.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(!_init)
		{
			this.addFood(new Pos(e.getX()-10,e.getY()-30));
			_init=true;
		}
		else
		{
			this.addFood(new Pos(e.getX()-10,e.getY()-30));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
