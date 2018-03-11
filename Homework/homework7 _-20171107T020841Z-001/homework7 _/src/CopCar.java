import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car
{
	private static int xRatio;
	private static int yRatio;

	public CopCar ()
	{
		//30 to 5000
	    super ("RANDOM COP CAR ", 5000, new Engine("v12", 30, 100), "cop-car.jpg");
	    //fill up
	    super.fillUp();
	    
	    Random rand = new Random ();
	    xRatio = 0;
	    yRatio = 0;
	    
	    while ((xRatio == 0) && (yRatio == 0))
	    {
	   	xRatio = rand.nextInt(5+5) - 5;
	   	yRatio = rand.nextInt(5+5) - 5;
	   	
	    }
		fillUp();
	}
	
//	public void update (Graphics g)
//	{
//		drive(20, xRatio,yRatio);
//		super.update(g);
//	}
	
	public void updateState(int width, int height)
	{
		super.drive(20,xRatio ,yRatio);
		if ( super.getX() > width || super.getX() < 0)
		{
			xRatio = -(xRatio);
		}
		if (super.getY() > height || super.getY() < 0)
		{
			yRatio = -(yRatio);
		}
	}
	
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
	
	
	
}
