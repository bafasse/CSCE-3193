package homework6;

import java.awt.Graphics; 
import java.util.Random;

public class CopCar extends Car 
{
	public static int xRatio;
	public static int yRatio;
	
	public CopCar()
	{
		super("CopCar", 30, new Engine("V6", 30, 100), "cop-car.jpg");
		Random rand = new Random();
		xRatio = 0;

		for (yRatio = 0; xRatio == 0 && yRatio == 0; yRatio = rand.nextInt(11) - 5)
			xRatio = rand.nextInt(11) - 5;
		
		this.fillUp();
	}
	
	public void update (Graphics g)
	{
		this.drive(20, (double) xRatio, (double) yRatio);
		super.update(g);
	}
}
