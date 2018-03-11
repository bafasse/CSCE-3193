import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


class Model
{
	private Car sprite;
	private Engine engine;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	int x = 0;

    Model() throws IOException 
	{
		sprite = new Car("cop-car.jpg", 10, engine);
		this.sprites.add(sprite);
		System.out.println(sprites.isEmpty()); // returns true if empty
		//CopCar cop = new CopCar();
		//this.sprites.add(cop);
    }

    public void update(Graphics g)
	{
		sprite.update(g);
    }
	
	public void addSprite(int x, int y)
	{
		Car newSprite = new Car("cop-car.jpg", x, engine);
		sprites.set(x, newSprite);
		sprites.set(y, newSprite);
		this.sprites.add(newSprite);
		System.out.println(sprites.isEmpty()); //return true if empty
	}
}
