
public class Engine 
{
	private String engineType;
	private int milesPerGallon;
	private int speed;
	
	public Engine(String mEngine, int mSpeed, int mMPG)
	{
		// unsure of what is equal to what
		this.engineType = mEngine;
		this.speed = mSpeed;
		this.milesPerGallon = mMPG;
		
		int length = engineType.length();
		
		if(length == 0)
			this.engineType = "Generic Engine";
		else
			this.engineType = mEngine;
		
		if (mSpeed < 0)
			this.speed = 0;
		else
			this.speed = mSpeed;
		
		if (mMPG < 0)
			this.milesPerGallon = 0;
		else
			this.milesPerGallon = mMPG;
	}
	
	public String getEngineType()
	{
		return engineType;
	}
	
	public int getMilesPerGallon()
	{
		return milesPerGallon;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public String getDescription()
	{
		return "Engine: " + getEngineType() + " (MPG: " + getMilesPerGallon() + ", Max Speed: " + getSpeed() + ")";
	}
}
