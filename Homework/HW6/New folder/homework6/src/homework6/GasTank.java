package homework6;

public class GasTank
{	
		private int capacity;
		private double level;
		
		public GasTank(int mCapacity)
		{
			this.level = 0.0;
			if (mCapacity < 0)
				this.capacity = 0;
			else 
			{
				this.capacity = mCapacity;
			}
		}
		
		public int getCapacity()
		{
			return capacity;
		}
		
		public double getLevel()
		{
			return level;
		}
		
		public void setLevel(double levelIn)
		{
			if(levelIn < 0)
				this.level = 0;
			else if (levelIn > this.capacity)
				this.level = this.capacity;
			else
				this.level = levelIn;
		}		
}
