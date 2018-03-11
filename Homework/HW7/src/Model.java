//package homework6;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


class Model
{
	//private Sprite sprite;
	private Engine engine;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	int z = 0;
	private int captured = 0;

    Model() throws IOException 
	{
		//sprite = new CopCar();
    	Bank bank= new Bank();
		this.sprites.add(bank);
		//System.out.println(sprites.isEmpty()); // returns true if empty
    }

    public void update(Graphics g)
	{
    	Iterator<Sprite> iterator = this.sprites.iterator();

		while (iterator.hasNext()) {
			Sprite temp = (Sprite) iterator.next();
			temp.updateImage(g);
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
		
		if(this.z == 1)
		{
			car.setX(300);
			car.setY(300);
		}
		this.sprites.add(car);

	}
	
	public void updateScene(int width, int height)
	{
//		for(Sprite spr: sprites)
//			spr.updateState(height,  width);
		
		Iterator<Sprite> iterator = sprites.iterator();
		while(iterator.hasNext())
    	{
    		Sprite sprite = (Sprite) iterator.next();
    		
    		if(sprite instanceof RobberCar)
    		{
    			if(((RobberCar) sprite).escape)
    			{
    				System.out.println("I am Free!!");
    				iterator.remove();
    			}
    		}
    	}

    	for (Sprite sprite: sprites)
    	{
    		sprite.updateState(width,height);
    	}
    	for (int x = 0; x < sprites.size(); x++)
    	{
    		if (sprites.get(x)  instanceof CopCar)
    		{	
    			for (int y = 0; y < sprites.size(); y++)
    			{
    				if (sprites.get(y) instanceof RobberCar)
    				{
    					if (sprites.get(y).overlaps(sprites.get(x)))
    					{
    						((RobberCar)sprites.get(y)).captured();

    					}
    				}
    			}
    		}
    	}
    }
}

