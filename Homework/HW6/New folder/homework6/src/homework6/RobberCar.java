package homework6;

import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car 
{
	private int xRatio;
	private int yRatio;
	
	public RobberCar()
	{
		super("RobberCar", 20, new Engine("V8", 20, 200), "red-car.jpg");
		Random rand = new Random();
		this.xRatio = 0;
		
		for (this.yRatio = 0; this.xRatio == 0 && this.yRatio == 0; this.yRatio = rand.nextInt(11) - 5)
			this.xRatio = rand.nextInt(11) - 5;
		
		this.fillUp();
		
	}
	
	public void update(Graphics g)
	{
		this.drive(40, (double) this.xRatio, (double) this.yRatio);
		super.update(g);
	}
}
