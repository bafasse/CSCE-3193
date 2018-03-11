//package homework6;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class RobberCar extends Car 
{
	private int xRatio;
	private int yRatio;
	private int counter;
	private int temp = 0;
	private int captured = 0;
	private int escaped = 0;
	boolean capture;
	boolean escape;
	
	public RobberCar()
	{
		super("RobberCar", 5000, new Engine("V8", 20, 200), "red-car.jpg");
		this.fillUp();
		Random rand = new Random();
		this.xRatio = 0;
		
		for (this.yRatio = 0; this.xRatio == 0 && this.yRatio == 0; this.yRatio = rand.nextInt(11) - 5)
			this.xRatio = rand.nextInt(11) - 5;
	}
	
	public void updateState(int width, int height)
	{
		if(!capture)
		{
			this.drive(40, (double) this.xRatio, (double) this.yRatio);
			
			if (((super.getX() > width || super.getY() > height) || (super.getX() <= -1 || super.getY() <=-1)))
			{
				counter++;
				//System.out.println("Escaped");
			}
			//else System.out.println("Still there");
		}
	}
	
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
	
	public void captured()
	{
		if (escape == false)
		{
			isCaptured();
			capture = true;
			super.setImage("jail.jpg");
			final int x = super.getX();
			final int y = super.getY();
			super.setX(x);
			super.setY(y);
		}
	}
	
	public boolean isCaptured()
	{
		if (capture == false)
		{
			captured++;
			JOptionPane.showMessageDialog( null, "captured : " + captured );
			return true;	
		}
		else
			return false;
	}
	
	public boolean hasEscaped()
	{
		if (escape == true)
		{
			escaped++;
			JOptionPane.showMessageDialog ( null,"escaped : " + escaped );
			return true;
		}
		else
			return false;
	}

}
