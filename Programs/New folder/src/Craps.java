import java.security.SecureRandom;

public class Craps 
{
	private int sumOfDice = 0;
	//private int point = 0;
	private enum Status {WON, LOST, CONTINUE};
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVIN = 11;
	private static final int BOX_CARS = 12;
	
	public static int rollDice()
	{
		int die1 = 1 + randomNumbers.nextInt(6);
		int die2 = 1 + randomNumbers.nextInt(6);
		
		int sum = die1 + die2;
		System.out.printf("The player rolled %d + %d = %d/n", sum);

		return sum;
	}
	
	public static void main(String[] args)
	{
		// roll dice once
		int sum = rollDice();
		int point = 0;
		Status gameStatus;
		
		switch(sum)
		{
		case SEVEN:
		case YO_LEVIN:
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES:
		case TREY:
		case BOX_CARS:
			gameStatus = Status.LOST;
			break;
		default:
			gameStatus = Status.CONTINUE;
			point = sum;
			System.out.printf("Point is %d%n", point);
			break;
		}
		
		// check whether the player wins
		// if not WIN then check the player loses
		while(gameStatus == Status.CONTINUE)
		{
			sum = rollDice();
			if (sum == point)
				gameStatus = Status.WON;
			else if (sum == SEVEN)
				gameStatus = Status.LOST;
		}
		
		if (gameStatus == Status.WON)
			System.out.print("YOU WON!");
		else
			System.out.print("YOU LOST!");
	}
}
