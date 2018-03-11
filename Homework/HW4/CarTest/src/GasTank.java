

public class GasTank
{	
		private int capacity;
		private double level;
		
		public GasTank(int mCapacity)
		{
			if (mCapacity >= 0)
				this.capacity = mCapacity;
			else 
			{
				this.capacity = 0;
				this.level = 0.0;
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
			else 
				this.level = this.capacity;
		}		
}
