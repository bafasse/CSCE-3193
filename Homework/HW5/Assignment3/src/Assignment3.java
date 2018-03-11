
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Assignment3 
{
	public static void main(String[]args)
	{	
		String description = JOptionPane.showInputDialog(null, "Type in description of you car: ");
		String gasTank = JOptionPane.showInputDialog(null, "Type in the size of the gas tank (in gallons): ");
		String engine = JOptionPane.showInputDialog(null, "Type in description of the engine: ");
		String mileage = JOptionPane.showInputDialog(null, "Type in the fuel mileage (in MPG): ");
		String speed = JOptionPane.showInputDialog(null, "Type in the maximum speed: ");
		
		int tempMileage = Integer.parseInt(mileage);
		int tempSpeed = Integer.parseInt(speed);
		int tempGasTank = Integer.parseInt(gasTank);
		
		while (tempGasTank <= 0)
			gasTank = JOptionPane.showInputDialog(null, "Type in the size of the gas tank (in gallons): ");
		while (tempSpeed <= 0)
			speed = JOptionPane.showInputDialog(null, "Type in the maximum speed: ");
		while(tempMileage <= 0)
			mileage = JOptionPane.showInputDialog(null, "Type in the fuel mileage (in MPG): ");
			
		
		Engine engine1 = new Engine(engine, tempSpeed, tempMileage); //Engine(String, int, int);
		
		System.out.println(tempSpeed);
		Car car1 = new Car(description, tempGasTank, engine1);
		JOptionPane.showMessageDialog(null, car1.getDescription());
		//JOptionPane.showMessageDialog(null, description + " (Engine: " + engine + " (MPG: " + mileage + ", Max Speed: " + speed + ")");
		car1.fillUp();
		
		String legs = JOptionPane.showInputDialog(null, "How many legs of the trip will there be: ");
		int tempLegs = Integer.parseInt(legs);
		
		int [] xLegs = new int [20000000];
		int [] yLegs = new int [20000000];
		for (int i = 0; i < tempLegs; ++i)
		{
			int distanceLegs = Integer.parseInt(JOptionPane.showInputDialog(null, "How long is this leg: "));
			double xRatio = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the X Ratio of this leg: "));
			double yRatio = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the Y Ratio of this leg: "));
			
			car1.drive(distanceLegs, xRatio, yRatio);
			xLegs[i] = car1.getX();
			yLegs[i] = car1.getY();
		}
		 for(int i = 0; i < 3; i++ )
		 {
			  System.out.printf("x[%d] = %d, y[%d] = %d,", i, xLegs[i], i, yLegs[i]);
		 }
			 //JOptionPane.showMessageDialog(null, "Distance: " + distance + ", X: " + x + ", Y: " + y);
		
		
		CarPanel panel = new CarPanel(xLegs, yLegs, tempLegs);
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(1920, 1080);
		application.setVisible(true);
	}
}
