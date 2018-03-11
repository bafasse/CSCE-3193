
import java.lang.Math;

public class Car 
{
	private String carDescription = "Sweet Ride";
	private int xCoordinate;
	private int yCoordinate;
	private GasTank gasTank;
	private Engine engine;
	private int capacity;
	private double totalMiles = 0.0;
	
	public Car(String mCarDescription, int mGasTank, Engine mEngine)
	{
		this.gasTank = new GasTank(mGasTank);
		int length = mCarDescription.length();
		
		if (length == 0)
			this.carDescription = "Generic Car";
		else
			this.carDescription = mCarDescription;
		
		if (mEngine == null)
			this.engine = new Engine ("", 0, 0);
		else 
			this.engine = mEngine;
		// ?????
		this.capacity = mGasTank;
	}
	
	public String getDescription()
	{
		return carDescription + " (" + engine.getDescription() + "), Fuel: " + gasTank.getLevel() + "/" + gasTank.getCapacity() + ", location: (" + getX() + ", " + getY() + ")"; 
		//return carDescription + " (Engine: " + engine.getEngineType() + " (MPG: " + engine.getMilesPerGallon() + ", Max Speed: " + engine.getSpeed() + ")), Fuel: " + gasTank.getLevel() + ", location: (" + getX() + ", " + getY() + ")";
	}
	
	public int getX()
	{
		return this.xCoordinate; // ???
	}
	
	public int getY()
	{
		return this.yCoordinate; // ???
	}
	
	public double getFuelLevel()
	{
		return gasTank.getLevel();
	}
	
	public int getMPG()
	{
		return engine.getMilesPerGallon(); // ???
	}
	
	public void fillUp()
	{
		gasTank.setLevel(gasTank.getCapacity());
	}
	
	public int getMaxSpeed()
	{
		return engine.getSpeed(); // ???
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		double totalDistance = this.engine.getMilesPerGallon() * this.capacity;
		totalMiles = totalMiles + distance;
		double ratio = totalMiles / totalDistance;
	    double newCapacity = ratio * this.capacity;
	    double fuelCapacity = this.capacity - newCapacity;
	    gasTank.setLevel(fuelCapacity);
		            
	       
	    if(getFuelLevel() > 0 && totalMiles < totalDistance)
	    {
	    	if((xRatio < 0 && yRatio < 0) || (xRatio < 0 && yRatio > 0))
            {
	    		double angle = Math.atan(yRatio/xRatio);
	    		
		        int xInverse = (int) (distance * (Math.cos(angle)));
		        int x = xInverse * -1;
		        
		        int yInverse = (int)  (distance * (Math.sin(angle)));
		        int y = yInverse * -1;
		        
		        this.xCoordinate = this.xCoordinate + x;
		        this.yCoordinate = this.yCoordinate + y;
		    }
		       
		    else
		    {
		        double angle = Math.atan(yRatio/xRatio);
		        
		        int x = (int)  (distance * (Math.cos(angle)));
		        int y = (int)  (distance * (Math.sin(angle)));
		        
		        this.xCoordinate = this.xCoordinate + x;
		        this.yCoordinate = this.yCoordinate + y;
		    }
	    	
	    	return distance;
		 }
		        
		 else
		 {
			 double newDistance = totalMiles - distance;
		     double emptyTank = totalDistance - newDistance;
		             
		     if(emptyTank < 0)
		    	 emptyTank = 0.0;
		             
		     System.out.printf("Ran out of gas after driving %.2f miles \n", emptyTank);
		             
		     if((xRatio < 0 && yRatio < 0) || (xRatio < 0 && yRatio > 0))
		     {
		        double angle = Math.atan(yRatio/xRatio);
		        
		        int xInverse = (int) (emptyTank * (Math.cos(angle)));
		        int x = xInverse * -1;
		        
		        int yInverse = (int)  (emptyTank * (Math.sin(angle)));
		        int y = yInverse * -1;
		        
		        this.xCoordinate = this.xCoordinate + x;
		        this.yCoordinate = this.yCoordinate + y;
		     }
		       
		     else
		     {
		        double angle = Math.atan(yRatio/xRatio);
		        
		        int x = (int)  (emptyTank * (Math.cos(angle)));
		        int y = (int)  (emptyTank * (Math.sin(angle)));
		        
		        this.xCoordinate = this.xCoordinate + x;
		        this.yCoordinate = this.yCoordinate + y;
		     }
		     
		     return emptyTank;
		 }
	}
}
