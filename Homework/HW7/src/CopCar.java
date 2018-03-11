

import java.awt.Graphics; 
import java.util.Random;

public class CopCar extends Car 
{
	public static int xRatio;
	public static int yRatio;
	
	public CopCar()
	{
		super("CopCar", 5000, new Engine("V6", 30, 100), "cop-car.jpg");
		this.fillUp();
		Random rand = new Random();
		xRatio = 0;

		for (yRatio = 0; xRatio == 0 && yRatio == 0; yRatio = rand.nextInt(11) - 5)
			xRatio = rand.nextInt(11) - 5;
	}
	
	public void updateState(int width, int height)
	{
		this.drive(20, (double) xRatio, (double) yRatio);

		if (super.getX() > width || super.getX() < 0)
			xRatio = -(xRatio);
		else if (super.getY() > height || super.getY() < 0)
			yRatio = -(yRatio);
	}
	
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
}
