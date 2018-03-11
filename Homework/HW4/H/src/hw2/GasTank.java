package hw2;

public class GasTank
{	
		private int capacity = 0;
		private double level = 0.0;
		
		public void gasTankConstructor(int temp)
		{
			temp = capacity;
			
			if(temp < 0)
				temp = 0;
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
			this.level = levelIn;
		}		
}
