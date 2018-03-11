package hw2;

public class Engine 
{
	private String engineType = "V8";
	private int milesPerGallon = 0;
	private int speed = 0;
	
	public void engineConstructor(String mEngine, int mSpeed, int mMPG)
	{
		// unsure of what is equal to what
		this.engineType = mEngine;
		this.speed = mSpeed;
		this.milesPerGallon = mMPG;
		
		if(mEngine == "")
			mEngine = "Generic Engine";
		
		else if (mSpeed < 0)
			mSpeed = 0;
		
		else if (mMPG < 0)
			mMPG = 0;
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
	
}
