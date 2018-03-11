
public class Car 
{
	private String carDescription = "Sweet Ride";
	private int xCoordinate;
	private int yCoordinate;
	private GasTank gasTank;
	private Engine engine;
	
	public Car(String mCarDescription, int mGasTank, Engine mEngine)
	{
		this.gasTank = new GasTank(mGasTank);
		int length = carDescription.length();
		
		if (length == 0)
			this.carDescription = "Generic Car";
		else
			this.carDescription = carDescription;
		
		if (this.engine == null)
			this.engine = new Engine ("", 0, 0);
		else 
			this.engine = engine;
		// ?????
	}
	
	public String getDescription()
	{
		return carDescription + "(" + engine.getDescription() + "), Fuel: " + gasTank.getLevel() + "/" + gasTank.getCapacity() + ", location: (" + getX() + ", " + getY() + ")"; 
		//return carDescription + " (Engine: " + engine.getEngineType() + " (MPG: " + engine.getMilesPerGallon() + ", Max Speed: " + engine.getSpeed() + ")), Fuel: " + gasTank.getLevel() + ", location: (" + getX() + ", " + getY() + ")";
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
		double direction = xRatio + yRatio;
		
		double milesTillEmpty = engine.getMilesPerGallon() * gasTank.getLevel();
		double destination = direction * distance;
		
		if (destination > milesTillEmpty)
			System.out.println("You have run out of gas after travelling " + milesTillEmpty);
		
		double fuel = destination / engine.getMilesPerGallon();
		double hyp = Math.sqrt((xRatio * xRatio) + (yRatio * yRatio));
		double temp = distance / hyp;
		double x1 = xCoordinate + (xRatio * temp);
		double y1 = yCoordinate + (yRatio * temp);
		
		gasTank.setLevel(fuel);
		return temp;
		
	}
}