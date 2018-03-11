//package homework6;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JOptionPane;


class Sprite 
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;
	private Sprite sprite;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return this.image; }	
	
	public void updateImage(Graphics g) 
	{
        // Move the sprite
		g.drawImage(this.getImage(), this.getX(), getY(), 60, 60, null);
	}
	
	public void updateState(int width, int height)
	{
		
	}
	
	public boolean overlaps(Sprite s)
	{
		if (locationX > s.getX() - 60 && locationX < s.getX() + 60)
		{
			if (locationY > s.getY() - 60 && locationY < s.getY() + 60)
			{
				// Always returns true
				//System.out.println("true");
				JOptionPane.showMessageDialog(null, "Gotcha!");
				return true;
			}
		}
		//System.out.println("False");
		return false;
	}
}