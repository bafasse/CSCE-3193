//package homework6;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{
	private Sprite sprite;
	private Engine engine;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	int z = 0;

    Model() throws IOException 
	{
		sprite = new CopCar();
		this.sprites.add(sprite);
		System.out.println(sprites.isEmpty()); // returns true if empty
    }

    public void update(Graphics g)
	{
    	Iterator<Sprite> iterator = this.sprites.iterator();

		while (iterator.hasNext()) {
			Sprite temp = (Sprite) iterator.next();
			temp.update(g);
		}
    }
	
	public void addSprite(int x, int y)
	{
		Sprite car;
		
		if (this.z == 0)
			car = new RobberCar();
		else 
			car = new CopCar();
		
		this.z = (this.z + 1) % 2;
		((Sprite) car).setX(x);
		((Sprite) car).setY(y);
		this.sprites.add(car);
		
//		Sprite newSprite = new Car("cop-car.jpg", x, engine, "red-car.jpg");
//		sprites.set(x, newSprite);
//		sprites.set(y, newSprite);
//		this.sprites.add(newSprite);
		
	}
	
	public void fillUp() 
	{
		Iterator<Sprite> x = this.sprites.iterator();

		while (x.hasNext()) 
		{
			Sprite sprite = (Sprite) x.next();
			((Car) sprite).fillUp();
		}
	}
}
