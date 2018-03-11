package hw2;

public class Car 
{
	private String carDescription = "Sweet Ride";
	private int xCoordinate = 0;
	private int yCoordinate = 0;
	private gasTank;
	private engine;
	
	public void carConstructor(String mCarDescription, int mGasTank, int mEngine)
	{
		if (mCarDescription == "")
			mCarDescription = "Generic Car";
		// ?????
	}
	
	public String getDescription()
	{
		String name = carDescription + "Engine: " + engine + " MPG: " + getMPG() + "Max Speed: " + getMaxSpeed() + "Fuel: " + getFuelLevel() + "location: (" + getX() + ", " + getY() + ")";
		//return carDescription; // ???
	}
	
	public int getX()
	{
		return xCoordinate; // ???
	}
	
	public int getY()
	{
		return yCoordinate; // ???
	}
	
	public double getFuelLevel()
	{
		return gasTank;
	}
	
	public int getMPG()
	{
		return ((xCoordinate * xCoordinate) + (yCoordinate * yCoordinate)) / gasTank ; // ???
	}
	
	public void fillUp()
	{
		if (gasTank == 0) // ???
			gasTank += 26;
	}
	
	public int getMaxSpeed()
	{
		return engine; // ???
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		return xRatio; // ???
	}
}