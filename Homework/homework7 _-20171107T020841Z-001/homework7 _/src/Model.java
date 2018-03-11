import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model 
{
    //private Sprite sprite;
    int car;
    //CREATE AN ARRAY OF SPRITE
    private ArrayList<Sprite>  arraySprites;
    
    
    Model() throws IOException
    {	
    	arraySprites = new ArrayList<Sprite>();
		//sprite = new Sprite("red-car.jpg");
    	car = 1;
    	//CopCar initialCar = new CopCar();
    	
    	Bank bankHouse = new Bank();
    	
    	arraySprites.add(bankHouse);
    }
    

    
    public void update(Graphics g)
    {
    	
    	//sprite.update(g);
    	for (Sprite sprite: arraySprites)
    	{
    		sprite.updateImage(g);
    	}
    	
    }
    
    public void specificSprite ( int x, int y)
    {
    	//DECLARE NEW SPRITE
    	//Sprite newSprite;
    	Object newSprite;
    	if (car == 0)
    	{
    		newSprite = new CopCar();
    	}
    	else
    	{
    		newSprite = new RobberCar();
    	}
    	
    	car = ( car + 1 ) % 2;
    	//SET NEW SPRITE
    	
    	((Sprite)newSprite).setX(x);
    	((Sprite)newSprite).setY(y);
    	if (car == 0)
    	{
    		((Sprite)newSprite).setX(300);
    		((Sprite)newSprite).setY(300);
    	}
    	//ADD NEWSPRITE TO ARRAY LIST
    	arraySprites.add((Sprite)newSprite);
    	
    }
    
//    public void fillCarUp() 
//    {
//        for (Sprite sprite : arraySprites) {
//          ((Car)sprite).fillUp();
//        }
//     }
    public void updateScene(int width, int height)
    {
    	Iterator iter = arraySprites.iterator();
    	while(iter.hasNext())
    	{
    		Sprite s = (Sprite) iter.next();
    		
    		
    		
    		
    		
    	}

    	for (Sprite sprite: arraySprites)
    	{
    		
    		sprite.updateState(width,height);
    	}
    	for (int x = 0; x < arraySprites.size(); x++)
    	{
    		if (arraySprites.get(x)  instanceof CopCar)
    		{	
    			for (int z = 0; z < arraySprites.size(); z++)
    			{
    				if (arraySprites.get(z) instanceof RobberCar)
    				{
    					if (arraySprites.get(z).overlaps(arraySprites.get(x)))
    					{
    						((RobberCar)arraySprites.get(z)).captured();

    					}
    				}
    		
    			
    			}
    		}
    	}
    }
}
